/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.speechproxy;

import de.vw.mib.asl.api.speechengine.features.Feature;

public interface SpeechProxy {
    default public void setFeatures(int n, Feature[] featureArray) {
    }

    default public void updateFeatures(int n, Feature[] featureArray) {
    }
}

