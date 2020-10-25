 public interface Estado{
    
    /**
     * Reasigna el método que se ejecutara automaticamente en el estado.
     * @param cambioAutomatico metodo a ejecutar automaticamente.
     */
    public void  cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico);
    /**
     * Solicita la accion de activarse al estado.
     */
    public void activarse();
    /**
    * Solicita la accion de caminar al estado.
    */
    public void caminar();
    /**
    * Solicita la accion de dirigirse al area de reabastecimiento al estado.
    */
    public void dirigirseAlAreaDeReabastecimiento();
    /**
     * Solicita la accion de dirigirse al area de construccion al estado.
    */
    public void dirigirseAlAreaDeConstruccion();
    /**
     * Solicita la accion de reabastecerse al estado.
     */
    public void reabastecer();
    /**
     * Solicita la accion de construir al estado.
     */
    public void construir();
    /**
     * Solicita la accion de construir a suspenderse.
     */
    public void suspenderse();
}





