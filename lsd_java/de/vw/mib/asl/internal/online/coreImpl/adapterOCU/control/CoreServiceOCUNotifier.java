/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCollector;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.TrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.Iterator;

public class CoreServiceOCUNotifier {
    private final String _classname = super.getClass().getName();
    private IntObjectMultimap _requestResponseQueue;
    private CoreServiceAdapterUpdateListener _updateListener;

    private CoreServiceCollector getValueWithIndexOrID(int n, int n2, int n3) {
        ObjectCollection objectCollection;
        if (this.getEventQueue().containsKey(n) && (objectCollection = this.getEventQueue().getAll(n)).size() >= 1) {
            int n4 = 0;
            Iterator iterator = objectCollection.iterator();
            while (iterator.hasNext()) {
                CoreServiceCollector coreServiceCollector = (CoreServiceCollector)iterator.next();
                if (n2 > -1) {
                    if (n2 == n4) {
                        return coreServiceCollector;
                    }
                    ++n4;
                    continue;
                }
                if (n3 > 0 && coreServiceCollector.getUniqueID() == n3) {
                    return coreServiceCollector;
                }
                return coreServiceCollector;
            }
        }
        return null;
    }

    public IntObjectMultimap getEventQueue() {
        if (this._requestResponseQueue == null) {
            this._requestResponseQueue = new IntObjectMultimap();
        }
        return this._requestResponseQueue;
    }

    public int generateUniqueID(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".generateUniqueID(").append(n).append(")").toString()).log();
        }
        int n2 = 1;
        if (this.getEventQueue().containsKey(n)) {
            ObjectCollection objectCollection = this.getEventQueue().getAll(n);
            Iterator iterator = objectCollection.iterator();
            while (iterator.hasNext()) {
                CoreServiceCollector coreServiceCollector = (CoreServiceCollector)iterator.next();
                n2 = coreServiceCollector.getUniqueID() + 1;
            }
        }
        return n2;
    }

    public void setUpdateListener(CoreServiceAdapterUpdateListener coreServiceAdapterUpdateListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".setUpdateListener(").append(coreServiceAdapterUpdateListener != null ? coreServiceAdapterUpdateListener.toString() : "null").append(")").toString()).log();
        }
        this._updateListener = coreServiceAdapterUpdateListener;
    }

    public CoreServiceAdapterUpdateListener getUpdateListener() {
        return this._updateListener;
    }

    public void updateRegistrationStatus(int n, int n2) {
        LogMessage logMessage = ServiceManager.logger2.info(16384);
        logMessage.append(this._classname).append(new StringBuffer().append(".updateRegistrationStatus( status = ").append(n).append(", DeviceID = ").append(n2).append(")").toString()).log();
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateRegistrationStatus(n, n2);
        }
    }

    public void updateDevice(Device device, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateDevice()").log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateDevice(device, n);
        }
    }

    public void updateUserList(User[] userArray, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateUserList()").log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateUserList(userArray, n);
        }
    }

    public void updateServiceList(Service[] serviceArray, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateServiceList()").log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateServiceList(serviceArray, n);
        }
    }

    public void updateTrackingServicesActivation(TrackingService[] trackingServiceArray, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateTrackingServicesActivation()").log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateTrackingServicesActivation(trackingServiceArray, n);
        }
    }

    public void updatePrivacyModeStatus(boolean bl, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updatePrivacyModeStatus(").append(bl).append(",").append(n).append(")").toString()).log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updatePrivacyModeStatus(bl, n);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updatePrivacyModeStatus()--> listener = null").log();
        }
    }

    public void updateServiceListState(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateServiceListState(").append(n).append(",").append(n2).append(")").toString()).log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateServiceListState(n, n2);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updateServiceListState()--> listener = null").log();
        }
    }

    public void resetToFactorySettingsResponse(int n, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".resetToFactorySettingsResponse( deviceID = ").append(n).append(", result = ").append(n2).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(1)) {
            object = this.getValueWithIndexOrID(1, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().resetToFactorySettingsResponse(n, ((CoreServiceCollector)object).getServiceID(), n2);
            }
            if (n2 == 0) {
                this.getEventQueue().clear();
            }
        }
    }

    public void userVerificationResponse(int n) {
        if (this.getEventQueue().containsKey(2)) {
            CoreServiceCollector coreServiceCollector = this.getValueWithIndexOrID(2, -1, 0);
            if (coreServiceCollector != null && coreServiceCollector.getAdapterListener() != null) {
                coreServiceCollector.getAdapterListener().resetToFactorySettingsResponse(1, coreServiceCollector.getServiceID(), n);
            }
            this.getEventQueue().removeValue(2, coreServiceCollector);
        }
    }

    public void validateOwnerResponse(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".validateOwnerResponse( result = ").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(3)) {
            object = this.getValueWithIndexOrID(3, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().validateOwnerResponse(null, n);
            }
            this.getEventQueue().removeValue(3, object);
        }
    }

    public void serviceStateResponse(Service service) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".serviceStateResponse( Service = ").append(service != null ? service.toString() : "NULL").append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(11)) {
            object = this.getValueWithIndexOrID(11, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().serviceStateResponse(service);
            }
            this.getEventQueue().removeValue(11, object);
        }
    }

    public void checkServiceStatusResponse(String string, int n) {
        LogMessage logMessage = ServiceManager.logger2.info(16384);
        logMessage.append(this._classname).append(".checkServiceStatusResponse( Service ID : ").append(!Util.isNullOrEmpty(string) ? string : "EMPTY").append(new StringBuffer().append(", result = ").append(n).toString()).append("  )").log();
        if (this.getEventQueue().containsKey(5)) {
            CoreServiceCollector coreServiceCollector = this.getValueWithIndexOrID(5, -1, 0);
            if (coreServiceCollector != null && coreServiceCollector.getAdapterListener() != null) {
                coreServiceCollector.getAdapterListener().checkServiceStatusResponse(string, n);
            }
            this.getEventQueue().removeValue(5, coreServiceCollector);
        }
    }

    public void forceValidationresponse(int n) {
        if (this.getEventQueue().containsKey(13)) {
            CoreServiceCollector coreServiceCollector = this.getValueWithIndexOrID(13, -1, 0);
            if (coreServiceCollector != null && coreServiceCollector.getAdapterListener() != null) {
                coreServiceCollector.getAdapterListener().forceOwnerValidationResponse(n);
            }
            this.getEventQueue().removeValue(13, coreServiceCollector);
        }
    }

    public boolean sendPrivacyModeStatusResponse(int n, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".sendPrivacyModeStatusResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(15)) {
            object = this.getValueWithIndexOrID(15, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().sendPrivacyModeStatusResponse(n, n2);
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".sendPrivacyModeStatusResponse(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            this.getEventQueue().removeValue(15, object);
            return true;
        }
        return false;
    }
}

