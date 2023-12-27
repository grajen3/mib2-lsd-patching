/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import java.util.Collection;

public interface Queue
extends Collection {
    @Override
    default public boolean add(Object object) {
    }

    default public boolean offer(Object object) {
    }

    default public Object remove() {
    }

    default public Object poll() {
    }

    default public Object element() {
    }

    default public Object peek() {
    }
}

