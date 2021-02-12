package fr.eql.ai108.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.eql.ai108.struts.actionform.PremierActionForm;

public class PremierAction extends Action{
	
	public ActionForward execute(
			ActionMapping paramMapping,
			ActionForm paramForm,
			HttpServletRequest paramRequest,
			HttpServletResponse paramResponse) {
		String forward = "success";
		PremierActionForm form = (PremierActionForm) paramForm;
		form.setLabel(form.getSaisie());
		
		return paramMapping.findForward(forward);
	}

}
