<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.gt.s.common.DateFormatUtil"%>
<%@ page import="com.gt.s.kos.draft.vo.GtDraftVO"%>
<%@ page import="com.gt.s.common.CodeUtil"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	GtDraftVO gvo = (GtDraftVO) request.getAttribute("gdvo");
String app = gvo.getApprover();
String count = gvo.getCount();
String s = CodeUtil.edsmjeoncheck(app, Integer.parseInt(count));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<style type="text/css">
.left-align {
	text-align: left;
}

.button-container {
	text-align: right;
}

th {
	background-color: #f2f2f2;
}

table {
	border-collapse: collapse;
	width: 1000px;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	align: left;
}

#approvalline {
	visibility: hidden;
	position: absolute;
	background-color: #fff;
	width: 100%;
	height: 100%;
	margin: auto;
}
</style>

<script type="text/javascript">
      
         $(document).ready(function(){
				
				var gdrsubject = '<%=gvo.getGdrsubject()%>';
				var gdrmemo = '<%=gvo.getGdrmemo()%>';
				var gdrsign = '<%=gvo.getGdrsign()%>';
				var gdrcontract = '<%=gvo.getGdrcontract()%>';
				var genum = '<%=gvo.getGenum()%>';
				var writer = '<%=gvo.getWriter()%>';
				var reference = '<%=gvo.getReference()%>';
				var approver = '<%=gvo.getApprover()%>';
				var dept = '<%=gvo.getDept()%>';
				var pro = '<%=gvo.getProval()%>';
				var appcount = '<%=gvo.getCount()%>';
				var gdrsign = '<%= gvo.getGdrsign() %>';
				var gdrcontract = '<%= gvo.getGdrcontract() %>';
				
				if(gdrsign = '0') {
					gdrsign = "사용인감 날인";
				}else{
					gdrsign = "법인인감 날인";
				}
				
				$("#gdrsign").text(gdrsign);
				
				if(gdrcontract = '0'){
					gdrcontract = "구매";
				} else if(gdrcontract = '1'){
					gdrcontract = "계약";
				} else if(gdrcontract = '2'){
					gdrcontract = "매출";
				} else if(gdrcontract = '3'){
					gdrcontract = "입찰";
				}
			
				$("#gdrcontract").text(gdrcontract);
					
				var s = '<%=s%>';
				var app_ = approver.split("/");
				var dept_ = dept.split("/");

				if (pro != 'null') {
					var pro_ = pro.split("/");
				} else {
					var pro_ = "";
				}
				console.log("s > : " + s);
				if (appcount < 0) {
					var nappcount = Number(appcount) + 10;
					for (var i = 0; i < app_.length; i++) {
						if (app_[i] != "-") {
							if (app_[i] != "-") {
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(1)").text("결재");
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(2)").text(app_[i]);
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(3)").text(dept_[i]);
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(5)").text(pro_[i]);
								if ($("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(5)").text() != "") {
									$("#table1").find("tr:eq(" + (i + 1) + ")")
											.find("td:eq(4)").text("결재완료");
								}
							}
							if (nappcount == i) {
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(1)").text("결재");
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(2)").text(app_[i]);
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(3)").text(dept_[i]);
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(5)").text(pro_[i]);
								if ($("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(5)").text() != "") {
									$("#table1").find("tr:eq(" + (i + 1) + ")")
											.find("td:eq(4)").text("반려");
								}
							}

						}
					}
				} else {
					if (s != '') {
						for (var i = 0; i < app_.length; i++) {
							if (app_[i] != "-") {
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(1)").text("결재");
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(2)").text(app_[i]);
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(3)").text(dept_[i]);
								$("#table1").find(
										"tr:eq(" + (appcount - 9) + ")").find(
										"td:eq(5)").text(pro_[0]);
								if ($("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(5)").text() != "") {
									$("#table1").find("tr:eq(" + (i + 1) + ")")
											.find("td:eq(4)").text("전결");
								}
							}
						}
					} else {
						for (var i = 0; i < app_.length; i++) {
							if (app_[i] != "-") {
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(1)").text("결재");
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(2)").text(app_[i]);
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(3)").text(dept_[i]);
								$("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(5)").text(pro_[i]);
								if ($("#table1").find("tr:eq(" + (i + 1) + ")")
										.find("td:eq(5)").text() != "") {
									$("#table1").find("tr:eq(" + (i + 1) + ")")
											.find("td:eq(4)").text("결재완료");
								}
							}
						}
					}
				}
				
				var num = '<%= gvo.getGdrnum() %>';
				
				$.ajax({
					url:"fileDownloadlistdr.gos",
					type:"GET",
					data:{"gdrnum":num},
					success:whens
				});
				
				function whens(d) {
					var filename = d.split(",");
					for(var i=0; i<filename.length-1; i++) {
						$("#gdr_file_form").find("tr:eq(0)").find("td:eq(0)").append("<a href='fileDownloaddr?file="+filename[i]+"&num="+num+"' target='_blank'>"+filename[i]+"</a><br>");
						
					}
				}		
				
			});

	// 				$.ajax({
	// 					url:"fileDownloadlist.gos",
	// 					type:"GET",
	// 					data:{"gsnum":num},
	// 					success:whens
	// 				});

	// 				function whens(d) {
	// 					var filename = d.split(",");
	// 					for(var i=0; i<filename.length-1; i++) {
	// 						$("#table3").find("tr:eq(0)").find("td:eq(0)").append("<a href='fileDownload?file="+filename[i]+"&num="+num+"' target='_blank'>"+filename[i]+"</a><br>");

	// 					}
	// 				}
	
</script>

</head>
<body>
	<form name="draftFormAll" id="draftFormAll">

		<h2 align="center">기안서(일반)</h2>
		<br>
		<table style="text-align: center">
			<tr>
				<th width="120px">문서번호</th>
				<td width="230px"><%=gvo.getGdrnum()%></td>
				<th width="120px">보안구분</th>
				<td width="230px">비공개</td>
				<th width="120px">보존연한</th>
				<td width="230px">5년</td>
			</tr>
			<tr>
				<th width="10%">작성자</th>
				<td width="23%"><%=gvo.getWriter()%></td>
				<th width="10%">작성일자</th>
				<td colspan="3"><%=gvo.getInsertdate()%></td>
			</tr>
		</table>
		<br>
		<table style="text-align: center" id="table1">
			<tr>
				<th width="5%">순서</th>
				<th width="8%">구분</th>
				<th width="17%">결재자</th>
				<th width="17%">부서</th>
				<th width="8%">상태</th>
				<th width="10%">결재일</th>
				<th width="35%">결재의견</th>
			</tr>
			<tr>
				<td align="center">1</td>
				<td id="snag1"></td>
				<td id="hu1" class="approver"></td>
				<td id="dept1" class="dept"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>2</td>
				<td></td>
				<td id="hu2"></td>
				<td id="du2"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>3</td>
				<td></td>
				<td id="hu3"></td>
				<td id="du3"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>4</td>
				<td></td>
				<td id="hu4"></td>
				<td id="du4"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>5</td>
				<td></td>
				<td id="hu5"></td>
				<td id="du5"></td>
				<td></td>
				<td></td>
				<td></td>

			</tr>
		</table>
		<br>
		<table>
			<tr>
            	<% if(gvo.getReference() == null) {
            		gvo.setReference(" ");
            } %>
				<th width="17%">참 조</th>
				<td><%=gvo.getReference()%></td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<th width="17%">제 목</th>
				<td><%=gvo.getGdrsubject()%></td>
			</tr>
		</table>
		<br>
		<div style="align: left">
			<table>
				<tr>
					<th width="17%">대표이사 등의 사안</th>
					<td class="left-align" id="gdrsign"></td>
				</tr>
				<tr>
					<th width="17%">계 약 형 태</th>
					<td class="left-align" id="gdrcontract"></td>
				</tr>
				<tr>
					<td colspan="2" height="300px;"><%=gvo.getGdrmemo()%></td>
				</tr>
			</table>
		</div>
	</form>
	<br>
	<form id="gdr_file_form">
		<table>
			<tr>
				<th width="17%">첨 부 파 일</th>
				<td></td>
				<!-- 파일 -->
			</tr>
		</table>
	</form>
</body>
</html>