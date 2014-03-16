package com.edw.gamersky.pojo;

import java.util.List;

public class Page {
	
	public Page(String h1, String info, List<Archor> listArchor, List<Image> listImage) {
		this.title = h1;
		this.info = info;
		this.listArchor = listArchor;
		this.listImage = listImage;
	}
	public String title;
	public String info;
	public List<Archor> listArchor;
	public List<Image> listImage;
	
	public String toString(){
		String str = this.title + " " + this.info + "\n";
		for(Archor a : listArchor){
			str += a.href + " " + a.text + "\n";
		}
		for(Image img : listImage){
			str += img.srcSmall + " " + img.srcOrigin + "\n";
		}
		return str;
	}

}
