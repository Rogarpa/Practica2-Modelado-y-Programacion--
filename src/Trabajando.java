public class Trabajando implements Estado{

    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;

/**
 * Construye un estado trabajando, instanciando su cadena para notificar y definiendo el Robot que lo usara. 
 * @param usuario robot que lo usara.
 */
    public Trabajando(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Trabajando";
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
        if(cambioAutomatico.getClass() != new EstrategiaCaminar(null).getClass()){
            System.out.println("No es posible caminar porque estas: " + NombreDelEstado);
            cambioAutomatico();
            return;
        }else{
            System.out.println("Caminando");
            Estado siguiente = usuario.getcaminando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaSuspenderse(siguiente));
            usuario.desplegarMenuAcciones();
        }
    }
    @Override
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque ya estás en ella");
    }
    @Override
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void construir(){
        if(cambioAutomatico.getClass() != new EstrategiaConstruir(null).getClass()){
            System.out.println("No es posible construir.");
            cambioAutomatico();
            return;
        }else{
            System.out.println("Construyendo");
            usuario.getcasa().template();
            Estado siguiente = usuario.gettrabajando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaCaminar(siguiente));
            usuario.desplegarMenuAcciones();
        }


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
    }
}
