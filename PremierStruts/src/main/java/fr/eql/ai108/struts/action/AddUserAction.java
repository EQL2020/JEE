package fr.eql.ai108.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.eql.ai108.dao.DaoUser;
import fr.eql.ai108.dao.IDaoUser;
import fr.eql.ai108.struts.actionform.AddUserActionForm;

public class AddUserAction extends Action {
	
	private IDaoUser dao = new DaoUser();

	public ActionForward execute(
			ActionMapping paramMapping,
			ActionForm paramForm,
			HttpServletRequest paramRequest,
			HttpServletResponse paramResponse) {

		String forward = "success";
		
		AddUserActionForm form = (AddUserActionForm) paramForm;
		if(!(dao.isExist(form.getUser()))) {
			dao.insertUser(form.getUser());
		}else {
			forward = "error";
			form.setMessage("Choisis un autre login banane !");
		}
		
		return paramMapping.findForward(forward);
	}
}
