package com.atdev.springcrudatdev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldNAme;
	private Object fieldvalue;
	public ResourceNotFoundException(String resourceName, String fieldNAme, Object fieldvalue) {
		super();
		this.resourceName = resourceName;
		this.fieldNAme = fieldNAme;
		this.fieldvalue = fieldvalue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldNAme() {
		return fieldNAme;
	}
	public void setFieldNAme(String fieldNAme) {
		this.fieldNAme = fieldNAme;
	}
	public Object getFieldvalue() {
		return fieldvalue;
	}
	public void setFieldvalue(Object fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	
}
