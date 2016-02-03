package br.com.setcons.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;

import br.com.setcons.model.Agenda;
import br.com.setcons.model.AgendaModel;
import br.com.setcons.model.TabelaDeAgendasModel;
import br.com.setcons.view.AgendaApp;

public class AgendaController implements PropertyChangeListener{
	
		private AgendaApp view;
		private AgendaModel model;
		private TabelaDeAgendasModel tabelaModel;
	
		public AgendaController(AgendaApp view, AgendaModel model){
			this.view = view;
			this.model = model;
			this.tabelaModel = view.getTabelaModel();
			
			model.addListener(this);
			
			registraAcoesDosBotoes();
			
			model.listar();
		}

		private void registraAcoesDosBotoes() {
			view.getBotaoAdicionar().addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (model.getAgenda().getId() == null){
								model.novo();
							}
			
//							JOptionPane.showMessageDialog(null, view.getNome() + "\n" + view.getTelefone());
							model.setNome(view.getNome());
							model.setTelefone(view.getTelefone());
							model.salvar();
						}
					}
					);
			
			view.getBotaoRemover().addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							model.remover();
						}
					}
					);
			
			view.getTabela().addMouseListener(
					new MouseAdapter(){
						public void mouseClicked(java.awt.event.MouseEvent e) {
							int linha = view.getTabela().getSelectedRow();
							Agenda agenda = tabelaModel.getAgendaSelecionada(linha);
							model.setAgenda(agenda);
							view.setNome(agenda.getNome());
							view.setTelefone(agenda.getTelefone());
						};
					}
					
					);
		}

		public void propertyChange(PropertyChangeEvent evt) {

//			if (evt.getPropertyName().equals("nome")){
//				JOptionPane.showMessageDialog(null,"Nome alterado");
//			}
//			if (evt.getPropertyName().equals("telefone")){
//				JOptionPane.showMessageDialog(null,"Telefone alterado");
//			}
			
			if (evt.getPropertyName().equals("agenda")){
				tabelaModel.listar(model.getTodasAgendas());
				view.setNome("");
				view.setTelefone("");
			}
			if (evt.getPropertyName().equals("listar")){
				tabelaModel.listar(model.getTodasAgendas());
			}
			
		}
		
}
