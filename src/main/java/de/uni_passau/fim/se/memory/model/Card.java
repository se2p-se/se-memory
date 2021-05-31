package de.uni_passau.fim.se.memory.model;

public class Card {
	private char value;
	private boolean isHidden = true ;
	private static String hiddenValue = "[]" ;

	public Card(Character ch) {
		this.value = ch ;
	}

	public char getValue () {
		return value ;
	}
	public void setValue (char wert) {
		value = wert ;
	}
	public void flipCard () {
		if (isHidden) {
			isHidden = false ;
		}
		else {
			isHidden = true ;
		}
	}
}
