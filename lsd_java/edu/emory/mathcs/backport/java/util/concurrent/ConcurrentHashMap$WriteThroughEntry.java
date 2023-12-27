/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleEntry;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;

final class ConcurrentHashMap$WriteThroughEntry
extends AbstractMap$SimpleEntry {
    private final /* synthetic */ ConcurrentHashMap this$0;

    ConcurrentHashMap$WriteThroughEntry(ConcurrentHashMap concurrentHashMap, Object object, Object object2) {
        this.this$0 = concurrentHashMap;
        super(object, object2);
    }

    @Override
    public Object setValue(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Object object2 = super.setValue(object);
        this.this$0.put(this.getKey(), object);
        return object2;
    }
}

