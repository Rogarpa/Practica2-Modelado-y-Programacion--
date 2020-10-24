public class RecibiendoOrden{
    
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
        System.out.println("Caminando");
        Estado siguienteEstado = usuario.getcaminando();
        usuario.cambiarEstado(siguienteEstado);
        siguienteEstado.cambioAutomatico(new EstrategiaDirigirseAlAreaDeReabastecimiento(siguienteEstado));
        usuario.desplegarMenuAcciones();
    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque estas: " + NombreDelEstado);
        cambioAutomático();
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + NombreDelEstado);
        cambioAutomático();
    }
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + NombreDelEstado);
        cambioAutomático();
    }
    public void construir(){
        System.out.println("No es posible construir porque estas: " + NombreDelEstado);
        cambioAutomático();
    }
    public void suspenderse(){
        System.out.println("Ya estas: suspendido");
        cambioAutomático();
    }
    public void cambioAutomatico(){
        if(EstrategiaCambioAutomatico != null)EstrategiaCambioAutomatico.ejecucionMetodoAutomatico();
    }
}
