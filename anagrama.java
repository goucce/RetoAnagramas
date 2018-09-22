package com.PruebaAnagramas;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class anagrama {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.printf("Escriba una palabra y le buscaremos sus anagramas: ");
        String anagrama = sc.next();
        System.out.println("");
        System.out.println("Tu palabrá elegida es:");
        System.out.println(anagrama);


        ////////////////////////////////
        //Ordeno alfabeticamente la palabra escrita
        ///////////////////////////////
        char[] letras = new char[anagrama.length()];
        //Creamos un array en char para utilizar el formato estandar e internacional

        for (int i = 0; i < letras.length; i++)
            letras[i] = anagrama.charAt(i);

        java.util.Arrays.sort(letras);

        String anagramaABC = new String(letras); //Conversion de char [ ] en String

        System.out.println();
        System.out.println("Tu palabrá ordenada alfabeticamente:");
        System.out.println(anagramaABC);

        ////////////////////////////////
        //******************************
        //*****************************
        ///////////////////////////////

        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;

        System.out.println();
        System.out.println("Seleccione el txt donde se realizará la busqueda:");

        //Para seleccionar el archivo
        JFileChooser j = new JFileChooser();
        j.showOpenDialog(j);

        try{
            //String con la ruta de la eleccion del archivo que hemos selecionado

            String ruta = j.getSelectedFile().getAbsolutePath();

            //Creacion del objeto file, asociado a la ruta del txt que queremos seleccionar.
            File f = new File(ruta);

            //Ahora hay que crear un scanner que pueda leer el fichero que le seleccionamos.
            //Para que funciono falta el catch FileNotFoundException
             entrada = new Scanner(f);

             //Pijería de decir el fichero que es
            System.out.println();
            System.out.println("Archivo: " + f.getName());
            System.out.println();
            System.out.println("Anagramas encontrados:");

            //Tenemos que recorrer cada linea del .txt
            //seleccionamos la entrada, que recorreco el archivo file donde esta asociado la ruta de .txt
            while (entrada.hasNext()) {

                //lectura de una linea del texto, cuando la llamemos, dirá lo que aparecerá:
                linea = entrada.nextLine();

                String lineaToString = new String(linea);

                ////////////////////////////////
                //Intento de cambiar y ordenar el .txt

                char[] letrasTXT = new char[lineaToString.length()];
                //Creamos un array en char para utilizar el formato estandar e internacional

                for (int i = 0; i < letrasTXT.length; i++)
                    letrasTXT[i] = lineaToString.charAt(i);

                java.util.Arrays.sort(letrasTXT);

                String lineaABC = new String(letrasTXT);

                //**********************************
                //////////////////////////////////

                //si la línea contiene el texto ("anagramaABC") buscado se muestra por pantalla
                if (anagramaABC.equals(lineaABC)) {
                    //Indicamos el numero de linea que es devolvemos true, en el booleano de contiene.
                    System.out.println("Linea " + numeroDeLinea + ": " + linea);
                    contiene = true;
                }
                  numeroDeLinea++; //Incrementamos el numero de linea para mostar cual es

            }
            ////////////////////
            //ERRORES
            /////////////////////
            if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo

                System.out.println(anagrama + " no se ha encontrado en el archivo");
            }

        }
        catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (entrada != null) {
                entrada.close();
            }
        }


    }


}




















