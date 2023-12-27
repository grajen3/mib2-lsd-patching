/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils;

import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechtuner.utils.FeatureAvailabilityChecker;

public interface SpeechTunerASLServices {
    default public long getCurrentTimeMillis() {
    }

    default public void requestAPI(Class clazz, ASLComponentAPICallback aSLComponentAPICallback) {
    }

    default public FeatureAvailabilityChecker getFeatureAvailabilityChecker() {
    }
}

