package google;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet(name="TestProject",urlPatterns= {"/TestProject"})
public class TestProject extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null)
		{
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			
			return;
			
		}
		
//		System.out.println(request.getParameter("keyword"));
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		MyHashMap<String, String> query = google.query();
		String[][] s = new String[query.size()][2];
		
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) 
		{
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(value.startsWith("/url?q="))
		    {
		    	value=value.substring(7);
		    }
		    if(value.startsWith(" /url?q="))
		    {
		    	value=value.substring(8);
		    }	
		    if(value.startsWith("/search")||value.startsWith("http://www.google.com/search"))
		    {
		    	continue;
		    }
		    if(value.contains("javascript"))
				continue;
		    if(value.contains("wikipedia"))
				continue;
		    if(!value.contains("http"))
				continue;
			if(value.contains("&sa=U")&&!value.startsWith("/search?"))
				value=value.substring(0,value.lastIndexOf("&sa=U"));
			if(value.contains(".php")&&!value.startsWith("/search?"))
				value=value.substring(0,value.lastIndexOf(".php")+4);
		    
		    
		    s[num][0] = key;
//		    System.out.println(key);
		    s[num][1] = value;
//		    System.out.println(value);
//		    System.out.println("-----------------");
		    num++;
		}
		
		originalResult r=new originalResult(s,google.searchKeyword);
		
//		for(Keyword k: r.lst)
//		{
//			System.out.println(k.name);
//		}
//		request.setAttribute("query", s);
		request.setAttribute("query", r.resultTrees);
		request.getRequestDispatcher("googleitem.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}