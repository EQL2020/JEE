package fr.ecoleql.clever4aviation.ibusiness;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Vol;

public interface GestionDossierVolIBusiness {
	List<ConsigneSurete> afficherConsignesParVol(Vol vol);
	List<Defaut> afficherDefautParVol(Vol vol);
	List<Vol> afficherTousLesVols();
}
