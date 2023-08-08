<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.gt.s.common.DateFormatUtil"%>
<%@ page import="com.gt.s.kos.contract.vo.GtContractVO"%>
<%@ page import="com.gt.s.common.CodeUtil"%>
<%
	GtContractVO cvo = (GtContractVO)request.getAttribute("cvo");
	String app = cvo.getApprover();
	String count = cvo.getCount();
	String s = CodeUtil.edsmjeoncheck(app, Integer.parseInt(count));
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
<script src="resources/js/common.js"></script>
	<script type="text/javascript">
	
			$(document).ready(function(){
				var app = '<%=cvo.getApprover()%>';
				var dept = '<%=cvo.getDept()%>';
				var pro = '<%=cvo.getProval()%>';
				var appcount = '<%=cvo.getCount()%>';
				var s = '<%=s%>';
				
				

				var app_ = app.split("/");
				var dept_ = dept.split("/");
				
				if(pro != 'null') {
					var pro_ = pro.split("/");
				}else {
					var pro_ = "";
				}
				
				var write = '<%=cvo.getWriter()%>'
				var insertdate = '<%=cvo.getInsertdate()%>'
				var reference = '<%=cvo.getReference()%>'
				var subject = '<%=cvo.getGcsubject()%>'
				var salplace = '<%=cvo.getGcsalplace()%>'
				var purchase = '<%=cvo.getGcpurchase()%>'
				var content = '<%=cvo.getGccontent()%>'
				var conform = '<%=cvo.getGcconform()%>' <%-- 계약형태/체크박스 --%>
				var salitem = '<%=cvo.getGcsalitem()%>'	 <%-- 매출품목/스플릿  --%>
				var salquantity = '<%=cvo.getGcsalquantity()%>' <%-- 매출수량/스플릿 --%>
				var salamount = '<%=cvo.getGcsalamount()%>'	<%-- 매출금액/스플릿--%>
				var sign = '<%=cvo.getGcsign()%>'
				
				/* saltable */
				var salitem_ = salitem.split(",");
				var salquantity_ = salquantity.split(",");
				var salamount_ = salamount.split(",");
					for (var i= 0; i < salitem_.length-1; i++){
						$("#saltable").find("tr:eq("+(i+2)+")").find("td:eq(1)").text(salitem_[i]);
						$("#saltable").find("tr:eq("+(i+2)+")").find("td:eq(2)").text(salquantity_[i]);
						$("#saltable").find("tr:eq("+(i+2)+")").find("td:eq(3)").text(salamount_[i]);
					}
				var puritem = '<%=cvo.getGcpuritem()%>' <%-- 매입품목/스플릿 --%>
				var puramount = '<%=cvo.getGcpuramount()%>'	<%--매입금액/스플릿 --%>
				
				/* purtable */
				var puritem_ = puritem.split(",");
				var puramount_ = puramount.split(",");
			
					for (var i= 0; i < puritem_.length-1; i++){
						if(puritem_[i] != ""){
						$("#purtable").find("tr:eq("+(i+2)+")").find("td:eq(1)").text(purchase);
						}
						$("#purtable").find("tr:eq("+(i+2)+")").find("td:eq(2)").text(puritem_[i]);
						$("#purtable").find("tr:eq("+(i+2)+")").find("td:eq(3)").text(puramount_[i]);
					}
				
				var attach = '<%=cvo.getGcattach()%>'
				var sign = '<%=cvo.getGcsign()%>' <%-- 동의사안/체크박스 --%>
				var file = '<%=cvo.getGcfile()%>'
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + file);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + write);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + insertdate);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + reference);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + subject);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + salplace);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + purchase);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + content);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + conform);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + salitem);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + salquantity);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + salamount);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + puritem);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + puramount);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + sign);
					console.log(">>>>>>>>>>>>>>>>>>>>>>>>> " + attach);
					
				
					
				console.log("s > : " + s);
				if(appcount < 0) {
					var nappcount = Number(appcount) + 10;
					for(var i=0; i<app_.length; i++) {
						if(app_[i] != "-"){
							if(app_[i] != "-"){
							 $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(1)").text("결재");
			 				 $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(2)").text(app_[i]);
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(3)").text(dept_[i]);
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(5)").text(pro_[i]);
		                     if($("#table1").find("tr:eq("+(i+1)+")").find("td:eq(5)").text() != "") {
		                        $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(4)").text("결재완료");
		                     }
		                  }
		                  if(nappcount == i) {
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(1)").text("결재");
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(2)").text(app_[i]);
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(3)").text(dept_[i]);
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(5)").text(pro_[i]);
		                     if($("#table1").find("tr:eq("+(i+1)+")").find("td:eq(5)").text() != "") {
		                        $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(4)").text("반려");
		                     }
		                  }

		               }
		            }
		         }else {
		        	 
		         }
				
		         if(s != '') {
		            for(var i=0; i<app_.length; i++) {
		               if(app_[i] != "-"){
		                  $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(1)").text("결재");
		                  $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(2)").text(app_[i]);
		                  $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(3)").text(dept_[i]);
		                  $("#table1").find("tr:eq("+(appcount-9)+")").find("td:eq(5)").text(pro_[0]);
		                  if($("#table1").find("tr:eq("+(i+1)+")").find("td:eq(5)").text() != "") {
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(4)").text("전결");
		                  }
		               }
		            }
		         }else {
		            for(var i=0; i<app_.length; i++) {
		               if(app_[i] != "-"){
		                  $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(1)").text("결재");
		                  $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(2)").text(app_[i]);
		                  $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(3)").text(dept_[i]);
		                  $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(5)").text(pro_[i]);
		                  if($("#table1").find("tr:eq("+(i+1)+")").find("td:eq(5)").text() != "") {
		                     $("#table1").find("tr:eq("+(i+1)+")").find("td:eq(4)").text("결재완료");
		                  }
		               }
		            }
		         }
				
				
				// 매출
				 var price = 0;
				 
				for (var i= 0; i < salquantity_.length; i++){
					price += (Number(salquantity_[i]) * Number(salamount_[i]));
				}
				
				console.log(price);
				
	        	var aa = (Math.floor(price/10)*10); // 소계
	        	
	        	var d = (Math.floor((price/10)/10)*10); // 부가세
	        	var e = comma(d.toString()); //계산 후에 콤마 붙이기
	        	
	        	var f = aa + d;// 합계
	        	
				$("#totalprice_1").text(comma(aa.toString()) + "원");
	        	$("#totalprice_2").text(e + "원");
	        	$("#totalprice_3").text(comma(f) + "원");
				
	        	
	        	// 매입
	        	var price_ = 0;
	        	
	        	for (var i= 0; i < puramount_.length; i++){
	    			price_ += Number(puramount_[i]);
				}
	        	
	        	console.log(">>>>> " + price_);
	        	
	        	$("#totalprice_4").text(comma(price_.toString()) + "원");
	        	
	          	$("#totalprice_5").text(comma(f) + "원"); //매출값
	        	$("#totalprice_6").text(comma(price_.toString()) + "원"); //매입값
	        	
	        	var ftotal = f - price_; //이익값
	        	$("#totalprice_7").text(comma(ftotal)+ "원");
	        	
	        	
	        	// 체크박스 - 계약형태
	    		console.log(conform);				
	    		var conform_ = conform.replace(",","");
	    		console.log(conform_);				
	    			
    			$(".gcconform").each(function(){
    				if($(this).val() == conform_){
    					$(this).prop("checked", true);
    				}
    			});
	 
    			// 체크박스 - 동의사안
	    		console.log(sign);
    			
    			$(".gcsign").each(function(){
    				if($(this).val() == sign){
    					$(this).prop("checked", true);
    				}
    			});
    			
    			
				var num = '<%=cvo.getGcnum() %>';

				$.ajax({
					url:"gcfileDownloadlist.gos",
					type:"GET",
					data:{"gcnum":num},
					success:whens
				});
				
				function whens(d) {
					var filename = d.split(",");
					for(var i=0; i<filename.length-1; i++) {
						$("#table3").find("tr:eq(0)").find("td:eq(0)").append("<a href='gcfileDownload?file="+filename[i]+"&num="+num+"' target='_blank'>"+filename[i]+"</a><br>");
						
					}
				}
				
				
				
			});
	</script>


<style type="text/css">
.button-container {
	text-align: right;
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
	<form id="gcform">
		<div>
		</div>
		<div class="button-container">
			<button type="button" id="line12">결재선지정</button>
			<button type="button" id="sbtn">상신</button>
			<button type="button" id="cbtn">취소</button>
		</div>

		<h2 align="center">기안서(계약건)</h2>
		<br>
		<table>
			<tr>
				<th width="120px">문서번호</th>
				<td width="230px"><%=cvo.getGcnum() %></td>
				<th width="120px">보안구분</th>
				<td width="230px">비공개</td>
				<!--  채번 -->
				<th width="120px">보존연한</th>
				<td width="230px">5년</td>
			</tr>
			<tr>
				<th width="100px">작성자</th>
				<td width="230px" id="writer1"><%=cvo.getWriter() %></td>
				<!-- 작성자 -->
				<th width="120px">작성일자</th>
				<td width="230px" id="writeday" colspan="3"><%=cvo.getInsertdate() %></td>
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
            <% if(cvo.getReference() == null) {
            	cvo.setReference(" ");
            } %>
				<th width="15%">참 조</th>
				<td id="cham"><%=cvo.getReference() %></td>
			</tr>
		</table>
		<br>

		<!-- 제목 -->
		<table>
			<tr>
				<th width="15%">제 목</th>
				<td><%=cvo.getGcsubject()%></td>
				<!-- 제목 -->
			</tr>
		</table>
		<br> 
		
		<table>
			<!-- 매출, 매입, 계약, 계약형태 -->
			<tr>
				<th width="15%">1. 매 출 처</th>
				<td><%=cvo.getGcsalplace()%></td>
			</tr>
			<tr>
				<th width="15%">2. 매 입 처</th>
				<td><%=cvo.getGcpurchase()%></td>
			</tr>
			<tr>
				<th width="15%">3. 계약(매출)내용</th>
				<td><%=cvo.getGccontent()%></td>
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
		<table id="saltable">
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
				<td align="center"></td>
				<!-- 품목 -->
				<td align="center"></td>
				<!-- 수량 -->
				<td align="center"></td>
				<!-- 금액 -->
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"></td>
				<!-- 품목 -->
				<td align="center"></td>
				<!-- 수량 -->
				<td align="center"></td>
				<!-- 금액 -->
			</tr>			
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"></td>
				<!-- 품목 -->
				<td align="center"></td>
				<!-- 수량 -->
				<td align="center"></td>
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
				<td colspan="1" style='text-align: center; background-color: #f2f2f2; font-weight: bold;' width="200px">합 계</td>
				<td colspan="2" width="80px" style="text-align: right;" id="totalprice_3"></td>
				</th>
			</tr>
		</table>
		<br>

		<!-- 매입 계산 -->
		<table id="purtable">
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
				<td align="center"></td>
				<!-- 매입처 -->
				<td align="center"></td>
				<!-- 품목 -->
				<td align="center"></td>
				<!-- 금액 -->
				<td align="center">-</td>
				<!-- 비교 -->
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"></td>
				<!-- 매입처 -->
				<td align="center"></td>
				<!-- 품목 -->
				<td align="center"></td>
				<!-- 금액 -->
				<td align="center">-</td>
				<!-- 비교 -->
			</tr>
			<tr>
				<td align="center"><input type="checkbox"></td>
				<td align="center"></td>
				<!-- 매입처 -->
				<td align="center"></td>
				<!-- 품목 -->
				<td align="center"></td>
				<!-- 금액 -->
				<td align="center">-</td>
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
				<td rowspan="3">-</td>
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
				<td><%=cvo.getGcattach()%></td>
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

	<!-- 첨부파일 -->
	<form id="fileform">
		<table id="table3">
			<tr>
				<th width="20%">첨 부 파 일</th>
				<td class="left-align" style='text-align: left;'></td>
			</tr>
		</table>
		<br>
		<div class="button-container" >
			<button type="button" id="line12">결재선지정</button>
			<button type="button" id="sbtn">상신</button>
			<button type="button" id="cbtn">취소</button>
		</div>
	</form>
</body>
</html>