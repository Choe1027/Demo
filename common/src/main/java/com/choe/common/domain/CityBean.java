package com.choe.common.domain;

import java.util.List;

/**
 * 城市代号
 * @author Administrator
 *
 */

public class CityBean {

	/**
	 * @Fields CityBean.java : TODOfdsfsd
	 */
	private static final long serialVersionUID = 1L;
	//城市代号
	private String city_code;
	//城市中文名称
	private String city_name;
	//城市父代号
	private String parent_code;
	//说明，0：省，1：市，2：县/区，3：镇/街道
	private String grade;
	
	private List<CityBean> countyList;

	private List<CityBean> cityList;
	
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}


	public List<CityBean> getCountyList() {
		return countyList;
	}

	public void setCountyList(List<CityBean> countyList) {
		this.countyList = countyList;
	}

	public List<CityBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityBean> cityList) {
		this.cityList = cityList;
	}
}
