/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceInfo;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceUrlHandler$1;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceUrlHandler$2;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceUrlHandler$3;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceUrlHandler$4;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback1;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.Iterator;

public class CoreServiceUrlHandler {
    private final String _classname = super.getClass().getName();
    private ObjectObjectOptHashMap _processingForUrlMap;
    private String _failureServiceID;

    public void handleURLInfo(CoreServiceCallback1 coreServiceCallback1, String string) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".handleURLInfo()").log();
        }
        if (coreServiceCallback1 != null && !Util.isNullOrEmpty(string)) {
            Object[] objectArray;
            object = new CoreServiceInfo(string, coreServiceCallback1, CoreServiceInfo.TYPE_URL);
            if (!Util.isNullOrEmpty(CoreServiceFactory.getExternalRegister().getRegisteredExternals()) && !Util.isNullOrEmpty(objectArray = CoreServiceFactory.getExternalRegister().getExternalsWithSupportedFunction(1))) {
                this.getProcessingQueueMap().put(string, object);
                int n = objectArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    objectArray[i2].getServiceURL(string, CoreServiceImplFactory.getExternalListener());
                }
                return;
            }
            this.getProcessingQueueMap().put(string, object);
            this._failureServiceID = string;
            this.fireCallback();
        }
    }

    public void responseServiceURLInfo(int n, String string, String string2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".responseServiceURLInfo( ").append(n).append(", ").append(string).append(", ").append(string2).append(" )").toString()).log();
        }
        if (this.getProcessingQueueMap().containsKey(string)) {
            object = (CoreServiceInfo)this.getProcessingQueueMap().remove(string);
            if (((CoreServiceInfo)object).getCallback() != null) {
                ((CoreServiceInfo)object).getCallback().getServiceURLResponse(((CoreServiceInfo)object).getServiceID(), string2);
            } else if (((CoreServiceInfo)object).getCallbackNotUsed() != null) {
                ((CoreServiceInfo)object).getCallbackNotUsed().getServiceURLResponse(new CoreServiceUrlHandler$1(this, string), string2);
            }
            ((CoreServiceInfo)object).clear();
            object = null;
        }
    }

    public void sendbackUrlInfo() {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".sendbackUrlInfo()").log();
        }
        if (this.getProcessingQueueMap().containsKey(this._failureServiceID)) {
            object = (CoreServiceInfo)this.getProcessingQueueMap().remove(this._failureServiceID);
            if (((CoreServiceInfo)object).getCallback() != null) {
                ((CoreServiceInfo)object).getCallback().getServiceURLResponse(((CoreServiceInfo)object).getServiceID(), null);
            } else if (((CoreServiceInfo)object).getCallbackNotUsed() != null) {
                String string = new String(((CoreServiceInfo)object).getServiceID());
                ((CoreServiceInfo)object).getCallbackNotUsed().getServiceURLResponse(new CoreServiceUrlHandler$2(this, string), null);
            }
            ((CoreServiceInfo)object).clear();
            object = null;
        }
    }

    public void errorHandlingServiceUrl() {
        if (!this.getProcessingQueueMap().isEmpty()) {
            Iterator iterator = this.getProcessingQueueMap().keyIterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                CoreServiceInfo coreServiceInfo = (CoreServiceInfo)this.getProcessingQueueMap().remove(string);
                if (coreServiceInfo.getCallback() != null) {
                    coreServiceInfo.getCallback().getServiceURLResponse(coreServiceInfo.getServiceID(), null);
                } else if (coreServiceInfo.getCallbackNotUsed() != null) {
                    String string2 = new String(coreServiceInfo.getServiceID());
                    coreServiceInfo.getCallbackNotUsed().getServiceURLResponse(new CoreServiceUrlHandler$3(this, string2), null);
                }
                coreServiceInfo.clear();
                coreServiceInfo = null;
            }
            this.getProcessingQueueMap().clear();
        }
    }

    private ObjectObjectOptHashMap getProcessingQueueMap() {
        if (this._processingForUrlMap == null) {
            this._processingForUrlMap = new ObjectObjectOptHashMap();
        }
        return this._processingForUrlMap;
    }

    private void fireCallback() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".fireCallback()").log();
        }
        ServiceManager.aslThreadSwitch.enqueue(new CoreServiceUrlHandler$4(this));
    }
}

