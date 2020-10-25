public class Trabajando implements Estado{
    
    protected Robot usuario;
    protected String NombreDelEstado;
    protected EstrategiaCambioAutomatico cambioAutomatico;
    

    public Trabajando(Robot usuario){
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
        if(cambioAutomatico.getclass() != new EstrategiaCaminar(null).getClass()){
            System.out.println("No es posible caminar porque estas: " + NombreDelEstado);
            cambioAutomatico();
            return;
        }else{
            System.out.println("Caminando");
            Estado siguiente = usuario.getcaminando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaSuspenderse(siguiente));
            usuario.desplegarMenuAcciones();
        }
    }
    public void dirigirseAlAreaDeReabastecimiento(){
        System.out.println("No es posible dirigirse al area de trabajo porque ya estás en ella");
    }
    public void dirigirseAlAreaDeConstruccion(){
        System.out.println("No es posible dirigirse al area de construccion porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    public void reabastecer(){
        System.out.println("No es posible reabastecerse porque estas: " + NombreDelEstado);
        cambioAutomatico();
    }
    public void construir(){
        if(cambioAutomatico.getClass() != new EstrategiaConstruir(null).getClass()){
            System.out.println("No es posible construir.");
            cambioAutomatico();
            return;
        }else{
            System.out.println("Construyendo");
            usuario.getcasa().template();
            Estado siguiente = usuario.gettrabajando();
            usuario.cambiarEstado(siguiente);
            siguiente.cambioAutomatico(new EstrategiaCaminar(siguiente));
            usuario.desplegarMenuAcciones();
        }

        
    }
    public void suspenderse(){
        System.out.println("Ya estas: suspendido");
        cambioAutomatico();
    }
    public void cambioAutomatico(){
        if(cambioAutomatico != null) cambioAutomatico.ejecucionMetodoAutomatico();
    }
}
