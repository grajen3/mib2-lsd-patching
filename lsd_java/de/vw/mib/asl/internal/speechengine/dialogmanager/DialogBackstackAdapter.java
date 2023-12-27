/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstackListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;

public class DialogBackstackAdapter
implements DialogBackstack {
    protected static DialogManagerLogger logger = new DialogManagerLogger("[DialogBackstackAdapter] ");
    private final int clientId;
    private final DialogManagerInternal dialogManager;

    public DialogBackstackAdapter(DialogManagerInternal dialogManagerInternal, int n) {
        if (logger.isTraceEnabled()) {
            logger.trace().append("Created instance for client: ").append(SpeechClientIdentifiersUtil.toString(n)).log();
        }
        this.dialogManager = dialogManagerInternal;
        this.clientId = n;
    }

    @Override
    public void clear() {
        if (logger.isTraceEnabled()) {
            this.trace("clear()");
        }
        this.dialogManager.clearBackstack(this.clientId);
    }

    @Override
    public void back() {
        if (logger.isTraceEnabled()) {
            this.trace("back()");
        }
        if (this.clientId != 1) {
            logger.warn("The back()-Function should only be called from SPEECH_HEADLINE.");
        }
        this.dialogManager.back();
    }

    @Override
    public void register(DialogBackstackListener dialogBackstackListener) {
        if (logger.isTraceEnabled()) {
            this.trace("register(DialogBackstackListener)");
        }
        this.dialogManager.registerDialogBackstackListener(dialogBackstackListener);
    }

    @Override
    public void unregister(DialogBackstackListener dialogBackstackListener) {
        if (logger.isTraceEnabled()) {
            this.trace("unregister(DialogBackstackListener)");
        }
        this.dialogManager.unregisterDialogBackstackListener(dialogBackstackListener);
    }

    @Override
    public void push(DialogBackHandler dialogBackHandler) {
        if (logger.isTraceEnabled()) {
            this.trace("push(DialogBackHandler)");
        }
        this.dialogManager.pushDialogBackHandler(dialogBackHandler);
    }

    private void trace(String string) {
        logger.trace().append("triggered ").append(string).append(" from client: ").append(SpeechClientIdentifiersUtil.toString(this.clientId)).log();
    }
}

