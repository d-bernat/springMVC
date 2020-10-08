package dbernat.it.springmvc.core.services;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.MessageFormat;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator
{
    @NonNull
    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game)
    {
        this.game = game;
    }

    @PostConstruct
    public void init()
    {
        log.info("Game is up and running ({})", game);
    }

    @PreDestroy
    public void destroy()
    {
        log.info("Game over, remaining guesses: {}", game.getRemainingGuesses());
    }

    @Override
    public String getMainMessage()
    {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage()
    {
        if(!game.isValidNumberRange())
        {
            return MessageFormat.format("The number {0} is out of the range ({1}:{2})", game.getGuess(), game.getSmallest(), game.getBiggest());
        }

        String finalIntro = "The number was " + game.getNumber() + "! ";
        return   (game.isGameWon() ? finalIntro + "YOU WON :-)": game.isGameLost() ? finalIntro+ "YOU LOST :-)": "Your number!");
    }
}
