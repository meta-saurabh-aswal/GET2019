package com.metacube.restfulws.model;

public class Advertisement 
{	
	private int id;
	private String title;
	private String desc;
	private int categoryId ;

	
	public Advertisement(int id, String title, String desc, int categoryId)
	{
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.categoryId = categoryId;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public void setDesc(String desc) 
	{
		this.desc = desc;
	}
	
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public String getDesc() 
	{
		return desc;
	}
	
	public int getCategoryId() 
	{
		return categoryId;
	}
	
	

}