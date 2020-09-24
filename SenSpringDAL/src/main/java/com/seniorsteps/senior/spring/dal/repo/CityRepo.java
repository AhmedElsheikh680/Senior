/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.dal.repo;

import com.seniorsteps.senior.spring.dal.entity.City;
import java.util.List;

/**
 *
 * @author SMARTCS
 */
public interface CityRepo extends CommonRepo<City> {
    
    public City updateHQL(City city);
    
    public List<City> findListByHQL();
    
    public List<City> findLikeByHQl(String keyboard);
    
    public List<City> findLike(String keyboard);
    
    public Long countLike(String keyboard);
}
