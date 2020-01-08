package google;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebNode
{
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;	
	public double nodeScore;
	
	public WebNode(WebPage webPage)
	{
		this.webPage = webPage;
		this.children = new ArrayList<WebNode>();
	}
	
	private String fetchContent(String u) throws Exception
    {
    	String retVal = "";
    	System.out.println(u);
    	String utf8String = new String(u.getBytes(), "UTF-8"); 
		URL url = new URL(utf8String);


		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(hv);		
		URLConnection conn = url.openConnection();
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
	
	public void findChildren() throws Exception
	{		
		if(getDepth()>2)
		{
			return;
		}
		System.out.println("");
		try
		{
			webPage.url = new String(webPage.url.getBytes(), "UTF-8"); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String content = fetchContent(webPage.url);
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		int count=1;
		for(Element li : lis)
		{
			if(li.select("a")!=null)
			{
				String citeUrl = li.select("a").attr("href");
				WebNode child =new WebNode(new WebPage(citeUrl,getDepth()+"-"+count));
				addChild(child);
				child.findChildren();
				count++;
			}
		}
		
	}
	
	public void setNodeScore(ArrayList<Keyword> keywords) throws Exception
	{
		nodeScore=0;
		webPage.setScore(keywords);
		nodeScore+=webPage.score;
		for(WebNode eachChildren : children)
		{
			try
			{
				eachChildren.setNodeScore(keywords);			
				nodeScore+=eachChildren.nodeScore;
			}
			catch (Exception e)
			{
				nodeScore+=0;
				continue;
			}
			
		}
	}
	
	public void addChild(WebNode child)
	{
		children.add(child);
		child.parent = this;
	}
	
	public boolean isTheLastChild()
	{
		if(this.parent == null) return true;
		ArrayList<WebNode> siblings = this.parent.children;
		
		return this.equals(siblings.get(siblings.size() - 1));
	}
	
	public int getDepth()
	{
		int retVal = 1;
		WebNode currNode = this;
		while(currNode.parent!=null)
		{
			retVal ++;
			currNode = currNode.parent;
		}
		return retVal;
	}
	
	HostnameVerifier hv = new HostnameVerifier() {
	    public boolean verify(String urlHostName, SSLSession session) {
	        System.out.println("Warning: URL Host: " + urlHostName + " vs. "
	                + session.getPeerHost());
	        return true;
	    }
	};

	private static void trustAllHttpsCertificates() throws Exception {
	    javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
	    javax.net.ssl.TrustManager tm = new miTM();
	    trustAllCerts[0] = tm;
	    javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
	            .getInstance("SSL");
	    sc.init(null, trustAllCerts, null);
	    javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
	            .getSocketFactory());
	}

	static class miTM implements javax.net.ssl.TrustManager,
	        javax.net.ssl.X509TrustManager {
	    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	        return null;
	    }

	    public boolean isServerTrusted(
	            java.security.cert.X509Certificate[] certs) {
	        return true;
	    }

	    public boolean isClientTrusted(
	            java.security.cert.X509Certificate[] certs) {
	        return true;
	    }

	    public void checkServerTrusted(
	            java.security.cert.X509Certificate[] certs, String authType)
	            throws java.security.cert.CertificateException {
	        return;
	    }

	    public void checkClientTrusted(
	            java.security.cert.X509Certificate[] certs, String authType)
	            throws java.security.cert.CertificateException {
	        return;
	    }
	}
}