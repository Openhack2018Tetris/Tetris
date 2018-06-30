<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ page import="java.util.*"%>

<%@ page import="java.net.URL"%>

<%@ page import="javax.xml.parsers.*"%>

<%@ page import="org.w3c.dom.*"%>

<%@ page import="org.xml.sax.InputSource"%>

<%@ page import="javax.xml.xpath.*"%>



<%

	String contextRoot = request.getContextPath();

	String key = "118AC82FCCC7491FD7993E41F6BAF6E4B91532CB638591AD94E437B00235B7D4";

	String maxResults = request.getParameter("maxResults");

	// 책 제목 검색시 사용

	String bookName = request.getParameter("bookName");

	String start = request.getParameter("start");





	// 특정 페이지 요청시 사용

	//System.out.println(bookName);



	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	DocumentBuilder builder = factory.newDocumentBuilder();

	Document xmlObj = null;



	// 주의) 한글 인코딩 설정 확인

	String str = String.format(

			"http://book.interpark.com/api/search.api?key=%s&query=%s&start=%s&maxResults=%s&inputEncoding=euc-kr",

			key, bookName, start,maxResults);







	URL url = new URL(str);

	InputSource is = new InputSource(url.openStream());

	xmlObj = builder.parse(is);



	XPath xPath = XPathFactory.newInstance().newXPath();



	String title = "";

	String publisher = "";

	String author = "";

	String priceStandard = "";

	String isbn = "";

	String pubDate = "";

	String link = "";

	String coverLargeUrl = "";

	String TotalRows = "";

	String totalResults = xPath.compile("/channel/totalResults").evaluate(xmlObj);







	NodeList nodeList = (NodeList) xPath.compile("/channel/item").evaluate(xmlObj,  XPathConstants.NODESET);

	StringBuilder sb = new StringBuilder();

	TotalRows = String.valueOf(nodeList.getLength());

	if(nodeList.getLength() != 0){

		int a = 1;

		for(int i=1; i<=nodeList.getLength(); i++){



			title = xPath.compile(String.format("/channel/item[%s]/title",i)).evaluate(xmlObj);

		//	System.out.println(title);

			publisher = xPath.compile(String.format("/channel/item[%s]/publisher",i)).evaluate(xmlObj);

			author = xPath.compile(String.format("/channel/item[%s]/author",i)).evaluate(xmlObj);

			priceStandard = xPath.compile(String.format("/channel/item[%s]/priceStandard",i)).evaluate(xmlObj);

			isbn = xPath.compile(String.format("/channel/item[%s]/isbn",i)).evaluate(xmlObj);

			pubDate = xPath.compile(String.format("/channel/item[%s]/pubDate",i)).evaluate(xmlObj);

			link = xPath.compile(String.format("/channel/item[%s]/link",i)).evaluate(xmlObj);

			coverLargeUrl = xPath.compile(String.format("/channel/item[%s]/coverLargeUrl",i)).evaluate(xmlObj);



			sb.append(String.format("<tbody><tr><td>%s</td><td><img src=\"%s\"?TotalRows=\"%s\" style=\"width: 180px;\"></td><td class=\"col-sm-6\">title:<label>%s</label><br>publisher:%s<br>author: %s <br> priceStandard : %s <br> isbn:%s<br>pubDate:%s </td><td><a href=\"%s\" target=\"_blank\" class=\"btn btn-default btn-xs\" role=\"button\">인터파크 상세보기</a></td></tr></tbody>",a,coverLargeUrl,TotalRows, title,publisher,author,priceStandard,isbn,pubDate,link)	);

			a++;





		}



	}else{

		sb.append(String.format("<tbody><tr><td colspan=\"4\" style=\"text-align:center;\"><strong>출력 대상이 없습니다.</strong></td></tr></tbody>"));



	}



	//System.out.println("-------------------");





%>

<input type="text" value="<%=nodeList.getLength()%>" id="sibal">

<input type="text" value="<%=totalResults%>" id="total">



<%=sb.toString()%>
