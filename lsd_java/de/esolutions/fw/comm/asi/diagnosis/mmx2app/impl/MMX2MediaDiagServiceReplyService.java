/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2MediaDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2MediaDiagService");
    private static int dynamicHandle = 0;
    private MMX2MediaDiagServiceReply p_MMX2MediaDiagServiceReply;

    public MMX2MediaDiagServiceReplyService(MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
        super(new ServiceInstanceID("4c311096-2484-4cc9-acaf-f8abcdb758e6", MMX2MediaDiagServiceReplyService.nextDynamicHandle(), "dccdf0f3-38de-548c-a50c-274e448a5cd3", "asi.diagnosis.mmx2app.MMX2MediaDiagService"));
        this.p_MMX2MediaDiagServiceReply = mMX2MediaDiagServiceReply;
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
                case 31: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestSubsystemState(l);
                    break;
                }
                case 1: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestMediaDBVersion(l);
                    break;
                }
                case 0: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2MediaDiagServiceReply.requestActiveMediaSourceState(l, n);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestMediaRegionCodes(l);
                    break;
                }
                case 27: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestMediaTypeOpticalDrive(l);
                    break;
                }
                case 15: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestUsbOvercurrent(l);
                    break;
                }
                case 30: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestPmlState(l);
                    break;
                }
                case 35: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestSparePartNumberMediaDB(l);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestApplicationSoftwareVersionNumberMediaDB(l);
                    break;
                }
                case 20: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestSerialNumberMediaDB(l);
                    break;
                }
                case 21: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestSystemNameMediaDB(l);
                    break;
                }
                case 38: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestStatusUSBCommunication(l);
                    break;
                }
                case 39: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestUSBHubIdentification(l);
                    break;
                }
                case 47: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestDTCPEncryptionState(l);
                    break;
                }
                case 48: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestDTCPKeytypeMMX(l);
                    break;
                }
                case 49: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2MediaDiagServiceReply.requestDTCPSRMInfo(l);
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

