public class Arista<DA,D> {
    private int ID;
    private DA anotacion;
    Nodo<D> origen;
    Nodo<D> destino;
    public Arista(Nodo<D> origen,Nodo<D> destino,DA anotacion,int ID) {
        setOrigen(origen);
        setDestino(destino);
        origen.salida.add(this);
        destino.entrada.add(this);
        this.ID = ID;
        this.anotacion = anotacion;

    }

    boolean setOrigen(Nodo<D> origen) {
        if (origen == null) {
            this.origen = origen;
            return true;
        }else {
            return false;
        }
    }
    boolean setDestino(Nodo<D> destino) {
        if (destino == null) {
            this.destino = destino;
            return true;
        }else {
            return false;
        }
    }
    boolean setAnotacion(DA anotacion) {
        this.anotacion = anotacion;
        return true;
    }
    DA getAnotacion() {
        return this.anotacion;
    }
}
