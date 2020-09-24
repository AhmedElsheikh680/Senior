/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SMARTCS
 */
public class SeniorDALMain {
    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("dal-spring-context.xml");
        TestCityRepo testCityRepo = appCon.getBean("testCityRepo",TestCityRepo.class);
        testCityRepo.addCity(appCon);
    }
}
