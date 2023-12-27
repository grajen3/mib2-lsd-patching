/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;

class DialogSession$PauseOnDDS
extends KeyAdapter {
    private DialogManager dialogMgr;
    private final /* synthetic */ DialogSession this$0;

    DialogSession$PauseOnDDS(DialogSession dialogSession, DialogManager dialogManager, SpeechGeneralLogger speechGeneralLogger) {
        this.this$0 = dialogSession;
        this.dialogMgr = dialogManager;
    }

    @Override
    public void onRotationLeft(int n) {
        if (n == 12 && this.this$0.isActive()) {
            this.dialogMgr.pauseSession();
        }
    }

    @Override
    public void onRotationRight(int n) {
        if (n == 12 && this.this$0.isActive()) {
            this.dialogMgr.pauseSession();
        }
    }
}

