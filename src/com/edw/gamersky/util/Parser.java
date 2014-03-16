package com.edw.gamersky.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.edw.gamersky.pojo.Archor;
import com.edw.gamersky.pojo.Gallery;
import com.edw.gamersky.pojo.Image;
import com.edw.gamersky.pojo.Page;

public class Parser {
	
	public static List<Gallery> listGallery(String url){
		List<Gallery> list = new ArrayList<Gallery>();
		
		try {
			Document doc = Jsoup.connect(url)
					  .userAgent("Mozilla")
					  .timeout(10000)
					  .get();
			
			Elements as = doc.select("td>a");
			for(Element a : as){
				
				Elements img = a.select("img");
			
				String alt = img.attr("alt");
				String src = img.attr("src");
				String href = a.attr("href");
				
				if( ! StringUtils.isBlank(alt)){
					System.out.println(alt + " " + src + " " + href);
					list.add(new Gallery(alt, src, href));
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
	public static List<Image> listImage(String url){
		List<Image> list = new ArrayList<Image>();
		
		try {
			Document doc = Jsoup.connect(url)
					  .userAgent("Mozilla")
					  .timeout(10000)
					  .get();
			
			String h1 = doc.select("h1>b").html();
			String info = doc.select("div.tit3").html();
			
			System.out.println(h1);
			System.out.println(info);

			Elements as = doc.select("#gspaging>p>a");
			for(Element a : as){
				Elements img = a.select("img");
			
				String srcSmall = img.attr("src");
				String href = a.attr("href");
				String srcOrigin = href.split("\\?")[1];
				
				System.out.println(srcSmall + " " + srcOrigin + " " + href);
				list.add(new Image(srcSmall, srcOrigin));
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Archor> listArchor(String url){
		List<Archor> listArchor = new ArrayList<Archor>();
		try {
			Document doc = Jsoup.connect(url)
					  .userAgent("Mozilla")
					  .timeout(10000)
					  .get();
			
			Elements pageElements = doc.select(".pagecss a");
			for(Element ele : pageElements){
				listArchor.add(new Archor(ele.attr("href"), ele.html()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listArchor;
	}
	
	public static Page page(String url){
		String h1 = null;
		String info = null;
		List<Image> listImage = new ArrayList<Image>();
		List<Archor> listArchor = new ArrayList<Archor>();
		
		try {
			Document doc = Jsoup.connect(url)
					  .userAgent("Mozilla")
					  .timeout(10000)
					  .get();
			
			h1 = doc.select("h1>b").html();
			info = doc.select("div.tit3").html();
			
			System.out.println(h1);
			System.out.println(info);
			
			Elements pageElements = doc.select(".page_css a");
			for(Element ele : pageElements){
				String href = ele.attr("href");
				String text = ele.html();
				listArchor.add(new Archor(href,text));
			}
			

			Elements as = doc.select("#gspaging>p>a");
			for(Element a : as){
				Elements img = a.select("img");
			
				String srcSmall = img.attr("src");
				String href = a.attr("href");
				String srcOrigin = href.split("\\?")[1];
				
				System.out.println(srcSmall + " " + srcOrigin + " " + href);
				listImage.add(new Image(srcSmall, srcOrigin));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Page page = new Page(h1, info, listArchor, listImage);
		return page;
	}

}
