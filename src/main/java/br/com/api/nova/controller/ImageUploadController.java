package br.com.api.nova.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.nova.entidade.UploadImagens;
import br.com.api.nova.repositorio.ImageRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/image")
public class ImageUploadController {
	
	@Autowired
	private ImageRepository repositorio;
	
	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity teste() {
		return ResponseEntity.ok("Olá");
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/upload")
	public ResponseEntity uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
	
		UploadImagens img = new UploadImagens(file.getOriginalFilename(), file.getContentType(), file.getBytes());
			repositorio.save(img);
			
			return ResponseEntity.ok("Imagem salva com sucesso!");
	}
	@GetMapping(path = { "/get/{id}" })
	public UploadImagens getImage(@PathVariable("id") int id) throws IOException {
		Long busca = (long) id;
		final Optional<UploadImagens> retrievedImage = repositorio.findById(busca);
		UploadImagens img = new UploadImagens(retrievedImage.get().getName(), retrievedImage.get().getType(),retrievedImage.get().getPicByte());
		return img;
	}
}
