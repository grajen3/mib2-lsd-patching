/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter.properties;

import de.vw.mib.asl.internal.list.ASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;

public final class BooleanIterator
implements Iterator {
    private ASLList aslList;
    private final int columnId;
    private int currentIndex;
    private final int size;

    public BooleanIterator(int n, int n2) {
        this.columnId = n2;
        this.currentIndex = 0;
        this.aslList = ListManager.getASLList(n);
        this.size = this.aslList.getSize();
    }

    public int size() {
        return this.size;
    }

    public boolean nextBoolean() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        boolean bl = this.aslList.getListTransformer().getBoolean(this.columnId, object);
        this.currentIndex = Math.min(this.currentIndex + 1, this.size);
        return bl;
    }

    public boolean booleanAtIndex(int n) {
        Object object = this.aslList.getRowItem(n);
        return this.aslList.getListTransformer().getBoolean(this.columnId, object);
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.size;
    }

    @Override
    public Object next() {
        boolean bl = this.nextBoolean();
        return bl ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static boolean getValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(n2, object);
    }
}

