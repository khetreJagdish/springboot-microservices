package com.springboot.webservices.restful_web_services.versioning;

public class PersonV1 {
	
	private String name;
	
	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonV1 [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
}
