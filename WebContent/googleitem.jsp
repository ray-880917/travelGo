<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,google.*,javax.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GoogleSearch</title>
	</head>
	<body>
	
		<style>
			body 
			{
  				background-color: skyblue;
  			
			}
		</style>
		<h1 style="top:10px; position:relative; color: white; font-family:courier; font-size:32px">TravelGo</h1>
  		
  		<img src="https://blog.tripbaa.com/wp-content/uploads/2019/11/%E6%BE%B3%E6%B4%B2%E6%99%AF%E9%BB%9E11.png" width=600px; height=450px; align="right" />
  		
 		<form action='${requestUri}' method='get'>
   
   		<input style="top:35px; left:200px; position:absolute; background-color:white; font-size:20px" type='text' name='keyword'  placeholder = 'enter a place' />
    
   		<input style="top:35px; left:480px; position:absolute; background-color:gray; font-size:20px" type='submit' value='Go' /> 
  
  		</form>
		<%
			//String[][] orderList = (String[][])  request.getAttribute("query");
			
			ArrayList<WebTree> orderList =  (ArrayList<WebTree>) request.getAttribute("query");
			for(WebTree t:orderList)
			{
			%>
				<a href='<%= t.root.webPage.url %>'>
					<%= t.root.webPage.name%>
				</a>
				<br>
					<h style="font-size:15px ;">
						<%= t.root.webPage.url%>
					</h>
				<br>
				<br>
			<%
			}
			
		%>
	</body>
</html>