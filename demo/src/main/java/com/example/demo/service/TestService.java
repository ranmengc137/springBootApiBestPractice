package com.example.demo.service;

import com.example.demo.dto.TestDTO;
import com.example.demo.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public Double service(TestDTO testDTO) {
        if (testDTO.getNum() == null || testDTO.getNum() <= 0) {
            throw new BusinessException("Number must be greater than 0");
        }
        if ("square".equals(testDTO.getType())) {
            return Math.pow(testDTO.getNum(), 2);
        }
        if ("factorial".equals(testDTO.getType())) {
            double result = 1;
            int num = testDTO.getNum();
            while (num > 1) {
                result = result * num;
                num -= 1;
            }
            return result;
        }
        throw new BusinessException("Unrecognized algorithm type");
    }

    public void saveValidatedUser(String userName, String password, String email) {
        // placeholder for saving logic
    }
}