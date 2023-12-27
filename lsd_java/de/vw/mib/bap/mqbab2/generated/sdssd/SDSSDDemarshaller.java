/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.CommandList_GetArray;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ResultList_GetArray;
import de.vw.mib.bap.stream.BitStream;
import de.vw.mib.bap.stream.BitStreamTransformer;

public final class SDSSDDemarshaller
implements BAPServiceListener {
    private final BAPFunctionListenerRegistry _functionListenerRegistry;
    private final BitStreamTransformer _bitSreamTransformer;
    private final BAPFunctionRegistry _functionRegistry;

    public SDSSDDemarshaller(BAPFunctionListenerRegistry bAPFunctionListenerRegistry, BAPFunctionRegistry bAPFunctionRegistry, BitStreamTransformer bitStreamTransformer) {
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

    private BitStreamTransformer getBitSreamTransformer() {
        return this._bitSreamTransformer;
    }

    private BitStream getBitstream(byte[] byArray) {
        return this.getBitSreamTransformer().bitStreamForValue(byArray);
    }

    private BitStream getBitstream(int n, int n2) {
        return this.getBitSreamTransformer().bitStreamForValue(n, n2);
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

    private void functionRequestAcknowledge(int n) {
        this.getFunctionRegistry().getBAPFunction(n).requestAcknowledge();
    }

    private void functionErrorAcknowledge(int n) {
        this.getFunctionRegistry().getBAPFunction(n).errorAcknowledge();
    }

    private void propertyGet(int n) {
        this.getFunctionRegistry().getProperty(n).getProperty(null, this.getFunctionListenerRegistry().getPropertyListener(n));
    }

    protected void propertySetGet(int n, int n2, int n3) {
        this.getFunctionRegistry().getProperty(n).setGetProperty(this.createBAPEntityForSetGetIndication(n, this.getBitstream(n2, n3)), this.getFunctionListenerRegistry().getPropertyListener(n));
    }

    protected void propertySetGet(int n, byte[] byArray) {
        this.getFunctionRegistry().getProperty(n).setGetProperty(this.createBAPEntityForSetGetIndication(n, this.getBitstream(byArray)), this.getFunctionListenerRegistry().getPropertyListener(n));
    }

    protected void propertyAck(int n, int n2, int n3) {
        this.getFunctionRegistry().getProperty(n).ackProperty(this.createBAPEntityForAckIndication(n, this.getBitstream(n2, n3)), this.getFunctionListenerRegistry().getPropertyListener(n));
    }

    protected void propertyAck(int n, byte[] byArray) {
        this.getFunctionRegistry().getProperty(n).ackProperty(this.createBAPEntityForAckIndication(n, this.getBitstream(byArray)), this.getFunctionListenerRegistry().getPropertyListener(n));
    }

    protected void methodStartResult(int n) {
        this.getFunctionRegistry().getMethod(n).startResult(null, this.getFunctionListenerRegistry().getMethodListener(n));
    }

    protected void methodStartResult(int n, int n2, int n3) {
        this.getFunctionRegistry().getMethod(n).startResult(this.createBAPEntityForStartResultIndication(n, this.getBitstream(n2, n3)), this.getFunctionListenerRegistry().getMethodListener(n));
    }

    protected void methodStartResult(int n, byte[] byArray) {
        this.getFunctionRegistry().getMethod(n).startResult(this.createBAPEntityForStartResultIndication(n, this.getBitstream(byArray)), this.getFunctionListenerRegistry().getMethodListener(n));
    }

    private void methodAbortResult(int n) {
        this.getFunctionRegistry().getMethod(n).abortResult(null, this.getFunctionListenerRegistry().getMethodListener(n));
    }

    protected void arrayGet(int n, byte[] byArray) {
        this.getFunctionRegistry().getArray(n).getArray(this.createBAPEntityForGetArrayIndication(n, this.getBitstream(byArray)), this.getFunctionListenerRegistry().getArrayListener(n));
    }

    protected void arraySetGet(int n, byte[] byArray) {
        this.getFunctionRegistry().getArray(n).setGetArray(this.createBAPEntityForSetGetArrayIndication(n, this.getBitstream(byArray)), this.getFunctionListenerRegistry().getArrayListener(n));
    }

    private BAPEntity createBAPEntityForSetGetIndication(int n, BitStream bitStream) {
        ASG_Capabilities_SetGet aSG_Capabilities_SetGet;
        switch (n) {
            case 16: {
                aSG_Capabilities_SetGet = new ASG_Capabilities_SetGet(bitStream);
                break;
            }
            default: {
                aSG_Capabilities_SetGet = null;
            }
        }
        return aSG_Capabilities_SetGet;
    }

    private BAPEntity createBAPEntityForAckIndication(int n, BitStream bitStream) {
        switch (n) {
            default: 
        }
        BAPEntity bAPEntity = null;
        return bAPEntity;
    }

    private BAPEntity createBAPEntityForStartResultIndication(int n, BitStream bitStream) {
        switch (n) {
            default: 
        }
        BAPEntity bAPEntity = null;
        return bAPEntity;
    }

    private BAPEntity createBAPEntityForGetArrayIndication(int n, BitStream bitStream) {
        BAPGetArray bAPGetArray;
        switch (n) {
            case 18: {
                bAPGetArray = new CommandList_GetArray(bitStream);
                break;
            }
            case 19: {
                bAPGetArray = new ResultList_GetArray(bitStream);
                break;
            }
            default: {
                bAPGetArray = null;
            }
        }
        return bAPGetArray;
    }

    private BAPEntity createBAPEntityForSetGetArrayIndication(int n, BitStream bitStream) {
        switch (n) {
            default: 
        }
        BAPEntity bAPEntity = null;
        return bAPEntity;
    }

    @Override
    public boolean indication(int n, int n2, int n3, int n4) {
        switch (n) {
            default: 
        }
        boolean bl = false;
        return bl;
    }

    @Override
    public boolean indication(int n, int n2) {
        boolean bl;
        block0 : switch (n) {
            case 2: {
                switch (n2) {
                    case 2: {
                        this.propertyGet(n);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 3: {
                switch (n2) {
                    case 2: {
                        this.propertyGet(n);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 4: {
                switch (n2) {
                    case 2: {
                        this.propertyGet(n);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 14: {
                switch (n2) {
                    case 2: {
                        this.propertyGet(n);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 15: {
                switch (n2) {
                    case 2: {
                        this.propertyGet(n);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 20: {
                switch (n2) {
                    case 2: {
                        this.propertyGet(n);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            default: {
                if (n2 == 5) {
                    if (this.getFunctionRegistry().getMethod(n) != null) {
                        this.methodAbortResult(n);
                        bl = true;
                        break;
                    }
                    bl = false;
                    break;
                }
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public boolean indication(int n, int n2, byte[] byArray) {
        boolean bl;
        block0 : switch (n) {
            case 16: {
                switch (n2) {
                    case 0: {
                        this.propertySetGet(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 17: {
                switch (n2) {
                    default: 
                }
                bl = false;
                break;
            }
            case 18: {
                switch (n2) {
                    case 2: {
                        this.arrayGet(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 19: {
                switch (n2) {
                    case 2: {
                        this.arrayGet(n, byArray);
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
        BAPFunction bAPFunction = this.getFunctionRegistry().getBAPFunction(n);
        if (bAPFunction != null) {
            bAPFunction.indicationError(n2, this.getFunctionListenerRegistry().getBAPFunctionListener(n));
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public boolean acknowledge(int n, int n2) {
        boolean bl;
        switch (n) {
            case 2: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 3: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 4: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 14: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 15: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 16: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 17: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 18: {
                if (n2 == 3 || n2 == 4) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 5) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 19: {
                if (n2 == 3 || n2 == 4) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 5) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 20: {
                if (n2 == 0) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 2) {
                    this.functionErrorAcknowledge(n);
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
}

