package dbernat.it.springmvc.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode(of={"id", "firstname", "lastname"})
public class Player implements Serializable
{
    private final String id;
    private final String firstname;
    private final String lastname;
    private final Address address;
}
