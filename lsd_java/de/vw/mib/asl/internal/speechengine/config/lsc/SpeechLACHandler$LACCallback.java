/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLACHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;

class SpeechLACHandler$LACCallback
implements DialogSystemConfigCallback {
    private final String newLanguage;
    private final SpeechLACHandler lacHandler;

    SpeechLACHandler$LACCallback(String string, SpeechLACHandler speechLACHandler) {
        this.newLanguage = string;
        this.lacHandler = speechLACHandler;
    }

    @Override
    public void setLanguageCallback(int n, boolean bl) {
        this.lacHandler.responseToLanguageChange(n, bl, this.newLanguage);
    }
}

