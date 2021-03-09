package com.liziyuan.hope.log.manager.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zqz
 */
@Api(tags = "测试系统服务(不用于自动化测试)")
@RestController
public class TestAliveController {

    @ApiOperation("测试服务是否正常")
    @GetMapping("/test/alive")
    public String testAlive() {
        return "success";
    }
}