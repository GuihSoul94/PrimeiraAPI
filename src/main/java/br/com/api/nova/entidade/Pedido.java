package br.com.api.nova.entidade;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {
	
	private String nome;
    private BigDecimal valor;

}
