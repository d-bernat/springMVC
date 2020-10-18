package dbernat.it.springmvc.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address
{
    private String street;
    private String city;
    private String state;
    private String zipcode;

    protected Address(){}
}
