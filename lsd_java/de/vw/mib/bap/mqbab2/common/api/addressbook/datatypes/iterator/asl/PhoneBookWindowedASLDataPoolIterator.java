/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.PhoneBookASLDataPoolIterator;
import java.util.NoSuchElementException;

public class PhoneBookWindowedASLDataPoolIterator
extends PhoneBookASLDataPoolIterator {
    protected int[] rowIndices;

    public PhoneBookWindowedASLDataPoolIterator(int[] nArray) {
        this.rowIndices = nArray;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex + 1 < this.rowIndices.length && this.rowIndices.length != 0 && this.rowIndices[this.currentIndex + 1] < this.aslList.getSize() && this.rowIndices[this.currentIndex + 1] >= 0;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.currentIndex;
        return this;
    }

    @Override
    protected int getCurrentIndex() {
        return this.rowIndices[this.currentIndex];
    }
}

