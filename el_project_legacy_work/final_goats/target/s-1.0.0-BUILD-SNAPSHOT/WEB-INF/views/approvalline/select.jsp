<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gt.s.kos.dept.vo.GtDeptVO"%>
<%@ page import="org.apache.log4j.LogManager"%>
<%@ page import="org.apache.log4j.Logger"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.0.min.js"></script>

<script type="text/javascript">
	   
   
	$(document).ready(function() {
         
		$.ajax({
			url:"goatsDeptSelectAll.gos",
			type:"POST",
			success:whens
		});
		function whens(data) {
			var data = data.split(",");
			for(let i=0; i<data.length-1; i++) {
				$("#jojic").append("<li><div class='select'><span class='aas'>" + data[i] + "</span></div></li>");
			}
		}
            
		$(document).on('click', '.aas', function() {
			var s = $(this).text();
			$("#t2").empty();
			$.ajax({
				url : "goatsEmployeeSelect.gos",
				data : {dept : s},
				method : 'GET',
				success : function(data){
                     
					var row = data.split("/");
					$("#t2").append("<tr class='white'>" 
                                  + "<td><font size='2'>이름</font></td>" 
                                  + "<td><font size='2'>직급</font></td>" 
                                  + "<td><font size='2'>부서</font></td>" 
                                 + "</tr>");
						for (var i = 0 ; i < row.length -1 ; i++ ) {
							var list = row[i].split(",");
                        
                        
                        $("#t2").append("<tr class='qq white' ><td><font size='2'>"+list[0]+"</font></td>"
                        									+ "<td><font size='2'>"+list[1]+"</font></td>"
                        									+ "<td><font size='2'>"+list[2]+"</font></td></tr>");
                        
                        
                     } // end of for
                     
                  } // end of success
                  
                  
                  
               }); // end of ajax
               
            }); // end of click
            
            
            $("#checkall").click(function(){
               if($("#checkall").prop("checked")){
                  
                  $(".checking").prop("checked", true)
                  
                  
                  
               }else{
                  
                  $(".checking").prop("checked", false)
                  
               }
               
               
               
            });
            
            
		$(document).on("click", "#applober", function(){
               
               if($(".sele").length != 0){
                  var name = $(".sele").children("td:eq(0)").text();
                    var si = $(".sele").children("td:eq(1)").text();
                    var deft = $(".sele").children("td:eq(2)").text();

               for(var i=0; i<$(".ss").length; i++) {
                  var n = $("#applovalt").find("tr:eq("+(i+1)+")").children("td:eq(1)").text();
                  if(n == name){
                  
                  return true;
                  }
               }
                    
				var line1 = $("#applovalt").find("tr:eq(1)").find("td:eq(1)").text();
				var line2 = $("#applovalt").find("tr:eq(2)").find("td:eq(1)").text();
				var line3 = $("#applovalt").find("tr:eq(3)").find("td:eq(1)").text();
				var line4 = $("#applovalt").find("tr:eq(4)").find("td:eq(1)").text();
				var line5 = $("#applovalt").find("tr:eq(5)").find("td:eq(1)").text();
                    
				if( line1 == "-"){
	                $("#applovalt").find("tr:eq(1)").find("td:eq(1)").text(name);
	                $("#applovalt").find("tr:eq(1)").find("td:eq(2)").text(si);
	                $("#applovalt").find("tr:eq(1)").find("td:eq(3)").text(deft);
	                $("#applovalt").find("tr:eq(1)").find("td:eq(4)").text("결재");
                       
                }else if(line2 == "-" ){
                       $("#applovalt").find("tr:eq(2)").find("td:eq(1)").text(name);
                       $("#applovalt").find("tr:eq(2)").find("td:eq(2)").text(si);
                       $("#applovalt").find("tr:eq(2)").find("td:eq(3)").text(deft);
                       $("#applovalt").find("tr:eq(2)").find("td:eq(4)").text("결재");
                       
                }else if(line3 == "-" ){
                   $("#applovalt").find("tr:eq(3)").find("td:eq(1)").text(name);
                   $("#applovalt").find("tr:eq(3)").find("td:eq(2)").text(si);
                   $("#applovalt").find("tr:eq(3)").find("td:eq(3)").text(deft);
                   $("#applovalt").find("tr:eq(3)").find("td:eq(4)").text("결재");
                   
                }else if(line4 == "-" ){
                   $("#applovalt").find("tr:eq(4)").find("td:eq(1)").text(name);
                   $("#applovalt").find("tr:eq(4)").find("td:eq(2)").text(si);
                   $("#applovalt").find("tr:eq(4)").find("td:eq(3)").text(deft);
                   $("#applovalt").find("tr:eq(4)").find("td:eq(4)").text("결재");
                   
                }else if(line5 == "-" ){
                   $("#applovalt").find("tr:eq(5)").find("td:eq(1)").text(name);
                   $("#applovalt").find("tr:eq(5)").find("td:eq(2)").text(si);
                   $("#applovalt").find("tr:eq(5)").find("td:eq(3)").text(deft);
                   $("#applovalt").find("tr:eq(5)").find("td:eq(4)").text("결재");       
                }
               }
		});
            
            $(document).on("click", ".hh", function(){
               $(".hh").removeClass("selec");
               $(this).toggleClass("selec");
            });
            
            $(document).on("click", ".ss", function(){
                  $(".ss").removeClass("sel");
                  $(this).toggleClass("sel");
               });
               
            $(document).on("click", ".qq", function(){
               $(".qq").removeClass("sele");
               $(this).toggleClass("sele");
            });

            
            $(document).on("click", "#delbtn", function(){
               if(($(".sel").length) == 0 && ($(".selec").length) == 0) {
                  
               }else if(($(".sel").length) != 0 && ($(".selec").length) == 0) {
               $(".sel").remove();
               $("#applovalt").append("<tr class='ss'><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td></tr>");
               
               $("#applovalt").find("tr:eq(1)").find("td:eq(0)").text("1");
               $("#applovalt").find("tr:eq(2)").find("td:eq(0)").text("2");
               $("#applovalt").find("tr:eq(3)").find("td:eq(0)").text("3");
               $("#applovalt").find("tr:eq(4)").find("td:eq(0)").text("4");
               $("#applovalt").find("tr:eq(5)").find("td:eq(0)").text("5");
               }else {
                  $(".selec").remove();
               }
            });
            
            // 참조자 집어넣는 펑션
            $(document).on('click', "#reference_btn", function(){
			   var name = $(".sele").children("td:eq(0)").text();
			   var si = $(".sele").children("td:eq(1)").text();
			   var dept = $(".sele").children("td:eq(2)").text();
				
			   if(name.length > 0){
				   var isDuplicate = false;
					
				   $(".hh").each(function() {
				      var n = $(this).children("td:eq(0)").text();
				      if (n === name) {
				         isDuplicate = true;
				         return false; // 중복된 이름을 찾았으므로 반복문을 종료합니다.
				      }
				   });
				
				   if (isDuplicate) {
				      alert("중복된 이름이 이미 존재합니다.");
				      return;
				   }
				
				   $("#t3").append("<tr class='hh'><td>"+name+"</td><td>"+si+"</td><td>"+dept+"</td></tr>");
				
				   
			   }else{
				   alert("원하는 사원을 선택하세요")
			   }
			   
            });   

            
            // 결재선 지정하는 펑션
            $(document).on("click", "#sangsin", function(){ 
            	
            	var name1 = $("#applovalt").find("tr:eq(1)").find("td:eq(1)").text();
            	var name2 = $("#applovalt").find("tr:eq(2)").find("td:eq(1)").text();
            	var name3 = $("#applovalt").find("tr:eq(3)").find("td:eq(1)").text();
            	var name4 = $("#applovalt").find("tr:eq(4)").find("td:eq(1)").text();
            	var name5 = $("#applovalt").find("tr:eq(5)").find("td:eq(1)").text();
            	
            	var position1 = $("#applovalt").find("tr:eq(1)").find("td:eq(2)").text();
            	var position2 = $("#applovalt").find("tr:eq(2)").find("td:eq(2)").text();
            	var position3 = $("#applovalt").find("tr:eq(3)").find("td:eq(2)").text();
            	var position4 = $("#applovalt").find("tr:eq(4)").find("td:eq(2)").text();
            	var position5 = $("#applovalt").find("tr:eq(5)").find("td:eq(2)").text();
            	
            	var dept1 = $("#applovalt").find("tr:eq(1)").find("td:eq(3)").text();
            	var dept2 = $("#applovalt").find("tr:eq(2)").find("td:eq(3)").text();
            	var dept3 = $("#applovalt").find("tr:eq(3)").find("td:eq(3)").text();
            	var dept4 = $("#applovalt").find("tr:eq(4)").find("td:eq(3)").text();
            	var dept5 = $("#applovalt").find("tr:eq(5)").find("td:eq(3)").text();
            	
            	var line1 = $("#applovalt").find("tr:eq(1)").find("td:eq(4)").text();
            	var line2 = $("#applovalt").find("tr:eq(2)").find("td:eq(4)").text();
            	var line3 = $("#applovalt").find("tr:eq(3)").find("td:eq(4)").text();
            	var line4 = $("#applovalt").find("tr:eq(4)").find("td:eq(4)").text();
            	var line5 = $("#applovalt").find("tr:eq(5)").find("td:eq(4)").text();
            	

            	$("#table1").find("tr:eq(1)").find("td:eq(1)").text(line1);
            	$("#table1").find("tr:eq(2)").find("td:eq(1)").text(line2);
            	$("#table1").find("tr:eq(3)").find("td:eq(1)").text(line3);
            	$("#table1").find("tr:eq(4)").find("td:eq(1)").text(line4);
            	$("#table1").find("tr:eq(5)").find("td:eq(1)").text(line5);
            	
            	
            	$("#table1").find("tr:eq(1)").find("td:eq(2)").text(name1 + " " + position1);
            	$("#table1").find("tr:eq(2)").find("td:eq(2)").text(name2 + " " + position2);
            	$("#table1").find("tr:eq(3)").find("td:eq(2)").text(name3 + " " + position3);
            	$("#table1").find("tr:eq(4)").find("td:eq(2)").text(name4 + " " + position4);
            	$("#table1").find("tr:eq(5)").find("td:eq(2)").text(name5 + " " + position5);
            	
            	
            	$("#table1").find("tr:eq(1)").find("td:eq(3)").text(dept1);
              	$("#table1").find("tr:eq(2)").find("td:eq(3)").text(dept2);
            	$("#table1").find("tr:eq(3)").find("td:eq(3)").text(dept3);
            	$("#table1").find("tr:eq(4)").find("td:eq(3)").text(dept4);
            	$("#table1").find("tr:eq(5)").find("td:eq(3)").text(dept5);
            	
            	var cham1 = "";
            	for(var i=1; i<$("#t3").find("tr").length; i++) {
            		for(var ii=0; ii<$("#t3").find("tr:eq(1)").find("td").length-1; ii++){
            			cham1 += $("#t3").find("tr:eq("+i+")").find("td:eq("+ii+")").text();
            		}
            		if(i != $("#t3").find("tr").length-1){
            			cham1 += ", ";
            		}
            	}
            	$("#cham1").find("tr:eq(0)").find("td:eq(0)").text(cham1);

            	
            	$("#approvalline").css({"visibility":"hidden"});
               														
            }); // end of sangsin function
            
      }); // end of ready
   </script>


</head>
<style type="text/css">
#t2 {
	width: 170px;
}

body {
	background: #fff;
}

.white {
	background: #fff;
	height: 10px;
	font: 10px;
}

.selec {
	background: #e2e2e2;
}

.sele {
	background: #e2e2e2;
}

.sel {
	background: #e2e2e2;
}

.abc {
	background: gray;
	padding: 0px;
	margin: 0px;
	border: 0px;
}

table {
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	border-collapse: collapse;
}

.right {
	float: right;
	margin-left: 10px;
}

td {
	border: 1px solid #000;
	text-align: center;
	width: 120px;
}

.tdn {
	border: none;
	color: white;
}

.dd {
	background: lightgray;
}

.container {
	display: flex;
}

.left-block {
	flex: 1;
	background: lightgray;
}

.right-block {
	flex: 3;
	margin-left: 10px;
}

li {
	list-style: none;
}

.select {
	margin: 5px 5px;
	background: white;
	width: 120px;
	height: 20%;
}

.gu {
	text-align: center;
	margin: auto;
}
</style>
<body>
	<div>
		<div class="container">
			<div class="left-block" style="width: 100px;">


				<aside class="side-bar">
					<div>
						<h2 style="text-align: center;">조직도</h2>
						<hr>
					</div>
					<ul id="jojic">

					</ul>
					<div id="div1">
						<h4 class="gu">구성원</h4>
						<hr>
						<table id="t2" class="gu">

							<tr>
								<td class='white'><font size='2'>이름 </font></td>
								<td class='white'><font size='2'>직책 </font></td>
								<td class='white'><font size='2'>부서 </font></td>
							</tr>

						</table>
					</div>
				</aside>
			</div>
			<div class="mid-block">
				<input id="applober" type="image" src="/final_goats/img/1.png"
					style="margin-top: 190px;"><br> <br> <br> <br>
				<input id="reference_btn" type="image" src="/final_goats/img/4.png"
					style="margin-top: 100px;"><br>
			</div>
			<div class="right-block">
				<h1 align="center">결재자</h1>
				<br>
				<hr>
				<h2></h2>
				<table id="applovalt" class="tt" style="width: 100%">
					<tr class="dd">
						<td class="tdn">순서</td>
						<td class="tdn">이름</td>
						<td class="tdn">직책</td>
						<td class="tdn">부서</td>
						<td class="tdn">결재선</td>
					</tr>
					<tr class="ss">
						<td>1</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<tr class="ss">
						<td>2</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<tr class="ss">
						<td>3</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<tr class="ss">
						<td>4</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<tr class="ss">
						<td>5</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
				</table>
				<br>

				<h2>참조자</h2>
				<table class="tt" style="width: 100%" id="t3">
					<tr class="dd">
						<td class="tdn" align="center">이름</td>
						<td class="tdn" align="center">직책</td>
						<td class="tdn" align="center">부서</td>
					</tr>

				</table>

				<br>
			</div>
		</div>

		<hr style="margin: 0px; padding: 0px;">
		<div
			style="background-color: lightgray; height: 30px; width: 100%; margin: 0px; padding: 0px;">
			<input type="button" class="right" id="delbtn" value="삭제"> <input
				type="button" class="right" id="sangsin" name="sangsin"
				value="결재선지정">

		</div>
	</div>
</body>
</html>