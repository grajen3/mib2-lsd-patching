/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntSet;
import java.util.Arrays;

public class ASLListItemHardCacheImpl
implements ASLListElementCache {
    private IntObjectOptHashMap map = new IntObjectOptHashMap();
    private int listSize;

    @Override
    public void clear() {
        this.map.clear();
        this.listSize = 0;
    }

    @Override
    public void clearItems(int n, int n2) {
        int n3 = n + n2;
        IntSet intSet = this.map.keySet();
        IntIterator intIterator = intSet.iterator();
        while (intIterator.hasNext()) {
            int n4 = intIterator.next();
            if (n > n4 || n4 >= n3) continue;
            intIterator.remove();
        }
    }

    @Override
    public Object getListItem(int n, Object object) {
        if (n >= 0 && n < this.listSize) {
            Object object2 = this.map.get(n);
            return null != object2 ? object2 : object;
        }
        return null;
    }

    @Override
    public boolean getListItems(int n, Object[] objectArray, int n2, Object object) {
        boolean bl = true;
        int n3 = 0;
        if (n < 0) {
            n3 = Math.min(n2, -n);
            Arrays.fill(objectArray, 0, n3, null);
        }
        while (n3 < n2 && n + n3 < this.listSize) {
            Object object2 = this.map.get(n + n3);
            Object object3 = objectArray[n3] = null != object2 ? object2 : object;
            if (null == object2) {
                bl = false;
            }
            ++n3;
        }
        if (n3 < n2) {
            Arrays.fill(objectArray, n3, n2, null);
        }
        return !bl;
    }

    @Override
    public void setListSize(int n) {
        if (n < this.listSize) {
            if (0 >= n) {
                this.map.clear();
            } else {
                IntSet intSet = this.map.keySet();
                IntIterator intIterator = intSet.iterator();
                while (intIterator.hasNext()) {
                    int n2 = intIterator.next();
                    if (n2 < n) continue;
                    intIterator.remove();
                }
            }
        }
        this.listSize = Math.max(0, n);
    }

    @Override
    public void insertListItems(int n, Object[] objectArray) {
        this.listSize = Math.max(this.listSize, n) + objectArray.length;
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(this.listSize);
        IntSet intSet = this.map.keySet();
        IntIterator intIterator = intSet.iterator();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            Object object = this.map.get(n2);
            if (null == object) continue;
            if (n2 >= n) {
                n2 += objectArray.length;
            }
            intObjectOptHashMap.put(n2, object);
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            intObjectOptHashMap.put(n + i2, objectArray[i2]);
        }
        this.map.clear();
        this.map = intObjectOptHashMap;
    }

    @Override
    public void removeListItems(int n, int n2) {
        if (n < this.listSize && 0 < n2) {
            this.listSize = Math.max(this.listSize - n2, n);
            IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(this.listSize);
            IntSet intSet = this.map.keySet();
            IntIterator intIterator = intSet.iterator();
            while (intIterator.hasNext()) {
                int n3 = intIterator.next();
                Object object = this.map.get(n3);
                if (null == object) continue;
                if (n3 < n) {
                    intObjectOptHashMap.put(n3, object);
                    continue;
                }
                if (n3 < n + n2) continue;
                intObjectOptHashMap.put(n3 - n2, object);
            }
            this.map.clear();
            this.map = intObjectOptHashMap;
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
            for (int i2 = 0; i2 < n3; ++i2) {
                Object object = objectArray[i2];
                if (null == object) continue;
                this.map.put(n + i2, object);
            }
            this.listSize = Math.max(this.listSize, n + n3);
        }
    }

    int getListSize() {
        return this.listSize;
    }
}

