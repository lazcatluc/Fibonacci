/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ArithExpr {
	
	static Scanner scanner;
	
	/**
	 * Metoda care determina toate submultimile unei multimi de numere, 
	 * in numar de 2 ^ set.size().
	 * @param set	multimea de numere 
	 * @return	toate submultimile, mai putin cea vida
	 */
	public static ArrayList<ArrayList<Integer>> subsets (ArrayList<Integer> set) {
		
		ArrayList<ArrayList<Integer>> combinations = 
				new ArrayList<ArrayList<Integer>>();
		combinations.add(new ArrayList<Integer>());
		for (Integer nr : set) {
			int maxLength = combinations.size();
			for (int i = 0; i < maxLength; i++) {
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.addAll(combinations.get(i));
				newList.add(nr);
				combinations.add(newList);
			}
		}
		combinations.remove(0);
		return combinations;
	}
	
	/**
	 * Metoda care determina o parte din permutarile unei liste, 
	 * prin intercalarea ultimului element din lista initiala pe rand
	 * intre fiecare dintre celelalte elemente.
	 * @param list 	lista de elemente ale carei permutari sunt determinate
	 * @return	cele list.size() - 1 permutari obtinute in modul descris
	 */
	public static ArrayList<ArrayList<Integer>> permutations 
			(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> permutations = 
				new ArrayList<ArrayList<Integer>>();
		int last = list.remove(list.size() - 1);
		
		for (int index = 0; index < list.size(); index++) {
			ArrayList<Integer> copyList = (ArrayList<Integer>) list.clone();
			copyList.add(index, last);
			permutations.add(copyList);
		}
		
		return permutations;
	}
	
	/**
	 * Metoda care determina sublista unei liste initiale, 
	 * pornind de la indexul start pana la sfarsitul listei.
	 * @param list	lista initiala
	 * @param start	indexul care va marca inceputul sublistei
	 * @return	sublista
	 */
	public static ArrayList<ArrayList<Character>> sublist 
						(ArrayList<ArrayList<Character>> list, int start) {
		ArrayList<ArrayList<Character>> sublist = new ArrayList<ArrayList<Character>>();
		
		for (int i = start; i < list.size(); i++) {
			sublist.add(list.get(i));
		}
		
		return sublist;
	}
	
	/**
	 * Metoda care determina toate modurile de a aranja semnele '+' si '*'
	 * pentru un anumit numar maxim de termeni/factori.
	 * @param size	numarul maxim de termeni/factori intre care s-ar putea
	 * 				intercala semnele '+' si '*'
	 * @return	o tabela de dispersie in care cheia marcheaza numarul de semne din gruparea
	 * 			respectiva pentru un numar de termeni/factori cu 1 mai mare decat cheia,
	 * 			iar valoarea de la cheia respectiva este o multime de liste de char-uri de
	 * 			combinatii de '+' si '*', in numar de 2 ^ cheie
	 * 			
	 */
	public static HashMap<Integer, ArrayList<ArrayList<Character>>> signs (int size) {
		
		HashMap<Integer, ArrayList<ArrayList<Character>>> map = 
				new HashMap<Integer, ArrayList<ArrayList<Character>>>();
		ArrayList<ArrayList<Character>> combinations = 
				new ArrayList<ArrayList<Character>>();
		
		ArrayList<Character> plusList = new ArrayList<Character>();
		plusList.add('+');
		ArrayList<Character> multList = new ArrayList<Character>();
		multList.add('*');
		
		combinations.add(plusList);
		combinations.add(multList);
		map.put(1, sublist(combinations, 0));
		
		int index = 0;
		for (int k = 1; k < size - 1; k++) {
			int length = combinations.size();
			for (int i = index; i < length; i++) {
				ArrayList<Character> newPlusList = new ArrayList<Character>();
				newPlusList.addAll(combinations.get(i));
				newPlusList.addAll(plusList);
				combinations.add(newPlusList);
				
				ArrayList<Character> newMultList = new ArrayList<Character>();
				newMultList.addAll(combinations.get(i));
				newMultList.addAll(multList);
				combinations.add(newMultList);
			}
			index += Math.pow(2, k);
			map.put(k + 1, sublist(combinations, index));
		}
		
		return map;
	}
	
	/**
	 * Metoda care evalueaza o expresie aritmetica.
	 * @param nrList	lista de numere
	 * @param charList	lista de semne dintre numere
	 * @return	rezultatul evaluarii expresiei
	 */
	public static int mergeArith (ArrayList<Integer> nrList, ArrayList<Character> charList) {
		int result = 0; 
		ArrayList<Integer> nrListCop = new ArrayList<Integer>();
		nrListCop.addAll(nrList);
		ArrayList<Character> charListCop = new ArrayList<Character>();
		charListCop.addAll(charList);
		
		int i = 0;
		
		//intai grupez toate inmultirile
		while (charListCop.contains('*') && i < charListCop.size()) {
			if (charListCop.get(i) == '*') {
				nrListCop.set(i, nrListCop.get(i) * nrListCop.get(i + 1));
				nrListCop.remove(i + 1);
				charListCop.remove(i);
				i--;
			}
			i++;
		}
		
		//apoi raman doar adunari de efectuat
		for (Integer j : nrListCop) {
			result += j;
		}
		return result;
	}
	
	/**
	 * Metoda care formeaza o expresie aritmetica.
	 * @param nrList	lista de numere
	 * @param charList	lista de semne dintre numere
	 * @return	expresia aritmetica sub forma de String
	 */
	public static String mergeExpr (ArrayList<Integer> nrList, ArrayList<Character> charList) {
		String result = nrList.get(0).toString(); 
		if (charList.isEmpty()) return result;
		for (int i = 0; i < charList.size(); i++) {
			result = result + charList.get(i) + nrList.get(i + 1).toString();
		}
		return result;
	}
	
	/**
	 * Metoda care produce expresia aritmetica care conduce spre rezultatul
	 * cel mai apropiat de tinta, pe care o si evalueaza.
	 * @param set	multimea de numere cu ajutorul careia se construieste expresia
	 * @param target	tinta efectuarii calculelor
	 * @return	expresia aritmetica dorita
	 */
	public static String produceArithExpr(ArrayList<Integer> set, int target) {
		int track = 0; //marcheaza cat de aproape este rezultatul obtinut de tinta
		ArrayList<ArrayList<Integer>> subset = subsets(set);
		HashMap<Integer, ArrayList<ArrayList<Character>>> arith = signs(set.size());
		String str = new String("");
		
		//pentru toate submultimile multimii de numere initiale
		for (int i = 0; i < subset.size(); i++) {
			//pentru un singur termen implicat, nu exista semne de pus
			if (subset.get(i).size() == 1) {
				if (Math.abs(target - subset.get(i).get(0)) 
						< Math.abs(target - track)) {
					track = subset.get(i).get(0);
					if (target == track) {
						System.out.println(target);
						return subset.get(i).get(0).toString();
					}
				}
			}
			else {
				//toate combinatiile de semne pentru un anumit numar de termeni/factori
				ArrayList<ArrayList<Character>> keyList = 
						arith.get(subset.get(i).size() - 1); 
				
				//pentru toate permutarile unei liste => aranjamente
				for (ArrayList<Integer> permuteList : permutations(subset.get(i))) {
					//pentru toate semnele posibile 
					for (ArrayList<Character> signList : keyList) { 
						int value = mergeArith(permuteList, signList);
						//verific rezultatul nou fata de statusul lui track
						if (Math.abs(target - value) < Math.abs(target - track)) {
							str = mergeExpr(permuteList, signList);
							track = value;
							if (target == track) {
								System.out.println(target);
								return str;
							}
						}
					}
				}
			}
		}
		System.out.println(track);
		return str;
	}
	
	/**
	 * Metoda principala a programului
	 * @param args
	 */
	public static void main (String [] args) {
		scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		ArrayList<Integer> set = new ArrayList<Integer>();
		//Nu este un numar exact de numere de citit.
		//Citesc pana la ^D
		while (scanner.hasNext()) {
			set.add(scanner.nextInt());
		}
		
		System.out.println(produceArithExpr(set, target));		
	}	
}