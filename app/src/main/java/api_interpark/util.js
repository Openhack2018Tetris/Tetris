function disable(start){

    var maxResults = $("input[type=radio][name=maxResults]:checked").val();

    var bookName = $('input[name="keyword"]').val();

    var start = start;

	getAjax(bookName, maxResults, start);



}



function checkpage(key){



	var test1 = document.getElementById("start");

	var test2 = parseInt(test1.value);



	if(key == 1){

			test2 = 1;

			test1.value=test2;



	}else if(key== 2){

		test2 = test2+1;

		test1.value=test2;

	}else if(key==3){

		test2 = test2-1;

		test1.value=test2;

	}



	var start = $("input#start").val();

	disable(start);



}





function currentpage(){



	checkpage(1);





}





function nextpage(){



	checkpage(2);



}





function prevpage(){



	checkpage(3);





}







function getAjax(bookName, maxResults, start) {

	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (this.readyState == 4 && this.status == 200) {



			myFunction(this);

		}

	};



	xhttp.open("GET", "ajaxbooksearch.jsp?maxResults=" + maxResults

			+ "&bookName=" + bookName + "&start=" + start, true);

	xhttp.send();





}



function myFunction(xhttp) {



	document.getElementById("result").innerHTML = xhttp.responseText;



	var sibal = document.getElementById("sibal").value;



	console.log(sibal);



    var maxResults = $("input[type=radio][name=maxResults]:checked").val();

    var bookName = $('input[name="keyword"]').val();

    var start = $("input#start").val();







    var totalrows = document.getElementById("total");

    var currentpage = document.getElementById("start");





    var currentpagem = parseInt(currentpage.value); // 현재 페이지

    var totalrowsm = parseInt(totalrows.value); // 검색결과 총수

	var maxResultsm = parseInt(maxResults); // 몇개 보기인지

    var totalpages = Math.ceil(totalrowsm/maxResultsm); // 페이지수



	var next = document.getElementById("next");

	var prev = document.getElementById("previous");



	if(sibal == 0){

		currentpagem = 0;

	}



	document.getElementById("totaltext").innerHTML =totalrowsm;

	document.getElementById("totalpage").innerHTML = totalpages;

	document.getElementById("currentpage").innerHTML = currentpagem;







	if(currentpagem == totalpages || currentpagem==1){

		prev.disabled = true;

		if(currentpagem >= totalpages && currentpagem !=0 && currentpagem !=1){

			prev.disabled = false;

		}

	}



	if(currentpagem == totalpages){

		next.disabled = true;



	}else if(currentpagem < totalpages){

		next.disabled = false;

	}






}
