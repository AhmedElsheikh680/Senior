/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.bll.manager.impl;

import com.seniorsteps.senior.common.bean.CityBean;
import com.seniorsteps.senior.common.constant.SeniorConstant;
import com.seniorsteps.senior.spring.bll.manager.lookupsmanager;
import com.seniorsteps.senior.spring.bll.transformer.CityTransformer;
import com.seniorsteps.senior.spring.dal.entity.City;
import com.seniorsteps.senior.spring.dal.repo.CityRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SMARTCS
 */
@Service
public class LookupsManagerImpl implements lookupsmanager,SeniorConstant {

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private CityTransformer cityTransformer;

    @Override
    @Transactional
    public CityBean addCity(CityBean cityBean) {
        City cityEntity = cityTransformer.fromBeanToEntity(cityBean);
        cityEntity = cityRepo.add(cityEntity);
        cityTransformer.fromEntityToBean(cityEntity, LANG_AR);
        return cityBean;
    }

    @Override
    @Transactional
    public List<CityBean> findCities() {
        List<City> citiesList = cityRepo.findList();
        List<CityBean> cityBeansList = new ArrayList<>();
        for(City iCity: citiesList){
            CityBean iCityBean = cityTransformer.fromEntityToBean(iCity, LANG_AR);
            cityBeansList.add(iCityBean);
        }
        return cityBeansList;
    }

    @Override
    @Transactional
    public CityBean getCity(Integer id) {
        City foundCity = cityRepo.findById(id);
        CityBean cityBean = cityTransformer.fromEntityToBeanWithAreas(foundCity, LANG_AR);
        return cityBean;
    }

    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    public CityRepo getCityRepo() {
        return cityRepo;
    }

    public void setCityRepo(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public CityTransformer getCityTransformer() {
        return cityTransformer;
    }

    public void setCityTransformer(CityTransformer cityTransformer) {
        this.cityTransformer = cityTransformer;
    }
    //</editor-fold>

}
