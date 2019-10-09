<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="검색결과"/>
</jsp:include>

<section id="content">

<table class="table">
		<tr>
			<th scope="col">번호</th>
			<th scope="col">이름</th>
			<th scope="col">나이</th>
			<th scope="col">이메일</th>
			<th scope="col">성별</th>
			<th scope="col">개발가능언어</th>
			<th scope="col" colspan="2"/>
		</tr>
		
		<c:if test="${!empty list}">
			<c:forEach var="dev" items="${list}" varStatus="status">
				<tr>
					<td><c:out value="${dev.devNo}"/> </td>
					<td><c:out value="${dev.devName}"/></td>
					<td><c:out value="${dev.devAge}"/></td>
					<td><c:out value="${dev.devEmail}"/></td>
					<td><c:out value="${dev.devGender =='M'?'남':'여'}"/></td>
					<td>
						<c:forEach items="${dev.devLang}" var="Lang" varStatus="v">
							<c:out value="${v.index !=0? ',':''}"/><c:out value="${Lang}"/>
							<!-- 
								- status.index : 0부터 시작하는 루프의 인덱스 입니다.
								- status.count : 현재 몇번째 루프인지 값입니다. 1부터 시작합니다.				
								- status.current : 현재 아이템입니다. var 속성의 값과 같습니다.					
								- status.first : 현재가 첫번째 루프이면 참입니다.		
								- status.last : 현재가 마지막 루프이면 참입니다.					
								- status.begin : begin  속성을 사용했을 경우 그 값이 나옵니다.							
								- status.end : end 속성을 사용했을 경우 그 값이 나옵니다.								
								- status.step :  step 속성을 사용했을 경우 그 값이 나옵니다.
							 -->
						</c:forEach>
					</td>
					<td>
						<button type="button" class="btn btn-outline-light" onclick="devUpdate()">수정</button>
					</td>
					<td>
						<button type="button" class="btn btn-outline-light" onclick="devDelete()">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		
</table>
		<script>
			/* function devModify()
			{
				var = $("<form id=''">")
				$("#devFrm").attr("action","${path}/demo/devUpdate.do");
				$("#devFrm").submit();			
			}
			function devDelete()
			{
				
			} */
		
		</script>
	
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>