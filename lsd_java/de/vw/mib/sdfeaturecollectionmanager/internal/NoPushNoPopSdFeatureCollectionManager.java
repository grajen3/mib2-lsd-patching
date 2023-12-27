/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager.internal;

import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager;

public class NoPushNoPopSdFeatureCollectionManager
implements SdFeatureCollectionManager {
    @Override
    public void pushSdFeatureCollection(int n, int n2) {
        throw new IllegalStateException(new StringBuffer().append("Trying to push an SdFeatureCollection before the real SdFeatureCollectionManager is available! Speech sm index: ").append(n).toString());
    }

    @Override
    public void popSdFeatureCollection(int n) {
        throw new IllegalStateException(new StringBuffer().append("Trying to push an SdFeatureCollection before the real SdFeatureCollectionManager is available! Speech sm index: ").append(n).toString());
    }

    @Override
    public void changeSdFeatureCollection(int n, int n2) {
    }
}

