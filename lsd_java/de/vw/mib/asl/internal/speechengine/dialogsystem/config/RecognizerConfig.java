/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;

public interface RecognizerConfig
extends DialogSystemConfig {
    default public void setLanguage(String string, int n, int n2, DialogSystemConfigCallback dialogSystemConfigCallback) {
    }

    default public String[] getAvailableLanguages() {
    }
}

