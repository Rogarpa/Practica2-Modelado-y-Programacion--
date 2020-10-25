public class EstrategiaReabastecer implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    /**
    * Construye una ejecutor de metodo automatico y guarda el estado al cual se le pedira ejecutar el metodo automatico.
    * @param estadoAAplicarMetodoAutomatico estado a ejecutar metodo automatico.
    */
    public EstrategiaReabastecer(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    @Override
    public void ejecucionMetodoAutomatico(){
        estadoAAplicarMetodoAutomatico.reabastecer();
    }
}