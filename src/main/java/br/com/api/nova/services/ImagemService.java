package br.com.api.nova.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.nova.entidade.UploadImagens;
import br.com.api.nova.interfaces.IUpload;
import br.com.api.nova.repositorio.ImageRepository;

@Component
public class ImagemService implements IUpload {
	
	@Autowired
	private ImageRepository repositorio;

	@Override
	public Boolean salvar(UploadImagens imagem) {
		try {
		repositorio.save(imagem);
			System.out.println("Deu certo");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Optional<UploadImagens> buscarPorId(Long busca) {
		Optional<UploadImagens> classeRetorno = null;
		try {
			classeRetorno = repositorio.findById((long) busca);
			System.out.println("Deu certo!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	return classeRetorno;
	}

}
