public class Suspendido{

    protected Robot usuario;
    protected String nombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Suspendido(Robot usuario){
        this.usuario = usuario;
        nombreDelEstado = "Suspendido"
    }

    public cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    public void activarse(){
        System.out.println("Activándose" + nombreDelEstado);
        Estado siguienteEstado = usuario.getrecibiendoOrden();
        usuario.cambiarEstado(siguienteEstado);
        siguienteEstado.cambioAutomatico(new EstrategiaCaminar(siguienteEstado));
        usuario.desplegarMenuRecepcionOrden();
        usuario.desplegarMenuAcciones();
    }
    public void caminar(){
        System.out.println("No es posible caminar porque estas: " + nombreDelEstado);
        cambioAutomático();
    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque estas: " + nombreDelEstado);
        cambioAutomático();
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + nombreDelEstado);
        cambioAutomático();
    }
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + nombreDelEstado);
        cambioAutomático();
    }
    public void construir(){
        System.out.println("No es posible construir porque estas: " + nombreDelEstado);
        cambioAutomático();
    }
    public void suspenderse(){
        System.out.println("Ya estas: suspendido");
        cambioAutomático();
    }
    protected void cambioAutomatico(){
        EstrategiaCambioAutomatico.ejecucionMetodoAutomatico();
    }
}
