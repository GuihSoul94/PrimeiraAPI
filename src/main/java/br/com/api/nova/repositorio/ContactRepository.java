package br.com.api.nova.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.api.nova.entidade.Contact;

@Repository
@Component
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
