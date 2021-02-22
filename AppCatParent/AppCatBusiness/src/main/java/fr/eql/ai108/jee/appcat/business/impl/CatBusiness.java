package fr.eql.ai108.jee.appcat.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.jee.appcat.entity.Cat;
import fr.eql.ai108.jee.appcat.ibusiness.api.CatIBusiness;
import fr.eql.ai108.jee.appcat.idao.api.CatIDao;

@Remote(CatIBusiness.class)
@Stateless
public class CatBusiness implements CatIBusiness {

	@EJB
	CatIDao proxyCatDao;
	
	@Override
	public List<Cat> displayCat() {
		// TODO Auto-generated method stub
		return proxyCatDao.getAll();
	}

}
