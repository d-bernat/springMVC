package dbernat.it.springmvc.controller;

import dbernat.it.springmvc.request.Player;
import dbernat.it.springmvc.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController
{
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService)
    {
        this.playerService = playerService;
    }

    @GetMapping("all")
    public dbernat.it.springmvc.response.Players getAllPlayers()
    {
        return playerService.findAll();
    }

    @PostMapping("add")
    public dbernat.it.springmvc.response.Players addPlayer(@RequestBody Player player)
    {

        playerService.save(player);

        return playerService.findAll();
    }

    @DeleteMapping("truncate")
    public dbernat.it.springmvc.response.Players deleteAll()
    {
        playerService.deleteAll();
        return playerService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public dbernat.it.springmvc.response.Players deleteById(@PathVariable int id)
    {
        playerService.deleteById(id);
        return playerService.findAll();
    }
}
