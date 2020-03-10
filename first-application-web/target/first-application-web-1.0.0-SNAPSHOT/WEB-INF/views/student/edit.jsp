<form:form action="${pageContext.request.contextPath}/student/update"
	method="post">
	<fieldset>

		<p>
		<h3>name</h3>
		<input type="text" name="name" value="${model.name}">
		</p>
		<p>
		<h3>age</h3>
		<input type="number" name="age" value="${model.age}">
		</p>
		<p>
		<h3>date of birth</h3>
		<input type="text" name="dateOfBirth" value="${model.dateOfBirth}">
		</p>
		<input type="hidden" name="id" value="${model.idT}" />

		<p>
			<button type="submit">update!</button>
		</p>
		
		<h3>checkbox 1</h3>
		<input type="checkbox" name="status" value="1" ${studentForm.status[0] = 1 ? checked : ''} />
		
		<h3>checkbox 2</h3>
		<input type="checkbox" name="status" value="2" ${studentForm.status[1] = 2 ? checked : ''}/>

		

	</fieldset>
</form:form>