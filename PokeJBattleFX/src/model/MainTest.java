package model;

import java.util.HashMap;

import model.costanti.Mossa;
import model.costanti.Tipo;
import model.pokemon.*;

public class MainTest {

	public static void test(String[] args) {

		Charmander p1 = new Charmander("Charmander", Tipo.FUOCO, null, new Mossa []{null, null, null, null},
										new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(2, Mossa.RUGGITO); put(4, Mossa.BRACIERE); put(8, Mossa.MURODIFUMO); put(12, Mossa.DRAGOSPIRO); put(17, Mossa.ROGODENTI); 
																		put(20, Mossa.LACERAZIONE); put(24, Mossa.LANCIAFIAMME); put(28, Mossa.VISOTRUCE); put(36, Mossa.MARCHIATURA);}}, 
										16, 16, null, 39, 65, 52, 60, 43, 50);
		
		Bulbasaur p2 = new Bulbasaur("Bulbasaur", Tipo.ERBA, null, new Mossa []{Mossa.FRUSTATA, Mossa.RUGGITO, null, null},
										null, 16, 16, p1 , 45, 45, 49, 65, 49, 65);
		
		Squirtle p3 = new Squirtle("Squirtle", Tipo.ACQUA, null, new Mossa []{Mossa.PISTOLACQUA, Mossa.RITIRATA, null, null},
				null, 5, 16, null, 44, 43, 48, 50, 65, 64);
		
		//non capisco la madonna che mi mette il livello 32 porcacccio chi so io
		System.out.println(p2.evolve());
		//System.out.println("\n" + p1);
		
		/*Test botte, precisione ed elusione
		p1.setPrecisioneBattaglia(100);
		p2.setStatModifier(6, Statistica.ELUSIONE);
		p2.incassa(p1.attacca(p2, p1.getMoveSet()[0]));
		
		System.out.println(p1);
		System.out.println("\n");
		System.out.println(p2);
		*/
		
		/*Test betto, con mossa non disponibile
		p2.incassa(p1.attacca(p2, Mossa.FOGLIELAMA));
		
		System.out.println(p1);
		System.out.println("\n");
		System.out.println(p2);
		*/
		
		
		/* Test Nerf enemy
		p1.setStatModifier(-5, p1.getAttacco());
		System.out.println(p1);
		
		p2.incassa(p1.attacca(p2, p1.usaMossa(1)));
		p1.incassa(p2.attacca(p1, p2.usaMossa(1)));
		System.out.println(p1);
		System.out.println("\n");
		System.out.println(p2);
		*/
		
		/* Test Boost self
		p1.incassa(p3.attacca(p1, p3.usaMossa(1)));
		System.out.println(p2);
		System.out.println("\n");
		System.out.println(p3);
		*/
		
		/* Test lvl-up
		System.out.println(p3 + "\n");
		p3.setCurrentExp(99);
		p3.gainExp(p2);
		System.out.println(p3);
		*/
	}

}
