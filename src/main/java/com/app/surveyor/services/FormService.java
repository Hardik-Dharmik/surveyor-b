package com.app.surveyor.services;

import com.app.surveyor.dtos.FormRequest;
import com.app.surveyor.models.Form;
import com.app.surveyor.repositories.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;

    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    public Form getFormById(String formId) {
        return formRepository.findById(formId).orElse(null);
    }

    public Form saveForm(FormRequest formRequest) {
        Form newForm = new Form();
        newForm.setName(formRequest.getName());
        newForm.setTitle(formRequest.getTitle());
        newForm.setDescription(formRequest.getDescription());
        newForm.setFormBody(formRequest.getFormBody());
        return formRepository.save(newForm);
    }

    public Form updateForm(String formId, FormRequest formRequest) {
        Form formToBeUpdated = formRepository.findById(formId).orElseThrow(() -> new RuntimeException("Form not found"));
        formToBeUpdated.setName(formRequest.getName());
        formToBeUpdated.setTitle(formRequest.getTitle());
        formToBeUpdated.setDescription(formRequest.getDescription());
        formToBeUpdated.setFormBody(formRequest.getFormBody());
        return formRepository.save(formToBeUpdated);
    }

    public void deleteForm(String formId) {
        formRepository.deleteById(formId);
    }
}
