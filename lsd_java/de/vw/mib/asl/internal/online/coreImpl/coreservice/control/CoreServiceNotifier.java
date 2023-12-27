/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCollector;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineApplication;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceUpdateListener;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.Iterator;

public class CoreServiceNotifier {
    private final String _classname = super.getClass().getName();
    private ObjectArrayList _listenerList;
    private IntObjectMultimap _requestResponseQueue;

    private ObjectArrayList getListenerList() {
        if (this._listenerList == null) {
            this._listenerList = new ObjectArrayList();
        }
        return this._listenerList;
    }

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

    public void addListener(CoreServiceUpdateListener coreServiceUpdateListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".addListener(").append(coreServiceUpdateListener != null ? coreServiceUpdateListener.toString() : "null").append(")").toString()).log();
        }
        if (!this.getListenerList().contains(coreServiceUpdateListener)) {
            this.getListenerList().add(coreServiceUpdateListener);
        }
    }

    public void removeListener(CoreServiceUpdateListener coreServiceUpdateListener) {
        if (this.getListenerList().contains(coreServiceUpdateListener)) {
            this.getListenerList().removeValue(coreServiceUpdateListener);
        }
    }

    public void updateRegisteredDeviceType(int n) {
        if (!this.getListenerList().isEmpty()) {
            Iterator iterator = this.getListenerList().iterator();
            while (iterator.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)iterator.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updateRegisteredDeviceType(n);
            }
        }
    }

    public void updateUserList(OnlineUser[] onlineUserArray) {
        if (!this.getListenerList().isEmpty()) {
            Iterator iterator = this.getListenerList().iterator();
            while (iterator.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)iterator.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updateUserList(onlineUserArray);
            }
        }
    }

    public void updateServiceList(OnlineService[] onlineServiceArray) {
        if (!this.getListenerList().isEmpty()) {
            Iterator iterator = this.getListenerList().iterator();
            while (iterator.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)iterator.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updateServiceList(onlineServiceArray);
            }
        }
    }

    public void updateRegistrationStatus(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".updateRegistrationStatus(").append(n).append(")").toString()).log();
        }
        if (!this.getListenerList().isEmpty()) {
            object = this.getListenerList().iterator();
            while (object.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)object.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updateRegistrationStatus(n);
            }
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updateRegistrationStatus(listener = EMPTY)").log();
        }
    }

    public void updateDeviceReadyForUse(int n) {
        if (!this.getListenerList().isEmpty()) {
            Iterator iterator = this.getListenerList().iterator();
            while (iterator.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)iterator.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updateDeviceReadyForUse(n);
            }
        }
    }

    public void updateTrackingServicesActivation(OnlineTrackingService[] onlineTrackingServiceArray) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".updateTrackingServicesActivation()").log();
        }
        if (!this.getListenerList().isEmpty()) {
            object = this.getListenerList().iterator();
            while (object.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)object.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updateTrackingServicesActivation(onlineTrackingServiceArray);
            }
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updateTrackingServicesActivation(listener = EMPTY)").log();
        }
    }

    public void updatePrimaryUserPopupActivation(OnlineUser onlineUser) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".updatePrimaryUserPopupActivation(").append(onlineUser != null ? onlineUser.toString() : "User=NULL").append(")").toString()).log();
        }
        if (!this.getListenerList().isEmpty()) {
            object = this.getListenerList().iterator();
            while (object.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)object.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updatePrimaryUserPopupActivation(onlineUser);
            }
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updatePrimaryUserPopupActivation(listener = EMPTY)").log();
        }
    }

    public void updatePrivacyModeStatus(boolean bl) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".updatePrivacyModeStatus(").append(bl).append(")").toString()).log();
        }
        if (!this.getListenerList().isEmpty()) {
            object = this.getListenerList().iterator();
            while (object.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)object.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updatePrivacyModeStatus(bl);
            }
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updatePrivacyModeStatus(listener = EMPTY)").log();
        }
    }

    public void updateCumulativeServiceListState(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".updateCumulativeServiceListState(").append(n).append(")").toString()).log();
        }
        if (!this.getListenerList().isEmpty()) {
            object = this.getListenerList().iterator();
            while (object.hasNext()) {
                CoreServiceUpdateListener coreServiceUpdateListener = (CoreServiceUpdateListener)object.next();
                if (coreServiceUpdateListener == null) continue;
                coreServiceUpdateListener.updateCumulativeServiceListState(n);
            }
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updateCumulativeServiceListState(listener = EMPTY)").log();
        }
    }

    public void resetToFactorSettingsResponse(int n, String string, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".resetToFactorySettingsResponse(").append(n2).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(1)) {
            object = this.getValueWithIndexOrID(1, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().resetToFactorySettingsResponse(n, string, n2);
            }
            this.getEventQueue().removeValue(1, object);
        }
    }

    public void resetToFactorSettingsWithServiceNameResponse(int n, String string, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".resetToFactorySettingsWithServiceNameResponse(").append(n2).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(1)) {
            object = this.getValueWithIndexOrID(1, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().resetToFactorySettingsWithServiceNameResponse(n, string, n2);
            }
            this.getEventQueue().removeValue(1, object);
        }
    }

    public void getUserListResponse(OnlineUser[] onlineUserArray, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".getUserListResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(4)) {
            object = this.getValueWithIndexOrID(4, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().getUserListResponse(onlineUserArray, n);
            }
            this.getEventQueue().removeValue(4, object);
        }
    }

    public void validateUserResponse(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".validateUserResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(2)) {
            object = this.getValueWithIndexOrID(2, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().verifyUserResponse(n);
            }
            this.getEventQueue().removeValue(2, object);
        }
    }

    public void setActiveUserResponse(OnlineUser onlineUser, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".setActiveUserResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(6)) {
            object = this.getValueWithIndexOrID(6, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().setActiveUserResponse(onlineUser, n);
            }
            this.getEventQueue().removeValue(6, object);
        }
    }

    public void getActiveUserResponse(OnlineUser onlineUser, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".getActiveUserResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(7)) {
            object = this.getValueWithIndexOrID(7, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().getActiveUserResponse(onlineUser, n);
            }
            this.getEventQueue().removeValue(7, object);
        }
    }

    public void validatePinResponse(OnlineUser onlineUser, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".validatePinResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(3)) {
            object = this.getValueWithIndexOrID(3, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().validatePinResponse(onlineUser, n);
            }
            this.getEventQueue().removeValue(3, object);
        }
    }

    public void checkAuthenticationResponse(String string, int n) {
        boolean bl;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".checkAuthenticationResponse(").append(n).append(")").toString()).log();
        }
        CoreServiceCollector coreServiceCollector = (bl = this.getEventQueue().containsKey(5)) ? this.getValueWithIndexOrID(5, -1, 0) : null;
        boolean bl2 = bl = coreServiceCollector != null && coreServiceCollector.getClientListener() != null && !Util.isNullOrEmpty(string) && !Util.isNullOrEmpty(coreServiceCollector.getServiceID()) && string.equalsIgnoreCase(coreServiceCollector.getServiceID());
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".checkAuthenticationResponse(").append(n).append(") --> In Queue : ").append(bl).toString()).log();
        }
        if (bl && coreServiceCollector != null) {
            coreServiceCollector.getClientListener().checkServiceStatusResponse(coreServiceCollector.getServiceID(), n);
            this.getEventQueue().removeValue(5, coreServiceCollector);
        } else {
            CoreServiceImplFactory.getStatusHandler().authenticationResult(n);
        }
    }

    public void checkServiceStatusWithServiceNameResponse(OnlineApplication onlineApplication, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".checkServiceStatusWithServiceNameResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(5)) {
            object = this.getValueWithIndexOrID(5, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().checkServiceStatusWithServiceNameResponse(((CoreServiceCollector)object).getServiceID(), n);
            }
            this.getEventQueue().removeValue(5, object);
        } else {
            CoreServiceImplFactory.getStatusHandler().authenticationResult(n);
        }
    }

    public void getApplicationOrServiceResponse(String string, OnlineApplication onlineApplication, OnlineService onlineService, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".getApplicationOrServiceResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(9)) {
            object = this.getValueWithIndexOrID(9, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().getServiceResponse(string, onlineService, n);
            }
            this.getEventQueue().removeValue(9, object);
        }
    }

    public void setStateResponse(OnlineService onlineService) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".setStateResponse()").log();
        }
        if (this.getEventQueue().containsKey(11)) {
            object = this.getValueWithIndexOrID(11, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().setStateResponse(((CoreServiceCollector)object).getServiceID(), onlineService);
            }
            this.getEventQueue().removeValue(11, object);
        }
    }

    public void getServiceURLResponse(String string, String string2, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".getServiceURLResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(12)) {
            object = this.getValueWithIndexOrID(12, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().getServiceURLResponse(string, string2, n);
            }
            this.getEventQueue().removeValue(12, object);
        }
    }

    public void getServiceURLWithServiceNameResponse(String string, String string2, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".getServiceURLWithServiceNameResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(12)) {
            object = this.getValueWithIndexOrID(12, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().getServiceURLWithServiceNameResponse(string, string2, n);
            }
            this.getEventQueue().removeValue(12, object);
        }
    }

    public void sendPrivacyModeStatusResponse(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".sendPrivacyModeStatusResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(15)) {
            object = this.getValueWithIndexOrID(15, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getClientListener() != null) {
                ((CoreServiceCollector)object).getClientListener().sendPrivacyModeStatusResponse(n);
            }
            this.getEventQueue().removeValue(15, object);
        }
    }
}

