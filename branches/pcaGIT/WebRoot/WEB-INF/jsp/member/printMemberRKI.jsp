<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="com.ametis.cms.util.WebUtil" %>
<%@ taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>


		<script type="text/javascript" src="scripts/sugar_3.js"></script>

		<link rel="stylesheet" type="text/css" media="all" href="css/calendar-win2k-cold-1.css" />
		<link rel="stylesheet" type="text/css" media="all" href="css/style.css" />
	
		

<link rel="stylesheet" type="text/css" href="css/reset-fonts-grids.css" />
        <!-- CSS for Menu -->

        <link rel="stylesheet" type="text/css" href="css/menu.css" />
 
 
        <!-- Page-specific styles -->

        <!-- Namespace source file -->
<!-- calendar stylesheet -->
	
		
        <!-- Menu source file -->
       
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Healthcare Management System</title>


		<link href="css/navigation.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="scripts/menu.js"></script>
		

	</head>


<%
String navigation = WebUtil.getAttributeString(request,"navigation","");
%>

 <!-- Page Title Start // Should be put on <Title> tag-->

<!-- Page Title Stop-->
<%
String alert = (String) request.getAttribute("alert");
int index = 0;
int totalIndex = 0;
int count = 0;
int countSet = 0;

try {
	
	
}
catch (Exception e){
}

if (alert != null && !alert.trim().equals("")) {%>
	<div id="warning" align="center">
		<c:out value="${alert}"></c:out>
	</div>
	<%}%>

<%

%>
<!-- Search Container Start -->

<br />
<form name="form1" action="batchclaim" method="POST">
<input type="hidden" name="navigation" value="gosearch">
<input type="hidden" name="subnavigation" value="list">
<input type="hidden" name="currentnavigation" value="list" >
<input type="hidden" name="providerId" value="<c:out value="${providerId}" />">
<input type="hidden" name="arah" value="">



<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td nowrap="nowrap"></td>
      <td width="100%"></td>
    </tr>
  </tbody>
</table>


	

<br />

 	<table class="listView" style="border-color: 000; border: 1px;" cellspacing="0" cellpadding="0" width="30%">
		<tbody>
<!-- 			<tr height="20"> -->
<!-- 				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="100%" valign="middle" colspan=2><center><c:out value="${provider.providerName}" /></center> -->
<!-- 					<img src="images/owlexa/owlexa_letter_logo.png" width="80" height="72" align="right"> -->
<!-- 				</td>				 -->
				
<!-- 			</tr> -->
<!-- 			<tr height="20"> -->
<!-- 				<td class="oddListRowS1" bgcolor="#e7f0fe"  width="100%" valign="top" colspan=3><center><c:out value="${provider.address}" /></center></td>				 -->
<!-- 			</tr> -->
			<tr height="20">
				<td bgcolor="#e7f0fe" nowrap="nowrap" valign="middle" class="oddListRowS1" style="border-left: 0px;padding-right: 20px;" align="center" colspan="4">
					<img src="images/owlexa/owlexa_letter_logo.png" height="72" align="middle">
				</td>
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" width="60%" valign="middle" colspan="4">
					<center><b><c:out value="${provider.providerName}" /></b></center>
					<!-- <br> -->
					<hr>
					<center><c:out value="${provider.address}" />
				</td>				
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4">&nbsp;</td>				
			</tr>
			<tr heigh="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4"><c:out value="${caseCategory.caseCategoryName}" /></td>
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4"><b>REGISTRASI</b></td>				
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4"><c:out value="${member.currentCardNumber}" /> (*)</td>				
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4"><c:out value="${member.customerPolicyNumber}" /></td>				
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4"><c:out value="${member.memberGroupId.groupName}" /></td>
				
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4"><c:out value="${member.firstName}" /></td>
			</tr>
			
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="60%" valign="top">Expired Date : </td>
				<td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top" style="border-left: 0px;"></td>
				<td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top" style="border-left: 0px;"></td>
				<td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top"><c:out value="${expireDate}" /></td>				
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="60%" valign="top">Date/Time : </td>
				<td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top" style="border-left: 0px;"></td>
				<td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top" style="border-left: 0px;"></td>
				<td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top"><c:out value="${dateTime}" /></td>				
			</tr>
			<tr height="20">
				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top" colspan="4"><b>BENEFIT : </b></td>
				<!-- <td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top" style="border-left: 0px;"></td>
				<td class="oddListRowS1" bgcolor="#e7f0fe" align=right nowrap="nowrap" valign="top" style="border-left: 0px;"></td> -->								
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>	
			<c:forEach items="${memberBenefitList}" var="memberBenefit" varStatus="status" >
				 <tr height="20">
			      	<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="60%" valign="top" colspan="3">
			      		<c:if test="${memberBenefit.itemCategoryId.itemCategoryEDCName eq null}">
			      		<c:out value="${fn:toUpperCase(memberBenefit.itemCategoryId.itemCategoryName)}" />
			      		</c:if>
			      		<c:if test="${memberBenefit.itemCategoryId.itemCategoryEDCName ne null}">
			      		<c:out value="${fn:toUpperCase(memberBenefit.itemCategoryId.itemCategoryEDCName)}" />
			      		</c:if>
			      	
			      	</td>			
	<!-- 				      	<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="10%" valign="top"></td> -->
					<td class="oddListRowS1" bgcolor="#e7f0fe" align=right width="30%" nowrap="nowrap" valign="top">
						Sesuai Bnf
					</td>				
			    </tr>   
				<tr>
			      <td colspan="20" class="listViewHRS1"></td>
			    </tr>	
			</c:forEach>
			<tr height="20">
		      	<td class="oddListRowS1" bgcolor="#e7f0fe" width="10%" nowrap="nowrap" valign="top" colspan="4"></td>
		    </tr> 
			<tr>
		      	<td colspan="20" class="listViewHRS1">&nbsp;</td>
		 	</tr>
		    <tr>
		      <td colspan="20" class="listViewHRS1">&nbsp;</td>
		    </tr>
			<c:forEach items="${policyClausulList}" var="clausul">
				<tr height="20">
					<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="60%" valign="top" colspan="4"><c:out value="${clausul.description}" /></td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
<%--	<table class="listView" style="border-color: 000; border: 1px;" cellspacing="0" cellpadding="0" width="30%">
		<tbody>
			
			
				<c:forEach items="${memberBenefitList}" var="memberBenefit" varStatus="status" >
								
					 <tr height="20">
				      	<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="60%" valign="top">
				      		<c:if test="${memberBenefit.itemCategoryId.itemCategoryEDCName eq null}">
				      		<c:out value="${fn:toUpperCase(memberBenefit.itemCategoryId.itemCategoryName)}" />
				      		</c:if>
				      		<c:if test="${memberBenefit.itemCategoryId.itemCategoryEDCName ne null}">
				      		<c:out value="${fn:toUpperCase(memberBenefit.itemCategoryId.itemCategoryEDCName)}" />
				      		</c:if>
				      	
				      	</td>			
<!-- 				      	<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="10%" valign="top"></td> -->
						<td class="oddListRowS1" bgcolor="#e7f0fe" align=right width="30%" nowrap="nowrap" valign="top">
							Sesuai Bnf
						</td>				
				    </tr>   
					<tr>
				      <td colspan="20" class="listViewHRS1"></td>
				    </tr>	
				    
				</c:forEach>
				 <tr height="20">
			      	<td class="oddListRowS1" bgcolor="#e7f0fe" width="10%" nowrap="nowrap" valign="top" colspan="3"></td>
			    </tr> 
	
			<tr>
		      	<td colspan="20" class="listViewHRS1">&nbsp;</td>
		 	</tr>
		    <tr>
		      <td colspan="20" class="listViewHRS1">&nbsp;</td>
		    </tr>
			<c:forEach items="${policyClausulList}" var="clausul">
				<tr height="20">
					<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" width="60%" valign="top" colspan=3><c:out value="${clausul.description}" /></td>				
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
 --%>
</form>
	
<!-- Table Content Stop -->
	<!-- Table Toolbar Start -->
	
		<!-- Table Toolbar Stop -->



<!-- Table Container Stop -->
