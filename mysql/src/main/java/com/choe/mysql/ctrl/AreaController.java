package com.choe.mysql.ctrl;

import com.choe.common.domain.CityBean;
import com.choe.mysql.dao.CityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cyk
 * @date 2018/6/22/022 19:13
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@RestController
public class AreaController {

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("/getArea")
    public Object test(){

        Long startTime = System.currentTimeMillis();
        CityBean province = new CityBean();
        province.setGrade("1");
        // 获取省级列表
        List<CityBean> provinceList = cityMapper.select(province);
        if (provinceList != null && !provinceList.isEmpty()) {
            for (CityBean provinceBean : provinceList) {
                CityBean city = new CityBean();
                city.setParent_code(provinceBean.getCity_code());
                // 获取市级列表
                List<CityBean> cityList = cityMapper.select(city);
                if (cityList != null && !cityList.isEmpty()) {
                    provinceBean.setCityList(cityList);
                    for (CityBean cityBean : cityList) {
                        CityBean county = new CityBean();
                        county.setParent_code(cityBean.getCity_code());
                        // 获取区县列表
                        List<CityBean> countyList =cityMapper.select(county);
                        if (countyList != null && !countyList.isEmpty()) {
                            cityBean.setCountyList(countyList);
//                            for (CityBean countyBean : countyList) {
//                                CityBean citybean = new CityBean();
//                                citybean.setParent_code(countyBean.getCity_code());
//                                // 获取接到列表
//                                List<CityBean> townList = cityMapper.select(citybean);
//                                if (townList != null && !townList.isEmpty()) {
//                                    countyBean.setChildCitys(townList);
//                                }
//                            }
                        }
                    }
                }
            }
        }

        return provinceList;

    }
}
