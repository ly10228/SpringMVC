package com.ly.springmvc.ss.beans;

public class Person {
	private String name ="SpringMvc+Springzz";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("My Name is " + name );
	}
	
}
