<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
     
    function openFixedWindowSize(url, width, height) {
        var left = Math.ceil(( window.screen.width / 2) - (width/2));
        var top = Math.ceil(( window.screen.height / 2) - (height/2)); 
        var windowFeatures = 'width=' + width + ',height=' + height + ',left=' + left + ',top=' + top + ',resizable=no';
        window.open(url, '_blank', windowFeatures);
      }
    
    $(document).ready(function(){

       
       
    });
    
    </script>
    <style>
    
        html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      body {
        display: flex;
        flex-direction: column;
      }
      body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
      }
      .con {
        flex: 1;
      }

      .container2 {
        display: flex;
        height: 100px;
        width: 100%;
      }

      
      .container {
       display: flex; /* Flexbox를 적용하여 요소들을 가로로 배치합니다 */
       flex-direction: row; /* 요소들을 가로 방향으로 배치합니다 */
       justify-content: space-between; /* 각 요소를 좌우로 최대한 벌립니다 */
       height: 430.43; 
     }

      .container > div {
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        
      }

      .container h3 {
        margin: 0;
        padding: 10px 0;
        font-size: 18px;
        font-weight: bold;
      }

      .draft_insert {
        height: 200px;
        width: 100%;
      }

      .alert table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 10px;
      }

      .alert th,
      .alert td {
        padding: 10px;
        text-align: left;
      }

      .alert th {
        background-color: #f0f0f0;
      }

      .work {
        height: 300px;
      }
      
      #maindiv{
         width:100%;
         height:100%;
      }
      table {
      border-collapse: collapse;
        
      }

     td, th {
        border-color: #FFF;
        background-color: #FFF;
     }

    </style>
  </head>
  <body>
    <div class="container2" style="margin: 0; height:100%;">
      <div style="height:100%; max-height:970px;">
         <jsp:include page="../main/mainSide-bar.jsp" />
      </div>
         <div style="margin: 0; padding: 0; width:100%;">
          <jsp:include page="../main/Top-bar.jsp"></jsp:include>
      <div>
         <br>
         　<img src="resources/goats_icon/home.png" alt="home" width="20" height="20"> Home > <span style="color: #337ab7;"><b>전자결재</b></span>
      <table style="margin:15px; width:1300px;">
        <tr>
          <th style="height:40px; border-left:2px solid #337ab7; border-top:2px solid #337ab7; text-align:right;"><span style="color: #337ab7; font-size:20px; border-left: #337ab7;"><b>기안서</b></span></th>
          <th style="height:40px; border-top:2px solid #337ab7; border-right:2px solid #337ab7; text-align:left;"><span style="color: #337ab7; font-size:20px; border-left: #337ab7;"><b>&nbsp;양식</b></span></th>
        </tr>
        <tr>
           <td style="height:50px; border-left:2px solid #337ab7;"></td>
          <td></td>
          <td style="height:20px; border-top:2px solid #337ab7;"></td>
          <td style="height:20px; border-top:2px solid #337ab7;"></td>
          <td style="height:20px; border-top:2px solid #337ab7;"></td>
          <td style="height:20px; border-top:2px solid #337ab7;"></td>
          <td style="height:20px; border-top:2px solid #337ab7;"></td>
          <td width="50px" style="height:20px; border-top:2px solid #337ab7; border-right:2px solid #337ab7;"></td>
        </tr>
        <tr>
           <td width="12%" style="border-left:2px solid #337ab7;"></td>
          <td style="text-align:center;" width="12%"><a href="#" onclick="openFixedWindowSize('gtContractInsertForm', 1033, 600)"><img src="resources/goats_icon/Draft.png" width="60" height="60"></a></td>
          <td style="text-align:center;" width="12%"><a href="#" onclick="openFixedWindowSize('draftInsertForm.gos', 1033, 600)"><img src="resources/goats_icon/Draft.png" width="60" height="60"></a></td>
          <td style="text-align:center;" width="12%"><a href="#" onclick="openFixedWindowSize('gtBusinessInsertForm.gos', 1033, 600)"><img src="resources/goats_icon/Draft.png" width="60" height="60"></a></td>
          <td style="text-align:center;" width="12%"><a href="#" onclick="openFixedWindowSize('gtVacationInsertForm.gos', 1033, 600)"><img src="resources/goats_icon/Draft.png" width="60" height="60"></a></td>
          <td style="text-align:center;" width="12%"><a href="#" onclick="openFixedWindowSize('spendInsertForm.gos', 1033, 600)"><img src="resources/goats_icon/Draft.png" width="60" height="60"></a></td> 
          <td style="text-align:center;" width="12%"><a href="#" onclick="openFixedWindowSize('resignationInsertForm.gos', 1033, 600)"><img src="resources/goats_icon/Draft.png" width="60" height="60"></a></td>
          <td style="height:20px; border-right:2px solid #337ab7; text-align:center;"></td>
        </tr>
        <tr>
           <td style="height:20px; border-left:2px solid #337ab7;"></td>
          <td style="text-align:center; height:20px; font-size:15px"><b>기안서(계약)</b></td>
          <td style="text-align:center; font-size:15px"><b>기안서</b></td>
          <td style="text-align:center; font-size:15px"><b>출장계획서</b></td>
          <td style="text-align:center; font-size:15px"><b>휴가신청서</b></td>
          <td style="text-align:center; font-size:15px"><b>지출결의서</b></td>
          <td style="text-align:center; font-size:15px;"><b>사직서</b></td>
          <td style="border-right:2px solid #337ab7; height:20px;"></td>
        </tr>
        
        <tr>
          <td style="height:20px; border-bottom:2px solid #337ab7; border-left:2px solid #337ab7;"></td>
          <td style="height:20px; border-bottom:2px solid #337ab7;"></td>
          <td style="height:20px; border-bottom:2px solid #337ab7;"></td>
          <td style="height:20px; border-bottom:2px solid #337ab7;"></td>
          <td style="height:20px; border-bottom:2px solid #337ab7;"></td>
          <td style="height:20px; border-bottom:2px solid #337ab7;"></td>
          <td style="height:20px; border-bottom:2px solid #337ab7;"></td>
          <td style="height:50px; border-bottom:2px solid #337ab7; border-right:2px solid #337ab7;"></td>
        </tr>
      </table>    
      </div>
      </div>
    </div>

  </body>
</html>