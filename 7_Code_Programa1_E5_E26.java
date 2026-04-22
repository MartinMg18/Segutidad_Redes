import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
class analizadorComplejidad{
	private String rutaArchivo;
	private int maxLineas = 2000; //Pongo un limite que sera el tamaño maximo del arreglo y sera el limite de lineas que soportara el programa
	private String[] lineas = new String[maxLineas];
	private int numLineas;  
	private int maxClases = 100; //Aqui igual creo esta variable para dar tamaño a arreglos
	private String[] nombreDeClases = new String[maxClases];
	private int[] numMetodosPublic = new int[maxClases];
	private int numClases;
	private String claseActual;
	private int posClaseAct;
	private int nivelLlaves;

	public analizadorComplejidad(String ruta){
		this.rutaArchivo = ruta;
		this.numLineas = 0;
		this.numClases = 0;
		this.claseActual = null;
		this.posClaseAct = -1;
		this.nivelLlaves = 0;
	}

	public void leerArchivo() throws IOException{
		numLineas = 0;
		BufferedReader leeArchivo = new BufferedReader(new FileReader(rutaArchivo));
		String lineaLeida;
		while((lineaLeida = leeArchivo.readLine())!=null){
			if(numLineas >= maxLineas){
			leeArchivo.close();
			throw new IOException("El archivo tiene mas líneas de lo permitido");
			}
			lineas[numLineas] = lineaLeida;
			numLineas++;
		}
		leeArchivo.close();
	}
	public String eliminaComentarios(String linea){
		int posComentario = linea.indexOf("//");
		if(posComentario != -1){
			return linea.substring(0, posComentario);
		}
		return linea;
	}
	public String esClase(String linea){
    	int posicionClass = linea.indexOf("class");
    	if (posicionClass == -1){ 
			return null;
		}
    	char caracterAntes;
    	if (posicionClass == 0) {
       		caracterAntes = ' ';
    	}else{
        	caracterAntes = linea.charAt(posicionClass - 1);
    	}		
		char caracterDespues;
    	if(posicionClass + 5 >= linea.length()) {
        	caracterDespues = ' ';
    	}else{
        	caracterDespues = linea.charAt(posicionClass + 5);
    	}
		int indiceCaracter = posicionClass + 5;
    	while(indiceCaracter < linea.length() && Character.isWhitespace(linea.charAt(indiceCaracter))) {
        	indiceCaracter++;
    	}
		String nombreClase = "";
    	while(indiceCaracter < linea.length()) {
        	char caracter = linea.charAt(indiceCaracter);
			if(Character.isLetterOrDigit(caracter)) {
            		nombreClase = nombreClase + caracter;
            		indiceCaracter++;
        	}else{
            	break;
        	}
    	}
		if(nombreClase.length() == 0){
			return null;
		}
    		return nombreClase;		
	}
	public int extraerNombreClase(String nombreClase){
		for(int indiceClase = 0; indiceClase < numClases; indiceClase++){
			if(nombreClase.equals(nombreDeClases[indiceClase])){
				return indiceClase;	
			}
		}
		if(numClases >= maxClases){
			return -1;//Error
		}
		nombreDeClases[numClases] = nombreClase;
		numMetodosPublic[numClases] = 0;
		numClases++;
		return numClases - 1;	
	}
	public int detectarYRegistrarClase(String linea) {
    	String nombreClase = esClase(linea);
    	if(nombreClase == null){
		return -1;
		}
    	return extraerNombreClase(nombreClase);
	}
	public void nivelLlaves(String linea){
		for (int indiceCaracter = 0; indiceCaracter < linea.length(); indiceCaracter++) {
        	char caracterActual = linea.charAt(indiceCaracter);
		if (caracterActual == '{'){
            		nivelLlaves++;
        	}else if(caracterActual == '}'){
           		nivelLlaves--;
            		if(nivelLlaves < 0){
                		nivelLlaves = 0;
            		}
        		}
    		}
	}
	public boolean esMetodoPublic(String linea) {
    	linea = linea.trim();
		if (!linea.startsWith("public ")) {
			return false;
		}
		if (linea.contains(" class ")) {
			return false;
		}
		if (linea.contains("=")) {
			return false;
		}
		int posParentesisAbre = linea.indexOf('(');
		int posParentesisCierra = linea.indexOf(')');
		if (posParentesisAbre == -1 || posParentesisCierra == -1 || posParentesisCierra < posParentesisAbre) {
			return false;
		}
		boolean tieneLlaveAbre = linea.indexOf('{') != -1;
		boolean tienePuntoYComa = linea.indexOf(';') != -1;
		if (!(tieneLlaveAbre || tienePuntoYComa)) {
			return false;
		}
		String antesPar = linea.substring(0, posParentesisAbre).trim();
		String[] partes = antesPar.split("\\s+");
		if (partes.length < 2) {
			return false;
		}
		String nombreMetodo = partes[partes.length - 1];
		if (!Character.isLetter(nombreMetodo.charAt(0))) {
			return false;
		}
		return true;
		}
	public void analizar() {
		claseActual = null;
		posClaseAct = -1;
		nivelLlaves = 0;
		for (int indiceLinea = 0; indiceLinea < numLineas; indiceLinea++) {
			String lineaOriginal = lineas[indiceLinea];
			if (lineaOriginal == null) continue;
			String lineaSinComentarios = eliminaComentarios(lineaOriginal);
			int indiceClaseDetectada = detectarYRegistrarClase(lineaSinComentarios);
			if (indiceClaseDetectada != -1) {
				posClaseAct = indiceClaseDetectada;
				claseActual = nombreDeClases[posClaseAct];
				nivelLlaves = 0;
			}
			boolean dentroDeClase = (claseActual != null && nivelLlaves >= 1);
			if (dentroDeClase) {
				if (!lineaSinComentarios.contains("class")) {
					boolean cuentaPorMismaLinea = esMetodoPublic(lineaSinComentarios);
					boolean cuentaPorSiguienteLinea = false;
					if (!cuentaPorMismaLinea) {
						boolean tienePublic = lineaSinComentarios.contains("public");
						boolean tieneParentesisAbre = lineaSinComentarios.indexOf('(') != -1;
						boolean tieneParentesisCierra = lineaSinComentarios.indexOf(')') != -1;
						boolean tieneLlaveAbre = lineaSinComentarios.indexOf('{') != -1;
						boolean tienePuntoYComa = lineaSinComentarios.indexOf(';') != -1;
						if (tienePublic && tieneParentesisAbre && tieneParentesisCierra && !tieneLlaveAbre && !tienePuntoYComa && llaveAbreEnSiguienteLinea(indiceLinea)) {
							cuentaPorSiguienteLinea = true;
						}
					}
					if (cuentaPorMismaLinea || cuentaPorSiguienteLinea) {
						int posPar = lineaSinComentarios.indexOf('(');
						if (posPar != -1) {
							String antesPar = lineaSinComentarios.substring(0, posPar).trim();
							String[] partes = antesPar.split("\\s+");
							String nombreMetodo = partes[partes.length - 1];
						if (cuentaPorMismaLinea || cuentaPorSiguienteLinea) {
							int posParentesis = lineaSinComentarios.indexOf('(');
							if (posParentesis != -1) {
								numMetodosPublic[posClaseAct]++;
							}
						}
						}
					}
				}
			}
			nivelLlaves(lineaSinComentarios);
			if (claseActual != null && nivelLlaves == 0) {
				claseActual = null;
				posClaseAct = -1;
			}
		}
	}	
	public boolean llaveAbreEnSiguienteLinea(int indiceLinea) {
		int recorre = indiceLinea + 1;
		while (recorre < numLineas) {
			String sig = lineas[recorre];
			if (sig == null) { recorre++; continue; }
			sig = eliminaComentarios(sig).trim();
			if (sig.length() == 0) { recorre++; continue; }
			return sig.startsWith("{");
		}
		return false;
	}
	public void imprimir(){
		for(int indiceClase = 0; indiceClase < numClases; indiceClase++){
			System.out.println(nombreDeClases[indiceClase] + ":" + numMetodosPublic[indiceClase]);
		}
	}
}
public class Main {
    public static void main(String[] args) throws IOException {
        String rutaArchivo;
        if (args.length > 0) {
            rutaArchivo = args[0];
        } else {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Dame la ruta del archivo .java: ");
            rutaArchivo = entrada.nextLine();
            entrada.close();
        }
        analizadorComplejidad analizador = new analizadorComplejidad(rutaArchivo);
        analizador.leerArchivo();
        analizador.analizar();
        analizador.imprimir();
    }
}