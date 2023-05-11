import controlador.Controlador;
import controlador.Menu;
import model.Connexio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvingut al sistema gestor de la base de dades de eleccions generals.");

        Connexio db = new Connexio();
        Connexio.conectar();
        Controlador controlador = new Controlador();
        controlador.generarScanner();

        Menu.principal();

        Connexio.desconectar();
        controlador.tancarScanner();
    }


}