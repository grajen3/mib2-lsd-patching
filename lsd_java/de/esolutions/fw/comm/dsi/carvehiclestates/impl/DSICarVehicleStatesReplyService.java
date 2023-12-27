/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carvehiclestates.DSICarVehicleStatesReply;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.DynamicVehicleInfoHighFrequentSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.DynamicVehicleInfoHighFrequentViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.DynamicVehicleInfoMidFrequentSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.DynamicVehicleInfoMidFrequentViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.DynamicVehicleInfoSCRSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.KeyDataSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.OilLevelDataSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.SemiStaticDataViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.SemiStaticVehicleDataSerializer;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.VehicleInfoViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class DSICarVehicleStatesReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carvehiclestates.DSICarVehicleStates");
    private static int dynamicHandle = 0;
    private DSICarVehicleStatesReply p_DSICarVehicleStatesReply;

    public DSICarVehicleStatesReplyService(DSICarVehicleStatesReply dSICarVehicleStatesReply) {
        super(new ServiceInstanceID("01233b5d-75cd-5163-928f-f10a23ccd2e7", DSICarVehicleStatesReplyService.nextDynamicHandle(), "42b4ba3b-ce4d-55e5-8838-444e7daddb80", "dsi.carvehiclestates.DSICarVehicleStates"));
        this.p_DSICarVehicleStatesReply = dSICarVehicleStatesReply;
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
                case 14: {
                    CarViewOption carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateOilLevelViewOption(carViewOption, n);
                    break;
                }
                case 13: {
                    OilLevelData oilLevelData = OilLevelDataSerializer.getOptionalOilLevelData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateOilLevelData(oilLevelData, n);
                    break;
                }
                case 16: {
                    CarViewOption carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateVINViewOption(carViewOption, n);
                    break;
                }
                case 15: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateVINData(string, n);
                    break;
                }
                case 12: {
                    CarViewOption carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateKeyViewOption(carViewOption, n);
                    break;
                }
                case 11: {
                    KeyData keyData = KeyDataSerializer.getOptionalKeyData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateKeyData(keyData, n);
                    break;
                }
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateDrvSchoolSystem(bl, n);
                    break;
                }
                case 27: {
                    VehicleInfoViewOptions vehicleInfoViewOptions = VehicleInfoViewOptionsSerializer.getOptionalVehicleInfoViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateVehicleInfoViewOptions(vehicleInfoViewOptions, n);
                    break;
                }
                case 50: {
                    DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions = DynamicVehicleInfoHighFrequentViewOptionsSerializer.getOptionalDynamicVehicleInfoHighFrequentViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateDynamicVehicleInfoHighFrequentViewOptions(dynamicVehicleInfoHighFrequentViewOptions, n);
                    break;
                }
                case 52: {
                    DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions = DynamicVehicleInfoMidFrequentViewOptionsSerializer.getOptionalDynamicVehicleInfoMidFrequentViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateDynamicVehicleInfoMidFrequentViewOptions(dynamicVehicleInfoMidFrequentViewOptions, n);
                    break;
                }
                case 49: {
                    DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent = DynamicVehicleInfoHighFrequentSerializer.getOptionalDynamicVehicleInfoHighFrequent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateDynamicVehicleInfoHighFrequent(dynamicVehicleInfoHighFrequent, n);
                    break;
                }
                case 51: {
                    DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent = DynamicVehicleInfoMidFrequentSerializer.getOptionalDynamicVehicleInfoMidFrequent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateDynamicVehicleInfoMidFrequent(dynamicVehicleInfoMidFrequent, n);
                    break;
                }
                case 44: {
                    SemiStaticDataViewOptions semiStaticDataViewOptions = SemiStaticDataViewOptionsSerializer.getOptionalSemiStaticDataViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateSemiStaticVehicleDataViewOptions(semiStaticDataViewOptions, n);
                    break;
                }
                case 43: {
                    SemiStaticVehicleData semiStaticVehicleData = SemiStaticVehicleDataSerializer.getOptionalSemiStaticVehicleData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateSemiStaticVehicleData(semiStaticVehicleData, n);
                    break;
                }
                case 24: {
                    DynamicVehicleInfoSCR dynamicVehicleInfoSCR = DynamicVehicleInfoSCRSerializer.getOptionalDynamicVehicleInfoSCR(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.updateDynamicVehicleInfoSCR(dynamicVehicleInfoSCR, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarVehicleStatesReply.asyncException(n, string, n2);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarVehicleStatesReply.yyIndication(string, string2);
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

