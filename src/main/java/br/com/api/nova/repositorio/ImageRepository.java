package br.com.api.nova.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.nova.entidade.UploadImagens;

public interface ImageRepository extends JpaRepository<UploadImagens, Long> {

	
}
