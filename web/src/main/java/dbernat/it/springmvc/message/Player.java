package dbernat.it.springmvc.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player
{
    private String id;
    private String firstname;
    private String lastname;

    protected Player(){}
}
