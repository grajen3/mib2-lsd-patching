/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.has.HASClient;
import de.vw.mib.has.internal.HASBridge;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.has.internal.HASManager;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.base.ServiceAdmin;
import org.dsi.ifc.has.DSIHAS;

public class HASDSITarget
implements Target,
DSIServiceStateListener {
    private final GenericEvents eventContext;
    private final HASClient client;
    private final String logPrefix;
    private final DSIProxy dsiProxy;
    private final ServiceAdmin serviceAdmin;
    private int targetId;
    private DSIHAS service;
    private HASBridge bridge;
    private boolean listenerRegistered;
    private boolean serviceRegistered;
    private boolean serviceStarted;
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHAS;
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHASListener;

    public HASDSITarget(GenericEvents genericEvents, int n, TaskInterface taskInterface, HASClient hASClient) {
        this.eventContext = genericEvents;
        this.client = hASClient;
        this.logPrefix = new StringBuffer().append("HASDSITarget[").append(hASClient.getClientName()).append(']').toString();
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.serviceAdmin = DSIProxyFactory.getDSIProxyAPI().getServiceAdmin();
        genericEvents.getEventDispatcher().registerTarget(n, this, taskInterface.getId());
    }

    @Override
    public GenericEvents getMainObject() {
        return this.eventContext;
    }

    @Override
    public int getTargetId() {
        return this.targetId;
    }

    @Override
    public void setTargetId(int n) {
        this.targetId = n;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.onPowerOn();
                break;
            }
            case 107: {
                this.onPowerOff();
                break;
            }
        }
    }

    private void onPowerOn() {
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "onPowerOn", true);
            logMessage.append("serviceRegistered=").append(this.serviceRegistered).log();
        }
        if (!this.listenerRegistered) {
            logMessage = HASLog.trace();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "onPowerOn", true);
                logMessage.append("registering as ServiceStateListener").log();
            }
            this.listenerRegistered = true;
            this.dsiProxy.addServiceStateListener(class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = HASDSITarget.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS, this.client.getDSIInstance(), this);
        }
        if (this.serviceRegistered) {
            if (null == this.bridge) {
                this.connectDSI();
            }
        } else if (!this.serviceStarted) {
            int n = this.client.getDSIInstance();
            logMessage = HASLog.info();
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "onPowerOn", true);
            logMessage.append("Starting DSIHAS");
            HASLog.appendIntProperty(logMessage, "instance", n, true).log();
            this.serviceStarted = true;
            this.serviceAdmin.startService((class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = HASDSITarget.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS).getName(), this.client.getDSIInstance());
        }
    }

    private void onPowerOff() {
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "onPowerOff", true);
            logMessage.append("serviceRegistered=").append(this.serviceRegistered).log();
        }
        this.disconnectDSI();
    }

    @Override
    public void registered(String string, int n) {
        if (!this.serviceRegistered) {
            this.serviceRegistered = true;
            this.connectDSI();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.serviceRegistered) {
            this.serviceRegistered = false;
            this.disconnectDSI();
        }
    }

    private void disconnectDSI() {
        if (null != this.bridge) {
            int n = this.client.getDSIInstance();
            LogMessage logMessage = HASLog.info();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "disconnectDSI", true);
                logMessage.append("stopping DSI communication");
                HASLog.appendIntProperty(logMessage, "instance", n, true).log();
            }
            this.dsiProxy.removeResponseListener(this, class$org$dsi$ifc$has$DSIHASListener == null ? (class$org$dsi$ifc$has$DSIHASListener = HASDSITarget.class$("org.dsi.ifc.has.DSIHASListener")) : class$org$dsi$ifc$has$DSIHASListener, n, this.bridge);
            HASManager.getInstance().dismissBridge(this.bridge);
            this.bridge = null;
        }
        this.service = null;
    }

    private void connectDSI() {
        this.disconnectDSI();
        int n = this.client.getDSIInstance();
        LogMessage logMessage = HASLog.info();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "connectDSI", true);
            logMessage.append("initializing DSI communication");
            HASLog.appendIntProperty(logMessage, "instance", n, true).log();
        }
        this.service = (DSIHAS)this.dsiProxy.getService(this, class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = HASDSITarget.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS, n);
        this.bridge = HASManager.getInstance().createBridge(this.client, this.service);
        this.dsiProxy.addResponseListener(this, class$org$dsi$ifc$has$DSIHASListener == null ? (class$org$dsi$ifc$has$DSIHASListener = HASDSITarget.class$("org.dsi.ifc.has.DSIHASListener")) : class$org$dsi$ifc$has$DSIHASListener, n, this.bridge);
        this.service.hmiReady();
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

