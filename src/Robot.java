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
        switch(getint("Digite el número de la opción y presione enter:","No es un numero valido.")){
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
            System.out.println("Opción incorrecta");
            desplegarMenuAcciones();
            break;
        }
        break;
    } while (dan==true);
    }
    private int obtenerDigito(int limiteInferior, int limiteSuperior, String mensajeError){
        Scanner sc = new Scanner(System.in);
        int digitoObtenido = limiteSuperior + 1;
        String bufferCleaner = "";
        while(digitoObtenido <= limiteInferior || digitoObtenido > limiteSuperior){
            if(sc.hasNextInt()) digitoObtenido = sc.nextInt();
            else {
                bufferCleaner = sc.nextLine();
                System.out.println(mensajeError);
            }
        }
        return digitoObtenido;
    }

    public int getint(String a, String b){
        int num=0;
        boolean c=true;
        Scanner scn=new Scanner(System.in);
        do{
            System.out.println(a);
            if(scn.hasNextInt()){
                num=scn.nextInt();
                c=false;
            }
            else{
                scn.next();
                System.out.println(b);
            }
        }while(c);
        return num;
    }

    public void desplegarMenuRecepcionOrden(){
        int m=0;
        boolean dani=true;
        String esqueleto="1 para el esqueleto de concreto y 2 para el esqueleto Reforzado.";
        String aislamiento="1 para el aislamiento de vidrio, 2 para aislamiento de madera,3 para aislamiento de concreto y 4 para aislamiento reforzado.";
        do {
            switch (getint(esqueleto,"No es un número válido.")) {
                case 1:
                switch (getint(aislamiento,"No es un número válido.")) {
                    case 1:
                    //casa=new EsqueletoConcretoAislamientoVidrio();
                    dani=false;
                    break;
                    case 2:
                    //casa=new EsqueletoConcretoAislamientoMadera();
                    dani=false;
                    break;
                    case 3:
                    //casa=new EsqueletoConcretoAislamientoConcreto();
                    dani=false;
                    break;
                    case 4:
                    //casa=new EsqueletoConcretoAislamientoReforzado();
                    dani=false;
                    break;
                    default:
                    System.out.println("Opción incorrecta");
                    desplegarMenuRecepcionOrden();
                    break;
                }
                break;
                case 2:
                switch (getint(aislamiento,"No es un número válido.")) {
                    case 1:
                    //casa=new EsqueletoReforzadoAislamientoVidrioEsqReforzado();
                    dani=false;
                    break;
                    case 2:
                    //casa=new EsqueletoReforzadoAislamientoMaderaEsqReforzado();
                    dani=false;
                    break;
                    case 3:
                    //casa=new EsqueletoReforzadoAislamientoConcretoEsqReforzado();
                    dani=false;
                    break;
                    case 4:
                    //casa=new EsqueletoReforzadoAislamientoReforzadoEsqReforzado();
                    dani=false;
                    break;
                    default:
                    System.out.println("Opción incorrecta");
                    desplegarMenuRecepcionOrden();
                    break;
                }
                break;
                default:
                System.out.println("Opción incorrecta");
                desplegarMenuRecepcionOrden();
                break;
            }

        } while (dani==true);

    }
}
