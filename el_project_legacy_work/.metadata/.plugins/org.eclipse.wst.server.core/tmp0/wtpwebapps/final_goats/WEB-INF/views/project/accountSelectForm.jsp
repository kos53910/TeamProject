<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				
				$("#search").keyup(function () {
			          var key = $("#search").val();
					  
			          $.ajax({
			            url: "AccountSelectForm2.gos",
			            data: { ganame: key },
			            success: function (data) {
			            	 
			              var row = data.split("/");
			              console.log(row);
			              for (var i = 0; i < row.length - 1; i++) {
			                var list = row[i].split(",");
			                
			                $("#ganum").val(list[0]);
			                $("#ganame").val(list[1]);
			                $("#gasnum").val(list[2]);
 			                $("#gabusinesstype").val(list[3]);
			                $("#gaevent").val(list[4]);
			                $("#gazone").val(list[5]);
			                $("#gaload").val(list[6]);
 			                $("#galoaddetale").val(list[7]);
			                $("#gahp").val(list[8]);
			                $("#gafax").val(list[9]);
 			                $("#gafoundation").val(list[10]);
			                $("#startdate").val(list[11]);
			                $("#enddate").val(list[12]);
			                $("#gagubun").val(list[13]);
			                $("#gainfo").text(list[14]);
			                
			               
			                
			              }
			            },
			          });
  
					    
			        });
				
				$(document).on("click", "#regbtn", function () {
			          
			          //시작일 종료일 계약처 이름을 보내야함
			          
			          
				     var start = document.getElementById("startdate").value;
				     var end = document.getElementById("enddate").value;	
				     var ganame = document.getElementById("ganame").value;
				     var ganum = document.getElementById("ganum").value;
				     
				     
				     
				  		window.opener.popaccount(start, end , ganame, ganum);
				  		window.close();
			        });
				
				
				
			}); // end of ready
		
		</script>
		
		<style type="text/css">
		
		
/* 		input[type=date]::-webkit-datetime-edit-text { */
/* 		    -webkit-appearance: none; */
/* 		    display: none; */
/* 		} */
/* 		input[type=date]::-webkit-datetime-edit-month-field{ */
/* 		    -webkit-appearance: none; */
/* 		    display: none; */
/* 		} */
/* 		input[type=date]::-webkit-datetime-edit-day-field { */
/* 		    -webkit-appearance: none; */
/* 		    display: none; */
/* 		} */
/* 		input[type=date]::-webkit-datetime-edit-year-field { */
/* 		    -webkit-appearance: none; */
/* 		    display: none; */
/* 		} */
		
		
		
		</style>
		<script type="text/javascript">
		  $(document).on('input','#asd',function(){
        	 $("#asd").css("display","inline");
    	  });
		
		
		</script>
		
	</head>
	<body>
		<form name="accountInsert" id="accountInsert">
		<h3>업체 등록</h3>
		<hr>
		<table>
			<tr><td>거래처 검색<input type="text" id="search" name="search" ></td></tr>
			<tr>
				<td>거래처코드</td>
				<td colspan="50">거래처명</td>
			</tr>
			<tr>
				<td><input type="text" name="ganum" id="ganum" readonly></td>
				<td colspan="50"><input type="text" name="ganame" id="ganame" style="colspan:3; width:351px;" readonly></td>
			</tr>
			<tr>
				<td>사업자번호</td>
				<td>업태</td>
				<td>종목</td>
			</tr>
			<tr>
				<td><input type="text" name="gasnum" id="gasnum" readonly></td>
				<td><input type="text" name="gabusinesstype" id="gabusinesstype" readonly></td>
				<td><input type="text" name="gaevent" id="gaevent" readonly></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>주소</td>
				<td>상세주소</td>
			</tr>
			<tr>
				<td><input type="text" name="gazone" id="gazone" readonly></td>
				<td><input type="text" name="gaload" id="gaload" readonly></td>
				<td><input type="text" name="galoaddetale" id="galoaddetale" readonly></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>FAX</td>
				<td>창립일</td>
			</tr>
			<tr>
				<td><input type="text" name="gahp" id="gahp" readonly></td>
				<td><input type="text" name="gafax" id="gafax" readonly></td>
				<td><input type="date" style="width:172px;" name="gafoundation" id="gafoundation" readonly></td>
			</tr>
			<tr>
				<td>거래 시작일</td>
				<td>거래 종료일</td>
				<td>사용구분</td>
			</tr>
			<tr>
				<td><input type="date" style="width:172px;" name="startdate" id="startdate" readonly></td>
				<td><input type="date" style="width:172px;" name="enddate" id="enddate" readonly></td>
				<td>
					<select name="gagubun" id="gagubun" style="width:177px; height:21px;" readonly>
						    <option value="Y">예</option>
		    				<option value="N">아니오</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>설명</td>
			</tr>
				<tr>
				<td colspan="50"><textarea id="gainfo" name="gainfo" rows="15" style="width:534px;" readonly></textarea></td>
			</tr>
		</table>
		<hr>
		<div style="float:right">
			<button type="reset">취소</button>
			<button id="regbtn">등록</button>
			<button>삭제</button>	
		</div>
		</form>
	</body>
</html>