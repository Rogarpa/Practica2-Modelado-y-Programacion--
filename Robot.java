public class Robot{
    protected Estado estadoActual;

    protected Estado suspendido;
    protected Estado recibiendoOrden;
    protected Estado caminando;
    protected Estado reabasteciendo;
    protected Estado trabajando;
    protected Estado orden;

    protected Construccion casa;

    public Robot(Estado estadoInicial){
        this.estadoActual = estadoInicial;
    }

    public void cambiarEstado(Estado estadoActual){
        this.estadoActual = estadoActual;
    }

    public Estado getsuspendido(){
        return suspendido;
    }
    public Estado getrecibiendoOrden(){
        return recibiendoOrden;
    }
    public Estado getcaminando(){
        return caminando;
    }
    public Estado getreabasteciendo(){
        return reabasteciendo;
    }
    public Estado gettrabajando(){
        return trabajando;
    }
    public Estado getorden(){
        return orden;
    }

    public Construccion getcasa(){
        return casa;
    }

    public Estado activarse(){
        estadoactual.activarse();
    }
    public Estado caminar(){
        estadoactual.caminar();
    }
    public Estado dirigirseAlAreaDeReabastecimiento(){
        estadoactual.dirigirseAlAreaDeReabastecimiento();
    }
    public void dirigirseAlAreaDeConstruccion(){
        estadoactual.dirigirseAlAreaDeConstruccion();
    }
    public void reabastecer(){
        estadoactual.reabastecer();
    }
    public void construir(){
        estadoactual.construir();
    }
    public void suspenderse(){
        estadoactual.suspenderse();
    }
    public void desplegarMenuAcciones(){
        //FALTA
    }
    public void desplegarMenuRecepcionOrden(){
        //FALTA
    }
}


