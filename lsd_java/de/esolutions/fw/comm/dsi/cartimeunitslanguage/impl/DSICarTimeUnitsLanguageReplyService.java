/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.DSICarTimeUnitsLanguageReply;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockDateSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockDayLightSavingDataSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockGPSSyncDataSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockSourcesSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockTimeSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.UTCOffsetSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.UnitmasterViewOptionsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public class DSICarTimeUnitsLanguageReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.cartimeunitslanguage.DSICarTimeUnitsLanguage");
    private static int dynamicHandle = 0;
    private DSICarTimeUnitsLanguageReply p_DSICarTimeUnitsLanguageReply;

    public DSICarTimeUnitsLanguageReplyService(DSICarTimeUnitsLanguageReply dSICarTimeUnitsLanguageReply) {
        super(new ServiceInstanceID("01263cc4-0929-5a81-a342-f8319d605c3a", DSICarTimeUnitsLanguageReplyService.nextDynamicHandle(), "52c43d02-c9d9-5770-917f-6a23f69a2ac8", "dsi.cartimeunitslanguage.DSICarTimeUnitsLanguage"));
        this.p_DSICarTimeUnitsLanguageReply = dSICarTimeUnitsLanguageReply;
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
                case 58: {
                    UnitmasterViewOptions unitmasterViewOptions = UnitmasterViewOptionsSerializer.getOptionalUnitmasterViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateUnitmasterViewOptions(unitmasterViewOptions, n);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateMenuLanguage(n, n2);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateTemperatureUnit(n, n3);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateDistanceUnit(n, n4);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateSpeedUnit(n, n5);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updatePressureUnit(n, n6);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateVolumeUnit(n, n7);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateConsumptionPetrolUnit(n, n8);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateConsumptionGasUnit(n, n9);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateConsumptionElectricUnit(n, n10);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockFormat(n, n11);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateDateFormat(n, n12);
                    break;
                }
                case 38: {
                    ClockViewOptions clockViewOptions = ClockViewOptionsSerializer.getOptionalClockViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockViewOptions(clockViewOptions, n);
                    break;
                }
                case 29: {
                    ClockDate clockDate = ClockDateSerializer.getOptionalClockDate(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockDate(clockDate, n);
                    break;
                }
                case 35: {
                    ClockTime clockTime = ClockTimeSerializer.getOptionalClockTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockTime(clockTime, n);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockSource(n, n13);
                    break;
                }
                case 30: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockDayLightSaving(bl, n);
                    break;
                }
                case 31: {
                    ClockDayLightSavingData clockDayLightSavingData = ClockDayLightSavingDataSerializer.getOptionalClockDayLightSavingData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockDayLightSavingData(clockDayLightSavingData, n);
                    break;
                }
                case 37: {
                    float f2 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockTimeZoneOffset(f2, n);
                    break;
                }
                case 36: {
                    ClockSources clockSources = ClockSourcesSerializer.getOptionalClockSources(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockTimeSourcesAvailable(clockSources, n);
                    break;
                }
                case 33: {
                    ClockGPSSyncData clockGPSSyncData = ClockGPSSyncDataSerializer.getOptionalClockGPSSyncData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateClockGPSSyncData(clockGPSSyncData, n);
                    break;
                }
                case 27: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarTimeUnitsLanguageReply.acknowledgeUmSetFactoryDefault(bl);
                    break;
                }
                case 48: {
                    UTCOffset uTCOffset = UTCOffsetSerializer.getOptionalUTCOffset(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateUTCOffset(uTCOffset, n);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateSkin(n, n14);
                    break;
                }
                case 59: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.updateWeightUnit(n, n15);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarTimeUnitsLanguageReply.asyncException(n, string, n16);
                    break;
                }
                case 51: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarTimeUnitsLanguageReply.yyIndication(string, string2);
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

