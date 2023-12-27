/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.state.CommandOverloadStateFeature;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;

public class OverloadFeatureHandler
implements FeatureHandler {
    protected DialogManagerLogger logger = new DialogManagerLogger("[OverloadFeatureHandler] ");
    private int currentClient;
    private Event abortEvent;
    private Event backEvent;
    private Event helpEvent;
    private Event pauseEvent;
    private Event repeatEvent;
    private Event abortEventTemp;
    private Event backEventTemp;
    private Event helpEventTemp;
    private Event pauseEventTemp;
    private Event repeatEventTemp;
    private final HmiEventPublisher hmiEventPublisher;

    public OverloadFeatureHandler(DialogManagerInternal dialogManagerInternal, HmiEventPublisher hmiEventPublisher) {
        this.hmiEventPublisher = hmiEventPublisher;
        dialogManagerInternal.registerFeatureHandler(308, this);
        dialogManagerInternal.registerFeatureHandlerDone(this);
    }

    protected void handleCommandOverloadFeature(int n, CommandOverloadStateFeature commandOverloadStateFeature) {
        this.abortEventTemp = commandOverloadStateFeature.getAbortEvent();
        this.backEventTemp = commandOverloadStateFeature.getBackEvent();
        this.helpEventTemp = commandOverloadStateFeature.getHelpEvent();
        this.pauseEventTemp = commandOverloadStateFeature.getPauseEvent();
        this.repeatEventTemp = commandOverloadStateFeature.getRepeatEvent();
        this.currentClient = n;
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.handleCommandOverloadFeature(n, (CommandOverloadStateFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.handleCommandOverloadFeature(n, (CommandOverloadStateFeature)feature);
    }

    @Override
    public boolean handleDone() {
        this.acceptAbortEvent();
        this.acceptBackEvent();
        this.acceptHelpEvent();
        this.acceptPauseEvent();
        this.acceptRepeatEvent();
        return false;
    }

    @Override
    public boolean updateDone() {
        return false;
    }

    private void acceptAbortEvent() {
        if (this.abortEventTemp != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("ABORT command overloaded with event id: ").append(this.abortEventTemp.getEventId()).toString());
            }
            this.abortEvent = this.abortEventTemp;
            this.abortEventTemp = null;
        } else if (this.abortEvent != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("ABORT command overload removed");
            }
            this.abortEvent = null;
        }
    }

    private void acceptBackEvent() {
        if (this.backEventTemp != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("BACK command overloaded with event id: ").append(this.backEventTemp.getEventId()).toString());
            }
            this.backEvent = this.backEventTemp;
            this.backEventTemp = null;
        } else if (this.backEvent != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("BACK command overload removed");
            }
            this.backEvent = null;
        }
    }

    private void acceptHelpEvent() {
        if (this.helpEventTemp != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("HELP command overloaded with event id: ").append(this.helpEventTemp.getEventId()).toString());
            }
            this.helpEvent = this.helpEventTemp;
            this.helpEventTemp = null;
        } else if (this.helpEvent != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("HELP command overload removed");
            }
            this.helpEvent = null;
        }
    }

    private void acceptPauseEvent() {
        if (this.pauseEventTemp != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("PAUSE command overloaded with event id: ").append(this.pauseEventTemp.getEventId()).toString());
            }
            this.pauseEvent = this.pauseEventTemp;
            this.pauseEventTemp = null;
        } else if (this.pauseEvent != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("PAUSE command overload removed");
            }
            this.pauseEvent = null;
        }
    }

    private void acceptRepeatEvent() {
        if (this.repeatEventTemp != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("repeat REPEAT overloaded with event id: ").append(this.repeatEventTemp.getEventId()).toString());
            }
            this.repeatEvent = this.repeatEventTemp;
            this.repeatEventTemp = null;
        } else if (this.repeatEvent != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("REPEAT command overload removed");
            }
            this.repeatEvent = null;
        }
    }

    public boolean fireAbort() {
        if (this.abortEvent == null) {
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Fire ABORT overload.");
        }
        this.hmiEventPublisher.publishHmiEvent(this.currentClient, this.abortEvent.getEventId());
        return true;
    }

    public boolean fireBack() {
        if (this.backEvent == null) {
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Fire BACK overload.");
        }
        this.hmiEventPublisher.publishHmiEvent(this.currentClient, this.backEvent.getEventId());
        return true;
    }

    public boolean fireHelp() {
        if (this.helpEvent == null) {
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Fire HELP overload.");
        }
        this.hmiEventPublisher.publishHmiEvent(this.currentClient, this.helpEvent.getEventId());
        return true;
    }

    public boolean firePause() {
        if (this.pauseEvent == null) {
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Fire PAUSE overload.");
        }
        this.hmiEventPublisher.publishHmiEvent(this.currentClient, this.pauseEvent.getEventId());
        return true;
    }

    public boolean fireRepeat() {
        if (this.repeatEvent == null) {
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Fire REPEAT overload.");
        }
        this.hmiEventPublisher.publishHmiEvent(this.currentClient, this.repeatEvent.getEventId());
        return true;
    }
}

