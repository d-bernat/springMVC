package dbernat.it.springmvc.service;



import java.util.Collection;
import java.util.Optional;

public interface PlayerService
{
    void save(dbernat.it.springmvc.request.Player player);
    void saveAll(Collection<dbernat.it.springmvc.request.Player> players);
    Optional<dbernat.it.springmvc.response.Player> findById(int id);
    boolean existsById(int id);
    dbernat.it.springmvc.response.Players findAll();
    dbernat.it.springmvc.response.Players findAllById(Collection<String> idList);
    long count();
    void deleteById(int id);
    void delete(dbernat.it.springmvc.request.Player player);
    void deleteAll(Collection<dbernat.it.springmvc.request.Player> playerList);
    void deleteAll();
}
