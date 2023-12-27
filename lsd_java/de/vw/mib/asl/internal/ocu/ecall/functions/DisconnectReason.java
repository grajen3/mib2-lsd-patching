/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.DisconnectReason_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class DisconnectReason
extends ECallFunction
implements PropertyListener {
    private int _modelOcuDisconnectReason;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener;

    private ModelPhoneOcuCallListener getModelPhoneOcuCallListener() {
        return (ModelPhoneOcuCallListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener = DisconnectReason.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener);
    }

    private void _setModelOcuDisconnectReason(int n) {
        if (this._modelOcuDisconnectReason != n) {
            this._modelOcuDisconnectReason = n;
            this.getModelPhoneOcuCallListener().updateDisconnectReason(n);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512).append("DisconnectReason: Update with new disconnectReason: modelOcuDisconnectReason=").append(n).log();
            }
        }
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        int n;
        DisconnectReason_Status disconnectReason_Status = (DisconnectReason_Status)bAPEntity;
        switch (disconnectReason_Status.disconnectReason) {
            case 1: {
                n = 2;
                break;
            }
            case 2: 
            case 3: {
                n = 3;
                break;
            }
            case 4: {
                n = 4;
                break;
            }
            case 5: {
                n = 5;
                break;
            }
            case 6: {
                n = 6;
                break;
            }
            case 7: {
                n = 7;
                break;
            }
            case 9: {
                n = 10;
                break;
            }
            case 10: {
                n = 9;
                break;
            }
            case 11: {
                n = 11;
                break;
            }
            case 12: {
                n = 12;
                break;
            }
            case 13: {
                n = 13;
                break;
            }
            case 8: 
            case 15: {
                n = 8;
                break;
            }
            default: {
                n = 0;
            }
        }
        this._setModelOcuDisconnectReason(n);
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
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

