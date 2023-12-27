/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCollector;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

public class CoreServiceMODNotifier {
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

    public void updateDeviceStatus(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateDeviceStatus( Status = ").append(n).append(", DeviceID = ").append(n2).append(")").toString()).log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateDeviceStatus(n, n2);
        }
    }

    public void updateDevice(Device device, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateDevice( deviceID = ").append(n).append(")").toString()).log();
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

    public void updateRegistrationStatus(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateRegistrationStatus(").append(n).append(",").append(n2).append(")").toString()).log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateRegistrationStatus(n, n2);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updateRegistrationStatus()--> listener = null").log();
        }
    }

    public void updatePrimaryUserDeviceStatus(boolean bl, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updatePrimaryUserDeviceStatus(").append(bl).append(",").append(n).append(")").toString()).log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updatePrimaryUserDeviceStatus(bl, n);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updatePrimaryUserDeviceStatus()--> listener = null").log();
        }
    }

    public void updatePrivacyModeStatus(boolean bl, int n) {
        if (!this.getEventQueue().containsKey(15)) {
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

    public void updateCumulativeServiceListState(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateCumulativeServiceListState(").append(n).append(",").append(n2).append(")").toString()).log();
        }
        if (this.getUpdateListener() != null) {
            this.getUpdateListener().updateCumulativeServiceListState(n, n2);
        } else {
            ServiceManager.logger2.info(16384).append(this._classname).append(".updateCumulativeServiceListState()--> listener = null").log();
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
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().resetToFactorySettingsResponse(n, ((CoreServiceCollector)object).getServiceID(), CoreServiceMappingTable.convertToInternalResultType(n2));
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".resetToFactorSettingsResponse(").append(n2).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            if (n2 == 0) {
                this.getEventQueue().clear();
            } else {
                this.getEventQueue().removeValue(1, object);
            }
        }
    }

    public void userVerificationResponse(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".userVerificationResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(2)) {
            object = this.getValueWithIndexOrID(2, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().verifyOwnerResponse(CoreServiceMappingTable.convertToInternalResultType(n));
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".userVerificationResponse(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            this.getEventQueue().removeValue(2, object);
        }
    }

    public void validateOwnerResponse(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".validateOwnerResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(3)) {
            object = this.getValueWithIndexOrID(3, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().validateOwnerResponse(((CoreServiceCollector)object).getUser(), CoreServiceMappingTable.convertToInternalOwnerVerificationResult(n));
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".validateOwnerResponse(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            this.getEventQueue().remove(3);
        }
    }

    public void forceOwnerValidation(int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".forceOwnerValidation(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(13)) {
            object = this.getValueWithIndexOrID(13, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().forceOwnerValidationResponse(CoreServiceMappingTable.convertToInternalOwnerVerificationResult(n));
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".forceOwnerValidation(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            this.getEventQueue().removeValue(13, object);
        }
    }

    public void serviceStateResponse(Service service) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".serviceStateResponse()").log();
        }
        if (this.getEventQueue().containsKey(11)) {
            object = this.getValueWithIndexOrID(11, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().serviceStateResponse(service);
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".serviceStateResponse()--> RESPONSE IS NOT SENDED").log();
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
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage2 = ServiceManager.logger2.trace(16384);
                logMessage2.append(this._classname).append(new StringBuffer().append(".checkServiceStatusResponse(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            this.getEventQueue().removeValue(5, coreServiceCollector);
        }
    }

    public void getServiceURLResponse(String string, String string2, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".getServiceURLResponse(").append(Util.isNullOrEmpty(string2) ? "NULL" : string2).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(12)) {
            object = this.getValueWithIndexOrID(12, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getExternalListener() != null) {
                if (string.equalsIgnoreCase(((CoreServiceCollector)object).getServiceID())) {
                    ((CoreServiceCollector)object).getExternalListener().getServiceURLResponse(string, string2, CoreServiceMappingTable.convertToInternalResultType(n));
                } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger2.trace(16384);
                    logMessage.append(this._classname).append(new StringBuffer().append(".getServiceURLResponse(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
                }
            }
            this.getEventQueue().removeValue(12, object);
        }
    }

    public void downloadImageResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".downloadImageResponse(").append(Util.isNullOrEmpty(string3) ? "NULL" : string3).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(14)) {
            object = this.getValueWithIndexOrID(14, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getExternalListener() != null) {
                ((CoreServiceCollector)object).getExternalListener().downloadImageResponse(((CoreServiceCollector)object).getServiceID(), !Util.isNullOrEmpty(string2) ? string2 : "", string3, resourceLocator, CoreServiceMappingTable.convertDownloadResult(n));
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".downloadImageResponse(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            this.getEventQueue().removeValue(14, object);
        }
    }

    public void sendPrivacyModeStatusResponse(int n, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".sendPrivacyModeStatusResponse(").append(n).append(")").toString()).log();
        }
        if (this.getEventQueue().containsKey(15)) {
            object = this.getValueWithIndexOrID(15, -1, 0);
            if (object != null && ((CoreServiceCollector)object).getAdapterListener() != null) {
                ((CoreServiceCollector)object).getAdapterListener().sendPrivacyModeStatusResponse(CoreServiceMappingTable.convertToInternalResultType(n), n2);
            } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".sendPrivacyModeStatusResponse(").append(n).append(")--> RESPONSE IS NOT SENDED").toString()).log();
            }
            this.getEventQueue().removeValue(15, object);
        }
    }

    public void calculateSPinHashResponse(String string, String string2, String string3, int n, String string4, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".calculateSPinHashResponse(").append(n2).append(")").toString()).log();
        }
        if ((object = this.getValueWithIndexOrID(16, -1, 0)) != null && ((CoreServiceCollector)object).getExternalListener() != null) {
            ((CoreServiceCollector)object).getExternalListener().calculateSPinHashResponse(((CoreServiceCollector)object).getServiceID(), string, string2, string3, n, string4, CoreServiceMappingTable.convertToInternalResultType(n2));
        } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".calculateSPinHashResponse(").append(n2).append(")--> RESPONSE IS NOT SENDED").toString()).log();
        }
        this.getEventQueue().removeValue(16, object);
    }

    public void setSPinResponse(String string, int n, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".setSPinResponse(").append(n2).append(")").toString()).log();
        }
        if ((object = this.getValueWithIndexOrID(17, -1, 0)) != null && ((CoreServiceCollector)object).getExternalListener() != null) {
            ((CoreServiceCollector)object).getExternalListener().setSPinResponse(string, n, CoreServiceMappingTable.convertToInternalResultType(n2));
        } else if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".setSPinResponse(").append(n2).append(")--> RESPONSE IS NOT SENDED").toString()).log();
        }
        this.getEventQueue().removeValue(17, object);
    }
}

