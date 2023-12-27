/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.buffer.ASLListCache;
import de.vw.mib.asl.internal.list.buffer.SoftRefArrayTreeCache;

public class ASLListItemSoftCacheImpl
implements ASLListElementCache {
    private final ASLListCache cache = new SoftRefArrayTreeCache();
    private int listSize;

    @Override
    public void clear() {
        this.cache.clear();
        this.listSize = 0;
    }

    @Override
    public void clearItems(int n, int n2) {
        this.cache.clearItems(n, n2);
    }

    @Override
    public Object getListItem(int n, Object object) {
        if (n >= 0 && n < this.listSize) {
            Object object2 = this.cache.getItem(n);
            return null != object2 ? object2 : object;
        }
        return null;
    }

    @Override
    public boolean getListItems(int n, Object[] objectArray, int n2, Object object) {
        boolean bl = this.cache.getItems(n, objectArray, n2);
        if (!bl || n + n2 > this.listSize || n < 0) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (n + i2 >= this.listSize || n + i2 < 0) {
                    objectArray[i2] = null;
                    continue;
                }
                if (objectArray[i2] != null) continue;
                objectArray[i2] = object;
            }
        }
        return !bl;
    }

    @Override
    public void setListSize(int n) {
        if (n < this.listSize) {
            this.cache.cutToSize(n);
        }
        this.listSize = n;
    }

    @Override
    public void insertListItems(int n, Object[] objectArray) {
        this.cache.insertItems(n, objectArray);
        this.listSize = Math.max(this.listSize, n) + objectArray.length;
    }

    @Override
    public void removeListItems(int n, int n2) {
        this.cache.removeItems(n, n2);
        if (n < this.listSize && 0 < n2) {
            this.listSize = Math.max(this.listSize - n2, n);
        }
    }

    @Override
    public void updateListItems(int n, Object[] objectArray) {
        this.updateListItems(n, objectArray, objectArray.length);
    }

    @Override
    public void updateListItems(int n, Object[] objectArray, int n2) {
        int n3 = Math.min(objectArray.length, n2);
        if (0 <= n3) {
            this.cache.setItems(n, objectArray, n3);
            this.listSize = Math.max(this.listSize, n + n3);
        }
    }

    int getListSize() {
        return this.listSize;
    }
}

