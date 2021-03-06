package dbernat.it.springmvc.core.services;

import dbernat.it.springmvc.core.qualifiers.GuessCount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
@Getter
public class GameImpl implements Game
{
    @Getter(AccessLevel.NONE)
    @NonNull
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @Override
    @PostConstruct
    public void reset()
    {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
    }

    @PreDestroy
    public void destroy()
    {
        log.info("will be destroy soon ...");
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange)
        {
            if(guess > number)
            {
                biggest = guess - 1;
            }

            if(guess < number)
            {
                smallest = guess + 1;
            }
            -- remainingGuesses;
        }
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange()
    {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
