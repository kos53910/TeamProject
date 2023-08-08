<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				//다음 주소
				$("#gazone").prop("readonly", true);
				$("#gaload").prop("readonly", true);
				
				$("#zonecode").click(function(){
					console.log("zonecode >>> : ");
					new daum.Postcode({
						oncomplete: function(data) {
							$("#gazone").val(data.zonecode);
							$("#gaload").val(data.roadAddress);
							
						}
					}).open();
				});
				
				
		       	  $.ajax({
		    		  url : "AccountChabun.gos",
		    		  success:function(res){
		    			  
		    			  var ganum = res;
		    			              		  
		    			  $("#ganum").val(ganum);

		    		  },
		    		  error:function(e){
		    			  console.log(e.responseText)
		    		  }
		    		  
		    	  });
				
				$(document).on("click", "#regbtn", function(){
					
					$("#accountInsert").attr({
						"action":"accountInsert.gos",
						"method":"GET",
						"enctype":"multipart/form-data"			
					}).submit();	
				});					
			});
		
		</script>
		
		<style type="text/css">
		
			#zonecode {
				padding: 0px 0px; 
			}
		
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
			<tr>
				<td>거래처코드</td>
				<td colspan="50">거래처명</td>
			</tr>
			<tr>
				<td><input type="text" name="ganum" id="ganum"></td>
				<td colspan="50"><input type="text" name="ganame" id="ganame" style="colspan:3; width:351px;"></td>
			</tr>
			<tr>
				<td>사업자번호</td>
				<td>업태</td>
				<td>종목</td>
			</tr>
			<tr>
				<td><input type="text" name="gasnum" id="gasnum"></td>
				<td><input type="text" name="gabusinesstype" id="gabusinesstype"></td>
				<td><input type="text" name="gaevent" id="gaevent"></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>주소</td>
				<td>상세주소</td>
			</tr>
			<tr>
				<td style="text-align: center;"><input type="text" name="gazone" id="gazone" style="width:55px; vertical-align: middle;">&nbsp;<input type="button" name="zonecode" id="zonecode" value="우편번호 찾기" style="width:108px; height:21px; vertical-align: middle;"></td>
				<td><input type="text" name="gaload" id="gaload"></td>
				<td><input type="text" name="galoaddetale" id="galoaddetale"></td>
				
							
			</tr>
			<tr>
				<td>전화번호</td>
				<td>FAX</td>
				<td>창립일</td>
			</tr>
			<tr>
				<td><input type="text" name="gahp" id="gahp"></td>
				<td><input type="text" name="gafax" id="gafax"></td>
				<td><input type="date" style="width:172px;" name="gafoundation" id="gafoundation"></td>
			</tr>
			<tr>
				<td>거래 시작일</td>
				<td>거래 종료일</td>
				<td>사용구분</td>
			</tr>
			<tr>
				<td><input type="date" style="width:172px;" name="startdate" id="startdate"></td>
				<td><input type="date" style="width:172px;" name="enddate" id="enddate"></td>
				<td>
					<select name="gagubun" id="gagubun" style="width:177px; height:21px;">
						    <option value="Y">예</option>
		    				<option value="N">아니오</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>설명</td>
			</tr>
				<tr>
				<td colspan="50"><textarea id="gainfo" name="gainfo" rows="15" style="width:534px;"></textarea></td>
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