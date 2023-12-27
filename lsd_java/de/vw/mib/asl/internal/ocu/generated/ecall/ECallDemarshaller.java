/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall;

import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.AcceptCall_Result;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.AudioState_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.AudioState_StatusAck;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.BAP_Config_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.CallState_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.CallState_StatusAck;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.DisconnectReason_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FSG_Control_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FSG_OperationState_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FSG_Setup_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FunctionList_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FunctionalRestrictions_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.HangupCall_Result;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.HeartBeat_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.NetworkProvider_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.RegisterState_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceControl_Result;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceRequest_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceState_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.SignalQuality_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.SupportedServices_Status;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;
import de.vw.mib.bap.stream.BitStreamTransformer;

public final class ECallDemarshaller
implements BAPServiceListener {
    private final BAPFunctionListenerRegistry _functionListenerRegistry;
    private final BitStreamTransformer _bitSreamTransformer;
    private final BAPFunctionRegistry _functionRegistry;

    public ECallDemarshaller(BAPFunctionListenerRegistry bAPFunctionListenerRegistry, BAPFunctionRegistry bAPFunctionRegistry, BitStreamTransformer bitStreamTransformer) {
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
        StatusAckProperty statusAckProperty;
        switch (n) {
            case 16: {
                statusAckProperty = new AudioState_StatusAck(bitStream);
                break;
            }
            case 17: {
                statusAckProperty = new CallState_StatusAck(bitStream);
                break;
            }
            default: {
                statusAckProperty = null;
            }
        }
        return statusAckProperty;
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
            case 16: {
                statusProperty = new AudioState_Status(bitStream);
                break;
            }
            case 17: {
                statusProperty = new CallState_Status(bitStream);
                break;
            }
            case 20: {
                statusProperty = new DisconnectReason_Status(bitStream);
                break;
            }
            case 21: {
                statusProperty = new RegisterState_Status(bitStream);
                break;
            }
            case 22: {
                statusProperty = new NetworkProvider_Status(bitStream);
                break;
            }
            case 23: {
                statusProperty = new SignalQuality_Status(bitStream);
                break;
            }
            case 24: {
                statusProperty = new ServiceRequest_Status(bitStream);
                break;
            }
            case 26: {
                statusProperty = new ServiceState_Status(bitStream);
                break;
            }
            case 27: {
                statusProperty = new SupportedServices_Status(bitStream);
                break;
            }
            case 28: {
                statusProperty = new FunctionalRestrictions_Status(bitStream);
                break;
            }
            default: {
                statusProperty = null;
            }
        }
        return statusProperty;
    }

    private BAPStatusArray createBAPEntityForStatusArrayIndication(int n, BitStream bitStream) {
        return null;
    }

    private BAPChangedArray createBAPEntityForChangedArrayIndication(int n, BitStream bitStream) {
        return null;
    }

    private BAPEntity createBAPEntityForResultIndication(int n, BitStream bitStream) {
        ResultMethod resultMethod;
        switch (n) {
            case 18: {
                resultMethod = new HangupCall_Result(bitStream);
                break;
            }
            case 19: {
                resultMethod = new AcceptCall_Result(bitStream);
                break;
            }
            case 25: {
                resultMethod = new ServiceControl_Result(bitStream);
                break;
            }
            default: {
                resultMethod = null;
            }
        }
        return resultMethod;
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
            case 14: {
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
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 8: {
                        this.propertyStatusAck(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 17: {
                switch (n2) {
                    case 9: {
                        this.propertyStatus(n, byArray);
                        bl = true;
                        break block0;
                    }
                    case 8: {
                        this.propertyStatusAck(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 21: {
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
            case 22: {
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
            case 16: {
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
            case 20: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 21: {
                if (n2 == 9) {
                    this.propertyHeartbeat(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 22: {
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
                        this.propertyStatus(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
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
                        this.propertyStatus(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
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
                        this.propertyStatus(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
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
                        this.methodResult(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 19: {
                switch (n3) {
                    case 11: {
                        this.methodResult(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 20: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 23: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 24: {
                switch (n3) {
                    case 9: {
                        this.propertyStatus(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 25: {
                switch (n3) {
                    case 11: {
                        this.methodResult(n, n4, ECallDemarshaller.getBitstreamTransformerDatatype(n2));
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

