public class EstrategiaDirigirseAlAreaDeConstruccion implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaDirigirseAlAreaDeConstruccion(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(Estado EstadoACambiarAutomaticamente){
        estadoAAplicarMetodoAutomatico.dirigirseAlAreaDeConstruccion();
    }
}