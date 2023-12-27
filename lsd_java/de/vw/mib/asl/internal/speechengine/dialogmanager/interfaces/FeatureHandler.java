/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces;

import de.vw.mib.asl.api.speechengine.features.Feature;

public interface FeatureHandler {
    default public void handleFeature(int n, Feature feature) {
    }

    default public void updateFeature(int n, Feature feature) {
    }

    default public boolean handleDone() {
    }

    default public boolean updateDone() {
    }
}

