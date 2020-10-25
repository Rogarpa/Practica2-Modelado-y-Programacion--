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
                break;
            }
        } while (dan==true);
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
        String esqueleto="Digite el esqueleto de su preferencia y presione enter:\n 1.-Esqueleto de Concreto \n 2.- Esqueleto Reforzado.";
        String aislamiento="Digite el aislamiento de su preferencia y presione enter \n 1.-Aislamiento de vidrio \n 2.- Aislamiento de madera \n 3 Aislamiento de concreto \n 4.-Aislamiento reforzado.";

        do {
            dani = false;
            switch (getint(esqueleto,"No es un número válido.")) {
                case 1:
                switch (getint(aislamiento,"No es un número válido.")) {
                    case 1:
                    casa=new AislamientoVidrio();
                    break;
                    case 2:
                    casa=new AislamientoMadera();
                    break;
                    case 3:
                    casa=new AislamientoMadera();
                    break;
                    case 4:
                    casa=new AislamientoReforzado();
                    break;
                    default:
                    System.out.println("Opción incorrecta");
                    desplegarMenuRecepcionOrden();
                    dani = true;
                    break;
                }
                break;
                case 2:
                switch (getint(aislamiento,"No es un número válido.")) {
                    case 1:
                    casa=new AislamientoVidrioEsqReforzado();
                    break;
                    case 2:
                    casa=new AislamientoMaderaEsqReforzado();
                    break;
                    case 3:
                    casa=new AislamientoMaderaEsqReforzado();
                    break;
                    case 4:
                    casa=new AislamientoReforzadoEsqReforzado();
                    break;
                    default:
                    System.out.println("Opción incorrecta");
                    desplegarMenuRecepcionOrden();
                    dani = true;
                    break;
                }
                break;
                default:
                System.out.println("Opción incorrecta");
                desplegarMenuRecepcionOrden();
                dani = true;
                break;
            }

        } while (dani==true);

    }
}
