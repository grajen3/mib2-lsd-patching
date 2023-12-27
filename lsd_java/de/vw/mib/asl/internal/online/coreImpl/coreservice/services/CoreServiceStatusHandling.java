/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceInfo;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceStatusHandling$1;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceStatusHandling$2;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceStatusListener;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import java.util.Iterator;

public class CoreServiceStatusHandling {
    private final String _classname = super.getClass().getName();
    private CoreServiceInfo _currentObject;
    private ArrayList _processQueue;
    private boolean _resetFactorySettings;

    public void resetToFactorySettings() {
        this._resetFactorySettings = true;
        this.sendResultToClear(1);
        if (!this.getQueue().isEmpty()) {
            Iterator iterator = this.getQueue().iterator();
            while (iterator.hasNext()) {
                if (this._currentObject != null) {
                    this._currentObject.clear();
                    this._currentObject = null;
                }
                this._currentObject = (CoreServiceInfo)iterator.next();
                this.sendResultToClear(1);
            }
            this.getQueue().clear();
        }
        this._resetFactorySettings = false;
    }

    public void handleServiceStatusCheck(CoreServiceStatusListener coreServiceStatusListener, String string) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".handleServiceStatusCheck( ").append(coreServiceStatusListener != null ? "callback" : "null").append(" )").toString()).log();
        }
        if (!this._resetFactorySettings && coreServiceStatusListener != null && !Util.isNullOrEmpty(string)) {
            object = new CoreServiceInfo(string, coreServiceStatusListener, CoreServiceInfo.TYPE_STATUS);
            if (this._currentObject != null) {
                this.getQueue().add(object);
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    ServiceManager.logger2.trace(16384).append(this._classname).append(".handleServiceStatusCheck: ").append("enqueing ").append(string).append(" to queue, _currentObject = ").append(this._currentObject.getServiceID()).log();
                }
            } else {
                this._currentObject = object;
                this.requestForServiceStatus(string);
            }
        }
    }

    public void handleServiceStatusCheck(CoreServiceCallback coreServiceCallback, String string) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".handleServiceStatusCheck(deprecated)( ").append(coreServiceCallback != null ? "callback" : "null").append(" )").toString()).log();
        }
        if (!this._resetFactorySettings && coreServiceCallback != null && !Util.isNullOrEmpty(string)) {
            object = new CoreServiceInfo(string, coreServiceCallback, CoreServiceInfo.TYPE_STATUS);
            if (this._currentObject != null) {
                this.getQueue().add(object);
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    ServiceManager.logger2.trace(16384).append(this._classname).append(".handleServiceStatusCheck(deprecated): ").append("enqueing ").append(string).append(" to queue, _currentObject = ").append(this._currentObject.getServiceID()).log();
                }
            } else {
                this._currentObject = object;
                this.requestForServiceStatus(string);
            }
        }
    }

    public void authenticationResult(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".authenticationResult( ").append(n).append(" )").toString()).log();
        }
        this.sendResultToClear(n);
        if (!this.getQueue().isEmpty()) {
            if (this._currentObject != null) {
                this._currentObject.clear();
                this._currentObject = null;
            }
            this._currentObject = (CoreServiceInfo)this.getQueue().remove(0);
            this.requestForServiceStatus(this._currentObject.getServiceID());
        }
    }

    public void sendStatus() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".sendLicenseStatusUpdate()").log();
        }
        if (!this._resetFactorySettings) {
            this.sendResultToClear(29);
            if (!this.getQueue().isEmpty()) {
                if (this._currentObject != null) {
                    this._currentObject.clear();
                    this._currentObject = null;
                }
                this._currentObject = (CoreServiceInfo)this.getQueue().remove(0);
                this.requestForServiceStatus(this._currentObject.getServiceID());
            }
        }
    }

    public void errorHandling() {
        this.callbackTimer();
    }

    private ArrayList getQueue() {
        if (this._processQueue == null) {
            this._processQueue = new ArrayList();
        }
        return this._processQueue;
    }

    private void callbackTimer() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".callbackTimer()").log();
        }
        ServiceManager.aslThreadSwitch.enqueue(new CoreServiceStatusHandling$1(this));
    }

    private void requestForServiceStatus(String string) {
        CoreServiceAdapter coreServiceAdapter;
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".requestForServiceStatus()").log();
        }
        if ((object = CoreServiceImplFactory.getCoreServiceController().getDeviceWithServiceID(string)) != null && (coreServiceAdapter = CoreServiceFactory.getAdapterRegister().getAdapterWithID(object.getDeviceID())) != null) {
            coreServiceAdapter.checkServiceStatus(string, null, CoreServiceImplFactory.getAdapterListener());
            return;
        }
        this.callbackTimer();
    }

    private int getResultForCallback(int n) {
        int n2 = 1;
        switch (n) {
            case -1: {
                break;
            }
            case 0: {
                n2 = 0;
                break;
            }
            case 24: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private void sendResultToClear(int n) {
        int n2 = 1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 24: {
                n2 = 3;
                break;
            }
            case 1: 
            case 15: {
                n2 = 2;
                break;
            }
            case 6: {
                n2 = 4;
                break;
            }
            case 50: {
                n2 = 5;
                break;
            }
            case -1: {
                n2 = 6;
                break;
            }
            case 2: {
                n2 = 7;
                break;
            }
            case 16: {
                n2 = 8;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        if (this._currentObject != null) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(new StringBuffer().append("sendResultToClear( ServiceID = ").append(this._currentObject.getServiceID()).append(", Result = ").append(n).append(" )").toString()).log();
            }
            if (this._currentObject.getListener() != null) {
                this._currentObject.getListener().updateServiceStatusOnChange(n2);
            } else {
                this._currentObject.getCallbackNotUsed().checkOnlineServiceStatusResponse(new CoreServiceStatusHandling$2(this), this.getResultForCallback(n));
            }
            this._currentObject.clear();
            this._currentObject = null;
        }
    }

    static /* synthetic */ CoreServiceInfo access$000(CoreServiceStatusHandling coreServiceStatusHandling) {
        return coreServiceStatusHandling._currentObject;
    }
}

