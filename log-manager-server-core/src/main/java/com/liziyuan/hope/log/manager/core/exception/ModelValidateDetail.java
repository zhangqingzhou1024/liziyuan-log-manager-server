package com.liziyuan.hope.log.manager.core.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelValidateDetail {
    private Map<String, List<ValidateError>> fieldErrors;
    private List<ValidateError> globalErrors;

    public ModelValidateDetail() {
    }

    public ModelValidateDetail(Map<String, List<ValidateError>> fieldErrors, List<ValidateError> globalErrors) {
        this.fieldErrors = fieldErrors;
        this.globalErrors = globalErrors;
    }

    public Map<String, List<ValidateError>> getFieldErrors() {
        return fieldErrors;
    }

    public List<ValidateError> getGlobalErrors() {
        return globalErrors;
    }

    public void setFieldErrors(Map<String, List<ValidateError>> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public void setGlobalErrors(List<ValidateError> globalErrors) {
        this.globalErrors = globalErrors;
    }

    public void addGlobalError(ValidateError error) {
        if (globalErrors == null)
            globalErrors = new ArrayList<>();
        globalErrors.add(error);
    }

    public void addFieldError(String field, ValidateError error) {
        if (fieldErrors == null)
            fieldErrors = new HashMap<>();
        List<ValidateError> fieldErrorList = fieldErrors.get(field);
        if (fieldErrorList == null) {
            fieldErrorList = new ArrayList<>();
            fieldErrors.put(field, fieldErrorList);
        }
        fieldErrorList.add(error);
    }
}
