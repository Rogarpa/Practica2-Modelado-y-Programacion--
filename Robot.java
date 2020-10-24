import java.util.Scanner;
public class Robot{
    protected Estado estadoActual;
    
    protected Estado suspendido;
    protected Estado recibiendoOrden;
    protected Estado caminando;
    protected Estado reabasteciendo;
    protected Estado trabajando;
    protected Estado orden;
    
    protected Construccion casa;
    
    public Robot(){
        this.estadoActual = estadoActual;
        suspendido = new Suspendido(this);
        recibiendoOrden = new RecibiendoOrden(this);
        caminando = new Caminando(this);
        reabasteciendo = new Reabasteciendo(this);
        trabajando = new Trabajando(this);
    }
    
    public void cambiarEstado(Estado estadoActual){
        this.estadoActual = estadoActual;
    }
    
    public Estado getsuspendido(){
        return suspendido;
    }
    public Estado getrecibiendoOrden(){
        return recibiendoOrden;
    }
    public Estado getcaminando(){
        return caminando;
    }
    public Estado getreabasteciendo(){
        return reabasteciendo;
    }
    public Estado gettrabajando(){
        return trabajando;
    }
    public Estado getorden(){
        return orden;
    }
    
    public Construccion getcasa(){
        return casa;
    }
    
    public void activarse(){
        estadoActual.activarse();
    }
    public void caminar(){
        estadoActual.caminar();
    }
    public void dirigirseAlAreaDeReabastecimiento(){
        estadoActual.dirigirseAlAreaDeReabastecimiento();
    }
    public void dirigirseAlAreaDeConstruccion(){
        estadoActual.dirigirseAlAreaDeConstruccion();
    }
    public void reabastecer(){
        estadoActual.reabastecer();
    }
    public void construir(){
        estadoActual.construir();
    }
    public void suspenderse(){
        estadoActual.suspenderse();
    }
    
    public void desplegarMenuAcciones(){
        int i = 0;
        
        System.out.println("Digite el número de la opción y presione enter: ");
        System.out.println("1.- Activarse");
        System.out.println("2.- Caminar");
        System.out.println("3.- Dirigirse al area de reabastecimiento");
        System.out.println("4.- Dirigirse al area de construccion");
        System.out.println("5.- Reabastecer");
        System.out.println("6.- Construir");
        System.out.println("7.- Suspenderse");
        i = obtenerDigito(1, 7);
        
        switch (i) {
            case 1:
            activarse();
            break;
            case 2:
            caminar();
            break;
            case 3:
            dirigirseAlAreaDeReabastecimiento();
            break;
            case 4:
            dirigirseAlAreaDeConstruccion();
            break;
            case 5:
            reabastecer();
            break;
            case 6:
            construir();
            break;
            case 7:
            suspenderse();
            break;
            
            default:
            System.out.println("Opción incorrecta");
            desplegarMenuAcciones();
            
            
        }
    }
    private int obtenerDigito(int limiteInferior, int limiteSuperior){
        Scanner sc = new Scanner(System.in);
        int digitoObtenido = limiteSuperior + 1;
        String bufferCleaner = "";
        while(digitoObtenido < limiteInferior || digitoObtenido > limiteSuperior){
            if(sc.hasNextInt()) digitoObtenido = sc.nextInt();
            else bufferCleaner = sc.nextLine();
        }
    }
    public void desplegarMenuRecepcionOrden(){
        //FALTA
    }
}


