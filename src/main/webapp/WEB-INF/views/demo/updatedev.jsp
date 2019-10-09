<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="updateDev"/>
</jsp:include>

<style>
	div#demo-container{
		width: 40%;
		padding: 15px;
		margin: 0 auto;
		border: 1px solid lightgray;
		border-radius: 10px;
	}
</style>

<section id="content">
	<div id="demo-container">
		<h2>파라미터 테스트</h2>
		<form id="devFrm">
		
			<div class="form-group row">
			
				<label for="devName" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="devName" name="devName" value="${dev.devName}"/>
				</div>
			</div>
			<div class="form-group row">
				
				<label for="devName" class="col-sm-2 col-form-label">번호</label>
				<div class="col-sm-10">
					<input type=number class="form-control" id="devNo" name="devNo" value="${dev.devNo}" readonly="readonly"/>
				</div>
			</div>
				
				<div class="form-group row">
					<label for="devAge" class="col-sm-2 col-form-label">나이</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="devAge" name="devAge" value="${dev.devAge}"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="devEmail" name="devEmail" value="${dev.devEmail}"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">성별</label>
					<div class="col-sm-10">
						<div class="form-check form-check-inline">
							<c:if test="${dev.devGender == 'M'}">
							<input type="radio" class="form-check-input" id="devGender0" name="devGender" value="M" checked="checked"/>
							<label class="form-check-label" for="devGender0">남</label>						
							<input type="radio" class="form-check-input" id="devGender1" name="devGender" value="F"/>
							<label class="form-check-label" for="devGender1">여</label>			
							</c:if>
							<c:if test="${dev.devGender != 'M'}">
							<input type="radio" class="form-check-input" id="devGender0" name="devGender" value="M"/>
							<label class="form-check-label" for="devGender0">남</label>						
							<input type="radio" class="form-check-input" id="devGender1" name="devGender" value="F" checked="checked"/>
							<label class="form-check-label" for="devGender1">여</label>			
							</c:if>
						</div>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">개발언어</label>
					<div class="col-sm-10">
						<div class="form-check form-check-inline">
							<input type="checkbox" class="form-check-input" id="devLang0" name="devLang" value="Java"/>
							<label class="form-check-label" for="devLang0">Java</label>	
						</div>
						<div class="form-check form-check-inline">
							<input type="checkbox" class="form-check-input" id="devLang1" name="devLang" value="C"/>
							<label class="form-check-label" for="devLang1">C</label>	
						</div>
						
						<div class="form-check form-check-inline">
							<input type="checkbox" class="form-check-input" id="devLang2" name="devLang" value="JavaScript"/>
							<label class="form-check-label" for="devLang2">JavaScript</label>	
						</div>
					</div>
				</div>
				
				<input type="hidden" id="d0" value="${dev.devLang['0']}"/>
				<input type="hidden" id="d1" value="${dev.devLang['1']}"/>
				<input type="hidden" id="d2" value="${dev.devLang['2']}"/>
				
				
			
			<div class="list-group">
				<button type="button" onclick="update()" class="list-group-item list-group-item-action">수정</button>
		        <button type="button" onclick="cencle()" id="demoFrmBtn" class="list-group-item list-group-item-action">취소</button>	        
			</div>
		</form>
		
	</div>
	
	<script>
		function update()
		{
			$("#devFrm").attr("action","${path}/demo/updateEnd.do");
			$("#devFrm").submit();	
		}
		function cencle()
		{
			$("#devFrm").attr("action","${path}/demo/selectDevList.do");
			$("#devFrm").submit();
		}
		
	
		$(function(){
			var devL0 = $("#d0").val();
			var devL1 = $("#d1").val();
			var devL2 = $("#d2").val();
			if(devL0.trim() == "Java")
			{
				$("#devLang0").attr("checked","checked");
			}
			if(devL1.trim() == "C")
			{
				$("#devLang1").attr("checked","checked");
			}
			if(devL2.trim() == "JavaScript")
			{
				$("#devLang2").attr("checked","checked");
			}
			
			/* var data = new Array();
			 <c:forEach items="'${dev.devLang}'" var="lang" varStatus="vs">
			 	data.push("${lang}['${vs.index}']");
	         </c:forEach>
	         
	         for(var d in data)
	         {
	        	 console.log(data[d]);
	         }   */
			
		})
		
		
	
	</script>

</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>