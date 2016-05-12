<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<form action="membergroup" method="POST" name="form1" id="form_layout">
<input type="hidden" name="navigation" value="">
<input type="hidden" name="memberGroupId" value="<c:out value="${memberGroup.memberGroupId}" />" />
	
	<%String alert = (String) request.getAttribute("alert");
			if (alert != null && !alert.trim().equals("")) {%>
							<div id="warning">
								<c:out value="${alert}"></c:out>
							</div>
							<%}%>
							
			
			
	<table class="tabForm" border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tbody>


						<tr>
								<td class="dataLabel">
									
								</td>


								<td class="dataField">
									
								</td>
								<td class="dataLabel">
								
								</td>
								<td class="dataField">
									
									
								</td>
							</tr>


							

							





							<tr>
								<td class="dataLabel">
									Member Group Name :
								</td>
								<td class="dataField">
									
										<input type="text" size="35" name="memberName" value="<c:out value="${memberGroup.groupName}"/>"  readonly="readonly">
									
								</td>
								
								<td class="dataLabel">
									Policy Number :
								</td>
								<td class="dataField">
									
										<input type="text" size="35" name="customerPolicyNumber" value="<c:out value="${memberGroup.policyNumber}"/>"  readonly="readonly"/>
										
								</td>
							
							
								
							</tr>






							<tr>
							
								
								
								
								
								<td class="dataLabel">
									Join Date :
								</td>
								<td class="dataField">
									
										<input type="text" size="25" name="joinDate" id="idJoinDate" value="<c:out value="${memberGroup.effectiveDate}" />" maxlength="30"  readonly="readonly">
										
								</td>
								<td class="dataLabel">								
									Expire Date :
								</td>
								<td class="dataField">
									
										<input type="text" size="25" name="expDate" id="idExpDate" value="<c:out value="${memberGroup.expireDate}" />" maxlength="30"  readonly="readonly">
										
								</td>
								
							</tr>



					<tr>
								<td class="dataLabel">
									Suspend Start Data :
								</td>
								<td class="dataField">
									<input type="text" size="25" name="startDate" id="idStartDate" value="" maxlength="30">
										<img src="images/jscalendar.gif" alt="Enter Date" id="startDate_trigger" align="absmiddle" height="20" width="20">
										<script type="text/javascript">
					    					Calendar.setup({
					        					inputField     :    "idStartDate",     // id of the input field
					        					ifFormat       :    "%Y-%m-%d",      // format of the input field
					        					button         :    "startDate_trigger",  // trigger for the calendar (button ID)
					        					align          :    "Bl",           // alignment (defaults to "Bl")
					        					singleClick    :    true
					    					});
									 	</script>										
								</td>
								<td class="dataLabel">								
									Suspend End Date :
								</td>
								<td class="dataField">
									<input type="text" size="25" name="endDate" id="idEndDate" value="" maxlength="30">
										<img src="images/jscalendar.gif" alt="Enter Date" id="endDate_trigger" align="absmiddle" height="20" width="20">
										<script type="text/javascript">
					    					Calendar.setup({
					        					inputField     :    "idEndDate",     // id of the input field
					        					ifFormat       :    "%Y-%m-%d",      // format of the input field
					        					button         :    "endDate_trigger",  // trigger for the calendar (button ID)
					        					align          :    "Bl",           // alignment (defaults to "Bl")
					        					singleClick    :    true
					    					});
									 	</script>																				
								</td>
								
							</tr>



							
							<tr>
		
								<td class="dataLabel">
									Block Reason :
								</td>
								<td class="dataField" colspan="3">									
									<textarea rows="6" cols="40" name="reason"></textarea>
								</td>
							</tr>

							<tr>
								<td class="dataLabel">
									
								</td>


								<td class="dataField">
									
								</td>
								<td class="dataLabel">
								
								</td>
								<td class="dataField">
									
									
								</td>
							</tr>
						</tbody>						
					</table>					
				</td>
			</tr>			
		</tbody>			
	</table>
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td style="padding-top: 2px;">
					<input type="hidden" name="notyet" value="">
					<input title="Save [Alt+Shift+S]" accesskey="S" class="ui-button ui-widget ui-state-default ui-corner-all ui-state-focus" onClick="javascript:simpan()" name="Save" value=" Save " type="submit">
					<input title="Cancel [Alt+Shift+C]" accesskey="C" class="ui-button ui-widget ui-state-default ui-corner-all ui-state-focus" onClick="javascript:kembali()" name="Cancel" value=" Cancel " type="button">
				</td>
				<td align="right"></td>
			</tr>
		</tbody>
	</table>

</form>

<script language="javascript">
	function simpan (){

		document.form1.method = "POST";
		document.form1.navigation.value = "block";
		document.form1.action = "membergroup";
		document.form1.submit();
	}
	function kembali (){
		document.form1.navigation.value = "detail";
		document.form1.action = "membergroup";
		document.form1.submit();
	}
	
				// forreign affairs end
</script>
