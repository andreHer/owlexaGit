<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="com.ametis.cms.util.WebUtil" %>
<%@ taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<ul id="maintab" class="shadetabs">

	<li >
		<a href="membergroup?navigation=detail&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent1">Member Group</a>
	</li>
	
	<li >
		<a href="claim?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent4">Claim</a>
	</li>	
	<li >
		<a href="case?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent5">Case</a>
	</li>	
	<li > 
		<a href="membergroupprovider?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent6">Provider</a>
	</li>	
	<li >
		<a href="costcontainment?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent6">Cost Containment</a>
	</li>
	<li >
		<a href="excesscharge?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent7">Excess Charge</a>
	</li>	
	<li >
		<a href="policy?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent7">Policy</a>
	</li>
	<li class="selected" >
		<a href="quotation?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent7">Quotation</a>
	</li>
        	<li >
		<a href="contactperson?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent8">Contact Person</a>
	</li>

        <li >
		<a href="bankaccount?navigation=listgroup&memberGroupId=<c:out value="${memberGroupId}" />" rel="tcontent9">Bank Acount</a>
	</li>

</ul><br />
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
<!-- Search Container Start -->

<form name="form1" action="quotation" method="POST">
<input type="hidden" name="navigation" value="gosearch">
<input type="hidden" name="arah" value="">
<input type="hidden" name="memberGroupId" value="<c:out value="${memberGroupId}" />" />
<input type="hidden" name="index" value="<c:out value="${index}" />">
				<input type="hidden" name="quotationId" value="<c:out value="${quotation.quotationId}" />">
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td nowrap="nowrap"><h3><img src="images/h3Arrow.gif"  border="0">&nbsp;Search Quotation</h3></td>
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

 		   			<option value="quotationNo" <c:if test="${searchby eq \"quotationNo\"}">selected="true"</c:if> >Quotation No</option>
			   		   		   		   		   		   		   			<option value="remarks" <c:if test="${searchby eq \"remarks\"}">selected="true"</c:if> >Remarks</option>
			   		   		   		   		   		   		   		   		   		   		   		   		   		   		   		   			<option value="requestedBy" <c:if test="${searchby eq \"requestedBy\"}">selected="true"</c:if> >Requested By</option>
			   		   		   		   		   		   		   		   		   		   		   </select>
				
              </td>
			  <td class="dataLabel" nowrap="nowrap">Status:
              &nbsp;&nbsp;
              
                <select name="searchstatus">					
							
					<option value="">--SELECT ONE --</option>
					<option value="1">REQUESTED</option>
					<option value="2">REVISED</option>
					<option value="3">ACCEPTED</option>
					<option value="4">REJECTED</option>
				</select>
				
              </td>
            <td class="dataLabel">
              <input title="Search [Alt+Q]" accesskey="Q" class="ui-button ui-widget ui-state-default ui-corner-all ui-state-focus" name="button" value="Search" type="submit">
                          
			</td>
            </tr>
			<tr>
            
            <td class="dataLabel" nowrap="nowrap"> Minimum Date :
              &nbsp;&nbsp;&nbsp;&nbsp;
              
                <input name="minimum_date" id="jscal_field" tab="1" maxlength="10" size="11" readonly="readonly" value="" type="text">
				<img src="images/jscalendar.gif" alt="Enter Date" id="jscal_trigger" align="absmiddle" height="18" width="18">
				
				<script type="text/javascript">
    					Calendar.setup({
        					inputField     :    "jscal_field",     // id of the input field
        					ifFormat       :    "%Y/%m/%d",      // format of the input field
        					button         :    "jscal_trigger",  // trigger for the calendar (button ID)
        					align          :    "Tl",           // alignment (defaults to "Bl")
        					singleClick    :    true
    					});
				 	</script>
              
			</td>
            <td class="dataLabel" nowrap="nowrap"> Maximum Date :
              &nbsp;&nbsp;&nbsp;&nbsp;
              
            <input name="maximum_date" id="jscal_field_max" tabindex="1" maxlength="10" size="11" readonly="readonly" value="" type="text">
			<img src="images/jscalendar.gif" alt="Enter Date" id="jscal_max_trigger" align="absmiddle" height="18" width="18">
			
					<script type="text/javascript">
    					Calendar.setup({
        					inputField     :    "jscal_field_max",     // id of the input field
        					ifFormat       :    "%Y/%m/%d",      // format of the input field
        					button         :    "jscal_max_trigger",  // trigger for the calendar (button ID)
        					align          :    "Tl",           // alignment (defaults to "Bl")
        					singleClick    :    true
    					});
				 	</script>
			</td>
            <td class="dataLabel">&nbsp;&nbsp;
              </td>
            <td align="right">
            </td>
          </tr>
        </tbody>
      </table></td>
    </tr>
  </tbody>
</table>



<br />
<input type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-state-focus" onClick="javascript:tambahi()" value="Create Quotation">
 	<br />
<table class="listView" cellspacing="0" cellpadding="0" width="100%">
	<tbody>
	<tr>
      <td colspan="20" align="right"><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr>
            <td  align="left">
			</td>
            <td  align="right" nowrap="nowrap">
				
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
		<td width="2%" nowrap="nowrap" class="listViewThS1" scope="col">No.</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="19%">Quotation No &nbsp;</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="10%">Request Date &nbsp;</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="19%">Remarks &nbsp</td>	   		   		   		   		   		   		   		   		   		   		   		   		   		   		   		   			
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="19%">Requested By &nbsp;</td>
		<td scope="col" class="listViewThS1" nowrap="nowrap" width="10%"></td>
	</tr>


	<c:forEach items="${Quotations}" var="quotation" varStatus="status" >
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
			
				<a href="quotation?navigation=detail&memberGroupId=<c:out value="${memberGroupId}" />&quotationId=<c:out value="${quotation.quotationId}" />" class="linkDetail"> <c:out value="${quotation.quotationNo}" /></a>
			
		</td>
		<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top">
			
				<c:out value="${quotation.quotationDate}" />
			
		</td>
		
		<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top">
			
				<c:out value="${quotation.remarks}" />
			
		</td>
					   		   		   		   		   		   		   		   		   		   		   		   		   		   		   		   				<td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" valign="top">
			
				<c:out value="${quotation.requestedBy}" />
			
		</td>
					   		   		   		   		   		   		   		   		   		   		         <td class="oddListRowS1" bgcolor="#e7f0fe" nowrap="nowrap" align="center" valign="top">
		<a href="javascript:detil('<c:out value="${quotation.quotationId}" />')">
				<img src="images/view.gif" class="action_icon" alt="View" title="View"></a>

			<!-- ini default edit table for each data -->
			<a href="javascript:ubah('<c:out value="${quotation.quotationId}" />')">
				<img src="images/edit.gif" class="action_icon" alt="Edit" title="Edit"></a>

			<!-- ini default delete table for each data -->
			<a href="javascript:hapus('<c:out value="${quotation.quotationId}" />')">
				<img src="images/delete.gif" class="action_icon" alt="Delete" title="Delete"></a>
		
	  </td>
    </tr>
   
	<tr>
      <td colspan="20" class="listViewHRS1"></td>
    </tr>
	
	</c:forEach>
	
<tr>
            <td  align="left"></td>
            <td  align="right" nowrap="nowrap" colspan="20">
				
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
<%
String nav="";
if(request.getAttribute("navigation").equals("gosearch")||request.getAttribute("navigation").equals("golookup")){
	nav = (String)request.getAttribute("navigation");
}
%>
function tambahi (){
	document.form1.navigation.value = "tambah";
	document.form1.action = "quotation-form";
	document.form1.method = "GET";
	document.form1.submit();
}
function hapus (idx){
	var delConfirm = window.confirm ("Are You Sure Want To Delete This Entry ?");

	if (delConfirm){
		document.form1.method = "POST";
		document.form1.quotationId.value = idx;
		document.form1.action = "quotation";
		document.form1.navigation.value = "delete";
		document.form1.submit();
	}
}
function ubah (idx){
	document.form1.method = "GET";
	document.form1.quotationId.value = idx;
	document.form1.action = "quotation-form";
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
	document.form1.navigation.value = "gosearch";
	document.form1.action = "quotation";
	document.form1.method = "POST";
	document.form1.submit();
}
function detil (idx){
	document.form1.method = "POST";
	document.form1.quotationId.value = idx;
	document.form1.action = "quotation";
	document.form1.navigation.value = "detail";
	document.form1.submit();

}
</script>
