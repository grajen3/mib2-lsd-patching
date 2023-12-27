/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.setup.HsmTargetSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateSetupInitPersistence
extends AbstractHsmState {
    private HsmTargetSetup myTarget;
    private EventGeneric blockedGoOnEvent = null;
    private int loopCounter = 0;

    StateSetupInitPersistence(HsmTargetSetup hsmTargetSetup, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetSetup;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.blockedGoOnEvent = eventGeneric;
                this.restorePersistence();
                this.waitingForPersistence();
                break;
            }
            case 4: {
                this.myTarget.traceState(this, "HSM_EXIT");
                break;
            }
            case 100103: {
                this.myTarget.traceState(this, "EV_NAVI_SETUP_WAIT_FOR_PERSISTENCE_LOOP");
                this.waitingForPersistence();
                break;
            }
            default: {
                hsmState = this.myTarget.getWorkStateParent();
            }
        }
        return hsmState;
    }

    private void restorePersistence() {
        this.myTarget.traceState(this, "restorePersistence");
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace("Navi persistence contained: ");
            this.myTarget.trace(this.myTarget.GUIDANCE_OPTIONS.toString());
            this.myTarget.trace(this.myTarget.PERS_DESTINPUT_SETUP.toString());
        }
    }

    private void waitingForPersistence() {
        this.myTarget.traceState(this, "waitingForPersistence");
        if (this.loopCounter >= 60) {
            this.myTarget.warn("A Timeout occured in loop with: EV_NAVI_SETUP_WAIT_FOR_PERSISTENCE_LOOP");
        }
        if (this.myTarget.GUIDANCE_OPTIONS.isPersistenceRestored() || this.loopCounter >= 60) {
            this.myTarget.traceState(this, "Persistence is restored.");
            this.init();
            this.initDSI();
            this.trans(this.myTarget.stateSetupMain);
        } else {
            this.blockedGoOnEvent.setBlocked(true);
            ++this.loopCounter;
            this.myTarget.startTimer(126288128, (long)0, false);
        }
    }

    private void init() {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace("Navi-Setup: init()");
        }
        ASLNavigationPoiFactory.getNavigationPoiApi().getPoiSetup().updateProperties();
        this.myTarget.GUIDANCE_OPTIONS.updateProperties();
        int n = this.myTarget.GUIDANCE_OPTIONS.getHmiAudioAnnouncementType();
        this.myTarget.setAudioVoiceAnnnouncementType(n, false);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(this.myTarget.PERS_DESTINPUT_SETUP.getLastDest());
        boolean bl = this.myTarget.PERS_DESTINPUT_SETUP.getHomeDest() != null;
        ServiceManager.aslPropertyManager.valueChangedBoolean(836, bl);
        int n2 = this.myTarget.PERS_DESTINPUT_SETUP.getLastInputMode();
        ServiceManager.aslPropertyManager.valueChangedInteger(-1024454656, n2);
        boolean bl2 = this.myTarget.PERS_DESTINPUT_SETUP.getShowSLDEHelp();
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1041231872, bl2);
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace(new StringBuffer("Target Navigation.Setup - All values restored from persistence.").append('\n').append(this.myTarget.GUIDANCE_OPTIONS.toString()).append('\n').append(this.myTarget.PERS_DESTINPUT_SETUP.toString()).toString());
        }
    }

    private void setLastInputModeToSLDE() {
        ServiceManager.aslPropertyManager.valueChangedInteger(-1024454656, 0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setLastModeDestinationInput(0);
    }

    private void initDSI() {
        block8: {
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace("Navi-Setup: initDSI()");
            }
            if (this.myTarget.dsiNavigationService != null) {
                this.myTarget.dsiNavigationService.etcSetDemoMode(false);
            } else {
                this.myTarget.trace("DSINavigation service was null!");
            }
            if (this.myTarget.dsiTmcOnRouteService != null) {
                this.myTarget.dsiTmcOnRouteService.setTmcWarningMode(this.myTarget.GUIDANCE_OPTIONS.getDsiAcousticTrafficJamWarning());
            } else {
                this.myTarget.trace("DSITmcOnRoute service was null!");
            }
            int n = ASLSystemFactory.getSystemApi().getConfiguredDistanceUnit();
            this.myTarget.setDsiDistanceUnit(n);
            this.myTarget.trace("Sending blocked NAVI_TARGET_GO_ON event back to Navi-Startup. Loop Counter: ", this.loopCounter);
            if (this.blockedGoOnEvent.isBlocked()) {
                try {
                    this.myTarget.sendBack(this.blockedGoOnEvent);
                }
                catch (GenericEventException genericEventException) {
                    if (!this.myTarget.isTraceEnabled()) break block8;
                    this.myTarget.trace().append("Navi-Startup: Exception: ").append(genericEventException.getMessage()).log();
                }
            }
        }
    }
}

