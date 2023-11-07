package org.example;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] adn = cargarADN().toArray(new String[6]);
        System.out.println(esMutante(adn) ? "El ADN es mutante" : "El ADN no es mutante");

    }

    public static List<String> cargarADN(){
        Scanner ingresoTeclado = new Scanner(System.in);
        List<String> adn = new ArrayList<String>();
        String expADN = "^[ATCG]*$";
        String ingreso = "";

        while(adn.size() != 6) {
            System.out.println("Ingresa un valor valido para el adn de 6 letras entre A, C, T, G: ");
            ingreso = ingresoTeclado.nextLine();
            if(ingreso.matches(expADN) && ingreso.length() == 6) {
                System.out.println("El valor ingresado cumple con una cadena de ADN");
                adn.add(ingreso);
            }
        }
        System.out.println("La cadena de ADN resultante quedó");
        System.out.println(adn);
        return adn;
    }

    public static boolean esMutante(String[] adn) {
        HashMap<String, Integer> apariciones = new HashMap<String, Integer>();
        HashMap<String, Boolean> esMutante = new HashMap<String, Boolean>();
        apariciones.put("horizontales", 1);
        apariciones.put("verticales", 1);
        apariciones.put("oblicuas", 1);

        esMutante.put("horizontal", false);
        esMutante.put("vertical", false);
        esMutante.put("oblicua", false);

        int columnaActual = 0;
        int filaActual = 0;
        int j = 0;
        int contador = 0;

        for( int i = 0; i < adn.length; i++) {

            // HORIZONTAL;
            while( j < adn[i].length()) {
                if(j + 1 < adn[i].length() && adn[i].charAt(j) == adn[i].charAt( j + 1)) {
                    apariciones.put("horizontales", apariciones.get("horizontales") + 1);
                } else {
                    apariciones.put("horizontales", 1);
                }
                if( apariciones.get("horizontales") == 4 ) {
                    esMutante.put("horizontal", true);
                    break;
                }
                j += 1;
            }
            // OBLICUA
            j = 0;
            filaActual = i;
            columnaActual = j;
            while(j < adn[i].length()) {
                if(columnaActual + 1 < adn[i].length()
                        && filaActual + 1 < adn.length
                        && adn[filaActual].charAt(columnaActual) == adn[filaActual + 1].charAt(columnaActual + 1)) {
                    apariciones.put("oblicuas", apariciones.get("oblicuas") + 1);
                    columnaActual += 1;
                    filaActual += 1;
                    if(apariciones.get("oblicuas") == 4) {
                        esMutante.put("oblicua", true);
                        break;
                    }
                } else {
                    apariciones.put("oblicuas", 1);
                    j += 1;
                    columnaActual = j;
                    filaActual = i;
                }
            }
            // VERTICAL
            j = 0;
            filaActual = i;
            while(j < adn[i].length()) {
                if(filaActual + 1 < adn.length && adn[filaActual].charAt(j) == adn[filaActual + 1].charAt(j)) {
                    apariciones.put("verticales", apariciones.get("verticales") + 1);
                    filaActual += 1;
                } else {
                    apariciones.put("verticales", 1);
                    filaActual = i;
                    j += 1;
                }
                if(apariciones.get("verticales") == 4) {
                    esMutante.put("vertical", true);
                    break;
                }
            }
        }
        for(String aparicion: esMutante.keySet()) {
            if(esMutante.get(aparicion)) {
                contador += 1;
            }
        }
        return contador >= 2;
    }
}