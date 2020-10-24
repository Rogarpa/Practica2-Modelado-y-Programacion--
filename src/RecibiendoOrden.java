public class RecibiendoOrden implements Estado{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public RecibiendoOrden(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Recibiendo Orden";
    }

    public void  cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    public void activarse(){
        System.out.println("No es posible activarse porque estas:" + NombreDelEstado);
        cambioAutomatico();
    }
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
            usuario.desplegarMenuAcciones();
        }
    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    public void construir(){
        System.out.println("No es posible construir porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    public void suspenderse(){
        System.out.println("Ya estas: suspendido");
        cambioAutomatico();
    }
    public void cambioAutomatico(){
        if(cambioAutomatico != null) cambioAutomatico.ejecucionMetodoAutomatico();
    }
}
