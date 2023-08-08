<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
          <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
          <script src="resources/js/common.js"></script>
      <script type="text/javascript">
      
         function logout(){
            location.href="logout.gos";
         }
         $(document).ready(function(){
            
         $(function(){
            // 현재 시간 
            function printTime(){
               let days = ["일", "월", "화", "수", "목", "금", "토"];
               let md = new Date();
               
               let yy = md.getFullYear();
               let mm = md.getMonth() + 1;
               let dd = md.getDate();
               let ii = md.getDay();
               let di = days[ii];
               let hh = md.getHours();
               let mi = md.getMinutes();
               let ss = md.getSeconds();
               
               let time =    yy + "년 " +
                        numpad(mm) + "월 " +
                        numpad(dd) + "일 " +
                        di + "요일 " +
                        numpad(hh.toString()) + ":" +
                        numpad(mi.toString()) + ":" +
                        numpad(ss.toString());
               document.getElementById("timer").innerHTML=time;
            }
            setInterval(printTime, 1000);
         });

      });
      </script>
      <style type="text/css">
      h2 {
        margin: 0;
        padding: 10px 0;
        text-align: center;
        color: #337ab7;
        }
        .topdiv{
/*       margin:0; */
      padding:0;
      }
      .topdiv{
           background-color: #fff;
           height:50px;
           min-width:100%;
      }
      
      .line{
         border:0.5px solid #F5F5F5;
         margin:0px; 0;
      }
      </style>
      
   </head>
   
   <body>
      <div class="topdiv">
      <div style="text-align:right;"></div>
      <div style="text-align:right;"><div style="padding: 15px 50px 10px 10px;"><span id="timer" style="padding: 0px 10px -2px 30px;"> </span></div>
         <a href="javascript:logout()" style="position: absolute; top: 0px; right:0px; height:50px;">
         <img src="resources/goats_icon/logout.png" style="width:30px; height:30px; margin: 10px;">
         </a>
      </div>
      </div>
     <div class="line"></div>
   </body>
</html>