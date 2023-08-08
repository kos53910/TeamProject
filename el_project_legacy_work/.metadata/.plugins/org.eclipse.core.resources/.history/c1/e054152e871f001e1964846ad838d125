<%@page import="com.gt.s.kos.business.vo.GtBusinessVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
	Object obj = request.getAttribute("list");
	List<GtBusinessVO> list = (List<GtBusinessVO>) obj;
	
	
%>
</head>
<body>
<form>
	<table border="1">
			<tr>
				<td>
					<%=list.get(0).getGbtnum()%>
				</td>
				<td><%=list.get(0).getGbtname()%></td>
				<td><%=list.get(0).getGbtprice1()%></td>
				<td><%=list.get(0).getGbtprice2()%></td>
				<td><%=list.get(0).getGbtprice3()%></td>
				<td><%=list.get(0).getGbtprice4()%></td>
				<td><%=list.get(0).getGbtprice5()%></td>
				<td><%=list.get(0).getGbttotalprice()%></td>
				<td><%=list.get(0).getGbtstart()%></td>
				<td><%=list.get(0).getGbtend() %></td>
			</tr>
	
	</table>

</form>

</body>
</html>