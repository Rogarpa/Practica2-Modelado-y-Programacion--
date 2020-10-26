public abstract class Construccion{

    int Precio = 1000;

    /**
    *Metodo para generar el patron template.
    */
    public final void template(){
        prepTerreno();
        colocacionCimientos();
        construccionEsqueleto();
        electricPlumber();
        aislamiento();
        System.out.println("Costo total: $" + Precio);
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
