/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationService;
import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.waypointmode.StateDefault;
import de.vw.mib.asl.internal.navigation.waypointmode.StateGuidance;
import de.vw.mib.asl.internal.navigation.waypointmode.StateInit;
import de.vw.mib.asl.internal.navigation.waypointmode.StateRecord;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmDataPool;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmDsiNotifier;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmModelNotifier;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;

public class HsmTargetWayPointMode
extends AbstractResettableAslHsmTarget
implements ASLComponentAPICallback {
    public static final int DESTINATION_REACHED_DISTANCE_METER;
    static final int FREE_WAYPOINTS_THRESHOLD;
    public static final int CLAMP15OFF_MAX_MIN_TO_RESUME;
    public static final String EXPORT_TOUR_FILE_SUFFIX;
    StateDefault stateDefault = new StateDefault(this, "StateDefault", this.getWorkStateParent());
    StateInit stateInit = new StateInit(this, "StateInit", (HsmState)this.stateDefault);
    StateGuidance stateGuidance = new StateGuidance(this, "StateGuidance", (HsmState)this.stateDefault);
    StateRecord stateRecord = new StateRecord(this, "StateRecord", (HsmState)this.stateDefault);
    private WpmDataPool dataPool;
    private WpmDsiNotifier dsiNotifier;
    private WpmModelNotifier modelNotifier;
    private WpmInternalAPINotifier internalAPINotifier;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public HsmTargetWayPointMode(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    void traceState(HsmState hsmState, String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(this.getShortName()).append(".").append(hsmState).append(": ").append(string).log();
        }
    }

    WpmDataPool getDataPool() {
        return this.dataPool;
    }

    void setDataPool(WpmDataPool wpmDataPool) {
        this.dataPool = wpmDataPool;
    }

    WpmDsiNotifier getDsiNotifier() {
        return this.dsiNotifier;
    }

    void setDsiNotifier(WpmDsiNotifier wpmDsiNotifier) {
        this.dsiNotifier = wpmDsiNotifier;
    }

    WpmModelNotifier getModelNotifier() {
        return this.modelNotifier;
    }

    void setModelNotifier(WpmModelNotifier wpmModelNotifier) {
        this.modelNotifier = wpmModelNotifier;
    }

    public WpmInternalAPINotifier getInternalAPINotifier() {
        return this.internalAPINotifier;
    }

    public void setInternalAPINotifier(WpmInternalAPINotifier wpmInternalAPINotifier) {
        this.internalAPINotifier = wpmInternalAPINotifier;
    }

    void changeExecutionMode(int n) {
        if (n == 1) {
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(861680896);
            ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        } else {
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(878458112);
            ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        }
        this.dataPool.setExecutionMode(n);
        this.modelNotifier.setExecutionMode(n);
        this.modelNotifier.setActionResultOk();
    }

    void requestMediaIndicationService() {
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService == null ? (class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService = HsmTargetWayPointMode.class$("de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationService")) : class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService, this);
    }

    @Override
    public void registered(Class clazz, Object object) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            ServiceManager.logger2.trace(this.getSubClassifier()).append("Registered: Class -> ").append(clazz).append(" Object -> ").append(object).log();
        }
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            ServiceManager.logger2.trace(this.getSubClassifier()).append("MediaIndicationService registered").log();
        }
        MediaIndicationService mediaIndicationService = (MediaIndicationService)object;
        mediaIndicationService.registerMountPointListenerSD(this.dataPool.getSdCardMountPoint0(), 0);
        mediaIndicationService.registerMountPointListenerSD(this.dataPool.getSdCardMountPoint1(), 1);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetWayPointMode.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetWayPointMode: resetting values after DSI restart");
            }
            this.initDSI();
            this.initLocalVariables();
            this.resetHsmToState(this.stateDefault);
        }
    }

    private void initLocalVariables() {
        block2: {
            try {
                this.stateInit.restoreExecutionMode();
            }
            catch (GenericEventException genericEventException) {
                if (!this.isTraceEnabled()) break block2;
                this.trace(new StringBuffer().append("HsmTargetWayPointMode").append(genericEventException).toString());
            }
        }
    }

    private void initDSI() {
        this.dsiNotifier.initDSI();
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

