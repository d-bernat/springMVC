package dbernat.it.springmvc.util;

public final class GameMappings
{
    public static final String PLAY = "play";
    public static final String RESTART = "restart";
    public static final String REDIRECT_PLAY = "redirect:/" + PLAY;

    private GameMappings()
    {
    }
}
