/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.RegisterState_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class RegisterState
extends ECallFunction
implements PropertyListener,
InternalServiceProvider {
    private boolean _ocuRegisterState;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener;

    private RegisterStateServiceListener getRegisterStateListener() {
        return (RegisterStateServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener = RegisterState.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener);
    }

    private void _informServices() {
        this.getRegisterStateListener().updateRegisterState(this.getOcuRegisterState());
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("RegisterState: Update with new ocuRegisterState=").append(this.getOcuRegisterState()).log();
        }
    }

    private boolean getOcuRegisterState() {
        return this._ocuRegisterState;
    }

    private void updateOcuRegisterState(boolean bl) {
        if (this._ocuRegisterState != bl) {
            this._ocuRegisterState = bl;
        }
        this._informServices();
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener = RegisterState.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener, RegisterStateServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 21;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        boolean bl;
        RegisterState_Status registerState_Status = (RegisterState_Status)bAPEntity;
        switch (registerState_Status.registerStateData) {
            case 1: 
            case 4: 
            case 5: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        this.updateOcuRegisterState(bl);
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (RegisterStateServiceListener.SERVICE_CONSTANTS[0] == n) {
            this._informServices();
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

