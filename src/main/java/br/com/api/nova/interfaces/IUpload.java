package br.com.api.nova.interfaces;

import java.util.Optional;

import br.com.api.nova.entidade.UploadImagens;

public interface IUpload {
	
	Boolean salvar(UploadImagens imagem);
	
	Optional<UploadImagens> buscarPorId(Long id);
	


}
