package com.edw.gamersky.pojo;

public class Gallery {
	
	public String title;
	public String thumb;
	public String url;
	
	public Gallery(String alt, String src, String href) {
		this.title = alt;
		this.thumb = src;
		this.url = href;
	}

	public String toString(){
		return "[" + this.title + " " + this.thumb + " " + this.url + "]";
	}

}
