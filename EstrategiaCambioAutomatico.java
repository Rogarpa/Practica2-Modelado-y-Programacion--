public interface EstrategiaCambioAutomatico{
    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaCambioAutomatico(Estado estadoAAplicarMetodoAutomatico);
    
    public void ejecucionMetodoAutomatico(Estado EstadoACambiarAutomaticamente);
}