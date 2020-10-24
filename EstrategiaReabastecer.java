public class EstrategiaReabastecer implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaReabastecer(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(Estado EstadoACambiarAutomaticamente){
        estadoAAplicarMetodoAutomatico.reabastecer();
    }
}