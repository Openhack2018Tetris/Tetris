<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%

	String contextRoot = request.getContextPath();



%>





<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>인터파크 도서검색 Ajax</title>



<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"

	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script

	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<script

	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>



<!-- <script type="text/javascript" src="/booksearch_20170203/script/util.js"></script> -->



<script type="text/javascript" src="<%=contextRoot%>/script/util.js"></script>



<style>

div.panel {

	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0

		rgba(0, 0, 0, 0.19);

}

</style>



<script>

	$(document).ready(function() {

		getAjax("", 10, 0);







		$("#mybtn").on("click",function() {



			currentpage();

			//disable();

	});



		$("#keyword").keypress(function(event){

			 if ( event.which == 13 ) {

		         $('#mybtn').click();

		         return false;

		     }



		});



		$("#next").on("click", function(){

			nextpage();

			//disable();



		});



		$("#previous").on("click", function(){



			prevpage();

			//disable();

		});



});

</script>



<script>



</script>



</head>

<body>

	<div class="container">



		<div>

			<h1 style="font-size: x-large;">

				<img src="<%=contextRoot%>/img/sist_logo.png" alt="sist_logo.png"

					style="vertical-align: bottom;"> [인터파크 도서검색 Ajax] <small>v1.0</small>

			</h1>

		</div>



		<div class="panel-group">

			<div class="panel panel-default">

				<div class="panel-heading">

					<label>도서 검색</label>

				</div>

				<div class="panel-body">

					<form class="form-inline" role="form" method="post" id="myForm">

						<input type="hidden" id="start" name="start" value="0">

						<!-- <label

							for="keyword">키워드:</label> -->

						<input type="text" class="form-control" id="keyword"

							name="keyword" required="required" value="" required>

						<button type="button" class="btn btn-default btnSearch" id="mybtn" >

							<span class="glyphicon glyphicon-search"></span> Search

						</button>





						<label class="radio-inline"><input type="radio"

							class="maxResults" name="maxResults" value="10" checked="checked">10개씩

							보기</label> <label class="radio-inline"><input type="radio"

							class="maxResults" name="maxResults" value="20">20개씩 보기</label> <label

							class="radio-inline"><input type="radio"

							class="maxResults" name="maxResults" value="30">30개씩 보기</label>

					</form>

				</div>

			</div>

			<div class="panel panel-default">

				<div class="panel-heading">



					<!-- <label>검색 결과 출력</label> -->

					<button type="button" class="btn btn-default">

						TotalRows <span class="badge totalResults" id="totaltext"></span>

					</button>

					<button type="button" class="btn btn-default">

						TotalPages <span class="badge totalPages" id="totalpage"></span>

					</button>

					<button type="button" class="btn btn-default">

						CurrentPage <span class="badge currentPage" id="currentpage"></span>

					</button>

				</div>

				<div class="panel-body">

					<table class="table bookAPI">

						<tbody id="result">





						</tbody>

					</table>

					<ul class="pager">

						<li><button type="button" class="btn btn-default"

								id="previous" value="1">Previous</button></li>

						<li><button type="button" class="btn btn-default" id="next"

								value="2">Next</button></li>

					</ul>

				</div>

			</div>

		</div>



	</div>

</body>

</html>
