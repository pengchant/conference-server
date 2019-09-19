package com.justcs.controller;

import com.justcs.utils.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 这里用于返回通用的结果
 */
@ApiIgnore
@RequestMapping("/just")
@RestController
public class BaseController {

    @RequestMapping("/unauth")
    public JSONResult unauth(){
        return JSONResult.errorMsg("对不起，您的访问非法!");
    }

}
