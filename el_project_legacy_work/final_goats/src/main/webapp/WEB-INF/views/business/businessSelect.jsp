<%@ page import="com.gt.s.common.CodeUtil"%>
<%@ page import="org.apache.log4j.LogManager"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.gt.s.kos.business.vo.GtBusinessVO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
      <script type="text/javascript" src="resources/js/common.js"></script>
       <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<% 
   Logger log = LogManager.getLogger(this.getClass());
   
   Object obj = request.getAttribute("buvo");
   GtBusinessVO buvo = (GtBusinessVO) obj;
   String app = buvo.getApprover();
   String count = buvo.getCount();
   String s = CodeUtil.edsmjeoncheck(app, Integer.parseInt(count));
   
   log.info("결재선 >>>> : " + buvo.getApprover());
   log.info("비용1 >>>> : " + buvo.getGbtprice1());
   log.info("비용2 >>>> : " + buvo.getGbtprice2());
   log.info("비용3 >>>> : " + buvo.getGbtprice3());
   log.info("비용4 >>>> : " + buvo.getGbtprice4());
   log.info("비용5 >>>> : " + buvo.getGbtprice5());
   log.info("부서 >>>> : " + buvo.getDept());
   log.info("결제 >>>> : " + buvo.getProval());
   
%>
<script type="text/javascript">

   $(document).ready(function(){
      
      var totalprice = "<%=buvo.getGbttotalprice() %>";
      var price1 = "<%= buvo.getGbtprice1()%>";
      var price2 = "<%= buvo.getGbtprice2()%>";
      var price3 = "<%= buvo.getGbtprice3()%>";
      var price4 = "<%= buvo.getGbtprice4()%>";
      var price5 = "<%= buvo.getGbtprice5()%>";
      
      var price1_ = price1.split(",");
      var price2_ = price2.split(",");
      var price3_ = price3.split(",");
      var price4_ = price4.split(",");
      var price5_ = price5.split(",");
      
      $("#gbtprice1").text(price(price1_[0]));
      $("#gbtprice2").text(price(price2_[0]));
      $("#gbtprice3").text(price(price3_[0]));
      $("#gbtprice4").text(price(price4_[0]));
      $("#gbtprice5").text(price(price5_[0]));
      
      if(price1_[0] != "00"){
          $("#bupricetable").find("tr:eq(2)").find("td:eq(2)").text(price1_[1]);
          $("#bupricetable").find("tr:eq(2)").find("td:eq(3)").text(price1_[2]);
          $("#bupricetable").find("tr:eq(2)").find("td:eq(4)").text(price1_[3]);
          $("#bupricetable").find("tr:eq(2)").find("td:eq(5)").text(price1_[4]);
      }else{
          $("#bupricetable").find("tr:eq(2)").find("td:eq(1)").text("");
      }
      
      if(price2_[0] != "00"){
          $("#bupricetable").find("tr:eq(3)").find("td:eq(2)").text(price2_[1]);
          $("#bupricetable").find("tr:eq(3)").find("td:eq(3)").text(price2_[2]);
          $("#bupricetable").find("tr:eq(3)").find("td:eq(4)").text(price2_[3]);
          $("#bupricetable").find("tr:eq(3)").find("td:eq(5)").text(price2_[4]);
      }else{
          $("#bupricetable").find("tr:eq(3)").find("td:eq(1)").text("");
      }
      
      if(price3_[0] != "00"){
          $("#bupricetable").find("tr:eq(4)").find("td:eq(2)").text(price3_[1]);
          $("#bupricetable").find("tr:eq(4)").find("td:eq(3)").text(price3_[2]);
          $("#bupricetable").find("tr:eq(4)").find("td:eq(4)").text(price3_[3]);
          $("#bupricetable").find("tr:eq(4)").find("td:eq(5)").text(price3_[4]);
      }else{
          $("#bupricetable").find("tr:eq(4)").find("td:eq(1)").text("");
      }
      
      if(price4_[0] != "00"){
          $("#bupricetable").find("tr:eq(5)").find("td:eq(2)").text(price4_[1]);
          $("#bupricetable").find("tr:eq(5)").find("td:eq(3)").text(price4_[2]);
          $("#bupricetable").find("tr:eq(5)").find("td:eq(4)").text(price4_[3]);
          $("#bupricetable").find("tr:eq(5)").find("td:eq(5)").text(price4_[4]);
      }else{
          $("#bupricetable").find("tr:eq(5)").find("td:eq(1)").text("");
      }
      
      if(price5_[0] != "00"){
          $("#bupricetable").find("tr:eq(6)").find("td:eq(2)").text(price5_[1]);
          $("#bupricetable").find("tr:eq(6)").find("td:eq(3)").text(price5_[2]);
          $("#bupricetable").find("tr:eq(6)").find("td:eq(4)").text(price5_[3]);
          $("#bupricetable").find("tr:eq(6)").find("td:eq(5)").text(price5_[4]);
      }else{
          $("#bupricetable").find("tr:eq(6)").find("td:eq(1)").text("");
      }
      
      var app = "<%=buvo.getApprover()%>";
      var dept = "<%=buvo.getDept()%>";
      var pro = "<%=buvo.getProval()%>";
      var appcount = "<%=buvo.getCount()%>";
            
      var app_ = app.split("/");
      var dept_ = dept.split("/");
      
      if(pro != 'null'){
         var pro_ = pro.split("/");
      }else {
         var pro_ = "";
      }
      
      var s = "<%=s%>";
      var gbtstart = "<%=buvo.getGbtstart()%>";
      var gbtend = "<%=buvo.getGbtend()%>";
      
      $("#gbttotalprice_1").text(comma(totalprice) + "원");
      
      $("#gbtstart_end").text(gbtstart + " ~ " + gbtend);      
      
      function price(pri){
         
         if(pri == "01"){
            pri = "교통비";
         }else if(pri == "02"){
            pri = "식비"
         }else if(pri == "03"){
            pri = "접대비"
         }else if(pri == "04"){
            pri = "기타"
         }else{
            pri =" "
         }
         
         return pri;
      }

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
      
      var num = "<%= buvo.getGbtnum()%>";

      $.ajax({
         url: "busineesfileDownloadList.gos",
         type:"GET",
         data : { "gbtnum" : num},
         success : whens
      });
      
      function whens(d){
         var filename = d.split(",");
         for(var i=0; i < filename.length-1; i++){
            $("#table3").find("tr:eq(0)").find("td:eq(0)")
            .append("<a href='businessfileDownload?file="+filename[i]+"&num="
            +num+"' target='_blank'>"+filename[i]+"</a><br>");
         }
      }
      
   });


</script>
<style type="text/css">
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
             

</style>
</head>
<body>
<form id="gbtform"> 
      <h2 align="center">출장계획서</h2>
      <br>
      <table>
         <tr>
            <th width="120px">문서번호</th><td width="230px" id="gbtnum1"><%= buvo.getGbtnum() %>
         </td>
            <th width="120px">보안구분</th><td width="230px">비공개 </td>
            <th width="120px">보존연한</th><td width="230px">5년</td>
         </tr>
         <tr>
            <th width="100px">작성자</th><td width="230px" id="writer1"><%= buvo.getWriter() %></td>
            <th width="120px">작성일자</th><td width="230px" id="writeday"><%= buvo.getInsertdate() %></td>
            <th width="120px">대결자</th><td width="230px"  id="decianother"><%= buvo.getDecianother()%></td>
         </tr>
      </table>
      <br>
      <table id="table1">
         <tr>
            <th width="50px">순서</th>
            <th width="80px">구분</th>
            <th width="170px">결재자</th>
            <th width="170px">부서</th>
            <th width="80px">상태</th>
            <th width="100px">결재일</th>
            <th width="350px">결재의견</th>
         </tr>
         <tr>
            <td align="center">1</td>
            <td id="snag1"></td>
            <td id="hu1"></td>
            <td id="dept1"></td>
            <td id="curr1"></td>
            <td ></td>
            <td ></td>
         </tr>
         <tr>
            <td align="center">2</td>
            <td id="snag2"></td>
            <td id="hu2"></td>
            <td id="dept2"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
         <tr>
            <td align="center">3</td>
            <td id="snag3"></td>
            <td id="hu3"></td>
            <td id="dept3"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
         <tr>
            <td align="center">4</td>
            <td id="snag4"></td>
            <td id="hu4"></td>
            <td id="dept4"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
         <tr>
            <td align="center">5</td>
            <td id="snag5"></td>
            <td id="hu5"></td>
            <td id="dept5"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
      </table>
      <br>
      <table id="cham1">
         <tr>
            <th width="150px" >참　　조</th>
            <% if(buvo.getReference() == null) {
            	buvo.setReference(" ");
            } %>
            <td id="reference_1" style="text-align:center;"><%= buvo.getReference() %></td>
         </tr>
      </table>
      <br>
      <table>
         <tr>
            <th width="150px">제　　목</th>
            <td><%=buvo.getGbtname()%></td> <!-- 제목 -->
         </tr>
      </table>
      <br>
      <table>
            <tr>
               <th width="15%">프로젝트</th>
               <td><div align="center"><%= buvo.getGpnum() %></div></td>
            </tr>
      </table>
      <br>
      <table>
         <tr>
            <th width="15%">시행일자</th>
            <td style="align:left;" id="gbtstart_end"></td> <!-- 종료일 -->
         </tr>
      </table>
      <br>
      <table id="bupricetable">
         <tr>
         <th width="50px"></th>
         <th colspan="7"style="text-align:center; width:950px;"> 비  용 </th>
         </tr>
         <tr>
            <th width="50px"></th>
            <th width="100px">구분</th>
            <th width="100px">장소</th>
            <th width="100px">예상금액</th>
            <th width="400px">상세내용</th>
            <th width="70px">기타</th>
       </tr>
         <tr>
            <td align="center">1</td>
            <td align="center" id="gbtprice1"></td>
            <td align="center"></td> <!-- 장소 -->
           <td align="center"></td> <!-- 예상금액 -->
            <td align="center"></td> <!-- 내용 -->
            <td align="center"></td> <!-- 기타 -->
         </tr>
         <tr>
            <td align="center">2</td>
            <td align="center" id="gbtprice2"></td>
            <td align="center"></td>
           <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>
         </tr>
                  <tr>
            <td align="center">3</td>
            <td align="center" id="gbtprice3"></td>
            <td align="center"></td>
           <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>
         </tr>
         <tr>
            <td align="center">4</td>
            <td align="center" id="gbtprice4"></td>
            <td align="center"></td>
           <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>
         </tr>
         <tr>
            <td align="center">5</td>
            <td align="center" id="gbtprice5"></td>
            <td align="center"></td>
           <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>
         </tr>
      </table>
        <div id="aaa">
         </div>
      <br>
      <table>
         <tr>
            <th width="150px">예상 금액 합계</th><!--비용 합계 -->
            <td id="gbttotalprice_1" style="text-align:right;"></td>
         </tr>
         </table>
         <br>
         </form> 
         <form id="gbtfile_form">
               <table id="table3">
         <tr>
            <th width="150px">첨부 파일</th>
            <td></td>
         </tr>
         </table>
         </form>

</body>
</html>