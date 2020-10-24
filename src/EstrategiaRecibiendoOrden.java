public class EstrategiaActivarse implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaActivarse(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(){
        estadoAAplicarMetodoAutomatico.activarse();;
    }
}