/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;
import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceS;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelPressures;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelStates;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelTemperatures;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarServiceAbstractBaseService
implements ASIHMISyncCarServiceS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.service.ASIHMISyncCarService");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private OilLevelData OilLevelData;
    private boolean OilLevelData_valid = false;
    private int OilLevelDataVisibilityState;
    private boolean OilLevelDataVisibilityState_valid = false;
    private AdBlueInfo AdBlueInfo;
    private boolean AdBlueInfo_valid = false;
    private int AdBlueInfoVisibilityState;
    private boolean AdBlueInfoVisibilityState_valid = false;
    private SIAOilInspection SIAOilInspection;
    private boolean SIAOilInspection_valid = false;
    private int[] SIAOilInspectionVisibilityState;
    private boolean SIAOilInspectionVisibilityState_valid = false;
    private SIAServiceData SIAServiceData;
    private boolean SIAServiceData_valid = false;
    private int SIAServiceDataVisibilityState;
    private boolean SIAServiceDataVisibilityState_valid = false;
    private String VinData;
    private boolean VinData_valid = false;
    private int VinDataVisibilityState;
    private boolean VinDataVisibilityState_valid = false;
    private int[] KeyData;
    private boolean KeyData_valid = false;
    private int KeyDataVisibilityState;
    private boolean KeyDataVisibilityState_valid = false;
    private TireDisplayData TireDisplayData;
    private boolean TireDisplayData_valid = false;
    private int TireDisplayDataVisibilityState;
    private boolean TireDisplayDataVisibilityState_valid = false;
    private int TireSystem;
    private boolean TireSystem_valid = false;
    private int VehicleSpeedVisibility;
    private boolean VehicleSpeedVisibility_valid = false;
    private FloatBaseType VehicleSpeed;
    private boolean VehicleSpeed_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static OilLevelData copyOilLevelData(OilLevelData oilLevelData) {
        if (oilLevelData == null) {
            return null;
        }
        OilLevelData oilLevelData2 = new OilLevelData();
        oilLevelData2.level = oilLevelData.level;
        oilLevelData2.refillVolume = ASIHMISyncCarServiceAbstractBaseService.copyIntBaseType(oilLevelData.refillVolume);
        oilLevelData2.warnings = oilLevelData.warnings;
        oilLevelData2.oilsystem = oilLevelData.oilsystem;
        oilLevelData2.bargraph = oilLevelData.bargraph;
        return oilLevelData2;
    }

    public static IntBaseType copyIntBaseType(IntBaseType intBaseType) {
        if (intBaseType == null) {
            return null;
        }
        IntBaseType intBaseType2 = new IntBaseType();
        intBaseType2.value = intBaseType.value;
        intBaseType2.unit = intBaseType.unit;
        intBaseType2.status = intBaseType.status;
        return intBaseType2;
    }

    public static AdBlueInfo copyAdBlueInfo(AdBlueInfo adBlueInfo) {
        if (adBlueInfo == null) {
            return null;
        }
        AdBlueInfo adBlueInfo2 = new AdBlueInfo();
        adBlueInfo2.range = adBlueInfo.range;
        adBlueInfo2.rangeUnit = adBlueInfo.rangeUnit;
        adBlueInfo2.level = adBlueInfo.level;
        adBlueInfo2.tankVolume = adBlueInfo.tankVolume;
        adBlueInfo2.state = adBlueInfo.state;
        adBlueInfo2.volumeUnit = adBlueInfo.volumeUnit;
        adBlueInfo2.minRefill = adBlueInfo.minRefill;
        adBlueInfo2.maxRefill = adBlueInfo.maxRefill;
        return adBlueInfo2;
    }

    public static SIAOilInspection copySIAOilInspection(SIAOilInspection sIAOilInspection) {
        if (sIAOilInspection == null) {
            return null;
        }
        SIAOilInspection sIAOilInspection2 = new SIAOilInspection();
        sIAOilInspection2.distanceStatus = sIAOilInspection.distanceStatus;
        sIAOilInspection2.distance = sIAOilInspection.distance;
        sIAOilInspection2.distanceUnit = sIAOilInspection.distanceUnit;
        sIAOilInspection2.timeStatus = sIAOilInspection.timeStatus;
        sIAOilInspection2.time = sIAOilInspection.time;
        return sIAOilInspection2;
    }

    public static SIAServiceData copySIAServiceData(SIAServiceData sIAServiceData) {
        if (sIAServiceData == null) {
            return null;
        }
        SIAServiceData sIAServiceData2 = new SIAServiceData();
        sIAServiceData2.distanceStatus = sIAServiceData.distanceStatus;
        sIAServiceData2.distance = sIAServiceData.distance;
        sIAServiceData2.distanceUnit = sIAServiceData.distanceUnit;
        sIAServiceData2.timeStatus = sIAServiceData.timeStatus;
        sIAServiceData2.time = sIAServiceData.time;
        return sIAServiceData2;
    }

    public static TireDisplayData copyTireDisplayData(TireDisplayData tireDisplayData) {
        if (tireDisplayData == null) {
            return null;
        }
        TireDisplayData tireDisplayData2 = new TireDisplayData();
        tireDisplayData2.wheelStates = ASIHMISyncCarServiceAbstractBaseService.copyWheelStates(tireDisplayData.wheelStates);
        tireDisplayData2.wheelPressures = ASIHMISyncCarServiceAbstractBaseService.copyWheelPressures(tireDisplayData.wheelPressures);
        tireDisplayData2.requiredWheelPressures = ASIHMISyncCarServiceAbstractBaseService.copyWheelPressures(tireDisplayData.requiredWheelPressures);
        tireDisplayData2.wheelTemperatures = ASIHMISyncCarServiceAbstractBaseService.copyWheelTemperatures(tireDisplayData.wheelTemperatures);
        return tireDisplayData2;
    }

    public static WheelStates copyWheelStates(WheelStates wheelStates) {
        if (wheelStates == null) {
            return null;
        }
        WheelStates wheelStates2 = new WheelStates();
        wheelStates2.frontLeft = wheelStates.frontLeft;
        wheelStates2.frontRight = wheelStates.frontRight;
        wheelStates2.rearLeft = wheelStates.rearLeft;
        wheelStates2.rearRight = wheelStates.rearRight;
        wheelStates2.spareWheel = wheelStates.spareWheel;
        wheelStates2.collectedState = wheelStates.collectedState;
        return wheelStates2;
    }

    public static WheelPressures copyWheelPressures(WheelPressures wheelPressures) {
        if (wheelPressures == null) {
            return null;
        }
        WheelPressures wheelPressures2 = new WheelPressures();
        wheelPressures2.pressureUnit = wheelPressures.pressureUnit;
        wheelPressures2.frontLeft = wheelPressures.frontLeft;
        wheelPressures2.frontRight = wheelPressures.frontRight;
        wheelPressures2.rearLeft = wheelPressures.rearLeft;
        wheelPressures2.rearRight = wheelPressures.rearRight;
        wheelPressures2.spareWheel = wheelPressures.spareWheel;
        return wheelPressures2;
    }

    public static WheelTemperatures copyWheelTemperatures(WheelTemperatures wheelTemperatures) {
        if (wheelTemperatures == null) {
            return null;
        }
        WheelTemperatures wheelTemperatures2 = new WheelTemperatures();
        wheelTemperatures2.temperatureUnit = wheelTemperatures.temperatureUnit;
        wheelTemperatures2.frontLeft = wheelTemperatures.frontLeft;
        wheelTemperatures2.frontRight = wheelTemperatures.frontRight;
        wheelTemperatures2.rearLeft = wheelTemperatures.rearLeft;
        wheelTemperatures2.rearRight = wheelTemperatures.rearRight;
        wheelTemperatures2.spareWheel = wheelTemperatures.spareWheel;
        return wheelTemperatures2;
    }

    public static FloatBaseType copyFloatBaseType(FloatBaseType floatBaseType) {
        if (floatBaseType == null) {
            return null;
        }
        FloatBaseType floatBaseType2 = new FloatBaseType();
        floatBaseType2.value = floatBaseType.value;
        floatBaseType2.unit = floatBaseType.unit;
        floatBaseType2.status = floatBaseType.status;
        return floatBaseType2;
    }

    public ASIHMISyncCarServiceAbstractBaseService() {
        ASIHMISyncCarServiceAbstractBaseService$AttributesBitMapProvider aSIHMISyncCarServiceAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncCarServiceAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarService", aSIHMISyncCarServiceAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarServiceReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarServiceReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.setNotification(aSIHMISyncCarServiceReply);
        this.sendAttributeUpdate(aSIHMISyncCarServiceReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarServiceReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarServiceReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarServiceReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.clearNotification(aSIHMISyncCarServiceReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarServiceReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        try {
            aSIHMISyncCarServiceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarServiceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarServiceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarServiceReply.updateOilLevelData(this.OilLevelData, this.OilLevelData_valid);
            aSIHMISyncCarServiceReply.updateOilLevelDataVisibilityState(this.OilLevelDataVisibilityState, this.OilLevelDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateAdBlueInfo(this.AdBlueInfo, this.AdBlueInfo_valid);
            aSIHMISyncCarServiceReply.updateAdBlueInfoVisibilityState(this.AdBlueInfoVisibilityState, this.AdBlueInfoVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateSIAOilInspection(this.SIAOilInspection, this.SIAOilInspection_valid);
            aSIHMISyncCarServiceReply.updateSIAOilInspectionVisibilityState(this.SIAOilInspectionVisibilityState, this.SIAOilInspectionVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateSIAServiceData(this.SIAServiceData, this.SIAServiceData_valid);
            aSIHMISyncCarServiceReply.updateSIAServiceDataVisibilityState(this.SIAServiceDataVisibilityState, this.SIAServiceDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateVinData(this.VinData, this.VinData_valid);
            aSIHMISyncCarServiceReply.updateVinDataVisibilityState(this.VinDataVisibilityState, this.VinDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateKeyData(this.KeyData, this.KeyData_valid);
            aSIHMISyncCarServiceReply.updateKeyDataVisibilityState(this.KeyDataVisibilityState, this.KeyDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateTireDisplayData(this.TireDisplayData, this.TireDisplayData_valid);
            aSIHMISyncCarServiceReply.updateTireDisplayDataVisibilityState(this.TireDisplayDataVisibilityState, this.TireDisplayDataVisibilityState_valid);
            aSIHMISyncCarServiceReply.updateTireSystem(this.TireSystem, this.TireSystem_valid);
            aSIHMISyncCarServiceReply.updateVehicleSpeedVisibility(this.VehicleSpeedVisibility, this.VehicleSpeedVisibility_valid);
            aSIHMISyncCarServiceReply.updateVehicleSpeed(this.VehicleSpeed, this.VehicleSpeed_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarServiceReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
        try {
            if (l == 0) {
                aSIHMISyncCarServiceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateOilLevelData(this.OilLevelData, this.OilLevelData_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateOilLevelDataVisibilityState(this.OilLevelDataVisibilityState, this.OilLevelDataVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateAdBlueInfo(this.AdBlueInfo, this.AdBlueInfo_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateAdBlueInfoVisibilityState(this.AdBlueInfoVisibilityState, this.AdBlueInfoVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateSIAOilInspection(this.SIAOilInspection, this.SIAOilInspection_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateSIAOilInspectionVisibilityState(this.SIAOilInspectionVisibilityState, this.SIAOilInspectionVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateSIAServiceData(this.SIAServiceData, this.SIAServiceData_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateSIAServiceDataVisibilityState(this.SIAServiceDataVisibilityState, this.SIAServiceDataVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateVinData(this.VinData, this.VinData_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateVinDataVisibilityState(this.VinDataVisibilityState, this.VinDataVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateKeyData(this.KeyData, this.KeyData_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateKeyDataVisibilityState(this.KeyDataVisibilityState, this.KeyDataVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateTireDisplayData(this.TireDisplayData, this.TireDisplayData_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateTireDisplayDataVisibilityState(this.TireDisplayDataVisibilityState, this.TireDisplayDataVisibilityState_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateTireSystem(this.TireSystem, this.TireSystem_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateVehicleSpeedVisibility(this.VehicleSpeedVisibility, this.VehicleSpeedVisibility_valid);
            } else if (l == 0) {
                aSIHMISyncCarServiceReply.updateVehicleSpeed(this.VehicleSpeed, this.VehicleSpeed_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) {
        this.ASIVersion = ASIHMISyncCarServiceAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateOilLevelData(OilLevelData oilLevelData) {
        this.updateOilLevelData(oilLevelData, true);
    }

    public void updateOilLevelData(OilLevelData oilLevelData, boolean bl) {
        this.OilLevelData = ASIHMISyncCarServiceAbstractBaseService.copyOilLevelData(oilLevelData);
        this.OilLevelData_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateOilLevelData(oilLevelData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateOilLevelDataVisibilityState(int n) {
        this.updateOilLevelDataVisibilityState(n, true);
    }

    public void updateOilLevelDataVisibilityState(int n, boolean bl) {
        this.OilLevelDataVisibilityState = n;
        this.OilLevelDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateOilLevelDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAdBlueInfo(AdBlueInfo adBlueInfo) {
        this.updateAdBlueInfo(adBlueInfo, true);
    }

    public void updateAdBlueInfo(AdBlueInfo adBlueInfo, boolean bl) {
        this.AdBlueInfo = ASIHMISyncCarServiceAbstractBaseService.copyAdBlueInfo(adBlueInfo);
        this.AdBlueInfo_valid = bl;
        List list = this.baseService.getNotifications(26);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateAdBlueInfo(adBlueInfo, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateAdBlueInfoVisibilityState(int n) {
        this.updateAdBlueInfoVisibilityState(n, true);
    }

    public void updateAdBlueInfoVisibilityState(int n, boolean bl) {
        this.AdBlueInfoVisibilityState = n;
        this.AdBlueInfoVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateAdBlueInfoVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection) {
        this.updateSIAOilInspection(sIAOilInspection, true);
    }

    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, boolean bl) {
        this.SIAOilInspection = ASIHMISyncCarServiceAbstractBaseService.copySIAOilInspection(sIAOilInspection);
        this.SIAOilInspection_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAOilInspection(sIAOilInspection, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAOilInspectionVisibilityState(int[] nArray) {
        this.updateSIAOilInspectionVisibilityState(nArray, true);
    }

    public void updateSIAOilInspectionVisibilityState(int[] nArray, boolean bl) {
        if (nArray != null) {
            this.SIAOilInspectionVisibilityState = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.SIAOilInspectionVisibilityState, 0, nArray.length);
        } else {
            this.SIAOilInspectionVisibilityState = null;
        }
        this.SIAOilInspectionVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAOilInspectionVisibilityState(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAServiceData(SIAServiceData sIAServiceData) {
        this.updateSIAServiceData(sIAServiceData, true);
    }

    public void updateSIAServiceData(SIAServiceData sIAServiceData, boolean bl) {
        this.SIAServiceData = ASIHMISyncCarServiceAbstractBaseService.copySIAServiceData(sIAServiceData);
        this.SIAServiceData_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAServiceData(sIAServiceData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSIAServiceDataVisibilityState(int n) {
        this.updateSIAServiceDataVisibilityState(n, true);
    }

    public void updateSIAServiceDataVisibilityState(int n, boolean bl) {
        this.SIAServiceDataVisibilityState = n;
        this.SIAServiceDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateSIAServiceDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVinData(String string) {
        this.updateVinData(string, true);
    }

    public void updateVinData(String string, boolean bl) {
        this.VinData = ASIHMISyncCarServiceAbstractBaseService.copyString(string);
        this.VinData_valid = bl;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVinData(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVinDataVisibilityState(int n) {
        this.updateVinDataVisibilityState(n, true);
    }

    public void updateVinDataVisibilityState(int n, boolean bl) {
        this.VinDataVisibilityState = n;
        this.VinDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVinDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateKeyData(int[] nArray) {
        this.updateKeyData(nArray, true);
    }

    public void updateKeyData(int[] nArray, boolean bl) {
        if (nArray != null) {
            this.KeyData = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.KeyData, 0, nArray.length);
        } else {
            this.KeyData = null;
        }
        this.KeyData_valid = bl;
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateKeyData(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateKeyDataVisibilityState(int n) {
        this.updateKeyDataVisibilityState(n, true);
    }

    public void updateKeyDataVisibilityState(int n, boolean bl) {
        this.KeyDataVisibilityState = n;
        this.KeyDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateKeyDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTireDisplayData(TireDisplayData tireDisplayData) {
        this.updateTireDisplayData(tireDisplayData, true);
    }

    public void updateTireDisplayData(TireDisplayData tireDisplayData, boolean bl) {
        this.TireDisplayData = ASIHMISyncCarServiceAbstractBaseService.copyTireDisplayData(tireDisplayData);
        this.TireDisplayData_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateTireDisplayData(tireDisplayData, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTireDisplayDataVisibilityState(int n) {
        this.updateTireDisplayDataVisibilityState(n, true);
    }

    public void updateTireDisplayDataVisibilityState(int n, boolean bl) {
        this.TireDisplayDataVisibilityState = n;
        this.TireDisplayDataVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateTireDisplayDataVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTireSystem(int n) {
        this.updateTireSystem(n, true);
    }

    public void updateTireSystem(int n, boolean bl) {
        this.TireSystem = n;
        this.TireSystem_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateTireSystem(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVehicleSpeedVisibility(int n) {
        this.updateVehicleSpeedVisibility(n, true);
    }

    public void updateVehicleSpeedVisibility(int n, boolean bl) {
        this.VehicleSpeedVisibility = n;
        this.VehicleSpeedVisibility_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVehicleSpeedVisibility(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVehicleSpeed(FloatBaseType floatBaseType) {
        this.updateVehicleSpeed(floatBaseType, true);
    }

    public void updateVehicleSpeed(FloatBaseType floatBaseType, boolean bl) {
        this.VehicleSpeed = ASIHMISyncCarServiceAbstractBaseService.copyFloatBaseType(floatBaseType);
        this.VehicleSpeed_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply = (ASIHMISyncCarServiceReply)iterator.next();
            try {
                aSIHMISyncCarServiceReply.updateVehicleSpeed(floatBaseType, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

