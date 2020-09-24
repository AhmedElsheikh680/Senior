/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.bll;

import com.seniorsteps.senior.common.bean.CityBean;
import com.seniorsteps.senior.spring.bll.manager.MenuManager;
import com.seniorsteps.senior.spring.bll.manager.lookupsmanager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SMARTCS
 */
@Service
public class SeniorBLGateway{
    
    @Autowired
    private lookupsmanager lookupsManager;
    
    @Autowired
    private MenuManager menuManger;

    public CityBean addCity(CityBean cityBean) {
        return lookupsManager.addCity(cityBean);
    }

    public List<CityBean> findCities() {
        return lookupsManager.findCities();
    }

    public CityBean getCity(Integer id) {
        return lookupsManager.getCity(id);
    }

   
    
    //<editor-fold defaultstate="collapsed" desc="SETTERS & GETTERS">
    public void setLookupsManager(lookupsmanager lookupsManager) {
        this.lookupsManager = lookupsManager;
    }

    public MenuManager getMenuManger() {
        return menuManger;
    }

    public void setMenuManger(MenuManager menuManger) {
        this.menuManger = menuManger;
    }
    //</editor-fold>
    
    
}
