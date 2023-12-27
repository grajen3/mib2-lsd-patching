/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

interface DatapoolWatchdogHandler {
    default public void onPropertyObjectHasChanged(int n, Object object) {
    }

    default public void onSetPropertyWithSameObject(int n, Object object) {
    }
}

