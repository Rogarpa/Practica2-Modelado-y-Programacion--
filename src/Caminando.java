public class Caminando implements Estado{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Caminando(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Caminando";
        cambioAutomatico = null;
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
        cambioAutomatico();
    }
    public void dirigirseAlAreaDeReabastecimiento(){

        if(cambioAutomatico.getClass() != new EstrategiaDirigirseAlAreaDeReabastecimiento(null).getClass()){
            System.out.println("No es posible dirigirse al area de reabastecimiento.");
            cambioAutomatico();
            return;
        }else {
            Estado siguienteEstado = usuario.getreabasteciendo();
            usuario.cambiarEstado(siguienteEstado);
            siguienteEstado.cambioAutomatico(new EstrategiaCaminar(siguienteEstado));
            usuario.desplegarMenuAcciones();
        }
    }
    public void dirigirseAlAreaDeConstruccion(){
        if(cambioAutomatico.getClass() != new EstrategiaDirigirseAlAreaDeConstruccion(null).getClass()){
            System.out.println("No es posible dirigirse al area de construccion porque debes ir al area de construccion");
            cambioAutomatico();
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
