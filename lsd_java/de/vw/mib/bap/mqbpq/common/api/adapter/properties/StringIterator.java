/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter.properties;

import de.vw.mib.asl.internal.list.ASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;

public class StringIterator
implements Iterator {
    private ASLList aslList;
    private final int columnId;
    private int currentIndex;
    private final int size;

    public StringIterator(int n, int n2) {
        this.columnId = n2;
        this.currentIndex = 0;
        this.aslList = ListManager.getASLList(n);
        this.size = this.aslList.getSize();
    }

    public StringIterator() {
        this.currentIndex = 0;
        this.size = 0;
        this.columnId = 0;
        this.aslList = null;
    }

    public int size() {
        return this.size;
    }

    public String stringAtIndex(int n) {
        Object object = this.aslList.getRowItem(n);
        return this.aslList.getListTransformer().getString(this.columnId, object);
    }

    public String stringForRow(Object object) {
        return this.aslList.getListTransformer().getString(this.columnId, object);
    }

    public String nextString() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        String string = this.aslList.getListTransformer().getString(this.columnId, object);
        this.currentIndex = Math.min(this.currentIndex + 1, this.size);
        return string;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.size;
    }

    @Override
    public Object next() {
        return this.nextString();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static String getValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(n2, object);
    }
}

