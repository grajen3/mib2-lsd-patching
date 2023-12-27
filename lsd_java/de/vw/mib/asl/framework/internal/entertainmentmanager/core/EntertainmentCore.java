/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.core;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.ActivationRequest;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.Deactivation;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentController;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerLastmodes;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.EntertainmentContextListenerServiceImpl;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.EntertainmentCore$1;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.EntertainmentCore$2;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.PrefixLogger;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.SafeActivationRequest;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Timer;

public class EntertainmentCore
implements EntertainmentManagerCoreService,
Loggable {
    private final PrefixLogger logger;
    private final Services services;
    private EntertainmentManagerLastmodes lastmodes;
    private EntertainmentContextListenerServiceImpl contextListeners;
    private boolean activating = false;
    private boolean canceling = false;
    private boolean deactivating = false;
    private ActivationRequest runningRequest;
    private ActivationRequest pendingRequest;
    private Deactivation deactivation;
    private final Runnable deactivateCallback;
    private final Runnable activateCallback;
    private final Timer deactivationTimer;
    private final Timer activationTimer;
    private int lastRequestedContext;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService;

    public EntertainmentCore(Logger logger, Services services) {
        this.logger = new PrefixLogger(logger, 16, this);
        this.services = services;
        this.deactivateCallback = (Runnable)this.services.getASLAsyncServiceFactory().create(new EntertainmentCore$1(this));
        this.activateCallback = (Runnable)this.services.getASLAsyncServiceFactory().create(new EntertainmentCore$2(this));
        ThreadSwitchingTarget threadSwitchingTarget = services.getASLThreadSwitch();
        this.deactivationTimer = services.getTimerManager().createTimer("deactivate Timer", 0, false, this.deactivateCallback, threadSwitchingTarget);
        this.activationTimer = services.getTimerManager().createTimer("activate Timer", EntertainmentController.WAIT_FOR_ACTIVATED_TIME, false, this.activateCallback, threadSwitchingTarget);
    }

    public void powerOn(EntertainmentManagerLastmodes entertainmentManagerLastmodes) {
        this.lastmodes = entertainmentManagerLastmodes;
        this.lastRequestedContext = entertainmentManagerLastmodes.getActive().getContext();
        this.services.getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService = EntertainmentCore.class$("de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService, this);
        this.contextListeners = new EntertainmentContextListenerServiceImpl(this.services.getASLAsyncServiceFactory());
        this.contextListeners.updateContext(this.getContext());
        this.services.getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService = EntertainmentCore.class$("de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener.EntertainmentContextListenerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService, this.contextListeners);
    }

    public int getLastRequestedContext() {
        return this.lastRequestedContext;
    }

    @Override
    public void request(ActivationRequest activationRequest) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("got request ").append(activationRequest.toString()).log();
        }
        activationRequest = new SafeActivationRequest(this.logger, activationRequest);
        this.lastRequestedContext = activationRequest.getContext();
        if (this.activating || this.deactivating) {
            if (this.pendingRequest != null) {
                this.pendingRequest.rejected();
            }
            this.pendingRequest = activationRequest;
            if (this.activating && !this.canceling) {
                this.canceling = true;
                this.runningRequest.cancel();
            }
        } else {
            this.executeActivation(activationRequest);
        }
    }

    @Override
    public int getContext() {
        return this.lastmodes.getActive().getContext();
    }

    private void executeActivation(ActivationRequest activationRequest) {
        this.runningRequest = activationRequest;
        this.activating = true;
        if (this.deactivation != null) {
            Deactivation deactivation = this.deactivation;
            this.deactivation = null;
            this.deactivating = true;
            this.deactivationTimer.start();
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("send deactivate to ").append(deactivation.toString()).log();
            }
            try {
                deactivation.deactivate(activationRequest.getContext(), this.deactivateCallback);
            }
            catch (Exception exception) {
                this.logger.error("a context failed on deactivate", exception);
            }
        }
        this.activationTimer.start();
        this.lastmodes.setContext(activationRequest.getContext());
        this.contextListeners.updateContext(this.lastRequestedContext);
        this.deactivation = activationRequest.granted(this.activateCallback);
    }

    private void checkNextActivation() {
        if (!this.activating && !this.deactivating && this.pendingRequest != null) {
            ActivationRequest activationRequest = this.pendingRequest;
            this.pendingRequest = null;
            this.executeActivation(activationRequest);
        }
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("[CORE]").append(this.activating ? (char)'!' : ' ').append(this.deactivating ? (char)'!' : ' ');
    }

    static /* synthetic */ Timer access$000(EntertainmentCore entertainmentCore) {
        return entertainmentCore.deactivationTimer;
    }

    static /* synthetic */ PrefixLogger access$100(EntertainmentCore entertainmentCore) {
        return entertainmentCore.logger;
    }

    static /* synthetic */ boolean access$202(EntertainmentCore entertainmentCore, boolean bl) {
        entertainmentCore.deactivating = bl;
        return entertainmentCore.deactivating;
    }

    static /* synthetic */ void access$300(EntertainmentCore entertainmentCore) {
        entertainmentCore.checkNextActivation();
    }

    static /* synthetic */ Timer access$400(EntertainmentCore entertainmentCore) {
        return entertainmentCore.activationTimer;
    }

    static /* synthetic */ boolean access$502(EntertainmentCore entertainmentCore, boolean bl) {
        entertainmentCore.activating = bl;
        return entertainmentCore.activating;
    }

    static /* synthetic */ boolean access$602(EntertainmentCore entertainmentCore, boolean bl) {
        entertainmentCore.canceling = bl;
        return entertainmentCore.canceling;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

