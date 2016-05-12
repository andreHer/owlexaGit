
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="com.ametis.cms.util.WebUtil" %>
<%@ taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<%
String navigation = WebUtil.getAttributeString(request,"navigation","");
%>

<!-- Page Title Stop-->
<%
String alert = (String) request.getAttribute("alert");
int index = 0;
int totalIndex = 0;
int count = 0;
int countSet = 0;

try {
	index = ((Integer) request.getAttribute ("index")).intValue();
	count = ((Integer) request.getAttribute ("count")).intValue();
	countSet = ((Integer) request.getAttribute ("countSet")).intValue();
	totalIndex = ((Integer) request.getAttribute ("halAkhir")).intValue();
	
	
	
}
catch (Exception e){
}

if (alert != null && !alert.trim().equals("")) {%>
	<div id="warning" align="center">
		<c:out value="${alert}"></c:out>
	</div>
	<%}%>

<%
String rowclass = "";
int i=0;
int indexint = Integer.parseInt(request.getAttribute("index").toString());
WebUtil.getAttributeInteger(request,"index",0).intValue();
%>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td nowrap="nowrap"><h3><img src="images/h3Arrow.gif"  border="0">&nbsp;List Member Diagnosis Exclusion</h3></td>
      <td width="100%"><img src="images/blank.gif"  height="1" width="1"></td>
      <c:if test="${theUser.userType eq 2 }">
	      <td align="right">
	      	<input title="Error Log"  name="errorLog" id="errorLog" value=" Error Log " class="errorLog" type="button" onClick="javascript:printErrorLog()">
	      </td>
	      <td align="right">
	      	<input title="Add Error Log"  name="addErrorLog" value=" Add Error Log " class="errorLog" type="button" onClick="javascript:adderrorlog()">
	      </td>
      </c:if>
    </tr>
  </tbody>
</table>

<!-- Search Container Start -->

<%@ include file="../mainContentMember.jsp" %>
	
<form name="form1" action="memberdiagnosisexclusion" method="POST">
<input type="hidden" name="navigation" value="">
<input type="hidden" name="arah" value="">

<input type="hidden" name="memberId" value="<c:out value="${memberId}" />">
<input type="hidden" name="index" value="<c:out value="${index}" />">

<input type="hidden" name="id" value="<c:out value="${memberDiagnosisExclusion.id}" />">
<br />

<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td nowrap="nowrap"><h3><img src="images/h3Arrow.gif"  border="0">&nbsp;Search Member Diagnosis Exclusion</h3></td>
      <td width="100%"><img src="images/blank.gif"  height="1" width="1"></td>
    </tr>
  </tbody>
</table>

<table class="tabForm" border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr>
            <form>
            </form>
            <td class="dataLabel" nowrap="nowrap">Search Keyword:
              &nbsp;&nbsp;
              
				<input size="20" name="searchtext" class="dataField" value="<c:out value="${searchtext}"/>" type="text">
              </td>
            <td class="dataLabel" nowrap="nowrap">Search Category:
              &nbsp;&nbsp;
              
                
				<select name="searchby" class="inputbox">
   		   		   	<option value="diagnosisCode" <c:if test="${searchby eq \"diagnosisCode\"}">selected="true"</c:if> >Diagnosis Code</option>
   		   		   	<option value="diagnosisName" <c:if test="${searchby eq \"diagnosisName\"}">selected="true"</c:if> >Diagnosis Name</option>
   		   		   	<option value="description" <c:if test="${searchby eq \"description\"}">selected="true"</c:if> >Description</option>
			   </select>
				
              </td>
			  <td class="dataLabel" nowrap="nowrap">
              </td>
              <td class="dataLabel">
              <input title="Search [Alt+Shift+Q]" accesskey="Q" class="ui-button ui-widget ui-state-default ui-corner-all ui-state-focus" onClick="javascript:cari();" name="button" value="Search" type="submit">
             </td>
            </tr>
            <tr>         
	            <td class="dataLabel" nowrap="nowrap"> Minimum Date :
	              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	              
	                <input name="minimum_date" id="jscal_field" tab="1" maxlength="10" size="11" value="<c:out value="${minimumDate}" />" type="text">
					<img src="images/jscalendar.gif" alt="Enter Date" id="jscal_trigger" align="absmiddle" height="18" width="18">
					
					<script type="text/javascript">
	    					Calendar.setup({
	        					inputField     :    "jscal_field",     // id of the input field
	        					ifFormat       :    "%Y-%m-%d",      // format of the input field
	        					button         :    "jscal_trigger",  // trigger for the calendar (button ID)
	        					align          :    "Tl",           // alignment (defaults to "Bl")
	        					singleClick    :    true
	    					});
					 	</script>
	              
				</td>
	            <td class="dataLabel" nowrap="nowrap"> Maximum Date :
	              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	              
	            <input name="maximum_date" id="jscal_field_max" tabindex="1" maxlength="10" size="11" value="<c:out value="${maximumDate}" />" type="text">
				<img src="images/jscalendar.gif" alt="Enter Date" id="jscal_max_trigger" align="absmiddle" height="18" width="18">
				
						<script type="text/javascript">
	    					Calendar.setup({
	        					inputField     :    "jscal_field_max",     // id of the input field
	        					ifFormat       :    "%Y-%m-%d",      // format of the input field
	        					button         :    "jscal_max_trigger",  // trigger for the calendar (button ID)
	        					align          :    "Tl",           // alignment (defaults to "Bl")
	        					singleClick    :    true
	    					});
					 	</script>
				</td>
            </tr>
		</tbody>
      </table></td>
    </tr>
  </tbody>
</table>

<br />

 	
<table class="listView" cellspacing="0" cellpadding="0" width="100%">
	<tbody>
	<tr>
      <td colspan="20" align="right"><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr>
            <td class="listViewPaginationTdS1" align="left"></td>
            <td class="listViewPaginationTdS1" align="right" nowrap="nowrap">
				
				<%
				if (index == 1){
				%>
				<img src="images/start_off.gif" alt="Start" align="absmiddle" border="0" height="10" width="9">
					Start&nbsp;
									
				<img src="images/previous_off.gif" alt="Previous" align="absmiddle" border="0" height="10" width="4">
					Previous&nbsp;&nbsp;					
				<%
				}
				else if ((index-1) > 0){
				
				%>
				<img src="images/start.gif" alt="Start" align="absmiddle" border="0" height="10" width="9">
					<a href="javascript:goleftbgt()" class="listViewPaginationLinkS1">
						Start&nbsp;
					</a>				
				
				<img src="images/previous.gif" alt="Previous" align="absmiddle" border="0" height="10" width="4">
					<a href="javascript:goleft()" class="listViewPaginationLinkS1">
					Previous&nbsp;&nbsp;
					</a>
				<%
				}
				%>
					<span class="pageNumbers">(<c:out value="${minIndex}" /> - <c:out value="${maxIndex}" /> of <c:out value="${count}" />)</span>&nbsp;&nbsp;
				
				<%
				if (totalIndex > index){
				%>
				
				<a href="javascript:goright()" class="listViewPaginationLinkS1">Next&nbsp;
				<img src="images/next.gif" alt="Next" align="absmiddle" border="0" height="10" width="4"></a>&nbsp;&nbsp;
				<a href="javascript:gorightbgt()" class="listViewPaginationLinkS1">End&nbsp;
					<img src="images/end.gif" alt="End" align="absmiddle" border="0" height="10" width="9"></a>
				<%
				} else {
				
				%>
				Next&nbsp;
				<img src="images/next_off.gif" alt="Next" align="absmiddle" border="0" height="10" width="4">
				&nbsp;&nbsp;
				End&nbsp;
					<img src="images/end_off.gif" alt="End" align="absmiddle" border="0" height="10" width="9">
				<%
				}
				%>
			</td>
          </tr>
        </tbody>
      </table></td>
    </tr>
	<tr height="20">
		<td width="6%" nowrap="nowrap" class="listViewThS1" scope="col">
			<img src="images/blank.gif" alt="asd" height="1" width="1">No.</td>		
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="10%">Diagnosis Code</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="15%">Diagnosis Name</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="20%">Description</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="10%">Exclusion End Date</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="10%">Duration</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="10%">Age Parameter</td>
	</tr>


	<c:forEach items="${MemberDiagnosisExclusions}" var="memberDiagnosisExclusion" varStatus="status" >
	<%	if (i % 2 == 0) {
			rowclass = "col1";
		} else if (i % 2 != 0) {
			rowclass= "col2";
		}
		i++;
	%>
	 <tr height="20">
      	<td class="oddListRowS1" align="center" bgcolor="#e7f0fe" nowrap="nowrap" valign="top"><%=(i+((indexint-1)*countSet))%></td>
      	<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top">			
				<c:out value="${memberDiagnosisExclusion.diagnosisId.diagnosisCode}" />			
		</td>
		<td class="oddListRowS1" bgcolor="#e7f0fe"  valign="top">			
			<c:out value="${memberDiagnosisExclusion.diagnosisId.diagnosisName}" />			
		</td>
		<td class="oddListRowS1" bgcolor="#e7f0fe" align="top" valign="top">
			<c:out value="${memberDiagnosisExclusion.diagnosisId.description}" />
	  	</td>
	  	<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top">			
			<c:out value="${memberDiagnosisExclusion.expireDate}" />
		</td>
		<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top">			
			<c:out value="${memberDiagnosisExclusion.preExistingDays}" /> day(s)
		</td>
		<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top">		
			<c:if test="${memberDiagnosisExclusion.ageParameter eq 'GT'}">
				Lebih Dari 
			</c:if>
			<c:if test="${memberDiagnosisExclusion.ageParameter eq 'LT'}">
				Kurang Dari 
			</c:if>	
			<c:out value="${memberDiagnosisExclusion.ageConstraint}" /> (days)
		</td>
    </tr>
   
	<tr>
      <td colspan="20" class="listViewHRS1"></td>
    </tr>
	
	</c:forEach>
	
<tr>
            <td class="listViewPaginationTdS1" align="left"></td>
            <td class="listViewPaginationTdS1" align="right" nowrap="nowrap" colspan="20">
				
				<%
				if (index == 1){
				%>
				<img src="images/start_off.gif" alt="Start" align="absmiddle" border="0" height="10" width="9">
					Start&nbsp;
									
				<img src="images/previous_off.gif" alt="Previous" align="absmiddle" border="0" height="10" width="4">
					Previous&nbsp;&nbsp;					
				<%
				}
				else if ((index-1) > 0){
				
				%>
				<img src="images/start.gif" alt="Start" align="absmiddle" border="0" height="10" width="9">
					<a href="javascript:goleftbgt()" class="listViewPaginationLinkS1">
						Start&nbsp;
					</a>				
				
				<img src="images/previous.gif" alt="Previous" align="absmiddle" border="0" height="10" width="4">
					<a href="javascript:goleft()" class="listViewPaginationLinkS1">
					Previous&nbsp;&nbsp;
					</a>
				<%
				}
				%>
					<span class="pageNumbers">(<c:out value="${minIndex}" /> - <c:out value="${maxIndex}" /> of <c:out value="${count}" />)</span>&nbsp;&nbsp;
				
				<%
				if (totalIndex > index){
				%>
				
				<a href="javascript:goright()" class="listViewPaginationLinkS1">Next&nbsp;
				<img src="images/next.gif" alt="Next" align="absmiddle" border="0" height="10" width="4">
				</a>&nbsp;&nbsp;
				<a href="javascript:gorightbgt()" class="listViewPaginationLinkS1">End&nbsp;
					<img src="images/end.gif" alt="End" align="absmiddle" border="0" height="10" width="9">
				</a>
				<%
				} else {
				
				%>
				Next&nbsp;
				<img src="images/next_off.gif" alt="Next" align="absmiddle" border="0" height="10" width="4">
				&nbsp;&nbsp;
				End&nbsp;
					<img src="images/end_off.gif" alt="End" align="absmiddle" border="0" height="10" width="9">
				<%
				}
				%>
			</td>
          </tr>
	</tbody>
	</table>
</form>
	
<!-- Table Content Stop -->
	<!-- Table Toolbar Start -->
	
		<!-- Table Toolbar Stop -->



<!-- Table Container Stop -->
<script language="Javascript">
$(document).ready(function(){
	$.get("firstcall?navigation=jsontotalmemberelog&memberId=<c:out value="${member.memberId }"/>", function(data){
	  //alert("Data: " + data);
	  if(data>0){
	  	blinker();
	  }
	});
});
function blinker(){
	document.getElementById("errorLog").style.backgroundColor="red";
	setTimeout("document.getElementById('errorLog').style.backgroundColor=''", 500);
	setTimeout("blinker()",1500);
}
<%
String nav="";
if(request.getAttribute("navigation").equals("gosearch")||request.getAttribute("navigation").equals("golookup")){
	nav = (String)request.getAttribute("navigation");
}
%>
function tambahi (){
	document.form1.navigation.value = "tambah";
	document.form1.action = "memberdiagnosisexclusion-form";
	document.form1.method = "GET";
	document.form1.submit();
}
function hapus (idx){
	var delConfirm = window.confirm ("Are You Sure Want To Delete This Entry ?");

	if (delConfirm){
		document.form1.method = "POST";
		document.form1.id.value = idx;
		document.form1.action = "memberdiagnosisexclusion";
		document.form1.navigation.value = "delete";
		document.form1.submit();
	}
}
function ubah (idx){
	document.form1.method = "GET";
	document.form1.id.value = idx;
	document.form1.action = "memberdiagnosisexclusion-form";
	document.form1.navigation.value = "edit";
	document.form1.submit();
}
function goleft(){
	document.form1.navigation.value = "<%=nav%>";
	document.form1.arah.value="kiri";
	document.form1.method = "POST";
	document.form1.submit();
}
function goleftbgt(){
	document.form1.navigation.value = "<%=nav%>";
	document.form1.arah.value="kiribgt";
	document.form1.method = "POST";
	document.form1.submit();
}
function goright(){
	document.form1.navigation.value = "<%=nav%>";
	document.form1.arah.value="kanan";
	document.form1.method = "POST";
	document.form1.submit();
}
function gorightbgt(){
	document.form1.navigation.value = "<%=nav%>";
	document.form1.arah.value="kananbgt";
	document.form1.method = "POST";
	document.form1.submit();
}
function go(){
	document.form1.navigation.value = "<%=nav%>";
	document.form1.submit();
}
function cari (){
	document.form1.navigation.value = "";
	document.form1.action = "memberdiagnosisexclusion";
	document.form1.method = "POST";
	document.form1.submit();
}
function detil (idx){
	document.form1.method = "POST";
	document.form1.id.value = idx;
	document.form1.action = "memberdiagnosisexclusion";
	document.form1.navigation.value = "detail";
	document.form1.submit();

}
function printErrorLog(){
	window.open ("firstcall?navigation=searchmembererrorlog&memberId=<c:out value="${member.memberId}" />","Search","width=1024, height=768, menubar=yes, status=no, toolbar=no, scrollbars=yes, resizable=yes");		
}

function adderrorlog (){ 
	window.location.href = "firstcall-form?navigation=memberelog&memberId=<c:out value="${member.memberId}" />";
}
</script>
