<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="jquery/jquery-3.6.4.min.js"></script>
<script>
        // document 로딩 후 처리.
        $(document).ready(function () {
            // fetch('url',{option})
            $.ajax({

                url: "membersListJquery.do", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소

                data: {
                    name: "홍길동", // request.getParameter('name')
                    id: 'user01'
                }, //request.getParameter('id')                  // HTTP 요청과 함께 서버로 보낼 데이터
                method: "GET", // HTTP 요청 방식(GET, POST)
                dataType: "json", //서버에서 보내줄 데이터의 타입:Json.parse()실행.
                // 서버에서 보내줄 데이터의 타입
                success: function (result) { // 서버요청의 성공시 실행

                    $(result).each(function (idx, member) {

                        $('#list').append(
                            //tr>td*4 생성
                            $('<tr />').append($('<td />').text(member.memberId),
                                $('<td />').text(member.memberName),
                                $('<td />').text(member.memberAddr),
                                $('<td />').text(member.memberTel),
                                $('<td />').text(member.memberPw),
                                $('<td />').append($('<button />').text('삭제')
                                    .on('click', rowDeleteFnc)),
                                $('<td />').append($('<input type="checkbox" />'))


                            )

                        );
                    });
                    $('#addBtn').on('click', rowInsertFnc);

                },
                error: function (err) { // 서버요청의 실패시 실행.
                    console.log(err);
                }

            }) // $.ajax()
            function rowDeleteFnc() {

                $(this).parentsUntil('tbody').remove();

            }

            $('#delSelected').on('click', function (e) {
                e.preventDefault();
                let memberIdAray = {}
                console.log($('#list input:checked'));
                $('#list input:checked').each(function (idx, item) {
                	
                	console.log($(item).parent().parent().attr('id'));
                    //memberIdAray.push({'memberId':$(item).parent().parent().memberId})
                	memberIdAry.memberId = $(item).parent().parent().attr('id');
                    //$(item).parentsUntil('tbody').remove();
                })
					console.log(memberIdAray);
                
                	// ajax호출
                	$.ajax({
                		url:'memberRemoveJquery.do', //호출할 컨트롤
                		method:'post',
                		data: {memberId:'user01', memberId:'user02'},
                		success: function(result){
                			
                		},
                		error: function(reject){
                			console.log(reject)
                		}
                	})
                	}
            })

            function rowInsertFnc(e) {
                e.preventDefault(); // 전송기능차단
               
                if(!$('#id').val()||!$('#name').val()||!$('#addr').val()||!$('#tel').val()||!$('#passwd').val()){
                	alert('공란있음');
                    } else{
                    	
                    
                
                // 사용자가 필수입력값을 입력했는지 validation 하고
              	
                // ajax 호출
                
                $.ajax({
            		url:"membersAddJquery.do",
            	 data:{id:$('#id').val(),
            		 name:$('#name').val(),
            		 addr:$('#addr').val(),
            		 tel:$('#tel').val(),
            		 pass:$('#passwd').val()
            		 },
            		method:"post",
            		dataType:"json",
            		ansyc : false,
            		success: function(result){
            			if(result.retCode =='Success'){
            				//성공.	
            				 
                            $('#list').append(
                                $('<tr />').append($('<td />').text($('#id').val()),
                                    $('<td />').text($('#name').val()),
                                    $('<td />').text($('#addr').val()),
                                    $('<td />').text($('#tel').val()),
                                    $('<td />').text($('#passwd').val()),
                                    $('<td />').append($('<button />').text('삭제')
                                        .on('click', rowDeleteFnc))),
                                $('<td />').append($('<input type="checkbox" />'))


                            );


                            $(this).parentsUntil('tbody').add();
            				
            				} else if(result.retCode == 'Fail'){
            					
            				// 처리중 에러.
            			} else{
            				// 반환코드 확인.
            			}
            		},
                	error: function(reject){
                		
                	}
                })
                
            
                    }
                
               
            }


            $('th>input[type="checkbox"]').on('change', function () {
                //$('td>input').attr('checked','checked')
                $('td>input').prop({
                    checked: this.checked

                })
            })
            // th>input 과 td>input을 비교해서 전체선택이 되도록.
            // 선택된 갯수를 비교>?
            // ajax호출의 결과로 만들어지는 부분.
            $('#list').on('change','td>input[type="checkbox"]',function(){
        	  /*  $('td>input[type="checkbox"]').on('change',function(){ */
               console.log(this);
        	 let checkCnt = $('td>input[type="checkbox"]:checked').length;
        	 let allCnt = $('td>input[type="checkbox"]').length;
        	 if(checkCnt == allCnt){
        		 $('th>input[type="checkbox"]').prop({checked:true})
        		 
        	 } else{
        		 $('th>input[type="checkbox"]').prop({checked:false})
        	 }
        	  
        	 
            	
            })

        });
    </script>
<div>
	<form>
		<table class="table" border="1">
			<tr>
				<td>Id:</td>
				<td><input type="text" id="id"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" id="name"></td>
			</tr>
			<tr>
				<td>pass:</td>
				<td><input type="text" id="passwd"></td>
			</tr>
			<tr>
				<td>addr:</td>
				<td><input type="text" id="addr"></td>
			</tr>
			<tr>
				<td>Tel:</td>
				<td><input type="text" id="tel"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id="addBtn">등록</button>
					<button id="delSelected">선택삭제</button>
				</td>
			</tr>
		</table>

	</form>
	<table class="table" border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Pass</th>
				<th>주소</th>
				<th>연락처</th>
				<th>삭제</th>
				<th><input type="checkbox" id="ck"></th>
			</tr>

		</thead>

		<tbody id="list">

		</tbody>
	</table>
</div>






</head>

<body>

</body>

</html>