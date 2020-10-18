package dbernat.it.springmvc.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Address implements Serializable
{
    private final String street;
    private final String city;
    private final String state;
    private final String zipcode;
}
