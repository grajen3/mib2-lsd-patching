/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.pool;

import de.esolutions.fw.util.commons.pool.ShortPool$Item;

public final class ShortPool {
    private ShortPool$Item[] items;
    private int count;
    protected int next;

    public ShortPool(short s) {
        this.items = new ShortPool$Item[s];
        this.fill();
        this.count = 0;
        this.next = 0;
    }

    private void fill() {
        for (short s = 0; s < this.items.length; s = (short)(s + 1)) {
            ShortPool$Item shortPool$Item;
            this.items[s] = shortPool$Item = new ShortPool$Item(s);
        }
    }

    public void clear() {
        for (int n = 0; n < this.items.length; n = (int)((short)(n + 1))) {
            this.items[n].setObject(null);
        }
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    private void setNext(int n) {
        this.next = ++n >= this.items.length ? 0 : n;
    }

    public short add(Object object) {
        short s = -1;
        boolean bl = false;
        int n = this.next;
        while (true) {
            ShortPool$Item shortPool$Item;
            if (!(shortPool$Item = this.items[n]).isUsed()) {
                s = shortPool$Item.getKey();
                shortPool$Item.setObject(object);
                ++this.count;
                break;
            }
            if (bl && n == this.next) break;
            if (++n < this.items.length) continue;
            n = 0;
            bl = true;
        }
        this.setNext(s);
        return s;
    }

    public Object remove(short s) {
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            ShortPool$Item shortPool$Item = this.items[i2];
            if (shortPool$Item.getKey() != s || !shortPool$Item.isUsed()) continue;
            Object object = shortPool$Item.getObject();
            shortPool$Item.setObject(null);
            --this.count;
            return object;
        }
        return null;
    }

    public Object getObject(short s) {
        return this.items[s].getObject();
    }

    public void setObject(short s, Object object) {
        this.items[s].setObject(object);
    }

    public short findObject(Object object) {
        for (int n = 0; n < this.items.length; n = (int)((short)(n + 1))) {
            ShortPool$Item shortPool$Item = this.items[n];
            if (shortPool$Item.getObject() != object) continue;
            return shortPool$Item.getKey();
        }
        return -1;
    }

    public short[] getUsedIDs() {
        if (this.count == 0) {
            return null;
        }
        short[] sArray = new short[this.count];
        int n = 0;
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            ShortPool$Item shortPool$Item = this.items[i2];
            if (!shortPool$Item.isUsed()) continue;
            sArray[n] = shortPool$Item.getKey();
            ++n;
        }
        return sArray;
    }

    public Object[] getUsedObjects() {
        if (this.count == 0) {
            return null;
        }
        Object[] objectArray = new Object[this.count];
        int n = 0;
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            ShortPool$Item shortPool$Item = this.items[i2];
            if (!shortPool$Item.isUsed()) continue;
            objectArray[n] = shortPool$Item.getObject();
            ++n;
        }
        return objectArray;
    }
}

