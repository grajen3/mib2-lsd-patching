/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model;

import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElement;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.lang.reflect.Field;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;

public class DisplayElements {
    public static final int DISPLAY_1;
    public static final int DISPLAY_2;
    private final int displayId;
    private final DCDisplayedAdditionalInfos displayedAdditionalInfos;
    private final DCAdditionalInfo additionalInfo1;
    private final DCAdditionalInfo additionalInfo2;
    private final IntObjectMap additionalInfoId2displayContentMap;
    private static final IntLongMap OBJECTID_2_ID;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCAdditionalInfo;

    public DisplayElements(int n, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2) {
        this.displayId = n;
        this.displayedAdditionalInfos = dCDisplayedAdditionalInfos;
        this.additionalInfo1 = dCAdditionalInfo;
        this.additionalInfo2 = dCAdditionalInfo2;
        this.additionalInfoId2displayContentMap = new IntObjectOptHashMap(2);
        if (dCDisplayedAdditionalInfos.isAdditionalInfo1()) {
            this.additionalInfoId2displayContentMap.put(1, DisplayElements.getDisplayContent(dCAdditionalInfo));
        }
        if (dCDisplayedAdditionalInfos.isAdditionalInfo2()) {
            this.additionalInfoId2displayContentMap.put(2, DisplayElements.getDisplayContent(dCAdditionalInfo2));
        }
    }

    public DisplayElements(int n, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2) {
        this(n, new DCDisplayedAdditionalInfos(true, false), dCAdditionalInfo, dCAdditionalInfo2);
    }

    public DisplayElements(ContentSelection contentSelection) {
        this.displayId = contentSelection.getDisplay();
        this.displayedAdditionalInfos = new DCDisplayedAdditionalInfos(contentSelection.getAdditionalInfo() == 1, contentSelection.getAdditionalInfo() == 2);
        this.additionalInfo1 = new DCAdditionalInfo();
        this.additionalInfo2 = new DCAdditionalInfo();
        Field[] fieldArray = (class$org$dsi$ifc$carkombi$DCAdditionalInfo == null ? (class$org$dsi$ifc$carkombi$DCAdditionalInfo = DisplayElements.class$("org.dsi.ifc.carkombi.DCAdditionalInfo")) : class$org$dsi$ifc$carkombi$DCAdditionalInfo).getFields();
        int n = contentSelection.getElementContent();
        if (n >= 0 && n <= fieldArray.length) {
            try {
                if (contentSelection.getAdditionalInfo() == 1) {
                    fieldArray[n].setBoolean(this.additionalInfo1, true);
                } else if (contentSelection.getAdditionalInfo() == 2) {
                    fieldArray[n].setBoolean(this.additionalInfo2, true);
                } else {
                    AppLogger.warn(this, new StringBuffer().append(".DisplayElements( selectedElement = ").append(contentSelection.toString()).append(" ), invalid screen area: ").append(contentSelection.getAdditionalInfo()).toString());
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        this.additionalInfoId2displayContentMap = new IntObjectOptHashMap(2);
        if (this.displayedAdditionalInfos.isAdditionalInfo1()) {
            this.additionalInfoId2displayContentMap.put(1, DisplayElements.getDisplayContent(this.additionalInfo1));
        }
        if (this.displayedAdditionalInfos.isAdditionalInfo2()) {
            this.additionalInfoId2displayContentMap.put(2, DisplayElements.getDisplayContent(this.additionalInfo2));
        }
    }

    public int getDisplayId() {
        return this.displayId;
    }

    public int[] getElementsObjectIds() {
        return this.getElementsObjectIds(this.getAdditionalInfoId());
    }

    public int[] getElementsObjectIds(int n) {
        IntBooleanMap intBooleanMap = (IntBooleanMap)this.additionalInfoId2displayContentMap.get(n);
        if (intBooleanMap == null) {
            AppLogger.error(this, new StringBuffer().append(".getElementsObjectIds( additionalInfoId = ").append(n).append(" ), invalid screen area detected.").toString());
        }
        return this.getAvailableElementsIds(intBooleanMap);
    }

    public static long getElementAslId(int n) {
        return OBJECTID_2_ID.get(n);
    }

    public static int[] getSupportedElementContentIds() {
        return OBJECTID_2_ID.keysToArray();
    }

    public DisplayElement[] getElements() {
        return this.getElements(this.getAdditionalInfoId());
    }

    public DisplayElement[] getElements(int n) {
        int[] nArray = this.getElementsObjectIds(n);
        DisplayElement[] displayElementArray = new DisplayElement[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            displayElementArray[i2] = new DisplayElement(DisplayElements.getElementAslId(nArray[i2]), this.getDisplayId(), this.displayedAdditionalInfos, nArray[i2]);
        }
        return displayElementArray;
    }

    public DCAdditionalInfo getAdditionalInfo1() {
        return this.additionalInfo1;
    }

    public DCAdditionalInfo getAdditionalInfo2() {
        return this.additionalInfo2;
    }

    public int getIndexOfElementContent(int n, int n2) {
        IntBooleanMap intBooleanMap = (IntBooleanMap)this.additionalInfoId2displayContentMap.get(n2);
        int[] nArray = this.getAvailableElementsIds(intBooleanMap);
        int n3 = -1;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            n3 = i2;
            break;
        }
        return n3;
    }

    public int getIndexOfElementContent(int n) {
        int n2 = this.displayedAdditionalInfos.isAdditionalInfo1() ? 1 : 2;
        return this.getIndexOfElementContent(n, n2);
    }

    public int getElementIdForIndex(int n) {
        int n2 = this.displayedAdditionalInfos.isAdditionalInfo1() ? 1 : 2;
        return this.getElementIdForIndex(n, n2);
    }

    public int getElementIdForIndex(int n, int n2) {
        IntBooleanMap intBooleanMap = (IntBooleanMap)this.additionalInfoId2displayContentMap.get(n2);
        int[] nArray = this.getAvailableElementsIds(intBooleanMap);
        if (n < 0 || n >= nArray.length) {
            return 0;
        }
        return nArray[n];
    }

    protected int[] getAvailableElementsIds(IntBooleanMap intBooleanMap) {
        if (intBooleanMap == null) {
            AppLogger.error(this, ".getAvailableElementsIds( displayXContentMap = null ), invalid argument");
            return new int[0];
        }
        IntArrayList intArrayList = new IntArrayList();
        IntIterator intIterator = intBooleanMap.keyIterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            if (!intBooleanMap.get(n)) continue;
            intArrayList.add(n);
        }
        return intArrayList.toArray(new int[intArrayList.size()]);
    }

    private static IntBooleanMap getDisplayContent(DCAdditionalInfo dCAdditionalInfo) {
        IntBooleanOptHashMap intBooleanOptHashMap = new IntBooleanOptHashMap(64);
        intBooleanOptHashMap.put(0, dCAdditionalInfo.isBlankLine());
        intBooleanOptHashMap.put(1, dCAdditionalInfo.isBoostPressure());
        intBooleanOptHashMap.put(2, dCAdditionalInfo.isOilPressure());
        intBooleanOptHashMap.put(3, dCAdditionalInfo.isOilTemperature());
        intBooleanOptHashMap.put(4, dCAdditionalInfo.isCoolantTemperature());
        intBooleanOptHashMap.put(5, dCAdditionalInfo.isFuelRange());
        intBooleanOptHashMap.put(6, dCAdditionalInfo.isDestinationArrivalTime());
        intBooleanOptHashMap.put(7, dCAdditionalInfo.isIntermediateArrivalTime());
        intBooleanOptHashMap.put(8, dCAdditionalInfo.isDestinationTripTime());
        intBooleanOptHashMap.put(9, dCAdditionalInfo.isIntermediateTripTime());
        intBooleanOptHashMap.put(10, dCAdditionalInfo.isCompass());
        intBooleanOptHashMap.put(11, dCAdditionalInfo.isGpsHeight());
        intBooleanOptHashMap.put(12, dCAdditionalInfo.isTime());
        intBooleanOptHashMap.put(13, dCAdditionalInfo.isDate());
        intBooleanOptHashMap.put(14, dCAdditionalInfo.isHybridBattery());
        intBooleanOptHashMap.put(15, dCAdditionalInfo.isStation());
        intBooleanOptHashMap.put(16, dCAdditionalInfo.isPhoneInfo());
        intBooleanOptHashMap.put(17, dCAdditionalInfo.isLateralAcceleration());
        intBooleanOptHashMap.put(18, dCAdditionalInfo.isAcceleration());
        intBooleanOptHashMap.put(19, dCAdditionalInfo.isDeceleration());
        intBooleanOptHashMap.put(20, dCAdditionalInfo.isElectricRange());
        intBooleanOptHashMap.put(21, dCAdditionalInfo.isBatteryStateOfCharge());
        intBooleanOptHashMap.put(22, dCAdditionalInfo.isChargingTimeLeft());
        intBooleanOptHashMap.put(23, dCAdditionalInfo.isBatteryTemperature());
        intBooleanOptHashMap.put(24, dCAdditionalInfo.isBatteryLevel());
        intBooleanOptHashMap.put(25, dCAdditionalInfo.isCoolant());
        intBooleanOptHashMap.put(26, dCAdditionalInfo.isBoostLevel());
        intBooleanOptHashMap.put(27, dCAdditionalInfo.isBatteryCoolant());
        intBooleanOptHashMap.put(28, dCAdditionalInfo.isBatteryBoost());
        intBooleanOptHashMap.put(29, dCAdditionalInfo.isBoostCoolant());
        intBooleanOptHashMap.put(30, dCAdditionalInfo.isVehicleVoltage());
        intBooleanOptHashMap.put(31, dCAdditionalInfo.isAverageConsumption());
        intBooleanOptHashMap.put(32, dCAdditionalInfo.isDistance());
        intBooleanOptHashMap.put(33, dCAdditionalInfo.isDrivingTime());
        intBooleanOptHashMap.put(34, dCAdditionalInfo.isCurrentConsumption());
        intBooleanOptHashMap.put(35, dCAdditionalInfo.isZeroEmission());
        intBooleanOptHashMap.put(36, dCAdditionalInfo.isDrivingProfile());
        intBooleanOptHashMap.put(37, dCAdditionalInfo.isSecondarySpeed());
        intBooleanOptHashMap.put(38, dCAdditionalInfo.isDigitalSpeed());
        intBooleanOptHashMap.put(39, dCAdditionalInfo.isEnergyFlow());
        intBooleanOptHashMap.put(40, dCAdditionalInfo.isACC());
        intBooleanOptHashMap.put(41, dCAdditionalInfo.isRouteGuidance());
        intBooleanOptHashMap.put(42, dCAdditionalInfo.isTrafficSignDetection());
        intBooleanOptHashMap.put(43, dCAdditionalInfo.isShiftUpIndication());
        intBooleanOptHashMap.put(44, dCAdditionalInfo.isPerformance());
        intBooleanOptHashMap.put(45, dCAdditionalInfo.isPredictiveEfficiencyAssistant());
        intBooleanOptHashMap.put(46, dCAdditionalInfo.isWildcard());
        intBooleanOptHashMap.put(47, dCAdditionalInfo.isSteeringAngle());
        intBooleanOptHashMap.put(48, dCAdditionalInfo.isSlope());
        intBooleanOptHashMap.put(49, dCAdditionalInfo.isConsumptionData());
        intBooleanOptHashMap.put(50, dCAdditionalInfo.isCombustorConsumption());
        intBooleanOptHashMap.put(51, dCAdditionalInfo.isConsumptionData());
        intBooleanOptHashMap.put(52, dCAdditionalInfo.isAverageSpeed());
        intBooleanOptHashMap.put(53, dCAdditionalInfo.isPowermeter());
        intBooleanOptHashMap.put(54, dCAdditionalInfo.isTachometer());
        intBooleanOptHashMap.put(55, dCAdditionalInfo.isPowermeterAndTachometer());
        intBooleanOptHashMap.put(56, dCAdditionalInfo.isHybrid());
        intBooleanOptHashMap.put(57, dCAdditionalInfo.isEngineData());
        intBooleanOptHashMap.put(58, dCAdditionalInfo.isShortTermData());
        intBooleanOptHashMap.put(59, dCAdditionalInfo.isLongTermData());
        intBooleanOptHashMap.put(60, dCAdditionalInfo.isGMeter());
        intBooleanOptHashMap.put(61, dCAdditionalInfo.isTyrePressureMonitor());
        return intBooleanOptHashMap;
    }

    private int getAdditionalInfoId() {
        int n = this.displayedAdditionalInfos.isAdditionalInfo1() ? 1 : (this.displayedAdditionalInfos.isAdditionalInfo2() ? 2 : 0);
        return n;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBJECTID_2_ID = new IntLongOptHashMap();
        OBJECTID_2_ID.put(0, 0L);
        OBJECTID_2_ID.put(1, 1L);
        OBJECTID_2_ID.put(5, 0);
        OBJECTID_2_ID.put(6, 0);
        OBJECTID_2_ID.put(10, 0);
        OBJECTID_2_ID.put(11, 0);
        OBJECTID_2_ID.put(15, 0);
        OBJECTID_2_ID.put(18, 0);
        OBJECTID_2_ID.put(31, 0);
        OBJECTID_2_ID.put(32, 0);
        OBJECTID_2_ID.put(33, 0);
        OBJECTID_2_ID.put(35, 0);
        OBJECTID_2_ID.put(38, 0);
        OBJECTID_2_ID.put(39, 0);
        OBJECTID_2_ID.put(40, 0);
        OBJECTID_2_ID.put(41, 0);
        OBJECTID_2_ID.put(42, 0);
        OBJECTID_2_ID.put(43, 0);
        OBJECTID_2_ID.put(44, 0);
        OBJECTID_2_ID.put(46, 0);
        OBJECTID_2_ID.put(47, 0);
        OBJECTID_2_ID.put(48, 0);
    }
}

