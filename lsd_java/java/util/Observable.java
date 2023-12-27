/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Observer;
import java.util.Vector;

public class Observable {
    final Vector observers = new Vector();
    boolean changed = false;

    public synchronized void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!this.observers.contains(observer)) {
            this.observers.addElement(observer);
        }
    }

    protected synchronized void clearChanged() {
        this.changed = false;
    }

    public synchronized int countObservers() {
        return this.observers.size();
    }

    public synchronized void deleteObserver(Observer observer) {
        this.observers.removeElement(observer);
    }

    public synchronized void deleteObservers() {
        this.observers.setSize(0);
    }

    public synchronized boolean hasChanged() {
        return this.changed;
    }

    public void notifyObservers() {
        this.notifyObservers(null);
    }

    public void notifyObservers(Object object) {
        if (this.changed) {
            Vector vector = (Vector)this.observers.clone();
            int n = vector.size();
            int n2 = 0;
            while (n2 < n) {
                ((Observer)vector.elementAt(n2)).update(this, object);
                ++n2;
            }
            this.clearChanged();
        }
    }

    protected synchronized void setChanged() {
        this.changed = true;
    }
}

