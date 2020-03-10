<c:forEach var="i" begin="1" end="3">

	<div class="table__row">
		<div class="table__col">質問ラベル${i}</div>
		<div class="table__col">
			<pre>${detail_map_info['QLABEL${i}']}</pre>
		</div>
	</div>
	
	<div class="table__row">
		<div class="table__col">質問回答${i}</div>
		<div class="table__col">
			<pre>${detail_map_info['AVALUE${i}']}</pre>
		</div>
	</div>

</c:forEach>

<div class="table__row">
	<div class="table__col">流入元(流入経路)</div>
	<div class="table__col">
		<pre>${detail_map_info.CPREFERRER}</pre>
	</div>
</div>

<div class="table__row">
	<div class="table__col">メルマガ全停止依頼フラグ</div>
	<div class="table__col">
		<pre>${detail_map_info.ALLOPTOUTFLG}</pre>
	</div>
</div>

<c:forEach var="i" begin="1" end="30">

	<div class="table__row">
		<div class="table__col">メール配信許諾${i}</div>
		<div class="table__col">
			<pre>${nh_map[detail_map_info['OPTINFLG${i}']]}</pre>
		</div>
	</div>

</c:forEach>

<c:forEach var="i" begin="1" end="30">

	<div class="table__row">
		<div class="table__col">HTMLパーミッション${i}</div>
		<div class="table__col">
			<pre>${th_map[detail_map_info['HTMLFLG${i}']]}</pre>
		</div>
	</div>

</c:forEach>


<div class="table__row">
	<div class="table__col">販社専用メルマガ許諾</div>
	<div class="table__col">
		<pre>${nh_map[detail_map_info.HOPTINFLG]}</pre>
	</div>
</div>

<div class="table__row">
	<div class="table__col">販社専用HTMLパーミッション</div>
	<div class="table__col">
		<pre>${th_map[detail_map_info.HHTMLFLG]}</pre>
	</div>
</div>


