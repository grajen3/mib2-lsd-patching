/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.speakonly.SpeakOnlyService;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;

public class SpeakOnlyServiceAdapter
implements SpeakOnlyService {
    protected static DialogManagerLogger logger = new DialogManagerLogger("[SpeakOnlyServiceAdapter] ");
    private final DialogManagerInternal dialogManager;
    private final int clientId;

    public SpeakOnlyServiceAdapter(DialogManagerInternal dialogManagerInternal, int n) {
        this.dialogManager = dialogManagerInternal;
        this.clientId = n;
    }

    @Override
    public void cancelCurrentRunningPrompt() {
        if (logger.isTraceEnabled()) {
            this.trace("cancelCurrentRunningPrompt()");
        }
        this.dialogManager.cancelCurrentRunningPrompt(this.clientId);
    }

    private void trace(String string) {
        logger.trace().append("triggered ").append(string).append(" from client: ").append(SpeechClientIdentifiersUtil.toString(this.clientId)).log();
    }
}

