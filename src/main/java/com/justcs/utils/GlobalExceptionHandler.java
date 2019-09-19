package com.justcs.utils;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


/**
 * Controller增强器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 捕捉shiro异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public JSONResult handle401(ShiroException e){
        return JSONResult.errorTokenMsg("对不起，系统拒绝您的访问");
    }

    /**
     * 处理未授权异常
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public JSONResult handle401(){
        return JSONResult.errorTokenMsg("对不起您未授权访问");
    }


    /**
     * 全局异常处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception ex) {
        Object errorObject = JSONResult.errorMsg("对不起，您的访问可能有点问题!");
        // 处理绑定异常
        if (ex instanceof MethodArgumentNotValidException) {
            List<ArgumentInvalidResult> invalidResultList = new ArrayList<>();
            for (FieldError error : ((MethodArgumentNotValidException) ex).getBindingResult()
                    .getFieldErrors()) {
                ArgumentInvalidResult invalidResult = new ArgumentInvalidResult();
                invalidResult.setDefaultMessage(error.getDefaultMessage());
                invalidResult.setField(error.getField());
                invalidResult.setRejectedValue(error.getRejectedValue());
                invalidResultList.add(invalidResult);
            }
            errorObject = JSONResult.errorMsgData("字段验证不通过", invalidResultList);
        }
        //ex.printStackTrace();
        logger.error(ex.toString());
        return errorObject;
    }
}
