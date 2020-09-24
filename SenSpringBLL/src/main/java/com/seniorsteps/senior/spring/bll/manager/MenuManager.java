/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.bll.manager;

import com.seniorsteps.senior.common.bean.ProductBean;
import org.springframework.stereotype.Service;

/**
 *
 * @author SMARTCS
 */

public interface MenuManager {
    
    public ProductBean addProduct(ProductBean productBean);
}
