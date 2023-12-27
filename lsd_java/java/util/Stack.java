/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack
extends Vector {
    private static final long serialVersionUID;

    public boolean empty() {
        return this.elementCount == 0;
    }

    public synchronized Object peek() {
        try {
            return this.elementData[this.elementCount - 1];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new EmptyStackException();
        }
    }

    public synchronized Object pop() {
        try {
            int n = this.elementCount - 1;
            Object object = this.elementData[n];
            this.removeElementAt(n);
            return object;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new EmptyStackException();
        }
    }

    public synchronized Object push(Object object) {
        this.addElement(object);
        return object;
    }

    public synchronized int search(Object object) {
        int n = this.lastIndexOf(object);
        if (n >= 0) {
            return this.elementCount - n;
        }
        return -1;
    }
}

