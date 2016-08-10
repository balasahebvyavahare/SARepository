package org.spring;

public class Triangle {
	
	public String type;
	public String height;
	
	public Triangle(String str)
	{
		this.type = str;
	}
	
	public Triangle(String str , String height)
	{
		this.type = str;
		this.height = height;
	}
	
	
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void draw()
	{
		System.out.println(getType() + getHeight() + " triangle drawn");
	}

}
