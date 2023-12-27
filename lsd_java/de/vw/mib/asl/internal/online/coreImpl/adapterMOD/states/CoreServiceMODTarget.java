/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD.states;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.CoreServiceMODFactory;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class CoreServiceMODTarget
extends AbstractTarget
implements DSIServiceStateListener {
    private final String _classname = super.getClass().getName();
    private DSIOnlineServiceRegistration _dsiOnlineServiceRegistration;
    private DSIListener _dsiOnlineServiceRegistrationListener;
    private final int _deviceID;
    public final int[] DSI_ATTR = new int[]{6, 7, 9, 11};
    final int[] OBSERVED_EVENTS = new int[]{-1239079424};
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistration;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener;

    public CoreServiceMODTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._deviceID = 2;
    }

    public void startUp() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startUp()").log();
        }
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = CoreServiceMODTarget.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration, this);
        this.addObservers(this.OBSERVED_EVENTS);
    }

    private void shutDown() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".shutDown()").log();
        }
        this.removeObservers(this.OBSERVED_EVENTS);
        CoreServiceFactory.getAdapterRegister().unRegisterAdapter(this.getDeviceID());
        ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = CoreServiceMODTarget.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration, this);
    }

    private void initializeDSI() {
        LogMessage logMessage;
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".initializeDSI()").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this._dsiOnlineServiceRegistration = (DSIOnlineServiceRegistration)dSIProxy.getService(this, class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = CoreServiceMODTarget.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration);
        this._dsiOnlineServiceRegistrationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener = CoreServiceMODTarget.class$("org.dsi.ifc.online.DSIOnlineServiceRegistrationListener")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener);
        if (this._dsiOnlineServiceRegistrationListener != null) {
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener = CoreServiceMODTarget.class$("org.dsi.ifc.online.DSIOnlineServiceRegistrationListener")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener, this._dsiOnlineServiceRegistrationListener);
        } else {
            logMessage = this.warn();
            logMessage.append(this._classname).append(".initializeDSI() Invalid DSIOnlineServiceRegistrationListener").log();
        }
        if (this._dsiOnlineServiceRegistration != null) {
            this._dsiOnlineServiceRegistration.setNotification(this.DSI_ATTR, this._dsiOnlineServiceRegistrationListener);
        } else {
            logMessage = this.warn();
            logMessage.append(this._classname).append(".initializeDSI() Invalid DSIOnlineServiceRegistration").log();
        }
    }

    private void deInitializeDSI() {
        this._dsiOnlineServiceRegistration = null;
        this._dsiOnlineServiceRegistrationListener = null;
    }

    public DSIOnlineServiceRegistration getDSIOnlineServiceRegistration() {
        if (this._dsiOnlineServiceRegistration == null) {
            this.warn().append(this._classname).append(".getDSIOnlineServiceRegistration() Invalid DSI instance").log();
        }
        return this._dsiOnlineServiceRegistration;
    }

    public void tranformToInternalImage(String string) {
        if (!Util.isNullOrEmpty(string) && string.lastIndexOf(47) > -1) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1239079424);
            eventGeneric.setSenderEventId(-1585053440);
            eventGeneric.setSenderTargetId(this.getDefaultTargetId());
            eventGeneric.setString(0, string.substring(0, string.lastIndexOf(47)));
            eventGeneric.setString(1, string.substring(string.lastIndexOf(47) + 1));
            this.sendSafe(eventGeneric);
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".dsiOnlineServiceRegistrationDownloadResponse( ").append(string).append(") -> File Path is not valid to tranform into a ResourceLocator").toString()).log();
        }
    }

    public int getDeviceID() {
        return 2;
    }

    public void setApplicationProperty(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".setApplicationProperty(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(")").log();
        }
        if (!Util.isNullOrEmpty(string)) {
            OSRApplicationProperties[] oSRApplicationPropertiesArray = new OSRApplicationProperties[]{new OSRApplicationProperties(1, "CCUhasCoreServices", string)};
            if (this.getDSIOnlineServiceRegistration() != null) {
                this.getDSIOnlineServiceRegistration().setApplicationProperties("hmi", oSRApplicationPropertiesArray);
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".registered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[92]) {
            this.initializeDSI();
            CoreServiceFactory.getExternalRegister().registerExternal(CoreServiceMODFactory.getExternal(this));
            CoreServiceFactory.getAdapterRegister().isReady(this.getDeviceID());
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".unregistered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[92]) {
            this.deInitializeDSI();
        }
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public int getDefaultTargetId() {
        return 896407040;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
                this.info().append("**** MOD Available ****").log();
                CoreServiceFactory.getAdapterRegister().registerAdapter(this.getDeviceID(), 5, CoreServiceMODFactory.getAdapter(this));
                this.startUp();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_OFF)").log();
                }
                this.shutDown();
                break;
            }
            case 100001: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".handle(OnlineCoreServicesEvents.EV_ONLINE_CORE_SERVICE_RESOURCE_LOCATOR_RESULT)").log();
                }
                String string = eventGeneric.getString(0);
                String string2 = eventGeneric.getString(1);
                Object[] objectArray = (ResourceLocator[])eventGeneric.getObject(3);
                String string3 = !Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(string2) ? new StringBuffer().append(string).append("/").append(string2).toString() : "";
                CoreServiceMODFactory.getNotifier().downloadImageResponse("", null, string3, (ResourceLocator)(Util.isNullOrEmpty(objectArray) ? null : objectArray[0]), 1);
                break;
            }
            case 100002: {
                String string = (String)eventGeneric.getObject(0);
                int n = eventGeneric.getInt(1);
                CoreServiceMODFactory.getNotifier().checkServiceStatusResponse(!Util.isNullOrEmpty(string) ? string : "", n);
                break;
            }
        }
    }

    public void dsiOnlineServiceRegistrationAsyncException(int n, String string, int n2) {
        LogMessage logMessage = this.warn();
        logMessage.append(this._classname).append(".dsiOnlineServiceRegistrationAsyncException(Code=").append(n).append(", Message=").append(string).append(", Type=").append(n2).append(")").log();
        CoreServiceMODFactory.getController(this).asyncException(n, n2);
    }

    public void dsiOnlineServiceRegistrationGetOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
    }

    public void dsiOnlineServiceRegistrationGetOnlineApplicationResponse(OSRApplication oSRApplication) {
        CoreServiceMODFactory.getController(this).getOnlineApplicationResponse(oSRApplication);
    }

    public void dsiOnlineServiceRegistrationActivateLicenseResponse(OSRLicense oSRLicense, int n) {
    }

    public void dsiOnlineServiceRegistrationGetServiceListResponse(int n) {
    }

    public void dsiOnlineServiceRegistrationValidatePairingCodeResponse(String string, int n) {
    }

    public void dsiOnlineServiceRegistrationSetCredentialResponse(String string, int n) {
    }

    public void dsiOnlineServiceRegistrationCheckValidCredentialResponse(String string, int n) {
    }

    public void dsiOnlineServiceRegistrationDownloadResponse(String string, String string2, int n) {
        if (Util.isNullOrEmpty(string) || Util.isNullOrEmpty(string2)) {
            CoreServiceMODFactory.getNotifier().downloadImageResponse("", string, string2, null, 0);
            return;
        }
        switch (n) {
            case 1: {
                this.tranformToInternalImage(string2);
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                CoreServiceMODFactory.getNotifier().downloadImageResponse("", string, string2, null, CoreServiceMappingTable.convertToInternalResultType(n));
                break;
            }
        }
    }

    public void dsiOnlineServiceRegistrationDownloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        CoreServiceMODFactory.getNotifier().downloadImageResponse(string, string2, string3, resourceLocator, n);
    }

    public void dsiOnlineServiceRegistrationValidateOwnerResponse(int n) {
        CoreServiceMODFactory.getNotifier().validateOwnerResponse(n);
    }

    public void dsiOnlineServiceRegistrationCheckOwnersVerificationResponse(int n) {
        CoreServiceMODFactory.getNotifier().userVerificationResponse(n);
    }

    public void dsiOnlineServiceRegistrationCreateUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
    }

    public void dsiOnlineServiceRegistrationCreateUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
    }

    public void dsiOnlineServiceRegistrationCheckPasswordResponse(OSRUser oSRUser, int n) {
    }

    public void dsiOnlineServiceRegistrationCheckPairingCodeResponse(OSRUser oSRUser, int n) {
    }

    public void dsiOnlineServiceRegistrationSetPrivacyFlagsResponse(OSRUser oSRUser) {
    }

    public void dsiOnlineServiceRegistrationSetAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
    }

    public void dsiOnlineServiceRegistrationLoginResponse(OSRUser oSRUser, int n) {
    }

    public void dsiOnlineServiceRegistrationLogoutResponse(OSRUser oSRUser, int n) {
    }

    public void dsiOnlineServiceRegistrationLogoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
    }

    public void dsiOnlineServiceRegistrationGetUsersResponse(OSRUser[] oSRUserArray) {
    }

    public void dsiOnlineServiceRegistrationRemoveUserResponse(OSRUser oSRUser, int n) {
    }

    public void dsiOnlineServiceRegistrationPerformPortalRegistrationResponse(String string, int n) {
    }

    public void dsiOnlineServiceRegistrationPrecheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
        OSRServiceState[] oSRServiceStateArray = null;
        if (oSRServiceState != null) {
            oSRServiceStateArray = new OSRServiceState[]{oSRServiceState};
        }
        CoreServiceMODFactory.getController(this).precheckOnlineServiceResponse(oSRServiceStateArray);
    }

    public void dsiOnlineServiceRegistrationPrecheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        OSRServiceState[] oSRServiceStateArray = null;
        if (oSRServiceState != null) {
            oSRServiceStateArray = new OSRServiceState[]{oSRServiceState};
        }
        CoreServiceMODFactory.getController(this).precheckOnlineServiceResponse(oSRServiceStateArray);
    }

    public void dsiOnlineServiceRegistrationPrecheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        CoreServiceMODFactory.getController(this).precheckOnlineServiceResponse(oSRServiceStateArray);
    }

    public void dsiOnlineServiceRegistrationGetLicenseResponse(int n, OSRLicense oSRLicense) {
    }

    public void dsiOnlineServiceRegistrationGetLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
    }

    public void dsiOnlineServiceRegistrationGetProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
    }

    public void dsiOnlineServiceRegistrationGetCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
    }

    public void dsiOnlineServiceRegistrationGetCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
    }

    public void dsiOnlineServiceRegistrationGetServiceURLResponse(int n, String string, String string2) {
        CoreServiceMODFactory.getNotifier().getServiceURLResponse(string, string2, n);
    }

    public void dsiOnlineServiceRegistrationResetToFactorySettingsResponse(String string, int n) {
        CoreServiceMODFactory.getNotifier().resetToFactorSettingsResponse(CoreServiceMODFactory.getController(this).getDevice() != null ? CoreServiceMODFactory.getController(this).getDevice().getDeviceID() : this.getDeviceID(), string, n);
        if (Util.isNullOrEmpty(string) && n == 0) {
            CoreServiceMODFactory.getController(this).reset();
        }
    }

    public void dsiOnlineServiceRegistrationUpdateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
    }

    public void dsiOnlineServiceRegistrationUpdateProfileInfo(int n, String string, String string2, int n2, int n3) {
    }

    public void dsiOnlineServiceRegistrationUpdateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
    }

    public void dsiOnlineServiceRegistrationUpdateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
    }

    public void dsiOnlineServiceRegistrationUpdateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
    }

    public void dsiOnlineServiceRegistrationUpdateServiceState(int n, int n2) {
        CoreServiceMODFactory.getController(this).updateServiceState(n);
    }

    public void dsiOnlineServiceRegistrationUpdateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
        CoreServiceMODFactory.getController(this).updateServiceList(oSRServiceListEntryArray);
    }

    public void dsiOnlineServiceRegistrationUpdateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
        CoreServiceMODFactory.getController(this).updateServices(oSRNotifyPropertiesSLArray);
    }

    public void dsiOnlineServiceRegistrationSetServiceStateResponse(OSRServiceState oSRServiceState) {
        CoreServiceMODFactory.getController(this).setServiceStateResponse(oSRServiceState);
    }

    public void dsiOnlineServiceRegistrationSetServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
    }

    public void dsiOnlineServiceRegistrationSetActivePrivacyCategoryMaskResponse(int n) {
        CoreServiceMODFactory.getNotifier().sendPrivacyModeStatusResponse(n, this.getDeviceID());
    }

    public void dsiOnlineServiceRegistrationSubmitServiceStateChangesToBackendResponse(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(new StringBuffer().append(".submitServiceStateChangesToBackendResponse(").append(n).append(")").toString()).log();
        }
    }

    public void dsiOnlineServiceRegistrationUpdateSPINRequired(String string, String string2, int n) {
        CoreServiceFactory.getExternalUpdateListener().updateSPinRequired(string2);
    }

    public void dsiOnlineServiceRegistrationSetSPINResponse(String string, String string2, int n, int n2) {
        CoreServiceMODFactory.getNotifier().setSPinResponse(string2, n, n2);
    }

    public void dsiOnlineServiceRegistrationGetSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
        CoreServiceMODFactory.getNotifier().calculateSPinHashResponse(string3, string, string2, n, string4, n2);
    }

    public void dsiOnlineServiceRegistrationSetInventoryFinishedResponse(int n) {
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

