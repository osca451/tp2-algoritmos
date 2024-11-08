import java.util.ArrayList;
import java.util.Arrays;
public class ColaPrioridadArray<T> implements ColaPrioridad<T> {
    private ArrayList <Elemento<T>> lista;
    //clase para crear elemento
private class Elemento<T>
{
    T elem;
    int prioridad;
    public Elemento(T elem, int prioridad)
    {
        this.elem = elem;
        this.prioridad = prioridad;
    }
}
    
@SuppressWarnings("unchecked")
public ColaPrioridadArray() {
    lista = new ArrayList<>();
}
    
@Override
public void insertar(T elem, int prioridad) { 
    Elemento<T> nuevoElemento = new Elemento<>(elem, prioridad);
    if (estaVacia()) {
        lista.add(0, nuevoElemento);
    } else {
        if (prioridad == 5) {
            lista.add(0, nuevoElemento);
        } else {
            int i = 0;
            while (i < lista.size() && ((Elemento<T>) 
            lista.get(i)).prioridad <= prioridad) {
                i++;
            }
            lista.add(i, nuevoElemento);
        }
    }
}

@Override
public T eliminar() {
    if(estaVacia())
    {
        return null;
    }
    else
    {
        T item;
        item = lista.get(0).elem;
        lista.remove(0);
        return item; 
    }
}

@Override
public T observar() {
    if(estaVacia())
    {
        return null;
    }
    else
    {
        T[] arreglo = (T[]) new Object[1];
        arreglo[0] = (T) lista.get(0);
        return arreglo[0];  
    } 
}

@Override
public boolean estaVacia() {
        if(lista.size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
}

@Override
    public int tamanio() {
    return lista.size();
    }
}
