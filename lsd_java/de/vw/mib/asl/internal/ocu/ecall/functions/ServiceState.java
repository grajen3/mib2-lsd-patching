/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceState_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class ServiceState
extends ECallFunction
implements PropertyListener {
    private int _modelOcuServiceState;
    private int _modelOcuServiceType;
    private int _ocuServiceState;
    private int _ocuServiceType;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener;

    private ModelPhoneOcuCallListener getModelPhoneOcuCallListener() {
        return (ModelPhoneOcuCallListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener = ServiceState.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener);
    }

    private void _setModelOcuServiceState(int n, int n2) {
        if (this._modelOcuServiceState != n || this._modelOcuServiceType != n2) {
            this._modelOcuServiceState = n;
            this._modelOcuServiceType = n2;
            this.getModelPhoneOcuCallListener().updateServiceState(n, n2);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512).append("ServiceState: Update with new service state: serviceState=").append(n).append(", serviceType=").append(n2).log();
            }
        }
    }

    private void _setOcuServiceState(int n, int n2) {
        if (this._ocuServiceState != n || this._ocuServiceType != n2) {
            this._ocuServiceState = n;
            this._ocuServiceType = n2;
            this.getModelPhoneOcuCallListener().updateOcuMenuServiceType(this.getOcuMenuServiceType());
        }
    }

    int getServiceType() {
        return this._ocuServiceType;
    }

    int getOcuMenuServiceType() {
        int n = (this._ocuServiceType == 1 || this._ocuServiceType == 3) && this.isServiceStateInRoaUsmIclDialog(this._ocuServiceState) ? (this._ocuServiceState == 6 ? 1 : 2) : ((this._ocuServiceType == 5 || this._ocuServiceType == 4) && this.isServiceStateInMecAcnDialog(this._ocuServiceState) ? (this._ocuServiceState == 6 || this._ocuServiceState == 8 || this._ocuServiceState == 22 ? 1 : 2) : 0);
        return n;
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        }
    }

    @Override
    public void uninitialize() {
        this._setModelOcuServiceState(0, 0);
    }

    @Override
    public int getFunctionId() {
        return 26;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        ServiceState_Status serviceState_Status = (ServiceState_Status)bAPEntity;
        this._setOcuServiceState(serviceState_Status.serviceState, serviceState_Status.serviceType);
        if (!(serviceState_Status.serviceState != 12 && serviceState_Status.serviceState != 21 || serviceState_Status.serviceType != 1 && serviceState_Status.serviceType != 2 && serviceState_Status.serviceType != 3 && serviceState_Status.serviceType != 4 && serviceState_Status.serviceType != 5)) {
            this.informPhoneCallTerminatedByError(serviceState_Status.serviceType);
        } else if (serviceState_Status.serviceState == 13 && (serviceState_Status.serviceType == 1 || serviceState_Status.serviceType == 2 || serviceState_Status.serviceType == 3 || serviceState_Status.serviceType == 4 || serviceState_Status.serviceType == 5)) {
            this.informServiceCallNotLicensed();
        }
        if (!ServiceState.isInvalidCombination(serviceState_Status)) {
            this._setModelOcuServiceState(ServiceState._mapOcuServiceStateToModelServiceState(serviceState_Status.serviceState), ServiceState._mapOcuServiceTypeToModelServiceType(serviceState_Status.serviceType));
        } else {
            this._setModelOcuServiceState(0, 0);
        }
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    private boolean isServiceStateInMecAcnDialog(int n) {
        boolean bl;
        switch (n) {
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 12: 
            case 16: 
            case 18: 
            case 19: 
            case 21: 
            case 22: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private boolean isServiceStateInRoaUsmIclDialog(int n) {
        boolean bl;
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 12: 
            case 18: 
            case 22: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private static boolean isServiceStateInRoaIclNoDialing(int n) {
        boolean bl;
        switch (n) {
            case 7: 
            case 9: 
            case 10: 
            case 11: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 19: 
            case 20: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private static boolean isServiceStateInMecAcnNoDialing(int n) {
        boolean bl;
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 9: 
            case 10: 
            case 11: 
            case 14: 
            case 15: 
            case 17: 
            case 20: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private static boolean isInvalidCombination(ServiceState_Status serviceState_Status) {
        return (serviceState_Status.serviceType == 1 || serviceState_Status.serviceType == 3) && ServiceState.isServiceStateInRoaIclNoDialing(serviceState_Status.serviceState) || (serviceState_Status.serviceType == 5 || serviceState_Status.serviceType == 4) && ServiceState.isServiceStateInMecAcnNoDialing(serviceState_Status.serviceState);
    }

    private static int _mapOcuServiceStateToModelServiceState(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 8: 
            case 22: {
                n2 = 2;
                break;
            }
            case 12: 
            case 21: {
                n2 = 3;
                break;
            }
            case 18: {
                n2 = 4;
                break;
            }
            case 7: {
                n2 = 5;
                break;
            }
            case 19: {
                n2 = 6;
                break;
            }
            case 16: {
                n2 = 7;
                break;
            }
            case 5: {
                n2 = -1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static int _mapOcuServiceTypeToModelServiceType(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 1;
                break;
            }
            case 5: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void informPhoneCallTerminatedByError(int n) {
        int n2 = ServiceState._mapOcuServiceTypeToModelServiceType(n);
        this.getModelPhoneOcuCallListener().informPhoneCallTerminatedByError(n2);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("ServiceState: Trigger Service call terminated with error for service type=").append(n2).log();
        }
    }

    private void informServiceCallNotLicensed() {
        this.getModelPhoneOcuCallListener().informServiceCallNotLicensed();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("ServiceState: Trigger Service call not licensed information").log();
        }
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

