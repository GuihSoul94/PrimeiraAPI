package br.com.api.nova.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.com.api.nova.entidade.Contact;
import br.com.api.nova.interfaces.IPessoa;
import br.com.api.nova.repositorio.ContactRepository;

@EnableScheduling
@Component
public class ContactServices implements IPessoa {
	
	@PersistenceContext
	EntityManager entidade;
	
	@Autowired
	private ContactRepository repositorio;
	
	@Autowired
	private CriarArquivoExcel criar;

	@Override
	public Contact adicionarContato(Contact contato) {
		Contact retorno = new Contact();
		retorno = repositorio.save(contato);
		
		return retorno;
	}
	
	@Override
	public List<Contact> listarContatos(){
		List<Contact> listaRetornoContato = new ArrayList<Contact>();
		
		try {
			listaRetornoContato = repositorio.findAll();
			gerarArquivo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listaRetornoContato;
	}

	@Override
	public void deletarContato(int id) {
		try {
			repositorio.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Contact editarContato(Contact contato) {
		Contact contatoEditado = new Contact();
		try {
			contatoEditado = repositorio.save(contato);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return contatoEditado;
	}


	@Override
	public Optional<Contact> encontrarPorId(int id) {
		Optional<Contact> retornoDeId = null;
		
		try {
			retornoDeId = repositorio.findById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retornoDeId;
	}

	@Override
	public int totalResultado() {
		int retorno = 0;
		try {
			retorno = (int) repositorio.count();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	@Scheduled(cron = "0 0 6 2 * MON-FRI")
	private void testeQueryAgendada() {
		Contact contatoAgendado = new Contact();
		contatoAgendado.setName("Contato Agendado");
		contatoAgendado.setEmail("contato@agendado.com");
		contatoAgendado.setPhone("(11)98765-4321");
		try {
			repositorio.saveAndFlush(contatoAgendado);
			System.out.println("Deu certo!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void gerarArquivo() {
		try {
			criar.criarArquivoComObjeto("Resultado_Agendado");
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	

	
	

}
