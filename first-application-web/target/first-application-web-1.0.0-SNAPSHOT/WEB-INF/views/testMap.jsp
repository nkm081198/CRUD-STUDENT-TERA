

<c:forEach var="i" begin="1" end="5">
	<h1>YOBI_${i}</h1>
	<c:set var="item" value="yobi${i}" />
	<h2>${detail_map_info[item]}</h2>
</c:forEach>
