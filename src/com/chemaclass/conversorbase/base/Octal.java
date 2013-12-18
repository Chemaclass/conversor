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
public class Octal implements Base {

    @Override
    public String toBinary(String input) {
        if (!Utils.isOctal(input) || input.length() == 0) {
            return "Input Error. Is Octal? ";
        }
        String resultado = "", binario = "", out = "/ ";
        for (int i = 0; i < input.length(); i++) {
            String s = "" + input.charAt(i);
            binario = Utils.getBinaryByDecimal(s, 8);// obtenemos el binario
            out += s + ":" + binario + " / "; // guardamos para la consola
            resultado += binario;// guardamos al resultado output
        }
        Principal.log(out);// imprimimos en la consola
        return resultado;// devolvemos el resultado al output
    }

    @Override
    public String toOctal(String input) {
        return (!Utils.isOctal(input) || input.length() == 0) ? "Input error. Is octal?"
                : input;

    }

    @Override
    public String toDecimal(String input) {
        if (!Utils.isOctal(input) || input.length() == 0) {
            return "Input Error. Is Octal?";
        }
        String resultado = "", decimal = "", out = "First convert to binary:\n/ ";
        for (int i = 0; i < input.length(); i++) {
            String s = "" + input.charAt(i);
            decimal = Utils.getBinaryByDecimal(s, 8);// obtenemos el decimal
            out += s + ":" + decimal + " / "; // guardamos para la consola
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
        if (!Utils.isOctal(input) || input.length() == 0) {
            return "Input Error. Is Octal?";
        }
        String resultado = "", decimal = "", out = "First convert to binary:\n";
        for (int i = 0; i < input.length(); i++) {
            String s = "" + input.charAt(i);
            decimal = Utils.getBinaryByDecimal(s, 8);// obtenemos el decimal
            out += s + ":" + decimal + " "; // guardamos para la consola
            resultado += decimal;// guardamos al resultado output
        }
        out += "\nThe binary would be " + resultado + "\n";
        out += "Now we do the divisions from binary result:";

        Principal.log(out);// imprimimos en la consola

        Binary binary = new Binary();
        resultado = binary.toHexadecimal(resultado);

        return resultado;// devolvemos el resultado al output
    }

    @Override
    public String me() {
        return "Octal";
    }
}
