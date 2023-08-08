<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection"%>

<%
   /********************************
전달해야 할 변수
********************************/
String url = null;
String str = null;

url = request.getParameter("url");
System.out.println("url >>> : " + url);

str = request.getParameter("str");
System.out.println("str >>> : " + str);

if (str != null && str.length() > 0) {
   str = str + "&";
   System.out.println("str + & >>>" + str);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My JSP Page</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<style type="text/css">
.custom-link {
   /* 필요한 스타일을 적용해주세요 */
   text-decoration: none; /* 링크에 밑줄 제거 */
   color: #000; /* 링크의 색상 설정 */
   /* 그 외 원하는 스타일을 추가로 적용할 수 있습니다 */
}

.number {
   display: inline-block;
   width: 30px;
   height: 30px;
   border: 1px solid #A4A4A4; /* 테두리에 1px 두께의 검정색 선 추가 */
   text-align: center;
   font-size: 18px;
   line-height: 30px;
   background-color: #848484;
   color: white;
}

.string {
   display: inline-block;
   width: 60px;
   height: 30px;
   border: 1px solid #A4A4A4; /* 테두리에 1px 두께의 검정색 선 추가 */
   text-align: center;
   font-size: 18px;
   line-height: 30px;
   background-color: #848484;
   color: white;
}

.othernumber {
   display: inline-block;
   width: 30px;
   height: 30px;
   border: 1px solid #A4A4A4; /* 테두리에 1px 두께의 검정색 선 추가 */
   text-align: center;
   font-size: 18px;
   line-height: 30px;
   background-color: #FFF;
   color: #848484;
}

.otherstring {
   display: inline-block;
   width: 60px;
   height: 30px;
   border: 1px solid #A4A4A4; /* 테두리에 1px 두께의 검정색 선 추가 */
   text-align: center;
   font-size: 18px;
   line-height: 30px;
   background-color: #FFF;
   color: #848484;
}
</style>
</head>
<body>
   <%
      /**********************************
   페이지 네비게이션 관련 변수
   ***********************************/
   // 한페이지에 보여질 게시물의 수
   int pageSize = 0;
   // 그룹의 크기
   int groupSize = 0; 
   // 전체 게시물의 개수
   int totalCount = 0;
   // 현재 페이지
   int curPage = 0;
   // 전체 페이지의 개수
   int pageCount = 0;

   if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize")); // 10
      System.out.println("pageSize >>> : " + pageSize);
   }

   if (request.getParameter("groupSize") != null) {
      groupSize = Integer.parseInt(request.getParameter("groupSize")); //5
      System.out.println("groupSize >>> : " + groupSize);
   }

   if (request.getParameter("curPage") != null) {
      curPage = Integer.parseInt(request.getParameter("curPage")); //1
      System.out.println("curPage >>> : " + curPage);
   }

   if (request.getParameter("totalCount") != null) {
      totalCount = Integer.parseInt(request.getParameter("totalCount"));//400
      System.out.println("totalCount >>> : " + totalCount);
   }

   // 전체게시물수와 페이지크기를 가지고 전체 페이지 개수를 계산함.
   // 소수점에 따라 계산상의 오류가 없도록 한것임.
   pageCount = (int) Math.ceil(totalCount / (groupSize + 0.0));
   System.out.println("pageCount >>> : " + pageCount);
   //(0/page)

   // 현재그룹 설정
   // 1-1/5
   int curGroup = (curPage - 1) / groupSize;
   System.out.println("curGroup >>> : " + curGroup);

   // 0*0
   int linkPage = curGroup * groupSize;
   System.out.println("linkPage >>> : " + linkPage);
   %>
   <p align="right">
      <%
         // 첫번째 그룹이 아닌경우
      if (curGroup > 0) {

         //boardSelectList.jsp?&curPage=1   
         //boardSelectList.jsp?&curPage=0
      %>
      <a href="<%=url%>?<%=str%>curPage=<%=linkPage%>"><span class="otherstring">이전</span></a>
      <%
         } else {
      %>
      <span class="string">이전</span>
      <%
         }

      // 다음 링크를 위해 증가시킴
      linkPage++;
      System.out.println("linkPage++ >>> : " + linkPage);
      //1

      int loopCount = groupSize;
      System.out.println("loopCount >>> : " + loopCount);
      //5

      // 그룹범위내에서 페이지 링크만듬.
      //5>0 && 1<=40
      while ((loopCount > 0) && (linkPage <= pageCount)) {
      //1==1
      if (linkPage == curPage) {
         System.out.println("그룹범위내에서 페이지 링크if");
         //linkPage :1
      %>
      <span class="number"><%=linkPage%></span>
      <%
         } else {
            System.out.println("그룹범위내에서 페이지 링크else");
      %>
      <a href="<%=url%>?<%=str%>curPage=<%=linkPage%>" id="custom-link"><span
         class="othernumber"><%=linkPage%></span></a>
      <%
         }
      linkPage++;
      loopCount--;
      }

      // 다음그룹이 있는 경우
      //      6         40
      if (linkPage <= pageCount) {
      System.out.println("다음그룹이 있는 경우 linkPage >>> : " + linkPage);

      //   boardSelectList.jsp?&curPage=6
      //   boardSelectList.jsp?&curPage=40
      %>
      <a href="<%=url%>?<%=str%>curPage=<%=linkPage%>"><span class="otherstring">다음</span></a>
      <%
         } else {
      System.out.println("다음그룹이 있는 경우 linkPage >>> : " + linkPage);
      System.out.println("다음그룹이 있는 경우_else");
      %>
      <span class="string">다음</span>
      <%
         }
      %>
   </p>

</body>
</html>