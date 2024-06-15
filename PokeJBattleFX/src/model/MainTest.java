// Token Desk 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

package model;

import java.util.HashMap;
import model.costanti.*;

import model.pokemon.*;

public class MainTest {

	public static void test(String[] args) {
		
		FactoryPkmn factory = new FactoryPkmn();
		
		Allenatore a1 = new Allenatore("Alessia", new Pokemon[] {factory.crea("squirtle", 10), factory.crea("charmander", 5), null, null, null, null}, 0, 0);
		Allenatore a2 = new Allenatore("SimoCom", new Pokemon[] {factory.crea("bulbasaur", 15), factory.crea("charmeleon", 20), null, null, null, null}, 0, 0);
		
		a2.getPokemonById(0).setCurrentExp(2650);
		
		BestOfThree game = new BestOfThree(a1,a2);
		
		game.run();
		
		System.out.println("\nVITTORIE-SCONFITTE -> " + a1.getNickname() + ":" + a1.getVittorie() + " - " + a1.getSconfitte() + "; " + a2.getNickname() + ":" + a2.getVittorie() + " - " + a2.getSconfitte() + "\n");
		
		
		/*
		FactoryPkmn factory = new FactoryPkmn();

		Pokemon p1 = factory.crea("charmander", 100);
		
		Pokemon p2 = factory.crea("squirtle");
		
		Pokemon p3 = factory.crea("bulbasaur");
		
		System.out.println(p1 + "\n");
		p1.evolve();
		p1.evolve();
		System.out.println(p1 + "\n");
		*/
		//non capisco la madonna che mi mette il livello 32 porcacccio chi so io
		//System.out.println(p2.evolve());
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
		
		return;
	}

}
