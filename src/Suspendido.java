public class Suspendido implements Estado{

    protected Robot usuario;
    protected String nombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    
    /**
    * Construye un estado trabajando, instanciando su cadena para notificar y definiendo el Robot que lo usara. 
    * @param usuario robot que lo usara.
    */
    public Suspendido(Robot usuario){
        this.usuario = usuario;
        nombreDelEstado = "Suspendido";
        cambioAutomatico = new EstrategiaActivarse(this);
    }

    /**
    *Si existe un cambio automatico, ejecuta su metodo por defecto.
    */
    public void cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    @Override
    public void activarse(){
        if(cambioAutomatico.getClass() != new EstrategiaActivarse(null).getClass()){
            System.out.println("No es posible activarse");
            cambioAutomatico();
            return;
        }else{
        System.out.println("Activandose" );
        System.out.println("//////////////////////////////////////////////////Bienvenido al servicio robotizado de construccion de casas//////////////////////////////////////////////////");
        Estado siguienteEstado = usuario.getrecibiendoOrden();
        usuario.cambiarEstado(siguienteEstado);
        siguienteEstado.cambioAutomatico(new EstrategiaCaminar(siguienteEstado));
        usuario.desplegarMenuRecepcionOrden();
        usuario.getcasa().template();
        usuario.desplegarMenuAcciones();
        }
    }
    @Override
    public void caminar(){
        System.out.println("No es posible caminar porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void construir(){
        System.out.println("No es posible construir porque estas: " + nombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void suspenderse(){
        System.out.println("Ya estas: suspendido");
        cambioAutomatico();
    }
    /**
    *Si existe un cambio automatico, ejecuta su metodo por defecto.
    */
    public void cambioAutomatico(){
        if(cambioAutomatico != null) cambioAutomatico.ejecucionMetodoAutomatico();
    }}
