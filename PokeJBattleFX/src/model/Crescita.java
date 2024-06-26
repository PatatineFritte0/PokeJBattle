package model;

/**
 * Interfaccia che definisce cosa deve avere una classe
 * che implamenta Crescita
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public interface Crescita {
	/**
	 * gestisce il lvlUp
	 * @return void
	 */
	public void levelUp();
	/**
	 * gestisce le evoluzioni
	 * @return void
	 */
	public void evolve();
	/**
	 * gestisce l'aumento dell'exp
	 * @return void
	 */
	public void gainExp(Pokemon Enemy);
}
