package br.com.canaldorubao.dao.cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.canaldorubao.model.cliente.Cliente;

public class ClienteDAO {
	
	private static Map<Long, Cliente> db = new HashMap<>();
	
	public static Cliente insert(Cliente cliente) {
		db.put(cliente.getId(), cliente);
		return cliente;
	}
	
	public Cliente update(Cliente cliente) {
		db.put(cliente.getId(), cliente);
		return cliente;
	}
	
	public void delete(Long id) {
		db.remove(id);
	}
	
	public Cliente getById(Long id) {
		return db.get(id);
	}
	
	
	public List<Cliente> getAll(){
		return db.values().stream().collect(Collectors.toList());
	}
	
	public boolean exists(Long id) {
		return db.containsKey(id);
	}
}






