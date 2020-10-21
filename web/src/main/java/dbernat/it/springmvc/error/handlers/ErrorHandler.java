package dbernat.it.springmvc.error.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import java.util.HashMap;

@ControllerAdvice
public class ErrorHandler
{
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleError404(Exception e)   {
        ModelAndView mav = new ModelAndView("errors/404");
        mav.addObject("exception", e);
        //mav.addObject("errorcode", "404");
        return mav;
    }
}
