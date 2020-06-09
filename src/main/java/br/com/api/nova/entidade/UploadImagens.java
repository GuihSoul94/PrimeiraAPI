package br.com.api.nova.entidade;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image_table" )
public class UploadImagens {
	
	public UploadImagens() {
		super();
	}
	
	public UploadImagens(String name, String type, byte[] picByte) {
		this.name = name;
		this.type = type;
		this.picByte = picByte;

	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "picbyte", length = 1000)
	private byte[] picByte;

	@Override
	public String toString() {
		return "UploadImagens [id=" + id + ", name=" + name + ", type=" + type + ", picByte=" + Arrays.toString(picByte)
				+ "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the picByte
	 */
	public byte[] getPicByte() {
		return picByte;
	}

	/**
	 * @param picByte the picByte to set
	 */
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

}
