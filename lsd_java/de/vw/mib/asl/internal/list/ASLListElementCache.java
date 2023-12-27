/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLListUpdates;

public interface ASLListElementCache
extends ASLListUpdates {
    default public void clear() {
    }

    default public Object getListItem(int n, Object object) {
    }

    default public boolean getListItems(int n, Object[] objectArray, int n2, Object object) {
    }

    default public void setListSize(int n) {
    }

    default public void updateListItems(int n, Object[] objectArray, int n2) {
    }

    default public void clearItems(int n, int n2) {
    }
}

