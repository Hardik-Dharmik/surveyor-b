package com.app.surveyor.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Map;

@Data
public class FormRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;

    private Map<String, Object> formBody;
}
