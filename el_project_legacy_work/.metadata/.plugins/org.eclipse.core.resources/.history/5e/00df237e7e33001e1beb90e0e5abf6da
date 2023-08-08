<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>GOATS | Log in</title>
        <link rel="stylesheet" href="https://webfontworld.github.io/kopus/KoPubWorldDotum.css">
        <link rel="stylesheet" href="resources/css/index.css">
      <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
      <script type="text/javascript">
      
         $(document).ready(function(){
            $("#loginBtn").click(function(){
               $("#loginForm").attr({
                  "action":"login.gos",
                  "method":"POST"
               }).submit();
            });
         });
         
      </script>
      <style type="text/css">
      
            #geid, #gepw, #loginBtn{
                font-family: 'KoPubWorldDotum';
            }
            
      </style>
   </head>

   <body>
      <div class="longin_box">
       <p class="aaa"><b>GOATS</b> Groupware</p>
       <br>
   
         <div class="login_container" layout:fragment="content"> <!-- login_container -->
            
            <div class="user_login_container">                  <!-- user_login_container -->
                  <!-- login form -->
                  
      
      
                     <form name="loginForm" id="loginForm">
                     <p>직원 전용 페이지입니다.</p>
                     <br>
      
                     <input class="user_login_input" type="text" name="geid" id="geid" placeholder="사용자 아이디" autofocus>
                     <input class="user_login_input" type="password" name="gepw" id="gepw" placeholder="비밀번호">
      
                     <button class="user_login_input" id="loginBtn">로그인</button>
                     <input type="hidden">
                  </form>
                  <!-- login from end-->
            </div>
         </div>
      </div>
      <a href="gtContractSelect.gos">test</a>
   </body>
</html>