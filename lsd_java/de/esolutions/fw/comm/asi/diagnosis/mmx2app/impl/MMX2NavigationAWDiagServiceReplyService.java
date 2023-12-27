/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2NavigationAWDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2NavigationAWDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2NavigationAWDiagService");
    private static int dynamicHandle = 0;
    private MMX2NavigationAWDiagServiceReply p_MMX2NavigationAWDiagServiceReply;

    public MMX2NavigationAWDiagServiceReplyService(MMX2NavigationAWDiagServiceReply mMX2NavigationAWDiagServiceReply) {
        super(new ServiceInstanceID("55213c43-0995-4f3c-9f56-08df21a1a0f5", MMX2NavigationAWDiagServiceReplyService.nextDynamicHandle(), "aceab9d2-746a-59f3-836b-7e4e2d8af5ed", "asi.diagnosis.mmx2app.MMX2NavigationAWDiagService"));
        this.p_MMX2NavigationAWDiagServiceReply = mMX2NavigationAWDiagServiceReply;
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
                case 16: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestSubsystemStates(l);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestVersionsNavDB(l);
                    break;
                }
                case 0: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestActiveNavDB(l);
                    break;
                }
                case 4: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestGPSNoSatellite(l);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestGPSOffroad(l);
                    break;
                }
                case 9: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestNavCalibrationState(l);
                    break;
                }
                case 11: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestNavCorrectedPosition(l);
                    break;
                }
                case 10: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestNavCorrectedDirection(l);
                    break;
                }
                case 18: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestUnitStateDSRC(l);
                    break;
                }
                case 1: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestAntennaStateDSRC(l);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestAntennaStateVICS(l);
                    break;
                }
                case 12: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestRadioBeaconStateVICS(l);
                    break;
                }
                case 8: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestInfraredBeaconStateVICS(l);
                    break;
                }
                case 13: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestResetCalibration(l, n);
                    break;
                }
                case 15: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestSparePartNumber(l, n);
                    break;
                }
                case 3: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestApplicationSoftwareVersionNumber(l, n);
                    break;
                }
                case 6: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestHardwareNumber(l, n);
                    break;
                }
                case 7: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestHardwareVersionNumber(l, n);
                    break;
                }
                case 14: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestSerialNumber(l, n);
                    break;
                }
                case 17: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestSystemName(l, n);
                    break;
                }
                case 45: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2NavigationAWDiagServiceReply.requestCountryRegionVersion(l);
                    break;
                }
                case 42: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2NavigationAWDiagServiceReply.requestDeleteMemory(l, n);
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

