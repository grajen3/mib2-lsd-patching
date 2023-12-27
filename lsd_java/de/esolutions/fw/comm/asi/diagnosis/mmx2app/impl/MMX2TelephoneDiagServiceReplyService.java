/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2TelephoneDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2TelephoneDiagService");
    private static int dynamicHandle = 0;
    private MMX2TelephoneDiagServiceReply p_MMX2TelephoneDiagServiceReply;

    public MMX2TelephoneDiagServiceReplyService(MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
        super(new ServiceInstanceID("434ab88c-5027-40eb-92ee-df5658912e1a", MMX2TelephoneDiagServiceReplyService.nextDynamicHandle(), "dd966f77-1703-5382-80a9-c2b428743ae7", "asi.diagnosis.mmx2app.MMX2TelephoneDiagService"));
        this.p_MMX2TelephoneDiagServiceReply = mMX2TelephoneDiagServiceReply;
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
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestSimState(l);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestNadIMEI(l);
                    break;
                }
                case 30: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2TelephoneDiagServiceReply.requestTelephoneAntennaState(l, n);
                    break;
                }
                case 0: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2TelephoneDiagServiceReply.requestConnectedBtHandset(l, n);
                    break;
                }
                case 3: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestNumberHandsetsHUCs(l);
                    break;
                }
                case 6: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestTelephoneNetworkState(l);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestTelephoneTemperature(l);
                    break;
                }
                case 24: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2TelephoneDiagServiceReply.requestDeleteMemory(l, n);
                    break;
                }
                case 34: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestNetworkName(l);
                    break;
                }
                case 35: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestNetworkType(l);
                    break;
                }
                case 33: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_MMX2TelephoneDiagServiceReply.requestDialNumber(l, string);
                    break;
                }
                case 32: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestCallStatus(l);
                    break;
                }
                case 40: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2TelephoneDiagServiceReply.requestInternalSimIdentification(l);
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

