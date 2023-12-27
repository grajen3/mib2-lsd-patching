/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCollector;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreService;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceListener;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceUpdateListener;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;

public class CoreServiceImpl
implements CoreService {
    private final String _classname = super.getClass().getName();

    @Override
    public void setLanguage(String string) {
        Object[] objectArray = CoreServiceFactory.getAdapterRegister().getAdapterList();
        if (!Util.isNullOrEmpty(objectArray)) {
            int n = objectArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (objectArray[i2] == null) continue;
                objectArray[i2].setLanguage(string);
            }
        }
    }

    @Override
    public void resetToFactorySettingsWithServiceName(String string, CoreServiceListener coreServiceListener) {
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(1, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(1), "", string, null, coreServiceListener));
            Object[] objectArray = CoreServiceFactory.getAdapterRegister().getAdapterList();
            if (!Util.isNullOrEmpty(objectArray)) {
                int n = objectArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    if (objectArray[i2] == null || objectArray[i2] != CoreServiceFactory.getAdapterRegister().getMainAdapter()) continue;
                    objectArray[i2].resetToFactorySettingsWithServiceName(string, CoreServiceImplFactory.getAdapterListener());
                }
            }
        }
    }

    @Override
    public void resetToFactorySettings(String string, CoreServiceListener coreServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".resetToFactorySettings(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(1, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(1), string, null, coreServiceListener));
            CoreServiceImplFactory.getFactoryResetHandler().requestResetToFactorySettings(string);
        }
    }

    @Override
    public void getUserList(CoreServiceListener coreServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".getUserList(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            coreServiceListener.getUserListResponse(CoreServiceImplFactory.getCoreServiceController().getClientUserList(), 0);
        }
    }

    @Override
    public void setActiveUser(OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".setActiveUser(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            coreServiceListener.setActiveUserResponse(null, 0);
        }
    }

    @Override
    public void getActiveUser(CoreServiceListener coreServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".getActiveUser(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            // empty if block
        }
    }

    @Override
    public void validatePin(OnlineUser onlineUser, String string, CoreServiceListener coreServiceListener) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".validatePin(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(3, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(3), null, null, onlineUser, coreServiceListener));
            object = null;
            if (onlineUser != null) {
                Device device = CoreServiceImplFactory.getCoreServiceController().getDeviceWithUserID(onlineUser.getUserID());
                object = CoreServiceFactory.getAdapterRegister().getAdapterWithID(device.getDeviceID());
            } else {
                object = CoreServiceFactory.getAdapterRegister().getMainAdapter();
            }
            if (object != null) {
                object.validateOwner(CoreServiceImplFactory.getCoreServiceController().getRealUserWithClientUser(onlineUser), string, CoreServiceImplFactory.getAdapterListener());
            }
        }
    }

    @Override
    public void verifyUser(OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".validatePin(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(2, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(2), null, null, onlineUser, coreServiceListener));
            object = null;
            if (onlineUser != null) {
                Device device = CoreServiceImplFactory.getCoreServiceController().getDeviceWithUserID(onlineUser.getUserID());
                object = CoreServiceFactory.getAdapterRegister().getAdapterWithID(device.getDeviceID());
            } else {
                object = CoreServiceFactory.getAdapterRegister().getMainAdapter();
            }
            if (object != null) {
                object.verifyOwner(CoreServiceImplFactory.getCoreServiceController().getRealUserWithClientUser(onlineUser), CoreServiceImplFactory.getAdapterListener());
            }
        }
    }

    @Override
    public void checkServiceStatus(String string, OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".checkServiceStatus(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(5, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(5), string, onlineUser, coreServiceListener));
            CoreServiceImplFactory.getCoreServiceController().checkServiceStatus(string, CoreServiceMappingTable.getServiceNameWithServiceID(string), onlineUser);
        }
    }

    @Override
    public void getService(String string, CoreServiceListener coreServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".getApplicationOrService(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null && !Util.isNullOrEmpty(string) && CoreServiceImplFactory.getCoreServiceController().getClientServiceWithID(string) != null) {
            coreServiceListener.getServiceResponse(string, CoreServiceImplFactory.getCoreServiceController().getClientServiceWithID(string), 0);
        }
    }

    @Override
    public void getServiceURL(String string, CoreServiceListener coreServiceListener) {
        Object[] objectArray;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            objectArray = ServiceManager.logger2.trace(16384);
            objectArray.append(this._classname).append(".getServiceURL(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(12, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(12), null, string, null, coreServiceListener));
            if (!Util.isNullOrEmpty(CoreServiceFactory.getExternalRegister().getRegisteredExternals()) && !Util.isNullOrEmpty(objectArray = CoreServiceFactory.getExternalRegister().getExternalsWithSupportedFunction(1))) {
                int n = objectArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    objectArray[i2].getServiceURL(string, CoreServiceImplFactory.getExternalListener());
                }
            }
        }
    }

    @Override
    public void setState(String string, int n, CoreServiceListener coreServiceListener) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".setState(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(11, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(11), string, null, coreServiceListener));
            object = CoreServiceImplFactory.getCoreServiceController().getDeviceWithServiceID(string);
            CoreServiceAdapter coreServiceAdapter = CoreServiceFactory.getAdapterRegister().getAdapterWithID(object.getDeviceID());
            if (coreServiceAdapter != null) {
                coreServiceAdapter.setServiceState(string, n, CoreServiceImplFactory.getAdapterListener());
            }
        }
    }

    @Override
    public void addUpdateListener(CoreServiceUpdateListener coreServiceUpdateListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".addUpdateListener(").append(coreServiceUpdateListener != null ? coreServiceUpdateListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceUpdateListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().addListener(coreServiceUpdateListener);
        }
    }

    @Override
    public void removeUpdateListener(CoreServiceUpdateListener coreServiceUpdateListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".removeUpdateListener(").append(coreServiceUpdateListener != null ? coreServiceUpdateListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceUpdateListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().removeListener(coreServiceUpdateListener);
        }
    }

    @Override
    public void isReady() {
        CoreServiceImplFactory.getCoreServiceController().initPersistence();
        CoreServiceImplFactory.getCoreServiceController().clientReady();
    }

    @Override
    public void setRoamingEnabled(boolean bl) {
        Object[] objectArray = CoreServiceFactory.getAdapterRegister().getAdapterListWithSupportedMethod(9);
        if (!Util.isNullOrEmpty(objectArray)) {
            int n = objectArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (objectArray[i2] == null) continue;
                objectArray[i2].setRoamingEnabled(bl);
            }
        }
    }

    @Override
    public void sendPrivacyModeStatus(boolean bl, CoreServiceListener coreServiceListener) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".sendPrivacyModeStatus(").append(coreServiceListener != null ? coreServiceListener.toString() : "NULL").append(" )").log();
        }
        if (coreServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceNotifier().getEventQueue().put(15, new CoreServiceCollector(CoreServiceImplFactory.getCoreServiceNotifier().generateUniqueID(15), "", "", null, coreServiceListener));
            CoreServiceImplFactory.getPrivacyModeHandler().handlePrivacyMode(bl, CoreServiceImplFactory.getCoreServiceController().getDeviceList());
        }
    }

    @Override
    public void submitCurrentServicesStateToBackend() {
        Object[] objectArray = CoreServiceFactory.getAdapterRegister().getAdapterList();
        if (!Util.isNullOrEmpty(objectArray)) {
            int n = objectArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (objectArray[i2] == null) continue;
                objectArray[i2].submitCurrentServicesStateToBackend();
            }
        }
    }

    @Override
    public void setTrackingServicesValidity(boolean bl) {
        Object[] objectArray;
        if (!Util.isNullOrEmpty(CoreServiceFactory.getExternalRegister().getRegisteredExternals()) && !Util.isNullOrEmpty(objectArray = CoreServiceFactory.getExternalRegister().getExternalsWithSupportedFunction(3))) {
            int n = objectArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                objectArray[i2].setTrackingServicesUpdateValid(bl);
            }
        }
    }
}

