<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("formdata_get_servlet.jsp >>> : ");
%>
<h3>formdata_get_servlet</h3>
<hr>
<h3>스프링 콘트롤러에서 request 객체로 받아오기</h3> 
<hr>
<%
	String datanum = request.getParameter("datanum");
	String dataid = request.getParameter("dataid");
	String datapw = request.getParameter("datapw");
	String dataname = request.getParameter("dataname");
	logger.info("formdata_get_servlet.jsp :::: datanum >>> : " + datanum);
	logger.info("formdata_get_servlet.jsp :::: dataid >>> : " + dataid);
	logger.info("formdata_get_servlet.jsp :::: datapw >>> : " + datapw);
	logger.info("formdata_get_servlet.jsp :::: dataname >>> : " + dataname);	
	out.println("formdata_get_servlet.jsp :::: datanum >>> : " + datanum + "<br>");
	out.println("formdata_get_servlet.jsp :::: dataid >>> : " + dataid + "<br>");
	out.println("formdata_get_servlet.jsp :::: datapw >>> : " + datapw + "<br>");
	out.println("formdata_get_servlet.jsp :::: dataname >>> : " + dataname + "<br><hr>");
	
	String req_datanum = (String)request.getAttribute("request_datanum");
	String req_dataid = (String)request.getAttribute("request_dataid");
	String req_datapw = (String)request.getAttribute("request_datapw");
	String req_dataname = (String)request.getAttribute("request_dataname");
	logger.info("formdata_get_servlet.jsp :::: req_datanum >>> : " + req_datanum);
	logger.info("formdata_get_servlet.jsp :::: req_dataid >>> : " + req_dataid);
	logger.info("formdata_get_servlet.jsp :::: req_datapw >>> : " + req_datapw);
	logger.info("formdata_get_servlet.jsp :::: req_dataname >>> : " + req_dataname);	
	out.println("formdata_get_servlet.jsp :::: req_datanum >>> : " + req_datanum + "<br>");
	out.println("formdata_get_servlet.jsp :::: req_dataid >>> : " + req_dataid + "<br>");
	out.println("formdata_get_servlet.jsp :::: req_datapw >>> : " + req_datapw + "<br>");
	out.println("formdata_get_servlet.jsp :::: req_dataname >>> : " + req_dataname + "<br>");
%>
<p>
<h3>스프링 콘트롤러에서 el 객체로 받아오기</h3> 
<hr>
${el_datanum }<br>
${el_dataid }<br>
${el_datapw }<br>
${el_dataname}<br>
<h3>스프링 콘트롤러에서 request.setAttribute() 객체로 받아오기</h3> 
<hr>
${request_datanum }<br>
${request_dataid }<br>
${request_datapw }<br>
${request_dataname }<br>
</body>
</html>