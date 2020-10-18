package dbernat.it.springmvc.repository;

import dbernat.it.springmvc.entity.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository("RedisPlayerRepository")
public class RedisPlayerRepository implements CrudRepository<Player, String>
{
    private final static String PLAYER_HASH = "player";
    private final HashOperations<String, String, Player> hashOperations;

    @Autowired
    public RedisPlayerRepository(RedisTemplate<String, Player> playerRedisTemplate)
    {
        this.hashOperations = playerRedisTemplate.opsForHash();
    }

    @Override
    public <S extends Player> S save(S s)
    {
        hashOperations.put(PLAYER_HASH, s.getId(), s);
        return s;
    }

    @Override
    public <S extends Player> Iterable<S> saveAll(Iterable<S> players)
    {
        final Map<String, Player> entries = new HashMap<>();
        players.forEach(player -> entries.putIfAbsent(player.getId(), player));
        hashOperations.putAll(PLAYER_HASH, entries);

        return players;
    }

    @Override
    public Optional<Player> findById(String id)
    {
        Player player = hashOperations.get(PLAYER_HASH, id);
        return player != null ? Optional.of(player) : Optional.empty();
    }

    @Override
    public boolean existsById(String id)
    {
        return hashOperations.hasKey(PLAYER_HASH, id);
    }

    @Override
    public Iterable<Player> findAll()
    {
        return hashOperations.multiGet(PLAYER_HASH, hashOperations.keys(PLAYER_HASH));
    }

    @Override
    public Iterable<Player> findAllById(Iterable<String> idList)
    {
        final List<String> ids = new ArrayList<>();
        idList.iterator().forEachRemaining(ids::add);

        return hashOperations.multiGet(PLAYER_HASH, ids);
    }

    @Override
    public long count()
    {
        return hashOperations.size(PLAYER_HASH);
    }

    @Override
    public void deleteById(String id)
    {
        hashOperations.delete(PLAYER_HASH, id);
    }

    @Override
    public void delete(Player player)
    {
        hashOperations.delete(PLAYER_HASH, player.getId());
    }

    @Override
    public void deleteAll(Iterable<? extends Player> players)
    {
        List<String> ids = new ArrayList<>();
        players.forEach(player -> ids.add(player.getId()));
        hashOperations.delete(PLAYER_HASH, ids);
    }

    @Override
    public void deleteAll()
    {
        Set<String> keys = hashOperations.keys(PLAYER_HASH);
        if (keys.size() > 0)
        {
            hashOperations.delete(PLAYER_HASH, keys.toArray());
        }
        else
        {
            log.warn("No players in store, deleteAll operation was ignored...");
        }
    }
}
