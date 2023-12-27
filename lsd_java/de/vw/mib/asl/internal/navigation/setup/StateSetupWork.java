/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.setup.HsmTargetSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavVersionInfo;

public class StateSetupWork
extends AbstractHsmState {
    private HsmTargetSetup myTarget;

    StateSetupWork(HsmTargetSetup hsmTargetSetup, Hsm hsm, String string, HsmState hsmState) {
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
                break;
            }
            case 4: {
                this.myTarget.traceState(this, "HSM_EXIT");
                this.myTarget.removeObservers();
                break;
            }
            case 101003: {
                this.myTarget.registerDsiStateChangeListener();
                break;
            }
            case 101001: {
                this.myTarget.traceState(this, "NAVI_TARGET_GO_ON");
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
                    this.myTarget.disableManeuverViewGeneration(false);
                }
                this.registerAslNavInternalServices();
                this.setDefaultLocation();
                this.myTarget.registerObservers();
                this.myTarget.registerASLServices();
                this.trans(this.myTarget.stateSetupInitPersistence);
                break;
            }
            default: {
                this.myTarget.traceState(this, "default");
                hsmState = this.myTarget.getWorkStateParent();
            }
        }
        return hsmState;
    }

    private void registerAslNavInternalServices() {
        this.myTarget.traceState(this, "registerAslNavInternalServices()");
        ASLNavigationEventFactory.registerService(409220352, 1481315328);
    }

    private void setDefaultLocation() {
        this.myTarget.traceState(this, "setDefaultLocation");
        boolean bl = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(0);
        int n = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(2);
        int n2 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(3);
        int n3 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(5);
        boolean bl2 = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(4);
        int n4 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(1);
        int n5 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(0);
        int n6 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(4);
        int n7 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(new double[]{n, n2, n3}, bl);
        int n8 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(new double[]{n4, n5, n6}, bl2);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n7, n8);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDefaultLocation(iLocationWrapper.getLocation());
    }

    public void dsiAdbSetupUpdateSortOrder(int n, int n2) {
        this.myTarget.traceState(this, "dsiAdbSetupUpdateSortOrder");
        if (n != 0) {
            if (n == 3) {
                this.myTarget.traceState(this, "Sort order is SORTORDER_DEFAULTLASTNAME_COMMA_FIRSTNAME.");
                ServiceManager.aslPropertyManager.valueChangedInteger(974, 0);
            } else if (n == 2) {
                this.myTarget.traceState(this, "Sort order is SORTORDER_DEFAULTFIRSTNAME_LASTNAME.");
                ServiceManager.aslPropertyManager.valueChangedInteger(974, 1);
            } else {
                this.myTarget.error("Navi-Setup#convertContactsNameRepresentationFromSetterToGetter Set contacts sort order to somethink wrong");
                ServiceManager.aslPropertyManager.valueChangedInteger(974, 0);
            }
        } else {
            this.myTarget.traceState(this, "Sort order came with Constants.SORTORDER_DEFAULT -> Ignoring update.");
        }
    }

    public HsmState dsiNavigationUpdateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateEtcVersionInfo");
        if (navVersionInfo != null && navVersionInfo.getNavVersion() != null && navVersionInfo.getNavVersion().length >= 1) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < navVersionInfo.getNavVersion().length; ++i2) {
                if (i2 > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(navVersionInfo.getNavVersion()[i2]);
            }
            String string = stringBuffer.toString();
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(429736192);
            eventGeneric.setString(0, string);
            this.myTarget.send(eventGeneric);
            ServiceManager.aslPropertyManager.valueChangedString(972, string);
        }
        return null;
    }

    public HsmState dsiNavigationUpdateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateEtcAvailablePersonalPOIDataBases");
        if (n == 1) {
            if (navDataBaseArray == null || navDataBaseArray.length == 0) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(952, false);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(952, true);
            }
            this.myTarget.currentlyInstalledPPois = navDataBaseArray;
        }
        this.myTarget.setDSICurrentPPOIApproachWarningStatus();
        return null;
    }
}

