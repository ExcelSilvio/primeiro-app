package br.com.setcons.model;

import java.beans.PropertyChangeListener;
import java.util.Collection;

import javax.swing.event.SwingPropertyChangeSupport;

public class AgendaModel {
	
	private Agenda agenda = new Agenda();
	private SwingPropertyChangeSupport notificador;
	private AgendaRepositorio repositorio = new AgendaRepositorio();

	public AgendaModel(){
		this.notificador = new SwingPropertyChangeSupport(this);
	}
	
	public void addListener(PropertyChangeListener listener){
		notificador.addPropertyChangeListener(listener);
	}
	
	public void setNome(String nome){
		String oldValue = agenda.getNome();
		agenda.setNome(nome);
		notificador.firePropertyChange("nome", oldValue, nome);
	}
	
	public void setTelefone(String telefone){
		String oldValue = agenda.getTelefone();
		agenda.setTelefone(telefone);
		notificador.firePropertyChange("telefone", oldValue, telefone);
	}

	public void salvar() {

		repositorio.adiciona(agenda);
		novo();
		notificador.firePropertyChange("agenda", null, agenda);
	}

	public Collection<Agenda> getTodasAgendas() {
		return repositorio.todas();
	}

	public void novo() {
		this.agenda = new Agenda();
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
}
