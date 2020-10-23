public abstract class Construccion{

    int Precio;

    /**
    *Metodo para generar el patrón template.
    */
    public final void template(){
        prepTerreno();
        colocacionCimientos();
        construccionEsqueleto();
        electricPlumber();
        aislamiento();
    }

    void prepTerreno(){
        System.out.println("Preparando el Terreno para la casa.Beep-bee-bee-boop-bee-doo-weep");

    }

    void colocacionCimientos(){
        System.out.println("Colocando los Cimientos de la casa.Beep-bee-bee-boop-bee-doo-weep");

    }

    void construccionEsqueleto(){
        System.out.println("Construyendo el esqueleto para la casa.Beep-bee-bee-boop-bee-doo-weep");
    }

    void electricPlumber(){
        System.out.println("Agregando la plomeria y la luz.Beep-bee-bee-boop-bee-doo-weep");

    }
    void aislamiento(){
        System.out.println("Agregando aislamiento para que no sientas frio <3 Beep-bee-bee-boop-bee-doo-weep");

    }
}
