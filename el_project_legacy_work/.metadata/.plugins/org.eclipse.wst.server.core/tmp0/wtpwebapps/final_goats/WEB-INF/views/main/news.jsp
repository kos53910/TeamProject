<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mongodb.BasicDBObject" %>
<%@ page import="com.mongodb.DB" %>
<%@ page import="com.mongodb.DBCollection" %>
<%@ page import="com.mongodb.DBCursor" %>
<%@ page import="com.mongodb.DBObject" %>
<%@ page import="com.mongodb.MongoClient" %>
<%@ page import="com.mongodb.ServerAddress" %>
<%@ page import="org.bson.*" %>

   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
		
 		$(document).ready(function(){
 			
 			newnews();
 			
 		function newnews(){
 			$.ajax({
 				url : "gtQuartzNewsMongoDB.gos",
 				type : "GET",
 				dataType:"json",
 				success : news,
 			});

 			function news(res){
 							//alert(res);
					
  							var a = "<a href='" + res["link0"] + "' target='_blank'>" + res["title0"] + "</a><br>";
  							var b = "<a href='" + res["link1"] + "' target='_blank'>" + res["title1"] + "</a><br>";
 							var c = "<a href='" + res["link2"] + "' target='_blank'>" + res["title2"] + "</a><br>";
  							var d = "<a href='" + res["link3"] + "' target='_blank'>" + res["title3"] + "</a><br>";
 							var e = "<a href='" + res["link4"] + "' target='_blank'>" + res["title4"] + "</a><br>";
							var f = "<a href='" + res["link5"] + "' target='_blank'>" + res["title5"] + "</a><br>";
 							var g = "<a href='" + res["link6"] + "' target='_blank'>" + res["title6"] + "</a><br>";
  							var h = "<a href='" + res["link7"] + "' target='_blank'>" + res["title7"] + "</a><br>";
  							var i = "<a href='" + res["link8"] + "' target='_blank'>" + res["title8"] + "</a><br>";
  							var j = "<a href='" + res["link9"] + "' target='_blank'>" + res["title9"] + "</a>";
 							
  							var newslsit = a + b + c + d + e + f + g + h + i + j
  							$("#wrap").empty();
  							$("#wrap").append(newslsit)

 					};
 					
 					    
 			}
   		 			setInterval(() => newnews(), 60000);
 		});

</script>
<style type="text/css">
#wrap {
margin: 13px 20px 10px 20px;
font-size: 15px;
}
h2 {
margin: 0;
padding: 18px 0px 0px 20px;
text-align: left;
color: lightslategrey;

}
.newbox {
    margin: 10px 13px;
}
.newcontainer {
border: 1px solid;
border-color: darkcyan;
border-radius: 0.4rem;
}
.newcontainer img {
    width: 35px;
    height: 35px;
    position: absolute;
}
.a {
    padding: 0px 45px;
    font-size: 21px;
}
</style> 
</head>

<body>
	<div class="newbox">
		<div class="newcontainer">
			<h2><img src="resources/goats_icon/news.png" > <div class="a">실시간 NEWS</div></h2>
			<div id="wrap"></div>
		</div>
	</div>
</body>
</html>