public class EstrategiaCaminar implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaCaminar(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(){
        estadoAAplicarMetodoAutomatico.caminar();
    }
}