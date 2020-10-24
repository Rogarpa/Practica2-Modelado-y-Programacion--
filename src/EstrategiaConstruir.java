public class EstrategiaConstruir implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaConstruir(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(){
        estadoAAplicarMetodoAutomatico.construir();
    }
}