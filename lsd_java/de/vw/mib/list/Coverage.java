/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.Range;

public interface Coverage {
    default public void addRange(int n, int n2) {
    }

    default public void clear() {
    }

    default public void clearRange(int n, int n2) {
    }

    default public void compact() {
    }

    default public boolean covers(int n, int n2) {
    }

    default public Range getFirstIntersection(Coverage coverage) {
    }

    default public Range getFirstRange() {
    }

    default public Range getRangeAfter(int n) {
    }

    default public Range getRangeAt(int n) {
    }

    default public void insertGap(int n, int n2) {
    }

    default public boolean intersects(int n, int n2) {
    }

    default public boolean isEmpty() {
    }

    default public void removeRange(int n, int n2) {
    }

    default public void upperBound(int n) {
    }
}

