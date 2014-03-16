package com.edw.gamersky.pojo;

public class Image {
	
	public String name;
	public String srcSmall;
	public String srcOrigin;
	
	public Image(String srcSmall, String srcOrigin) {
		this.srcSmall = srcSmall;
		this.srcOrigin = srcOrigin;
	}

	public String toString(){
		return "[" + this.name + " " + this.srcSmall + " " + this.srcOrigin + "]";
	}

}
