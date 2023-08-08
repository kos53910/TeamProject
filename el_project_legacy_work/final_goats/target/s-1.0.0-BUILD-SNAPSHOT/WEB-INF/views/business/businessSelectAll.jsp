<%@page import="com.gt.s.kos.business.vo.GtBusinessVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Object obj = request.getAttribute("aList");
	List<GtBusinessVO> aList = (List<GtBusinessVO>) obj;
	
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>	
		<div>
			<button type="button">엑셀</button>
			<select>
				<option>항목설정</option>
				<option>구분</option>
				<option>참여인원</option>
				<option>내용</option>
				<option>시작일시</option>
				<option>종료일시</option>
				<option>장소</option>
			</select>
		</div>
		<div>
			<span>검색</span>
			<span><input type="text"></span>
		</div>
		<table border="1">
			<tr>
				<td>구분</td>
				<td>참여인원</td>
				<td>내용</td>
				<td>시작일시</td>
				<td>종료일시</td>			
				<td>장소</td>			
			</tr>
		<% for (int i = 0; i < aList.size(); i++){
			
		%>
			<tr>
				<td>
					<%=aList.get(i).getGbtnum()%>
				</td>
				<td><%=aList.get(i).getGbtname()%></td>
				<td><%=aList.get(i).getGbtprice1()%></td>
				<td><%=aList.get(i).getGbtprice2()%></td>
				<td><%=aList.get(i).getGbtprice3()%></td>
				<td><%=aList.get(i).getGbtprice4()%></td>
				<td><%=aList.get(i).getGbtprice5()%></td>
				<td><%=aList.get(i).getGbttotalprice()%></td>
				<td><%=aList.get(i).getGbtstart()%></td>
				<td><%=aList.get(i).getGbtend() %></td>
			</tr>
			<%} %>
		</table>
	</form>
</body>
</html>