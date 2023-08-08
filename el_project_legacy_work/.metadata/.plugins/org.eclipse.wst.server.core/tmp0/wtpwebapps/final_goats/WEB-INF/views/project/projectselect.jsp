<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>  
<%@ page import="com.gt.s.common.FileUploadUtil" %>
<%@ page import="com.gt.s.kos.project.vo.GtProjectVO" %>
<%@ page import="com.gt.s.kos.account.vo.GtAccountVO" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	Logger log = LogManager.getLogger(this.getClass());
	log.info("projectselect.jsp");
	
	Object obj = request.getAttribute("aList");
	
	List<GtProjectVO> aList = (List<GtProjectVO>)obj;
	
	GtProjectVO pvo = aList.get(0);
	
	Object obj2 = request.getAttribute("aList2");
	
	List<GtAccountVO> aList2 = (List<GtAccountVO>)obj2;
	
	GtAccountVO gvo = aList2.get(0);
	
	Date now = new Date();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	String currentDate = dateFormat.format(now);
	
	log.info("여기는 aList.size() 입니다 " + aList.size());
	
	
%>  

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-1.11.0.min.js"
    ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <script>
      $(document).ready(function () {
    	  var ss = new moment();
        
       	  var formatteDate = ss.format('YYYY-MM-DD');
          var status = "";
		 	
          // 프로젝트 시작일 < 현재날짜 보다 
		
		  if(<%=pvo.getGpstartdate()%> <  <%=currentDate%>){
        	status = "개발";
					
        	
         		// 프로젝트 시작일 > 현재날짜
          }else if(<%=pvo.getGpstartdate()%> >  <%=currentDate%>){
          	
        	status = "프로젝트 시작";
        	
          }else if(<%=pvo.getGpstartdate()%> <  <%=currentDate%> && <%=pvo.getGpenddate()%> < <%=currentDate%> ){
        	
        	status = "개발완료";
          }

	      
		  $(".psei").append("<tr>" +
				  "<td>프로젝트 시작일</td>" +
				  "<td><%=pvo.getGpstartdate()%></td>" +
				  "</tr>" +
				  "<tr>" +
				  "<td>프로젝트 종료일</td>" +
				  "<td><%=pvo.getGpenddate()%></td>" +
				  "</tr>" +
				  "<tr>" +
				  "<td>프로젝트 진행상태</td>" +
				  "<td>" + status + "</td>" +
				  "</tr>" +
				  "<tr>" +
				  "<td>내용</td>" +
				  "<td><%=pvo.getGpnote()%></td>" +
				  "</tr>");


			
	         // end of if	
    	  
    	  
      }); // end of ready
    </script>
    <style>
      .container2 {
        display: flex;
      }
      .container h3 {
        margin: 0;
        padding: 10px 0;
        font-size: 18px;
        font-weight: bold;
      }
      .innercontainer {
      }
      .contents {
        display: flex;
        width : 100%;
      }
      .conn{
      background-color: white;
      width : 100%;
      margin: 10px;
      }
      
	.fire tr:first-child {
		background-color: #666666;
		color: #ffffff;
		font-weight: bold;
	}
	
	.fire td {
		border: 1px solid black;
		padding: 5px;
	}
    </style>
  </head>
  <body>
    <div class="container2" style="margin: 0">
      <div>
        <jsp:include page="../main/mainSide-bar.jsp" />
      </div>
      <div style="margin: 0; padding: 0; width: 100%">
        <div>
          <jsp:include page="../main/Top-bar.jsp"></jsp:include>
        </div>
        <div class="contents">
          <div style="margin-right:15px;">
            <div class="conn">
            	<br>
          		<table class="fire">
            	<tr>
            		<td>프로젝트ID</td>
            		<td><%=pvo.getGpnum() %></td>
            	</tr>
            	<tr>
            		<td>구분</td>
            		<td><%=pvo.getGpgubun() %></td>
            	</tr>
            	<tr>
            		<td>등록일자</td>
            		<td><%=pvo.getInsertdate() %></td>
            	</tr>
            	<tr>
            		<td>완료일자</td>
            		<td><%=pvo.getGpenddate() %></td>
            	</tr>
            	<tr>
            		<td>관리부서</td>
            		<td><%=pvo.getGptic() %></td>
            	</tr>
            	<tr>
            		<td>관리자(담당PM)</td>
            		<td><%=pvo.getGpticman() %></td>
            	</tr>
            	<tr>
            		<td>계약여부</td>
            		<td><%=gvo.getDeleteyn() %></td>
            	</tr>
            	<tr>
            		<td>계약 시작일</td>
            		<td><%=gvo.getStartdate() %></td>
            	</tr>
            	<tr>
            		<td>계약 종료일</td>
            		<td><%=gvo.getEnddate() %></td>
            	</tr>
            </table>
          </div>
          <div class="conn" >
          	<table class="fire">
            	<tr>
            		<td>계약처</td>
            		<td><%=gvo.getGaname() %></td>
            	</tr>
            	<tr>
            		<td>계약처 담당</td>
            		<td><%=gvo.getGaname() %></td>
            	</tr>
            </table>
          </div>
          </div>
          <div class="conn" style="">
          <br>
            <table class="fire psei">
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>


