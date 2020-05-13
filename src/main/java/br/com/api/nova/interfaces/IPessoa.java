package br.com.api.nova.interfaces;

import java.util.Optional;

import java.util.List;
import br.com.api.nova.entidade.Contact;

public interface IPessoa {

	public Contact adicionarContato(Contact contato);
	
	public void deletarContato(int id);
	
	public Contact editarContato (Contact contato);
	
	public List<Contact> listarContatos();
	
	public Optional<Contact> encontrarPorId(int id);
	
	public int totalResultado();
	
}
