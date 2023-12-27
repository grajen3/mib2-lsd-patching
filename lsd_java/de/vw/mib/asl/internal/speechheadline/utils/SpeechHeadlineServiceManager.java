/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechheadline.utils;

import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineLogger;
import org.osgi.framework.BundleContext;

public interface SpeechHeadlineServiceManager {
    default public BundleContext getBundleContext() {
    }

    default public SpeechHeadlineLogger createSpeechHeadlineLogger(String string) {
    }

    default public void writeIntegerToDatapool(int n, int n2) {
    }
}

