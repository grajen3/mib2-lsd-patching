/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractMap$4;
import java.util.Iterator;

final class AbstractMap$3
extends AbstractCollection {
    final /* synthetic */ AbstractMap this$0;

    AbstractMap$3(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
    }

    @Override
    public Iterator iterator() {
        return new AbstractMap$4(this);
    }

    static /* synthetic */ AbstractMap access$0(AbstractMap$3 abstractMap$3) {
        return abstractMap$3.this$0;
    }
}

