/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.asl.FileBrowserASLDataPoolIterator;
import java.util.NoSuchElementException;

public class FileBrowserWindowedASLDataPoolIterator
extends FileBrowserASLDataPoolIterator {
    protected int[] rowIndices;

    public FileBrowserWindowedASLDataPoolIterator(int[] nArray) {
        this.rowIndices = nArray;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex + 1 < this.rowIndices.length && this.rowIndices.length > 0;
    }

    @Override
    public Object next() {
        if (this.currentIndex > this.rowIndices.length || this.rowIndices.length == 0 || this.rowIndices[this.currentIndex + 1] >= this.aslList.getSize() || this.rowIndices[this.currentIndex + 1] < 0) {
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

