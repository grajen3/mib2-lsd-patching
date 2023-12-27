/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.audio.Services;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateAbort;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateAbortByAudioContext;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateAnnouncementActive;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateAudiomanagementNotAvailable;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateDSINotAvailable;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateIdle;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateReleaseConnection;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateRepeat;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateRequestConnection;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateStopAnnouncement;
import de.vw.mib.asl.internal.navigation.guidance.audio.StateWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;

public class HsmTargetAudio
extends AbstractResettableAslHsmTarget {
    private static IExtLogger LOGGER = null;
    private Services services;
    DSIListener dsiNavigationListener;
    public final StateWork stateWork;
    public final StateIdle stateIdle;
    public final StateRequestConnection stateRequestConnection;
    public final StateReleaseConnection stateReleaseConnection;
    public final StateAnnouncementActive stateAnnouncementActive;
    public final StateAbort stateAbort;
    public final StateAbortByAudioContext stateAbortByAudioContext;
    public final StateStopAnnouncement stateStopAnnouncement;
    public final StateRepeat stateRepeat;
    public final StateAudiomanagementNotAvailable stateAudiomanagementNotAvailable;
    public final StateDSINotAvailable stateDSINotAvailable;
    int connection;
    boolean isRepeat;
    boolean isRepeatAltRouteCalcAnnouncement;
    boolean isTriggerAltRouteCalcAnnouncement;
    int audioState;
    boolean isRgActive;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public HsmTargetAudio(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.stateIdle = new StateIdle(this, this.hsm, "stateIdle", this.stateWork);
        this.stateRequestConnection = new StateRequestConnection(this, this.hsm, "stateRequestConnection", this.stateWork);
        this.stateReleaseConnection = new StateReleaseConnection(this, this.hsm, "stateReleaseConnection", this.stateWork);
        this.stateAnnouncementActive = new StateAnnouncementActive(this, this.hsm, "stateAnnouncementActive", this.stateWork);
        this.stateAbort = new StateAbort(this, this.hsm, "stateAbort", this.stateWork);
        this.stateAbortByAudioContext = new StateAbortByAudioContext(this, this.hsm, "stateAbortByAudioContext", this.stateWork);
        this.stateStopAnnouncement = new StateStopAnnouncement(this, this.hsm, "stateStopAnnouncement", this.stateWork);
        this.stateRepeat = new StateRepeat(this, this.hsm, "stateRepeat", this.stateWork);
        this.stateAudiomanagementNotAvailable = new StateAudiomanagementNotAvailable(this, this.hsm, "stateAudiomanagementNotAvailable", this.stateWork);
        this.stateDSINotAvailable = new StateDSINotAvailable(this, this.hsm, "stateDSINotAvailable", this.stateWork);
        this.connection = 0;
        this.isRepeat = false;
        this.isRepeatAltRouteCalcAnnouncement = false;
        this.isTriggerAltRouteCalcAnnouncement = false;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    void traceState(AbstractHsmState abstractHsmState, String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    void infoLogAudioState(AbstractHsmState abstractHsmState) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.info(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append("AudioState: ");
            logMessage.append(this.audioState);
            logMessage.log();
        }
    }

    void initDSI() {
        this.services = new Services(this);
    }

    DSINavigation getDsiNavigation() {
        return this.services.getNavigation();
    }

    public static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[HsmTargetAudio] ");
        }
        return LOGGER;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetAudio.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetAudio: resetting values after DSI restart");
            }
            this.releaseAudioConnection();
            this.resetHsmToState(this.stateIdle);
            this.initLocalVariables();
            this.services.initDsiNavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetAudio: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void releaseAudioConnection() {
        block2: {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
            eventGeneric.setInt(0, this.connection);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                if (!this.isTraceEnabled()) break block2;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("HsmTargetAudio: ").append(genericEventException.getMessage());
                this.trace(stringBuffer.toString());
            }
        }
    }

    private void initLocalVariables() {
        this.connection = 0;
        this.isRepeat = false;
        this.isRepeatAltRouteCalcAnnouncement = false;
        this.isTriggerAltRouteCalcAnnouncement = false;
        this.audioState = 0;
        this.isRgActive = false;
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

