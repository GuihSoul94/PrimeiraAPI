package br.com.api.nova.services;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.nova.entidade.Contact;
import br.com.api.nova.interfaces.IArquivo;
import br.com.api.nova.repositorio.ContactRepository;

@Component
public class CriarArquivoExcel implements IArquivo {
	
	@Autowired
	          private ContactRepository repositorio;

	@Override
	public void criaArquivo() {
		String[] cabecalho = {"Nome", "Email","Telefone"};
		
		List<Contact> linhas = new ArrayList<Contact>();
		linhas = repositorio.findAll();
		
		List<String[]> listaResultado = new ArrayList<String[]>();
		for (Contact contact : linhas) {
			listaResultado.add(new String[] {contact.getName(), contact.getEmail(), contact.getPhone()});			
		}
		Writer escritor = null;
		try {
			escritor = Files.newBufferedWriter(Paths.get("teste.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSVWriter csvescritor = new CSVWriter(escritor);
		
		csvescritor.writeNext(cabecalho);
		csvescritor.writeAll(listaResultado);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void criarArquivoComObjeto(String nomeArquivo) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<Contact> linhas = new ArrayList<Contact>();
		linhas = repositorio.findAll();
		
		Writer escritor = Files.newBufferedWriter(Paths.get("C:\\Maven\\"+ nomeArquivo + ".csv"));
		StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder(escritor).build();

		beanToCsv.write(linhas);
		
	escritor.flush();
	escritor.close();
	}

}
