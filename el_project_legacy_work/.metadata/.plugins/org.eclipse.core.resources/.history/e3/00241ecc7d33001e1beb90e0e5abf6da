<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import='com.gt.s.kos.draft.vo.GtDraftVO' %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <% request.setCharacterEncoding("UTF-8");%>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>

      .container2 {
        display: flex;
      }

/* //////////////////////////////////////////////// */
/* ///////////////////메인 css/////////////////////// */
/* //////////////////////////////////////////////// */
.basic_i01 {
	margin: 10px;
	width: 100%;
	background-color: #fff;
}
/* 1번째 .content의 2번째 .section에 적용 */
.content_i01:nth-of-type(1)>.section_i01:nth-of-type(2) {
	display: flex;
}
/* 1~2의 .article 적용 */
.article_i01:nth-of-type(-n+2) {
	width: 50%;
}
/* 2번째 .article 적용 */
.article_i01:nth-of-type(2) {
	text-align: right;
}
/* 테이블 기본설정 */
.content_i01 > table{
	width:100%;
	text-align: center;
}

 .content_i01 > table,td,tr{
	border: 1px solid #aaa;
	border-spacing: 0;
	border-collapse: collapse;
}
/* 마지막에서 1번째 .content */
.content_i01:nth-last-of-type(1) {
	text-align: right;
}

.wrapper_i01:first-of-type {
	display: flex;
	justify-content: space-between;
}

.wrapper_i01:last-of-type {
	margin: 10px auto 0 auto;
	padding: 0 10px 0 10px;
}
.section_i01  img {
	width: 15px;
	height: 15px;
}
 
 
/* 23.07.24 검색기능 input 추가 */
.section_i01 {display:flex;justify-content: space-between;align-items: center;    margin-bottom: 10px;}
.section_i01 .selectArea input{border: 1px solid #e8e8e8;border-radius: 5px;height: 30px;padding-left: 5px;outline:none;}
.section_i01 .selectArea button{border-radius: 5px;border: 1px solid #e8e8e8;width: 40px;height: 30px;}
.section_i01 .selectArea select{outline: none;height: 30px;border: 1px solid #e8e8e8;border-radius: 5px;}
.spaceRight{margin-right:10px;}


.content_01:nth-child(2) > span {
	color: blue;
}
.content_01:nth-child(1) > span {
	margin: 10px;
	font-size: 20px;
	font-weight: bold;
}
.basic_i01 {
	border: 1px solid #aaa;
	width: 95%;
}

	  
</style>
<script>
	$(function(){
		performSearch();
	})

  function updateTable(data) {
      var table = $("#dataBody");
      table.empty(); // Clear existing content

      $.each(data, function(index, item) {
         var row = $("<tr>");
         row.append($("<td>").text(item.genum));
         row.append($("<td>").text(item.gedept));
         row.append($("<td>").text(item.title));
         row.append($("<td>").text(item.gename));
         row.append($("<td>").text(item.geid));
         row.append($("<td>").text(item.geemail));
         row.append($("<td>").text(item.gehp));

         table.append(row);
      });
   }
  
  function performSearch() {
	  console.log("search starts")
      let searchGename = $("#searchGename").val();
	  let searchGedept = $("#searchGedept").val();
	 
	  
	  let dataToSend = {
		         gename: searchGename,
		         gedept: searchGedept
		      };
	  
      $.ajax({
         type: "GET",
         url : "gtOrganizationSelectAll2.gos",
         data: dataToSend,
         success: function(data) {
        	console.log(data)
            updateTable(data.aList); // 기존 controller > rest방식으로 변경  json직렬화까지 해놓음
         },
         error: function() {
            alert("Error occurred during search.");
         }
      });
   }
</script>
  </head>
  <body>
    <div class="container2">
		<div>
			<jsp:include page="../main/mainSide-bar.jsp" />
		</div>
     	 <div style="margin: 0; padding: 0; width:100%;">
       		<jsp:include page="../main/Top-bar.jsp"></jsp:include>
        <br>
<!--         //////////////////////////////////////////////////////////////////////////// -->
<!--         //////////////////////////////////////////////////////////////////////////// -->
<!--         //////////////////////////////////////////////////////////////////////////// -->

     
			<div class="basic_i01">
				<div class="wrapper_i01">
					<div class="content_01">
						<span>조직도</span>
					</div>
					<div class="content_01 spaceRight">
						<span>Home</span> / 조직도 
					</div>
				</div>
				<div class="wrapper_i01">
					<div class="content_i01">
						<div class="section_i01">
						<div>
							<img src="\resources\goats_icon\my.png" alt="img"> <span>조직도 인원 현황</span>
						</div>
						<div class="selectArea">
							<select id="searchGedept" class=""> <!-- 구분 -->
					      		<option value="">-전체-</option>
					      		<option value="인사팀">인사팀</option>
					      		<option value="개발1팀">개발1팀</option>
					      		<option value="영업팀">영업팀</option>
					      		<option value="개발2팀">개발2팀</option>
					      		<option value="개발3팀">개발3팀</option>
					      		<option value="대표이사">대표이사</option>
					      	</select>
							<input type="text" id="searchGename" placeholder="이름입력">
							<button onclick="performSearch()">검색</button>
						</div>
						</div>
					</div>
					<div class="content_i01" style='overflow-x: hidden; height: 728px;'>
						<table >
							<!-- js로 오름, 내림 처리 -->
							<tr>
								<td>사번</td>
								<td>부서</td>
								<td>직급</td>
								<td>이름</td>
								<td>아이디</td>
								<td>메일</td>
								<td>연락처</td>
							</tr>
							
							<tbody id="dataBody">
								<c:forEach var="list" items="${aList}">
								   <tr>
								      <td>${list.genum}</td>
								      <td>${list.gedept}</td>
								      <td>${list.title}</td>
								      <td>${list.gename}</td>
									  <td>${list.geid}</td>
									  <td>${list.geemail}</td>
									  <td>${list.gehp}</td>
								   </tr>
								</c:forEach>
							</tbody>
						</table>
						<br>
				</div>
			</div>
		</div>                  
      </div>
    </div>
    <br>
  </body>
</html>
