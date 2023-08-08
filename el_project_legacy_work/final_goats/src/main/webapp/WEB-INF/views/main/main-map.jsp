<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>로드뷰 도로를 이용하여 로드뷰 생성하기</title>
	    <style>
	    .map_wrap {overflow:hidden;height:500px}
		</style>
	</head>
	<body>
	<div class="map_wrap">
	    <div id="mapWrapper" style="width:100%;height:500px;float:left">
	        <div id="map" style="width:100%;height:100%"></div> <!-- 지도를 표시할 div 입니다 -->
	    </div>
	    <div id="rvWrapper" style="width:50%;height:300px;float:left">
	        <div id="roadview" style="width:100%;height:100%"></div> <!-- 로드뷰를 표시할 div 입니다 -->
	    </div>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4d9a50a53bb326bd97f52af1b2248c5f"></script>

	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(37.478853, 126.879367), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	var marker = new kakao.maps.Marker();
	
	// 타일 로드가 완료되면 지도 중심에 마커를 표시합니다
	kakao.maps.event.addListener(map, 'tilesloaded', displayMarker);
	
	function displayMarker() {
	    
	    // 마커의 위치를 지도중심으로 설정합니다 
	    marker.setPosition(map.getCenter()); 
	    marker.setMap(map); 
	
	    // 아래 코드는 최초 한번만 타일로드 이벤트가 발생했을 때 어떤 처리를 하고 
	    // 지도에 등록된 타일로드 이벤트를 제거하는 코드입니다 
	    // kakao.maps.event.removeListener(map, 'tilesloaded', displayMarker);
	}
	</script>
	</body>
</html>