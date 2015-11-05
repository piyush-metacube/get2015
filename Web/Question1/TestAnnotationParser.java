package com.metacube.Question1;

import java.lang.reflect.Method;

public class TestAnnotationParser {

    public void parse(Class<Employee> tempClass) throws Exception {

	Method[] methods = tempClass.getMethods();

	for (Method method : methods) {
	    if (method.isAnnotationPresent(RequestForEnhancement.class)) {
		RequestForEnhancement test = method.getAnnotation(RequestForEnhancement.class);

		System.out.println("annotation is present!");
		// try to invoke the method with param
		method.invoke(Employee.class.newInstance(), test.id(), test.synopsis(), test.engineer(), test.date());
	    }
	}
    }
}
