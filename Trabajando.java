public class Trabajando{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Reabastecer(Robot usuario){
        this.usuario = usuario;
        NombreDelEstado = "Trabajando";
    }

    public void cambioAutomatico(EstrategiaCambioAutomatico cambioAutomatico){
        this.cambioAutomatico = cambioAutomatico;
    }

    public void activarse(){
        System.out.println("No es posible activarse porque estas:" + NombreDelEstado);
        cambioAutomatico();
    }
    public void caminar(){
        if(cambioAutomatico.getClass() != EstrategiaCaminar){
            System.out.println("No es posible caminar porque estas: " + NombreDelEstado);
            return;
        }else{
            System.out.println("Caminando");
            Estado siguiente = usuario.getcaminando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaSuspenderse());
            usuario.desplegarMenuAcciones();
        }
    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque ya estás en ella");
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + NombreDelEstado);
        cambioAutomático();
    }
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + NombreDelEstado);
        cambioAutomático();
    }
    public void construir(){
        if(cambioAutomatico.getClass() != construir()){
            System.out.println("No es posible construir.");
            return;
        }else{
            System.out.println("Construyendo");
            //FALTA TU METODOS usuario.getcasa();
            Estado siguiente = usuario.gettrabajando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaCaminar(siguiente));
            usuario.desplegarMenuAcciones();
        }

        
    }
    public void suspenderse(){
        System.out.println("Ya estas: suspendido");
        cambioAutomático();
    }
    public void cambioAutomatico(){
        if(EstrategiaCambioAutomatico != null)EstrategiaCambioAutomatico.ejecucionMetodoAutomatico();
    }
}
