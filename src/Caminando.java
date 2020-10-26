public class Caminando implements Estado{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    
    /**
    * Construye un estado trabajando, instanciando su cadena para notificar y definiendo el Robot que lo usara. 
    * @param usuario robot que lo usara.
    */
    public Caminando(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Caminando";
        cambioAutomatico = null;
    }

    /**
    *Si existe un cambio automatico, ejecuta su metodo por defecto.
    */
    public void cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    @Override
    public void activarse(){
        System.out.println("No es posible activarse porque estas:" + NombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void caminar(){
        System.out.println("No es posible caminar porque ya lo estas haciendo.");
        cambioAutomatico();
    }
    @Override
    public void dirigirseAlAreaDeReabastecimiento(){

        if(cambioAutomatico.getClass() != new EstrategiaDirigirseAlAreaDeReabastecimiento(null).getClass()){
            System.out.println("No es posible dirigirse al area de reabastecimiento.");
            cambioAutomatico();
            return;
        }else {
            System.out.println("Dirigiendose al area de reabastecimiento");
            Estado siguienteEstado = usuario.getreabasteciendo();
            usuario.cambiarEstado(siguienteEstado);
            siguienteEstado.cambioAutomatico(new EstrategiaReabastecer(siguienteEstado));
            usuario.desplegarMenuAcciones();
        }
    }
    @Override
    public void dirigirseAlAreaDeConstruccion(){
        if(cambioAutomatico.getClass() != new EstrategiaDirigirseAlAreaDeConstruccion(null).getClass()){
            System.out.println("No es posible dirigirse al area de construccion porque debes ir al area de construccion");
            cambioAutomatico();
            return;
        }else{
            System.out.println("Dirigiendose al area de construccion");
            Estado siguienteEstado = usuario.gettrabajando();
            usuario.cambiarEstado(siguienteEstado);
            siguienteEstado.cambioAutomatico(new EstrategiaConstruir(siguienteEstado));
            usuario.desplegarMenuAcciones();
        }
    }
    @Override
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void construir(){
        System.out.println("No es posible construir porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void suspenderse(){
        if(cambioAutomatico.getClass() != new EstrategiaSuspenderse(null).getClass() ){
            System.out.println("No es posible suspenderse");
            cambioAutomatico();
            return;
        }else{
            System.out.println("Suspendiendose");
            Estado siguienteEstado = usuario.getsuspendido();
            usuario.cambiarEstado(siguienteEstado);
            siguienteEstado.cambioAutomatico(new EstrategiaActivarse(siguienteEstado));
            usuario.desplegarMenuAcciones();
        }

    }
    /**
    *Si existe un cambio automatico, ejecuta su metodo por defecto.
    */
    public void cambioAutomatico(){
        if(cambioAutomatico != null) cambioAutomatico.ejecucionMetodoAutomatico();
    }
}
