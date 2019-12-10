package com.example.demo.customexception;

public class RecordNotFoundException extends RuntimeException {

	private String resourseName;

	private String fieldName;

	private Object fieldValue;

	public RecordNotFoundException(String resourseName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : %s", resourseName, fieldName, fieldValue));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourseName() {
		return resourseName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
}
