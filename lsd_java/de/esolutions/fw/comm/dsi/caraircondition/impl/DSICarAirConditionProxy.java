/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirCondition;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirConditionC;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirConditionReply;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$1;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$10;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$11;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$12;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$13;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$14;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$2;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$3;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$4;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$5;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$6;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$7;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$8;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy$9;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarAirConditionProxy
implements DSICarAirCondition,
DSICarAirConditionC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.caraircondition.DSICarAirCondition");
    private Proxy proxy;

    public DSICarAirConditionProxy(int n, DSICarAirConditionReply dSICarAirConditionReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5bd0c4d1-7601-59a2-a47a-293eb5eb76b8", n, "cf30a335-1e95-5df1-81d1-e5ebf39a5f7b", "dsi.caraircondition.DSICarAirCondition");
        DSICarAirConditionReplyService dSICarAirConditionReplyService = new DSICarAirConditionReplyService(dSICarAirConditionReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarAirConditionReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setAirconAirCirculationMan(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setAirconAirCirculationAuto(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setAirconMiddleExhaustion(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void setAirconRearWindowHeater(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void setAirconIndirectVentilation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setAirconPopupTime(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void setAirconHeater(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void setAirconRearAuxHeater(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setAirconFrontWindowHeater(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void setAirconDefrost(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setAirconMaxDefrost(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)110, genericSerializable);
    }

    @Override
    public void setAirconSolar(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    @Override
    public void setAirconAC(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setAirconMaxAC(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)109, genericSerializable);
    }

    @Override
    public void setAirconEcoAC(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)141, genericSerializable);
    }

    @Override
    public void setAirconRearControl(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void setAirconRearControlFondPlus(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)143, genericSerializable);
    }

    @Override
    public void setAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater) {
        DSICarAirConditionProxy$1 dSICarAirConditionProxy$1 = new DSICarAirConditionProxy$1(this, airconSteeringWheelHeater);
        this.proxy.remoteCallMethod((short)113, dSICarAirConditionProxy$1);
    }

    @Override
    public void setAirconFrontWindowHeaterAuto(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void setAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation) {
        DSICarAirConditionProxy$2 dSICarAirConditionProxy$2 = new DSICarAirConditionProxy$2(this, airconBlowerCompensation);
        this.proxy.remoteCallMethod((short)137, dSICarAirConditionProxy$2);
    }

    @Override
    public void setAirconSynchronisation(AirconSynchronisation airconSynchronisation) {
        DSICarAirConditionProxy$3 dSICarAirConditionProxy$3 = new DSICarAirConditionProxy$3(this, airconSynchronisation);
        this.proxy.remoteCallMethod((short)145, dSICarAirConditionProxy$3);
    }

    @Override
    public void setAirconSuppressVisualisation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    @Override
    public void setAirconSystemOnOffRow(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)195, genericSerializable);
    }

    @Override
    public void setAirconAirCirculationSensitivity(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setAirconResidualHeat(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void showAirconPopup(AirconContent airconContent) {
        DSICarAirConditionProxy$4 dSICarAirConditionProxy$4 = new DSICarAirConditionProxy$4(this, airconContent);
        this.proxy.remoteCallMethod((short)196, dSICarAirConditionProxy$4);
    }

    @Override
    public void cancelAirconPopup(AirconContent airconContent, int n) {
        DSICarAirConditionProxy$5 dSICarAirConditionProxy$5 = new DSICarAirConditionProxy$5(this, airconContent, n);
        this.proxy.remoteCallMethod((short)169, dSICarAirConditionProxy$5);
    }

    @Override
    public void setAirconContent(AirconContent airconContent) {
        DSICarAirConditionProxy$6 dSICarAirConditionProxy$6 = new DSICarAirConditionProxy$6(this, airconContent);
        this.proxy.remoteCallMethod((short)179, dSICarAirConditionProxy$6);
    }

    @Override
    public void setAirconTempZone(int n, AirconTemp airconTemp) {
        DSICarAirConditionProxy$7 dSICarAirConditionProxy$7 = new DSICarAirConditionProxy$7(this, n, airconTemp);
        this.proxy.remoteCallMethod((short)40, dSICarAirConditionProxy$7);
    }

    @Override
    public void setAirconAirVolume(int n, AirconAirVolume airconAirVolume) {
        DSICarAirConditionProxy$8 dSICarAirConditionProxy$8 = new DSICarAirConditionProxy$8(this, n, airconAirVolume);
        this.proxy.remoteCallMethod((short)13, dSICarAirConditionProxy$8);
    }

    @Override
    public void setAirconAirDistribution(int n, AirconAirDistribution airconAirDistribution) {
        DSICarAirConditionProxy$9 dSICarAirConditionProxy$9 = new DSICarAirConditionProxy$9(this, n, airconAirDistribution);
        this.proxy.remoteCallMethod((short)175, dSICarAirConditionProxy$9);
    }

    @Override
    public void setAirconFootwellTemp(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void setAirconSeatHeater(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)281, genericSerializable);
    }

    @Override
    public void setAirconSeatVentilation(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)282, genericSerializable);
    }

    @Override
    public void setAirconHMIIsReady(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void setAirconSeatHeaterDistribution(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)111, genericSerializable);
    }

    @Override
    public void setAirconSeatVentilationDistribution(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)112, genericSerializable);
    }

    @Override
    public void setAirconTempStep(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)114, genericSerializable);
    }

    @Override
    public void setAirconClimateStyle(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)178, genericSerializable);
    }

    @Override
    public void setAirconSetFactoryDefaultMaster() {
        this.proxy.remoteCallMethod((short)192, null);
    }

    @Override
    public void setAirconSetFactoryDefaultRow(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)193, genericSerializable);
    }

    @Override
    public void setAirconNozzleControlRow1(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)183, genericSerializable);
    }

    @Override
    public void setAirconNozzleControlRow2(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)184, genericSerializable);
    }

    @Override
    public void setAirconNozzleControlRow3(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)185, genericSerializable);
    }

    @Override
    public void requestAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        DSICarAirConditionProxy$10 dSICarAirConditionProxy$10 = new DSICarAirConditionProxy$10(this, n, carArrayListUpdateInfo);
        this.proxy.remoteCallMethod((short)170, dSICarAirConditionProxy$10);
    }

    @Override
    public void setAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        DSICarAirConditionProxy$11 dSICarAirConditionProxy$11 = new DSICarAirConditionProxy$11(this, n, carArrayListUpdateInfo, airconNozzleListRecordArray);
        this.proxy.remoteCallMethod((short)186, dSICarAirConditionProxy$11);
    }

    @Override
    public void setAirconSideWindowDefrost(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)194, genericSerializable);
    }

    @Override
    public void setAirconPureAir(AirconPureAirSetup airconPureAirSetup) {
        DSICarAirConditionProxy$12 dSICarAirConditionProxy$12 = new DSICarAirConditionProxy$12(this, airconPureAirSetup);
        this.proxy.remoteCallMethod((short)187, dSICarAirConditionProxy$12);
    }

    @Override
    public void setAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration) {
        DSICarAirConditionProxy$13 dSICarAirConditionProxy$13 = new DSICarAirConditionProxy$13(this, airconFreshAirConfiguration);
        this.proxy.remoteCallMethod((short)180, dSICarAirConditionProxy$13);
    }

    @Override
    public void setAirconAirQuality(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)176, genericSerializable);
    }

    @Override
    public void setAirconSeatNeckHeater(int n, boolean bl, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)189, genericSerializable);
    }

    @Override
    public void setAirconSeatSurfaceHeater(int n, boolean bl, boolean bl2, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)190, genericSerializable);
    }

    @Override
    public void setAirconIndividualClimatisation(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)181, genericSerializable);
    }

    @Override
    public void setAirconIonisator(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)280, genericSerializable);
    }

    @Override
    public void setAirconBodyCloseMeasures(int n, boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
        DSICarAirConditionProxy$14 dSICarAirConditionProxy$14 = new DSICarAirConditionProxy$14(this, n, bl, airconBCMeasuresConfiguration);
        this.proxy.remoteCallMethod((short)177, dSICarAirConditionProxy$14);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)41, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)108, genericSerializable);
    }
}

