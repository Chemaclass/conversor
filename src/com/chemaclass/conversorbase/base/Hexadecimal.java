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

import com.chemaclass.conversorbase.Principal;
import com.chemaclass.conversorbase.Utils;

/**
 *
 * @author Chemaclass
 * @version 1.0
 */
public class Hexadecimal implements Base {

    @Override
    public String toBinary(String input) {
        if (!Utils.isHexadecimal(input) || input.length() == 0) {
            String text = "Input Error. Is Hexadecimal?";
            return text;
        }
        String resultado = "", binario = "", out = "";
        for (int i = 0; i < input.length(); i++) {
            String s = "" + input.charAt(i);
            // Si no es una letra, obtenemos su binario
            if (!Utils.isAlpha(s)) {
                binario = Utils.getBinaryByDecimal(s, 16);
            } // Si es una letra obtenemos su binario
            else {
                binario = Utils.getBinaryByAlpha(s);
            }
            out += s + ":" + binario + " "; // guardamos para la consola
            resultado += binario;// guardamos al resultado output
        }
        Principal.log(out);// imprimimos en la consola
        return resultado;// devolvemos el resultado al output
    }

    @Override
    public String toOctal(String input) {
        if (!Utils.isHexadecimal(input) || input.length() == 0) {
            return "Input Error. Is Hexadecimal?";
        }
        String resultado = "", decimal = "", out = "First convert to binary:\n";
        for (int i = 0; i < input.length(); i++) {
            String s = "" + input.charAt(i);
            // Si no es una letra, obtenemos su binario
            if (!Utils.isAlpha(s)) {
                decimal = Utils.getBinaryByDecimal(s, 16);
            } // Si es una letra obtenemos su binario
            else {
                decimal = Utils.getBinaryByAlpha(s);
            }
            out += s + ":" + decimal + " "; // guardamos para la consola
            resultado += decimal;// guardamos al resultado output
        }
        out += "\nThe binary would be " + resultado + "\n";
        out += "Now we do the sums to pass from binary to octal:";

        Principal.log(out);// imprimimos en la consola

        Binary binary = new Binary();
        resultado = binary.toOctal(resultado);

        return resultado;// devolvemos el resultado al output
    }

    @Override
    public String toDecimal(String input) {
        if (!Utils.isHexadecimal(input) || input.length() == 0) {
            return "Input Error. Is Hexadecimal?";
        }
        String resultado = "", decimal = "", out = "First convert to binary:\n";
        for (int i = 0; i < input.length(); i++) {
            String s = "" + input.charAt(i);
            // Si no es una letra, obtenemos su binario
            if (!Utils.isAlpha(s)) {
                decimal = Utils.getBinaryByDecimal(s, 16);
            } // Si es una letra obtenemos su binario
            else {
                decimal = Utils.getBinaryByAlpha(s);
            }
            out += s + ":" + decimal + " "; // guardamos para la consola
            resultado += decimal;// guardamos al resultado output
        }
        out += "\nThe binary would be " + resultado + "\n";
        out += "Now we do the sums to pass from binary to decimal:";

        Principal.log(out);// imprimimos en la consola

        Binary binary = new Binary();
        resultado = binary.toDecimal(resultado);
        return resultado;// devolvemos el resultado al output
    }

    @Override
    public String toHexadecimal(String input) {
        return (!Utils.isHexadecimal(input) || input.length() == 0) ? "Input error. Is hexadecimal?"
                : input;
    }

    @Override
    public String me() {
        return "Hexadecimal";
    }
}
