package dbernat.it.springmvc.service;

import dbernat.it.springmvc.entity.Address;
import dbernat.it.springmvc.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService
{
    private final CrudRepository<Player, String> playerRepository;

    @Autowired
    public PlayerServiceImpl(@Qualifier("RedisPlayerRepository") CrudRepository<Player, String> playerRepository)
    {
        this.playerRepository = playerRepository;
    }

    @Override
    public void save(dbernat.it.springmvc.request.Player player)
    {
        playerRepository.save(toEntityPlayer(player));
    }

    @Override
    public void saveAll(Collection<dbernat.it.springmvc.request.Player> players)
    {
        final List<Player> entityPlayers = new ArrayList<>();
        players.forEach( player -> entityPlayers.add(toEntityPlayer(player)) );
        playerRepository.saveAll(entityPlayers);
    }

    @Override
    public Optional<dbernat.it.springmvc.response.Player> findById(int id)
    {
        Optional<Player> optionalPlayer = playerRepository.findById(Integer.toString(id));
        return optionalPlayer.map(this::toResponsePlayer);
    }

    @Override
    public boolean existsById(int id)
    {
        return playerRepository.existsById(Integer.toString(id));
    }

    @Override
    public dbernat.it.springmvc.response.Players findAll()
    {
        return toResponsePlayers(playerRepository.findAll());
    }

    @Override
    public dbernat.it.springmvc.response.Players findAllById(Collection<String> idList)
    {
        return toResponsePlayers(playerRepository.findAllById(idList));
    }

    @Override
    public long count()
    {
        return playerRepository.count();
    }

    @Override
    public void deleteById(int id)
    {
        playerRepository.deleteById(Integer.toString(id));
    }

    @Override
    public void delete(dbernat.it.springmvc.request.Player player)
    {
        playerRepository.delete(toEntityPlayer(player));
    }

    @Override
    public void deleteAll(Collection<dbernat.it.springmvc.request.Player> playerList)
    {
        playerRepository.deleteAll(toEntityPlayerList(playerList));
    }

    @Override
    public void deleteAll()
    {
        playerRepository.deleteAll();
    }

    private Player toEntityPlayer(dbernat.it.springmvc.request.Player player)
    {
        dbernat.it.springmvc.entity.Address address = new Address(player.getAddress().getStreet(),
                player.getAddress().getCity(),
                player.getAddress().getState(),
                player.getAddress().getZipcode());

        return new Player(player.getId(), player.getFirstname(), player.getLastname(), address);
    }

    private dbernat.it.springmvc.response.Player toResponsePlayer(Player player)
    {
        dbernat.it.springmvc.response.Address address = new dbernat.it.springmvc.response.Address();
        address.setCity(player.getAddress().getCity());
        address.setStreet(player.getAddress().getStreet());
        address.setZipcode(player.getAddress().getZipcode());
        address.setState(player.getAddress().getState());

        dbernat.it.springmvc.response.Player responsePlayer = new dbernat.it.springmvc.response.Player();
        responsePlayer.setId(player.getId());
        responsePlayer.setFirstname(player.getFirstname());
        responsePlayer.setLastname(player.getLastname());
        responsePlayer.setAddress(address);

        return responsePlayer;
    }

    private dbernat.it.springmvc.response.Players toResponsePlayers(Iterable<Player> players)
    {
        List<dbernat.it.springmvc.response.Player> responsePlayers = new ArrayList<>();
        players.forEach(player -> responsePlayers.add(toResponsePlayer(player)));
        dbernat.it.springmvc.response.Players ret = new dbernat.it.springmvc.response.Players();
        ret.setPlayers(responsePlayers);

        return ret;
    }

    private Iterable<Player> toEntityPlayerList(Collection<dbernat.it.springmvc.request.Player> players)
    {
        List<Player> entityPlayers = new ArrayList<>();
        players.forEach(player -> entityPlayers.add(toEntityPlayer(player)));

        return entityPlayers;
    }

}
