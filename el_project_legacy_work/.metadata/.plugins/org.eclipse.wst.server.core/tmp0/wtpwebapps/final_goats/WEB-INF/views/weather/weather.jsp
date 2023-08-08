<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
		
		var weather = "http://192.168.0.106:5001/weather";
		
		$.ajax({
			url : weather,
			dataType : "json",
			success : function(res){
				
				console.log(res);
				
				
				var obj = JSON.stringify(res); 
				var aaab = JSON.parse(obj);
				console.log(obj);
				console.log(aaab);
				
				var temp = aaab.main.temp;
				console.log(" > : " + temp);
				
				var table = "<div>현재 지역 온도<br>" + temp +" °C </div>";
				
				$('#weather1').append(table);
			}, 
			error : function(e) {
				console.log(e.responseText);
			}
			
		});
		
		</script>	
		<style type="text/css">
		
			#weather {
				display: flex;
				width:100%;
				
			}	
		
		</style>
	</head>
	<body>
		<div>
		<div id="weather">
			<div><img src="resources/goats_icon/temperature.png" style="width:50px;"></div>
			<div id="weather1"></div>
			</div>
	</div>
	</body>
</html>