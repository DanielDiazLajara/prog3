package mains;
/**
 * Funciones útiles para la 
 * correcta ejecución de la
 * práctica
 */
public class FileUtils {
	/**
	 * Separa la extensión de una cadena
	 * @param name cadena entera con nombre del archivo
	 * @return extension de la cadena 
	 */
    public static String getFileExtension(String name) {
        int extIndex = name.lastIndexOf(".");

        if (extIndex == -1) {
            return "";
        } else {
            return name.substring(extIndex + 1);
        }
    }
}
