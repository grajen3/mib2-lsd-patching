/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.states;

import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.online.CallCenterLanguage;
import de.vw.mib.asl.internal.online.OnlineCallCenterServiceController;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOperatorCall;
import org.dsi.ifc.online.OperatorCallResult;

public class OnlineCallCenterServiceTarget
extends AbstractASLTarget
implements DSIServiceStateListener,
ASLOnlineServiceListener {
    private DSIOperatorCall _dsiOperatorCall = null;
    private DSIListener _dsiOperatorCallListener = null;
    private final String _classname = super.getClass().getName();
    final int[] OBSERVED_EVENTS = new int[]{155076864};
    private OnlineCallCenterServiceController _controller;
    private final CallCenterLanguage callCenterLanguage = new CallCenterLanguage(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOperatorCall;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOperatorCallListener;

    public OnlineCallCenterServiceTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
                this.startup();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_OFF)").log();
                }
                this.shutdown();
                break;
            }
            case 40003: {
                String string = eventGeneric.getString(1);
                EventGeneric eventGeneric2 = eventGeneric;
                this.callCenterLanguage.setLanguage(string, eventGeneric2);
                break;
            }
        }
    }

    private void initializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".initializeDSI()").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this._dsiOperatorCall = (DSIOperatorCall)dSIProxy.getService(this, class$org$dsi$ifc$online$DSIOperatorCall == null ? (class$org$dsi$ifc$online$DSIOperatorCall = OnlineCallCenterServiceTarget.class$("org.dsi.ifc.online.DSIOperatorCall")) : class$org$dsi$ifc$online$DSIOperatorCall);
        this._dsiOperatorCallListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$online$DSIOperatorCallListener == null ? (class$org$dsi$ifc$online$DSIOperatorCallListener = OnlineCallCenterServiceTarget.class$("org.dsi.ifc.online.DSIOperatorCallListener")) : class$org$dsi$ifc$online$DSIOperatorCallListener);
        if (this._dsiOperatorCallListener != null) {
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$online$DSIOperatorCallListener == null ? (class$org$dsi$ifc$online$DSIOperatorCallListener = OnlineCallCenterServiceTarget.class$("org.dsi.ifc.online.DSIOperatorCallListener")) : class$org$dsi$ifc$online$DSIOperatorCallListener, this._dsiOperatorCallListener);
        } else {
            this.warn().append(this._classname).append(".initializeDSI() Invalid DSIOperatorCallListener").log();
        }
    }

    private void deInitializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".deInitializeDSI()").log();
        }
        this._dsiOperatorCall = null;
        this._dsiOperatorCallListener = null;
    }

    private void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startup()").log();
        }
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$online$DSIOperatorCall == null ? (class$org$dsi$ifc$online$DSIOperatorCall = OnlineCallCenterServiceTarget.class$("org.dsi.ifc.online.DSIOperatorCall")) : class$org$dsi$ifc$online$DSIOperatorCall, this);
        this.addObservers(this.OBSERVED_EVENTS);
        ASLOnlineCoreServices aSLOnlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
        aSLOnlineCoreServices.registerForServiceUpdate(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(24), this);
    }

    private void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startdown()").log();
        }
        ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$online$DSIOperatorCall == null ? (class$org$dsi$ifc$online$DSIOperatorCall = OnlineCallCenterServiceTarget.class$("org.dsi.ifc.online.DSIOperatorCall")) : class$org$dsi$ifc$online$DSIOperatorCall, this);
        this.removeObservers(this.OBSERVED_EVENTS);
        this.deInitializeDSI();
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (ASLOnlineFactory.getOnlineCoreServices().isServiceAvailable(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(24))) {
            this.getOnlineCallCenterServiceController().setActive(n == 0);
        }
    }

    public DSIOperatorCall getDSIOperatorCall() {
        if (this._dsiOperatorCall == null) {
            this.warn().append(this._classname).append(".getDSIOperatorCall() Invalid DSI instance").log();
        }
        return this._dsiOperatorCall;
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
        return 862852608;
    }

    @Override
    public void registered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".registered(").append(string).append(", ").append(n).append(")").log();
        }
        if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[96])) {
            this.initializeDSI();
            this.getOnlineCallCenterServiceController().setActive(true);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
            eventGeneric.setInt(0, this.getTargetId());
            eventGeneric.setInt(1, 9);
            eventGeneric.setString(2, "NO_LANGUAGE");
            this.sendSafe(eventGeneric);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".unregistered(").append(string).append(", ").append(n).append(")").log();
        }
        if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[96])) {
            this.deInitializeDSI();
            this.getOnlineCallCenterServiceController().setActive(false);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1117519872);
            eventGeneric.setInt(0, this.getTargetId());
            eventGeneric.setInt(1, 9);
            this.sendSafe(eventGeneric);
        }
    }

    public OnlineCallCenterServiceController getOnlineCallCenterServiceController() {
        if (this._controller == null) {
            this._controller = new OnlineCallCenterServiceController(this);
        }
        return this._controller;
    }

    public void dsiOperatorCallResponseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        this.getOnlineCallCenterServiceController().responseOperatorCallResult(n, operatorCallResultArray);
    }

    public void dsiOperatorCallResponseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        this.getOnlineCallCenterServiceController().responseOperatorPhoneNumber(n, string, stringArray, n2);
    }

    public void dsiOperatorCallAsyncException(int n, String string, int n2) {
        this.warn().append(this._classname).append(".dsiOperatorCallAsyncException(Code=").append(n).append(", Message=").append(string).append(", Type=").append(n2).append(")").log();
        this.getOnlineCallCenterServiceController().errorHandling(n, n2);
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

