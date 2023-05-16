import controlador.Controlador;
import controlador.Menu;
import model.Connexio;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Benvingut al sistema gestor de la base de dades de eleccions generals.");

        Connexio.conectar();

        if (Connexio.getConnexio() == null) {
            return;
        }

        Controlador.generarScanner();

        Menu.principal();

        Connexio.desconectar();
        Controlador.tancarScanner();
    }
}