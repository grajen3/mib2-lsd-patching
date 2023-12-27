/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter.properties;

import de.vw.mib.asl.internal.list.ASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;

public class LongIterator
implements Iterator {
    private ASLList aslList;
    private final int columnId;
    private int currentIndex;
    private final int size;
    public static final int INVALID_LONG_VALUE;

    public LongIterator(int n, int n2) {
        this.columnId = n2;
        this.currentIndex = 0;
        this.aslList = ListManager.getASLList(n);
        this.size = this.aslList.getSize();
    }

    public int size() {
        return this.size;
    }

    public long longAtIndex(int n) {
        Object object = this.aslList.getRowItem(n);
        return this.aslList.getListTransformer().getLong(this.columnId, object);
    }

    public long cachedLongAtIndex(int n) {
        Object object = this.aslList.getRowItemCacheOnly(n);
        return this.aslList.isValidItem(object) ? this.aslList.getListTransformer().getLong(this.columnId, object) : -1L;
    }

    public long nextLong() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        long l = this.aslList.getListTransformer().getLong(this.columnId, object);
        this.currentIndex = Math.min(this.currentIndex + 1, this.size);
        return l;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.size;
    }

    @Override
    public Object next() {
        long l = this.nextLong();
        return new Long(l);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static long getValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getLong(n2, object);
    }
}

