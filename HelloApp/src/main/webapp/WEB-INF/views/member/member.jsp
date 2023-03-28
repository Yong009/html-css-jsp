<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<h3>Tiles가 적용된 member 페이지</h3>
	<div>
		<form>
			id:<input type="text" id="id"><br> name: <input type="text" id="name"><br> pass: <input type="text"
				id="passwd"><br> mail: <input type="text" id="mail"><br>
			auth: <input type="text" id="auth"><br>
			<button id="addBtn">등록</button>

d
		</form>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Pass</th>
					<th>Mail</th>
					<th>Auth</th>
					<th>삭제</th>
				</tr>

			</thead>

			<tbody id="list">

			</tbody>
		</table>
	</div>

	<script>
		fetch('memberListAjax.do') //json 포맷으로 데이터 정상.
			.then(function (resolve) {
				console.log(resolve); // body: readablestream
				return resolve.json(); // json포맷에 따라 javascript object 변경.

			})
			.then(function (result) {
				console.log(result);   //result:[{id,name,pass,mail,auth},{},{},{}.....{}]
				for (let i = 0; i < result.length; i++) {
					let id = result[i].id;
					makeTr(result[i]);




				}
			})
			.catch(function (reject) {
				console.error(reject);
			})
		// 등록버튼 클릭이벤트.
		document.getElementById('addBtn').addEventListener('click', function (e) {
			e.preventDefault();

			let id = document.getElementById('id').value;
			let nm = document.getElementById('name').value;
			let pw = document.getElementById('passwd').value;
			let ma = document.getElementById('mail').value;
			let au = document.getElementById('auth').value;

			if (!id || !nm || !pw || !ma || !au) {
				alert("값을 입력!!");
				return;
			}
			//Ajax호출.
			fetch('memberAddAjax.do', {
				method: 'post',
				headers: { 'Content-type': 'application/x-www-form-urlencoded' },
				body: 'id=' + id + '&name=' + nm + '&pw=' + pw + '&mail=' + ma + '&auth=' + au
			})
				.then(resolve => resolve.json()) //{"id:"user1","name":name}
				.then(result => {
					console.log(result);
					if (result.retCode == 'Success') {
						alert('성공!!');
						// 추가된 값을 화면 출력.
						makeTr(result.member);
						// 추가된 값 화면 출력.
						initField();
					} else if (result.retCode == 'Fail')
						alert('예외발생!!');
				})
				.catch(reject => console.error());


		})

		//tr 생성.
		function makeTr(member = {}) {
			//완료. tr>td+td+td+td+td+td+td>button
			let tr = document.createElement('tr');
			//td 만들기.(아이디,이름,비번,메일,권한)
			for (let prop in member) { //for..in..object의 필드 반복
				let td = document.createElement('td');
				td.innerText = member[prop];
				tr.append(td);

			}
			//등록버튼
			let delBtn = document.createElement('button'); //<button>삭제</button>
			delBtn.innerText = '등록';

			delBtn.addEventListener('click', function () {
				console.log(this);
				console.log(this.parentElement.parentElement.children[0].innerText)
				let delId = this.parentElement.parentElement.children[0].innerText
				//ajax 호출.
				fetch('memberRemoveAjax.do', {
					method: 'post',
					headers: { 'Content-Type': 'application/x-www-form-urlencoded' }, //key=val&key&val
					body: 'id=' + delId
				})
					.then(resolve => resolve.json()) // resolve => {"retCode" : "Success"}
					.then(result => {
						console.log(result);
						if (result.retCode == 'Success') {
							alert('성공!');
							this.parentElement.parentElement.remove();
						} else if (result.retCode == 'Fail') {
							alert('실패!');
						} else {
							alert('dsfsdfsdfsdfs');
						}
					})
					.catch(reject => console.log(reject));


			});
			let td = document.createElement('td');
			td.append(delBtn); //<td><button>삭제</button></td>
			tr.append(td);	//<tr><td/><td/><td/><td/><td/>...
			document.getElementById('list').append(tr);
		}
		function initField(){
			document.getElementById('id').value='';
			document.getElementById('name').value='';
		}
		
	</script>