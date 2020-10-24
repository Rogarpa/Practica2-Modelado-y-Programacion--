public class Reabasteciendo implements Estado{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Reabasteciendo(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Reabasteciendo";
    }

    public void cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    public void activarse(){
        System.out.println("No es posible activarse porque estas:" + NombreDelEstado);
        cambioAutomatico();
    }
    public void caminar(){
        if(cambioAutomatico.getClass() != new EstrategiaCaminar(null).getClass()){
            System.out.println("No es posible caminar porque estas: " + NombreDelEstado);
            cambioAutomatico();
            return;
        }else{
            System.out.println("Caminando");
            Estado siguiente = usuario.getcaminando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaDirigirseAlAreaDeConstruccion(siguiente));
            usuario.desplegarMenuAcciones();
        }

    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque ya estás en ella");
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    public void reabastecer(){
        if(cambioAutomatico.getClass() != new EstrategiaReabastecer(null).getClass()){
            System.out.println("No es posible reabastecerse.");
            cambioAutomatico();
            return;
        }else{
            System.out.println("Reabasteciendo");
            Estado siguiente = usuario.getreabasteciendo();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaCaminar(siguiente));
            usuario.desplegarMenuAcciones();
        }
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
