/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractMap;
import java.util.AbstractMap$2;
import java.util.AbstractSet;
import java.util.Iterator;

final class AbstractMap$1
extends AbstractSet {
    final /* synthetic */ AbstractMap this$0;

    AbstractMap$1(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public Iterator iterator() {
        return new AbstractMap$2(this);
    }

    static /* synthetic */ AbstractMap access$0(AbstractMap$1 abstractMap$1) {
        return abstractMap$1.this$0;
    }
}

