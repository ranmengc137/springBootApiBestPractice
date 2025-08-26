package com.example.demo.controller;

import com.example.demo.dto.ValidationTestDTO;
import com.example.demo.service.TestService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pretty")
@Validated
public class PrettyTestController {

    private TestService testService;

    @GetMapping("/{num}")
    public Integer detail(@PathVariable("num") @Min(1) @Max(20) Integer num) {
        return num * num;
    }

    @GetMapping("/getByEmail")
    public ValidationTestDTO getByAccount(@RequestParam @NotBlank @Email String email) {
        ValidationTestDTO dto = new ValidationTestDTO();
        dto.setEmail(email);
        dto.setUserName("placeholder");
        dto.setPassword("123456");
        return dto;
    }

    @PostMapping("/test-validation")
    public void testValidation(@RequestBody @Validated ValidationTestDTO testDTO) {
        this.testService.saveValidatedUser(testDTO.getUserName(), testDTO.getPassword(), testDTO.getEmail());
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}