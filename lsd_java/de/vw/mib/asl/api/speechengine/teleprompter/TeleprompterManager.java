/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterStateConsumer;

public interface TeleprompterManager {
    default public void toggle() {
    }

    default public void show() {
    }

    default public void hide() {
    }

    default public void register(TeleprompterStateConsumer teleprompterStateConsumer) {
    }

    default public void unregister(TeleprompterStateConsumer teleprompterStateConsumer) {
    }
}

