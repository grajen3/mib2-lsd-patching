/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirConditionReply;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirDistributionSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirQualitySerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirVolumeSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconBCMeasuresConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconBlowerCompensationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconContentSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconFreshAirCartridgeSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconFreshAirConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconMasterViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconNozzleListRecordSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconPureAirSetupSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconRowViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconSteeringWheelHeaterSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconSynchronisationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconTempSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirQuality;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarAirConditionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.caraircondition.DSICarAirCondition");
    private static int dynamicHandle = 0;
    private DSICarAirConditionReply p_DSICarAirConditionReply;

    public DSICarAirConditionReplyService(DSICarAirConditionReply dSICarAirConditionReply) {
        super(new ServiceInstanceID("c791e146-d96d-50ac-96cd-5519a0a20ef4", DSICarAirConditionReplyService.nextDynamicHandle(), "30c8a0e9-7f16-5069-b300-aec7e607644e", "dsi.caraircondition.DSICarAirCondition"));
        this.p_DSICarAirConditionReply = dSICarAirConditionReply;
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
                case 171: {
                    AirconContent airconContent = AirconContentSerializer.getOptionalAirconContent(iDeserializer);
                    this.p_DSICarAirConditionReply.requestAirconPopup(airconContent);
                    break;
                }
                case 168: {
                    AirconContent airconContent = AirconContentSerializer.getOptionalAirconContent(iDeserializer);
                    this.p_DSICarAirConditionReply.acknowlegdeAirconPopup(airconContent);
                    break;
                }
                case 222: {
                    AirconContent airconContent = AirconContentSerializer.getOptionalAirconContent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconContent(airconContent, n);
                    break;
                }
                case 47: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirCirculationMan(bl, n);
                    break;
                }
                case 46: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirCirculationAuto(bl, n);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirCirculationSensitivity(n, n2);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirCirculationMiddleExhaustion(n, n3);
                    break;
                }
                case 78: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconRearWindowHeater(bl, n);
                    break;
                }
                case 74: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIndirectVentilation(bl, n);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconPopupTime(n, n4);
                    break;
                }
                case 73: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconHeater(bl, n);
                    break;
                }
                case 76: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconRearAuxHeater(bl, n);
                    break;
                }
                case 71: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFrontWindowHeater(bl, n);
                    break;
                }
                case 64: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconDefrost(bl, n);
                    break;
                }
                case 116: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconMaxDefrost(bl, n);
                    break;
                }
                case 92: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSolar(bl, n);
                    break;
                }
                case 45: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAC(bl, n);
                    break;
                }
                case 115: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconMaxAC(bl, n);
                    break;
                }
                case 152: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconEcoAC(bl, n);
                    break;
                }
                case 77: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconRearControl(bl, n);
                    break;
                }
                case 154: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconRearControlFondPlus(bl, n);
                    break;
                }
                case 129: {
                    AirconSteeringWheelHeater airconSteeringWheelHeater = AirconSteeringWheelHeaterSerializer.getOptionalAirconSteeringWheelHeater(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSteeringWheelHeater(airconSteeringWheelHeater, n);
                    break;
                }
                case 72: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFrontWindowHeaterAuto(bl, n);
                    break;
                }
                case 138: {
                    AirconBlowerCompensation airconBlowerCompensation = AirconBlowerCompensationSerializer.getOptionalAirconBlowerCompensation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconBlowerCompensation(airconBlowerCompensation, n);
                    break;
                }
                case 161: {
                    AirconSynchronisation airconSynchronisation = AirconSynchronisationSerializer.getOptionalAirconSynchronisation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSynchronisation(airconSynchronisation, n);
                    break;
                }
                case 95: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSuppressVisualisation(bl, n);
                    break;
                }
                case 79: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconResidualHeat(bl, n);
                    break;
                }
                case 272: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSystemOnOffRow1(bl, n);
                    break;
                }
                case 273: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSystemOnOffRow2(bl, n);
                    break;
                }
                case 274: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSystemOnOffRow3(bl, n);
                    break;
                }
                case 100: {
                    AirconTemp airconTemp = AirconTempSerializer.getOptionalAirconTemp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempZone1(airconTemp, n);
                    break;
                }
                case 56: {
                    AirconAirVolume airconAirVolume = AirconAirVolumeSerializer.getOptionalAirconAirVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirVolumeZone1(airconAirVolume, n);
                    break;
                }
                case 197: {
                    AirconAirDistribution airconAirDistribution = AirconAirDistributionSerializer.getOptionalAirconAirDistribution(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirDistributionZone1(airconAirDistribution, n);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFootwellTempZone1(n, n5);
                    break;
                }
                case 283: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterZone1(n, n6, n7);
                    break;
                }
                case 289: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationZone1(n, n8, n9);
                    break;
                }
                case 101: {
                    AirconTemp airconTemp = AirconTempSerializer.getOptionalAirconTemp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempZone2(airconTemp, n);
                    break;
                }
                case 57: {
                    AirconAirVolume airconAirVolume = AirconAirVolumeSerializer.getOptionalAirconAirVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirVolumeZone2(airconAirVolume, n);
                    break;
                }
                case 198: {
                    AirconAirDistribution airconAirDistribution = AirconAirDistributionSerializer.getOptionalAirconAirDistribution(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirDistributionZone2(airconAirDistribution, n);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFootwellTempZone2(n, n10);
                    break;
                }
                case 284: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterZone2(n, n11, n12);
                    break;
                }
                case 290: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationZone2(n, n13, n14);
                    break;
                }
                case 102: {
                    AirconTemp airconTemp = AirconTempSerializer.getOptionalAirconTemp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempZone3(airconTemp, n);
                    break;
                }
                case 58: {
                    AirconAirVolume airconAirVolume = AirconAirVolumeSerializer.getOptionalAirconAirVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirVolumeZone3(airconAirVolume, n);
                    break;
                }
                case 199: {
                    AirconAirDistribution airconAirDistribution = AirconAirDistributionSerializer.getOptionalAirconAirDistribution(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirDistributionZone3(airconAirDistribution, n);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFootwellTempZone3(n, n15);
                    break;
                }
                case 285: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterZone3(n, n16, n17);
                    break;
                }
                case 291: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationZone3(n, n18, n19);
                    break;
                }
                case 103: {
                    AirconTemp airconTemp = AirconTempSerializer.getOptionalAirconTemp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempZone4(airconTemp, n);
                    break;
                }
                case 59: {
                    AirconAirVolume airconAirVolume = AirconAirVolumeSerializer.getOptionalAirconAirVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirVolumeZone4(airconAirVolume, n);
                    break;
                }
                case 200: {
                    AirconAirDistribution airconAirDistribution = AirconAirDistributionSerializer.getOptionalAirconAirDistribution(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirDistributionZone4(airconAirDistribution, n);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFootwellTempZone4(n, n20);
                    break;
                }
                case 286: {
                    int n = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterZone4(n, n21, n22);
                    break;
                }
                case 292: {
                    int n = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationZone4(n, n23, n24);
                    break;
                }
                case 104: {
                    AirconTemp airconTemp = AirconTempSerializer.getOptionalAirconTemp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempZone5(airconTemp, n);
                    break;
                }
                case 60: {
                    AirconAirVolume airconAirVolume = AirconAirVolumeSerializer.getOptionalAirconAirVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirVolumeZone5(airconAirVolume, n);
                    break;
                }
                case 201: {
                    AirconAirDistribution airconAirDistribution = AirconAirDistributionSerializer.getOptionalAirconAirDistribution(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirDistributionZone5(airconAirDistribution, n);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFootwellTempZone5(n, n25);
                    break;
                }
                case 287: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterZone5(n, n26, n27);
                    break;
                }
                case 293: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationZone5(n, n28, n29);
                    break;
                }
                case 105: {
                    AirconTemp airconTemp = AirconTempSerializer.getOptionalAirconTemp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempZone6(airconTemp, n);
                    break;
                }
                case 61: {
                    AirconAirVolume airconAirVolume = AirconAirVolumeSerializer.getOptionalAirconAirVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirVolumeZone6(airconAirVolume, n);
                    break;
                }
                case 202: {
                    AirconAirDistribution airconAirDistribution = AirconAirDistributionSerializer.getOptionalAirconAirDistribution(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirDistributionZone6(airconAirDistribution, n);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFootwellTempZone6(n, n30);
                    break;
                }
                case 288: {
                    int n = iDeserializer.getInt32();
                    int n31 = iDeserializer.getInt32();
                    int n32 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterZone6(n, n31, n32);
                    break;
                }
                case 294: {
                    int n = iDeserializer.getInt32();
                    int n33 = iDeserializer.getInt32();
                    int n34 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationZone6(n, n33, n34);
                    break;
                }
                case 117: {
                    int n = iDeserializer.getInt32();
                    int n35 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterDistributionZone1(n, n35);
                    break;
                }
                case 118: {
                    int n = iDeserializer.getInt32();
                    int n36 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterDistributionZone2(n, n36);
                    break;
                }
                case 119: {
                    int n = iDeserializer.getInt32();
                    int n37 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterDistributionZone3(n, n37);
                    break;
                }
                case 120: {
                    int n = iDeserializer.getInt32();
                    int n38 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterDistributionZone4(n, n38);
                    break;
                }
                case 121: {
                    int n = iDeserializer.getInt32();
                    int n39 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterDistributionZone5(n, n39);
                    break;
                }
                case 122: {
                    int n = iDeserializer.getInt32();
                    int n40 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatHeaterDistributionZone6(n, n40);
                    break;
                }
                case 123: {
                    int n = iDeserializer.getInt32();
                    int n41 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationDistributionZone1(n, n41);
                    break;
                }
                case 124: {
                    int n = iDeserializer.getInt32();
                    int n42 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationDistributionZone2(n, n42);
                    break;
                }
                case 125: {
                    int n = iDeserializer.getInt32();
                    int n43 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationDistributionZone3(n, n43);
                    break;
                }
                case 126: {
                    int n = iDeserializer.getInt32();
                    int n44 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationDistributionZone4(n, n44);
                    break;
                }
                case 127: {
                    int n = iDeserializer.getInt32();
                    int n45 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationDistributionZone5(n, n45);
                    break;
                }
                case 128: {
                    int n = iDeserializer.getInt32();
                    int n46 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatVentilationDistributionZone6(n, n46);
                    break;
                }
                case 130: {
                    int n = iDeserializer.getInt32();
                    int n47 = iDeserializer.getInt32();
                    int n48 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempStepZone1(n, n47, n48);
                    break;
                }
                case 131: {
                    int n = iDeserializer.getInt32();
                    int n49 = iDeserializer.getInt32();
                    int n50 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempStepZone2(n, n49, n50);
                    break;
                }
                case 132: {
                    int n = iDeserializer.getInt32();
                    int n51 = iDeserializer.getInt32();
                    int n52 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempStepZone3(n, n51, n52);
                    break;
                }
                case 133: {
                    int n = iDeserializer.getInt32();
                    int n53 = iDeserializer.getInt32();
                    int n54 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempStepZone4(n, n53, n54);
                    break;
                }
                case 134: {
                    int n = iDeserializer.getInt32();
                    int n55 = iDeserializer.getInt32();
                    int n56 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempStepZone5(n, n55, n56);
                    break;
                }
                case 135: {
                    int n = iDeserializer.getInt32();
                    int n57 = iDeserializer.getInt32();
                    int n58 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconTempStepZone6(n, n57, n58);
                    break;
                }
                case 276: {
                    AirconMasterViewOptions airconMasterViewOptions = AirconMasterViewOptionsSerializer.getOptionalAirconMasterViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconViewOptionsMaster(airconMasterViewOptions, n);
                    break;
                }
                case 295: {
                    AirconRowViewOptions airconRowViewOptions = AirconRowViewOptionsSerializer.getOptionalAirconRowViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconViewOptionsRow1(airconRowViewOptions, n);
                    break;
                }
                case 296: {
                    AirconRowViewOptions airconRowViewOptions = AirconRowViewOptionsSerializer.getOptionalAirconRowViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconViewOptionsRow2(airconRowViewOptions, n);
                    break;
                }
                case 297: {
                    AirconRowViewOptions airconRowViewOptions = AirconRowViewOptionsSerializer.getOptionalAirconRowViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconViewOptionsRow3(airconRowViewOptions, n);
                    break;
                }
                case 166: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarAirConditionReply.acknowledgeAirconSetFactoryDefaultMaster(bl);
                    break;
                }
                case 167: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarAirConditionReply.acknowledgeAirconSetFactoryDefaultRow(n, bl);
                    break;
                }
                case 163: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_DSICarAirConditionReply.acknowledgeAirconNozzleControlRow1(bl, bl2);
                    break;
                }
                case 164: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    this.p_DSICarAirConditionReply.acknowledgeAirconNozzleControlRow2(bl, bl3);
                    break;
                }
                case 165: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl4 = iDeserializer.getBool();
                    this.p_DSICarAirConditionReply.acknowledgeAirconNozzleControlRow3(bl, bl4);
                    break;
                }
                case 172: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    AirconNozzleListRecord[] airconNozzleListRecordArray = AirconNozzleListRecordSerializer.getOptionalAirconNozzleListRecordVarArray(iDeserializer);
                    this.p_DSICarAirConditionReply.responseAirconNozzleListRow1(carArrayListUpdateInfo, airconNozzleListRecordArray);
                    break;
                }
                case 173: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    AirconNozzleListRecord[] airconNozzleListRecordArray = AirconNozzleListRecordSerializer.getOptionalAirconNozzleListRecordVarArray(iDeserializer);
                    this.p_DSICarAirConditionReply.responseAirconNozzleListRow2(carArrayListUpdateInfo, airconNozzleListRecordArray);
                    break;
                }
                case 174: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    AirconNozzleListRecord[] airconNozzleListRecordArray = AirconNozzleListRecordSerializer.getOptionalAirconNozzleListRecordVarArray(iDeserializer);
                    this.p_DSICarAirConditionReply.responseAirconNozzleListRow3(carArrayListUpdateInfo, airconNozzleListRecordArray);
                    break;
                }
                case 240: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleListUpdateInfoRow1(carArrayListUpdateInfo, nArray, n);
                    break;
                }
                case 241: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleListUpdateInfoRow2(carArrayListUpdateInfo, nArray, n);
                    break;
                }
                case 242: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleListUpdateInfoRow3(carArrayListUpdateInfo, nArray, n);
                    break;
                }
                case 237: {
                    int n = iDeserializer.getInt32();
                    int n59 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleListTotalNumberOfElementsRow1(n, n59);
                    break;
                }
                case 238: {
                    int n = iDeserializer.getInt32();
                    int n60 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleListTotalNumberOfElementsRow2(n, n60);
                    break;
                }
                case 239: {
                    int n = iDeserializer.getInt32();
                    int n61 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleListTotalNumberOfElementsRow3(n, n61);
                    break;
                }
                case 271: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSideWindowDefrost(bl, n);
                    break;
                }
                case 246: {
                    AirconPureAirSetup airconPureAirSetup = AirconPureAirSetupSerializer.getOptionalAirconPureAirSetup(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n62 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconPureAir(airconPureAirSetup, n, n62);
                    break;
                }
                case 224: {
                    AirconFreshAirCartridge airconFreshAirCartridge = AirconFreshAirCartridgeSerializer.getOptionalAirconFreshAirCartridge(iDeserializer);
                    AirconFreshAirCartridge airconFreshAirCartridge2 = AirconFreshAirCartridgeSerializer.getOptionalAirconFreshAirCartridge(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFreshAirState(airconFreshAirCartridge, airconFreshAirCartridge2, n);
                    break;
                }
                case 223: {
                    AirconFreshAirConfiguration airconFreshAirConfiguration = AirconFreshAirConfigurationSerializer.getOptionalAirconFreshAirConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconFreshAirConfig(airconFreshAirConfiguration, n);
                    break;
                }
                case 203: {
                    AirconAirQuality airconAirQuality = AirconAirQualitySerializer.getOptionalAirconAirQuality(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconAirQuality(airconAirQuality, n);
                    break;
                }
                case 243: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleStatusRow1(bl, n);
                    break;
                }
                case 244: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleStatusRow2(bl, n);
                    break;
                }
                case 245: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconNozzleStatusRow3(bl, n);
                    break;
                }
                case 216: {
                    int n = iDeserializer.getInt32();
                    int n63 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStyleZone1(n, n63);
                    break;
                }
                case 217: {
                    int n = iDeserializer.getInt32();
                    int n64 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStyleZone2(n, n64);
                    break;
                }
                case 218: {
                    int n = iDeserializer.getInt32();
                    int n65 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStyleZone3(n, n65);
                    break;
                }
                case 219: {
                    int n = iDeserializer.getInt32();
                    int n66 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStyleZone4(n, n66);
                    break;
                }
                case 220: {
                    int n = iDeserializer.getInt32();
                    int n67 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStyleZone5(n, n67);
                    break;
                }
                case 221: {
                    int n = iDeserializer.getInt32();
                    int n68 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStyleZone6(n, n68);
                    break;
                }
                case 210: {
                    int n = iDeserializer.getInt32();
                    int n69 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStateZone1(n, n69);
                    break;
                }
                case 211: {
                    int n = iDeserializer.getInt32();
                    int n70 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStateZone2(n, n70);
                    break;
                }
                case 212: {
                    int n = iDeserializer.getInt32();
                    int n71 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStateZone3(n, n71);
                    break;
                }
                case 213: {
                    int n = iDeserializer.getInt32();
                    int n72 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStateZone4(n, n72);
                    break;
                }
                case 214: {
                    int n = iDeserializer.getInt32();
                    int n73 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStateZone5(n, n73);
                    break;
                }
                case 215: {
                    int n = iDeserializer.getInt32();
                    int n74 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconClimateStateZone6(n, n74);
                    break;
                }
                case 253: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n75 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatNeckHeaterZone1(bl, n, n75);
                    break;
                }
                case 254: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n76 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatNeckHeaterZone2(bl, n, n76);
                    break;
                }
                case 255: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n77 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatNeckHeaterZone3(bl, n, n77);
                    break;
                }
                case 256: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n78 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatNeckHeaterZone4(bl, n, n78);
                    break;
                }
                case 257: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n79 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatNeckHeaterZone5(bl, n, n79);
                    break;
                }
                case 258: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n80 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatNeckHeaterZone6(bl, n, n80);
                    break;
                }
                case 259: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl5 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n81 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatSurfaceHeaterZone1(bl, bl5, n, n81);
                    break;
                }
                case 260: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl6 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n82 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatSurfaceHeaterZone2(bl, bl6, n, n82);
                    break;
                }
                case 261: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl7 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n83 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatSurfaceHeaterZone3(bl, bl7, n, n83);
                    break;
                }
                case 262: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl8 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n84 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatSurfaceHeaterZone4(bl, bl8, n, n84);
                    break;
                }
                case 263: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl9 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n85 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatSurfaceHeaterZone5(bl, bl9, n, n85);
                    break;
                }
                case 264: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl10 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n86 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconSeatSurfaceHeaterZone6(bl, bl10, n, n86);
                    break;
                }
                case 225: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIndividualClimatisationZone1(bl, n);
                    break;
                }
                case 226: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIndividualClimatisationZone2(bl, n);
                    break;
                }
                case 227: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIndividualClimatisationZone3(bl, n);
                    break;
                }
                case 228: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIndividualClimatisationZone4(bl, n);
                    break;
                }
                case 229: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIndividualClimatisationZone5(bl, n);
                    break;
                }
                case 230: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIndividualClimatisationZone6(bl, n);
                    break;
                }
                case 231: {
                    int n = iDeserializer.getInt32();
                    int n87 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIonisatorZone1(n, n87);
                    break;
                }
                case 232: {
                    int n = iDeserializer.getInt32();
                    int n88 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIonisatorZone2(n, n88);
                    break;
                }
                case 233: {
                    int n = iDeserializer.getInt32();
                    int n89 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIonisatorZone3(n, n89);
                    break;
                }
                case 234: {
                    int n = iDeserializer.getInt32();
                    int n90 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIonisatorZone4(n, n90);
                    break;
                }
                case 235: {
                    int n = iDeserializer.getInt32();
                    int n91 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIonisatorZone5(n, n91);
                    break;
                }
                case 236: {
                    int n = iDeserializer.getInt32();
                    int n92 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconIonisatorZone6(n, n92);
                    break;
                }
                case 204: {
                    boolean bl = iDeserializer.getBool();
                    AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconBodyCloseMeasuresZone1(bl, airconBCMeasuresConfiguration, n);
                    break;
                }
                case 205: {
                    boolean bl = iDeserializer.getBool();
                    AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconBodyCloseMeasuresZone2(bl, airconBCMeasuresConfiguration, n);
                    break;
                }
                case 206: {
                    boolean bl = iDeserializer.getBool();
                    AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconBodyCloseMeasuresZone3(bl, airconBCMeasuresConfiguration, n);
                    break;
                }
                case 207: {
                    boolean bl = iDeserializer.getBool();
                    AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconBodyCloseMeasuresZone4(bl, airconBCMeasuresConfiguration, n);
                    break;
                }
                case 208: {
                    boolean bl = iDeserializer.getBool();
                    AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconBodyCloseMeasuresZone5(bl, airconBCMeasuresConfiguration, n);
                    break;
                }
                case 209: {
                    boolean bl = iDeserializer.getBool();
                    AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.updateAirconBodyCloseMeasuresZone6(bl, airconBCMeasuresConfiguration, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n93 = iDeserializer.getInt32();
                    this.p_DSICarAirConditionReply.asyncException(n, string, n93);
                    break;
                }
                case 107: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarAirConditionReply.yyIndication(string, string2);
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

