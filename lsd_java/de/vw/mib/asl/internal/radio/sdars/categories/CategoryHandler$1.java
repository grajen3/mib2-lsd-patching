/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.categories;

import de.vw.mib.asl.internal.radio.sdars.categories.CategoryHandler;
import java.util.Iterator;
import java.util.NoSuchElementException;

class CategoryHandler$1
implements Iterator {
    private int mIndex = -1;
    private final /* synthetic */ CategoryHandler this$0;

    CategoryHandler$1(CategoryHandler categoryHandler) {
        this.this$0 = categoryHandler;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object next() {
        if (this.mIndex < this.this$0.mArray.length - 1) {
            ++this.mIndex;
            return this.this$0.mArray[this.mIndex];
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        return this.mIndex < this.this$0.mArray.length - 1;
    }
}

