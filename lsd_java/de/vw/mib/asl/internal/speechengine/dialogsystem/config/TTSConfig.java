/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface TTSConfig
extends DialogSystemConfig {
    default public void setLanguage(String string, int n, int n2, int n3, DialogSystemConfigCallback dialogSystemConfigCallback) {
    }

    default public LanguageVoiceInfo[] getAvailableLanguages() {
    }

    default public int getTtsInstanceId() {
    }
}

