/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.CoreServiceMODFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control.CoreServiceMODTransformer;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.states.CoreServiceMODTarget;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceState;

public class CoreServiceMODController {
    private final String _classname = super.getClass().getName();
    private final CoreServiceMODTarget _target;
    private Device _modDevice;
    private Service[] _modServiceList;
    private CoreServiceMODTransformer _transformer;
    private int _status;
    private int _serviceState = 0;
    private boolean _coreServiceAvailability;
    private boolean _roamingHandlingInProgress;
    private boolean _roamingEnabled;
    private ObjectIntOptHashMap _roamingAppList;
    private boolean _roamingPending;
    private OSRNotifyPropertiesSL[] _osrNotifyProperties;
    private ObjectIntOptHashMap _precheckResult;
    private boolean _privacyMode;
    private int _serviceListState = 1;
    private int _serviceListStatus = 0;

    public CoreServiceMODController(CoreServiceMODTarget coreServiceMODTarget) {
        this._target = coreServiceMODTarget;
    }

    private CoreServiceMODTransformer getTransformer() {
        if (this._transformer == null) {
            this._transformer = new CoreServiceMODTransformer();
        }
        return this._transformer;
    }

    private ObjectIntOptHashMap getRoamingAppList() {
        if (this._roamingAppList == null) {
            this._roamingAppList = new ObjectIntOptHashMap();
        }
        return this._roamingAppList;
    }

    private ObjectIntOptHashMap getPrecheckResult() {
        if (this._precheckResult == null) {
            this._precheckResult = new ObjectIntOptHashMap();
        }
        return this._precheckResult;
    }

    private boolean checkIfBitSetForPrimaryUserDeviceValid(int n, int n2) {
        return n2 != n && Util.isBitSet(32, n2) && !Util.isBitSet(32, n) && !Util.isBitSet(64, n);
    }

    private boolean isOwnerVerifiedList() {
        return !Util.isNullOrEmpty(this._modServiceList) && Util.isBitSet(256, this._serviceState);
    }

    public void reset() {
        this._roamingEnabled = false;
        this._roamingHandlingInProgress = false;
        this.getRoamingAppList().clear();
        this._serviceListState = 1;
    }

    public void fireUpdates(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray) {
        if (!Util.isNullOrEmpty(this._modServiceList) && !Util.isNullOrEmpty(oSRNotifyPropertiesSLArray)) {
            this._modDevice = this.getTransformer().transformToDevice(this._modServiceList, this._modDevice);
            if (this._modDevice != null) {
                CoreServiceMODFactory.getNotifier().updateDevice(this._modDevice, this._target.getDeviceID());
            }
        }
    }

    public void sendRegistrationStatus() {
        this._target.info().append(this._classname).append(new StringBuffer().append(".sendRegistrationStatus( status = ").append(this._status).append(", deviceID = ").append(this._target.getDeviceID()).append(")").toString()).log();
        CoreServiceMODFactory.getNotifier().updateRegistrationStatus(this._status, this._target.getDeviceID());
    }

    public void handleRoaming(boolean bl) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".handleRoaming(").append(bl).append(")").toString()).log();
        }
        if (this._roamingEnabled != bl) {
            this._roamingEnabled = bl;
            if (this.isOwnerVerifiedList()) {
                this._roamingHandlingInProgress = true;
                int n = this._modServiceList.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    if (this._modServiceList[i2].getServiceState() == 6) continue;
                    int n2 = 1;
                    if (this._roamingEnabled) {
                        n2 = Util.setBit(2, n2);
                    }
                    if (this._target.getDSIOnlineServiceRegistration() == null) continue;
                    this._target.getDSIOnlineServiceRegistration().setServiceState(this._modServiceList[i2].getServiceID(), n2);
                    this.getRoamingAppList().put(this._modServiceList[i2].getServiceID(), n2);
                }
            } else {
                this._roamingPending = true;
            }
        }
    }

    public boolean checkIfServiceStateBitSet(int n) {
        return Util.isBitSet(1 << n, this._serviceState);
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".getOnlineApplicationResponse(").append(oSRApplication != null ? oSRApplication.toString() : "NULL").append(")").toString()).log();
        }
        if (oSRApplication != null && !Util.isNullOrEmpty(oSRApplication.getId()) && oSRApplication.getId().equalsIgnoreCase("hmi") && !Util.isNullOrEmpty(oSRApplication.getPropertyList())) {
            int n = oSRApplication.getPropertyList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!oSRApplication.getPropertyList()[i2].getKey().equalsIgnoreCase("CCUhasCoreServices") || Util.isNullOrEmpty(oSRApplication.getPropertyList()[i2].getValue())) continue;
                if (oSRApplication.getPropertyList()[i2].getValue().equalsIgnoreCase("NoCS")) {
                    CoreServiceMODFactory.getNotifier().updateDeviceStatus(0, 2);
                }
                this._target.getDSIOnlineServiceRegistration().setInventoryFinished(false);
            }
        }
    }

    public void setServiceStateResponse(OSRServiceState oSRServiceState) {
        Service service;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".setServiceStateResponse(").append(oSRServiceState != null ? oSRServiceState.toString() : "NULL").append(")").toString()).log();
        }
        Service service2 = service = oSRServiceState != null ? this.getServiceWithID(oSRServiceState.getServiceID()) : null;
        if (oSRServiceState != null && !Util.isNullOrEmpty(oSRServiceState.getServiceID()) && CoreServiceMappingTable.isValidService(oSRServiceState.getServiceID()) && this.getServiceWithID(oSRServiceState.getServiceID()) != null) {
            if (service != null && oSRServiceState.getServiceListEntry() != null) {
                service.setEnabledState(this.getTransformer().getEnabledServiceState(oSRServiceState.getServiceListEntry().getVehicleLocalServiceState()));
            }
            if (oSRServiceState.getServiceListEntry() != null && this._roamingHandlingInProgress && this.getRoamingAppList().containsKey(oSRServiceState.getServiceID()) && this.getRoamingAppList().get(oSRServiceState.getServiceID()) == oSRServiceState.getServiceListEntry().getVehicleLocalServiceState()) {
                this.getRoamingAppList().remove(oSRServiceState.getServiceID());
                boolean bl = this._roamingHandlingInProgress = !this.getRoamingAppList().isEmpty();
                if (!this._roamingHandlingInProgress) {
                    this._modServiceList = this.getTransformer().updateServices(this._osrNotifyProperties, this._modServiceList, this._serviceState, this.getRoamingEnabled());
                    this.fireUpdates(this._osrNotifyProperties);
                }
            } else {
                CoreServiceMODFactory.getNotifier().serviceStateResponse(service);
            }
        } else {
            CoreServiceMODFactory.getNotifier().serviceStateResponse(service);
        }
    }

    public void precheckOnlineServiceRequest(String string) {
        if (!Util.isNullOrEmpty(string)) {
            int n = this.getPrecheckResult().containsKey(string) ? this.getPrecheckResult().get(string) : 59;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1568276224);
            eventGeneric.setObject(0, string);
            eventGeneric.setInt(1, n);
            this._target.triggerMe(eventGeneric, -1568276224);
        }
    }

    public void precheckOnlineServiceResponse(OSRServiceState[] oSRServiceStateArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".precheckOnlineServiceResponse()").log();
        }
        if (!Util.isNullOrEmpty(oSRServiceStateArray)) {
            int n = CoreServiceMappingTable.convertToInternalResultType(oSRServiceStateArray[0].getErrorCode());
            Service service = this.getServiceWithID(oSRServiceStateArray[0].getServiceID());
            if (service == null) {
                n = 59;
            }
            if (n == 3 && oSRServiceStateArray[0].getServiceListEntry().getLicense() != null) {
                n = 50;
            }
            CoreServiceMODFactory.getNotifier().checkServiceStatusResponse(service != null ? service.getServiceID() : "", n);
        }
    }

    public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateServiceList(").append(Util.isNullOrEmpty(oSRServiceListEntryArray) ? 0 : oSRServiceListEntryArray.length).append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(oSRServiceListEntryArray)) {
            this._modServiceList = this.getTransformer().transformToServices(oSRServiceListEntryArray, this._modServiceList, this._target.getDeviceID());
            this._modServiceList = this.getTransformer().updateServices(this._osrNotifyProperties, this._modServiceList, this._serviceState, this.getRoamingEnabled());
            if (this._roamingPending && this.isOwnerVerifiedList()) {
                this.handleRoaming(this._roamingEnabled);
                this._roamingPending = false;
            } else {
                this.fireUpdates(this._osrNotifyProperties);
            }
        }
    }

    public void updateServiceState(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateServiceState(").append(n).append(")").toString()).log();
        }
        if (this._serviceState == 0) {
            this._modDevice = this.getTransformer().transformToDevice(null, this._modDevice);
            if (this._modDevice != null) {
                CoreServiceMODFactory.getNotifier().updateDevice(this._modDevice, this._target.getDeviceID());
            }
        }
        if (this._serviceState != n) {
            if (this.checkIfBitSetForPrimaryUserDeviceValid(n, this._serviceState)) {
                CoreServiceMODFactory.getNotifier().updatePrimaryUserDeviceStatus(true, this._target.getDeviceID());
            }
            if (!Util.isBitSet(16, n)) {
                boolean bl = false;
                if (Util.isBitSet(256, n)) {
                    if (this._status != 1) {
                        this._status = 1;
                        bl = true;
                    }
                } else if (Util.isBitSet(256, n)) {
                    if (this._status != 2) {
                        this._status = 2;
                        this._coreServiceAvailability = true;
                        bl = true;
                    }
                } else if (!this._coreServiceAvailability && !Util.isNullOrEmpty(this._modServiceList)) {
                    if (this._status != 3) {
                        this._status = 3;
                        bl = true;
                    }
                } else {
                    this._status = 0;
                    bl = true;
                }
                if (this.getDevice() == null) {
                    this._modDevice = this.getTransformer().transformToDevice(this._modServiceList, this._modDevice);
                }
                if (bl && this.getDevice().isMainDevice()) {
                    this.sendRegistrationStatus();
                }
                this.updateServiceListState(n);
                this._serviceState = n;
                this._modServiceList = this.getTransformer().updateServices(this._osrNotifyProperties, this._modServiceList, this._serviceState, this.getRoamingEnabled());
                this.fireUpdates(this._osrNotifyProperties);
            }
            this._serviceState = n;
        }
    }

    public void updateServiceListState(int n) {
        if (!Util.isBitSet(16, n)) {
            int n2 = this._serviceListStatus;
            if (Util.isBitSet(4, n)) {
                this._serviceListState = 3;
                if (Util.isBitSet(1, n)) {
                    n2 = 3;
                }
                if (Util.isBitSet(256, n)) {
                    n2 = 4;
                }
            } else if (Util.isBitSet(2, n)) {
                this._serviceListState = 2;
                if (Util.isBitSet(1, n)) {
                    n2 = 1;
                }
                if (Util.isBitSet(256, n)) {
                    n2 = 2;
                }
            } else {
                this._serviceListState = 2;
                if (Util.isBitSet(1, n)) {
                    n2 = 1;
                }
            }
            CoreServiceMODFactory.getNotifier().updateServiceListState(this._serviceListState, this._target.getDeviceID());
            if (!Util.isNullOrEmpty(this._modServiceList) && !Util.isNullOrEmpty(this._osrNotifyProperties) && n2 != this._serviceListStatus) {
                this._serviceListStatus = n2;
                CoreServiceMODFactory.getNotifier().updateCumulativeServiceListState(this._serviceListStatus, this._target.getDeviceID());
            }
        }
    }

    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray) {
        this.setPrivacyMode(this.getTransformer().checkForPrivacyModeActiveStatus(oSRNotifyPropertiesSLArray));
        this._precheckResult = this.getTransformer().updateServicesReasonResult(oSRNotifyPropertiesSLArray, this.getPrecheckResult());
        if (!Util.isNullOrEmpty(this._modServiceList) && !this._roamingPending) {
            this._modServiceList = this.getTransformer().updateServices(oSRNotifyPropertiesSLArray, this._modServiceList, this._serviceState, this.getRoamingEnabled());
            this.fireUpdates(oSRNotifyPropertiesSLArray);
            CoreServiceMODFactory.getNotifier().updateCumulativeServiceListState(this._serviceListStatus, this._target.getDeviceID());
        } else if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateServices: ignoring ").append(oSRNotifyPropertiesSLArray.length).append(" OSRNotifyPropertiesSL because of _roamingPending").log();
        }
        this._osrNotifyProperties = oSRNotifyPropertiesSLArray;
    }

    public boolean getRoamingEnabled() {
        return this._roamingEnabled;
    }

    public Device getDevice() {
        return this._modDevice;
    }

    public Service[] getServiceList() {
        return this._modServiceList;
    }

    public Service getServiceWithID(String string) {
        if (!Util.isNullOrEmpty(this._modServiceList) && !Util.isNullOrEmpty(string)) {
            int n = this._modServiceList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (this._modServiceList[i2] == null || !this._modServiceList[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this._modServiceList[i2];
            }
        }
        return null;
    }

    public boolean isPrivacyMode() {
        return this._privacyMode;
    }

    public void setPrivacyMode(boolean bl) {
        if (this._privacyMode != bl) {
            this._privacyMode = bl;
            CoreServiceMODFactory.getNotifier().updatePrivacyModeStatus(this.isPrivacyMode(), this._target.getDeviceID());
        }
    }

    public void asyncException(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".asyncException(").append(n).append(", ").append(n2).append(")").toString()).log();
        }
        if (n == 8304) {
            switch (n2) {
                case 1001: {
                    break;
                }
                case 1002: {
                    break;
                }
                case 1042: {
                    CoreServiceMODFactory.getNotifier().serviceStateResponse(null);
                    break;
                }
                case 1011: {
                    CoreServiceMODFactory.getNotifier().validateOwnerResponse(2);
                    break;
                }
                case 1016: {
                    CoreServiceMODFactory.getNotifier().resetToFactorSettingsResponse(this._target.getDeviceID(), null, 29);
                    break;
                }
                case 1017: {
                    CoreServiceMODFactory.getNotifier().downloadImageResponse("", "", "", null, 6);
                    break;
                }
                case 1035: {
                    CoreServiceMODFactory.getNotifier().getServiceURLResponse("", "", 29);
                    break;
                }
                case 1038: 
                case 1039: 
                case 1040: {
                    CoreServiceMODFactory.getNotifier().checkServiceStatusResponse("", CoreServiceMappingTable.convertToInternalResultType(29));
                    break;
                }
                case 1041: {
                    CoreServiceMODFactory.getNotifier().forceOwnerValidation(29);
                    break;
                }
                case 1055: {
                    CoreServiceMODFactory.getNotifier().calculateSPinHashResponse("", "", "", 0, "", 29);
                    break;
                }
                case 1054: {
                    CoreServiceMODFactory.getNotifier().setSPinResponse("", 0, 29);
                    break;
                }
                case 1003: 
                case 1005: 
                case 1006: 
                case 1009: 
                case 1012: 
                case 1014: 
                case 1018: 
                case 1019: 
                case 1020: 
                case 1021: 
                case 1022: 
                case 1023: 
                case 1024: 
                case 1025: 
                case 1026: 
                case 1027: 
                case 1028: 
                case 1030: 
                case 1031: 
                case 1032: 
                case 1033: 
                case 1034: 
                case 1036: {
                    break;
                }
            }
        } else {
            switch (n) {
                default: 
            }
        }
    }
}

