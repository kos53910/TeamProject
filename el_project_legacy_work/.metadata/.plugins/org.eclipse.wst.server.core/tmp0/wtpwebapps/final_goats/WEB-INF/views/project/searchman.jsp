<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gt.s.kos.employee.vo.*" %>   
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>
<%
	Logger log = LogManager.getLogger(this.getClass());
	
%>  
<%
		Object obj = request.getAttribute("aList");
		
		List<GtEmployeeVO> aList = (List<GtEmployeeVO>)obj;
		
		log.info("aList.size() >>>> : " + aList.size())	;
%>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-1.11.0.min.js"
    ></script>
    <script type="text/javascript">
      $(document).ready(function () {
    	  
        $(document).on("click", ".co", function () {
          $(".co").removeClass(".co");
          $(this).toggleClass("se");
          
	        var name = $(this).children().eq(0).text();
	  		var dept = $(this).children().eq(1).text();
	   		var title = $(this).children().eq(2).text();
	   		var sabun = $(this).children().eq(3).text();
		
	  		window.opener.popdata(name, dept, title, sabun);
	  		
        });
        
        $("#search").keyup(function () {
          var key = $("#search").val();

          $.ajax({
            url: "searchman2.gos",
            data: { gename: key },
            async: false,
            success: function (data) {
              var row = data.split("/");
              $(".co").remove();

              for (var i = 0; i < row.length - 1; i++) {
                var list = row[i].split(",");

                $("#table").append(
                		  "<tr class='co'><td><font size='2'>" +
                		    list[0] +
                		    "</font></td>" +
                		    "<td><font size='2'>" +
                		    list[1] +
                		    "</font></td>" +
                		    "<td><font size='2'>" +
                		    list[2] +
                		    "</font></td>" +
                		    "<td><font size='2'>" +
                		    list[3] +
                		    "</font></td></tr>"
                		    
                );
              }
            },
          });
        });
      });
    </script>

    <style type="text/css">
      table {
        width: 100%;
        border-collapse: collapse;
      }

      table td {
        padding: 8px;
        border: 1px solid black;
      }

      table th {
        padding: 8px;
        background-color: lightgray;
        border: 1px solid black;
      }

      .se {
        background-color: lightgray;
      }
    </style>
  </head>
  <body>
    <div style="overflow:auto; height= 50px;">
      <table id="table" class="table">
        <th>사원명 검색 : <input type="search" id="search" /></th>
        <tr>
          <td>사원명</td>
          <td>부서</td>
          <td>자원등급</td>
          <td>사번</td>
        </tr>
      </table>
    </div>
    <div style="text-align: right">
      <input type="button" value="입력" id="send" name="send" style="width: 64px" />
  	  <input type="hidden">
    </div>
  </body>
</html>



 