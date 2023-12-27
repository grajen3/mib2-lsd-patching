/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter.properties;

import de.vw.mib.asl.internal.list.ASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;

public class IntegerIterator
implements Iterator {
    private ASLList aslList;
    private final int columnId;
    private int currentIndex;
    private final int size;

    protected IntegerIterator() {
        this.currentIndex = 0;
        this.columnId = 0;
        this.size = 0;
        this.aslList = null;
    }

    public IntegerIterator(int n, int n2) {
        this.columnId = n2;
        this.currentIndex = 0;
        this.aslList = ListManager.getASLList(n);
        this.size = this.aslList.getSize();
    }

    public int size() {
        return this.size;
    }

    public int integerAtIndex(int n) {
        Object object = this.aslList.getRowItem(n);
        return this.aslList.getListTransformer().getInt(this.columnId, object);
    }

    public int integerForRow(Object object) {
        return this.aslList.getListTransformer().getInt(this.columnId, object);
    }

    public int nextInteger() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        int n = this.aslList.getListTransformer().getInt(this.columnId, object);
        this.currentIndex = Math.min(this.currentIndex + 1, this.size);
        return n;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.size;
    }

    @Override
    public Object next() {
        int n = this.nextInteger();
        return new Integer(n);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static int getValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(n2, object);
    }
}

