<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gt.s.kos.schedule.vo.GtScheduleVO"%>
<%@ page import="org.apache.log4j.LogManager"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.gt.s.kos.employee.vo.GtEmployeeVO"%>

<%
	Logger log = LogManager.getLogger(this.getClass());
	List<GtEmployeeVO> list = (List<GtEmployeeVO>)request.getAttribute("list");
	GtEmployeeVO evo = list.get(0);
	log.info("mainpage.jsp");
%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
    
    $(document).ready(function(){
    	var gender = '<%=evo.getGegender()%>';
    	var apryn = '<%=evo.getApryn()%>';
    	var notiyn = '<%=evo.getNotiyn()%>';
    	
    	if(gender == "1"){
    		$("#men").prop({"checked":true});
    	}else{
    		$("#women").prop({"checked":true});
    	}
    	
    	if(apryn == "Y") {
    		$("#apryn").prop({"checked":true});
    	}
    	if(notiyn == "Y") {
    		$("#notiyn").prop({"checked":true});
    	}
    	
    	$(".gender").click(function() {
    		$(".gender").prop({"checked":false});
    		$(this).prop({"checked":true});
    	});
    	
    	$(document).on("click", "#update_btn", function() {
    		$("#emp_update_form").attr({
    			"action":"gtEmployeeUpdate.gos",
    			"method":"GET"
    		}).submit();
    	});
    	
    });
    
    	
    
    
		$(document).ready(function(){
			//다음 주소
			$("#gezone").prop("readonly", true);
			$("#geload").prop("readonly", true);
			$("#gejibun").prop("readonly", true);
			$("#zonecode").click(function(){
				console.log("zonecode >>> : ");
				new daum.Postcode({
					oncomplete: function(data) {
						$("#gezone").val(data.zonecode);
						$("#geroad").val(data.roadAddress);
						$("#gejibun").val(data.jibunAddress);
						
					}
				}).open();
			});
		});
    </script>

<style>
body {
	margin: 0 auto;
}

#rightcon {
	width: 100%;
}

table {
	margin-left: auto;
	margin-right: auto;
	border: 1px solid gray;
}

input[type="text"] {
	width: 90%;
	margin: 2px;
	height: 28px;
	text-align:center;
}

input[type="password"] {
	text-align:center;
}
td {
	boerder: none;
	text-align: center;
	margin: 5px;
}

th {
	margin: 5px;
	font-size: 20px;
}

body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.container2 {
	display: flex;
}
</style>
</head>
<body style="width: 100%">
	<div class="container2" style="margin: 0; width: 100%;">
		<div>
			<jsp:include page="../main/mainSide-bar.jsp" />
		</div>
		<div style="margin: 0; padding: 0; width: 100%;">
			<jsp:include page="../main/Top-bar.jsp"></jsp:include>
			<div class="container" id="rightcon">
				<div style="width: 500px; margin-right: auto; margin-left: auto;">
					<h1 style="text-align: center;">사원 정보수정</h1>
					<form id="emp_update_form">
					<table style="text-align: center; width: 500px; height: 600px;">
						<tr>
							<th style="height: 10px;"></th>
						</tr>
						<tr style="margin-top: 10px">
							<th style="margin: 30px;">사원번호</th>
							<th>사원명</th>
						</tr>
						<tr>
							<td><input type="text" readonly="readonly" value="<%=evo.getGenum() %>" name="genum"></td>
							<td><input type="text" readonly="readonly" value="<%=evo.getGename() %>" name="gename"></td>
						</tr>
						<tr>
							<th>아이디</th>
							<th>비밀번호</th>
						</tr>
						<tr>
							<td><input type="text" value="<%=evo.getGeid() %>" name="geid"></td>
							<td><input type="password" style="width: 90%; height: 28px;" value="<%=evo.getGepw() %>" name="gepw"></td>
						</tr>
						<tr>
							<th>성별</th>
							<th>생년월일</th>
						</tr>
						<tr>
							<td>남자<input type="checkbox" id="men" class="gender" name="gegender" value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							       여자<input type="checkbox" id="women" class="gender"name="gegender" value="2"></td>
							<td><input type="text" value="<%=evo.getGebirth() %>" name="gebirth"></td>
						</tr>
						<tr>
							<th>핸드폰 번호</th>
							<th>이메일</th>
						</tr>
						<tr>
							<td><input type="text" value="<%=evo.getGehp()%>" name="gehp"></td>
							<td><input type="text" value="<%=evo.getGeemail()%>" name="geemail"></td>
						</tr>
						<tr>
							<th style="height: 10px;"></th>
						</tr>
						<tr>
							<td colspan="2">
								<table style="width: 95%;">
									<tr>
										<th>우편번호</th>
										<th>도로명 주소</th>
									</tr>
									<tr>
										<td><input type="text" id="gezone" name="gezone" value="<%=evo.getGezone()%>"></td>
										<td><input type="text" id="geroad" name="geroad" value="<%=evo.getGeroad()%>">
										</td>
									</tr>
									<tr>
										<th>지번주소</th>
										<th>상세주소</th>
									</tr>
									<tr>
										<td><input type="text" id="gejibun" name="geroaddetail" value="<%=evo.getGeroaddetail()%>"></td>
										<td><input type="text" id="gejibun" name="gejibun" value="<%=evo.getGejibun()%>">
										</td>
									</tr>
									<tr>
										<td colspan="2"><input type="button" name="zonecode"
											id="zonecode" value="우편번호 찾기"
											style="width: 108px; height: 21px; vertical-align: middle; float: right; margin: 10px; background-color: lightblue; color: black;">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<th style="height: 10px;"></th>
						</tr>
						<tr>
							<th>부서명</th>
							<th>직급</th>
						</tr>
						<tr>
							<td><input type="text" value="<%=evo.getGedept()%>" name="gedept"></td>
							<td><input type="text" value="<%=evo.getTitle()%>" name="title"></td>
						</tr>
						<tr>
							<th>공지&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전결</th>
							<th>연봉</th>
						</tr>
						<tr>
							<td><input type="checkbox" id="notiyn" name="notiyn"
								style="margin-right: 30px;" value="Y"><input type="checkbox"
								id="apryn" name="apryn" style="margin-left: 30px;" value="Y"></td>
							<td><input type="text" value="<%=evo.getSalary()%>" name="salary"></td>
						</tr>
						<tr>
							<th style="height: 10px;"></th>
						</tr>
					</table>
					</form>
					<div style="float: right;">
						<input type="button" value="수정" id="update_btn"
							style="width: 108px; height: 21px; vertical-align: middle; background-color: lightblue; color: black; margin-top: 10px;">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

