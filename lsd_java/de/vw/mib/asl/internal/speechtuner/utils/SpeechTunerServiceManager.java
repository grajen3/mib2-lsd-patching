/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils;

import de.vw.mib.asl.internal.speechtuner.utils.RadioUtils;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerASLServices;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerModelServices;
import org.osgi.framework.BundleContext;

public interface SpeechTunerServiceManager {
    default public BundleContext getBundleContext() {
    }

    default public SpeechTunerModelServices getModelServices() {
    }

    default public SpeechTunerASLServices getASLServices() {
    }

    default public RadioUtils getRadioUtils() {
    }

    default public SpeechTunerLogger createSpeechTunerLogger(String string) {
    }
}

