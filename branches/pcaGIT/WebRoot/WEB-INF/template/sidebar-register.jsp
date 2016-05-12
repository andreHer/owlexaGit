
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tbody>
		<tr>
			<td valign="top">
				<div id="handle-sidebar" class="handle-container-sidebar vertical-text-sidebar">
				    <div id="openCloseButton-sidebar" class="handle-button-item-sidebar">
				    	<span><img src="images/owlexa/arrow_up.png"/>Sidebar</span>
				    </div>
				</div>
			</td>
			<td>
				<div id="sidebar-container">
					<div id="openCloseIdentifier-sidebar"></div>
					
					<div class="sidebar" style="margin-left:-50px;">
						<span class="pendinglist-title">Notifications</span>
						<ul class="pendinglist">		
							<li><a href="claim?navigation=searchopenedc" title="">Open EDC Claim</a> <span class="pendinglist-notif" id="openEdcClaimNotifyId">0</span></li>		
							<li><a href="claim?navigation=searchopencase" title="">Open Case Claim</a> <span class="pendinglist-notif" id="openCaseClaimNotifyId">0</span></li>				
							<li><a href="batchclaim?status=1&navigation=gosearch" title="">Open Batch Claim</a> <span class="pendinglist-notif" id="openBatchNotifyId">0</span></li>
						</ul>
					</div>
					

				<!-- End Sidebar container -->
				</div>
			</td>
		</tr>
	</tbody>
</table>	

<script type="text/javascript">
		
		refreshData();		
		setInterval("refreshData()",50000);
		
		function refreshData(){
			refreshOpenBatch(); //done
			refreshOpenEDCClaim();
			refreshOpenCaseClaim();
		}		
		function refreshOpenBatch(){
			$.get("batchclaim?navigation=jsontotalopen",
				function(data) {					
					var label = document.getElementById("openBatchNotifyId");					
					var hasil = $.trim(data);
					
					assignLabel(label,data,hasil);
				});
		}
		function refreshOpenEDCClaim(){
			$.get("claim?navigation=jsontotalopenedc",
				function(data) {					
					var label = document.getElementById("openEdcClaimNotifyId");					
					var hasil = $.trim(data);
					
					assignLabel(label,data,hasil);
				});
		}
		function refreshOpenCaseClaim(){
			$.get("claim?navigation=jsontotalcaseclaim",
				function(data) {					
					var label = document.getElementById("openCaseClaimNotifyId");					
					var hasil = $.trim(data);
					
					assignLabel(label,data,hasil);					
				});
		}
		
		function assignLabel(label,data,hasil){						
			if (hasil == '0'){
				label.style.display = "none";						
			}
			else {
				if (!isNaN(hasil)){
					label.style.display = "";
					label.innerHTML = data;
				}
				else {
					label.style.display = "none";
				}
			}
		}
		
		
</script>