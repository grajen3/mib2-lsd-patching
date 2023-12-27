/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.RemoteProcessCommands_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public class RemoteProcessCommands
extends ENIFunction
implements PropertyListener,
InternalServiceProvider {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener;

    private FunctionSupportServiceListener getFunctionSupportServiceListener() {
        return (FunctionSupportServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener = RemoteProcessCommands.class$("de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener = RemoteProcessCommands.class$("de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener, FunctionSupportServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        RemoteProcessCommands_Status remoteProcessCommands_Status = (RemoteProcessCommands_Status)bAPEntity;
        this.getFunctionSupportServiceListener().supportedOperations(remoteProcessCommands_Status.supportedCommands0.pairMainUserPairingCodeSupported, remoteProcessCommands_Status.supportedCommands0.remoteDeleteUserListSupported, remoteProcessCommands_Status.supportedCommands0.confirmServiceExpiryWarningSupported);
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (FunctionSupportServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.getDelegate().getProperty(this).getProperty(null, this);
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

