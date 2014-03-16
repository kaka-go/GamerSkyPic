package com.edw.gamersky.pojo;

public class Archor {
	
	public Archor(String href, String html) {
		this.href = href;
		this.text = html;
	}
	public String href;
	public String text;

	public String toString(){
		return "<" + this.href + " " + this.text + ">";
	}
}
