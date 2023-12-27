/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.remote;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.speech.remote.dialogmanager.DialogManagerRemote;

public class DialogManagerRemoteImpl
implements DialogManagerRemote {
    private final SpeechEngineMaster speechEngineMaster;

    DialogManagerRemoteImpl(SpeechEngineMaster speechEngineMaster) {
        this.speechEngineMaster = speechEngineMaster;
    }

    @Override
    public void disableSession(int n) {
        this.speechEngineMaster.getDialogManager(n).disableSession();
    }

    @Override
    public void enableSession(int n) {
        this.speechEngineMaster.getDialogManager(n).enableSession();
    }
}

