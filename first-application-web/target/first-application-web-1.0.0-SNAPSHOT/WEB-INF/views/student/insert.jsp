<form:form modelAttribute="studentForm" method="post"
	class="form-horizontal"
	action="${pageContext.request.contextPath}/student/insert">
	<form:label path="name" cssErrorClass="error-label">Name:</form:label>
	<form:input path="name" cssErrorClass="error-input" />
	<form:errors path="name" cssClass="error-messages" />
	<br>
	<form:label path="age" cssErrorClass="error-label">Age:</form:label>
	<form:input path="age" cssErrorClass="error-input" />
	<form:errors path="age" cssClass="error-messages" />
	<br>
	<form:label path="dateOfBirth" cssErrorClass="error-label">Date Of Birth:</form:label>
	<form:input path="dateOfBirth" cssErrorClass="error-input" />
	<form:errors path="dateOfBirth" cssClass="error-messages" />
	<br>
	
	<form:label path="status" cssErrorClass="error-label">checkbox 1:</form:label>
	<form:input path="status" type="checkbox" checked value="1"/>
	
	<form:label path="status" cssErrorClass="error-label">checkbox 1:</form:label>
	<form:input path="status" type="checkbox" checked value="1"/>
	
	<form:button name="confirm">save</form:button>
</form:form>