<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8");%>
<%
   Logger log = LogManager.getLogger(this.getClass());
   Date now = new Date();
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
   String currentDate = dateFormat.format(now);
   String gsname = (String) request.getAttribute("gsname");
   String genum = (String) request.getAttribute("genum");
%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Insert title here</title>
          <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
          <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
          <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
          <style type="text/css">
          .left-align {
            text-align: left;
            }
            .button-container {
               text-align: right;
             }          
             .initial-size {
                 min-height: 200px; 
                 width : 1000px;
             }
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
                  align: left;
                }

      #approval{
                 visibility: hidden;
                 position: absolute;
                 background-color:#fff;
                 width:100%;
                 height:100%;
                 margin:auto;
           }
      </style>

      <script type="text/javascript">
      
          var currentDate = new Date();
          var formattedDate = currentDate.getFullYear() + '년 ' + (currentDate.getMonth() + 1) + '월 ' + currentDate.getDate() + '일';
      
         $(document).ready(function(){
            
            var gsname = "<%=gsname%>";
            $("#gsname1").val(gsname);
            
            var genum = "<%=genum%>";
            $("#genum1").val(genum);
            
            $.ajax({
            url : "DraftChanbun.gos",
            success:function(res){

               var gdrnum = res;
                                   
               $("#gdrnum1").text(gdrnum);
               $("#gdrnum").val(gdrnum);

            },
            error:function(e){
               console.log(e.responseText)
            }
            
         });
            
            $(document).on("click", "#gdrsign", function(){
               
               if($(this).prop('checked')){          
                  //$('input[type="checkbox"][name="mnum"]').prop('checked',false);
                  $('.gdrsign').prop('checked',false);
                  $(this).prop('checked',true);
               }
            });
            
            $(document).on("click", "#gdrcontract", function(){
               
               if($(this).prop('checked')){
                  //$('input[type="checkbox"][name="mnum"]').prop('checked',false);
                  $('.gdrcontract').prop('checked',false);
                  $(this).prop('checked',true);
               }
            });
            
            $(document).on("click", "#sbtn", function(){
                         
                 var hu1 = $("#hu1").text()
              var hu2 = $("#hu2").text()
              var hu3 = $("#hu3").text()
              var hu4 = $("#hu4").text()
              var hu5 = $("#hu5").text()
              
              var reference1 = $("#reference1").text();
             
              $("#hu1_1").val(hu1);
              $("#hu1_2").val(hu2);
              $("#hu1_3").val(hu3);
              $("#hu1_4").val(hu4);
              $("#hu1_5").val(hu5);

              var du1 = $("#du1").text()
              var du2 = $("#du2").text()
              var du3 = $("#du3").text()
              var du4 = $("#du4").text()
              var du5 = $("#du5").text()
              
               $("#du1_1").val(du1);
              $("#du1_2").val(du2);
              $("#du1_3").val(du3);
              $("#du1_4").val(du4);
              $("#du1_5").val(du5);
   
              $("#writer").val(gsname);
              $("#genum").val(genum);       
              $("#reference").val(reference1);
              
                var a = $('.ql-editor').html();   
                var b =$("#quill_html").val(a);
                  
                var cc = $("#cham1").find("tr:eq(0)").find("td:eq(0)").text();
                 var aa = cc.replaceAll(", ", ",");
                  
              $("#gdrapprover").val(aa);
                
                 let dataParam = $("#draftFormAll").serialize();
                 
                 $.ajax({
                  url : "draftInsert.gos",
                  data : dataParam,
                  success : function(res){
                     if(res == "OK"){
                         $("#gdr_file_form").attr({
                            "action" : "draftInsertFile.gos",
                            "method" : "POST",
                            "enctype":"multipart/form-data"
                         }).submit();
                     }else{
                        alert("입력 실패");
                     }
                  },
                  error : function(e){
                     console.log(e.responseText);
                  }
               });
               
            });
            
           $(document).on("click", "#gbtn", function(){
            $("#approval").css({"visibility":"visible"});
            $("#hide_div").hide();
         });
            
         });
      
      </script>
      
   </head>

   <body>
     <div id="approval">
            <jsp:include page="../approvalline/select.jsp"></jsp:include>
     </div>
     <div id="hide_div">
        <form name="draftFormAll" id="draftFormAll">
    <div>
        <input type="hidden" id="gdrapprover" name="gdrapprover" value="">
         <input type="hidden" id="gdrdept" name="gdrdept" value="">
     </div>
        <div class="button-container">
         <button type="button" id="gbtn">결재선지정</button>
         <button type="button" id="sbtn">상신</button>
         <button type="button" id="cbtn">취소</button>
        </div>
     
     <h2 align="center">기안서(일반)</h2>
     <br>
     <table style="text-align:center">
         <tr>
            <th width="120px">문서번호</th><td width="230px" id="gdrnum1"></td>
           <th width="120px">보안구분</th><td width="230px">비공개</td>
            <th width="120px">보존연한</th><td width="230px">5년</td>
         </tr>
         <tr>
            <th width="10%">작성자</th><td width="23%" id="gsname1"><%=gsname%></td>
            <th width="10%">작성일자</th><td colspan="3"><%= currentDate %></td>
         </tr>
      </table>
      <br>
      <table style="text-align:center" id="table1">
         <tr>
            <th width="5%">순서</th>
            <th width="8%">구분</th>
            <th width="17%">결재자</th>
            <th width="17%">부서</th>
            <th width="8%">상태</th>
            <th width="10%">결재일</th>
            <th width="35%">결재의견</th>
         </tr>
         <tr>
            <td>1</td>
            <td></td>
            <td id="hu1"></td>
            <td id="du1"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
         <tr>
            <td>2</td>
            <td></td>
            <td id="hu2"></td>
            <td id="du2"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
         <tr>
            <td>3</td>
            <td></td>
            <td id="hu3"></td>
            <td id="du3"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
         <tr>
            <td>4</td>
            <td></td>
            <td id="hu4"></td>
            <td id="du4"></td>
            <td></td>
            <td></td>
            <td></td>
         </tr>
         <tr>
            <td>5</td>
            <td></td>
            <td id="hu5"></td>
            <td id="du5"></td>
            <td></td>
            <td></td>
            <td></td>
            
         </tr>
      </table>
      <br>
      <table id="cham1">
         <tr>
            <th width="17%">참　　조</th>
            <td id="reference1"></td>
         </tr>
      </table>
      <br>
      <table>
         <tr>
            <th width="17%">제　　목</th>
            <td><input type="text" name="gdrsubject" id="gdrsubject" size="112px"></td>
         </tr>
      </table>
      <br>
      <div style="align:left">
      <table>
         <tr>
            <th width="17%">대표이사 등의 사안</th>
            <td class="left-align"><input type="checkbox" class="gdrsign" name="gdrsign" id="gdrsign" value="0" checked/>사용인감 날인
                          <input type="checkbox" class="gdrsign" name="gdrsign" id="gdrsign" value="1"/>법인인감 날인
                          </td>
         </tr>
         <tr>
            <th width="17%">계 약 형 태</th>
            <td class="left-align"><input type="checkbox" class="gdrcontract" name="gdrcontract" id="gdrcontract" value="0">구매
                          <input type="checkbox" class="gdrcontract" name="gdrcontract" id="gdrcontract" value="1">계약
                          <input type="checkbox" class="gdrcontract" name="gdrcontract" id="gdrcontract" value="2">매출
                          <input type="checkbox" class="gdrcontract" name="gdrcontract" id="gdrcontract" value="3">입찰
                          </td>
      </table>
      </div>
      <br>
      

    <div id="editor" class="initial-size"></div>
    <input type="hidden" id="quill_html" name="gdrmemo">
    <script>
      
        var quill = new Quill('#editor', {
         // Quill 설정 옵션
       });

       // 작성 영역 클릭 시 이벤트 처리
       var editorContainer = document.querySelector('#editor');
       editorContainer.addEventListener('click', function() {
         quill.focus(); // 작성 영역으로 포커스 이동
       });
    
        var toolbarOptions = [
            ['bold', 'italic', 'underline', 'strike'],
            ['link', 'image'],
            [{ 'list': 'ordered' }, { 'list': 'bullet' }],
            [{ 'header': [1, 2] }]
        ];
      
        var quill = new Quill('#editor', {
            modules: {
                toolbar: toolbarOptions
            },
            theme: 'snow'
        });
        
        function myFunction(){
        
        }
        
    </script>
    <div>
    <input type="hidden" id="gdrnum" name="gdrnum" value="">
    <input type="hidden" id="writer" name="writer">
    <input type="hidden" id="reference" name="reference" value="">    
    <input type="hidden" id="hu1_1" name="gdrapprover1" value="">
    <input type="hidden" id="du1_1" name="gdrdept1" value="">
    <input type="hidden" id="hu1_2" name="gdrapprover2" value="">
    <input type="hidden" id="du1_2" name="gdrdept2" value="">
    <input type="hidden" id="hu1_3" name="gdrapprover3" value="">
    <input type="hidden" id="du1_3" name="gdrdept3" value="">
    <input type="hidden" id="hu1_4" name="gdrapprover4" value="">
    <input type="hidden" id="du1_4" name="gdrdept4" value="">
    <input type="hidden" id="hu1_5" name="gdrapprover5" value="">
    <input type="hidden" id="du1_5" name="gdrdept5" value="">
    <input type="hidden" id="genum1" name="genum">
    
    </div>
    </form>
    <br>
   <form id="gdr_file_form">
   <table>
      <tr>
         <th width="17%">첨 부 파 일</th>
            <td class="left-align"><input type="file" name="gdrfile" id="gdrfile" multiple="multiple"></td><!-- 파일 -->
      </tr>            
   </table>
      <br>
      <div class="button-container">
         <button type="button" id="gbtn">결재선지정</button>
         <button type="button" id="sbtn">상신</button>
         <button type="button" id="cbtn">취소</button>
      </div>
   </form>
   </div>
   </body>
</html>