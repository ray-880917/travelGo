<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Search</title>
	</head>
	<!--	
		<style>
			body {
	  		background-image: url('search_background.JPG');
	 		background-repeat: no-repeat;
	 		background-attachment: fixed;  
	  		background-size: cover;
		}
		</style>
	<div align="center">
		<input style=" top:350px; position:relative; background-color:white; font-size:20px" type='text' name='keyword'  placeholder = 'enter a place' /></td>
	</div>	
	<div align="center">
		<input style=" top:400px; position:relative; background-color:gray; font-size:20px" type='submit' value='Go' />
	</div>
	<div style=" text-align:center; border:0">
	     <a style=" top:450px; position:relative" href="https://www.booking.com/index.zh-tw.html?aid=376396;label=bdot-gOdtIr17IC7mDJ2ewBK1sAS267725091117:pl:ta:p1:p22,545,000:ac:ap1t1:neg:fi:tikwd-334108349:lp9040379:li:dec:dm;ws=&gclid=Cj0KCQjw6eTtBRDdARIsANZWjYacElkdS82qYPhrQ3gek45fEMhEs7qKsws6BimcSyEDUVUfGotb9ioaAi3MEALw_wcB"><img src="https://content.presspage.com/uploads/685/1920_highresbooking.png?10000" width=80px; height=80px; border="0"></a>
		 <a style=" top:450px; position:relative" href="https://www.airbnb.com"><img src="https://pbs.twimg.com/profile_images/1011661817704165376/leYahCm7.jpg" width=80px; height=80px; border=0></a>
		 <a style=" top:450px; position:relative" href="https://www.agoda.com"><img src="https://cdn6.agoda.net/images/MVC/default/agoda-logo-v2.png" width=96px; height=64px; border=0></a>
		 <a style=" top:450px; position:relative" href="https://www.trivago.com"><img src="https://www.innroad.com/wp-content/uploads/2017/09/Trivago-800x321.png"width=96px; height=64px; border="0"></a>
		 <a style=" top:450px; position:relative" href="https://www.tripadvisor.com"><img src="https://lh3.googleusercontent.com/vbumLlj79-5tl1Ud3he1lgxyqeeTwzrWdZ2WXZyFa2embOfWfL6SmvkKBZEKER2pgg" width=80px; height=80px; border="0"></a>
		 <a style=" top:450px; position:relative" href="https://www.skyscanner.com"><img src="https://store-images.s-microsoft.com/image/apps.6389.14071432515241257.e3d7890a-4ad0-4e78-8f09-42d581fa3edd.9835f4c0-c845-4cb7-937b-afbefd52f0ee?mode=scale&q=90&h=300&w=300" width=80px; height=80px; border="0"></a>
	</div>
	-->
	
	
	<style>
		body 
		{
  			background-image: url('https://media.allure.com/photos/5bf1b1502ab5072a91e1853a/2:1/w_3431,h_1715,c_limit/travel%20editor%20favorite%20products.jpg');
 			background-repeat: no-repeat;
 			background-attachment: fixed;  
  			background-size: cover;
		}
	</style>
	
		<form action='${requestUri}' method='get'>
		<div style="top:100px; right:200px; position:fixed; color:white; border=0; width: 250px; height: 160px;">
			
			<h1 style="top:10px; position:absolute; color: white; font-family:courier; font-size:32px">TravelGo</h1>
		
			<input style="top:70px; position:absolute;background-color:white; font-size:20px" type='text' name='keyword'  placeholder = 'enter a place' />
			
			<input style="bottom:20px; position:absolute;background-color:gray; font-size:20px" type='submit' value='Go' />
		
		 </div>
		 <a style=" left:10px; top:10px; position:fixed"href="https://www.booking.com/index.zh-tw.html?aid=376396;label=bdot-gOdtIr17IC7mDJ2ewBK1sAS267725091117:pl:ta:p1:p22,545,000:ac:ap1t1:neg:fi:tikwd-334108349:lp9040379:li:dec:dm;ws=&gclid=Cj0KCQjw6eTtBRDdARIsANZWjYacElkdS82qYPhrQ3gek45fEMhEs7qKsws6BimcSyEDUVUfGotb9ioaAi3MEALw_wcB">
			 <img src="https://content.presspage.com/uploads/685/1920_highresbooking.png?10000" width=80px; height=80px; border="0">
		 </a>
		 <a style=" left:10px; top:100px; position:fixed" href="https://www.airbnb.com">
			 <img src="https://pbs.twimg.com/profile_images/1011661817704165376/leYahCm7.jpg" width=80px; height=80px; border=0>
		 </a>
		 <a style=" left:10px; top:190px; position:fixed" href="https://www.agoda.com">
			 <img src="https://cdn6.agoda.net/images/MVC/default/agoda-logo-v2.png" width=96px; height=64px; border=0>
		 </a>
		 <a style=" left:10px; top:280px; position:fixed" href="https://www.trivago.com">
			 <img src="https://www.innroad.com/wp-content/uploads/2017/09/Trivago-800x321.png"width=96px; height=64px; border="0">
		 </a>
		 <a style=" left:10px; top:370px; position:fixed" href="https://www.tripadvisor.com">
			 <img src="https://lh3.googleusercontent.com/vbumLlj79-5tl1Ud3he1lgxyqeeTwzrWdZ2WXZyFa2embOfWfL6SmvkKBZEKER2pgg" width=80px; height=80px; border="0">
		 </a>
		 <a style=" left:10px; top:460px; position:fixed" href="https://www.hotels.com">
			 <img src="https://i0.wp.com/www.securityorb.com/wp-content/uploads/2017/06/hotels-com-logo.jpg?zoom=1.25&fit=560%2C420&ssl=1" width=80px; height=80px; border="0">
		 </a>
		 <a style=" left:10px; top:550px; position:fixed" href="https://www.skyscanner.com">
			 <img src="https://store-images.s-microsoft.com/image/apps.6389.14071432515241257.e3d7890a-4ad0-4e78-8f09-42d581fa3edd.9835f4c0-c845-4cb7-937b-afbefd52f0ee?mode=scale&q=90&h=300&w=300" width=80px; height=80px; border="0">
		 </a>
		
	
		</form>
	</body>
</html>