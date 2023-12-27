/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager;

import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandler;

public interface SdFeatureCollectionHandlerFactory {
    default public SdFeatureCollectionHandler createSdFeatureCollectionHandler(int n, int n2) {
    }

    default public void destroySdFeatureCollectionHandler(SdFeatureCollectionHandler sdFeatureCollectionHandler) {
    }
}

