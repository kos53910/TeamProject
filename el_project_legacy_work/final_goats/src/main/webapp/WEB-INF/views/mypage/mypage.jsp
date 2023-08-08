<%@ page import="com.gt.s.kos.employee.vo.GtEmployeeVO"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	Object obj = request.getAttribute("gevo");
	GtEmployeeVO gevo = (GtEmployeeVO) obj;
	
	System.out.println("이메일 > :" + gevo.getGeemail());
	System.out.println("우편번호 > : " + gevo.getGezone());
	System.out.println("도로명주소 > :" + gevo.getGeroad());
	System.out.println("상세 > : " + gevo.getGeroaddetail());
	System.out.println("지번 > :" + gevo.getGejibun());
	System.out.println("전화번호 > :" + gevo.getGehp());
	
	String geemail = gevo.getGeemail();
	String gezone = gevo.getGezone();
	String geroad = gevo.getGeroad();
	String geroaddetail = gevo.getGeroaddetail();
	String gejibun = gevo.getGejibun();
	String gehp = gevo.getGehp();
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>GOATS | MyPage</title>
	
	<link rel="stylesheet" href="https://webfontworld.github.io/kopus/KoPubWorldDotum.css">
	<link rel="stylesheet" href="resources/css/mypage.css">
	<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
	    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
	    
	    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script type="text/javascript">

			$(document).ready(function(){
				var geemail = "<%=geemail%>";
				var gezone = "<%=gezone%>";
				var geroad = "<%=geroad%>";
				var geroaddetail = "<%=geroaddetail%>";
				var gejibun = "<%=gejibun%>";
				var gehp = "<%=gehp%>";
	
				// 이메일 스플릿
				var email = geemail;
				var aaa = email.split("@");
				console.log(aaa);
				console.log(aaa[0]);
				console.log(aaa[1]);
				console.log(typeof (aaa));
	
				//전화번호 스플릿
				var hp = gehp;
				var bbb = hp.split("-");
				console.log(bbb);
				console.log(bbb[0]);
				console.log(bbb[1]);
				console.log(bbb[2]);
				console.log(typeof (bbb));
	
				$("#geemail0").val(aaa[0]);
				$("#geemail1").val(aaa[1]);
				$("#geemail2").val(aaa[1]).prop("selected", true);
				$("#gezone").val(gezone);
				$("#geroad").val(geroad);
				$("#geroaddetail").val(geroaddetail);
				$("#gejibun").val(gejibun);
				$("#gehp0").val(bbb[0]).prop("selected", true);
				$("#gehp1").val(bbb[1]);
				$("#gehp2").val(bbb[2]);
	
				$("#zonecode").click(function() {
					new daum.Postcode({
						oncomplete : function(data) {
							$("#gezone").val(data.zonecode);
							$("#geroad").val(data.roadAddress);
							$("#gejibun").val(data.jibunAddress);
						}
					}).open();
				});
				
				$('#geemail2').change(function(){
					$('#geemail2 option:selected').each(function(){
						if($(this).val() == '1'){
							var aa = $("#geemail1").val();
							$("#geemail1").val('');
							$("#geemail1").attr("readonly", false);
						}else{
							$("#geemail1").val($(this).text());
							$("#geemail1").attr("readonly", true);
						}
					});	
				});
	
				$(document).on("click", "#infbtn", function(){
	
					var gehp = $("#gehp0").val() + "-" + $("#gehp1").val() + "-" + $("#gehp2").val(); 
					var geemail = $("#geemail0").val() + "@" + $("#geemail1").val();
	
					$("#gehp").val(gehp);
					$("#geemail").val(geemail);
	
					let dataParam = $("#inf").serialize();
	
					console.log(dataParam);
	
					$.ajax({
						url : "gtinfupdate.gos",
						type : "POST",
						data : dataParam,	
						success : function(res){
						},
						error : function(e){
							console.log(e.responseText);
						}
					});
				});
	
				var pw_nCnt = 0;
				var pwcheck = 0;
	
				// 확인
				$(document).on("click", "#pbtn", function() {
	
					var mpw = $("#newpw").val();
					var mpw_r = $("#newpwfirm").val();
	
					
					if (mpw == mpw_r) {
						pw_nCnt++;
					} else {
						$("#currenpw").focus();
						$("#currenpw").val("");
						$("#newpw").val("");
						$("#newpwfirm").val("");
						alert("새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
					}
	
					if (pwcheck == 1) {
						$.ajax({
	
							url : "gtpwCheck.gos",
							type : "POST",
							async : false,
							data : {
								newpw : $("#newpw").val(),
								currenpw : $("#currenpw").val()
							},
							success : function(res) {
							},
							error : function(e) {}
						});
	
					} else {
	
						$("#newpwfirm").val("");
						$("#newpw").focus();
						
					}
				});
	
				$("#newpw").keyup(function() {
	
					var pwnew = $("#newpw").val();
					$.ajax({
						url : "gtpwupdateCheck.gos",
						type : "POST",
						data : {
							newpw : pwnew
						},
						success : function(res) {
						console.log(res);

							if (res == "true+true+true+true+true") {
		
								pwcheck++;
														
							}
						},
						error : function(e) {
							console.log(e.responseText);
						}
					});
				});
			});
		</script>
    <script>
        $(function(){
            $('.rightTop button').click(function(){
                console.log("dd")
            })

            // rightMyInfo
            // rightPassChange
            // passBtn
            // myInfoBtn
            $('.myInfoBtn').click(function(){
                $(this).addClass('on');
                $('.rightPassChange').addClass('none');
                $('.rightMyInfo').removeClass('none');
                $('.passBtn').removeClass('on')
            })

            $('.passBtn').click(function(){
                $(this).addClass('on');
                $('.rightPassChange').removeClass('none');
                $('.rightMyInfo').addClass('none');
                $('.myInfoBtn').removeClass('on')
            })
        })
    </script>
<style class="goatsfont">
    body {
        font-family: 'KoPubWorldDotum';
    }
</style>
</head>
<body>
     
      <div class="container2" style="margin: 0">
      <!--  사이드바 -->
      <div>
        <jsp:include page="../main/mainSide-bar.jsp" />
      </div>
      
      <!-- 탑바 -->
      <div style="margin: 0; padding: 0; width:100%">
        <jsp:include page="../main/Top-bar.jsp"></jsp:include>
      <div class="container" id="rightcon">
        
		<!--  -->
        <div class="myPageWrap">
            <h2>마이페이지</h2>
            <div class="myPageContentWrap">
                <!-- 왼쪽 프로필 사진있는곳 -->
                <div class="myPageContentLeft">
                    <div class="leftTop">
                        <div class="leftImage" style="background-image: url('resources/goats_icon/person.png');"></div>
                        <div>이름 ${gevo.gename}</div>
                        <div>${gevo.gedept}</div>
                    </div>
                    <div class="leftBottom">
                        <div>
                            <span>직급</span>
                            <span>${gevo.title}</span>
                        </div>
                        <div>
                            <span>이메일</span>
                            <span>${gevo.geemail}</span>
                        </div>
                        <div>
                            <span>입사일</span>
                            <span>
                            	<c:set var="insertdate" value="${gevo.insertdate}"></c:set>
                     			${fn:substring(insertdate,0,10)}
                            </span>
                        </div>
                    </div>
                </div>
                <!-- /왼쪽 프로필 사진있는곳 -->

                <!-- 오른쪽 내정보랑 비번변경 -->
	                <div class="myPageContentRight">
	                    <div class="rightTop">
	                        <button class="myInfoBtn on">내 정보</button>
	                        <button class="passBtn">비밀번호 변경</button>
	                    </div>
	                    <div class="rightBottom">
	                        <!-- 내 정보 -->
	                        <div>
	                        	<form id="inf" class="rightMyInfo">
		                            <div>
		                                <div>Email</div>
		                                <input type="text" name="geemail0" id="geemail0" style="width: 100px">  @ 
		                                <input type="text"name="geemail1" id="geemail1" style="width: 100px"placeholder="직접입력">
		                            </div>
		                            <div>
		                                <div>주소</div>
		                                <input type="text" name="gezone" id="gezone" placeholder="우편번호">
										<input type="button" name="zonecode" id="zonecode" value="우편번호 찾기"><br>
										
		                            </div>
		                            <div>
		                            	<div></div>
										<input type="text" name="geroad" id="geroad" placeholder="도로명주소"> 
										<input type="text" name="geroaddetail" id="geroaddetail" placeholder="도로명주소 상세주소">
										<input type="text" name="gejibun" id="gejibun" placeholder="지번주소">
		                           	</div>
		                            <div>
		                                <div>전화번호</div>
		                                <select name="gehp0" id="gehp0">
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
										</select> - <input type="text" name="gehp1" id="gehp1" size="2" maxlength="4"> - <input type="text" name="gehp2" id="gehp2" size="2" maxlength="4">
		                            </div>
		                            <div>
		                                <div></div>                      
		                               <input style="width:114.3px;" type="button" value="저장" id="infbtn" class="registerBtn">
		                            </div>
									<div>
										<input type="hidden" id="gehp" name="gehp" value=""> 
										<input type="hidden" id="geemail" name="geemail" value="">
									</div>
	                            </form>
	                        </div>
                        <!-- 내 정보 -->
                        <!-- 비밀번호 수정 -->
                        <div class="rightPassChange none">
                            <div>
                                <div>기존 비밀번호</div>
								<input type="password" id="currenpw" name="gepw" value="">
                            </div>
                            <div>
                                <div>새 비밀번호</div>
                                <input type="password" id="newpw">
                            </div>
                            <div>
                                <div>새 비밀번호 확인</div>
                                <input type="password" id="newpwfirm">
                            </div>
                            <div>
                                <div></div>
                                <p class="rightPassP">최소 8개의 숫자와 소문자, 대문자, 특수기호를 입력해주세요.</p>
                            </div>
                            <div>
                                <div></div>
                                <input type="button" value="저장" id="pbtn" class="registerBtn">
                            </div>
                        </div>
                        <!-- 비밀번호 수정 -->

                    </div>
                </div>
                <!-- 오른쪽 내정보랑 비번변경 -->
            	</div>
        	</div>
       		</div>
        </div>
    </div>
</body>
</html>