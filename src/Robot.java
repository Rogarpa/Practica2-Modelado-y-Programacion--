import java.util.Scanner;
public class Robot{
    protected Estado estadoActual;

    protected Estado suspendido;
    protected Estado recibiendoOrden;
    protected Estado caminando;
    protected Estado reabasteciendo;
    protected Estado trabajando;

    protected Construccion casa;
    
    /**
     * Constructor de robot encargado de inicializar todas las variables de clase.
     */

    public Robot(){
        this.estadoActual = estadoActual;
        suspendido = new Suspendido(this);
        recibiendoOrden = new RecibiendoOrden(this);
        caminando = new Caminando(this);
        reabasteciendo = new Reabasteciendo(this);
        trabajando = new Trabajando(this);
    }
    
    /**
     * Recibe un estado a configurar como estado temporal.
     * @param estadoActual estado a reemplazar.
     */
    public void cambiarEstado(Estado estadoActual){
        this.estadoActual = estadoActual;
    }
    
    public Estado getsuspendido(){
        return suspendido;
    }
    /**
     * Regresa el estado construido con respecto a esta clase.
     * @return estado recibiendo orden.
     */
    public Estado getrecibiendoOrden(){
        return recibiendoOrden;
    }
    /**
     * Regresa el estado construido con respecto a esta clase.
     * @return estado caminando.
     */
    public Estado getcaminando(){
        return caminando;
    }
    /**
     * Regresa el estado construido con respecto a esta clase.
     * @return estado reabasteciendo.
     */
    public Estado getreabasteciendo(){
        return reabasteciendo;
    }
    /**
     * Regresa el estado construido con respecto a esta clase.
     * @return estado trabajando.
     */
    public Estado gettrabajando(){
        return trabajando;
    }
    public Construccion getcasa(){
        return casa;
    }
    /**
     * Solicita al estado actual del Robot, activarse.
     */
    public void activarse(){
        estadoActual.activarse();
    }
    /**
     * Solicita al estado actual del Robot, caminar.
     */
    public void caminar(){
        estadoActual.caminar();
    }
    /**
     * Solicita al estado actual del Robot, dirigirse al area de reabastecimiento.
     */
    public void dirigirseAlAreaDeReabastecimiento(){
        estadoActual.dirigirseAlAreaDeReabastecimiento();
    }
    /**
     * Solicita al estado actual del Robot, dirigirse al area de construccion.
     */
    public void dirigirseAlAreaDeConstruccion(){
        estadoActual.dirigirseAlAreaDeConstruccion();
    }
    /**
     * Solicita al estado actual del Robot, reabastecerse.
     */
    public void reabastecer(){
        estadoActual.reabastecer();
    }
    /**
     * Solicita al estado actual del Robot, construir el pedido almacenado en casa.
     */
    public void construir(){
        estadoActual.construir();
    }
    /**
     * Solicita al estado actual del Robot, suspenderse.
     */
    public void suspenderse(){
        estadoActual.suspenderse();
    }
    /**
     * Despliega un menu de acciones posibles a solicitar a todos los estados.
     */

    public void desplegarMenuAcciones(){
        int i = 0;
        boolean dan=true;
        do {
            System.out.println("0.-Terminar menu");
            System.out.println("1.- Activarse");
            System.out.println("2.- Caminar");
            System.out.println("3.- Dirigirse al area de reabastecimiento");
            System.out.println("4.- Dirigirse al area de construccion");
            System.out.println("5.- Reabastecer");
            System.out.println("6.- Construir");
            System.out.println("7.- Suspenderse");
            switch(getint("Digite el numero de la opcion y presione enter:","No es un numero valido.")){
                case 0:
                dan=false;
                break;
                case 1:
                activarse();
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
                System.out.println("Opcion incorrecta");
                dan=true;
                break;
            }
        } while (dan==true);
    }
    /**
     * Imprime una indicacion y devuelve la entrada estandar hasta que esta es capaz de ser guardada en un entero, de lo contrario imprime un mensaje de error y la indicacion de nuevo hasta que es asi.
     * @param indicacion el mensaje correspondiente a la indicacion.
     * @param error el mensaje de error.
     * @return el unico digito obtenido de la entrada estandar.
     */
    public int getint(String indicacion, String error){
        int num=0;
        boolean c=true;
        Scanner scn=new Scanner(System.in);
        do{
            System.out.println(indicacion);
            if(scn.hasNextInt()){
                num=scn.nextInt();
                c=false;
            }
            else{
                scn.next();
                System.out.println(error);
            }
        }while(c);
        return num;
    }
    /**
     * Despliega un menu para recibir la orden entre las ordenes disponibles para construir.
     */

    public void desplegarMenuRecepcionOrden(){
        int m=0;
        boolean dani=true;
        String esqueleto="Digite el esqueleto de su preferencia y presione enter:\n 1.-Esqueleto de Concreto \n 2.- Esqueleto Reforzado.";
        String aislamiento="Digite el aislamiento de su preferencia y presione enter \n 1.-Aislamiento de vidrio \n 2.- Aislamiento de madera \n 3 Aislamiento de concreto \n 4.-Aislamiento reforzado.";

        do {
            switch (getint(esqueleto,"No es un numero valido.")) {
                case 1:
                switch (getint(aislamiento,"No es un numero valido.")) {
                    case 1:
                    casa=new AislamientoVidrio();
                    dani=false;
                    break;
                    case 2:
                    casa=new AislamientoMadera();
                    dani=false;
                    break;
                    case 3:
                    casa=new AislamientoMadera();
                    dani=false;
                    break;
                    case 4:
                    casa=new AislamientoReforzado();
                    dani=false;
                    break;
                    default:
                    System.out.println("Opcion incorrecta");
                    desplegarMenuRecepcionOrden();
                    dani=true;
                    break;
                }
                break;
                case 2:
                switch (getint(aislamiento,"No es un numero valido.")) {
                    case 1:
                    casa=new AislamientoVidrioEsqReforzado();
                    dani=false;
                    break;
                    case 2:
                    casa=new AislamientoMaderaEsqReforzado();
                    dani=false;
                    break;
                    case 3:
                    casa=new AislamientoMaderaEsqReforzado();
                    dani=false;
                    break;
                    case 4:
                    casa=new AislamientoReforzadoEsqReforzado();
                    dani=false;
                    break;
                    default:
                    System.out.println("Opcion incorrecta");
                    desplegarMenuRecepcionOrden();
                    dani=true;
                    break;
                }
                break;
                default:
                System.out.println("Opcion incorrecta");
                desplegarMenuRecepcionOrden();
                dani = true;
                break;
            }

        } while (dani==true);

    }
}
