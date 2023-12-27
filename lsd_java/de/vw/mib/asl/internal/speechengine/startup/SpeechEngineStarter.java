/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.features.FeatureFactory;

public interface SpeechEngineStarter {
    default public void onSdFeatureCollectionManagerReady() {
    }

    default public void onFeatureFactoryReady(FeatureFactory featureFactory) {
    }
}

