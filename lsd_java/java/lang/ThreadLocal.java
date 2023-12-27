/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class ThreadLocal {
    public Object get() {
        return Thread.currentThread().getThreadLocal(this);
    }

    protected Object initialValue() {
        return null;
    }

    public void set(Object object) {
        Thread.currentThread().setThreadLocal(this, object);
    }
}

