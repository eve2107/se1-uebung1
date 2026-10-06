package org.hbrs.se1.ws26.exercises.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = null;

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	 public String translateNumber(int number) {

		 if (number <1 || number > 100) {
			 return "Übersetzung der Zahl " + number + " nicht möglich. Ungültiger Wert" + "("+version+")";
		 }
		 String[] einer = {"", "ein", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun"};

		 String[] elfBis9Zehn = {"zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn"};

		 String[] zehner = {"", "zehn", "zwanzig", "dreißig", "vierzig", "fünfzig", "sechzig", "siebzig", "achtzig", "neunzig"};


		if (number == 1) {
			return "eins";
		} else
		if (number == 100) {
			return "einhundert";
		} else
			if (number >= 10 && number <= 19) {
				return elfBis9Zehn[number % 10];
				}
				int einerStelle = number%10;
				int zehnerStelle = number/10;

				if (einerStelle == 0) {
					return zehner[zehnerStelle];
				}
				else
					if (zehnerStelle == 0) {
						return einer[einerStelle];
					}
					else
         {
							return einer[einerStelle] + "und" + zehner[zehnerStelle];
		 }

	 }

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: dd.MM.yyyy (Beispiel: "20.08.2026"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 * Technisch sollte einfach das "heutige" Datum gesetzt werden.
	 */
	public void setDate( String date ) {
		this.date = date;
	}

	/**
	 * Auslesen des gesetzten Datums
	 * @return
	 */
	public String getDate() {
		return date;
	}
}
