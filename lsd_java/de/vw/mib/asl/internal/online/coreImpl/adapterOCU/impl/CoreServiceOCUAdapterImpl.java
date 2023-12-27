/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.CoreServiceOCUFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.states.CoreServiceOCUTarget;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCollector;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterListener;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;

public class CoreServiceOCUAdapterImpl
implements CoreServiceAdapter {
    private final String _classname = super.getClass().getName();
    private final CoreServiceOCUTarget _target;
    final int[] SUPPORTED_FUNCTIONS = new int[]{2, 3, 7, 5, 6, 8, 10, 11};

    public CoreServiceOCUAdapterImpl(CoreServiceOCUTarget coreServiceOCUTarget) {
        this._target = coreServiceOCUTarget;
    }

    @Override
    public void setAsMainDevice(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".setAsMainDevice( deviceID = ").append(n).append(")").toString()).log();
        }
        if (CoreServiceOCUFactory.getController(this._target).getDevice() != null) {
            CoreServiceOCUFactory.getController(this._target).getDevice().setDeviceType(n == CoreServiceOCUFactory.getController(this._target).getDevice().getDeviceID() ? 1 : 2);
            CoreServiceOCUFactory.getController(this._target).checkForRegistrationStatus();
        }
    }

    @Override
    public void setLanguage(String string) {
    }

    @Override
    public void resetToFactorySettings(String string, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".resetToFactorySettings(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(" )").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getNetworkService() != null) {
                CoreServiceOCUFactory.getNotifier().getEventQueue().put(1, new CoreServiceCollector(CoreServiceOCUFactory.getNotifier().generateUniqueID(1), string, null, coreServiceAdapterListener));
                this._target.getNetworkService().restoreFactorySettings(CoreServiceOCUFactory.getResponseListener());
            } else {
                this._target.info().append(this._classname).append(".resetToFactorSettings()").append("Network Service interface is invalid").log();
            }
        } else {
            this._target.info().append(this._classname).append(".resetToFactorSettings()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void validateOwner(User user, String string, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".validateOwner(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(" )").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getNetworkService() != null) {
                CoreServiceOCUFactory.getNotifier().getEventQueue().put(3, new CoreServiceCollector(CoreServiceOCUFactory.getNotifier().generateUniqueID(3), null, null, user, coreServiceAdapterListener));
                this._target.getNetworkService().pairMainUser(null, string, CoreServiceOCUFactory.getResponseListener());
            } else {
                this._target.info().append(this._classname).append(".validateOwner()").append("Network Service interface is invalid").log();
            }
        } else {
            this._target.info().append(this._classname).append(".validateOwner()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void forceOwnerValidation(boolean bl, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".forceOwnerValidation(").append(bl).append(")").toString()).log();
        }
        if (coreServiceAdapterListener != null) {
            CoreServiceOCUFactory.getNotifier().getEventQueue().put(13, new CoreServiceCollector(CoreServiceOCUFactory.getNotifier().generateUniqueID(13), null, null, null, coreServiceAdapterListener));
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this._target.getDefaultTargetId(), this._target.getDefaultTargetId(), -1568276224);
            this._target.sendSafe(eventGeneric);
        } else {
            this._target.info().append(this._classname).append(".forceOwnerValidation()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void verifyOwner(User user, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".verifyOwner()").log();
        }
        if (coreServiceAdapterListener == null) {
            this._target.info().append(this._classname).append(".verifyOwner()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void setServiceState(String string, int n, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setServiceState(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(" )").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getNetworkService() != null) {
                CoreServiceOCUFactory.getNotifier().getEventQueue().put(11, new CoreServiceCollector(CoreServiceOCUFactory.getNotifier().generateUniqueID(11), string, null, coreServiceAdapterListener));
                boolean bl = n == 2;
                this._target.getNetworkService().setServiceBlocking(CoreServiceOCUFactory.getController(this._target).getServiceEntryWithServiceID(string), bl);
            } else {
                this._target.info().append(this._classname).append(".setServiceState()").append("Network Service interface is invalid").log();
            }
        } else {
            this._target.info().append(this._classname).append(".setServiceState()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void resetToFactorySettingsWithServiceName(String string, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".resetToFactorySettingsWithServiceName(").append(", ").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(" )").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getNetworkService() != null) {
                CoreServiceOCUFactory.getNotifier().getEventQueue().put(1, new CoreServiceCollector(CoreServiceOCUFactory.getNotifier().generateUniqueID(1), "", string, null, coreServiceAdapterListener));
                this._target.getNetworkService().restoreFactorySettings(CoreServiceOCUFactory.getResponseListener());
            } else {
                this._target.info().append(this._classname).append(".resetToFactorSettingsWithServiceName()").append("Network Service interface is invalid").log();
                coreServiceAdapterListener.resetToFactorSettingsWithServiceNameResponse(1, string, 29);
            }
        } else {
            this._target.info().append(this._classname).append(".resetToFactorSettingsWithServiceName()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void checkServiceStatus(String string, User user, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".checkServiceStatus(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(" )").log();
        }
        if (coreServiceAdapterListener != null) {
            CoreServiceOCUFactory.getNotifier().getEventQueue().put(5, new CoreServiceCollector(CoreServiceOCUFactory.getNotifier().generateUniqueID(5), string, user, coreServiceAdapterListener));
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this._target.getDefaultTargetId(), this._target.getDefaultTargetId(), -1585053440);
            eventGeneric.setString(0, string);
            this._target.sendSafe(eventGeneric);
        } else {
            this._target.info().append(this._classname).append(".checkServiceStatus()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void setRoamingEnabled(boolean bl) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setRoamingEnabled()").log();
        }
    }

    @Override
    public void addUpdateListener(CoreServiceAdapterUpdateListener coreServiceAdapterUpdateListener) {
        CoreServiceOCUFactory.getNotifier().setUpdateListener(coreServiceAdapterUpdateListener);
    }

    @Override
    public void removeUpdateListener(CoreServiceAdapterUpdateListener coreServiceAdapterUpdateListener) {
        if (coreServiceAdapterUpdateListener != null && coreServiceAdapterUpdateListener == CoreServiceOCUFactory.getNotifier().getUpdateListener()) {
            CoreServiceOCUFactory.getNotifier().setUpdateListener(null);
        }
    }

    @Override
    public int[] getSupportedFuntions() {
        return this.SUPPORTED_FUNCTIONS;
    }

    @Override
    public boolean isFuntionSupported(int n) {
        if (!Util.isNullOrEmpty(this.SUPPORTED_FUNCTIONS)) {
            int n2 = this.SUPPORTED_FUNCTIONS.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.SUPPORTED_FUNCTIONS[i2] != n) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void activateGroup(int n, int n2, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    @Override
    public void sendPrivacyModeStatus(boolean bl, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (coreServiceAdapterListener != null) {
            CoreServiceOCUFactory.getNotifier().getEventQueue().put(15, new CoreServiceCollector(CoreServiceOCUFactory.getNotifier().generateUniqueID(15), null, null, coreServiceAdapterListener));
            this._target.getNetworkService().setPrivacyMode(bl);
        } else {
            this._target.info().append(this._classname).append(".checkAuthentication()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void submitCurrentServicesStateToBackend() {
        this._target.getNetworkService().synchronizeServiceListWithBackend(CoreServiceOCUFactory.getResponseListener());
    }
}

