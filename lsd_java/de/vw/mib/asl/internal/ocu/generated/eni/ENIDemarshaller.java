/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveTrip_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.AlertList_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.AlertList_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.BAP_Config_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ConnectionState_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.CurrentOnlineUpdateState_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationList_ASGcapacity_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationsList_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationsList_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FSG_Control_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FSG_OperationState_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FSG_Setup_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FoDList_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FoDList_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FoDState_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FunctionList_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.HeartBeat_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.MobileDeviceKeyCount_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OLBSettings_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OLBTripList_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OLBTripList_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.PrivacySetup_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.RemoteProcessCommands_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.RemoteProcessState_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.TriggerRemoteProcess_Result;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.UserList_ChangedArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.UserList_StatusArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.VTANDataEncrypted_Status;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;
import de.vw.mib.bap.stream.BitStreamTransformer;

public final class ENIDemarshaller
implements BAPServiceListener {
    private final BAPFunctionListenerRegistry _functionListenerRegistry;
    private final BitStreamTransformer _bitSreamTransformer;
    private final BAPFunctionRegistry _functionRegistry;

    public ENIDemarshaller(BAPFunctionListenerRegistry bAPFunctionListenerRegistry, BAPFunctionRegistry bAPFunctionRegistry, BitStreamTransformer bitStreamTransformer) {
        this._functionListenerRegistry = bAPFunctionListenerRegistry;
        this._functionRegistry = bAPFunctionRegistry;
        this._bitSreamTransformer = bitStreamTransformer;
    }

    private BAPFunctionListenerRegistry getFunctionListenerRegistry() {
        return this._functionListenerRegistry;
    }

    private BAPFunctionRegistry getFunctionRegistry() {
        return this._functionRegistry;
    }

    private BitStreamTransformer getBitstreamTransformer() {
        return this._bitSreamTransformer;
    }

    private BitStream getBitstream(byte[] byArray) {
        return this.getBitstreamTransformer().bitStreamForValue(byArray);
    }

    private BitStream getBitstream(int n, int n2) {
        return this.getBitstreamTransformer().bitStreamForValue(n, n2);
    }

    protected static int getBitstreamTransformerDatatype(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 8;
                break;
            }
            case 1: {
                n2 = 16;
                break;
            }
            case 2: {
                n2 = 32;
                break;
            }
            default: {
                n2 = 32;
            }
        }
        return n2;
    }

    private void propertyHeartbeat(int n) {
        this.getFunctionListenerRegistry().getPropertyListener(n).statusProperty(null, this.getFunctionRegistry().getProperty(n));
    }

    private void propertyStatus(int n, byte[] byArray) {
        this.getFunctionListenerRegistry().getPropertyListener(n).statusProperty(this.createBAPEntityForStatusIndication(n, this.getBitstream(byArray)), this.getFunctionRegistry().getProperty(n));
    }

    private void propertyStatus(int n, int n2, int n3) {
        this.getFunctionListenerRegistry().getPropertyListener(n).statusProperty(this.createBAPEntityForStatusIndication(n, this.getBitstream(n2, n3)), this.getFunctionRegistry().getProperty(n));
    }

    private void propertyReset(int n, byte[] byArray) {
        this.propertyStatus(n, byArray);
    }

    protected void propertyReset(int n, int n2, int n3) {
        this.propertyStatus(n, n2, n3);
    }

    protected void propertyStatusAck(int n, int n2, int n3) {
        this.getFunctionListenerRegistry().getPropertyListener(n).statusAckProperty(this.createBAPEntityForStatusAckIndication(n, this.getBitstream(n2, n3)), this.getFunctionRegistry().getProperty(n));
    }

    protected void propertyStatusAck(int n, byte[] byArray) {
        this.getFunctionListenerRegistry().getPropertyListener(n).statusAckProperty(this.createBAPEntityForStatusAckIndication(n, this.getBitstream(byArray)), this.getFunctionRegistry().getProperty(n));
    }

    protected void methodResult(int n, byte[] byArray) {
        this.getFunctionListenerRegistry().getMethodListener(n).result(this.createBAPEntityForResultIndication(n, this.getBitstream(byArray)), this.getFunctionRegistry().getMethod(n));
    }

    protected void methodResult(int n, int n2, int n3) {
        this.getFunctionListenerRegistry().getMethodListener(n).result(this.createBAPEntityForResultIndication(n, this.getBitstream(n2, n3)), this.getFunctionRegistry().getMethod(n));
    }

    protected void arrayChanged(int n, byte[] byArray) {
        this.getFunctionListenerRegistry().getArrayListener(n).changedArray(this.createBAPEntityForChangedArrayIndication(n, this.getBitstream(byArray)), this.getFunctionRegistry().getArray(n));
    }

    protected void arrayStatus(int n, byte[] byArray) {
        this.getFunctionListenerRegistry().getArrayListener(n).statusArray(this.createBAPEntityForStatusArrayIndication(n, this.getBitstream(byArray)), this.getFunctionRegistry().getArray(n));
    }

    protected BAPEntity createBAPEntityForStatusAckIndication(int n, BitStream bitStream) {
        return null;
    }

    private BAPEntity createBAPEntityForStatusIndication(int n, BitStream bitStream) {
        StatusProperty statusProperty;
        switch (n) {
            case 2: {
                statusProperty = new BAP_Config_Status(bitStream);
                break;
            }
            case 3: {
                statusProperty = new FunctionList_Status(bitStream);
                break;
            }
            case 4: {
                statusProperty = new HeartBeat_Status(bitStream);
                break;
            }
            case 13: {
                statusProperty = new FSG_Control_Status(bitStream);
                break;
            }
            case 14: {
                statusProperty = new FSG_Setup_Status(bitStream);
                break;
            }
            case 15: {
                statusProperty = new FSG_OperationState_Status(bitStream);
                break;
            }
            case 17: {
                statusProperty = new DestinationList_ASGcapacity_Status(bitStream);
                break;
            }
            case 19: {
                statusProperty = new RemoteProcessCommands_Status(bitStream);
                break;
            }
            case 20: {
                statusProperty = new RemoteProcessState_Status(bitStream);
                break;
            }
            case 23: {
                statusProperty = new ActiveMonitorings_Status(bitStream);
                break;
            }
            case 24: {
                statusProperty = new PrivacySetup_Status(bitStream);
                break;
            }
            case 26: {
                statusProperty = new MobileDeviceKeyCount_Status(bitStream);
                break;
            }
            case 27: {
                statusProperty = new VTANDataEncrypted_Status(bitStream);
                break;
            }
            case 28: {
                statusProperty = new OnlineUpdateState_Deprecated_Status(bitStream);
                break;
            }
            case 29: {
                statusProperty = new ConnectionState_Status(bitStream);
                break;
            }
            case 32: {
                statusProperty = new FoDState_Status(bitStream);
                break;
            }
            case 33: {
                statusProperty = new ActiveTrip_Status(bitStream);
                break;
            }
            case 34: {
                statusProperty = new OLBSettings_Status(bitStream);
                break;
            }
            case 36: {
                statusProperty = new CurrentOnlineUpdateState_Status(bitStream);
                break;
            }
            default: {
                statusProperty = null;
            }
        }
        return statusProperty;
    }

    private BAPStatusArray createBAPEntityForStatusArrayIndication(int n, BitStream bitStream) {
        BAPStatusArray bAPStatusArray;
        switch (n) {
            case 16: {
                bAPStatusArray = new DestinationsList_StatusArray(bitStream);
                break;
            }
            case 21: {
                bAPStatusArray = new UserList_StatusArray(bitStream);
                break;
            }
            case 22: {
                bAPStatusArray = new ServiceList_StatusArray(bitStream);
                break;
            }
            case 25: {
                bAPStatusArray = new AlertList_StatusArray(bitStream);
                break;
            }
            case 30: {
                bAPStatusArray = new ChallengeData_StatusArray(bitStream);
                break;
            }
            case 31: {
                bAPStatusArray = new FoDList_StatusArray(bitStream);
                break;
            }
            case 35: {
                bAPStatusArray = new OLBTripList_StatusArray(bitStream);
                break;
            }
            case 37: {
                bAPStatusArray = new OnlineUpdateList_StatusArray(bitStream);
                break;
            }
            default: {
                bAPStatusArray = null;
            }
        }
        return bAPStatusArray;
    }

    private BAPChangedArray createBAPEntityForChangedArrayIndication(int n, BitStream bitStream) {
        BAPChangedArray bAPChangedArray;
        switch (n) {
            case 16: {
                bAPChangedArray = new DestinationsList_ChangedArray(bitStream);
                break;
            }
            case 21: {
                bAPChangedArray = new UserList_ChangedArray(bitStream);
                break;
            }
            case 22: {
                bAPChangedArray = new ServiceList_ChangedArray(bitStream);
                break;
            }
            case 25: {
                bAPChangedArray = new AlertList_ChangedArray(bitStream);
                break;
            }
            case 30: {
                bAPChangedArray = new ChallengeData_ChangedArray(bitStream);
                break;
            }
            case 31: {
                bAPChangedArray = new FoDList_ChangedArray(bitStream);
                break;
            }
            case 35: {
                bAPChangedArray = new OLBTripList_ChangedArray(bitStream);
                break;
            }
            case 37: {
                bAPChangedArray = new OnlineUpdateList_ChangedArray(bitStream);
                break;
            }
            default: {
                bAPChangedArray = null;
            }
        }
        return bAPChangedArray;
    }

    private BAPEntity createBAPEntityForResultIndication(int n, BitStream bitStream) {
        TriggerRemoteProcess_Result triggerRemoteProcess_Result;
        switch (n) {
            case 18: {
                triggerRemoteProcess_Result = new TriggerRemoteProcess_Result(bitStream);
                break;
            }
            default: {
                triggerRemoteProcess_Result = null;
            }
        }
        return triggerRemoteProcess_Result;
    }

    @Override
    public boolean indication(int n, int n2, byte[] byArray) {
        boolean bl;
        block0 : switch (n) {
            case 2: {
                switch (n2) {
                    case 13: {
                        this.propertyReset(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 3: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 16: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 19: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 20: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 21: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 22: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 23: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 24: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 25: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 26: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 27: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 28: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 29: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 30: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 31: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 32: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 33: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 34: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 35: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 36: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 37: {
                switch (n2) {
                    case 12: {
                        this.arrayChanged(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 9: {
                        this.arrayStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public boolean indication(int n, int n2) {
        boolean bl;
        switch (n) {
            case 2: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 3: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 4: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 13: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 14: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 15: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 17: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 19: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 20: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 23: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 24: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 26: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 27: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 28: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 29: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 32: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 33: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 34: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 36: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public boolean indication(int n, int n2, int n3, int n4) {
        boolean bl;
        block0 : switch (n) {
            case 4: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ENIDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 13: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ENIDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 14: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ENIDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 15: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ENIDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 17: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ENIDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 18: {
                switch (n3) {
                    case 11: {
                        this.methodResult(n, n4, ENIDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public boolean indicationError(int n, int n2) {
        boolean bl;
        if (n != 4) {
            BAPFunctionListener bAPFunctionListener = this.getFunctionListenerRegistry().getBAPFunctionListener(n);
            if (bAPFunctionListener != null) {
                bAPFunctionListener.requestError(n2, this.getFunctionRegistry().getBAPFunction(n));
                bl = true;
            } else {
                bl = false;
            }
        } else {
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean acknowledge(int n, int n2) {
        return true;
    }
}

