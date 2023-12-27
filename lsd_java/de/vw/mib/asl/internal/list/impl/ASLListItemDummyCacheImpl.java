/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import java.util.Arrays;

public class ASLListItemDummyCacheImpl
implements ASLListElementCache {
    private int listSize;

    @Override
    public void clear() {
    }

    @Override
    public void clearItems(int n, int n2) {
    }

    @Override
    public Object getListItem(int n, Object object) {
        if (n >= 0 && n < this.listSize) {
            return object;
        }
        return null;
    }

    @Override
    public boolean getListItems(int n, Object[] objectArray, int n2, Object object) {
        if (0 < n2) {
            int n3 = Math.min(n2, this.listSize - n);
            if (0 < n3) {
                Arrays.fill(objectArray, 0, n3, object);
            }
            if (n3 < n2) {
                Arrays.fill(objectArray, Math.max(0, n3), n2, null);
            }
        }
        return true;
    }

    @Override
    public void setListSize(int n) {
        this.listSize = n;
    }

    @Override
    public void insertListItems(int n, Object[] objectArray) {
        this.listSize += objectArray.length;
    }

    @Override
    public void removeListItems(int n, int n2) {
        this.listSize = Math.max(this.listSize - n2, n);
    }

    @Override
    public void updateListItems(int n, Object[] objectArray) {
        this.listSize = Math.max(this.listSize, n + objectArray.length);
    }

    @Override
    public void updateListItems(int n, Object[] objectArray, int n2) {
        this.listSize = Math.max(this.listSize, n + n2);
    }
}

