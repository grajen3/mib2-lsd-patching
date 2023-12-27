/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.buffer;

import de.vw.mib.asl.internal.list.IndexIterable;

public interface ASLListCache
extends IndexIterable {
    default public void clear() {
    }

    default public void cutToSize(int n) {
    }

    default public Object getItem(int n) {
    }

    default public int getItemCount() {
    }

    default public boolean getItems(int n, Object[] objectArray, int n2) {
    }

    default public void insertItems(int n, Object[] objectArray) {
    }

    default public void removeItems(int n, int n2) {
    }

    default public void setItems(int n, Object[] objectArray, int n2) {
    }

    default public void clearItems(int n, int n2) {
    }
}

