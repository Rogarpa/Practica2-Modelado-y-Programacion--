public class EstrategiaSuspenderse implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    /**
    * Construye una ejecutor de metodo automatico y guarda el estado al cual se le pedira ejecutar el metodo automatico.
    * @param estadoAAplicarMetodoAutomatico estado a ejecutar metodo automatico.
    */
    public EstrategiaSuspenderse(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    @Override
    public void ejecucionMetodoAutomatico(){
        estadoAAplicarMetodoAutomatico.suspenderse();
    }
}