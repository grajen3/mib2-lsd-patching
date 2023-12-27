/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap$1;
import java.util.Set;

public abstract class AbstractMap
extends java.util.AbstractMap {
    transient Set keySet;

    protected AbstractMap() {
    }

    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractMap$1(this);
        }
        return this.keySet;
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }

    static /* synthetic */ boolean access$100(Object object, Object object2) {
        return AbstractMap.eq(object, object2);
    }
}

