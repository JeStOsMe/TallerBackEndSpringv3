package com.sofka.tallerbackendv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tallerbackendv3Application {

	public static void main(String[] args) {
		try{
                    SpringApplication.run(Tallerbackendv3Application.class, args);
                } catch (Throwable e){
                    e.printStackTrace();
                }
	}

}
