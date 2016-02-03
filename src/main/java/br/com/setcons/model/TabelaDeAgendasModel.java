package br.com.setcons.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaDeAgendasModel extends AbstractTableModel{

	private String[] colunas = {"Nome", "Telefone"};
	private List<Agenda> agendas = new ArrayList<Agenda>();
	
	public int getRowCount() {
		return agendas.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Agenda agenda = agendas.get(rowIndex);
		if (colunas[columnIndex].equals("Nome")){
			return agenda.getNome();
		}
		if (colunas[columnIndex].equals("Telefone")){
			return agenda.getTelefone();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	public void listar(Collection<Agenda> agendas) {
		this.agendas = (List<Agenda>) agendas;
		fireTableDataChanged();
	}
	
	public Agenda getAgendaSelecionada(int linha){
		return agendas.get(linha);
	}
}
