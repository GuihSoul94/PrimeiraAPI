package br.com.api.nova.entidade;

import java.util.List;

public class Pokemon {
	
	private String name;
	private String id;
	private String weight;
	private String height;
	private Sprites sprites;
	private List<Types> types;
	private List<Moves> moves;
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**
	 * @return the sprites
	 */
	public Sprites getSprites() {
		return sprites;
	}
	/**
	 * @param sprites the sprites to set
	 */
	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
	/**
	 * @return the types
	 */
	public List<Types> getTypes() {
		return types;
	}
	/**
	 * @param types the types to set
	 */
	public void setTypes(List<Types> types) {
		this.types = types;
	}
	/**
	 * @return the move
	 */
	public List<Moves> getMoves() {
		return moves;
	}
	/**
	 * @param move the move to set
	 */
	public void setMoves(List<Moves> moves) {
		this.moves = moves;
	}

}