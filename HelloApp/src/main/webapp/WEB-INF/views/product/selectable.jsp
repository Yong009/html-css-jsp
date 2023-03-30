<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='full/dist/index.global.js'></script>
<script>
	
	
		


	
	
  document.addEventListener('DOMContentLoaded', async function() {
	 // fetch api를 사용.
	 
	
	 let events = [];
	
	let promise1 = await fetch('calendar.do');
	let promise2 = await promise1.json();
		promise2.forEach(function (calendar){
			let obj = {title: calendar.title, start: calendar.startDate, end: calendar.endDate}
			events.push(obj)
		})
	  
	  
	  var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2023-01-12',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
        
    	  var title = prompt('일정등록:');
        if (title) {
        	console.log(arg)
        	
        	fetch('calendarAdd.do?title='+title+'&start='+arg.startStr+'&end='+arg.endStr)
       	 	.then(resolve => resolve.json())
       	 	.then(result=>{
       	 		
       	 	result = arg;	
       	 		
       	 		
       	 	
       	        
       	 	})
       	  	.catch(reject=> console.error(reject));
         
        	
        	calendar.addEvent({
            title: title,
            start: arg.start,
            end: arg.end,
            allDay: arg.allDay
          })
        }
        calendar.unselect()
      },
      eventClick: function(arg) {
        if (confirm('이벤트를 삭제하겠습니까?')) {
          	
        	fetch('calendarRemove.do?title='+arg.event.title+'&start='+arg.event.startStr+'&end='+arg.event.endStr)
        	.then(resolve => resolve.json())
        	.then(result=>{
        	
        	 	  	
        	
        		
        	
        		
        		
        	arg.event.remove();
        		
        	})
        	
        	
        }
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: events
       
      
    });
	
    calendar.render();
  });

</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
