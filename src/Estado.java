public interface Estado{
 
    public void  cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico);
    public void activarse();
    public void caminar();
    public void dirigirseAlAreaDeReabastecimiento();
    public void dirigirseAlAreaDeConstruccion();
    public void reabastecer();
    public void construir();
    public void suspenderse();
}





