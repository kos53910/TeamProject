<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 

  	 String gcname = (String)request.getAttribute("gcname");
	 String genum = (String)request.getAttribute("genum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>기안서(계약) page</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css"
	rel="stylesheet">
<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
<script src="resources/js/common.js"></script>

<script type="text/javascript">
	
	//좀따 주석처리
	$(document).ready(function(){
		
		var gcname = "<%=gcname%>";
		var genum = "<%=genum%>";
		
		$("#writer1").text(gcname);
		$("#genum").val(genum);
		

		// 기능
		totalprice(); //합계 기능
		writerday(); //작성일자
		
		// 현재날짜 불러오기
		function writerday(){
			
			let md = new Date(); // md 월/일
			console.log(md);
			let year = md.getFullYear();
			let month = md.getMonth() + 1;
			let date = md.getDate();
			
			let day = year + "-" + numpad(month.toString()) + "-" + numpad(date.toString());
			
			$("#writeday").text(day);
		};
		
			// 대표이사 동의사안 체크박스 택1 코드
            $(document).on("click", "#gcsign", function(){
               
               if($(this).prop('checked')){          
                  //$('input[type="checkbox"][name="mnum"]').prop('checked',false);
                  $('.gcsign').prop('checked',false);
                  $(this).prop('checked',true);	
               }
            });
		
            // 계약형태 체크박스 택1 코드
            $(document).on("click", "#gcconform", function(){
               
               if($(this).prop('checked')){          
                  $('.gcconform').prop('checked',false);
                  $(this).prop('checked',true);
               }
            });
            
			
			
			$(document).on("click", "#line12", function() {
				$("#approval").css({
					"visibility" : "visible"
				});
				$("#hide_div").hide();
			});	
      	  $.ajax({
    		  url : "getGtContractChabun.gos",
    		  type : "GET",
    		  async : false,
      		  success:function(res){
    			  $("#gcnum1").text(res);
    			  $("#gcnum").val(res);
    			  
    		  },
    		  error:function(e){
    			  console.log(e.responseText)
    		  }
    		  
    	  });
      	  

			// 결재선 상신 --------------
			$(document).on("click", "#cbtn", function(){
				var pum = $(".pum");
	      		var pum2 = $(".pum2");
				var count = $(".count");
				var cost = $(".cost");
	      		var cost2 = $(".cost2");
				var pum1 = "";
	      		var count1 = "";
	      		var cost1 = "";
	      		var pum3 = "";
	      		var cost3 = "";
	      			
	      		  for(var i=0; i<pum.length; i++) {
	      			pum1 += pum[i].value + ",";
	      			count1 += count[i].value + ",";
	      			cost1 += cost[i].value + ",";
	      			pum3 += pum2[i].value + ",";
	      			cost3 += cost2[i].value + ",";

	      		  }
	      		  
	      		$("#gcsalitem").val(pum1);
	      		$("#gcsalquantity").val(count1);
	      		$("#gcsalamount").val(cost1);
	      		$("#gcpuritem").val(pum3);
	      		$("#gcpuramount").val(cost3);
	      		
				var app = "";
				var appr = $(".approver");
				for (let i = 0; i < $(".approver").length; i++) {
					app += appr[i].innerHTML + "/";
				}
	
				var dept = "";
				var dept1 = $(".dept");
				for (let i = 0; i < $(".dept").length; i++) {
					dept += dept1[i].innerHTML + "/";
				}
// 				$("#writer").val(gsname);
				$("#writer").val($("#writer1").text());
				$("#reference").val($("#cham").text());
				$("#approver").val(app);
				$("#dept").val(dept);
				
	       	let dataParam = $("#gcform").serialize();
	       	   
	       	   $.ajax({
	 				url : "contractInsert.gos",
	  				data : dataParam,
	  				success : function(res){
							if(res == "OK"){
	  	        		  $("#fileform").attr({
	  	        			  "action" : "gtContractFileupload.gos",
	  	        			  "method" : "POST",
	  	        			  "enctype": "multipart/form-data"
	  	        		  }).submit();
 							}else{
								alert("입력 실패");
							}
	  				},
	  				error : function(e){
	  					console.log(e.responseText);
	  				}
	  			});
	          
	       });
       		
		// 합계
		$(document).on('input','#price1_',function(){
			totalprice();
		});
		$(document).on('input','#price2_',function(){
			totalprice();
		});
		$(document).on('input','#price3_',function(){
			totalprice();
		});
		
		$(document).on('input','#num1_',function(){
			totalprice();
		});
		$(document).on('input','#num2_',function(){
			totalprice();
		});
		
		$(document).on('input','#num3_',function(){
			totalprice();
		});
		
		$(document).on('input','#price4_',function(){
			totalprice();
		});
		
		$(document).on('input','#price5_',function(){
			totalprice();
		});
		
		$(document).on('input','#price6_',function(){
			totalprice();
		});
		
		
		function totalprice(){
			
			var price1 = $("#price1_").val();//매출
			var price2 = $("#price2_").val();
			var price3 = $("#price3_").val();
			var price4 = $("#price4_").val();//매입
			var price5 = $("#price5_").val();
			var price6 = $("#price6_").val();
			var num1 = $("#num1_").val();
			var num2 = $("#num2_").val();
			var num3 = $("#num3_").val();

			
				if(price1 == ""){ //금액
 						price1 = "0" ;
 					}
				if(price2 == ""){
						price2 = "0" ;
					}
				if(price3 == ""){
						price3 = "0" ;
					}
				
				if(price4 == ""){
						price4 = "0" ;
					}
				if(price5 == ""){
						price5 = "0" ;
					}
				if(price6 == ""){
						price6 = "0" ;
					}
				
				if(num1 == ""){ //수량
						num1 = "0" ;
 					}
				
				if(num2 == ""){
						num2 = "0" ;
					}
				
				if(num3 == ""){
						num3 = "0" ;
					}

					// 소계
					var totalprice = (parseInt(price1)*parseInt(num1)) + (parseInt(price2)*parseInt(num2)) + (parseInt(price3)*parseInt(num3));
		        	var aa = (Math.floor(totalprice/10)*10);
		        	
		        	$("#totalprice_1").text(comma(aa) + "원");//매출
		        	
		        	$("#totalprice").val(totalprice);
		        	
		        	// 부가세
		        	var a = $("#totalprice_1").text(); //소계값을 가져오는 것
		        	var b = a.replace("원",""); //원 제거
		        	var c = comma_replace(b); //콤마 제거
		        	var d = (Math.floor((totalprice/10)/10)*10);
		        	var e = comma(d.toString()); //계산 후에 콤마 붙이기
		        	
		        	$("#totalprice_2").text(e + "원"); //부가세 나타내기 
		        	
		        	// 매출합계 
		        	var f = aa + d;
		        	
		        	$("#totalprice_3").text(comma(f) + "원");
		        	
		        	// 매입합계
		        	var totalprice_4 = parseInt(price4) + parseInt(price5) + parseInt(price6);
		        	$("#totalprice_4").text(comma(totalprice_4) + "원");
		        	
		        	// 매출이익
		        	$("#totalprice_5").text(comma(f) + "원"); //매출값
		        	$("#totalprice_6").text(comma(totalprice_4) + "원"); //매입값
		        	
		        	var ftotal = f - totalprice_4; //이익값
		        	$("#totalprice_7").text(comma(ftotal)+ "원");
		        	
		    
		        }
		
		
    });
</script>

<style type="text/css">
.button-container {
	text-align: right;
	width:1000px;
}

.initial-size {
	min-height: 200px;
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
}

#approval {
	visibility: hidden;
	position: absolute;
	background-color: #fff;
	width: 100%;
	height: 100%;
	margin: auto;
}
</style>
</head>
<body>
	<div id="approval">
		<jsp:include page="../approvalline/select.jsp"></jsp:include>
	</div>
	<div id="hide_div">
	<form id="gcform">
	<input type="hidden" id="gcnum" name="gcnum">
		<div>
			<input type="hidden" id="approver" name="approver" value="">
			<input type="hidden" id="dept" name="dept" value="">
			<input type="hidden" id="gcsalitem" name="gcsalitem" value="">
			<input type="hidden" id="gcsalquantity" name="gcsalquantity" value="">
			<input type="hidden" id="gcsalamount" name="gcsalamount" value="">
			<input type="hidden" id="gcpuritem" name="gcpuritem" value="">
			<input type="hidden" id="gcpuramount" name="gcpuramount" value="">
			<input type="hidden" id="writer" name="writer" value="">
			<input type="hidden" id="reference" name="reference" value="">
			<input type="hidden" id="genum" name="genum" value="">
			
		</div>
      <div class="button-container">
         <button type="button" id="line12" onclick=testFn();>결재선지정</button>
         <button type="button" id="cbtn">상신</button>
         <button type="button" id="cbtn1">취소</button>
      </div>
	
		<h2 align="center">기안서(계약건)</h2>
		<br>
		<table>
			<tr>
				<th width="120px">문서번호</th>
				<td width="230px" id="gcnum1"></td>
				<th width="120px">보안구분</th>
				<td width="230px">비공개</td>
				<!--  채번 -->
				<th width="120px">보존연한</th>
				<td width="230px">5년</td>
			</tr>
			<tr>
				<th width="100px">작성자</th>
				<td width="230px" id="writer1"></td>
				<!-- 작성자 -->
				<th width="120px">작성일자</th>
				<td width="230px" id="writeday" colspan="3"></td>
				<!-- 작성일자 -->
				
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
				<td align="center">2</td>
				<td id="snag2"></td>
				<td id="hu2" class="approver"></td>
				<td id="dept2" class="dept"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td align="center">3</td>
				<td id="snag3"></td>
				<td id="hu3" class="approver"></td>
				<td id="dept3" class="dept"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td align="center">4</td>
				<td id="snag4"></td>
				<td id="hu4" class="approver"></td>
				<td id="dept4" class="dept"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td align="center">5</td>
				<td id="snag5"></td>
				<td id="hu5" class="approver"></td>
				<td id="dept5" class="dept"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<br>
		<table id="cham1">
			<tr>
				<th width="15%">참 조</th>
				<td id="cham"></td>
			</tr>
		</table>
		<br>

		<!-- 제목 -->
		<table>
			<tr>
				<th width="15%">제 목</th>
				<td>
					<input type="text" name="gcsubject" id="gcsubject" size="120px">
				</td>
				<!-- 제목 -->
			</tr>
		</table>
		<br> <br>

		<!-- 검토 유도 -->
		<table border="3">
			<tr>
				<td colspan='1'>
					<input type="text" size="135px"
						value="다음과  같이                  에  대한                 을(를)  하고자  하오니  검토  후  재가하여  주시기  바랍니다.">
				</td>
			</tr>
		</table>
		<br>

		<div>
			<span
				style="display: block; text-align: center; height: 50px; font-size: 20px; font-weight: bold;">-
				다 음 -</span>
		</div>
		<br>

		<table>
			<!-- 매출, 매입, 계약, 계약형태 -->
			<tr>
				<th width="15%">1. 매 출 처</th>
				<td><input type="text" name="gcsalplace" id="gcsalplace"
					size="120%" placeholder="XXXX 주식회사"></td>
			</tr>
			<tr>
				<th width="15%">2. 매 입 처</th>
				<td><input type="text" name="gcpurchase" id="gcpurchase"
					size="120%" placeholder="XXXX 주식회사"></td>
			</tr>
			<tr>
				<th width="15%">3. 계약(매출)내용</th>
				<td><textarea rows="8" cols="121" name="gccontent"
						id="gccontent" placeholder=" 계약명  / 계약 금액  / 예정 날짜  / 발주처"></textarea>
				</td>
			</tr>

			<tr>
				<th width="133px">계 약 형 태</th>
				<td style="text-align:left;">
					<input type="checkbox" class="gcconform" name="gcconform" id="gcconform" value="0">구매 
					<input type="checkbox" class="gcconform" name="gcconform" id="gcconform" value="1">계약 
					<input type="checkbox" class="gcconform" name="gcconform" id="gcconform" value="2">매출 
					<input type="checkbox" class="gcconform" name="gcconform" id="gcconform" value="3">입찰
				</td>
			</tr>
		</table>
		<br>

		<!-- 매출 계산 -->
		<table>
			<tr>
				<th colspan="4">매출</th>
			</tr>
			<tr>
				<th></th>
				<th>품목</th>
				<th>수량</th>
				<th>금액</th>
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"><input type="text" size="80" class="pum"></td>
				<!-- 품목 -->
				<td align="center"><input type="text" size="20" class="count" id="num1_" style="text-align: right"></td>
				<!-- 수량 -->
				<td align="center"><input type="text" size="20" id="price1_" style="text-align: right" class="cost"></td>
				<!-- 금액 -->
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"><input type="text" size="80" class="pum"></td>
				<!-- 품목 -->
				<td align="center"><input type="text" size="20" class="count" id="num2_" style="text-align: right"></td>
				<!-- 수량 -->
				<td align="center"><input type="text" size="20" id="price2_" style="text-align: right" class="cost"></td>
				<!-- 금액 -->
			</tr>			
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"><input type="text" size="80" class="pum"></td>
				<!-- 품목 -->
				<td align="center"><input type="text" size="20" class="count" id="num3_" style="text-align: right"></td>
				<!-- 수량 -->
				<td align="center"><input type="text" size="20" id="price3_" style="text-align: right" class="cost"></td>
				<!-- 금액 -->
			</tr>
			<tr>
				<th>
					<!-- 소계 칸 -->
				<td colspan="1"
					style='text-align: center; background-color: #f2f2f2; font-weight: bold;'
					width="200px">소 계</td>
				<td colspan="2" width="80px" style="text-align: right;"
					id="totalprice_1"></td>
				</th>
			</tr>
			<tr>
				<th>
					<!-- 부가세 칸 -->
				<td colspan="1"
					style='text-align: center; background-color: #f2f2f2; font-weight: bold;'
					width="200px">부 가 세</td>
				<td colspan="2" width="80px" style="text-align: right;"
					id="totalprice_2"></td>
				</th>
			</tr>
			<tr>
				<th>
					<!-- 합계 칸 -->
				<td colspan="1"
					style='text-align: center; background-color: #f2f2f2; font-weight: bold;' width="200px">합 계</td>
				<td colspan="2" width="80px" style="text-align: right;" id="totalprice_3"></td>
				</th>
			</tr>
		</table>
		<br>

		<!-- 매입 계산 -->
		<table>
			<tr>
				<th colspan="5">매입</th>
			</tr>
			<tr>
				<th></th>
				<th>매입처</th>
				<th>품목</th>
				<th>금액</th>
				<th>비고</th>
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"><input type="text" size="25"></td>
				<!-- 매입처 -->
				<td align="center"><input type="text" size="40" class="pum2"></td>
				<!-- 품목 -->
				<td align="center"><input type="text" size="20" id="price4_" style="text-align: right" class="cost2"></td>
				<!-- 금액 -->
				<td align="center"><input type="text" size="25"></td>
				<!-- 비교 -->
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"><input type="text" size="25"></td>
				<!-- 매입처 -->
				<td align="center"><input type="text" size="40" class="pum2"></td>
				<!-- 품목 -->
				<td align="center"><input type="text" size="20" id="price5_" style="text-align: right" class="cost2"></td>
				<!-- 금액 -->
				<td align="center"><input type="text" size="25"></td>
				<!-- 비교 -->
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"><input type="text" size="25"></td>
				<!-- 매입처 -->
				<td align="center"><input type="text" size="40" class="pum2"></td>
				<!-- 품목 -->
				<td align="center"><input type="text" size="20" id="price6_" style="text-align: right" class="cost2"></td>
				<!-- 금액 -->
				<td align="center"><input type="text" size="25"></td>
				<!-- 비교 -->
			</tr>

			<tr>
				<th>
					<!-- 합계 칸 -->
				<td colspan="2"
					style='text-align: center; background-color: #f2f2f2; font-weight: bold;'
					width="200px">합 계</td>
				<td colspan="2" width="80px" style="text-align: right;"
					id="totalprice_4"></td>
				</th>
			</tr>
		</table>
		<br>

		<!-- 매출이익 계산 -->
		<table>
			<tr>
				<th colspan="2" style="width: 500px">매출이익</th>
				<th colspan="1" style="width: 500px">비고</th>
			</tr>
			<tr>
				<th colspan="1" width="20%">매 출</th>
				<td style="text-align: right;" id="totalprice_5"></td>
				<td rowspan="3"><textarea rows="7" cols="70"></textarea></td>
			</tr>
			<tr>
				<th colspan="1" width="20%">매 입</th>
				<td style="text-align: right;" id="totalprice_6"></td>
			</tr>
			<tr>
				<th colspan="1" width="20%">이 익</th>
				<td style="text-align: right;" id="totalprice_7"></td>
			</tr>
		</table>
		<br>


		<!-- 계약서 첨부 칸 -->
		<table>
			<tr>
				<th width="20%">첨 부 서</th>
				<td><input type="text" name="gcattach" size="110" placeholder="계약서 1부"></td>
			</tr>
			<th width="20%">대표이사 동의 사안</th>
				<td>
					<div style="text-align:left;">
						<input type="checkbox" class="gcsign" name="gcsign" id="gcsign" value="0" checked>사용인감 날인 
						<input type="checkbox" class="gcsign" name="gcsign" id="gcsign" value="1">법인인감 날인
					</div>
				</td>
			</th>
		</table>
		<br>
	</form>
	</div>

	<!-- 첨부파일 -->
	<form id="fileform">
		<table>
			<tr>
				<th width="20%">첨 부 파 일</th>
				<td class="left-align" style='text-align: left;'><input type="file" name="gcfile" id="gcfile" multiple></td>
			</tr>
		</table>
		<br>

	</form>
</body>
</html>