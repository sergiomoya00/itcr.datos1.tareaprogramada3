/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
*
* @author Mario
*/
public class FechaHora {
public static void main(String[] args) {
Date date = new Date();
//Caso 1: obtener la hora y salida por pantalla con formato:
DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
 int i = (int) new Date().getTime();
 System.out.println("Integer : " + i);
 System.out.println("Long : "+ new Date().getTime());
 System.out.println("Long date : " + new Date(new Date().getTime()));
 System.out.println("Int Date : " + new Date(i));
System.out.println("Hora: "+hourFormat.format(date));
System.out.println(date);
}
}
