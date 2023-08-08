<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:"appProjectSelectAll.gos",
			type:"POST",
			success:whensuccess
		});
		
		function whensuccess(d){
			var row = d.split(",,,");
			for(var i=0; i<row.length-1; i++) {
				var row_ = row[i].split(",");
				$("#protable").append("	 <tr><td>"+row_[0]+"</td>"
									+	"<td>"+row_[1]+"</td>"
									+	"<td>"+row_[2]+"</td>"
									+	"<td>"+row_[3]+"</td>"
									+	"<td>"+row_[4]+"</td>"
									+	"<td style='width:50px;'><input type='button' id='appselectbtn' value='선택'></td></tr>");
			}
		}
		$(document).on("click", "#appselectbtn", function(){
			var a = $(this).parent().parent().find("td:eq(1)").text();
			var b = $(this).parent().parent().find("td:eq(2)").text();
			$("#pro_span").text(b);
			$("#gpnum").val(a);
			$("#hide_div").show();
			$("#projectselect").hide();
		});
	});
</script>
</head>
<body>
<div>
	<table id="protable">
		<tr> 
			<td>고객명</td>
			<td>프로젝트 코드</td>
			<td>프로젝트 명</td>
			<td>시작 일자</td>
			<td>종료 일자</td>
			<td style='width:50px;'></td>
		</tr>
		
	</table>
</div>
</body>
</html>