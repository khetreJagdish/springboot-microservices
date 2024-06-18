package com.springboot.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties("field1")
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	//@JsonIgnore
	private String field1;
	private String field2;
	private String field3;

	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SomeBean [field1=");
		builder.append(field1);
		builder.append(", field2=");
		builder.append(field2);
		builder.append(", field3=");
		builder.append(field3);
		builder.append("]");
		return builder.toString();
	}

}
