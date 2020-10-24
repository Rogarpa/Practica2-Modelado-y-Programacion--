public class EstrategiaDirigirseAlAreaDeReabastecimiento implements EstrategiaCambioAutomatico{

    protected Estado estadoAAplicarMetodoAutomatico;

    public EstrategiaDirigirseAlAreaDeReabastecimiento(Estado estadoAAplicarMetodoAutomatico){
        this.estadoAAplicarMetodoAutomatico = estadoAAplicarMetodoAutomatico;
    }
    
    public void ejecucionMetodoAutomatico(){
        estadoAAplicarMetodoAutomatico.dirigirseAlAreaDeReabastecimiento();
    }
}