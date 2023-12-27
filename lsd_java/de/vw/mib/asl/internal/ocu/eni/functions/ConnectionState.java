/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ConnectionState_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public class ConnectionState
extends ENIFunction
implements PropertyListener,
InternalServiceProvider {
    private int connectionState;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener;

    private ConnectionStateServiceListener getConnectionStateServiceListener() {
        return (ConnectionStateServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener = ConnectionState.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener);
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener = ConnectionState.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener, ConnectionStateServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
        this.setConnectionState(0);
    }

    @Override
    public int getFunctionId() {
        return 29;
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        ConnectionState_Status connectionState_Status = (ConnectionState_Status)bAPEntity;
        int n = connectionState_Status.synchronisationState.serviceListWasSynchronised ? 3 : 2;
        this.setConnectionState(n);
        this.didChangeValue(bAPEntity);
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (ConnectionStateServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.getConnectionStateServiceListener().updateConnectionState(this.getConnectionState());
        }
    }

    private int getConnectionState() {
        return this.connectionState;
    }

    private void setConnectionState(int n) {
        if (this.connectionState != n) {
            this.connectionState = n;
        }
        this.getConnectionStateServiceListener().updateConnectionState(n);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("ConnectionState: connectionState=").append(n).log();
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

