/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.Action;
import de.vw.mib.asl.internal.speechmedia.action.global.GenericGlobalAction$1;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import de.vw.mib.genericevents.EventGeneric;

public abstract class GenericGlobalAction
implements Action {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[GenericAction] ");
    public static final int ERROR_NOT_AVAILABLE;
    public static final int ERROR_NOT_ACTIVE;
    public static final int NOTIFY_ACTIVATED;
    public static final int DATAPOOL;
    protected final MediaServiceController msController;

    public GenericGlobalAction(MediaServiceController mediaServiceController) {
        this.msController = mediaServiceController;
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (this.getDownEvent() == n) {
            this.executeAction(4);
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (this.getDownEvent() == n) {
            this.executeAction(4);
        }
    }

    protected abstract int getSuccessEvent() {
    }

    protected abstract int getDatapoolValue() {
    }

    protected abstract boolean doSourceCheck() {
    }

    protected abstract boolean doSuccess() {
    }

    public boolean executeAction(int n) {
        if (!this.msController.isAvailable()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Media domain is not available. Prompt error and end SDS.");
            }
            AbstractASLHsmTarget.writeIntegerToDatapool(-1233047040, this.getDatapoolValue());
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1065274880);
            return false;
        }
        if (!this.doSourceCheck() || this.msController.isActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Media is active. Execute action.");
            }
            if (this.doSuccess()) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.getSuccessEvent());
            }
            return true;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Media is not active.");
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1082052096);
        this.msController.activate(n, new GenericGlobalAction$1(this));
        return false;
    }
}

