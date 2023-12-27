/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMasterControlReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
    private static int dynamicHandle = 0;
    private ASIHMISyncMasterControlReply p_ASIHMISyncMasterControlReply;

    public ASIHMISyncMasterControlReplyService(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        super(new ServiceInstanceID("02954bb2-63fb-44a0-b50d-cb235060c4b6", ASIHMISyncMasterControlReplyService.nextDynamicHandle(), "e4f36342-c71e-54be-b822-4a56b5d0a9a1", "asi.hmisync.mastercontrol.ASIHMISyncMasterControl"));
        this.p_ASIHMISyncMasterControlReply = aSIHMISyncMasterControlReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 4: {
                    this.p_ASIHMISyncMasterControlReply.factoryReset();
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_ASIHMISyncMasterControlReply.enterAppContext(n, string);
                    break;
                }
                case 8: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMasterControlReply.updateASIVersion(string, bl);
                    break;
                }
                case 14: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMasterControlReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 13: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMasterControlReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMasterControlReply.updateHUVersion(string, bl);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMasterControlReply.updateVIN(string, bl);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMasterControlReply.updateLockState(n, bl);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncMasterControlReply.updateBlockState(n, bl);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

