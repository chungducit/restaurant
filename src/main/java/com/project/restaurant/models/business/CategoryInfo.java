package com.project.restaurant.models.business;

import java.util.List;

public class CategoryInfo {
	private long id;
	
	private String name;
	
	private String code;
	
	private Long parentId;
	
	private List<ItemInfo> itemList;
	
	private List<CategoryInfo> cateList;
	
	public CategoryInfo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CategoryInfo(long id, String name, String code, Long parentId, List<ItemInfo> itemList,
			List<CategoryInfo> cateList) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.parentId = parentId;
		this.itemList = itemList;
		this.cateList = cateList;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}



	public List<CategoryInfo> getCateList() {
		return cateList;
	}



	public void setCateList(List<CategoryInfo> cateList) {
		this.cateList = cateList;
	}



	public List<ItemInfo> getItemList() {
		return itemList;
	}



	public void setItemList(List<ItemInfo> itemList) {
		this.itemList = itemList;
	}


	
}
