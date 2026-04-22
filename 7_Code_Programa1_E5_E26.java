/********************************************************************
* Program Assignment: Programa 2
* Name: Martin Alejandro Gaspar Mercado
* Date: 20 marzo 2026
* Description: Programa que analiza archivos Java para calcular
* el total de lineas de codigo, las clases encontradas, el numero
* de metodos por clase, el tamano por clase y la densidad de
* comentarios, siguiendo el estandar de conteo definido.
********************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/********************************************************************
* Esta clase concentra la lectura del archivo y el analisis de sus
* lineas para obtener las metricas solicitadas en la practica.
********************************************************************/
class AnalizadorComplejidad {
    private String rutaArchivo;
    private int maxLineas = 2000;
    private String[] lineas = new String[maxLineas];
    private int numLineas;
    private int maxClases = 100;
    private String[] nombreDeClases = new String[maxClases];
    private int[] numMetodosClase = new int[maxClases];
    private int[] locPorClase = new int[maxClases];
    private int numClases;
    private String claseActual;
    private int posicionClaseActual;
    private int nivelLlaves;
    private int nivelClaseActual;
    private int totalLoc;
    private int totalComentarios;
    private double densidadComentarios;
    private boolean clasePendiente;
    private int posicionClasePendiente;

    /****************************************************************
    * Inicializa los contadores y estructuras necesarias para el
    * analisis del archivo fuente indicado por el usuario.
    ****************************************************************/
    public AnalizadorComplejidad(String ruta) {
        this.rutaArchivo = ruta;
        this.numLineas = 0;
        this.numClases = 0;
        this.claseActual = null;
        this.posicionClaseActual = -1;
        this.nivelLlaves = 0;
        this.nivelClaseActual = -1;
        this.totalLoc = 0;
        this.totalComentarios = 0;
        this.densidadComentarios = 0.0;
        this.clasePendiente = false;
        this.posicionClasePendiente = -1;
    }

    /****************************************************************
    * Lee el archivo linea por linea y lo almacena en un arreglo
    * para poder recorrerlo despues durante el analisis.
    ****************************************************************/
    public void leerArchivo() throws IOException {
        numLineas = 0;
        BufferedReader lectorArchivo = new BufferedReader(
            new FileReader(rutaArchivo)
        );
        String lineaLeida;

        while ((lineaLeida = lectorArchivo.readLine()) != null) {
            if (numLineas >= maxLineas) {
                lectorArchivo.close();
                throw new IOException(
                    "El archivo tiene mas lineas de lo permitido"
                );
            }
            lineas[numLineas] = lineaLeida;
            numLineas++;
        }

        lectorArchivo.close();
    }

    /****************************************************************
    * Determina si una linea completa corresponde a comentario.
    * Estas lineas se contabilizan como comentarios y no como LOC.
    ****************************************************************/
    public boolean esComentarioLineaCompleta(String linea) {
        String lineaDepurada = linea.trim();

        if (lineaDepurada.startsWith("//")) {
            return true;
        }
        if (lineaDepurada.startsWith("/*")) {
            return true;
        }
        if (lineaDepurada.startsWith("*")) {
            return true;
        }
        if (lineaDepurada.startsWith("*/")) {
            return true;
        }

        return false;
    }

    /****************************************************************
    * Devuelve una version de la linea apta para analisis:
    * - elimina comentario simple //
    * - reemplaza contenido de strings por espacios
    * - reemplaza contenido de chars por espacios
    * Asi evita confundir llaves, parentesis o // dentro de literales.
    ****************************************************************/
    public String normalizarLineaCodigo(String linea) {
        if (linea == null) {
            return "";
        }

        String resultado = "";
        boolean dentroCadena = false;
        boolean dentroCaracter = false;
        boolean escapado = false;

        for (int indiceCaracter = 0;
                indiceCaracter < linea.length();
                indiceCaracter++) {
            char caracterActual = linea.charAt(indiceCaracter);

            if (!dentroCadena && !dentroCaracter) {
                if (caracterActual == '/'
                        && indiceCaracter + 1 < linea.length()
                        && linea.charAt(indiceCaracter + 1) == '/') {
                    break;
                }
            }

            if (escapado) {
                resultado = resultado + " ";
                escapado = false;
                continue;
            }

            if ((dentroCadena || dentroCaracter) && caracterActual == '\\') {
                resultado = resultado + " ";
                escapado = true;
                continue;
            }

            if (!dentroCaracter && caracterActual == '"') {
                dentroCadena = !dentroCadena;
                resultado = resultado + " ";
                continue;
            }

            if (!dentroCadena && caracterActual == '\'') {
                dentroCaracter = !dentroCaracter;
                resultado = resultado + " ";
                continue;
            }

            if (dentroCadena || dentroCaracter) {
                resultado = resultado + " ";
            } else {
                resultado = resultado + caracterActual;
            }
        }

        return resultado;
    }

    /****************************************************************
    * Determina si una linea cuenta como LOC segun el estandar de
    * conteo realizado para esta practica.
    ****************************************************************/
    public boolean esLineaCodigoValida(String linea) {
        String lineaDepurada = normalizarLineaCodigo(linea).trim();

        if (lineaDepurada.length() == 0) {
            return false;
        }

        return true;
    }

    /****************************************************************
    * Busca la palabra class dentro de la linea y, si existe una
    * declaracion valida, extrae el nombre de la clase.
    ****************************************************************/
    public String esClase(String linea) {
        String lineaDepurada = normalizarLineaCodigo(linea).trim();
        int posicionClass = lineaDepurada.indexOf("class");

        if (posicionClass == -1) {
            return null;
        }

        if (posicionClass > 0) {
            char caracterAnterior = lineaDepurada.charAt(posicionClass - 1);
            if (Character.isLetterOrDigit(caracterAnterior)
                    || caracterAnterior == '_') {
                return null;
            }
        }

        if (posicionClass + 5 < lineaDepurada.length()) {
            char caracterSiguiente = lineaDepurada.charAt(posicionClass + 5);
            if (!Character.isWhitespace(caracterSiguiente)) {
                return null;
            }
        }

        int indiceCaracter = posicionClass + 5;
        while (indiceCaracter < lineaDepurada.length()
                && Character.isWhitespace(
                    lineaDepurada.charAt(indiceCaracter))) {
            indiceCaracter++;
        }

        String nombreClase = "";
        while (indiceCaracter < lineaDepurada.length()) {
            char caracterActual = lineaDepurada.charAt(indiceCaracter);
            if (Character.isLetterOrDigit(caracterActual)
                    || caracterActual == '_') {
                nombreClase = nombreClase + caracterActual;
                indiceCaracter++;
            } else {
                break;
            }
        }

        if (nombreClase.length() == 0) {
            return null;
        }

        return nombreClase;
    }

    /****************************************************************
    * Registra una clase nueva si aun no existe y prepara sus
    * contadores de metodos y LOC.
    ****************************************************************/
    public int extraerNombreClase(String nombreClase) {
        for (int indiceClase = 0; indiceClase < numClases; indiceClase++) {
            if (nombreClase.equals(nombreDeClases[indiceClase])) {
                return indiceClase;
            }
        }

        if (numClases >= maxClases) {
            return -1;
        }

        nombreDeClases[numClases] = nombreClase;
        numMetodosClase[numClases] = 0;
        locPorClase[numClases] = 0;
        numClases++;

        return numClases - 1;
    }

    /****************************************************************
    * Detecta si una linea contiene una declaracion de clase y la
    * registra dentro de las estructuras del analizador.
    ****************************************************************/
    public int detectarYRegistrarClase(String linea) {
        String nombreClase = esClase(linea);
        if (nombreClase == null) {
            return -1;
        }
        return extraerNombreClase(nombreClase);
    }

    /****************************************************************
    * Actualiza el nivel de llaves considerando solo llaves reales
    * de bloques y no las que aparecen dentro de strings o chars.
    ****************************************************************/
    public void actualizarNivelLlaves(String linea) {
        String lineaDepurada = normalizarLineaCodigo(linea);

        for (int indiceCaracter = 0;
                indiceCaracter < lineaDepurada.length();
                indiceCaracter++) {
            char caracterActual = lineaDepurada.charAt(indiceCaracter);

            if (caracterActual == '{') {
                nivelLlaves++;
            } else if (caracterActual == '}') {
                nivelLlaves--;
                if (nivelLlaves < 0) {
                    nivelLlaves = 0;
                }
            }
        }
    }

    /****************************************************************
    * Verifica si la llave de apertura de un metodo se encuentra
    * en la siguiente linea util del archivo.
    ****************************************************************/
    public boolean llaveAbreEnSiguienteLinea(int indiceLinea) {
        int indiceRevision = indiceLinea + 1;

        while (indiceRevision < numLineas) {
            String lineaSiguiente = lineas[indiceRevision];

            if (lineaSiguiente == null) {
                indiceRevision++;
                continue;
            }

            if (esComentarioLineaCompleta(lineaSiguiente)) {
                indiceRevision++;
                continue;
            }

            String lineaDepurada = normalizarLineaCodigo(lineaSiguiente).trim();

            if (lineaDepurada.length() == 0) {
                indiceRevision++;
                continue;
            }

            return lineaDepurada.equals("{");
        }

        return false;
    }

    /****************************************************************
    * Obtiene la ultima palabra antes del parentesis de apertura.
    * Se usa para identificar el nombre potencial de un metodo sin
    * utilizar expresiones regulares.
    ****************************************************************/
    public String obtenerUltimaPalabra(String texto) {
        int finPalabra = texto.length() - 1;

        while (finPalabra >= 0
                && Character.isWhitespace(texto.charAt(finPalabra))) {
            finPalabra--;
        }

        if (finPalabra < 0) {
            return "";
        }

        int inicioPalabra = finPalabra;
        while (inicioPalabra >= 0
                && !Character.isWhitespace(texto.charAt(inicioPalabra))
                && texto.charAt(inicioPalabra) != '.') {
            inicioPalabra--;
        }

        return texto.substring(inicioPalabra + 1, finPalabra + 1);
    }

    /****************************************************************
    * Determina si la palabra recibida es una estructura de control
    * y no una firma valida de metodo.
    ****************************************************************/
    public boolean esEstructuraControl(String palabra) {
        return palabra.equals("if")
            || palabra.equals("while")
            || palabra.equals("for")
            || palabra.equals("switch")
            || palabra.equals("catch")
            || palabra.equals("return")
            || palabra.equals("new")
            || palabra.equals("throw")
            || palabra.equals("else")
            || palabra.equals("do")
            || palabra.equals("try");
    }

    /****************************************************************
    * Determina si una linea corresponde a la firma de un metodo
    * valido dentro de una clase.
    ****************************************************************/
    public boolean esMetodo(String linea, int indiceLinea) {
        String lineaDepurada = normalizarLineaCodigo(linea).trim();

        if (lineaDepurada.length() == 0) {
            return false;
        }

        if (lineaDepurada.indexOf("class") != -1) {
            return false;
        }

        int posicionParentesisAbre = lineaDepurada.indexOf('(');
        int posicionParentesisCierra = lineaDepurada.indexOf(')');

        if (posicionParentesisAbre == -1 || posicionParentesisCierra == -1) {
            return false;
        }

        if (posicionParentesisCierra < posicionParentesisAbre) {
            return false;
        }

        int posicionIgual = lineaDepurada.indexOf('=');
        if (posicionIgual != -1 && posicionIgual < posicionParentesisAbre) {
            return false;
        }

        String parteAntesParentesis = lineaDepurada.substring(
            0, posicionParentesisAbre
        ).trim();

        if (parteAntesParentesis.length() == 0) {
            return false;
        }

        if (parteAntesParentesis.indexOf('.') != -1) {
            return false;
        }

        String nombreMetodo = obtenerUltimaPalabra(parteAntesParentesis);

        if (nombreMetodo.length() == 0) {
            return false;
        }

        if (!Character.isLetter(nombreMetodo.charAt(0))) {
            return false;
        }

        if (esEstructuraControl(nombreMetodo)) {
            return false;
        }

        boolean tieneLlaveEnMismaLinea = lineaDepurada.indexOf('{') != -1;
        boolean tienePuntoYComa = lineaDepurada.indexOf(';') != -1;

        if (tienePuntoYComa && !tieneLlaveEnMismaLinea) {
            return false;
        }

        if (tieneLlaveEnMismaLinea) {
            return true;
        }

        return llaveAbreEnSiguienteLinea(indiceLinea);
    }

    /****************************************************************
    * Recorre el archivo linea por linea para calcular el total de
    * comentarios, LOC, metodos por clase y tamano por clase.
    ****************************************************************/
    public void analizar() {
        claseActual = null;
        posicionClaseActual = -1;
        nivelLlaves = 0;
        nivelClaseActual = -1;
        totalLoc = 0;
        totalComentarios = 0;
        clasePendiente = false;
        posicionClasePendiente = -1;

        for (int indiceLinea = 0; indiceLinea < numLineas; indiceLinea++) {
            String lineaOriginal = lineas[indiceLinea];

            if (lineaOriginal == null) {
                continue;
            }

            if (esComentarioLineaCompleta(lineaOriginal)) {
                totalComentarios++;
                continue;
            }

            String lineaDepurada = normalizarLineaCodigo(lineaOriginal).trim();

            int indiceClaseDetectada = detectarYRegistrarClase(lineaOriginal);
            if (indiceClaseDetectada != -1) {
                clasePendiente = true;
                posicionClasePendiente = indiceClaseDetectada;
            }

            if (clasePendiente && lineaDepurada.indexOf('{') != -1) {
                posicionClaseActual = posicionClasePendiente;
                claseActual = nombreDeClases[posicionClaseActual];
                nivelClaseActual = nivelLlaves + 1;
                clasePendiente = false;
                posicionClasePendiente = -1;
            }

            boolean estaDirectamenteDentroDeClase =
                (claseActual != null && nivelLlaves == nivelClaseActual);

            if (estaDirectamenteDentroDeClase) {
                if (esMetodo(lineaOriginal, indiceLinea)) {
                    numMetodosClase[posicionClaseActual]++;
                }
            }

            if (esLineaCodigoValida(lineaOriginal)) {
                totalLoc++;
                if (posicionClaseActual != -1) {
                    locPorClase[posicionClaseActual]++;
                }
            }

            actualizarNivelLlaves(lineaOriginal);

            if (claseActual != null && nivelLlaves < nivelClaseActual) {
                claseActual = null;
                posicionClaseActual = -1;
                nivelClaseActual = -1;
            }
        }

        calcularDensidadComentarios();
    }

    /****************************************************************
    * Calcula la densidad de comentarios a partir del total de
    * comentarios y el total de lineas de codigo.
    ****************************************************************/
    public void calcularDensidadComentarios() {
        if (totalLoc > 0) {
            densidadComentarios = (double) totalComentarios
                / (double) totalLoc;
        } else {
            densidadComentarios = 0.0;
        }
    }

    /****************************************************************
    * Imprime el reporte final con las metricas obtenidas durante
    * el analisis del archivo.
    ****************************************************************/
    public void imprimirReporteCompleto() {
        System.out.println("Reporte del programa analizado");
        for (int indiceClase = 0; indiceClase < numClases; indiceClase++) {
            System.out.println("Clase: " + nombreDeClases[indiceClase]);
            System.out.println("Metodos: " + numMetodosClase[indiceClase]);
            System.out.println(
                "Tamano de la clase: " + locPorClase[indiceClase]
            );
        }
        System.out.println("Tamano total: " + totalLoc);
        System.out.println(
            "Densidad de comentarios: " + densidadComentarios
        );
    }
}

/********************************************************************
* Esta clase controla la ejecucion general del programa y obtiene
* la ruta del archivo que sera analizado por el sistema.
********************************************************************/
public class Main {
    public static void main(String[] args) throws IOException {
        String rutaArchivo;

        if (args.length > 0) {
            rutaArchivo = args[0];
        } else {
            Scanner entradaUsuario = new Scanner(System.in);
            System.out.print("Dame la ruta del archivo .java: ");
            rutaArchivo = entradaUsuario.nextLine();
            entradaUsuario.close();
        }

        AnalizadorComplejidad analizador;
        analizador = new AnalizadorComplejidad(rutaArchivo);
        analizador.leerArchivo();
        analizador.analizar();
        analizador.imprimirReporteCompleto();
    }
}