package com.choe.common.domain;

import java.util.List;

/** 废品分类信息表 */
public class CategoryBean  {

	private static final long serialVersionUID = 5916761344466416926L;

	private Long id;
	/** 类型名称 */
	private String type_name;

	/** 短信模板编号 用于价格异动短信通知*/
	private String template_code;

	/** 说明 */
	private String description;
	/** 等级 1-一级分类 2-二级分类 */
	private Integer level;
	/**所属父类*/
	private Long pid;
    /**子级集合*/
	private List<CategoryBean> childrenList;

	/** 备注 */
	private String remarks;

	/** 图片地址 */
	private String url;

	/** 税率 */
	private Double geld;
	/**是否是其他 0不是 1 是*/
	private Integer isOther;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplate_code() {
		return template_code;
	}

	public void setTemplate_code(String template_code) {
		this.template_code = template_code;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getGeld() {
		return geld;
	}

	public void setGeld(Double geld) {
		this.geld = geld;
	}

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<CategoryBean> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<CategoryBean> childrenList) {
        this.childrenList = childrenList;
    }

	public Integer getIsOther() {
		return isOther;
	}

	public void setIsOther(Integer isOther) {
		this.isOther = isOther;
	}
}
