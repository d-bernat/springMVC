package dbernat.it.springmvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        log.info("preHandle method called. handler = {}", handler);
        log.info("requested URL = {}", request.getRequestURL());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        log.info("postHandle method called. handler = {}", handler);
        log.info("requested URL = {}", request.getRequestURL());
        log.info("model = {}", modelAndView.getModel());
        log.info("model = {}", modelAndView.getViewName());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        log.info("afterHandle method called. handler = {}", handler);
        log.info("requested URL = {}", request.getRequestURL());
    }


}
