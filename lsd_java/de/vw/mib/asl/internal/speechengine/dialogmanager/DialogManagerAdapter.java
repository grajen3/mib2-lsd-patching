/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogSessionListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;

public class DialogManagerAdapter
implements DialogManager {
    protected static DialogManagerLogger logger = new DialogManagerLogger("[DialogManagerAdapter] ");
    private final int clientId;
    private final DialogManagerInternal dialogManagerInternal;

    public DialogManagerAdapter(DialogManagerInternal dialogManagerInternal, int n) {
        if (logger.isTraceEnabled()) {
            logger.trace().append("Created instance for client: ").append(SpeechClientIdentifiersUtil.toString(n)).log();
        }
        this.dialogManagerInternal = dialogManagerInternal;
        this.clientId = n;
    }

    @Override
    public void startSession(DialogSessionListener dialogSessionListener) {
        if (logger.isTraceEnabled()) {
            this.trace("startSession()");
        }
        this.dialogManagerInternal.startSession(dialogSessionListener);
    }

    @Override
    public void startSession() {
        logger.error("Used deprecated method 'DialogManager.startSession()'");
        this.dialogManagerInternal.startSession(null);
    }

    @Override
    public void endSession(boolean bl) {
        if (logger.isTraceEnabled()) {
            this.trace(new StringBuffer().append("endSession(").append(bl).append(")").toString());
        }
        this.dialogManagerInternal.endSession(bl);
    }

    @Override
    public void disableSession() {
        if (logger.isTraceEnabled()) {
            this.trace("disableSession()");
        }
        this.dialogManagerInternal.disableSession(this.clientId);
    }

    @Override
    public void enableSession() {
        if (logger.isTraceEnabled()) {
            this.trace("enableSession()");
        }
        this.dialogManagerInternal.enableSession(this.clientId);
    }

    @Override
    public void pauseSession() {
        if (logger.isTraceEnabled()) {
            this.trace("pauseSession()");
        }
        this.dialogManagerInternal.pauseSession();
    }

    @Override
    public void back() {
        if (logger.isTraceEnabled()) {
            this.trace("back()");
        }
        this.dialogManagerInternal.back();
    }

    @Override
    public void togglePause() {
        if (logger.isTraceEnabled()) {
            this.trace("togglePause()");
        }
        this.dialogManagerInternal.togglePause();
    }

    private void trace(String string) {
        logger.trace().append("triggered ").append(string).append(" from client: ").append(SpeechClientIdentifiersUtil.toString(this.clientId)).log();
    }
}

