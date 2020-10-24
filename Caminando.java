public class Caminando{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Caminando(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Caminando";
    }

    public void cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    public void activarse(){
        System.out.println("No es posible activarse porque estas:" + NombreDelEstado);
        cambioAutomatico();
    }
    public void caminar(){
        System.out.println("No es posible caminar porque ya lo estás haciendo.");
        cambioAutomático();
    }
    public void dirigirseAlAreaDeReabastecimiento(){

        if(cambioAutomatico.getClass() != EstrategiaDirigirseAlAreaDeReabastecimiento){
            System.out.println("No es posible dirigirse al area de reabastecimiento.");
            return;
        }else {
            Estado siguienteEstado = usuario.getreabasteciendo();
            usuario.cambiarEstado(siguienteEstado);
            siguienteEstado.cambioAutomatico(new EstrategiaCaminar(siguienteEstado));
            usuario.desplegarMenuAcciones();
        }
    }
    public void dirigirseAlAreaDeConstruccion(){
        if(cambioAutomatico.getClass() != EstrategiaDirigirseAlAreaDeConstruccion){
            System.out.println("No es posible dirigirse al area de construccion porque debes ir al area de construccion");
            return;
        }else{
            Estado siguienteEstado = usuario.gettrabajando();
            usuario.cambiarEstado(siguienteEstado);
            siguienteEstado.cambioAutomatico(new EstrategiaCaminar(siguienteEstado));
            usuario.desplegarMenuAcciones();
        }
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
        if(EstrategiaCambioAutomatico != null) EstrategiaCambioAutomatico.ejecucionMetodoAutomatico();
    }
}
