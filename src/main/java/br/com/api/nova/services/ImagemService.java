package br.com.api.nova.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.nova.repositorio.ImageRepository;

@Component
public class ImagemService {
	
	@Autowired
	private ImageRepository repositorio;

}
