/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD.impl;

import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.CoreServiceMODFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control.CoreServiceMODUtils;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.states.CoreServiceMODTarget;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCollector;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterListener;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.util.Util;

public class CoreServiceMODAdapterImpl
implements CoreServiceAdapter {
    private final String _classname = super.getClass().getName();
    private final CoreServiceMODTarget _target;
    final int[] SUPPORTED_FUNCTIONS = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 11};

    public CoreServiceMODAdapterImpl(CoreServiceMODTarget coreServiceMODTarget) {
        this._target = coreServiceMODTarget;
    }

    @Override
    public void setAsMainDevice(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".setAsMainDevice( deviceID = ").append(n).append(")").toString()).log();
        }
        if (CoreServiceMODFactory.getController(this._target).getDevice() != null) {
            CoreServiceMODFactory.getController(this._target).getDevice().setDeviceType(n == CoreServiceMODFactory.getController(this._target).getDevice().getDeviceID() ? 1 : 2);
            if (CoreServiceMODFactory.getController(this._target).getDevice().isMainDevice()) {
                CoreServiceMODFactory.getController(this._target).sendRegistrationStatus();
            }
        }
        this._target.setApplicationProperty(n != this._target.getDeviceID() ? "CoreServicesV1" : "NoCS");
    }

    @Override
    public void setLanguage(String string) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setLanguage(").append(string).log();
        }
        if (this._target.getDSIOnlineServiceRegistration() != null) {
            this._target.getDSIOnlineServiceRegistration().setLanguage(string);
        }
    }

    @Override
    public void resetToFactorySettings(String string, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".resetToFactorySettings()").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(1, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(1), string, null, coreServiceAdapterListener));
                this._target.getDSIOnlineServiceRegistration().resetToFactorySettings(string);
            } else {
                this._target.info().append(this._classname).append(".resetToFactorSettings()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".resetToFactorSettings()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void validateOwner(User user, String string, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".validateOwner(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(")").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null && !Util.isNullOrEmpty(string)) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(3, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(3), null, null, user, coreServiceAdapterListener));
                this._target.getDSIOnlineServiceRegistration().validateOwner(string);
            } else {
                this._target.info().append(this._classname).append(".validateOwner()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".validateOwner()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void forceOwnerValidation(boolean bl, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".forceOwnerValidation(").append(bl).append(")").log();
        }
        if (CoreServiceMODFactory.getController(this._target).checkIfServiceStateBitSet(8) != bl) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                this._target.info().append(this._classname).append(".validateOwnerForce(").append(bl).append(")").log();
                this._target.getDSIOnlineServiceRegistration().validateOwnerForce(bl);
            } else {
                this._target.info().append(this._classname).append(".forceOwnerValidation()").append("--> DSI Instance is NULL").log();
            }
        }
    }

    @Override
    public void verifyOwner(User user, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".verifyOwner(").append(user == null ? "NULL" : user.toString()).append(")").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(2, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(2), null, null, user, coreServiceAdapterListener));
                this._target.getDSIOnlineServiceRegistration().checkOwnersVerification();
            } else {
                this._target.info().append(this._classname).append(".verifyOwner()").append("--> DSI Instance is NULL").log();
            }
        }
    }

    @Override
    public void setServiceState(String string, int n, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setServiceState(").append(CoreServiceMODUtils.getAdapterStateWithServiceState(n)).append(")").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(11, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(11), string, null, coreServiceAdapterListener));
                n = CoreServiceMODFactory.getController(this._target).getRoamingEnabled() && CoreServiceMODUtils.getAdapterStateWithServiceState(n) != 0 ? Util.setBit(2, CoreServiceMODUtils.getAdapterStateWithServiceState(n)) : CoreServiceMODUtils.getAdapterStateWithServiceState(n);
                this._target.getDSIOnlineServiceRegistration().setServiceState(string, n);
            } else {
                this._target.info().append(this._classname).append(".setServiceState()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".setServiceState()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void checkServiceStatus(String string, User user, CoreServiceAdapterListener coreServiceAdapterListener) {
        this._target.info().append(this._classname).append(".checkServiceStatus( Service ID : ").append(Util.isNullOrEmpty(string) ? "" : string).append("  )").log();
        if (coreServiceAdapterListener != null) {
            CoreServiceMODFactory.getNotifier().getEventQueue().put(5, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(5), string, null, coreServiceAdapterListener));
            CoreServiceMODFactory.getController(this._target).precheckOnlineServiceRequest(string);
        } else {
            this._target.info().append(this._classname).append(".checkAuthentication()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void addUpdateListener(CoreServiceAdapterUpdateListener coreServiceAdapterUpdateListener) {
        if (coreServiceAdapterUpdateListener != null) {
            CoreServiceMODFactory.getNotifier().setUpdateListener(coreServiceAdapterUpdateListener);
        }
    }

    @Override
    public void removeUpdateListener(CoreServiceAdapterUpdateListener coreServiceAdapterUpdateListener) {
        if (coreServiceAdapterUpdateListener != null && coreServiceAdapterUpdateListener == CoreServiceMODFactory.getNotifier().getUpdateListener()) {
            CoreServiceMODFactory.getNotifier().setUpdateListener(null);
        }
    }

    @Override
    public void resetToFactorySettingsWithServiceName(String string, CoreServiceAdapterListener coreServiceAdapterListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".resetToFactorySettingsWithServiceName()").log();
        }
        if (coreServiceAdapterListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(1, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(1), CoreServiceMappingTable.getServiceIDWithServiceName(string), string, null, coreServiceAdapterListener));
                this._target.getDSIOnlineServiceRegistration().resetToFactorySettings(CoreServiceMappingTable.getServiceIDWithServiceName(string));
            } else {
                this._target.info().append(this._classname).append(".resetToFactorSettingsWithServiceName()").append("--> DSI Instance is NULL").log();
                coreServiceAdapterListener.resetToFactorySettingsResponse(2, string, 29);
            }
        } else {
            this._target.info().append(this._classname).append(".resetToFactorSettingsWithServiceName()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void setRoamingEnabled(boolean bl) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".setRoamingEnabled(").append(bl).append(")").toString()).log();
        }
        CoreServiceMODFactory.getController(this._target).handleRoaming(bl);
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
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(15, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(15), null, null, coreServiceAdapterListener));
                boolean bl2 = false;
                this._target.getDSIOnlineServiceRegistration().setActivePrivacyCategoryMask(bl ? Util.setBit(32, 0) : 0);
            } else {
                this._target.info().append(this._classname).append(".checkAuthentication()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".checkAuthentication()").append("-->CoreServiceAdapterListener is NULL").log();
        }
    }

    @Override
    public void submitCurrentServicesStateToBackend() {
        if (this._target.getDSIOnlineServiceRegistration() != null) {
            this._target.getDSIOnlineServiceRegistration().submitServiceStateChangesToBackend();
        } else {
            this._target.info().append(this._classname).append(".submitServiceStateChangesToBackend()").append("--> DSI Instance is NULL").log();
        }
    }
}

