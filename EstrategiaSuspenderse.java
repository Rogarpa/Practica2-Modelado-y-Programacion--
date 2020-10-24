public class EstrategiaSuspenderse implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaSuspenderse(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(Estado EstadoACambiarAutomaticamente){
        estadoAAplicarMetodoAutomatico.suspenderse();
    }
}