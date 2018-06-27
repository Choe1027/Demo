package com.choe.mysql;

import com.choe.common.domain.CategoryBean;
import com.choe.common.domain.CityBean;
import com.choe.common.domain.Student;
import com.choe.common.utils.JsonUtil;
import com.choe.mysql.dao.CategoryMapper;
import com.choe.mysql.dao.CityMapper;
import com.choe.mysql.service.StudentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private StudentService studentService;

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void contextLoads() {
    }


    @Test
    public void addStudent(){
        Student student = new Student();
        student.setHeight(100);
        studentService.add(student);
    }


    @Test
    public void getCategoryList(){
        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setIsOther(1);
        List<CategoryBean> categoryList = categoryMapper.getCategoryList(categoryBean);
        categoryList.remove(0);
        for (int i = 0; i <categoryList.size() ; i++) {

        }
    }

    @Test
    public void getCityList(){
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
        provinceList.get(0);
        System.out.println("耗时:"+(System.currentTimeMillis() - startTime));
        System.out.println(JsonUtil.objToJson(provinceList));
    }
}
