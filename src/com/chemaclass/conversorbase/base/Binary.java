/*
 * Conversor -  Copyright (C) 2013 
 * José María Valera Reales <chemaclass@outlook.es> Twitter: @Chemaclass
 * http://www.chemaclass.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.chemaclass.conversorbase.base;

import java.util.StringTokenizer;

import com.chemaclass.conversorbase.Principal;
import com.chemaclass.conversorbase.Utils;

/**
 *
 * @author Chemaclass
 * @version 1.0
 */
public class Binary implements Base {

    @Override
    public String toBinary(String input) {
        return (!Utils.isBinary(input) || input.length() == 0) ? "Input error. Is binary?"
                : input;
    }

    @Override
    public String toOctal(String input) {
        if (!Utils.isBinary(input) || input.length() == 0) {
            return "Input error. Is binary?";
        }
        int residuo = 0;
        // Nos aseguramos que hayan de 3 y 3, para poder hacer la división
        if ((residuo = input.length() % 3) != 0) {
            String s = (residuo == 1) ? "00" : "0";
            input = s + input;
        }
        return convert(input, 3);
    }

    @Override
    public String toHexadecimal(String input) {
        if (!Utils.isBinary(input) || input.length() == 0) {
            return "Input error. Is binary?";
        }
        int residuo = 0;
        // Nos aseguramos que hayan de 4 y 4, para poder hacer la división
        if ((residuo = input.length() % 4) != 0) {
            String s = (residuo == 1) ? "000" : ((residuo == 2) ? "00" : "0");
            input = s + input;
        }
        return convert(input, 4);
    }

    /**
     *
     * @param input
     * @param base
     * @return
     */
    private String convert(String input, int base) {
        String resultado = "";

        // Ahora tenemos a 'input' con el binario completo y pasaremos a
        // dividirlo de 3 en 3
        String aux = "", log = "/ ";
        for (int i = 0; i < input.length() - 1; i += base) {
            String s = input.substring(i, i + base);
            int decimal = Integer.parseInt(Utils.getDecimalByBinary(s));
            log += s + ":" + Utils.getCharByHexa(decimal) + " / ";
            aux += s + " ";
        }
        Principal.log(log);
        StringTokenizer st = new StringTokenizer(aux, " ");// recortamos

        while (st.hasMoreElements()) {
            // recorremos los binarios
            String next = st.nextToken();
            // obtenemos de cada binario su balor decimal
            int decimal = Integer.parseInt(Utils.getDecimalByBinary(next));
            // nos aseguramos de obtener su posible valor hexadecimal (con letra
            // si la hubiere)
            resultado += Utils.getCharByHexa(decimal);
        }
        return resultado;
    }

    @Override
    public String toDecimal(String input) {
        if (!Utils.isBinary(input) || input.length() == 0) {
            return "Input error. Is binary?";
        }
        // Si es 0 o 1
        if (input.length() <= 4) {
            if (Long.parseLong(input) == 0 || Long.parseLong(input) == 1) {
                return input;
            }
        }
        // Para todo lo demás
        String out = "";
        long resultado = 0, base = 0;
        long sumaje;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            //si es 1 entonces preparamos el dígito a su potencia
            if (c == '1') {
                sumaje = (long) Math.pow(2, base);
                out = sumaje + " (2^" + base + ") \n" + " + " + out;
                resultado += sumaje;
            }
            base++;
        }
        // quitamos el último signo '+'
        out = out.substring(0, out.length() - 3);
        out += " = " + resultado;// añadimos el resultado
        Principal.log(out);
        return String.valueOf(resultado); // TextField de resultado     
    }

    @Override
    public String me() {
        return "Binary";
    }
}
