package com.hydronovo.util.swing.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldUI {

	String name();

	String description() default "";
	
	String getMethod() default "";
	
	String setMethod() default "";

}
