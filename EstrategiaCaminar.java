public class EstrategiaCaminar implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaCambioAutomatico(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(Estado EstadoACambiarAutomaticamente){
        estadoAAplicarMetodoAutomatico.caminar();
    }
}