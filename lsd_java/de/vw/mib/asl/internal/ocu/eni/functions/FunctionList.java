/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FunctionList_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import java.util.BitSet;

public final class FunctionList
extends ENIFunction
implements PropertyListener,
BAPFunctionList,
InternalServiceProvider {
    private BitSet _functionListBitSet;
    private boolean _functionListReceived;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener;

    private BitSet getFunctionListBitSet() {
        if (this._functionListBitSet == null) {
            this._functionListBitSet = new BitSet();
        }
        return this._functionListBitSet;
    }

    private boolean isFunctionListReceived() {
        return this._functionListReceived;
    }

    private void setFunctionListReceived(boolean bl) {
        this._functionListReceived = bl;
    }

    private FunctionSupportServiceListener getFunctionSupportServiceListener() {
        return (FunctionSupportServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener = FunctionList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener);
    }

    private boolean existsFunction(int n) {
        return n >= this.getFunctionListBitSet().size() ? false : this.getFunctionListBitSet().get(n);
    }

    private void evaluateSupportOfOnlineNetworkServices() {
        boolean bl = this.containsFunction(19) && this.containsFunction(20) && this.containsFunction(22) && this.containsFunction(18) && this.containsFunction(21);
        this.getFunctionSupportServiceListener().updateOnlineNetworkServicesSupported(bl);
        this.getLogger().trace(256).append("Online network services supported = ").append(bl).log();
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener = FunctionList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener, FunctionSupportServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
        this.setFunctionListReceived(false);
        this.getFunctionListBitSet().clear();
    }

    @Override
    public int getFunctionId() {
        return 3;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        BitSet bitSet = this.getFunctionListBitSet();
        bitSet.set(1, functionList_Status.fctList.fctGetAllAvailable);
        bitSet.set(2, functionList_Status.fctList.fctBap_ConfigAvailable);
        bitSet.set(3, functionList_Status.fctList.fctFunctionListAvailable);
        bitSet.set(4, functionList_Status.fctList.fctHeartbeatAvailable);
        bitSet.set(14, functionList_Status.fctList.fctFsg_SetupAvailable);
        bitSet.set(15, functionList_Status.fctList.fctFsg_OperationStateAvailable);
        bitSet.set(16, functionList_Status.fctList.fctDestinationsListAvailable);
        bitSet.set(17, functionList_Status.fctList.fctDestinationList_AsgcapacityAvailable);
        bitSet.set(18, functionList_Status.fctList.fctIdTriggerRemoteProcessAvailable);
        bitSet.set(19, functionList_Status.fctList.fctIdRemoteProcessCommandsAvailable);
        bitSet.set(20, functionList_Status.fctList.fctIdRemoteProcessStateAvailable);
        bitSet.set(21, functionList_Status.fctList.fctIdUserListAvailable);
        bitSet.set(22, functionList_Status.fctList.fctIdServiceListAvailable);
        bitSet.set(23, functionList_Status.fctList.fctIdActiveMonitoringsAvailable);
        bitSet.set(24, functionList_Status.fctList.fctIdPrivacySetupAvailable);
        bitSet.set(36, functionList_Status.fctList.currentOnlineUpdateStateAvailable);
        bitSet.set(37, functionList_Status.fctList.onlineUpdateListAvailable);
        bitSet.set(30, functionList_Status.fctList.fctIdChallengeDataAvailable);
        bitSet.set(33, functionList_Status.fctList.fctIdActiveTripAvailable);
        bitSet.set(25, functionList_Status.fctList.fctIdAlertListAvailable);
        bitSet.set(29, functionList_Status.fctList.fctIdConnectionStateAvailable);
        bitSet.set(31, functionList_Status.fctList.fctIdFoDlistAvailable);
        bitSet.set(32, functionList_Status.fctList.fctIdFoDstateAvailable);
        bitSet.set(26, functionList_Status.fctList.fctIdMobileDeviceKeyCountAvailable);
        bitSet.set(34, functionList_Status.fctList.fctIdOlbsettingsAvailable);
        bitSet.set(35, functionList_Status.fctList.fctIdOlbtripListAvailable);
        bitSet.set(27, functionList_Status.fctList.fctIdVtandataEncryptedAvailable);
        this.setFunctionListReceived(true);
        this.didChangeValue(bAPEntity);
        this.evaluateSupportOfOnlineNetworkServices();
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public boolean containsFunction(int n) {
        return this.isFunctionListReceived() ? this.existsFunction(n) : true;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (FunctionSupportServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.evaluateSupportOfOnlineNetworkServices();
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

