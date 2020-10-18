package dbernat.it.springmvc.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends dbernat.it.springmvc.message.Player
{
    private Address address;
}
