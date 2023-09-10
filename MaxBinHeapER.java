package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {

    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        Patient p = new Patient(value, priority);
        _heap.add(p);
        bubbleUp(p);
    }

    // TODO: enqueue
    public void enqueue(V value) {
        Patient p = new Patient(value);
        _heap.add(p);
        bubbleUp(p);
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        if (_heap.size() > 0){
            V highest = _heap.get(0).getValue();
            _heap.set(0, _heap.get(_heap.size() - 1));
            _heap.remove(_heap.size() - 1);
            if (_heap.size() > 1){
                bubbleDown(_heap.get(0));
            }
            return highest;
        }
        return null;
    }

    public void bubbleUp(Patient p) {
        int index = _heap.indexOf(p);
        int parent = (int) Math.floor((index - 1) / 2);
        while(parent > -1 && parent != index && _heap.size() > 1 && p.getPriority().compareTo(_heap.get(parent).getPriority()) > 0){
            _heap.set(index, _heap.get(parent));
            _heap.set(parent, p);
            index = parent;
            parent = (int) Math.floor((index - 1) / 2);
        }
    }

    public void bubbleDown(Prioritized<V, P> p) {
        int index = _heap.indexOf(p);
        int lChild = (2*index) + 1;
        int rChild = (2*index) + 2;
        int biggestChild = 0;
        if(rChild >= _heap.size()){
            biggestChild = lChild;
        }
        else if (_heap.get(lChild).getPriority().compareTo(_heap.get(rChild).getPriority()) > 0){
            biggestChild = lChild;
        }
        else{
            biggestChild = rChild;
        }
        while(lChild < _heap.size() && lChild != index && rChild != index && _heap.size() > 1 && p.getPriority().compareTo(_heap.get(biggestChild).getPriority()) < 0){
            _heap.set(index, _heap.get(biggestChild));
            _heap.set(biggestChild, p);
            index = biggestChild;
            lChild = (2*index) + 1;
            rChild = (2*index) + 2;
            if(rChild >= _heap.size()){
                biggestChild = lChild;
            }
            else if (_heap.get(lChild).getPriority().compareTo(_heap.get(rChild).getPriority()) > 0){
                biggestChild = lChild;
            }
            else{
                biggestChild = rChild;
            }
        }
    }

    // TODO: getMax
    @Override
    public V getMax() {
        if (_heap.size() > 0){
            return _heap.get(0).getValue();
        }
        return null;
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }






}
