package de.uni_passau.fim.se.memory.model;

public class Card {
	private Character value;
	private boolean isHidden = true ;
	private static Character hiddenValue = '▯';


	public Card(Character ch) {
		this.value = ch ;
	}

	public Character getValue () {
		return value ;
	}
	public void setValue (Character val) {
		value = val ;
	}
	public void flipCard () {
		isHidden = !isHidden;
	}
}

