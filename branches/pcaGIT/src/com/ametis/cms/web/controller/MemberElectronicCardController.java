package com.ametis.cms.web.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
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
import com.ametis.cms.datamodel.Member;
import com.ametis.cms.datamodel.MemberElectronicCard;
import com.ametis.cms.service.MemberElectronicCardService;
import com.ametis.cms.service.MemberService;
import com.ametis.cms.service.SecurityService;
import com.ametis.cms.service.UserService;
import com.ametis.cms.util.WebUtil;
import com.ametis.cms.util.servlet.TableRenderingServlet;

// imports+

// imports-

/**
 * MemberElectronicCard is a servlet controller for member_electronic_card
 * Table. All you have to do is to convert necessary data field to the named
 * parameter
 */
public class MemberElectronicCardController implements Controller

// extends+

// extends-

{

	private MemberElectronicCardService memberElectronicCardService;
	private SecurityService securityService;

	private UserService actionuserService;

	private ResourceBundleMessageSource alertProperties;
	private Integer countSet;
	private Integer maxPercountSet;
	private MemberService memberService;
	
	//Add by aju on 20150928, make iframe param public fufufu :D
	private String usingIFrame;
	private String iFrameClientMemberId;
	private String iFrameLevelLogin;
	private String sessionMemberId;
	private String sessionMemberParentId;
	private boolean isIFrameSession;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setActionUserService(UserService userService) {
		this.actionuserService = userService;
	}

	public UserService getActionUserService() {
		return actionuserService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	public SecurityService getSecurityService() {
		return this.securityService;
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

	public void setMemberElectronicCardService(
			MemberElectronicCardService memberElectronicCardService) {
		this.memberElectronicCardService = memberElectronicCardService;
	}

	public MemberElectronicCardService getMemberElectronicCardService() {
		return this.memberElectronicCardService;
	}

	public ModelAndView deletePerformed(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView result = null;

		try {
			Integer id = WebUtil.getParameterInteger(request, "id");

			/*
			 * Pkey ini merupakan representasi dari primary key, misalkan hasil
			 * get dari attribute diatas ^ itu cuma ada 1 key saja berarti
			 * tinggal pkey = <nama var diatas> tapi kalau misalkan composite
			 * primary key berarti tinggal bikin representasi primary key nya
			 * saja .
			 */
			java.io.Serializable pkey = id;

			ActionUser user = securityService.getActionUser(request);

			MemberElectronicCard res = memberElectronicCardService.delete(pkey,
					user);

			if (res != null) {
				request.setAttribute("alert", alertProperties.getMessage(
						"success.delete.memberelectroniccard", null, "success",
						Locale.getDefault()));
			} else {
				request.setAttribute("alert", alertProperties.getMessage(
						"fail.delete.memberelectroniccard", null, "fail",
						Locale.getDefault()));

			}
			result = searchPerformed(request, response,
					"searchMemberElectronicCard");
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
			Integer id = WebUtil.getParameterInteger(request, "id");

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
			java.io.Serializable pkey = id;
			MemberElectronicCard object = memberElectronicCardService.get(pkey);

			if (object == null) {
				request.setAttribute("alert", alertProperties.getMessage(
						"not.found.memberelectroniccard", null, "fail", Locale
								.getDefault()));
			}
			/*
			 * convention .. kalo mau nampilkan sebuah object pake BeanClass aja
			 * ya .. ga pake 's' -adhit
			 */

			result.addObject("memberElectronicCard", object);
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
			if (navigation.equals("gosearch") || navigation.equals("golookup")) {

				if (searchby != null) {
					
					if (searchby.equalsIgnoreCase("cardNumber")) {
						vLikeP.add("cardNumber");
						vLikeQ.add(searchtext);
					}
					if (searchby.equalsIgnoreCase("memberNumber")) {
						vLikeP.add("memberNumber");
						vLikeQ.add(searchtext);
					}
					
					if (searchby.equalsIgnoreCase("description")) {
						vLikeP.add("description");
						vLikeQ.add(searchtext);
					}
				}

			}

			Integer memberId = WebUtil.getParameterInteger(request, "memberId");
			
			//Add by aju on 20150929, for handle iFrame things fufufu
			if(isIFrameSession && iFrameLevelLogin.equalsIgnoreCase("member")){
				System.out.println("it\'s still on member(" + sessionMemberId + ") login session fufufu...");
				memberId = (memberId==null?Integer.parseInt(sessionMemberId):memberId);
				Member theMember = memberService.get(memberId);
				if(theMember!=null){
					System.out.println("checking->requestParentMemberId(" + theMember.getParentMember().getMemberId().toString() + ") vs sessionParentMemberId(" + sessionMemberParentId + ")");
					if(!theMember.getParentMember().getMemberId().toString().equals(sessionMemberParentId)){
						memberId=Integer.parseInt(sessionMemberId);
						ModelAndView errorResult = new ModelAndView(new RedirectView("errorpage"));	
						errorResult.addObject("errorType","OtherFamilyAccessDenied");			
						errorResult.addObject("errorMessage", "Hey member("+ sessionMemberId + "), are you missing your way? :P<br/>" 
								+ "<a href=\"memberelectroniccard?navigation=list&memberId="+memberId+"\">Go Back</a>");
						return errorResult;
					}
				}
			}


			
			Member member = null;
			
			if (memberId != null){
				member = memberService.get(memberId);
			}
			
			if (navigation.equalsIgnoreCase("list") || navigation.equalsIgnoreCase("golist")){
				
				vEqP.add("memberId.parentMember.memberId");
				
				if (member != null){
					if (member.getParentMember() != null){
						vEqQ.add(member.getParentMember().getMemberId());
					}
					else {
						vEqQ.add(member.getMemberId());
					}
				}	
				else {
					vEqQ.add(memberId);
				}
				
				request.setAttribute("memberId", memberId);
				
			}
			
			vEqP.add("deletedStatus");
			vEqQ.add(new Integer(0));

			String sLikeP[] = new String[vLikeP.size()];
			vLikeP.toArray(sLikeP);
			Object sLikeQ[] = new Object[vLikeP.size()];
			vLikeQ.toArray(sLikeQ);

			String sEqP[] = new String[vEqP.size()];
			vEqP.toArray(sEqP);
			Object sEqQ[] = new Object[vEqP.size()];
			vEqQ.toArray(sEqQ);

			count = memberElectronicCardService.getTotal(sLikeP, sLikeQ, sEqP,
					sEqQ);

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
			collection = memberElectronicCardService.search(sLikeP, sLikeQ,
					sEqP, sEqQ, required, rowsetint, countSet.intValue());

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
				collection = memberElectronicCardService.search(sLikeP, sLikeQ,
						sEqP, sEqQ, required, rowsetint, countSet.intValue());
			}

			request.setAttribute("searchtext", searchtext);
			request.setAttribute("searchby", searchby);
			request.setAttribute("navigation", navigation);

			if (memberId != null){
				String[] requiredMember = {"Member.MemberGroupId","Member.ClientId",
						"Member.RelationshipId","Member.ParentMember","Member.CurrentPolicyId"};
				Member object = memberService.get(memberId,requiredMember);
				result.addObject("member", object);
				
				//hitung umur
				Date umur =  object.getBirthday();
				Calendar dob = Calendar.getInstance();  
				dob.setTime(umur);  
				Calendar today = Calendar.getInstance();  
				int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR); 
				if ((today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
				    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) ||
				    today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
					age--;  
				}
				result.addObject("age", age);
				//end
			}
			

			result.addObject("MemberElectronicCards", collection);

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
			
			//modified by aju on 20150929, new iFrame checker fufufu plus init
			isIFrameSession = securityService.isUsingIFrameSession(request);
			iFrameLevelLogin = securityService.getTheIFrameLevelLogin();
			System.out.println("securityService->SessionMemberId->" + securityService.getTheSessionMemberId());
			sessionMemberId = securityService.getTheSessionMemberId();
			System.out.println("securityService->SessionParentMemberId->" + securityService.getTheSessionMemberParentId());
			sessionMemberParentId = securityService.getTheSessionMemberParentId();

			
			if (navigation.equalsIgnoreCase("detail")) {
				/*
				 * disesuaikan dengan halaman targetnya nih
				 */
				result = detailPerformed(request, response,
						"detailMemberElectronicCard");
			} else if (navigation.equalsIgnoreCase("delete")) {
				result = deletePerformed(request, response);
			} else if (navigation.equalsIgnoreCase("search")
					|| navigation.equals("gosearch")) {
				result = searchPerformed(request, response,
						"searchMemberElectronicCard");
			} else if (navigation.equalsIgnoreCase("list")
					|| navigation.equals("golist")) {
				result = searchPerformed(request, response,
						"listMemberElectronicCard");
				String memberId = request.getParameter("memberId");
				breadcrumb = "<a href=\"member?navigation=detail&memberId="+memberId+"\" class=\"linkbreadcrumb\">Detail Member</a> &nbsp;&nbsp;<b>&gt</b> &nbsp;&nbsp;List Member Electronic Card";
			} else if (navigation.equalsIgnoreCase("lookup")
					|| navigation.equals("golookup")) {
				result = searchPerformed(request, response,
						"lookupMemberElectronicCard");
			} else {
				result = searchPerformed(request, response,
						"searchMemberElectronicCard");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.addObject("breadcrumb", breadcrumb);
		Map map = TableRenderingServlet.seti18N(request, response);
		result.addAllObjects(map);
		return result;
	}

	// class+

	// class-

}
