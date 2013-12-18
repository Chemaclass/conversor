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
public class Decimal implements Base {

    @Override
    public String toBinary(String input) {
        return (!Utils.isDecimal(input) || input.length() == 0) ? "Input Error. Is decimal?"
                : convert(input, 2);
    }

    @Override
    public String toOctal(String input) {
        return (!Utils.isDecimal(input) || input.length() == 0) ? "Input Error. Is decimal?"
                : convert(input, 8);
    }

    @Override
    public String toDecimal(String input) {
        return (!Utils.isDecimal(input) || input.length() == 0) ? "Input Error. Is decimal?"
                : input;
    }

    @Override
    public String toHexadecimal(String input) {
        return (!Utils.isDecimal(input) || input.length() == 0) ? "Input Error. Is decimal?"
                : convert(input, 16);
    }

    /**
     * Transformar en número de entrada (en base decimal) a la base que se
     * indique en el parámetro base.
     *
     * @param inputDecimal Número en base decimal que queremos manipular
     * @param base Base a la cual queremos transformar la entrada
     */
    private String convert(String inputDecimal, int base) {
        String resultado = "", out = "";
        long input, aux = Long.parseLong(inputDecimal);
        int residuo = 0;
        while (Math.round(aux / base) != 0) {
            residuo = (int) aux % base;// sacamos el residuo
            residuo = Math.abs(residuo); // Nos aseguramos de que sea su abs
            input = aux; // guardamos aux antes de hacer su división
            aux /= base;// dividimos
            // Si la base a convertir es hexadecimal convertimos el número en
            // letra, si no, simplemente ponemos su número
            resultado = ((base == 16 && residuo > 9) ? Utils.getCharByHexa(residuo)
                    : residuo) + resultado;
            out += input + " / " + base + " =  " + aux + " (->" + residuo
                    + ")\t| ... " + resultado + "\n";
        }
        // Y una vez más para el que queda
        residuo = (int) aux % base;// sacamos el residuo
        input = aux; // guardamos aux antes de hacer su división
        aux /= base;// Oudividimos
        resultado = ((base == 16 && residuo > 9) ? Utils.getCharByHexa(residuo)
                : residuo) + resultado;
        out += input + " / " + base + "  =  " + aux + " (->" + residuo
                + ")\t| ... " + resultado;

        Principal.log(out);
        return resultado; // editText de resultado
    }

    @Override
    public String me() {
        return "Decimal";
    }
}
