/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$HashIterator;
import java.util.Enumeration;
import java.util.Iterator;

final class ConcurrentHashMap$KeyIterator
extends ConcurrentHashMap$HashIterator
implements Iterator,
Enumeration {
    private final /* synthetic */ ConcurrentHashMap this$0;

    ConcurrentHashMap$KeyIterator(ConcurrentHashMap concurrentHashMap) {
        this.this$0 = concurrentHashMap;
        super(concurrentHashMap);
    }

    @Override
    public Object next() {
        return super.nextEntry().key;
    }

    @Override
    public Object nextElement() {
        return super.nextEntry().key;
    }
}

