package service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import model.Bebida;

public class BebidaService {
	
	public static List<Bebida> todosRegistros = new ArrayList<Bebida>();
	
	public static void salvarBebida(Bebida bebida) {
		bebida.setId(getRandomId());
        BebidaService.todosRegistros.add(new Bebida(getRandomId(), bebida.getDescricao(), bebida.getMarca(), bebida.getValorUnitario(), bebida.getLote(), bebida.getQtdEstoque()));
        Collections.sort(BebidaService.todosRegistros, new BebidaComparatorByDescricao());
		
	}
	
	public static void deletarBebida(Bebida bebida) {
	}
	
	public static List<Bebida> listarTodasBebidas() {
		return todosRegistros;
	}
	
	private static void preencherListaBebidas(){
	
	}
	
	private static Integer getRandomId() {
		Random gerador = new Random();
        return gerador.nextInt(501);
    }

}


class BebidaComparatorByDescricao implements Comparator<Bebida> {
	@Override
	public int compare(Bebida c1, Bebida c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
}