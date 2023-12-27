/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import java.util.Iterator;
import java.util.List;

public interface BAPArrayDataList {
    default public int size() {
    }

    default public BAPArrayElement get(int n) {
    }

    default public BAPArrayDataList getElements(int n, int n2) {
    }

    default public BAPArrayElement getFirst() {
    }

    default public BAPArrayElement getLast() {
    }

    default public Iterator getIterator() {
    }

    default public BAPArrayElement[] toArray() {
    }

    default public boolean addToList(List list) {
    }

    default public boolean addToList(int n, List list) {
    }
}

