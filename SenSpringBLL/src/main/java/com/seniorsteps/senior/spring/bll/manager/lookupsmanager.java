/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.bll.manager;

import com.seniorsteps.senior.common.bean.AreaBean;
import com.seniorsteps.senior.common.bean.CityBean;
import java.util.List;

/**
 *
 * @author SMARTCS
 */
public interface lookupsmanager {
    
    public CityBean addCity(CityBean cityBean);
    
    public List<CityBean> findCities();
    
    public CityBean getCity(Integer id);
    
//    public AreaBean addArea(AreaBean areaBean);
}
