<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		    <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		    <script src="resources/js/common.js"></script>

		<script type="text/javascript">
		    function openFixedWindowSize(url, width, height) {
		    	
		    	var screenWidth = window.screen.width;
		    	var screenHeight = window.screen.height;
		    	
		    	var left = Math.ceil((screenWidth - width) / 2);
		    	
		    	var top = Math.ceil((screenHeight - height) / 2); 
		    	  
		        
		        var windowFeatures = 'width=' + width + ',height=' + height + ',left=' + left + ',top=' + top + ',resizable=no';
		        window.open(url, '_blank', windowFeatures);
		      }
			
		</script>
		<style type="text/css">
		
			.bottomdiv{
		       	background-color: #fff;
	        	box-shadow: 0 1px 1px 0px rgba(0, 0, 0, 0.5);
	       		
	       		margin-bottom:0; 
				padding:0;
				width: 100%;
			}
			.map_a{
				margin-left: 15px;
				font-size: 13px;
			}
		</style>
		
	</head>
	
	<body>
	
		<div class="bottomdiv">
			<span class="map_a">
			    (주)GOATS.SOLUSION | Tel. 02-570-2222 | Fax. 02-570-2222 | 사업자번호: 000-000-00000
			</span>
				<br>
			<span class="map_a">
				<a href="#" onclick="openFixedWindowSize('mainMap.gos', 700, 400)">서울특별시 금천구 가산디지털2로 123 2차) 4층 413호 월드메르디앙 </a>
			</span>	
		</div>
	</body>
</html>