/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.teleprompter.data;

import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataConsumer;

public interface TeleprompterDataManager {
    default public void register(TeleprompterDataConsumer teleprompterDataConsumer) {
    }

    default public void unregister(TeleprompterDataConsumer teleprompterDataConsumer) {
    }

    default public TeleprompterData getTeleprompterData() {
    }
}

