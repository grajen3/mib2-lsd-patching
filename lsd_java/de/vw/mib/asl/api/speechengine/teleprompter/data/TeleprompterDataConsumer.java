/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.teleprompter.data;

import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;

public interface TeleprompterDataConsumer {
    default public void onTeleprompterDataChanged(TeleprompterData teleprompterData) {
    }
}

