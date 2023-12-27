/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombi;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombiC;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombiReply;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$1;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$10;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$11;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$12;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$13;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$14;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$15;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$16;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$17;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$18;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$19;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$2;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$3;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$4;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$5;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$6;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$7;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$8;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy$9;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarKombiProxy
implements DSICarKombi,
DSICarKombiC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carkombi.DSICarKombi");
    private Proxy proxy;

    public DSICarKombiProxy(int n, DSICarKombiReply dSICarKombiReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2134aec9-b386-5e87-ba1a-0c71e46a44b4", n, "acd7898d-1e18-59e8-8cfa-13a7f7533288", "dsi.carkombi.DSICarKombi");
        DSICarKombiReplyService dSICarKombiReplyService = new DSICarKombiReplyService(dSICarKombiReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarKombiReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void resetSIAValue(int n) {
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
    public void requestSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        DSICarKombiProxy$1 dSICarKombiProxy$1 = new DSICarKombiProxy$1(this, carArrayListUpdateInfo);
        this.proxy.remoteCallMethod((short)188, dSICarKombiProxy$1);
    }

    @Override
    public void setSIADistanceOilUser(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)205, genericSerializable);
    }

    @Override
    public void setSIADistanceAirFilterUser(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)203, genericSerializable);
    }

    @Override
    public void setSIADistanceOilFilterUser(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)204, genericSerializable);
    }

    @Override
    public void setSIAInspectionDistanceUser(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)206, genericSerializable);
    }

    @Override
    public void setBCVZADisplay(boolean bl) {
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
    public void setBCLifeTipsDisplay(boolean bl) {
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
    public void setBCConsumerDisplay(boolean bl) {
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
    public void setBCMenueConfig(BCMenueConfiguration bCMenueConfiguration, int n) {
        DSICarKombiProxy$2 dSICarKombiProxy$2 = new DSICarKombiProxy$2(this, bCMenueConfiguration, n);
        this.proxy.remoteCallMethod((short)111, dSICarKombiProxy$2);
    }

    @Override
    public void resetBCMenue(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setBCOilTemperature(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void setBCDigitalSpeed(boolean bl) {
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
    public void setBCStopwatch(boolean bl) {
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
    public void setBCVzaMFA(boolean bl) {
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
    public void setBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings) {
        DSICarKombiProxy$3 dSICarKombiProxy$3 = new DSICarKombiProxy$3(this, bCSpeedWarningSettings);
        this.proxy.remoteCallMethod((short)25, dSICarKombiProxy$3);
    }

    @Override
    public void setBCGearRecommendation(boolean bl) {
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
    public void setBCRearSeatbeltWarning(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void requestVehicleStateList(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        DSICarKombiProxy$4 dSICarKombiProxy$4 = new DSICarKombiProxy$4(this, bCVehicleStateUpdateInfoAH);
        this.proxy.remoteCallMethod((short)143, dSICarKombiProxy$4);
    }

    @Override
    public void setBcSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)29, null);
    }

    @Override
    public void resetBCStatistics(BCStatisticsReset bCStatisticsReset) {
        DSICarKombiProxy$5 dSICarKombiProxy$5 = new DSICarKombiProxy$5(this, bCStatisticsReset);
        this.proxy.remoteCallMethod((short)10, dSICarKombiProxy$5);
    }

    @Override
    public void setBCAstaMFA(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)171, genericSerializable);
    }

    @Override
    public void setHUDHeightAdjustment(byte by) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    @Override
    public void setHUDBrightness(byte by) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void setHUDContent(HUDContent hUDContent) {
        DSICarKombiProxy$6 dSICarKombiProxy$6 = new DSICarKombiProxy$6(this, hUDContent);
        this.proxy.remoteCallMethod((short)104, dSICarKombiProxy$6);
    }

    @Override
    public void setHUDRotationAdjustment(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)105, genericSerializable);
    }

    @Override
    public void setHUDColour(int n, int n2) {
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
    public void setHUDSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)113, null);
    }

    @Override
    public void setHUDSystemOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)114, genericSerializable);
    }

    @Override
    public void setDCSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)158, null);
    }

    @Override
    public void setDCBrightness(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)152, genericSerializable);
    }

    @Override
    public void setDCVolume(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)159, genericSerializable);
    }

    @Override
    public void setDCDisplay1MainSelection(DCMainItems dCMainItems) {
        DSICarKombiProxy$7 dSICarKombiProxy$7 = new DSICarKombiProxy$7(this, dCMainItems);
        this.proxy.remoteCallMethod((short)194, dSICarKombiProxy$7);
    }

    @Override
    public void setDCDisplay2MainSelection(DCMainItems dCMainItems) {
        DSICarKombiProxy$8 dSICarKombiProxy$8 = new DSICarKombiProxy$8(this, dCMainItems);
        this.proxy.remoteCallMethod((short)195, dSICarKombiProxy$8);
    }

    @Override
    public void setDCDisplay3MainSelection(DCMainItems dCMainItems) {
        DSICarKombiProxy$9 dSICarKombiProxy$9 = new DSICarKombiProxy$9(this, dCMainItems);
        this.proxy.remoteCallMethod((short)196, dSICarKombiProxy$9);
    }

    @Override
    public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        DSICarKombiProxy$10 dSICarKombiProxy$10 = new DSICarKombiProxy$10(this, dCElementContentSelectionListUpdateInfo);
        this.proxy.remoteCallMethod((short)142, dSICarKombiProxy$10);
    }

    @Override
    public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        DSICarKombiProxy$11 dSICarKombiProxy$11 = new DSICarKombiProxy$11(this, dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
        this.proxy.remoteCallMethod((short)156, dSICarKombiProxy$11);
    }

    @Override
    public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        DSICarKombiProxy$12 dSICarKombiProxy$12 = new DSICarKombiProxy$12(this, dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA2Array);
        this.proxy.remoteCallMethod((short)200, dSICarKombiProxy$12);
    }

    @Override
    public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        DSICarKombiProxy$13 dSICarKombiProxy$13 = new DSICarKombiProxy$13(this, dCElementContentSelectionListUpdateInfo, nArray);
        this.proxy.remoteCallMethod((short)157, dSICarKombiProxy$13);
    }

    @Override
    public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument) {
        DSICarKombiProxy$14 dSICarKombiProxy$14 = new DSICarKombiProxy$14(this, dCAdditionalInstrument);
        this.proxy.remoteCallMethod((short)172, dSICarKombiProxy$14);
    }

    @Override
    public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2) {
        DSICarKombiProxy$15 dSICarKombiProxy$15 = new DSICarKombiProxy$15(this, dCAdditionalInstrument2);
        this.proxy.remoteCallMethod((short)193, dSICarKombiProxy$15);
    }

    @Override
    public void requestDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        DSICarKombiProxy$16 dSICarKombiProxy$16 = new DSICarKombiProxy$16(this, carArrayListUpdateInfo);
        this.proxy.remoteCallMethod((short)187, dSICarKombiProxy$16);
    }

    @Override
    public void setDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        DSICarKombiProxy$17 dSICarKombiProxy$17 = new DSICarKombiProxy$17(this, carArrayListUpdateInfo, dCDisplayPresetsListRecordArray);
        this.proxy.remoteCallMethod((short)198, dSICarKombiProxy$17);
    }

    @Override
    public void setDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency) {
        DSICarKombiProxy$18 dSICarKombiProxy$18 = new DSICarKombiProxy$18(this, dCDisplayDependency);
        this.proxy.remoteCallMethod((short)197, dSICarKombiProxy$18);
    }

    @Override
    public void setDCActiveDisplayPreset(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)192, genericSerializable);
    }

    @Override
    public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration) {
        DSICarKombiProxy$19 dSICarKombiProxy$19 = new DSICarKombiProxy$19(this, dCDisplayViewConfiguration);
        this.proxy.remoteCallMethod((short)199, dSICarKombiProxy$19);
    }

    @Override
    public void setHUDLicense(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)202, genericSerializable);
    }

    @Override
    public void setDCLEDConfiguration(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)201, genericSerializable);
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
        this.proxy.remoteCallMethod((short)34, genericSerializable);
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
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)33, null);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)98, genericSerializable);
    }
}

