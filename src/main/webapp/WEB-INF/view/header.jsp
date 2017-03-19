<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<title>NYC cab</title>

 		<meta charset="utf-8">
     	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="webjars/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" rel="stylesheet">
        <link rel="shortcut icon" href='<c:url value="/resources/images/favicon.png" />' type="image/x-icon">
        <style>
			<%@include file='styles.css'%>
        </style>

        <jsp:include page="javaScript.jsp" />

	</head>
	<body>
		<div class="container" id="mainLayout">
		    <div class="col-12" id="header">
		       <h1>NYC cab</h1>
		    </div>