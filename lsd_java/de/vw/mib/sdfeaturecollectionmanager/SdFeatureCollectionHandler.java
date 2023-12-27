/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public interface SdFeatureCollectionHandler {
    default public void setSpeechClientId(int n) {
    }

    default public void setParent(SdFeatureCollectionHandler sdFeatureCollectionHandler) {
    }

    default public Feature[] collectFeaturesAndActivateConditionObservation() {
    }

    default public void destroy() {
    }

    default public void collectAllCommandsToLoad(ObjectArrayList objectArrayList) {
    }

    default public void tryToAddAllFeaturesToMapAndUpdateFeatureActivity(IntObjectOptHashMap intObjectOptHashMap) {
    }

    default public void setCommandFeatureActivity(boolean bl) {
    }

    default public void evaluateAllConditionsInitially() {
    }
}

