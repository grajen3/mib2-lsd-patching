/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIListener;

public interface DSISearchDataProviderListener
extends DSIListener {
    default public void registerProviderSourceResult(int n, int n2) {
    }

    default public void activateProviderSource(int n) {
    }

    default public void invalidateAllDataResult(int n, int n2) {
    }

    default public void provideData(int n, int n2, int n3) {
    }

    default public void storeDataSetsResult(int n, int n2) {
    }

    default public void deleteDataSetResult(int n, int n2, long l) {
    }
}

