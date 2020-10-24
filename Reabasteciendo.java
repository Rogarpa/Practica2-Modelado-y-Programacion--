public class Reabasteciendo{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Reabastecer(Robor usuario){
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
        if(cambioAutomatico.getClass() != EstrategiaCaminar){
            System.out.println("No es posible caminar porque estas: " + NombreDelEstado);
            return;
        }else{
            System.out.println("Caminando");
            Estado siguiente = usuario.getcaminando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaDirigirseAlAreaDeConstruccion());
            usuario.desplegarMenuAcciones();
        }

    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque ya estás en ella");
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + NombreDelEstado);
        cambioAutomático();
    }
    public void reabastecer(){
        if(cambioAutomatico.getClass() != EstrategiaReabastecer){
            System.out.println("No es posible reabastecerse.");
            return;
        }else{
            System.out.println("Reabasteciendo");
            Estado siguiente = usuario.reabasteciendo();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaCaminar(siguiente));
            usuario.desplegarMenuAcciones();
        }
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
