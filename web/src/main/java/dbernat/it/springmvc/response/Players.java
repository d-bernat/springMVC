package dbernat.it.springmvc.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class Players
{
    private Collection<Player> players;
}
