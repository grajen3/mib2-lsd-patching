/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.states;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.internetbrowser.IBrowserController;
import de.vw.mib.asl.internal.internetbrowser.common.EfiLinkHandler;
import de.vw.mib.asl.internal.internetbrowser.common.HASPropertyReceiver;
import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.BrowserServiceBridge;
import de.vw.mib.asl.internal.internetbrowser.states.IBrowserStateActive;
import de.vw.mib.asl.internal.internetbrowser.states.IBrowserTarget$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.DSIBrowser;

public final class IBrowserTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    final HsmState _stateActive;
    private IBrowserController _controller;
    private static HASPropertyReceiver _HASHandler;
    private static EfiLinkHandler _EfiHandler;
    private DSIBrowser _dsiBrowser;
    private DSIListener _dsiBrowserListener;
    boolean _dsiBrowserAvailable;
    private String _vinNum;
    private final String _classname;
    private static final int EV_HANDLE_MULTIPLE_TOUCH_SCROLL_WINDOW_TIMEOUT;
    private static final int TOUCH_SCROLL_DEBOUNCE_TIMER;
    final int[] OBSERVED_EVENTS;
    final int[] DSI_BROWSER_ATTR;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserListener;

    public IBrowserTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._stateActive = new IBrowserStateActive(this, this.hsm, "StateActive", this.getWorkStateParent());
        this._dsiBrowser = null;
        this._dsiBrowserListener = null;
        this._dsiBrowserAvailable = false;
        this._classname = super.getClass().getName();
        this.OBSERVED_EVENTS = new int[]{-836302528, 973668416, 1342242880, -1054406336, -869856960, 990445632, 1007222848, 1024000064, 1040777280, 1057554496, -987297472, -1020851904, -1004074688, -1037629120, -970520256, -920188608, -903411392, -886634176, -853079744, -819525312, 513622272, 849166592, 933052672, -459521792, -2017908224, -2001131008, -1047453440, -1013899008, -963567360, -997121792, -946790144, -980344576, -1030676224, 806035456};
        this.DSI_BROWSER_ATTR = new int[]{1, 2, 3, 4, 7, 10, 12, 13, 14, 15, 16, 17, 18};
    }

    private boolean initializeDSI() {
        this._dsiBrowser = (DSIBrowser)DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getService(this, class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = IBrowserTarget.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser);
        this._dsiBrowserListener = DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$browser$DSIBrowserListener == null ? (class$org$dsi$ifc$browser$DSIBrowserListener = IBrowserTarget.class$("org.dsi.ifc.browser.DSIBrowserListener")) : class$org$dsi$ifc$browser$DSIBrowserListener);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$browser$DSIBrowserListener == null ? (class$org$dsi$ifc$browser$DSIBrowserListener = IBrowserTarget.class$("org.dsi.ifc.browser.DSIBrowserListener")) : class$org$dsi$ifc$browser$DSIBrowserListener, this._dsiBrowserListener);
        this._dsiBrowser.setNotification(this.DSI_BROWSER_ATTR, this._dsiBrowserListener);
        return true;
    }

    private void deInitializeDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$browser$DSIBrowserListener == null ? (class$org$dsi$ifc$browser$DSIBrowserListener = IBrowserTarget.class$("org.dsi.ifc.browser.DSIBrowserListener")) : class$org$dsi$ifc$browser$DSIBrowserListener, this._dsiBrowserListener);
        this._dsiBrowser.clearNotification(this.DSI_BROWSER_ATTR, this._dsiBrowserListener);
    }

    public IBrowserController getController() {
        return this._controller;
    }

    public HASPropertyReceiver getHASHandler() {
        return _HASHandler;
    }

    public EfiLinkHandler getEfiHandler() {
        return _EfiHandler;
    }

    public DSIBrowser getDSIBrowser() {
        return this._dsiBrowser;
    }

    public void startup() {
        Object object;
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append(this._classname).append(".startup()").log();
        }
        this._controller = IBrowserController.initializeController();
        this._controller.setTarget(this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = IBrowserTarget.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser, this);
        this.registerService(-2017908224);
        this.registerService(-2001131008);
        this.addObservers(this.OBSERVED_EVENTS);
        ServiceManager.adaptionApi.requestCoding(new IBrowserTarget$1(this));
        object = ServiceManager.mGenericEventFactory.newEvent(1083965440);
        ((EventGeneric)object).setInt(0, this.getTargetId());
        ((EventGeneric)object).setInt(1, 0);
        ((EventGeneric)object).setString(2, "NO_LANGUAGE");
        ((EventGeneric)object).setString(3, this._classname);
        this.send((EventGeneric)object);
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.addParticipant(this.getController(), FactoryResetComponents.INTERNET_BROWSER);
    }

    private void shutdown() {
        Object object;
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append(this._classname).append(".shutdown()").log();
        }
        ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = IBrowserTarget.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser, this);
        this.removeObservers(this.OBSERVED_EVENTS);
        this.deInitializeDSI();
        object = ASLSystemFactory.getSystemApi().getFactoryResetService();
        object.removeParticipant(this.getController(), FactoryResetComponents.INTERNET_BROWSER);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    LogMessage logMessage = this.trace();
                    logMessage.append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(452)) break;
                this.startup();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    LogMessage logMessage = this.trace();
                    logMessage.append(this._classname).append(".gotEvent(POWER_OFF)").log();
                }
                this.shutdown();
                break;
            }
            case 100016: {
                this.getController().touchScrollWindowTimeout();
                break;
            }
        }
        super.gotEvent(eventGeneric);
    }

    public boolean isTouchScrollWindowTimerActive() {
        return this.getTimerServer().isTimerActive(this.getTargetId(), -1333395200);
    }

    public void startTouchScrollWindowTimer() {
        this.startTimer(-1333395200, (long)0, false);
    }

    public void stopTouchScrollWindowTimer() {
        this.stopTimer(-1333395200);
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    protected HsmState getDefaultState() {
        return this._stateActive;
    }

    @Override
    public int getDefaultTargetId() {
        return -262139136;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".registered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[11]) {
            this._dsiBrowserAvailable = true;
            this.initializeDSI();
            _HASHandler = BrowserServiceBridge.getBrowserServiceBridgeController().getHasHandler();
            _HASHandler.setTarget(this);
            _EfiHandler = EfiLinkHandler.initializeEfiHandler(this.getTextLogger());
            _EfiHandler.setTarget(this);
            _EfiHandler.setSettings();
        }
        if (this._dsiBrowserAvailable) {
            this.getController().initializeSettings();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        Object object;
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append(this._classname).append(".unregistered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[11]) {
            this._dsiBrowserAvailable = false;
            this.deInitializeDSI();
            object = ServiceManager.mGenericEventFactory.newEvent();
            ((EventGeneric)object).setBoolean(-1501167360, false);
            this.triggerMe((EventGeneric)object, -1517944576);
        }
        if (!this._dsiBrowserAvailable) {
            // empty if block
        }
    }

    public void dsiStartupUpdateDomainStatusBrowser(int n, int n2) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".dsiStartupUpdateDomainStatusBrowser(").append(n).append(", ").append(n2).append(")").log();
        }
    }

    public void setVINNumber(String string) {
        this._vinNum = string;
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.info();
            logMessage.append(this._classname).append(" VIN from the car ").append(string).log();
        }
    }

    public String getVINNumber() {
        return this._vinNum;
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

