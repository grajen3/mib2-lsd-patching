/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator;

import de.vw.mib.asl.internal.list.ASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;

public abstract class AbstractASLDataPoolIterator
implements Iterator {
    protected ASLList aslList;
    protected int currentIndex = -1;
    protected int size;

    public AbstractASLDataPoolIterator(int n) {
        this.aslList = ListManager.getASLList(n);
        this.size = this.aslList.getSize();
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex + 1 < this.size && this.size > 0;
    }

    @Override
    public abstract Object next() {
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    protected int getCurrentIndex() {
        return this.currentIndex;
    }
}

