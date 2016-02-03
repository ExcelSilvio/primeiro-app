package br.com.setcons.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AgendaRepositorio {
	
	private Long nextId = 1L;

	private List<Agenda> agendas = new ArrayList<Agenda>();
	
	public void adiciona(Agenda agenda){
		
		if (agendas.contains(agenda)){
			agendas.remove(agenda);
			agendas.add(agenda);	
		}else{
			agenda.setId(nextId++);
			agendas.add(agenda);
		}
	}
	public void remover(Agenda agenda){
		agendas.remove(agenda);
	}
	public Collection<Agenda> todas(){
		return agendas;
	}
	
	
}
