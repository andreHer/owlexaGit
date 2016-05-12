package com.ametis.cms.web.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import com.ametis.cms.datamodel.ActionUser;
import com.ametis.cms.datamodel.Client;
import com.ametis.cms.datamodel.ClientProvider;
import com.ametis.cms.datamodel.Member;
import com.ametis.cms.datamodel.MemberGroup;
import com.ametis.cms.datamodel.Policy;
import com.ametis.cms.service.ActivityLogService;
import com.ametis.cms.service.ClientProviderService;
import com.ametis.cms.service.ClientService;
import com.ametis.cms.service.MemberGroupService;
import com.ametis.cms.service.MemberService;
import com.ametis.cms.service.PolicyService;
import com.ametis.cms.service.SecurityService;
import com.ametis.cms.service.UserService;
import com.ametis.cms.util.WebUtil;
import com.ametis.cms.util.servlet.TableRenderingServlet;

// imports+ 

// imports- 

/**
 * ClientProvider is a servlet controller for client_provider Table. All you
 * have to do is to convert necessary data field to the named parameter
 */
public class ClientProviderController implements Controller

// extends+

// extends-

{

	private ClientProviderService clientProviderService;

	private UserService userService;

	private ResourceBundleMessageSource alertProperties;
	
	private ClientService clientService;
	
	private MemberGroupService memberGroupService;
	private MemberService memberService;

	private Integer countSet;

	private Integer maxPercountSet;
	private SecurityService securityService;
private ActivityLogService logService;

	private PolicyService policyService;
	
	
	public ClientService getClientService() {
		return clientService;
	}
	
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	public PolicyService getPolicyService() {
		return policyService;
	}

	public void setPolicyService(PolicyService policyService) {
		this.policyService = policyService;
	}

	public ActivityLogService getLogService() {
		return logService;
	}

	public void setLogService(ActivityLogService logService) {
		this.logService = logService;
	}
	
	public MemberGroupService getMemberGroupService() {
		return memberGroupService;
	}

	public void setMemberGroupService(MemberGroupService memberGroupService) {
		this.memberGroupService = memberGroupService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setCountSet(Integer countSet) {
		this.countSet = countSet;
	}

	public Integer getCountSet() {
		return this.countSet;
	}

	public void setMaxPercountSet(Integer maxCount) {
		this.maxPercountSet = maxCount;
	}

	public Integer getMaxPercountSet() {
		return this.maxPercountSet;
	}

	public void setAlertProperties(ResourceBundleMessageSource alert) {
		this.alertProperties = alert;
	}

	public ResourceBundleMessageSource getAlertProperties() {
		return alertProperties;
	}

	public void setClientProviderService(
			ClientProviderService clientProviderService) {
		this.clientProviderService = clientProviderService;
	}

	public ClientProviderService getClientProviderService() {
		return this.clientProviderService;
	}

	public ModelAndView deletePerformed(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView result = null;

		try {
			Integer clientProviderId = WebUtil.getParameterInteger(request,
					"clientProviderId");

			
			
			java.io.Serializable pkey = clientProviderId;

			ActionUser user= securityService.getActionUser(request); 
			
			boolean isUserAuthorized = securityService.isUserAuthorized(user, "DELETECLIENTPROVIDER");
			
			if (!isUserAuthorized){
				
				ModelAndView errorResult = new ModelAndView(new RedirectView("errorpage"));	errorResult.addObject("errorType","accessDenied");			
				errorResult.addObject("errorMessage", "You Are Not Authorized for DELETECLIENTPROVIDER access");
				return errorResult;
				
			}
			String[] clientProviders = request.getParameterValues("clientProviderDelete");
			
			
			boolean resDelete = clientProviderService.deleteClientProviders(clientProviders, user);

			if (resDelete) {
				request.setAttribute("alert", alertProperties.getMessage(
						"success.delete.clientprovider", null, "success",
						Locale.getDefault()));
			} else {
				request.setAttribute("alert", alertProperties.getMessage(
						"fail.delete.clientprovider", null, "fail", Locale
								.getDefault()));

			}
			result = searchPerformed(request, response, "searchClientProvider");
		} catch (Exception e) {
			// nanti kalo sudah OK codenya e.printStackTrace nya di hapus saja
			e.printStackTrace();
			request.setAttribute("alert", alertProperties.getMessage(
					"system.error " + e.getMessage(), null, "fail", Locale
							.getDefault()));
			result = new ModelAndView("error");
		}
		return result;
	}

	public ModelAndView detailPerformed(HttpServletRequest request,
			HttpServletResponse response, String location) throws Exception {
		ModelAndView result = null;

		try {

			ActionUser user= securityService.getActionUser(request); 
			
			boolean isUserAuthorized = securityService.isUserAuthorized(user, "DETAILCLIENTPROVIDER");
			
			if (!isUserAuthorized){
				
				ModelAndView errorResult = new ModelAndView(new RedirectView("errorpage"));	errorResult.addObject("errorType","accessDenied");			
				errorResult.addObject("errorMessage", "You Are Not Authorized for DELETECLIENTPROVIDER access");
				return errorResult;
				
			}			
			Integer clientProviderId = WebUtil.getParameterInteger(request,
					"clientProviderId");

			Integer index = WebUtil.getParameterInteger(request, "index");
			String searchtext = WebUtil.getParameterString(request,
					"searchtext", "");
			String searchby = WebUtil.getParameterString(request, "searchby",
					"");
			/*
			 * Pkey ini merupakan representasi dari primary key, misalkan hasil
			 * get dari attribute diatas ^ itu cuma ada 1 key saja berarti
			 * tinggal pkey = <nama var diatas> tapi kalau misalkan composite
			 * primary key berarti tinggal bikin representasi primary key nya
			 * saja .
			 */

			result = new ModelAndView(location);
			java.io.Serializable pkey = clientProviderId;
			ClientProvider object = clientProviderService.get(pkey);

			if (object == null) {
				request.setAttribute("alert", alertProperties.getMessage(
						"not.found.clientprovider", null, "fail", Locale
								.getDefault()));
			}
			/*
			 * convention .. kalo mau nampilkan sebuah object pake BeanClass aja
			 * ya .. ga pake 's' -adhit
			 */

			result.addObject("clientProvider", object);
			result.addObject("index", index);
			result.addObject("searchtext", searchtext);
			result.addObject("searchby", searchby);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("alert", alertProperties.getMessage(
					"system.error " + e.getMessage(), null, "fail", Locale
							.getDefault()));

			result = new ModelAndView("error");
		}

		return result;
	}

	public ModelAndView searchPerformed(HttpServletRequest request,
			HttpServletResponse response, String location) throws Exception {
		ModelAndView result = null;
		try {
			
			ActionUser user= securityService.getActionUser(request); 
			
			boolean isUserAuthorized = securityService.isUserAuthorized(user, "DELETECLIENTPROVIDER");
			
			if (!isUserAuthorized){
				
				ModelAndView errorResult = new ModelAndView(new RedirectView("errorpage"));	errorResult.addObject("errorType","accessDenied");			
				errorResult.addObject("errorMessage", "You Are Not Authorized for DELETECLIENTPROVIDER access");
				return errorResult;
				
			}
			
			String currentNavigation = WebUtil.getParameterString(request,"currentnavigation","");
			

			String rowset = WebUtil.getParameterString(request, "rowset", "0");

			Integer index = WebUtil.getParameterInteger(request, "index");

			String navigation = WebUtil.getParameterString(request,
					"navigation", "");
			String searchtext = WebUtil.getParameterString(request,
					"searchtext", "");
			String searchby = WebUtil.getParameterString(request, "searchby",
					"");
			String sortby = WebUtil.getParameterString(request, "sortby", "");
			
			Integer clientId = WebUtil.getParameterInteger(request, "clientId");
			
			Integer memberId = WebUtil.getParameterInteger(request, "memberId");

			Integer memberGroupId = WebUtil.getParameterInteger(request, "memberGroupId");
			
			String subnavigation = WebUtil.getParameterString(request,"subnavigation","");
			
			
			if (currentNavigation.equalsIgnoreCase("listmember")){
				location = "listMemberProvider";
			}
			else if (currentNavigation.equalsIgnoreCase("listclient")){
				location = "listClientProvider";
			}
			else if (currentNavigation.equalsIgnoreCase("listgroup")){
				location = "listGroupProvider";
			}
			
			result = new ModelAndView(location);
			
			result.addObject("subnavigation",subnavigation);
			result.addObject("currentnavigation", currentNavigation);
			
			int minIndex = 0;
			int maxIndex = 0;
			int totalIndex = 0;

			Collection collection = null;

			int rowsetint = 0;
			int count = 0;
			
			Policy currentPolicy = null;
			
			if (memberId != null){
				String[] requiredMember = {"Member.MemberGroupId","Member.ClientId",
						"Member.RelationshipId","Member.ParentMember"};
				Member object = memberService.get(memberId,requiredMember);
				result.addObject("member", object);
				
				if (object != null){
					currentPolicy = object.getCurrentPolicyId();
				}
			}
			

			if (StringUtils.isNumeric(rowset)) {
				rowsetint = Integer.parseInt(rowset);
			}
			Vector vLikeP = new Vector();
			Vector vLikeQ = new Vector();
			Vector vEqP = new Vector();
			Vector vEqQ = new Vector();
			if (navigation.equals("gosearch") || navigation.equals("golookup") || navigation.equals("list") || navigation.equals("listclient")) {

				if (searchby != null) {
			

					if (searchby.equalsIgnoreCase("province")) {
						vLikeP.add("providerId.province");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("country")) {
						vLikeP.add("providerId.country");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("city")) {
						vLikeP.add("providerId.city");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("providerName")){
						vLikeP.add("providerId.providerName");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("providerCategoryName")){
						vLikeP.add("providerId.providerCategoryId.providerCategoryName");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("providerCode")){
						vLikeP.add("providerId.providerCode");
						vLikeQ.add(searchtext);
					}
				}

			}

			result.addObject("clientId",clientId);
			result.addObject("memberId",memberId);
			result.addObject("memberGroupId", memberGroupId);
			
			if (navigation.equalsIgnoreCase("list")){
				
				vEqP.add("clientId.clientId");
				vEqQ.add(clientId);
				
			}
			else if (navigation.equalsIgnoreCase("listmember")){
				Member member = memberService.get(memberId);
				
				if (member != null){
					clientId = member.getClientId().getClientId();
					vEqP.add("clientId.clientId");
					vEqQ.add(clientId);
				}
				
				
			}
			else if (navigation.equalsIgnoreCase("listgroup")){
				MemberGroup memberGroup = memberGroupService.get(memberGroupId);
				
				if (memberGroup != null){
					
					Client client = memberGroup.getClientId();
					
					if (client != null){
						vEqP.add("clientId.clientId");
						vEqQ.add(client.getClientId());
					}
					
				}
				result.addObject("memberGroupId", memberGroupId);
				//
			}
			else {
				if (clientId != null){
					vEqP.add("clientId.clientId");
					vEqQ.add(clientId);
				}
				else {
					if (memberGroupId != null){
						MemberGroup memberGroup = memberGroupService.get(memberGroupId);

						Client client = memberGroup.getClientId();
						
						if (client != null){
							vEqP.add("clientId.clientId");
							vEqQ.add(client.getClientId());
						}
						
					}
					if (memberId != null){
						Member member = memberService.get(memberId);
						
						if (member != null){
							clientId = member.getClientId().getClientId();
							vEqP.add("clientId.clientId");
							vEqQ.add(clientId);
						}		
					}
				}
			}
			
			vEqP.add("deletedStatus");
			vEqQ.add(Integer.valueOf(0));

			String sLikeP[] = new String[vLikeP.size()];
			vLikeP.toArray(sLikeP);
			Object sLikeQ[] = new Object[vLikeP.size()];
			vLikeQ.toArray(sLikeQ);

			String sEqP[] = new String[vEqP.size()];
			vEqP.toArray(sEqP);
			Object sEqQ[] = new Object[vEqP.size()];
			vEqQ.toArray(sEqQ);

			count = clientProviderService.getTotal(sLikeP, sLikeQ, sEqP, sEqQ);

			String arah = WebUtil.getParameterString(request, "arah", "");

			if (index == null)
				index = new Integer(1);

			if (arah.equals("kanan"))
				index = new Integer(index.intValue() + 1);
			else if (arah.equals("kiri"))
				index = new Integer(index.intValue() - 1);
			else if (arah.equals("kiribgt"))
				index = new Integer(1);
			else if (arah.equals("kananbgt"))
				index = new Integer(count / countSet.intValue() + 1);

			if (index.compareTo(new Integer(1)) == new Integer(-1).intValue())
				index = new Integer(1);
			else if (index.compareTo(new Integer(count / countSet.intValue()
					+ 1)) == new Integer(1).intValue())
				index = new Integer(count / countSet.intValue() + 1);

			rowsetint = (new Integer((index.intValue() - 1)
					* countSet.intValue())).intValue();
			if (count % countSet.intValue() > 0) {
				result.addObject("halAkhir", new Integer(count
						/ countSet.intValue() + 1));
			} else {
				result.addObject("halAkhir", new Integer(count
						/ countSet.intValue()));
			}

			minIndex = (index - 1) * countSet;
			maxIndex = index * countSet;

			if (maxIndex > count) {
				maxIndex = count;
			}

			String required[] = new String[] {};
			collection = clientProviderService.search(sLikeP, sLikeQ, sEqP,
					sEqQ, required, rowsetint, countSet.intValue());

			if (collection.size() <= 0) {
				index = new Integer(index.intValue() - 1);
				if (index.compareTo(new Integer(1)) == new Integer(-1)
						.intValue())
					index = new Integer(1);
				else if (index.compareTo(new Integer(count
						/ countSet.intValue() + 1)) == new Integer(1)
						.intValue())
					index = new Integer(count / countSet.intValue() + 1);

				rowsetint = (new Integer((index.intValue() - 1)
						* countSet.intValue())).intValue();
				if (count % countSet.intValue() > 0) {
					result.addObject("halAkhir", new Integer(count
							/ countSet.intValue() + 1));
				} else {
					result.addObject("halAkhir", new Integer(count
							/ countSet.intValue()));
				}
				collection = clientProviderService.search(sLikeP, sLikeQ, sEqP,
						sEqQ, required, rowsetint, countSet.intValue());
			}

			request.setAttribute("searchtext", searchtext);
			request.setAttribute("searchby", searchby);
			request.setAttribute("navigation", navigation);

			Client clientObject = null;
			
			if(clientId != null){
				try
				{
				java.io.Serializable clientpkey = clientId;
				System.out.println("member client id : "+clientId);
				String[] clientRequired = {"Client.FundCurrency","Client.PaymentCurrency","Client.StatusId"};
				clientObject = clientService.get(clientpkey, clientRequired);
				
				}
				catch (Exception ex)
				{
					System.out.println("member group object : "+clientObject.getAddress());
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			}
			
			result.addObject("ClientProviders", collection);
			result.addObject("client", clientObject);

			request.setAttribute("countSet", countSet);
			request.setAttribute("index", new Integer(index));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("alert", request.getParameter("alert"));
			request.setAttribute("minIndex", new Integer(minIndex));
			request.setAttribute("maxIndex", new Integer(maxIndex));

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("alert", alertProperties.getMessage(
					"system.error " + e.getMessage(), null, "fail", Locale
							.getDefault()));

			result = new ModelAndView("error");
		}

		return result;
	}
	public ModelAndView saveClientProviders (HttpServletRequest request, HttpServletResponse response, String location) throws Exception {
		
		ModelAndView result = null;
		
		try {
			
ActionUser user= securityService.getActionUser(request); 
			
			boolean isUserAuthorized = securityService.isUserAuthorized(user, "DELETECLIENTPROVIDER");
			
			if (!isUserAuthorized){
				
				ModelAndView errorResult = new ModelAndView(new RedirectView("errorpage"));	
				errorResult.addObject("errorType","accessDenied");			
				errorResult.addObject("errorMessage", "You Are Not Authorized for DELETECLIENTPROVIDER access");
				return errorResult;
				
			}

			String navigation = WebUtil.getParameterString(request,
					"navigation", "");
			
			
			Integer clientId = WebUtil.getParameterInteger(request, "clientId");
			
			String[] providerId = request.getParameterValues("providers");
			
			String subnavigation = WebUtil.getParameterString(request,"subnavigation","");

			String searchtext = WebUtil.getParameterString(request, "searchtext", "");
			String searchby = WebUtil.getParameterString(request, "searchby", "");
			Integer searchStatus = WebUtil.getParameterInteger(request, "status");


			clientProviderService.saveClientProviders(providerId, clientId, user);
			
			result = new ModelAndView(new RedirectView("provider?navigation=addclientprovider&clientId="+clientId+"&searchtext="+searchtext+"&searchby="+searchby));
		//	result.addObject(searchtext, searchtext);
		//	result.addObject("searchby",searchby);
		//	result.addObject("status", searchStatus);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("alert", alertProperties.getMessage(
					"system.error " + e.getMessage(), null, "fail", Locale
							.getDefault()));

			result = new ModelAndView("error");
		}

		return result;

	}
	public ModelAndView searchUnassignedPerformed(HttpServletRequest request,
			HttpServletResponse response, String location) throws Exception {
		ModelAndView result = null;
		try {
			result = new ModelAndView(location);

			String rowset = WebUtil.getParameterString(request, "rowset", "0");

			Integer index = WebUtil.getParameterInteger(request, "index");

			String navigation = WebUtil.getParameterString(request,
					"navigation", "");
			String searchtext = WebUtil.getParameterString(request,
					"searchtext", "");
			String searchby = WebUtil.getParameterString(request, "searchby",
					"");
			String sortby = WebUtil.getParameterString(request, "sortby", "");
			
			Integer clientId = WebUtil.getParameterInteger(request, "clientId");
			
			Integer memberId = WebUtil.getParameterInteger(request, "memberId");

			String subnavigation = WebUtil.getParameterString(request,"subnavigation","");
			result.addObject("subnavigation",subnavigation);
			
			int minIndex = 0;
			int maxIndex = 0;
			int totalIndex = 0;

			Collection collection = null;

			int rowsetint = 0;
			int count = 0;

			if (StringUtils.isNumeric(rowset)) {
				rowsetint = Integer.parseInt(rowset);
			}
			Vector vLikeP = new Vector();
			Vector vLikeQ = new Vector();
			Vector vEqP = new Vector();
			Vector vEqQ = new Vector();
			if (navigation.equals("searchunassigned")) {

				if (searchby != null) {
					/**
					 * ini querynya disesuaikan dengan apa yang mau di search
					 * default nya gue bikin template search by semua field yang
					 * tipenya 'String' -adhit
					 */

					if (searchby.equalsIgnoreCase("createdBy")) {
						vLikeP.add("createdBy");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("deletedBy")) {
						vLikeP.add("deletedBy");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("modifiedBy")) {
						vLikeP.add("modifiedBy");
						vLikeQ.add(searchtext);
					}
				}

			}

			if (navigation.equalsIgnoreCase("list")){
				
				vEqP.add("clientId.clientId");
				vEqQ.add(clientId);
				result.addObject("clientId",clientId);
				
			}
			else if (navigation.equalsIgnoreCase("listmember")){
				Member member = memberService.get(memberId);
				
				if (member != null){
					clientId = member.getClientId().getClientId();
					vEqP.add("clientId.clientId");
					vEqQ.add(clientId);
				}
				
				
				result.addObject("memberId",memberId);
			}
			
			// vEqP.add("deletedStatus");
			// vEqQ.add(Integer.valueOf(0));

			String sLikeP[] = new String[vLikeP.size()];
			vLikeP.toArray(sLikeP);
			Object sLikeQ[] = new Object[vLikeP.size()];
			vLikeQ.toArray(sLikeQ);

			String sEqP[] = new String[vEqP.size()];
			vEqP.toArray(sEqP);
			Object sEqQ[] = new Object[vEqP.size()];
			vEqQ.toArray(sEqQ);

			count = clientProviderService.getTotal(sLikeP, sLikeQ, sEqP, sEqQ);

			String arah = WebUtil.getParameterString(request, "arah", "");

			if (index == null)
				index = new Integer(1);

			if (arah.equals("kanan"))
				index = new Integer(index.intValue() + 1);
			else if (arah.equals("kiri"))
				index = new Integer(index.intValue() - 1);
			else if (arah.equals("kiribgt"))
				index = new Integer(1);
			else if (arah.equals("kananbgt"))
				index = new Integer(count / countSet.intValue() + 1);

			if (index.compareTo(new Integer(1)) == new Integer(-1).intValue())
				index = new Integer(1);
			else if (index.compareTo(new Integer(count / countSet.intValue()
					+ 1)) == new Integer(1).intValue())
				index = new Integer(count / countSet.intValue() + 1);

			rowsetint = (new Integer((index.intValue() - 1)
					* countSet.intValue())).intValue();
			if (count % countSet.intValue() > 0) {
				result.addObject("halAkhir", new Integer(count
						/ countSet.intValue() + 1));
			} else {
				result.addObject("halAkhir", new Integer(count
						/ countSet.intValue()));
			}

			minIndex = (index - 1) * countSet;
			maxIndex = index * countSet;

			if (maxIndex > count) {
				maxIndex = count;
			}

			String required[] = new String[] {
			// foreign affairs
			// foreign affairs end
			};
			collection = clientProviderService.search(sLikeP, sLikeQ, sEqP,
					sEqQ, required, rowsetint, countSet.intValue());

			if (collection.size() <= 0) {
				index = new Integer(index.intValue() - 1);
				if (index.compareTo(new Integer(1)) == new Integer(-1)
						.intValue())
					index = new Integer(1);
				else if (index.compareTo(new Integer(count
						/ countSet.intValue() + 1)) == new Integer(1)
						.intValue())
					index = new Integer(count / countSet.intValue() + 1);

				rowsetint = (new Integer((index.intValue() - 1)
						* countSet.intValue())).intValue();
				if (count % countSet.intValue() > 0) {
					result.addObject("halAkhir", new Integer(count
							/ countSet.intValue() + 1));
				} else {
					result.addObject("halAkhir", new Integer(count
							/ countSet.intValue()));
				}
				collection = clientProviderService.search(sLikeP, sLikeQ, sEqP,
						sEqQ, required, rowsetint, countSet.intValue());
			}

			request.setAttribute("searchtext", searchtext);
			request.setAttribute("searchby", searchby);
			request.setAttribute("navigation", navigation);

			/*
			 * ini gue generate juga dari nama tablenya convention -->
			 * collection = nama bean + 's' -adhit
			 */

			result.addObject("ClientProviders", collection);

			request.setAttribute("countSet", countSet);
			request.setAttribute("index", new Integer(index));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("alert", request.getParameter("alert"));
			request.setAttribute("minIndex", new Integer(minIndex));
			request.setAttribute("maxIndex", new Integer(maxIndex));

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("alert", alertProperties.getMessage(
					"system.error " + e.getMessage(), null, "fail", Locale
							.getDefault()));

			result = new ModelAndView("error");
		}

		return result;
	}

	/**
	 * Action Service
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get paramater navigation
		String navigation = request.getParameter("navigation") == null ? "welcome"
				: request.getParameter("navigation");
        Integer clientId 	= WebUtil.getParameterInteger(request, "clientId");

		
		String subnavigation = WebUtil.getParameterString(request,"subnavigation","");

		Object user = null;

		ModelAndView result = null;
		HttpSession session = request.getSession(false);

		/*
		 * if (session == null) {
		 * 
		 * request.setAttribute("alert", "<b>" +
		 * alertProperties.getValue("not.login") + "</b>");
		 * request.setAttribute("content", "/jsp/login.jsp");
		 * forward("/main.jsp", request, response);
		 * 
		 * 
		 * result = new ModelAndView ("login"); } else {
		 *  }
		 */
		String breadcrumb = "";
		try {
			if (navigation.equalsIgnoreCase("detail")) {
				/*
				 * disesuaikan dengan halaman targetnya nih
				 */
				result = detailPerformed(request, response,
						"detailClientProvider");
			} else if (navigation.equalsIgnoreCase("delete")) {
				result = deletePerformed(request, response);
			} else if (navigation.equalsIgnoreCase("search")
					|| navigation.equals("gosearch")) {
				result = searchPerformed(request, response,
						"searchClientProvider");
			} else if (navigation.equalsIgnoreCase("lookup")
					|| navigation.equals("golookup")) {
				result = searchPerformed(request, response,
						"lookupClientProvider");
			} else if (navigation.equalsIgnoreCase("list") || subnavigation.equalsIgnoreCase("list")) {
				result = searchPerformed(request, response,
						"searchClientProvider");
//				String clientId = request.getParameter("clientId");
				breadcrumb = "<a href=\"client?navigation="+navigation+"&clientId="+clientId+"\" class=\"linkbreadcrumb\">Detail Client</a> &nbsp;&nbsp;<b>&gt</b> &nbsp;&nbsp;List Client Provider";
			} else if (navigation.equalsIgnoreCase("listmember") || subnavigation.equalsIgnoreCase("listmember")) {
				result = searchPerformed(request, response,
						"listMemberProvider");
			} 
			else if (navigation.equalsIgnoreCase("listgroup") || subnavigation.equalsIgnoreCase("listgroup")){
				result = searchPerformed(request, response,
				"listGroupProvider");
			}
			else if (navigation.equalsIgnoreCase("saveproviders")){
				result = saveClientProviders(request, response, "addClientProvider");
			}
			 else if (navigation.equalsIgnoreCase("tambah")) {
					result = searchUnassignedPerformed(request, response,		"addClientProvider");
			 }else {
				result = searchPerformed(request, response,
						"searchClientProvider");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.addObject("breadcrumb", breadcrumb);
		request.setAttribute("clientId", clientId);
		request.setAttribute("navigation", navigation);

		Map map = TableRenderingServlet.seti18N(request, response);
		result.addAllObjects(map);
		return result;
	}

	// class+

	// class-

}
