/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAppConnectAppAdapter;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.smartphoneintegration.common.AppConnectContextRequestHandler;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationHelper;
import de.vw.mib.asl.internal.smartphoneintegration.persistence.SmartPhoneIntegrationPersistence;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLEventHandler;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler;
import de.vw.mib.asl.internal.smartphoneintegration.target.DSIHandler;
import de.vw.mib.asl.internal.smartphoneintegration.target.FactoryReset;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;
import org.dsi.ifc.smartphoneintegration.Device;

public class HsmTarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    private static ASLHandler aslhandler;
    private static ASLEventHandler aslEventhandler;
    private static DSIHandler dsihandler;
    private static SmartPhoneIntegrationPersistence persistence;
    private static FactoryReset factoryReset;
    private ASLSmartphoneIntegrationAppConnectAppAdapter adapter;
    private AppConnectContextRequestHandler appConnectRequestHandler;
    private DSISmartphoneIntegration dsiSmartPhoneIntegration;
    private DSIListener dsiSmartPhoneIntegrationListener;
    private boolean targetStarted;
    boolean dsiSmartPhoneIntegrationAvailable;
    private final String classname;
    final int[] OBSERVED_EVENTS = new int[]{-2075192832, 513622272, 655645952, 722754816, 672423168, 739532032, 840195328, 856972544, 924081408, 940858624, 689200384, 705977600, 756309248, -1578224128, 957635840, 1007967488, 1075076352, 1041521920, 1058299136, 1125408000, 1158962432, 403258624, 252263680, -476299008, -1978376960, -1961599744, -1995154176, -1944822528, 1191510080, 772481088};
    final int[] DSI_SMARTPHONEINTEGRATION_ATTR1 = new int[]{3};
    final int[] DSI_SMARTPHONEINTEGRATION_ATTR2 = new int[]{2, 1, 4, 5};
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration;
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener;

    public HsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.classname = "SmartPhoneIntegration.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target smartphoneintegration - Initialising Target smartphoneintegration (2)!");
        }
        this.initObjects();
    }

    public HsmTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
        this.classname = "SmartPhoneIntegration.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target smartphoneintegration - Initialising smartphoneintegration (3)!");
        }
        this.initObjects();
    }

    public HsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.classname = "SmartPhoneIntegration.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target smartphoneintegration - Initialising Target smartphoneintegration (1)!");
        }
        this.initObjects();
    }

    private void initObjects() {
        SmartPhoneIntegrationHelper.setTarget(this);
        aslhandler = this.getASLHandler();
        aslEventhandler = this.getAslEventhandler();
        dsihandler = this.getDSIHandler();
        persistence = this.getPersistence();
        factoryReset = new FactoryReset(this);
        this.appConnectRequestHandler = null;
        this.adapter = null;
        this.getGlobalProperties().setTarget(this);
        ServiceManager.aslPropertyManager.valueChangedInteger(1097280512, -1);
        ServiceManager.aslPropertyManager.valueChangedInteger(1164389376, this.getPersistence().getInitialConnectionType());
        this.getASLHandler().updateExlapServerData(true);
        if (this.isTraceEnabled()) {
            this.getPersistence().printLastConnectedDevicesList();
            this.trace().append("################################  SMARTPHONEINTEGRATION DOMAIN IS RUNNING  #########################################").log();
        }
        factoryReset.register();
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".initObjects().factoryreset.register").log();
        }
    }

    private void initializeDSI() {
        LogMessage logMessage;
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".initializeDSI()").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiSmartPhoneIntegration = (DSISmartphoneIntegration)dSIProxy.getService(this, class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = HsmTarget.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration);
        this.dsiSmartPhoneIntegrationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener = HsmTarget.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener);
        if (this.dsiSmartPhoneIntegrationListener != null) {
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener = HsmTarget.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener, this.dsiSmartPhoneIntegrationListener);
        } else {
            logMessage = this.warn();
            logMessage.append("SmartPhoneIntegration.HsmTarget").append(".initializeDSI() Invalid DSISmartphoneIntegrationListener").log();
        }
        if (this.dsiSmartPhoneIntegration != null) {
            this.dsiSmartPhoneIntegration.setNotification(this.DSI_SMARTPHONEINTEGRATION_ATTR1, this.dsiSmartPhoneIntegrationListener);
            this.dsiSmartPhoneIntegration.setNotification(this.DSI_SMARTPHONEINTEGRATION_ATTR2, this.dsiSmartPhoneIntegrationListener);
        } else {
            logMessage = this.warn();
            logMessage.append("SmartPhoneIntegration.HsmTarget").append(".initializeDSI() Invalid DSISmartphoneIntegration").log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".initializeDSI(start subcontexts)").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1211244544, 1);
    }

    private void deInitializeDSI() {
        if (this.dsiSmartPhoneIntegrationListener != null) {
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener = HsmTarget.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener, this.dsiSmartPhoneIntegrationListener);
        }
        this.dsiSmartPhoneIntegration = null;
        this.dsiSmartPhoneIntegrationListener = null;
        ServiceManager.aslPropertyManager.valueChangedInteger(1211244544, 0);
    }

    public DSISmartphoneIntegration getDSISmartphoneIntegration() {
        if (this.dsiSmartPhoneIntegration == null) {
            this.warn().append("SmartPhoneIntegration.HsmTarget").append(".getDSISmartphoneIntegration() Invalid DSI instance").log();
        }
        return this.dsiSmartPhoneIntegration;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("Target smartphoneintegration - got an event! target is set, call event handling");
        }
        this.getAslEventhandler().gotEvent(eventGeneric);
    }

    public void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".startup()").log();
        }
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = HsmTarget.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration, this);
        this.addObservers(this.OBSERVED_EVENTS);
        this.targetStarted = true;
        ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1585053440);
        ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1568276224);
    }

    private void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".shutdown()").log();
        }
        if (this.targetStarted) {
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = HsmTarget.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration, this);
            this.removeObservers(this.OBSERVED_EVENTS);
            this.deInitializeDSI();
            this.targetStarted = false;
        }
    }

    @Override
    public int getClassifier() {
        return 1174437888;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    @Override
    public int getDefaultTargetId() {
        return -501540864;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".registered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2.equalsIgnoreCase(RuntimeGeneratedConstants.SERVICE_TS_NS[125])) {
            this.initializeDSI();
        } else if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".registered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(RuntimeGeneratedConstants.SERVICE_TS_NS[125]).append(")").log();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".unregistered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[125]) {
            this.deInitializeDSI();
        }
    }

    public ASLHandler getASLHandler() {
        if (aslhandler == null) {
            aslhandler = new ASLHandler(this);
        }
        return aslhandler;
    }

    public DSIHandler getDSIHandler() {
        if (dsihandler == null) {
            dsihandler = new DSIHandler(this);
        }
        return dsihandler;
    }

    public AppConnectContextRequestHandler getAppConnectRequestHandler() {
        if (null == this.appConnectRequestHandler) {
            this.appConnectRequestHandler = new AppConnectContextRequestHandler(this);
        }
        return this.appConnectRequestHandler;
    }

    public SmartPhoneIntegrationPersistence getPersistence() {
        if (persistence == null) {
            persistence = new SmartPhoneIntegrationPersistence(this);
            ServiceManager.persistence.registerSharedPersistable(persistence);
            ServiceManager.persistence.loadPersistable(persistence.getNamespace(), persistence.getKey(), persistence);
        }
        return persistence;
    }

    public ASLEventHandler getAslEventhandler() {
        if (aslEventhandler == null) {
            aslEventhandler = new ASLEventHandler(this);
        }
        return aslEventhandler;
    }

    SmartPhoneIntegrationGlobalProperyAccessor getGlobalProperties() {
        return SmartPhoneIntegrationGlobalProperyAccessor.getInstance();
    }

    public ASLSmartphoneIntegrationAppConnectAppAdapter getAppAdapterInterface() {
        return this.adapter;
    }

    public void setAppAdapterInterface(ASLSmartphoneIntegrationAppConnectAppAdapter aSLSmartphoneIntegrationAppConnectAppAdapter) {
        this.adapter = aSLSmartphoneIntegrationAppConnectAppAdapter;
    }

    public void dsiSmartphoneIntegrationUpdateDiscoveredDevices(Device[] deviceArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationUpdateDiscoveredDevices() ").log();
        }
        if (n == 1) {
            if (!this.getGlobalProperties().isBusResetActive()) {
                if (this.getTimerServer().isTimerActive(this.getTargetId(), -1450835712)) {
                    SmartPhoneIntegrationGlobalProperyAccessor.getInstance().setTempDsiDevicelist(deviceArray);
                    if (this.isTraceEnabled()) {
                        this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationUpdateDiscoveredDevices(busreset is not active but timer is already running -> updatediscovereddevices will be storde temporary) ").log();
                    }
                } else {
                    this.getDSIHandler().handleDsiApiUpdateDiscoveredDevices(deviceArray);
                }
            } else if (this.isTraceEnabled()) {
                this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationUpdateDiscoveredDevices(busresetisactive and updatediscovereddevices will be ignored) ").log();
            }
        }
    }

    public void dsiSmartphoneIntegrationUpdateDeviceConnectionState(int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            if (this.isTraceEnabled()) {
                this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationUpdateDeviceConnectionState( ID: ").append(n).append(" , DSIconnactionstate: ").append(n2).append(new StringBuffer().append(" , connectionmethod").append(n3).append(" )").toString()).log();
            }
            this.getDSIHandler().handleDsiApiUpdateDeviceConnectionState(n, n2, n3);
        }
    }

    public void dsiSmartphoneIntegrationAsyncException(int n, String string, int n2) {
        if (n == 0 && n2 == 1001 && this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationAsyncException(  ").append(string).append(" )").log();
        }
    }

    public void dsiSmartphoneIntegrationUpdateSWaPStatus(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationUpdateSWaPStatus( status: ").append(n).append(" )").log();
        }
        if (n2 == 1) {
            this.getDSIHandler().handleDsiApiUpdateSWaPStatus(n);
        }
    }

    public void dsiSmartphoneIntegrationUpdateUSBResetActive(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationUpdateUSBResetActive( active: ").append(bl).append(" )").log();
        }
        if (n == 1) {
            this.getDSIHandler().handleDsiApiUpdateUSBResetActive(bl);
        }
    }

    public void dsiSmartphoneIntegrationUpdateAppConnectContextRequested(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("SmartPhoneIntegration.HsmTarget").append(".dsiSmartphoneIntegrationUpdateAppConnectContextRequested( requested: ").append(bl).append(" )").log();
        }
        if (n == 1) {
            this.getDSIHandler().handleDsiApiUpdateAppConnectContextRequested(bl);
        }
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

