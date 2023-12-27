/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;

public abstract class AbstractList
extends java.util.AbstractList {
    protected AbstractList() {
    }

    @Override
    public Object[] toArray() {
        return Utils.collectionToArray(this);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return Utils.collectionToArray(this, objectArray);
    }
}

