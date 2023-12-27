/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.poi.setup.HsmTargetPoiSetupFuelOptions;
import de.vw.mib.asl.internal.navigation.poi.setup.PersistedPoiSetup;
import de.vw.mib.asl.internal.navigation.setup.transformer.GasStationCollector;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupGasStationNoneOptionCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.Brand;

public class StatePoiSetupFuelOptionsWork
extends AbstractHsmState
implements CacheClient,
DSIServiceStateListener,
TargetForResetNavigation {
    private HsmTargetPoiSetupFuelOptions fuelTarget;
    private GasStationCollector[] gasStationList = new GasStationCollector[0];
    private boolean waitingForSetPreferenceResult = false;
    private int criterianumber_energy_type = 101;
    private boolean isServiceStateListenerAdded = false;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    StatePoiSetupFuelOptionsWork(HsmTargetPoiSetupFuelOptions hsmTargetPoiSetupFuelOptions, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.fuelTarget = hsmTargetPoiSetupFuelOptions;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.fuelTarget.isTraceEnabled()) {
                    this.fuelTarget.trace("Target Navigation.FuelOptions entered HSM_ENTRY.");
                }
                if (this.navigationResetParticipant != null) break;
                this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                break;
            }
            case 3: {
                if (!this.fuelTarget.isTraceEnabled()) break;
                this.fuelTarget.trace("Target Navigation.FuelOptions entered HSM_START.");
                break;
            }
            case 4: {
                if (this.fuelTarget.isTraceEnabled()) {
                    this.fuelTarget.trace("Target Navigation.FuelOptions entered HSM_EXIT.");
                }
                this.fuelTarget.removeObservers();
                if (this.navigationResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                this.navigationResetParticipant = null;
                break;
            }
            case 101001: {
                if (this.fuelTarget.isTraceEnabled()) {
                    this.fuelTarget.trace("Target Navigation.FuelOptions entered NAVI_TARGET_GO_ON.");
                }
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StatePoiSetupFuelOptionsWork.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                }
                this.fuelTarget.registerObservers();
                this.fuelTarget.blockedGoOnEvent = eventGeneric;
                this.fuelTarget.blockedGoOnEvent.setBlocked(true);
                if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
                    this.criterianumber_energy_type = 133;
                }
                this.fuelTarget.getDsiNavigation().ehGetAllBrandsOfCategory(0, this.criterianumber_energy_type);
                this.fuelTarget.trace("Target Navigation.FuelOptions finished processing NAVI_TARGET_GO_ON.");
                break;
            }
            case 1073744392: {
                this.fuelTarget.trace("Target Navigation.FuelOptions entered SET_DESTINATION_RANGE_WARNING_ENABLED.");
                boolean bl = eventGeneric.getBoolean(0);
                this.setDestinationRangeWarning(bl);
                break;
            }
            case 1073744393: {
                this.fuelTarget.trace("Target Navigation.FuelOptions entered SET_HOME_RANGE_WARNING_ENABLED.");
                boolean bl = eventGeneric.getBoolean(0);
                this.setHomeRangeWarning(bl);
                break;
            }
            case 1073744416: {
                this.fuelTarget.trace("Target Navigation.FuelOptions entered SET_PREFERRED_CHARGING_SPEED.");
                int n = eventGeneric.getInt(0);
                this.setPreferredChargingSpeed(n);
                break;
            }
            case 1073742558: {
                this.fuelTarget.trace("Target Navigation.FuelOptions entered ASL_NAVIGATION_SETUP_PREPARE_GAS_STATION_LIST.");
                this.fuelTarget.getDsiNavigation().ehGetAllBrandsOfCategory(0, this.criterianumber_energy_type);
                break;
            }
            case 1073742565: {
                this.fuelTarget.trace("Target Navigation.Setup entered ASL_NAVIGATION_SETUP_TOGGLE_GAS_STATION_LIST_ITEM.");
                this.toggleGasStation(eventGeneric);
                break;
            }
            case 1073742566: {
                this.fuelTarget.trace("Target Navigation.Setup entered ASL_NAVIGATION_SETUP_TOGGLE_GAS_STATION_NONE_OPTION.");
                this.deselectAllGasStations();
                break;
            }
            case 3499026: {
                this.dsiNavigationEhResult(0, 0);
                break;
            }
            default: {
                this.fuelTarget.trace("Target Navigation.FuelOptions entered DEFAULT event with ID:", eventGeneric.getReceiverEventId());
                hsmState = this.fuelTarget.getWorkStateParent();
            }
        }
        return hsmState;
    }

    public void dsiNavigationEhGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        this.fuelTarget.trace("Target Navigation.FuelOptions dsiNavigationEhGetAllBrandsOfCategoryResult");
        this.notifyNaviStartup();
        if (n3 != 0) {
            this.fuelTarget.error("Error! returnCode=", n3);
            return;
        }
        if (brandArray == null) {
            this.fuelTarget.error("brands == null");
            this.updateNoneOptionDatapool(false);
            return;
        }
        this.updateGasStationList(n2, brandArray);
        boolean bl = false;
        for (int i2 = 0; i2 < this.gasStationList.length; ++i2) {
            if (!this.gasStationList[i2].selected) continue;
            bl = true;
        }
        this.updateNoneOptionDatapool(bl);
    }

    public void dsiNavigationEhResult(int n, int n2) {
        this.fuelTarget.trace("Target Navigation.FuelOptions entered DSINAVIGATION_EHRESULT.");
        this.waitingForSetPreferenceResult = false;
        if (n2 != 0) {
            this.fuelTarget.error("dsiNavigationEhResult resultCode=", n2);
            this.fuelTarget.getDsiNavigation().ehGetAllBrandsOfCategory(0, this.criterianumber_energy_type);
        }
    }

    private void updateGasStationList(int n, Brand[] brandArray) {
        this.fuelTarget.trace("Target Navigation.FuelOptions entered updateGasStationList");
        if (n != this.criterianumber_energy_type) {
            this.fuelTarget.error("unknown category uid ( received -> ignore):", n);
            return;
        }
        this.gasStationList = new GasStationCollector[brandArray.length];
        for (int i2 = 0; i2 < brandArray.length; ++i2) {
            Brand brand = brandArray[i2];
            ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(brand.iconIndex, brand.subIconIndex, 0, this, new Integer(i2));
            this.gasStationList[i2] = new GasStationCollector(brand.brandUid, resourceLocator, brand.description, brand.isPreferred());
        }
        ListManager.getGenericASLList(984).updateList(this.gasStationList);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPreferredBrandUids(this.getPreferredBrandUids());
        this.fuelTarget.sendInternalEvent(1581978624, 56898816);
    }

    private void toggleGasStationItem(int n) {
        this.fuelTarget.trace("Target FuelOptions: toggleGasStationItem");
        GasStationCollector gasStationCollector = this.gasStationList[n];
        gasStationCollector.selected = !gasStationCollector.selected;
        int[] nArray = new int[this.gasStationList.length];
        boolean[] blArray = new boolean[this.gasStationList.length];
        boolean bl = false;
        for (int i2 = 0; i2 < this.gasStationList.length; ++i2) {
            nArray[i2] = this.gasStationList[i2].brandUid;
            blArray[i2] = this.gasStationList[i2].selected;
            if (!this.gasStationList[i2].selected) continue;
            bl = true;
        }
        if (bl) {
            this.updateNoneOptionDatapool(true);
        } else {
            this.updateNoneOptionDatapool(false);
        }
        this.waitingForSetPreferenceResult = true;
        this.fuelTarget.getDsiNavigation().ehSetBrandPreference(0, nArray, blArray);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPreferredBrandUids(this.getPreferredBrandUids());
        this.fuelTarget.sendInternalEvent(1581978624, 56898816);
        ListManager.getGenericASLList(984).updateList(this.gasStationList);
    }

    private void deselectAllGasStations() {
        int n;
        this.fuelTarget.trace("Target FuelOptions: deselectAllGasStations ");
        int[] nArray = new int[this.gasStationList.length];
        boolean[] blArray = new boolean[this.gasStationList.length];
        for (n = 0; n < this.gasStationList.length; ++n) {
            nArray[n] = this.gasStationList[n].brandUid;
            blArray[n] = false;
        }
        this.waitingForSetPreferenceResult = true;
        this.fuelTarget.getDsiNavigation().ehSetBrandPreference(0, nArray, blArray);
        this.updateNoneOptionDatapool(true);
        for (n = 0; n < this.gasStationList.length; ++n) {
            this.gasStationList[n].selected = false;
        }
        ListManager.getGenericASLList(984).updateList(this.gasStationList);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPreferredBrandUids(new int[0]);
        this.fuelTarget.sendInternalEvent(1581978624, 56898816);
        ListManager.getGenericASLList(984).updateList(this.gasStationList);
    }

    private void updateNoneOptionDatapool(boolean bl) {
        NavigationSetupGasStationNoneOptionCollector navigationSetupGasStationNoneOptionCollector = new NavigationSetupGasStationNoneOptionCollector();
        navigationSetupGasStationNoneOptionCollector.navigation_setup_gas_station_none_option_icon = null;
        navigationSetupGasStationNoneOptionCollector.navigation_setup_gas_station_none_option_selected = bl;
        ListManager.getGenericASLList(983).updateList(new NavigationSetupGasStationNoneOptionCollector[]{navigationSetupGasStationNoneOptionCollector});
    }

    private void toggleGasStation(EventGeneric eventGeneric) {
        if (!this.waitingForSetPreferenceResult) {
            this.toggleGasStationItem(eventGeneric.getInt(0));
        } else {
            this.fuelTarget.warn("Target Navigation.Setup - already toggling item in preferred gas station list");
        }
    }

    private void setDestinationRangeWarning(boolean bl) {
        PersistedPoiSetup.getInstance().setFuelOptionsDestinationRangeWarning(bl);
        PersistedPoiSetup.getInstance().updatePropertyFuelOptionsDestinationRangeWarning();
    }

    private void setHomeRangeWarning(boolean bl) {
        PersistedPoiSetup.getInstance().setFuelOptionsDestinationHomeWarning(bl);
        PersistedPoiSetup.getInstance().updatePropertyFuelOptionsDestinationHomeWarning();
    }

    private void setPreferredChargingSpeed(int n) {
        PersistedPoiSetup.getInstance().setPreferredChargingSpeed(n);
        PersistedPoiSetup.getInstance().updatePropertyPreferredChargingSpeed();
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.fuelTarget.trace("handleIconCacheUpdate index:", (Integer)object);
        int n = (Integer)object;
        if (n < this.gasStationList.length) {
            this.gasStationList[n].resourceLocator = resourceLocator;
            Object[] objectArray = new GasStationCollector[]{this.gasStationList[n]};
            ListManager.getGenericASLList(984).updateListItems(n, objectArray);
        } else {
            this.fuelTarget.error("Index out of bounds  index:", n);
            this.fuelTarget.error(" length:", this.gasStationList.length);
        }
    }

    public static int findIndexByBrandUid(Brand[] brandArray, int n) {
        for (int i2 = 0; i2 < brandArray.length; ++i2) {
            if (brandArray[i2].brandUid != n) continue;
            return i2;
        }
        return -1;
    }

    private int[] getPreferredBrandUids() {
        IntArrayList intArrayList = new IntArrayList();
        for (int i2 = 0; i2 < this.gasStationList.length; ++i2) {
            if (!this.gasStationList[i2].selected) continue;
            intArrayList.add(this.gasStationList[i2].brandUid);
        }
        int[] nArray = new int[intArrayList.size()];
        for (int i3 = 0; i3 < intArrayList.size(); ++i3) {
            nArray[i3] = intArrayList.get(i3);
        }
        return nArray;
    }

    private void notifyNaviStartup() {
        if (this.fuelTarget.blockedGoOnEvent != null) {
            try {
                this.fuelTarget.trace("Navi-Startup: Sending blocked GO_ON event back to Navi-Startup");
                this.fuelTarget.sendBack(this.fuelTarget.blockedGoOnEvent);
            }
            catch (GenericEventException genericEventException) {
                LogMessage logMessage = this.fuelTarget.error();
                logMessage.append(genericEventException);
                logMessage.log();
            }
            this.fuelTarget.blockedGoOnEvent = null;
        }
    }

    public HsmState dsiNavigationAsyncException(int n, String string, int n2) {
        if (n2 == 1132) {
            this.waitingForSetPreferenceResult = false;
        }
        return null;
    }

    @Override
    public void registered(String string, int n) {
        this.fuelTarget.registerDsiStateChangeListeners(string, n);
    }

    @Override
    public void unregistered(String string, int n) {
        this.fuelTarget.unregisterDsiStateChangeListeners(string, n);
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.deselectAllGasStations();
        this.setDestinationRangeWarning(true);
        this.setHomeRangeWarning(false);
        this.setPreferredChargingSpeed(2);
        this.navigationResetParticipant.notifyResetDone();
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

