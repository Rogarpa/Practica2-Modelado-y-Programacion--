public class RecibiendoOrden implements Estado{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    
    /**
    * Construye un estado trabajando, instanciando su cadena para notificar y definiendo el Robot que lo usara. 
    * @param usuario robot que lo usara.
    */
    public RecibiendoOrden(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Recibiendo Orden";
    }

    @Override
    public void  cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
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
            System.out.println("No es posible caminar");
            cambioAutomatico();
            return;
        }else{
            System.out.println("Caminando");
            Estado siguienteEstado = usuario.getcaminando();
            usuario.cambiarEstado(siguienteEstado);
            siguienteEstado.cambioAutomatico(new EstrategiaDirigirseAlAreaDeReabastecimiento(siguienteEstado));
            
        }
    }
    @Override
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque estas: " + NombreDelEstado);
        cambioAutomatico();
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
        System.out.println("No es posible construir porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    @Override
    public void suspenderse(){
        System.out.println("No es posible suspenderse");
        cambioAutomatico();
    }
    /**
    *Si existe un cambio automatico, ejecuta su metodo por defecto.
    */
    public void cambioAutomatico(){
        if(cambioAutomatico != null) cambioAutomatico.ejecucionMetodoAutomatico();
    }
}
