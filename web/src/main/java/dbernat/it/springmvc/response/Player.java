package dbernat.it.springmvc.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends dbernat.it.springmvc.message.Player
{
    private Address address;
}
