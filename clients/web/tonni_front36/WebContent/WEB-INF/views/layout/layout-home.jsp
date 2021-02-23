<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
				<tiles:importAttribute name="javascripts"/>
				<tiles:importAttribute name="stylesheets"/>

<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="viewport" content="width=device-width, initial-scale=1" shrink-to-fit=no">
  <!-- put link here not in tiles -->
  
  	<!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
  	<!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
    <!-- Third party plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
     <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <!-- Contact Form -->
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    
    
                
 
					<title>
						<tiles:getAsString name="title" />
					</title>
					
					 <!-- stylesheets -->
				    <c:forEach var="css" items="${stylesheets}">
				        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
				    </c:forEach>
				    <!-- end stylesheets -->
  
  
</head>

<body class="home page-template-default page page-id-5"> 
	 <div class="wrapper">
			<tiles:insertAttribute name="body" />
	<nav class="main-heade navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav" style="margin-left: auto !important;">
	 <!-- <nav class="main-header navbar navbar-expand-lg navbar-light fixed-top py-3 " style="margin-left: auto !important;"> -->
		 
			<tiles:insertAttribute name="navbar" />
		</nav>
		  
 </div>
 

		
<footer>
	<div class="footer-wrapper">
		<tiles:insertAttribute name="footer" />
	
	</div>
</footer>
 

<!-- scripts -->
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	    
   <c:forEach var="script" items="${javascripts}">
       <script src="<c:url value="${script}"/>"></script>
   </c:forEach>
   <!-- end scripts -->

	


</body>
</html>
