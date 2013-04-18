<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:actionURL name="login" var="loginAction"/>

<div class="liferay-my-admin">
	<form:form action="${loginAction}" method="post" modelAttribute="loginModel">
		<div>
			<div class="title">
				<form:label path="driver"><spring:message code="Driver"/>:</form:label>	
			</div>
			<div class="content">
				<form:select path="driver">
					<spring:eval expression="T(com.scobich.liferaymyadmin.model.enums.Driver).values()" var="drivers" />
					<c:forEach items="${drivers}" var="driver">
						<form:option value="${driver}"><spring:message code="com.scobich.liferaymyadmin.model.enums.Driver.${driver}"/></form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div>
			<div class="title">
				<form:label path="username"><spring:message code="Username"/>:</form:label>	
			</div>
			<div class="content">
				<form:input path="username"/>
			</div>
		</div>
		<div>
			<div class="title">
				<form:label path="password"><spring:message code="Password"/>:</form:label>	
			</div>
			<div class="content">
				<form:input path="password"/>
			</div>
		</div>
		<div>
			<div class="title">
				<form:label path="host"><spring:message code="Host"/>:</form:label>	
			</div>
			<div class="content">
				<form:input path="host"/>
			</div>
		</div>
		<div>
			<div class="title">
				<form:label path="port"><spring:message code="Port"/>:</form:label>	
			</div>
			<div class="content">
				<form:input path="port"/>
			</div>
		</div>
		<div>
			<div class="title">
				<form:label path="database"><spring:message code="Database"/>:</form:label>	
			</div>
			<div class="content">
				<form:input path="database"/>
			</div>
		</div>
		<div>
			<form:button><spring:message code="Connect"/></form:button>
		</div>
	</form:form>
	<script>
	AUI().ready(function(A) {
		var driver = A.one('.liferay-my-admin select');
		var username = A.one('.liferay-my-admin input[name=username]');
		var password = A.one('.liferay-my-admin input[name=password]');
		var host = A.one('.liferay-my-admin input[name=host]');
		var port = A.one('.liferay-my-admin input[name=port]');
		var database = A.one('.liferay-my-admin input[name=database]');
		driver.on('change', function(event){
			var driverValue = driver.get('value');
			if (driverValue === 'LIFERAY') {
				username.attr('disabled', 'disabled');
				password.attr('disabled', 'disabled');
				host.attr('disabled', 'disabled');
				port.attr('disabled', 'disabled');
				database.attr('disabled', 'disabled');
			} else {
				username.removeAttribute('disabled');
				password.removeAttribute('disabled');
				host.removeAttribute('disabled');
				port.removeAttribute('disabled');
				database.removeAttribute('disabled');
			}
		});
	});
	
	</script>
</div>
