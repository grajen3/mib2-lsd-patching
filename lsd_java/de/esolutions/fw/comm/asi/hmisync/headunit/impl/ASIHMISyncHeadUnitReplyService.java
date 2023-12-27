/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;
import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.CarConfigurationSerializer;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ClockDateSerializer;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ClockTimeSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncHeadUnitReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.headunit.ASIHMISyncHeadUnit");
    private static int dynamicHandle = 0;
    private ASIHMISyncHeadUnitReply p_ASIHMISyncHeadUnitReply;

    public ASIHMISyncHeadUnitReplyService(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        super(new ServiceInstanceID("00c7b221-4634-4004-97dd-03531d5bc83c", ASIHMISyncHeadUnitReplyService.nextDynamicHandle(), "d70a28c6-c507-5f9a-8920-21d1424b355a", "asi.hmisync.headunit.ASIHMISyncHeadUnit"));
        this.p_ASIHMISyncHeadUnitReply = aSIHMISyncHeadUnitReply;
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
                case 3: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_ASIHMISyncHeadUnitReply.resetLanguage(n, string);
                    break;
                }
                case 7: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateASIVersion(string, bl);
                    break;
                }
                case 18: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 17: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 9: {
                    ClockTime clockTime = ClockTimeSerializer.getOptionalClockTime(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateClockTime(clockTime, bl);
                    break;
                }
                case 8: {
                    ClockDate clockDate = ClockDateSerializer.getOptionalClockDate(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateClockDate(clockDate, bl);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateLanguage1(n, bl);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateLanguage2(string, bl);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateTemperatureUnit(n, bl);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateSpeedUnit(n, bl);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateDistanceUnit(n, bl);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updatePressureUnit(n, bl);
                    break;
                }
                case 16: {
                    CarConfiguration carConfiguration = CarConfigurationSerializer.getOptionalCarConfiguration(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateCarConfiguration(carConfiguration, bl);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateRegion(n, bl);
                    break;
                }
                case 20: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateExtCarConfiguration(nArray, bl);
                    break;
                }
                case 21: {
                    short s2 = iDeserializer.getInt16();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncHeadUnitReply.updateSplashScreenCoding(s2, bl);
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

