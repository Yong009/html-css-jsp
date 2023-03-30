<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 시도: <input type="text" id="sido"> -->
	시도선택:<select id="sidoList">
				
			</select>
	<button id="sidoBtn">찾기</button>

	<h3>센터현황</h3>
	<table border="1">
		<thead>
			<tr><th>아이디</th><th>센터명</th><th>주소</th><th>연락처</th><th>시도</th>
		</thead>
		<tbody id ="centerList"></tbody>
		
		
	</table>
	<script>
	
	
		
		

		
		
	//전체 목록.
	let totalList; // 다른 함수에서도 활용.
	
	
	let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=EXQfDasKzi8ej6hx7zkY2wsEvSoYGjgPLBCM87%2BYH5G0NKbtBIHFsFiCWoAv5Ifcpl3zZX%2FXpDfDO3DL0Oaqsw%3D%3D`;
		fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
				console.log(result);
				let aryData = result.data;
				totalList = aryData; //처리결과를 활용해서 totalList 대입.
				aryData.forEach(function (center) {
					let tr = makeTr(center);
					document.querySelector('#centerList').append(tr);

				});
		// 시도 배열
		//totalList; //{id, centerName, address, sido}
		// push(추가), pop(빼기), unshift(앞에 빼기) ,shift(앞에 추가)
		let sidoAry = [];
		totalList.forEach(center =>{
			if(sidoAry.indexOf(center.sido)==-1){
				sidoAry.push(center.sido);
			} 
		})

				
		sidoAry.forEach(function(sido){
			
			let opt = document.createElement('option');
			opt.value = sido;
			opt.innerText = sido;
			document.querySelector('#sidoList').append(opt);

		});



		})
		.catch(reject => console.error(reject));
	
		
		let showFields = ['id','centerName','address','phoneNumber','sido'];

	function makeTr(center={}){
		// tr생성>td*여러개.
		let tr = document.createElement('tr');
		tr.setAttribute('data-lng',center.lng);
		tr.setAttribute('data-lat',center.lat);
		tr.setAttribute('data-name',center.centerName);
		
		tr.addEventListener('click',openMapFnc);

		// td생성
		showFields.forEach(function (prop){
			let td = document.createElement('td');
			td.innerText = center[prop];
			tr.append(td);
		
		    
		});

		return tr;
	}
	
		function openMapFnc() {
			let tr = this; //event target.
			let lng = tr.dataset.lng; //tr.getAttribute('date-lng');
			let lat = tr.dataset.lat; // tr.getAttribute('date-lat');
			let name = tr.dataset.name;
			location.href = 'map.do?lng='+lng+'&lat='+lat+'&name='+name;
			
			/* window.open('map.do?lng='+lng+'&lat='lat,'_blank') */

		}

		
		
		

		// 찾기 버튼
		document.querySelector('#sidoBtn').addEventListener('click', findSidoFnc);

		function findSidoFnc(){
			// 전체목록. 검색조건 filter한 결과를 tbody의 하위목록 출력.
			document.querySelector('#centerList').innerHTML ="";
			
			let searchWord = document.getElementById('sidoList').value;
			
			let filterAry = totalList.filter(function (center) {
				
				return center.sido == searchWord;
			});
				

				filterAry.forEach(center => {
					document.querySelector('#centerList').append(makeTr(center));
				})
				
		}
	
		
		
		
		
		
	




	</script>
</body>
</html>