package google;
import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;



public class GoogleQuery 

{

	public String searchKeyword;

	public String url;

	public String content;

	public GoogleQuery(String searchKeyword)
	{
		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com.tw/search?q="+searchKeyword+"&oe=utf8&num=3";
	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";
		if(url.contains(" "))
		{
			url=url.replaceAll(" ", "%20");
			System.out.println(url);
		}
		if(url.contains("+"))
		{
			url=url.replaceAll("+", "%2B");
			System.out.println(url);
		}
//		if(url.contains("?"))
//		{
//			url=url.replaceAll("?", "%3F");
//			System.out.println(url);
//		}
//		if(url.contains("="))
//		{
//			url=url.replaceAll("=", "%3D");
//			System.out.println(url);
//		}
//		if(url.contains("%"))
//		{
//			url=url.replaceAll("%", "%25");
//			System.out.println(url);
//		}
//		if(url.contains("#"))
//		{
//			url=url.replaceAll("#", "%23");
//			System.out.println(url);
//		}
//		if(url.contains("&"))
//		{
//			url=url.replaceAll("&", "%26");
//			System.out.println(url);
//		}
		
		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	public MyHashMap<String, String> query() throws IOException

	{
		
		if(content==null)
		{

			content= fetchContent();
		}

		MyHashMap<String, String> retVal = new MyHashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select(".ZINbbc");
		
		
		for(Element li : lis)
		{
			try 
			{
				if(!li.select(".BNeawe").isEmpty())
				{
					String title = li.select(".BNeawe").get(0).text();	
//					System.out.println(title);
					String citeUrl = li.select("a").attr("href");
//					System.out.println(citeUrl);
					retVal.put(title, citeUrl);
				}
				
//				
//				
//				for(int i = 0 ; i < block.size(); i++)
///				System.out.println(block.get(i).text());
//				
//				System.out.println(block.get(1).text());
//				System.out.println(block.get(2).text());
//				
//				String title = block.get(1).text();
//				String citeUrl = block.get(2).text();
//				
//				System.out.println(title+" "+citeUrl);
//
				

				

			} 
			catch (IndexOutOfBoundsException e) 
			{

				e.printStackTrace();

			}

			

		}

		

		return retVal;

	}

	

	

}