/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.dal;

import com.seniorsteps.senior.spring.dal.entity.City;
import com.seniorsteps.senior.spring.dal.repo.CityRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SMARTCS
 */
@Component
public class TestCityRepo {
   
    @Transactional
    public void addCity(ApplicationContext appCon){
        try{
            CityRepo cityRepo = appCon.getBean("cityRepoImpl",CityRepo.class);
            City city = new City("Senior 7", "Senior 7");
            City returnedCity = cityRepo.add(city);
            System.out.println(returnedCity.getId());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
