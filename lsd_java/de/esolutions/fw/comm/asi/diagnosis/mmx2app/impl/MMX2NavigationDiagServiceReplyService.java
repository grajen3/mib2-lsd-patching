/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2NavigationDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2NavigationDiagService");
    private static int dynamicHandle = 0;
    private MMX2NavigationDiagServiceReply p_MMX2NavigationDiagServiceReply;

    public MMX2NavigationDiagServiceReplyService(MMX2NavigationDiagServiceReply mMX2NavigationDiagServiceReply) {
        super(new ServiceInstanceID("128c33a5-671a-49e8-911b-ee23a09bcd10", MMX2NavigationDiagServiceReplyService.nextDynamicHandle(), "8040a0cc-a4ea-5c17-8a45-3b275afe913b", "asi.diagnosis.mmx2app.MMX2NavigationDiagService"));
        this.p_MMX2NavigationDiagServiceReply = mMX2NavigationDiagServiceReply;
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
                case 36: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestSubsystemState(l);
                    break;
                }
                case 7: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestVersionsNavDB(l);
                    break;
                }
                case 0: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestActiveNavDB(l);
                    break;
                }
                case 1: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestGPSNoSatellite(l);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestGPSOffroad(l);
                    break;
                }
                case 3: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestNavCalibrationState(l);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestNavCorrectedPosition(l);
                    break;
                }
                case 4: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestNavCorrectedDirection(l);
                    break;
                }
                case 6: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationDiagServiceReply.requestResetCalibration(l, n);
                    break;
                }
                case 26: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestSparePartNumberNavDB(l);
                    break;
                }
                case 22: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestApplicationSoftwareVersionNumberNavDB(l);
                    break;
                }
                case 23: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestHardwareNumberNavDB(l);
                    break;
                }
                case 24: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestHardwareVersionNumberNavDB(l);
                    break;
                }
                case 25: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestSerialNumberNavDB(l);
                    break;
                }
                case 27: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestSystemNameNavDB(l);
                    break;
                }
                case 40: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationDiagServiceReply.requestCountryRegionVersion(l);
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

