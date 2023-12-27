/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.unifiedlogging;

public interface UnifiedLoggingCallbackListener {
    public static final String OSGI_PROPERTY_MESSAGE_TYPE;

    default public void onBinaryMessageReceived(short s, byte[] byArray, int n, int n2) {
    }
}

