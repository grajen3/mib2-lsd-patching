/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;

public interface TeleprompterManagerCallback {
    default public void onTeleprompterManagerReady(TeleprompterManager teleprompterManager) {
    }
}

