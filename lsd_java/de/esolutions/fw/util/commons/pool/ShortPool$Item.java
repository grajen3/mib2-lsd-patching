/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.pool;

final class ShortPool$Item {
    private short key;
    private Object object;

    public ShortPool$Item(short s) {
        this.key = s;
        this.object = null;
    }

    public boolean isUsed() {
        return this.object != null;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public short getKey() {
        return this.key;
    }

    public Object getObject() {
        return this.object;
    }
}

