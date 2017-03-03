package br.com.cafglass.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cafglass.purchaseorder.models.State;
import br.com.cafglass.purchaseorder.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> findAll() {
		return (List<State>) this.stateRepository.findAll();
	}

	public void create() { 
		State ac = new State("AC", "Acre"); 
		if( this.stateRepository.findByAbbreviation(ac.getAbbreviation()) == null)
			this.stateRepository.save(ac);
		State al = new State("AL", "Alagoas");
		if( this.stateRepository.findByAbbreviation(al.getAbbreviation()) == null)
			this.stateRepository.save(al);		
		State ap = new State("AP", "Amapá");
		if( this.stateRepository.findByAbbreviation(ap.getAbbreviation()) == null)
			this.stateRepository.save(ap);		
//		Amazonas	AM	 
//		Bahia	BA	 
//		Ceará	CE	 
//		Distrito Federal	DF	 
//		Espírito Santo	ES	 
//		Goiás	GO	 
//		Maranhão	MA	 
//		Mato Grosso	MT	 
//		Mato Grosso do Sul	MS	 
//		Minas Gerais	MG	 
//		Pará	PA	 
//		Paraíba	PB	 
//		Paraná	PR	 
//		Pernambuco	PE	 
//		Piauí	PI	 
		State rj = new State("RJ", "Rio de Janeiro");
		if( this.stateRepository.findByAbbreviation(rj.getAbbreviation()) == null)
			this.stateRepository.save(rj);		
//		Rio Grande do Norte	RN	 
//		Rio Grande do Sul	RS	 
//		Rondônia	RO	 
//		Roraima	RR	 
//		Santa Catarina	SC	 
		State sp = new State("SP", "São Paulo");
		if( this.stateRepository.findByAbbreviation(sp.getAbbreviation()) == null)
			this.stateRepository.save(sp);		
//		Sergipe	SE	 
//		Tocantins	TO
		
	}

}
