package edu.TecMilenio;
import java.io.*;

public class Promedio {
    private static BufferedReader Captura = new BufferedReader(new InputStreamReader(System.in));

    public static void Calificacion() {
        String nombreEstudinate = ""; //atributo para guardar el nombre del estudiante
        Double[] Calificaciones = null; ///atributo para guardar la calificacion del estudiante
        Double promedioFnal = 0.0; //atributo para dar con el promedio
        try {
            System.out.print("Favor de ingresar el Nombre del Estudiante: ");
            nombreEstudinate = Captura.readLine().toString().trim().toUpperCase();
            Calificaciones = ObtenerCalificaciones(5, 0);
            promedioFnal = CalcularPromedio(Calificaciones);
            CalificacionPantalla(nombreEstudinate, Calificaciones, promedioFnal, CalificacionLetraFinal(promedioFnal));
        }
        catch (Exception ex){

        }
    }
    private static Double[] ObtenerCalificaciones(int Arreglo, int Conteo) {
        Double[] dbResult = new Double[Arreglo];
        try{
            do {
                dbResult[Conteo] = ObtenerCalificaciones(Conteo);
                Conteo ++;
            } while (Conteo <= (Arreglo -1));
        }
        catch(Exception ex) { }
        finally { }
        return dbResult;
    }
    private static Double ObtenerCalificaciones(int nRenglonCont) {
        Double Resultado = 0.0;
        try{
            System.out.print("Calificación " + (nRenglonCont + 1) + ":  ");
            Resultado = Double.parseDouble(Captura.readLine());
            if (Resultado < 0 || Resultado > 100) throw new IOException("La calificación ingresada es errónea.");
            Resultado = Math.round(Resultado * 100.00) / 100.00;
        }
        catch(IOException | NumberFormatException ex) {
            System.out.print(" El tipo de dato ingresado no es un numero, ingresar una Calificación valido. ");
            Resultado = ObtenerCalificaciones(nRenglonCont);
        }
        finally { }
        return Resultado;
    }
    private static Double CalcularPromedio(Double[] dbCalificaciones){ //metodo para calcular el promedio
        Double Resultado = 0.0;
        Integer Conteo = 0;
        try {
            for (Conteo = 0; Conteo < dbCalificaciones.length; Conteo++)
            {
                Resultado = Resultado + dbCalificaciones[Conteo];
            }
            Resultado = Math.round((Resultado / dbCalificaciones.length) * 100.00) / 100.00;
        }
        catch (Exception ex){

        }
        return Resultado;
    }
    private static String CalificacionLetraFinal(Double Promedio){ //metodo para calcular la calificacion final con letras segun lo menciona la actividad.
        String caligicacion = "A";

        if (Promedio >= 51.00 && Promedio <= 60.99) caligicacion = "E";
        else if (Promedio >= 61.00 && Promedio <= 70.99) caligicacion = "D";
        else if (Promedio >= 71.00 && Promedio <= 80.99) caligicacion = "C";
        else if (Promedio >= 81.00 && Promedio <= 90.99) caligicacion = "B";
        else if (Promedio >= 91.00 && Promedio <= 100.99) caligicacion = "A";
        else caligicacion = "F";

        return caligicacion;
    }
    private static void CalificacionPantalla(String nombreAlumno, Double[] aCalificaciones, Double Promedio, String Letracalificacion) {
        //metodo para imprimir la informacion que contiene el nombre del alumno, el arreglo con las calificaciones del estudiante, el promedio del estudiante y la calificacion en letra del estudiante
        Integer nConteo = 0;
        System.out.println("");
        System.out.println("");
        System.out.println("  Nombre del estudiante: " + nombreAlumno);
        for (nConteo = 0; nConteo < aCalificaciones.length; nConteo++)
        {
            System.out.println("       Calificación " + (nConteo + 1) + ": " + aCalificaciones[nConteo]);
        }
        System.out.println("        Promedio: " + Promedio);
        System.out.println("    Calificación: " + Letracalificacion);
    }

}
