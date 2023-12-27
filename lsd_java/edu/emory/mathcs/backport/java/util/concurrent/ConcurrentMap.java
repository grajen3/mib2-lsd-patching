/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import java.util.Map;

public interface ConcurrentMap
extends Map {
    default public Object putIfAbsent(Object object, Object object2) {
    }

    default public boolean remove(Object object, Object object2) {
    }

    default public boolean replace(Object object, Object object2, Object object3) {
    }

    default public Object replace(Object object, Object object2) {
    }
}

