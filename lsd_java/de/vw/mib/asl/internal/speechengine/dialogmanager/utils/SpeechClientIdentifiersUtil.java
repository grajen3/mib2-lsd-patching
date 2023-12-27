/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.utils;

import de.vw.mib.configuration.internal.generated.SpeechConfiguration;

public final class SpeechClientIdentifiersUtil {
    private static SpeechConfiguration speechConfig;

    private SpeechClientIdentifiersUtil() {
    }

    public static void setSpeechConfig(SpeechConfiguration speechConfiguration) {
        speechConfig = speechConfiguration;
    }

    public static String toString(int n) {
        String string = speechConfig.getSpeechClientName(n);
        StringBuffer stringBuffer = new StringBuffer();
        if (string == null) {
            stringBuffer.append("UNKNOWN");
        } else {
            stringBuffer.append(string);
        }
        stringBuffer.append("[");
        stringBuffer.append(n);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

