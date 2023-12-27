/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.AbstractMap$2;
import edu.emory.mathcs.backport.java.util.AbstractSet;
import java.util.Iterator;

class AbstractMap$1
extends AbstractSet {
    private final /* synthetic */ AbstractMap this$0;

    AbstractMap$1(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public Iterator iterator() {
        return new AbstractMap$2(this);
    }

    static /* synthetic */ AbstractMap access$000(AbstractMap$1 abstractMap$1) {
        return abstractMap$1.this$0;
    }
}

