package com.wayne.aop;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wayne
 * @date 2018/3/8
 * <p>
 * desc:统一处理日志记录
 */
@Aspect
@Component
public class HttpAspect {

    private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义切点Pointcut
     */
    @Pointcut("execution(* com.wayne.controller..*.*(..))")
    public void logHttp() {
    }

    @Around("logHttp()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        Gson gson = new Gson();
        logger.info("请求结束，controller的返回值是 " + gson.toJson(result));
        return result;
    }

}
