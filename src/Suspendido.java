public class Suspendido implements Estado{

    protected Robot usuario;
    protected String nombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Suspendido(Robot usuario){
        this.usuario = usuario;
        nombreDelEstado = "Suspendido";
        cambioAutomatico = new EstrategiaActivarse(this);
    }

    public void  cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    public void activarse(){
        System.out.println("Activándose" );
        Estado siguienteEstado = usuario.getrecibiendoOrden();
        usuario.cambiarEstado(siguienteEstado);
        siguienteEstado.cambioAutomatico(new EstrategiaCaminar(siguienteEstado));
        usuario.desplegarMenuRecepcionOrden();
        usuario.desplegarMenuAcciones();
    }
    public void caminar(){
        System.out.println("No es posible caminar porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    public void construir(){
        System.out.println("No es posible construir porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    public void suspenderse(){
        System.out.println("Ya estas: suspendido");
        cambioAutomatico();
    }
    public void cambioAutomatico(){
        if(cambioAutomatico != null) cambioAutomatico.ejecucionMetodoAutomatico();
    }}
