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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
           if(data[i] === "대표이사"){
            $("#jojic").append("<li><div class='select' style='border:1px solid darkgray;'><span class='aas'><img src='resources/goats_icon/person.png' style='width:18px; height:18px; margin-left:5px; margin-right:5px; margin-top:5px;'></spna><span style='vertical-align:3px; margin-left:1px;'>" + data[i] + "</span></div></li>");           
           }else if(data[i] === "영업팀"){
            $("#jojic").append("<li><div class='select' style='border:1px solid darkgray;'><span class='aas'><img src='resources/goats_icon/member.png' style='width:18px; height:18px; margin-left:5px; margin-right:5px; margin-top:5px;'></spna><span style='vertical-align:3px; margin-left:5px;'>" + data[i] + "</span></div></li>");
           }else if(data[i] === "인사팀"){
            $("#jojic").append("<li><div class='select' style='border:1px solid darkgray;'><span class='aas'><img src='resources/goats_icon/member.png' style='width:18px; height:18px; margin-left:5px; margin-right:5px; margin-top:5px;'></spna><span style='vertical-align:3px; margin-left:5px;'>" + data[i] + "</span></div></li>");
           }else{
           $("#jojic").append("<li><div class='select' style='border:1px solid darkgray;'><span class='aas'><img src='resources/goats_icon/member.png' style='width:18px; height:18px; margin-left:5px; margin-right:5px; margin-top:5px;'></spna><span style='vertical-align:3px; margin-left:2px;'>" + data[i] + "</span></div></li>");
        }
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
                                  + "<td class=font12_1 style='width:34%; border:1px solid white; color:white; background-color:#A4A4A4;'>이름</td>" 
                                  + "<td class=font12_1 style='border:1px solid white; color:white; background-color:#A4A4A4;'>직급</td>" 
                                  + "<td class=font12_1 style='width:40%; border:1px solid white; color:white; background-color:#A4A4A4;'>부서</td>" 
                                 + "</tr>");
                  for (var i = 0 ; i < row.length -1 ; i++ ) {
                     var list = row[i].split(",");
                                           
                        if(list[1] === "대표이사" ){
                           $("#t2").append("<tr class='qq'><td class=font12>"+list[0]+"</td>"
                                    + "<td class=font10>"+list[1]+"</td>"
                                    + "<td class=font10 style='width:500px;'>"+list[2]+"</td></tr>");
                        }else{
                           $("#t2").append("<tr class='qq white font12_1'><td class=font12_1>"+list[0]+"</td>"
                                    + "<td class=font12_1>"+list[1]+"</td>"
                                    + "<td class=font12_1>"+list[2]+"</td></tr>");
                        }
                        
                     } // end of for
                     
                  } // end of success
                         
               }); // end of ajax
               
            }); // end of click           
            
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
                    
            var line1 = $("#applovalt").find("tr:eq(2)").find("td:eq(1)").text();
            var line2 = $("#applovalt").find("tr:eq(3)").find("td:eq(1)").text();
            var line3 = $("#applovalt").find("tr:eq(4)").find("td:eq(1)").text();
            var line4 = $("#applovalt").find("tr:eq(5)").find("td:eq(1)").text();
            var line5 = $("#applovalt").find("tr:eq(6)").find("td:eq(1)").text();
                    
            if( line1 == "-"){
                    $("#applovalt").find("tr:eq(2)").find("td:eq(1)").text(name);
                    $("#applovalt").find("tr:eq(2)").find("td:eq(2)").text(si);
                    $("#applovalt").find("tr:eq(2)").find("td:eq(3)").text(deft);
                    $("#applovalt").find("tr:eq(2)").find("td:eq(4)").text("결재");
                       
                }else if(line2 == "-" ){
                    $("#applovalt").find("tr:eq(3)").find("td:eq(1)").text(name);
                     $("#applovalt").find("tr:eq(3)").find("td:eq(2)").text(si);
                     $("#applovalt").find("tr:eq(3)").find("td:eq(3)").text(deft);
                     $("#applovalt").find("tr:eq(3)").find("td:eq(4)").text("결재");
                       
                }else if(line3 == "-" ){
                   $("#applovalt").find("tr:eq(4)").find("td:eq(1)").text(name);
                    $("#applovalt").find("tr:eq(4)").find("td:eq(2)").text(si);
                    $("#applovalt").find("tr:eq(4)").find("td:eq(3)").text(deft);
                    $("#applovalt").find("tr:eq(4)").find("td:eq(4)").text("결재");
                   
                }else if(line4 == "-" ){
                   $("#applovalt").find("tr:eq(5)").find("td:eq(1)").text(name);
                   $("#applovalt").find("tr:eq(5)").find("td:eq(2)").text(si);
                   $("#applovalt").find("tr:eq(5)").find("td:eq(3)").text(deft);
                   $("#applovalt").find("tr:eq(5)").find("td:eq(4)").text("결재");
                   
                }else if(line5 == "-" ){
                   $("#applovalt").find("tr:eq(6)").find("td:eq(1)").text(name);
                   $("#applovalt").find("tr:eq(6)").find("td:eq(2)").text(si);
                   $("#applovalt").find("tr:eq(6)").find("td:eq(3)").text(deft);
                   $("#applovalt").find("tr:eq(6)").find("td:eq(4)").text("결재");       
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
               $("#applovalt").append("<tr class='ss td'><td style='color:white; background-color:#A4A4A4; border:1px solid white; border-left:1px solid #A4A4A4'>-</td><td style='border:1px solid #A4A4A4'>-</td><td style='border:1px solid #A4A4A4'>-</td><td style='border:1px solid #A4A4A4'>-</td><td style='border:1px solid #A4A4A4'>-</td></tr>");
               
               $("#applovalt").find("tr:eq(2)").find("td:eq(0)").html("<span style='color:white;'><strong>1</strong></span>");
               $("#applovalt").find("tr:eq(3)").find("td:eq(0)").html("<strong>2</strong>");
               $("#applovalt").find("tr:eq(4)").find("td:eq(0)").html("<strong>3</strong>");
               $("#applovalt").find("tr:eq(5)").find("td:eq(0)").html("<strong>4</strong>");
               $("#applovalt").find("tr:eq(6)").find("td:eq(0)").html("<strong>5</strong>");
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
            
               $("#t3").append("<tr class='hh'><td class=chamjo style='width:31%; text-align:center'>"+name+"</td><td class=chamjo style='width:33%; text-align:center'>"+si+"</td><td class=chamjo style='width:36%; text-align:center'>"+dept+"</td></tr>");
            
               
            }else{
               alert("원하는 사원을 선택하세요")
            }
            
            });   

            
            // 결재선 지정하는 펑션
            $(document).on("click", "#sangsin", function(){ 
               
               var name1 = $("#applovalt").find("tr:eq(2)").find("td:eq(1)").text();
               var name2 = $("#applovalt").find("tr:eq(3)").find("td:eq(1)").text();
               var name3 = $("#applovalt").find("tr:eq(4)").find("td:eq(1)").text();
               var name4 = $("#applovalt").find("tr:eq(5)").find("td:eq(1)").text();
               var name5 = $("#applovalt").find("tr:eq(6)").find("td:eq(1)").text();
               
               var position1 = $("#applovalt").find("tr:eq(2)").find("td:eq(2)").text();
               var position2 = $("#applovalt").find("tr:eq(3)").find("td:eq(2)").text();
               var position3 = $("#applovalt").find("tr:eq(4)").find("td:eq(2)").text();
               var position4 = $("#applovalt").find("tr:eq(5)").find("td:eq(2)").text();
               var position5 = $("#applovalt").find("tr:eq(6)").find("td:eq(2)").text();
               
               var dept1 = $("#applovalt").find("tr:eq(2)").find("td:eq(3)").text();
               var dept2 = $("#applovalt").find("tr:eq(3)").find("td:eq(3)").text();
               var dept3 = $("#applovalt").find("tr:eq(4)").find("td:eq(3)").text();
               var dept4 = $("#applovalt").find("tr:eq(5)").find("td:eq(3)").text();
               var dept5 = $("#applovalt").find("tr:eq(6)").find("td:eq(3)").text();
               
               var line1 = $("#applovalt").find("tr:eq(2)").find("td:eq(4)").text();
               var line2 = $("#applovalt").find("tr:eq(3)").find("td:eq(4)").text();
               var line3 = $("#applovalt").find("tr:eq(4)").find("td:eq(4)").text();
               var line4 = $("#applovalt").find("tr:eq(5)").find("td:eq(4)").text();
               var line5 = $("#applovalt").find("tr:eq(6)").find("td:eq(4)").text();
               

               $("#table1").find("tr:eq(1)").find("td:eq(1)").text(line1);
               $("#table1").find("tr:eq(2)").find("td:eq(1)").text(line2);
               $("#table1").find("tr:eq(3)").find("td:eq(1)").text(line3);
               $("#table1").find("tr:eq(4)").find("td:eq(1)").text(line4);
               $("#table1").find("tr:eq(5)").find("td:eq(1)").text(line5);
               
               if(name1 == "-") {
                  $("#table1").find("tr:eq(1)").find("td:eq(2)").text(name1);
               }else{
               $("#table1").find("tr:eq(1)").find("td:eq(2)").text(name1 + " " + position1);
               }
               if(name2 == "-") {
                  $("#table1").find("tr:eq(2)").find("td:eq(2)").text(name2);
               }else{
               $("#table1").find("tr:eq(2)").find("td:eq(2)").text(name2 + " " + position2);
               }
               if(name3 == "-") {
                  $("#table1").find("tr:eq(3)").find("td:eq(2)").text(name3);
               }else{
               $("#table1").find("tr:eq(3)").find("td:eq(2)").text(name3 + " " + position3);
               }
               if(name4 == "-") {
                  $("#table1").find("tr:eq(4)").find("td:eq(2)").text(name4);
               }else{
                  $("#table1").find("tr:eq(4)").find("td:eq(2)").text(name4 + " " + position4);
               }
               if(name5 == "-") {
                  $("#table1").find("tr:eq(5)").find("td:eq(2)").text(name5);
               }else{
               $("#table1").find("tr:eq(5)").find("td:eq(2)").text(name5 + " " + position5);
               }
               
               $("#table1").find("tr:eq(1)").find("td:eq(3)").text(dept1);
               $("#table1").find("tr:eq(2)").find("td:eq(3)").text(dept2);
               $("#table1").find("tr:eq(3)").find("td:eq(3)").text(dept3);
               $("#table1").find("tr:eq(4)").find("td:eq(3)").text(dept4);
               $("#table1").find("tr:eq(5)").find("td:eq(3)").text(dept5);
               
               var cham1 = "";
               for(var i=1; i<$("#t3").find("tr").length; i++) {
                  for(var ii=0; ii<$("#t3").find("tr:eq(1)").find("td").length-1; ii++){ // 부서 삭제
                     cham1 += $("#t3").find("tr:eq("+(i+1)+")").find("td:eq("+ii+")").text() + " ";
                  }
                  if(i != $("#t3").find("tr").length-1){
                     cham1 += ", ";
                  }
               }
               $("#cham1").find("tr:eq(0)").find("td:eq(0)").text(cham1);
        
               $("#approval").css({"visibility":"hidden"});
               $("#hide_div").show();
                                                         
            }); // end of sangsin function

            
      }); // end of ready
   </script>
   
   </head>
   
   <style type="text/css">
   
      input[type="button"] {
         margin-top:7px;
         margin-right:10px;
         padding: 5px;
            font-size: 16px;
            border: 2px solid white;
            background-color: white;
            color: gray;
            cursor: pointer;
        }
   
      #t2 {
         width: 170px;
      }
      body {
         background: #fff;
      }
      
      .white {
         background: #fff;
         height: 3px;
         font-size: 12px;
         width: 220px;
      }
      .font10 {
         font-size: 10px;
         width:33%;
         border:1px solid #A4A4A4;
      }
      .font12 {
         font-size: 12px;
         width:300px;
         border:1px solid #A4A4A4;
      }
      .font12_1 {
         font-size: 12px;
         border:1px solid #A4A4A4;
      }
      
      .chamjo{
         border:1px solid #A4A4A4;
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
      
/*       table { */
/*          border-top: 1px solid black; */
/*          border-bottom: 1px solid black; */
/*          border-collapse: collapse; */
/*       } */
      
      .right {
         float: right;
         margin-left: 10px;
      }
      
/*       td { */
/*          border: 1px solid #000; */
/*          text-align: center; */
/*          width: 120px; */
/*       } */
      
      .tdn {
         border: none;
         color: white;
      }
      
      .dd {
         background: #A4A4A4;
      }
      
      .container {
         display: flex;
         width:1000px;
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
         width: 100px;
         height: 28px;
         
      }
      
      .gu {
         text-align: center;
         margin: auto;
      }
      
      .tbo {
         border:1px solid #A4A4A4;
      }
            .td {
         border:1px solid #A4A4A4;
      }
   
   </style>
   <body style="width:1000px;">
      <div style="background-color: gray; height: 50px; width: 1000px; margin: 0px; padding: 0px; line-height:300%;">
         <span style="font-size:25px; margin:20px; color:white;"><strong>결재선 지정</strong></span>
       </div>
     <div>
      <div class="container">
         <div class="left-block" style="width: 100px;">
            <aside class="side-bar">
               <br>
               <div style="border:1px solid gray; width:80%; margin-left:20px; background-color:white;">
                  <div style="width:100%; background-color:gray; align:center; height:30px;">
                     <span style="font-size:15px; color:white; line-height:200%; margin-left:10px;">
                     <img src='resources/goats_icon/mem.png' style='width:15px; height:15px;'>&nbsp;조직도</span>
                  </div>
                  <div style="background-color:white; width:80%;">
                          <ul id="jojic" style="padding-left:11px; margin-left:20px; background-color:white;">
                         </ul>  
                      </div>
                   </div>      
                   <div style="border:1px solid gray; width:80%; margin-left:20px; background-color:white;">
                  <div style="width:100%; background-color:gray; align:center; height:30px;">
                     <span style="font-size:15px; color:white; line-height:200%; margin-left:10px;">
                     <img src='resources/goats_icon/project_contractor.png' style='width:15px; height:15px;'>&nbsp;구성원</span>
                  </div>
                  <div style="width:100%; height:225px; overflow: auto; border:none;">
                        <table id="t2" class="gu" style=" margin-left:0px; width:100%; border:1px solid lightgray;">
                        <tr>
                           <td class='white' style="width:32%; border:1px solid white; color:white; background-color:#A4A4A4;">이름 </td>
                           <td class='white' style="border:1px solid white; color:white; background-color:#A4A4A4;">직책 </td>
                           <td class='white' style="width:40%; border:1px solid white; color:white; background-color:#A4A4A4;">부서</td>
                       </tr>
                  </table>
                     </div>
                   </div> 
            </aside>
         </div>
         <div class="mid-block" style="margin:150px auto">
            <input id="applober" type="image" src="resources/goats_icon/1.png" style="width:100px; height:55px"
               style="margin-top: 190px;"><br> <br> <br> <br><br> <br> <br> <br>
            <input id="reference_btn" type="image" src="resources/goats_icon/4.png" style="width:100px; height:55px"
               style="margin-top: 100px;"><br>
         </div>
         <div class="right-block">
            <br>
            <table id="applovalt" class="tt" style="width: 100%; text-align:center;">
               <tr>
                    <th style="background-color:gray; border:none;" colspan="2">
                    <span style="color:white; font-size:20px;">결재자</span>
                    </th>
               </tr>
               <tr class="tbo">
                  <td class="td" style="width:8%; background-color:#A4A4A4; border:1px solid white; border-left:1px solid #A4A4A4; color:white">순서</td>
                  <td class="td" style="width:23%; background-color:#A4A4A4; border:1px solid white; color:white">이름</td>
                  <td class="td" style="width:23%; background-color:#A4A4A4; border:1px solid white; color:white">직책</td>
                  <td class="td" style="width:23%; background-color:#A4A4A4; border:1px solid white; color:white">부서</td>
                  <td class="td" style="width:23%; background-color:#A4A4A4; border-left:1px solid white; border-top:1px solid white; border-bottom:1px solid white; border-rigth:1px solid #A4A4A4; color:white">결재선</td>
               </tr>
               <tr class="td ss">
                  <td class="td" style="color:white; background-color:#A4A4A4; border-bottom:1px solid white; border-right:1px solid white;"><strong>1</strong></td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
               </tr>
               <tr class="td ss">
                  <td class="td" style="color:white; background-color:#A4A4A4; border-bottom:1px solid white; border-right:1px solid white;"><strong>2</strong></td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
               </tr>
               <tr class="td ss">
                  <td class="td" style="color:white; background-color:#A4A4A4; border-bottom:1px solid white; border-right:1px solid white;"><strong>3</strong></td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
               </tr>
               <tr class="td ss">
                  <td class="td" style="color:white; background-color:#A4A4A4; border-bottom:1px solid white; border-right:1px solid white;"><strong>4</strong></td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
               </tr>
               <tr class="td ss">
                  <td class="td" style="color:white; background-color:#A4A4A4; border-right:1px solid white;"><strong>5</strong></td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
                  <td class="td">-</td>
               </tr>
            </table>
            <br>

            <table class="tt" style="width:100%; overflow: auto;" id="t3">            
               <tr>
                    <th style="background-color:gray; border:none; width:31%">
                    <span style="color:white; font-size:20px;">참조자</span>
                    </th>
               </tr>
               <tr class="dd">
                  <td class="tdn" align="center" style="border:1px solid white; border-left:1px solid #A4A4A4;">이름</td>
                  <td class="tdn" align="center" style="border:1px solid white; width:33%'">직책</td>
                  <td class="tdn" align="center" style="border:1px solid white; width:36%; border-right:1px solid #A4A4A4;">부서</td>
               </tr>
            </table>
            <br>
         </div>
      </div>
      <div style="background-color: gray; height: 50px; width: 1000px; margin: 0px; padding: 0px;">         
         <input type="button" class="right" id="sangsin" name="sangsin" value="결재선 반영">
         <input type="button" class="right" id="delbtn" value="삭제">
      </div>
   </div>
</body>
</html>