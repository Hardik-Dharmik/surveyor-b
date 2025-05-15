package com.app.surveyor.controllers;

import com.app.surveyor.dtos.FormRequest;
import com.app.surveyor.models.Form;
import com.app.surveyor.payloads.ApiResponse;
import com.app.surveyor.services.FormService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/forms")
@RequiredArgsConstructor
public class FormController {
    private final FormService formService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Form>>> getAllForms() {
        ApiResponse<List<Form>> apiResponse = new ApiResponse<>(200, "Form fetched successfully", formService.getAllForms(), null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{formId}")
    public ResponseEntity<ApiResponse<Form>> getFormById(@PathVariable("formId") String formId) {
        Form form = formService.getFormById(formId);
        ApiResponse<Form> apiResponse = new ApiResponse<>(200, "Form fetched successfully", form, null);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Form>> createForm(@Valid @RequestBody FormRequest form) {
        Form formSaved = formService.saveForm(form);
        ApiResponse<Form> apiResponse = new ApiResponse<>(200, "Form added successfully", formSaved, null);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{formId}")
    public ResponseEntity<ApiResponse<Form>> updateForm(@PathVariable("formId") String formId, @Valid @RequestBody FormRequest form) {
        Form formSaved = formService.updateForm(formId, form);
        ApiResponse<Form> apiResponse = new ApiResponse<>(200, "Form updated successfully", formSaved, null);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{formId}")
    public ResponseEntity<ApiResponse<Void>> deleteForm(@PathVariable("formId") String formId) {
        formService.deleteForm(formId);
        ApiResponse<Void> apiResponse = new ApiResponse<>(200, "Form deleted successfully", null, null);
        return ResponseEntity.ok(apiResponse);
    }
}
