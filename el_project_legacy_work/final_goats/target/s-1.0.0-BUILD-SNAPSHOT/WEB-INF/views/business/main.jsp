<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
    $("#a").click(function() {

	window.open("gtBusinessInsertForm.gos", "popup", "width=1033px,height=800,left=300,top=10,scrollbars=no,toolbars=no,location=no");

    });
    
    $("#aaa").click(function(){
    	
    	var select = $("#select").val();
    	
    	location.href="/final_goats/gtBusinessSelect.gos?gbt_num=" + select
    });
    
    $("#bbb").click(function(){
    	
    	var select = $("#select").val();
    	var gbt_price1 = $("#update").serialize();
    	console.log(gbt_price1);
    	location.href="/final_goats/gtBusinessUpdate.gos?gbt_num=" + select +"&" + gbt_price1;
    });
    
    
    
    
 });
</script>
</head>
<body>
	<input type="button" id="a" value="팝업">
	<hr>
	<a href="gtBusinessInsertForm.gos">인서트폼</a>
	<hr>
	<a href="gtBusinessSelectAll.gos">셀렉트올</a>
	<hr>
	<a href="loginForm.gos"> 로그인 </a>
	<hr>
	<select id="select" name="select">
		<option value="BU202306290001">1</option>
		<option value="BU202306290002">2</option>
		<option value="BU202306290003">3</option>
		<option value="BU202306290004">4</option>
		<option value="BU202306290005">5</option>
		<option value="BU202306290006">6</option>
		<option value="BU202306290007">7</option>
		<option value="BU202306290008">8</option>
		<option value="BU202306290009">9</option>
		<option value="BU202306290010">10</option>
		<option value="BU202306300011">11</option>
		<option value="BU202306300012">12</option>
		<option value="BU202307010013">13</option>
		<option value="BU202307010014">14</option>
		<option value="BU202307300014">실패</option>
	</select>
	<button type="button" id="aaa">셀렉트</button>
	<hr>
	<form id="update">
	<table border="1">
		<tr>
		    <td align="center">1</td>
		    <td align="center">
		    <select name="gbt_price1" id="" class=""> <!-- 구분 -->
			    <option value="01">교통비</option>
			    <option value="02">식비</option>
			    <option value="03">접대비</option>
			    <option value="04">기타</option>
		    </select></td>
		    <td align="center"><input type="text" size="9" name="gbt_price1" id="" class=""></td> <!-- 장소 -->
		    <td align="center"><input type="text" size="9" name="gbt_price1" id="gbt_price1_2" class="aa"></td> <!-- 예상금액 -->
		    <td align="center"><input type="text" size="49" name="gbt_price1" id="" class=""></td> <!-- 내용 -->
		    <td align="center"><input type="text" size="3" name="gbt_price1" id="" class=""></td> <!-- 기타 -->
	    </tr>
	</table>
	</form>
		<button type="button" id="bbb">수정</button>
	
</body>
</html>

