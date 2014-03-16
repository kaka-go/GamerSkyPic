package com.edw.gamersky.test;

import java.util.List;

import com.edw.gamersky.pojo.Archor;
import com.edw.gamersky.pojo.Gallery;
import com.edw.gamersky.pojo.Image;
import com.edw.gamersky.pojo.Page;
import com.edw.gamersky.util.Config;
import com.edw.gamersky.util.Parser;

public class ParserTest {

	public static void testGallery() {
		List<Gallery> listGallery = Parser.listGallery(Config.PIC_URL);

		for (Gallery gallery : listGallery) {
			System.out.println(gallery);
		}
	}

	public static void testImage() {
		List<Image> listImage = Parser.listImage(Config.TEST_URL);
		for (Image image : listImage) {
			System.out.println(image);
		}
	}
	
	public static void testPage(){
		Page page = Parser.page(Config.TEST_URL);
		System.out.println(page);
	}
	
	public static void testArchor(){
		List<Archor> listArchor = Parser.listArchor(Config.PIC_URL);
		for(Archor archor : listArchor){
			System.out.println(archor);
		}
	}
	
	public static void main(String[] args) {
//		testGallery();
		testArchor();
//		testPage();

	}

}
