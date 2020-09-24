/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.senior.spring.bll.transformer;

import com.seniorsteps.senior.common.bean.AreaBean;
import com.seniorsteps.senior.common.constant.SeniorConstant;
import com.seniorsteps.senior.spring.dal.entity.Area;
import org.springframework.stereotype.Component;

/**
 *
 * @author SMARTCS
 */
@Component
public class AreaTransformer implements CommonTransformer<Area, AreaBean>, SeniorConstant {

    @Override
    public AreaBean fromEntityToBean(Area entity, String lang) {
        AreaBean areaBean = new AreaBean();
        areaBean.setId(entity.getId());
        areaBean.setNameAr(entity.getNameAr());
        areaBean.setNameEn(entity.getNameEn());
//        if(LANG_AR.equals(lang)){
//            areaBean.setName(entity.getNameAr());
//        } else {
//            areaBean.setName(entity.getNameEn());
//        }

        return areaBean;
    }

    @Override
    public Area fromBeanToEntity(AreaBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
