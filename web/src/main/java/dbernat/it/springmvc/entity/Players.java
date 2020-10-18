package dbernat.it.springmvc.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Players
{
    private final List<Player> players;
}
