/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.util;

import java.util.Iterator;

public final class EmptyIterator
implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
    }
}

