package dbernat.it.springmvc.core.services;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.MessageFormat;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator
{
    private static final String MAIN_MESSAGE = "game.main.message";

    @NonNull
    private final Game game;

    @NonNull
    private final MessageSource messageSource;

    @Autowired
    public MessageGeneratorImpl(@NonNull Game game, @NonNull MessageSource messageSource)
    {
        this.game = game;
        this.messageSource = messageSource;
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
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
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

    private String getMessage(String code, Object... args)
    {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
