/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  
 */
package java.lang;

public class Object
extends  {
    protected native Object clone() {
    }

    public boolean equals(Object object) {
        return this == object;
    }

    protected void finalize() {
    }

    public final native Class getClass() {
    }

    public native int hashCode() {
    }

    public final native void notify() {
    }

    public final native void notifyAll() {
    }

    public String toString() {
        return new StringBuffer(String.valueOf(this.getClass().getName())).append("@").append(Integer.toHexString(this.hashCode())).toString();
    }

    public final void wait() {
        this.wait(0L, 0);
    }

    public final void wait(long l) {
        this.wait(l, 0);
    }

    public final native void wait(long l, int n) {
    }

    private Object newInstancePrototype(Class clazz) {
        return null;
    }
}

