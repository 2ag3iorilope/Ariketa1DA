package paises;

import java.util.*;
import java.lang.Exception;
import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Pais.
 */
public class Pais {

	/** Gure erregistroak sortzen ditugu bertan gure datuak gordez. */

	static String Kodea[] 		=  { "31"	 				  ,"376"					,"90"					   ,"261"		 			 ,"685"					  ,"213"	  			   ,"291"					 ,"595"					   ,"30"	 				,"964"};

	/** Estatuak. */
	static String  Estatua[] 	=  {"Holanda"				  ,"Andorra" 				,"Turquia"				   ,"Madagascar" 			 ,"Samoa Occidental"	  ,"Argelia"			   ,"Eritrea"				 ,"Paraguay" 			   ,"Grecia"				,"Irak"};

	/** Bizi Esperantza. */
	static int BiziEsperantza[] = { 78		 				  ,0						,67						   ,52			 			 ,68					  ,70		  			   ,0						 ,68					   ,78		 				,66    };

	/** Estatua Sortutako Data. */
	static LocalDate DataSortu[] = { LocalDate.of(1581, 7, 26),LocalDate.of(1993, 3, 14),LocalDate.of(1923, 10, 29),LocalDate.of(1960, 6, 26),LocalDate.of(1962, 1, 1),LocalDate.of(1962, 7, 5),LocalDate.of(1993, 5, 24),LocalDate.of(1825, 8, 25),LocalDate.of(1830, 2, 3),LocalDate.of(1958, 7, 14) };

	/** Poblazioa. */
	static double Poblazioa[] 	 = {15460000				  ,64000					,61058000				   ,13651000				 ,165000				  ,27959000				   ,3400000					 ,4828000				   ,10467000				,20097000 };

	/** Kapitalak. */
	static String Kapitala[]	 = {"Amsterdam"				  ,"Andorra La Vieja"		,"Ankara"				   ,"Antananarivo"			 ,"Apia"				  ,"Argel"				   ,"Asmara"				 ,"Asuncion"			   ,"Atenas"				,"Bagdad"};



	/**
	 * The main method.
	 *
	 * @param args, argumentuak
	 */
	public static void main(String[] args) {
		try {
			menua();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * Menua.
	 *
	 * @throws Exception the exception
	 */
	public static void menua() throws Exception {

		Scanner sc = new Scanner(System.in);
		boolean ondosartuta = false;
		int aukera = 0;
		do {
			ondosartuta = false;  //Buklea berrarazi galdetzen segitzeko

			System.out.println("Aukeratu hurrengo ataletako bat :");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.- Erregistro guztiak erakutsi 				   |");
			System.out.println("2.- Kode Bidez Erregistroa Bilatu 				   |");
			System.out.println("3.- Ikusi erregistro guztietako batazbesteko Bizi esperantza 	   |");
			System.out.println("4.- Ikusi erregistro guztietako Poblazio Kopuiruaren batazbestekoa |");
			System.out.println("5.- Ikusi Bizi Esperantza handiena duen Erregistroa 		   |");
			System.out.println("6.- Ikusi Poblazioa Handiena duen Erregistroa 			   |");
			System.out.println("7.- Ikusi erregistroan gordeta dagoen Estatu Zaharrena 		   |");
			System.out.println("8.- Ikusi zein erregistrok duen Izen Luzeena 			   |");
			System.out.println("9.- Irten 							   |");

			//Zenbakia ondo sartuta ez badago buklean sartuko da
			while (!ondosartuta) {
				System.out.print("Zuk aukeratutakoa: ");
				if (sc.hasNextInt()) {
					aukera = sc.nextInt();

					if (aukera >= 1 && aukera <= 9) {
						ondosartuta = true;

						switch (aukera) {

						case 1: {
							System.out.println("Erregistro guztiak erakutsi aukeratu duzu");
							
							for (int i = 0; i < Kodea.length; i++) {
								System.out.println("Kodea: " + Kodea[i]);
								System.out.println("Estatua: " + Estatua[i]);
								System.out.println("BiziEsperantza: " + (BiziEsperantza[i] != 0 ? BiziEsperantza[i] : "Ez da aurkitu"));
								System.out.println("DataSortu: " + DataSortu[i]);
								System.out.println("Poblazioa: " + Poblazioa[i]);
								System.out.println("Kapitala: " + Kapitala[i]);
								System.out.println("------------------------------");
							}

							break;
						}

						case 2: {
							String telefonokodeString;
							System.out.println("Erregistroa kode bidez bilatzea aukeratu duzu");
							int aukeratutakoKodea = 0;
							boolean Ondosartutakode = false;
							telefonokodeString = sc.next();

							while (!Ondosartutakode) {
								System.out.print("Zenbakiak sartu: ");
								telefonokodeString = sc.next();

								if (telefonokodeString.matches("\\d+")) {
									if (KodeaExistitzenDaArrayean(Kodea, telefonokodeString)) {
										
										aukeratutakoKodea = Integer.parseInt(telefonokodeString);
										int index = LortuArrayekoPosizioaKode(Kodea, telefonokodeString);
										ErakutsierregistroKode(index);
										Ondosartutakode = true;
										
									} else {
										System.out.println("Error: Kodea ez dago zerrendan.");
									}
								} else 
								{
									System.out.println("Error: Zenbakiak bakarrik sartu behar dituzu.");
								}
							}

							System.out.println("Sartutako kodea: " + aukeratutakoKodea);
							break;

						}

						case 3: {
							System.out.println("Erregistro guztietako Bizi Esperantzaren batazbestekoa ikustea aukeratu duzu");
							double media = kalkulatuBiziEsperantzaMedia();
							System.out.println("Erregistroen Bizi Esperantzaren bataz Bestekoa : " + media + " urtekoa da");
							
							break;
						}

						case 4: {
							System.out.println("Erregistro guztietako Poblazioaren batazbestekoa ikustea aukeratu duzu");
							double mediapoblazio = kalkulatuPoblazioMedia();
							System.out.println("Erregistroen Poblazioaren bataz Bestekoa : " + mediapoblazio + " pertsona da");
							
							break;
						}

						case 5: {
							System.out.println("Erregistro guztietako Bizi Esperantza Handiena Ikustea aukeratu duzu");
							int IndexBiziEsperantzaHandiena = LortuBiziEsperantzahandiena();
							ErakutsierregistroKode(IndexBiziEsperantzaHandiena);
							
							break;
						}

						case 6: {
							System.out.println("Erregistro guztietako Poblazio Handiena duen erregistroa Ikustea aukeratu duzu");
							int IndexPoblazioHandiena = LortuPoblaziohandiena();
							ErakutsierregistroKode(IndexPoblazioHandiena);
							
							break;
						}

						case 7: {
							System.out.println("Erregistro guztietako Estatu zaharrena ikustea aukeratu duzu");
							int IndexEstatuZaharrena = LortuDataZaharrena();
							ErakutsierregistroKode(IndexEstatuZaharrena);
							
							break;
						}

						case 8: {
							System.out.println("Erregistro guztietako Estatua izen luzeena aukeratu duzu");
							int IndexIzenLuzeena = LortuizenLuzeena();
							ErakutsierregistroKode(IndexIzenLuzeena);
							
							break;
						}

						case 9:
							System.out.println("Irteten...");
							break;

						default:
							System.out.println("Aukera desegokia.");
						}
						
					} else {
						System.out.println("Errorea: Sartu baliozko aukera bat (1-9).");
					}
				} else {
					System.out.println("Errorea: Zenbaki bat sartu behar duzu.");
					sc.next();  
				}
			}
		} while (aukera != 9);

		sc.close();
	}

	/**
	 * Kodea existitzen da  arrayean metodoa.Kodea benetan existitzen den konprobatzen du
	 *
	 * @param array , gure erregistroak
	 * @param value , erabiltzaileak sartutako balioa
	 * @return true, Kodea erregistroan badago
	 */
	public static boolean KodeaExistitzenDaArrayean(String[] array, String value) {
		for (String s : array) {
			if (s.equals(value)) {
				return true; 
			}
		}
		return false; 
	}

	/**
	 * Lortu arrayeko posizioa kode bidez.
	 *
	 * @param array , gure erregistroa
	 * @param value , sartutako balioa
	 * @return  int, gure erregistroaren posizioa
	 */
	public static int LortuArrayekoPosizioaKode(String[] array, String value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				return i; 
			}
		}
		return -1; 
	}

	/**
	 * Erakutsi erregistro kode metodoa.
	 *
	 * @param index , erregistroko posizioaren bidez erregistroa erakusten du
	 */
	public static void ErakutsierregistroKode(int index) {
		System.out.println("Kodea " + Kodea[index] + ":");
		System.out.println("Estatua: " + Estatua[index]);
		System.out.println("Bizi Esperantza: " + (BiziEsperantza[index] != 0 ? BiziEsperantza[index] : "No disponible"));
		System.out.println("Sortze Data: " + DataSortu[index]);
		System.out.println("Poblazioa: " + Poblazioa[index]);
		System.out.println("kapitala: " + Kapitala[index]);
	}

	/**
	 * Kalkulatu bizi esperantza media.
	 *
	 * @return double, erregistro guztien bizi esperantzaren batazbestekoa kalkulatzen du
	 */
	public static double kalkulatuBiziEsperantzaMedia() {
		int batura = 0;
		int kontatu = 0;


		for (int i = 0; i < BiziEsperantza.length; i++) {
			if (BiziEsperantza[i] != 0) {
				batura += BiziEsperantza[i];
				kontatu++;
			}
		}


		if (kontatu > 0) {
			return (double) batura / kontatu;
		} else {
			return 0; 
		}
	}

	/**
	 * Kalkulatu poblazio media.
	 *
	 * @return  double, erregistro guztien poblazioaren batazbestekoa kalkulatzen du
	 */
	public static double kalkulatuPoblazioMedia() {
		int batura2 = 0;
		int kontatu2 = 0;


		for (int i = 0; i < Poblazioa.length; i++) {
			if (Poblazioa[i] != 0) {
				batura2 += Poblazioa[i];
				kontatu2++;
			}
		}


		if (kontatu2 > 0) {
			return (double) batura2 / kontatu2;
		} else {
			return 0; 
		}
	}

	/**
	 * Lortu bizi esperantza handiena duen Estatu metodoa.
	 *
	 * @return  int, esperantza handiena duen erregitroaren posizioa
	 */
	public static int LortuBiziEsperantzahandiena() {
		int indexaltuena = 0; 
		for (int i = 1; i < BiziEsperantza.length; i++) {
			if (BiziEsperantza[i] > BiziEsperantza[indexaltuena]) {
				indexaltuena = i; 
			}
		}
		return indexaltuena; 
	}

	/**
	 * Lortu poblazio handiena metodoa.
	 *
	 * @return  int, poblazio handiena duen erregistroaren posizioa
	 */
	public static int LortuPoblaziohandiena() {
		int indexaltuena2 = 0; 
		for (int i = 1; i < Poblazioa.length; i++) {
			if (Poblazioa[i] > Poblazioa[indexaltuena2]) {
				indexaltuena2 = i; 
			}
		}
		return indexaltuena2; 
	}

	/**
	 * Lortu data zaharrena metodoa.
	 *
	 * @return  int, data zaharrena duen erregistroaren posizioa
	 */
	public static int LortuDataZaharrena() {
		int indexZaharra = 0;
		for (int i = 1; i < DataSortu.length; i++) {
			if (DataSortu[i].isBefore(DataSortu[indexZaharra])) {
				indexZaharra = i;
			}
		}
		return indexZaharra;
	}

	/**
	 * Lortu izen luzeena metodoa.
	 *
	 * @return int, gure erregistroko izen luzeenaren posizioa itzulten du
	 */
	public static int LortuizenLuzeena() {
		int IndexIzenluzeena = 0;
		for (int i = 1; i < Estatua.length; i++) {
			if (Estatua[i].length() > Estatua[IndexIzenluzeena].length()) {
				IndexIzenluzeena = i;
			}
		}
		return IndexIzenluzeena;
	}

}

