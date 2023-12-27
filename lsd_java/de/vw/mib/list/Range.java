/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListPooledEntity;

public interface Range
extends HMIListPooledEntity {
    default public Range copy() {
    }

    default public int getStart() {
    }

    default public int getEnd() {
    }

    default public Range intersect(int n, int n2) {
    }

    default public boolean intersects(Range range) {
    }

    default public boolean intersects(int n, int n2) {
    }
}

