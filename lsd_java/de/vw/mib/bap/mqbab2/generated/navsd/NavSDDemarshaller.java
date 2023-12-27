/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.ActiveRgType_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Calibration_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.FavoriteDest_List_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LastDest_List_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MagnetFieldZone_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapColorAndType_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapScale_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Map_Presentation_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NavBook_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NbSpeller_StartResult;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.POI_List_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.POI_Search_StartResult;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.RG_ActDeact_StartResult;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TMCinfo_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.VoiceGuidance_SetGet;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;
import de.vw.mib.bap.stream.BitStreamTransformer;

public final class NavSDDemarshaller
implements BAPServiceListener {
    private final BAPFunctionListenerRegistry _functionListenerRegistry;
    private final BitStreamTransformer _bitSreamTransformer;
    private final BAPFunctionRegistry _functionRegistry;

    public NavSDDemarshaller(BAPFunctionListenerRegistry bAPFunctionListenerRegistry, BAPFunctionRegistry bAPFunctionRegistry, BitStreamTransformer bitStreamTransformer) {
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
        SetGetProperty setGetProperty;
        switch (n) {
            case 25: {
                setGetProperty = new TMCinfo_SetGet(bitStream);
                break;
            }
            case 26: {
                setGetProperty = new MagnetFieldZone_SetGet(bitStream);
                break;
            }
            case 27: {
                setGetProperty = new Calibration_SetGet(bitStream);
                break;
            }
            case 28: {
                setGetProperty = new ASG_Capabilities_SetGet(bitStream);
                break;
            }
            case 36: {
                setGetProperty = new VoiceGuidance_SetGet(bitStream);
                break;
            }
            case 39: {
                setGetProperty = new ActiveRgType_SetGet(bitStream);
                break;
            }
            case 43: {
                setGetProperty = new MapColorAndType_SetGet(bitStream);
                break;
            }
            case 44: {
                setGetProperty = new MapViewAndOrientation_SetGet(bitStream);
                break;
            }
            case 45: {
                setGetProperty = new MapScale_SetGet(bitStream);
                break;
            }
            case 54: {
                setGetProperty = new Map_Presentation_SetGet(bitStream);
                break;
            }
            default: {
                setGetProperty = null;
            }
        }
        return setGetProperty;
    }

    private BAPEntity createBAPEntityForAckIndication(int n, BitStream bitStream) {
        switch (n) {
            default: 
        }
        BAPEntity bAPEntity = null;
        return bAPEntity;
    }

    private BAPEntity createBAPEntityForStartResultIndication(int n, BitStream bitStream) {
        StartResultMethod startResultMethod;
        switch (n) {
            case 34: {
                startResultMethod = new RG_ActDeact_StartResult(bitStream);
                break;
            }
            case 41: {
                startResultMethod = new GetNextListPos_StartResult(bitStream);
                break;
            }
            case 42: {
                startResultMethod = new NbSpeller_StartResult(bitStream);
                break;
            }
            case 51: {
                startResultMethod = new POI_Search_StartResult(bitStream);
                break;
            }
            default: {
                startResultMethod = null;
            }
        }
        return startResultMethod;
    }

    private BAPEntity createBAPEntityForGetArrayIndication(int n, BitStream bitStream) {
        BAPGetArray bAPGetArray;
        switch (n) {
            case 24: {
                bAPGetArray = new LaneGuidance_GetArray(bitStream);
                break;
            }
            case 29: {
                bAPGetArray = new LastDest_List_GetArray(bitStream);
                break;
            }
            case 30: {
                bAPGetArray = new FavoriteDest_List_GetArray(bitStream);
                break;
            }
            case 32: {
                bAPGetArray = new NavBook_GetArray(bitStream);
                break;
            }
            case 33: {
                bAPGetArray = new Address_List_GetArray(bitStream);
                break;
            }
            case 52: {
                bAPGetArray = new POI_List_GetArray(bitStream);
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
        boolean bl;
        block0 : switch (n) {
            case 26: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, NavSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 27: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, NavSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 36: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, NavSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 39: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, NavSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 54: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, NavSDDemarshaller.getBitstreamTransformerDatatype(n2));
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
            case 16: {
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
            case 17: {
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
            case 18: {
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
            case 19: {
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
            case 21: {
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
            case 22: {
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
            case 23: {
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
            case 31: {
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
            case 35: {
                switch (n2) {
                    case 5: {
                        this.methodAbortResult(n);
                        bl = true;
                        break block0;
                    }
                    case 4: {
                        this.methodStartResult(n);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 37: {
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
            case 38: {
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
            case 40: {
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
            case 46: {
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
            case 47: {
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
            case 48: {
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
            case 49: {
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
            case 50: {
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
            case 53: {
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
            case 55: {
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
            case 24: {
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
            case 25: {
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
            case 28: {
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
            case 29: {
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
            case 30: {
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
            case 32: {
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
            case 33: {
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
            case 34: {
                switch (n2) {
                    case 4: {
                        this.methodStartResult(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 41: {
                switch (n2) {
                    case 4: {
                        this.methodStartResult(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 42: {
                switch (n2) {
                    case 4: {
                        this.methodStartResult(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 43: {
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
            case 44: {
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
            case 45: {
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
            case 51: {
                switch (n2) {
                    case 4: {
                        this.methodStartResult(n, byArray);
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 52: {
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
            case 19: {
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
            case 21: {
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
            case 22: {
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
            case 23: {
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
            case 24: {
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
            case 25: {
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
            case 26: {
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
            case 27: {
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
            case 28: {
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
            case 29: {
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
            case 30: {
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
            case 31: {
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
            case 32: {
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
            case 33: {
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
            case 34: {
                if (n2 == 7) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 8) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 35: {
                if (n2 == 7) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 8) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 36: {
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
            case 37: {
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
            case 38: {
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
            case 39: {
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
            case 40: {
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
            case 41: {
                if (n2 == 7) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 8) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 42: {
                if (n2 == 7) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 8) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 43: {
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
            case 44: {
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
            case 45: {
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
            case 46: {
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
            case 47: {
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
            case 48: {
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
            case 49: {
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
            case 50: {
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
            case 51: {
                if (n2 == 7) {
                    this.functionRequestAcknowledge(n);
                    bl = true;
                    break;
                }
                if (n2 == 8) {
                    this.functionErrorAcknowledge(n);
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 52: {
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
            case 53: {
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
            case 54: {
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
            case 55: {
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

