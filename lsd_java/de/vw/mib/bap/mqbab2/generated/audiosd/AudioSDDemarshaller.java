/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentVolumeExtended_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.DedicatedAudioControl_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GeneralInfoSwitches_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowserControl_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaFileInfo_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.Mute_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.PreferredList_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SDS_State_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SiriusAlertList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceState_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchRadioMedia_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchSource_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoList_GetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;
import de.vw.mib.bap.stream.BitStreamTransformer;

public final class AudioSDDemarshaller
implements BAPServiceListener {
    private final BAPFunctionListenerRegistry _functionListenerRegistry;
    private final BitStreamTransformer _bitSreamTransformer;
    private final BAPFunctionRegistry _functionRegistry;

    public AudioSDDemarshaller(BAPFunctionListenerRegistry bAPFunctionListenerRegistry, BAPFunctionRegistry bAPFunctionRegistry, BitStreamTransformer bitStreamTransformer) {
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
            case 19: {
                setGetProperty = new Mute_SetGet(bitStream);
                break;
            }
            case 20: {
                setGetProperty = new SourceState_SetGet(bitStream);
                break;
            }
            case 25: {
                setGetProperty = new GeneralInfoSwitches_SetGet(bitStream);
                break;
            }
            case 40: {
                setGetProperty = new PreferredList_SetGet(bitStream);
                break;
            }
            case 41: {
                setGetProperty = new SDS_State_SetGet(bitStream);
                break;
            }
            case 43: {
                setGetProperty = new ASG_Capabilities_SetGet(bitStream);
                break;
            }
            case 47: {
                setGetProperty = new CurrentVolumeExtended_SetGet(bitStream);
                break;
            }
            default: {
                setGetProperty = null;
            }
        }
        return setGetProperty;
    }

    private BAPEntity createBAPEntityForAckIndication(int n, BitStream bitStream) {
        return null;
    }

    private BAPEntity createBAPEntityForStartResultIndication(int n, BitStream bitStream) {
        StartResultMethod startResultMethod;
        switch (n) {
            case 24: {
                startResultMethod = new DedicatedAudioControl_StartResult(bitStream);
                break;
            }
            case 34: {
                startResultMethod = new SwitchSource_StartResult(bitStream);
                break;
            }
            case 38: {
                startResultMethod = new MediaBrowserControl_StartResult(bitStream);
                break;
            }
            case 39: {
                startResultMethod = new MediaFileInfo_StartResult(bitStream);
                break;
            }
            case 44: {
                startResultMethod = new GetNextListPos_StartResult(bitStream);
                break;
            }
            case 45: {
                startResultMethod = new SwitchRadioMedia_StartResult(bitStream);
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
            case 23: {
                bAPGetArray = new ReceptionList_GetArray(bitStream);
                break;
            }
            case 27: {
                bAPGetArray = new TpMemoList_GetArray(bitStream);
                break;
            }
            case 32: {
                bAPGetArray = new SourceList_GetArray(bitStream);
                break;
            }
            case 33: {
                bAPGetArray = new RadioTV_PresetList_GetArray(bitStream);
                break;
            }
            case 36: {
                bAPGetArray = new MediaBrowser_GetArray(bitStream);
                break;
            }
            case 50: {
                bAPGetArray = new SiriusAlertList_GetArray(bitStream);
                break;
            }
            default: {
                bAPGetArray = null;
            }
        }
        return bAPGetArray;
    }

    private BAPEntity createBAPEntityForSetGetArrayIndication(int n, BitStream bitStream) {
        return null;
    }

    @Override
    public boolean indication(int n, int n2, int n3, int n4) {
        boolean bl;
        block0 : switch (n) {
            case 19: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, AudioSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 34: {
                switch (n3) {
                    case 4: {
                        this.methodStartResult(n, n4, AudioSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 39: {
                switch (n3) {
                    case 4: {
                        this.methodStartResult(n, n4, AudioSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 40: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, AudioSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 41: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, AudioSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 43: {
                switch (n3) {
                    case 0: {
                        this.propertySetGet(n, n4, AudioSDDemarshaller.getBitstreamTransformerDatatype(n2));
                        bl = true;
                        break block0;
                    }
                }
                bl = false;
                break;
            }
            case 45: {
                switch (n3) {
                    case 4: {
                        this.methodStartResult(n, n4, AudioSDDemarshaller.getBitstreamTransformerDatatype(n2));
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
            case 26: {
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
            case 28: {
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
            case 29: {
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
            case 30: {
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
                    case 2: {
                        this.propertyGet(n);
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
            case 42: {
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
            case 51: {
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
            case 52: {
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
            case 20: {
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
            case 23: {
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
            case 24: {
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
            case 27: {
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
            case 36: {
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
            case 38: {
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
            case 44: {
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
            case 47: {
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
            case 50: {
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
            case 24: {
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
            case 30: {
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
            case 36: {
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
            case 39: {
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
            case 42: {
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
            case 45: {
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
            case 51: {
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
            case 52: {
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
            case 56: {
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
            default: {
                bl = false;
            }
        }
        return bl;
    }
}

