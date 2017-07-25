package com.metacube.Question3;

import java.lang.reflect.Method;

import com.metacube.Question3.annotations.CanRun;

public class Q3Main {
    public static void main(String[] args) throws Exception {
	System.out.println("Parsing the values...");
	Q3Main objQ3Main = new Q3Main();
	objQ3Main.parse(AnnotationRunner.class);
    }

    public void parse(Class<AnnotationRunner> annotationRunnerClass) throws Exception {

	Method[] methods = annotationRunnerClass.getMethods();
	for (Method method : methods) {

	    if (method.isAnnotationPresent(CanRun.class)) {
		// try to invoke the method with param
		method.invoke(AnnotationRunner.class.newInstance());
	    }
	}
    }
}
