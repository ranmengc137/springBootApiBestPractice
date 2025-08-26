package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.dto.TestDTO;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private TestService testService;

    @PostMapping("/test")
    public Result<Double> test(@RequestBody TestDTO testDTO) {
        Double result = this.testService.service(testDTO);
        return Result.success(result);
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}