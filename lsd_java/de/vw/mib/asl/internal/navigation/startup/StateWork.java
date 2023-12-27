/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.transformer.CalculatedRouteDetailsCollector;
import de.vw.mib.asl.internal.navigation.guidance.transformer.VZACollector;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiPitStopItemCollector;
import de.vw.mib.asl.internal.navigation.startup.HsmTargetNavigation;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchLocationCollector;
import org.dsi.ifc.navigation.BapManeuverDescriptor;

public final class StateWork
extends AbstractHsmState {
    private final HsmTargetNavigation myTarget;

    StateWork(HsmTargetNavigation hsmTargetNavigation, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetNavigation;
        this.initListValues();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace("Target Navigation entered HSM_ENTRY.");
                break;
            }
            case 3: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace("Target Navigation entered HSM_START.");
                break;
            }
            case 4: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace("Target Navigation entered HSM_EXIT.");
                }
                this.myTarget.removeObservers();
                break;
            }
            case 101001: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace("Target Navigation entered NAVI_TARGET_GO_ON.");
                }
                this.initPropertyValues();
                this.myTarget.addObservers();
                break;
            }
            case 1073742284: {
                this.myTarget.trace("Target Navigation entered ASL_NAVIGATION_RESET_INFO_CODE.");
                ServiceManager.aslPropertyManager.valueChangedInteger(755, 0);
                break;
            }
            case 1073742283: {
                this.myTarget.trace("Target Navigation entered ASL_NAVIGATION_RESET_ERROR_CODE.");
                ServiceManager.aslPropertyManager.valueChangedInteger(754, 0);
                break;
            }
            default: {
                this.myTarget.trace(new StringBuffer().append("Target Navigation entered DEFAULT event with ID: ").append(eventGeneric.getReceiverEventId()).toString());
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        if (n != 1) {
            return;
        }
        this.myTarget.trace("Target Navigation entered UPDATEBAPMANEUVERDESCRIPTOR.");
        if (bapManeuverDescriptorArray != null) {
            for (int i2 = 0; i2 < bapManeuverDescriptorArray.length; ++i2) {
                if (bapManeuverDescriptorArray[i2].mainElement != 132) continue;
                ServiceManager.aslPropertyManager.valueChangedInteger(755, 5);
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.info(new StringBuffer().append("MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_VIGNETTE received.").append(bapManeuverDescriptorArray[i2]).toString());
                break;
            }
        }
    }

    public void dsiNavigationRgException(int n) {
        this.myTarget.trace("Target Navigation entered DSINAVIGATION_RGEXCEPTION.");
        switch (n) {
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(754, 2);
                break;
            }
            default: {
                this.myTarget.warn(new StringBuffer().append("Target Navigation - unhandled RouteGuidanceException: ").append(n).toString());
            }
        }
    }

    public void dsiGeneralVehicleStatesUpdateVehicleStandstill(boolean bl, int n) {
        if (n != 1) {
            return;
        }
        this.myTarget.trace("Target Navigation entered DSIGENERALVEHICLESTATES_UPDATEVEHICLESTANDSTILL.");
        if (!bl) {
            ServiceManager.aslPropertyManager.valueChangedInteger(755, 1);
        }
    }

    private void initListValues() {
        Object[] objectArray = ServiceManager.configManagerDiag.isFeatureFlagSet(75) ? new PoiPitStopItemCollector[5] : new PoiPitStopItemCollector[]{new PoiPitStopItemCollector(null, ""), new PoiPitStopItemCollector(null, ""), new PoiPitStopItemCollector(null, "")};
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(75)) {
            objectArray[3] = new PoiPitStopItemCollector(null, "");
            objectArray[4] = new PoiPitStopItemCollector(null, "");
        }
        ListManager.getGenericASLList(950).updateList(objectArray);
        Object[] objectArray2 = new VZACollector[]{new VZACollector(), new VZACollector(), new VZACollector()};
        ListManager.getGenericASLList(833).updateList(objectArray2);
        ListManager.getGenericASLList(2498).updateList(new Object[]{null, null, null, null});
        NavigationPOISearchLocationCollector navigationPOISearchLocationCollector = new NavigationPOISearchLocationCollector();
        navigationPOISearchLocationCollector.navigation_poi_search_location_address_details_for_fix_formatter = new FixFormatterFieldDataImpl();
        ListManager.getGenericASLList(3099).updateList(new Object[]{navigationPOISearchLocationCollector});
        Object[] objectArray3 = new CalculatedRouteDetailsCollector[5];
        for (int i2 = 0; i2 < objectArray3.length; ++i2) {
            objectArray3[i2] = new CalculatedRouteDetailsCollector();
        }
        ListManager.getGenericASLList(822).updateList(objectArray3);
    }

    private void initPropertyValues() {
        int n = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
        this.myTarget.trace("TargetNavigation.StateWork: Set FixFormatter naming rule variant offset to ", n);
        ServiceManager.aslPropertyManager.valueChangedInteger(3963, n);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-235991040, NavigationConfiguration.LOCATIONINPUT_FEATURE_AVAILABLE);
    }
}

