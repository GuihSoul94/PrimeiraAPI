package br.com.api.nova.interfaces;

import java.io.IOException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public interface IArquivo {

	void criaArquivo();
	
	void criarArquivoComObjeto(String nomeArquivo) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
}
