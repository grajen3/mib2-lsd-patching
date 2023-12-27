/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.widgets.car.ops.OPSConfigData;
import de.vw.mib.widgets.models.OPSModel;

final class OPSUI$OPSUIHelper {
    static final int SENSOR_GROUP_AVAILABILITY_TYPE_OK;
    static final int SENSOR_GROUP_AVAILABILITY_TYPE_ERROR;
    static final int SENSOR_GROUP_AVAILABILITY_TYPE_ICEMUD;

    static int getColoredSensorFailureAlpha(int[] nArray, int n) {
        int n2 = 255;
        if (nArray != null && n >= 0 && n < nArray.length) {
            n2 = nArray[n];
        }
        return n2;
    }

    static short[] getDataSet(OPSConfigData oPSConfigData, int n, int n2) {
        n = OPSUI$OPSUIHelper.mapSensorToConfigSectorId(n);
        return oPSConfigData.getSegmentDataByDistance(n, n2);
    }

    static short[] getDataSetCameraBased(OPSConfigData oPSConfigData, int n, int n2, boolean bl) {
        short s;
        short[] sArray;
        int n3 = OPSUI$OPSUIHelper.mapSensorCameraBasedToSensor(n);
        int n4 = OPSUI$OPSUIHelper.mapSensorToConfigSectorId(n3);
        if (bl) {
            switch (n4) {
                case 1: {
                    n4 = 20;
                    break;
                }
                case 6: {
                    n4 = 21;
                    break;
                }
            }
        }
        if ((sArray = oPSConfigData.getSegmentDataWithHighestDistance(n4)) != null && (s = sArray[2]) < n2) {
            int n5 = OPSUI$OPSUIHelper.mapSensorToConfigSectorIdCameraBased(n);
            return oPSConfigData.getSegmentDataByDistanceRange(n5, s, n2);
        }
        return null;
    }

    static short[] getDataSetFrontTrafficAlert(OPSConfigData oPSConfigData, int n) {
        n = OPSUI$OPSUIHelper.mapSensorToConfigSectorIdFrontTrafficAlert(n);
        return oPSConfigData.getSegmentDataByDistance(n, 0);
    }

    static short[] getDataSetRearTrafficAlert(OPSConfigData oPSConfigData, int n) {
        n = OPSUI$OPSUIHelper.mapSensorToConfigSectorIdRearTrafficAlert(n);
        return oPSConfigData.getSegmentDataByDistance(n, 0);
    }

    static int getScaleValueX(OPSModel oPSModel, OPSConfigData oPSConfigData) {
        if (oPSModel.is_showRearOnly()) {
            if (!oPSModel.is_showOPSMini()) {
                return -1;
            }
            return 1;
        }
        return 1;
    }

    static int getScaleValueY(OPSModel oPSModel, OPSConfigData oPSConfigData) {
        if (oPSModel.is_showRearOnly()) {
            if (!oPSModel.is_showOPSMini()) {
                return 1;
            }
            return -1;
        }
        return -1;
    }

    static Color getSensorStateColor(Color[] colorArray, int n) {
        Color color = Color.WHITE;
        if (colorArray != null && n >= 0 && n < colorArray.length) {
            color = colorArray[n];
        }
        return color;
    }

    static int getSensorStateValue(int[] nArray, int n) {
        int n2 = -1;
        if (OPSUI$OPSUIHelper.isLogicalSensor(n)) {
            n = OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n);
        }
        if (nArray != null && n >= 0 && n < nArray.length) {
            n2 = nArray[n];
        }
        return n2;
    }

    static int getSensorSegmentValue(int[] nArray, int n) {
        int n2 = -129;
        if (OPSUI$OPSUIHelper.isLogicalSensor(n)) {
            n = OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n);
        }
        if (nArray != null && n >= 0 && n < nArray.length) {
            n2 = nArray[n];
        }
        return n2;
    }

    static int getTranslationValueX(OPSModel oPSModel, OPSConfigData oPSConfigData) {
        if (oPSModel.is_showRearOnly() && !oPSModel.is_showOPSMini()) {
            return 2 * oPSConfigData.getMirrorValue(2) + oPSConfigData.getMirrorValue(3);
        }
        return 0;
    }

    static int getTranslationValueY(OPSModel oPSModel, OPSConfigData oPSConfigData) {
        if (oPSModel.is_showRearOnly() && !oPSModel.is_showOPSMini()) {
            return 0;
        }
        return 2 * oPSConfigData.getMirrorValue(0) + oPSConfigData.getMirrorValue(1);
    }

    static boolean isBackgroundAvailable(OPSModel oPSModel, int n) {
        int n2 = OPSUI$OPSUIHelper.mapBackgroundToSensor(n);
        boolean bl = false;
        if (-1 == n2) {
            return bl;
        }
        int[] nArray = oPSModel.get_sensorStateValues();
        if (n2 >= 0 && n2 < nArray.length) {
            int n3 = nArray[n2];
            block0 : switch (n3) {
                case 12: 
                case 13: {
                    switch (OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, OPSUI$OPSUIHelper.mapSensorToSensorGroup(n2))) {
                        case 1: 
                        case 2: {
                            bl = true;
                            break block0;
                        }
                    }
                    bl = false;
                    break;
                }
                case 14: {
                    switch (OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, OPSUI$OPSUIHelper.mapSensorToSensorGroup(n2))) {
                        case 1: {
                            bl = true;
                            break block0;
                        }
                    }
                    bl = false;
                    break;
                }
                default: {
                    bl = true;
                }
            }
        }
        return bl;
    }

    static boolean isBackgroundTrafficAlertAvailable(OPSModel oPSModel, int n) {
        switch (n) {
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 133: 
            case 134: 
            case 235: 
            case 236: {
                return OPSUI$OPSUIHelper.isBackgroundFTAAvailable(oPSModel, n);
            }
            case 17: 
            case 18: 
            case 28: 
            case 31: 
            case 32: 
            case 117: 
            case 118: 
            case 128: 
            case 231: 
            case 232: {
                return OPSUI$OPSUIHelper.isBackgroundRTAAvailable(oPSModel, n);
            }
        }
        return false;
    }

    static boolean isBackgroundFTAAvailable(OPSModel oPSModel, int n) {
        return !OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapBackgroundTrafficAlertToSensor(n), oPSModel.get_ftaStates(), 0);
    }

    static boolean isBackgroundRTAAvailable(OPSModel oPSModel, int n) {
        return !OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapBackgroundTrafficAlertToSensor(n), oPSModel.get_rtaStates(), 0);
    }

    static boolean isLogicalSensor(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return false;
            }
        }
        return true;
    }

    static boolean isOverlayAvailable(OPSModel oPSModel, int n) {
        switch (n) {
            case 35: 
            case 36: 
            case 235: 
            case 236: {
                return OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapOverlayToSensor(n), oPSModel.get_ftaStates(), 2) || OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapOverlayToSensor(n), oPSModel.get_ftaStates(), 3);
            }
            case 31: 
            case 32: 
            case 231: 
            case 232: {
                return OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapOverlayToSensor(n), oPSModel.get_rtaStates(), 2) || OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapOverlayToSensor(n), oPSModel.get_rtaStates(), 3);
            }
        }
        return false;
    }

    static boolean isRightSideBackground(int n) {
        switch (n) {
            case 105: 
            case 106: 
            case 107: 
            case 108: 
            case 109: 
            case 110: 
            case 111: 
            case 112: 
            case 113: 
            case 114: 
            case 115: 
            case 116: 
            case 117: 
            case 118: 
            case 126: 
            case 127: 
            case 128: 
            case 133: 
            case 134: 
            case 231: 
            case 232: 
            case 235: 
            case 236: {
                return true;
            }
        }
        return false;
    }

    static boolean isRightSideSensor(int n) {
        switch (n) {
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 114: 
            case 115: 
            case 209: 
            case 214: {
                return true;
            }
        }
        return false;
    }

    static boolean isRightSideSensorCameraBased(int n) {
        switch (n) {
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 309: 
            case 314: {
                return true;
            }
        }
        return false;
    }

    static boolean isRightSideSensorTrafficAlert(int n) {
        switch (n) {
            case 1: 
            case 401: 
            case 501: 
            case 601: {
                return true;
            }
        }
        return false;
    }

    static boolean isRimProtectionAvailable(OPSModel oPSModel, int n) {
        switch (n) {
            case 39: 
            case 40: 
            case 41: 
            case 42: {
                return OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapRimProtectionToSensor(n), oPSModel.get_rimProtectionStates(), 1) || OPSUI$OPSUIHelper.isSenorStateEqual(OPSUI$OPSUIHelper.mapRimProtectionToSensor(n), oPSModel.get_rimProtectionStates(), 2);
            }
        }
        return false;
    }

    static int isSensorGroupAvailable(OPSModel oPSModel, int n) {
        boolean bl = oPSModel.is_showTrailer();
        int[] nArray = oPSModel.get_sensorStateValues();
        if (nArray.length > 0 && nArray.length >= 16) {
            switch (n) {
                case 0: {
                    if (nArray[1] == 15 || nArray[0] == 15 || nArray[8] == 15 || nArray[9] == 15) {
                        return 1;
                    }
                    if (nArray[1] == 13 || nArray[0] == 13 || nArray[8] == 13 || nArray[9] == 13) {
                        return 2;
                    }
                    if (nArray[1] != 12 && nArray[0] != 12 && nArray[8] != 12 && nArray[9] != 12) break;
                    return 2;
                }
                case 1: {
                    if (nArray[2] == 15 || nArray[3] == 15 || nArray[4] == 15 || nArray[5] == 15) {
                        return 1;
                    }
                    if (nArray[2] == 13 || nArray[3] == 13 || nArray[4] == 13 || nArray[5] == 13) {
                        return 2;
                    }
                    if (nArray[2] != 12 && nArray[3] != 12 && nArray[4] != 12 && nArray[5] != 12) break;
                    return 2;
                }
                case 2: {
                    if (nArray[10] == 15 || nArray[11] == 15 || nArray[12] == 15 || nArray[13] == 15) {
                        return 1;
                    }
                    if (nArray[10] == 13 || nArray[11] == 13 || nArray[12] == 13 || nArray[13] == 13) {
                        return 2;
                    }
                    if (nArray[10] != 12 && nArray[11] != 12 && nArray[12] != 12 && nArray[13] != 12) break;
                    return 2;
                }
                case 3: {
                    if (bl) break;
                    if (nArray[6] == 15 || nArray[7] == 15 || nArray[15] == 15 || nArray[14] == 15) {
                        return 1;
                    }
                    if (nArray[6] == 13 || nArray[7] == 13 || nArray[15] == 13 || nArray[14] == 13) {
                        return 2;
                    }
                    if (nArray[6] != 12 && nArray[7] != 12 && nArray[15] != 12 && nArray[14] != 12) break;
                    return 2;
                }
                default: {
                    throw new IllegalArgumentException("Unknown sensor group id passed!");
                }
            }
        }
        return 0;
    }

    static boolean isSensorGroupAvailableBySensor(OPSModel oPSModel, int n) {
        switch (OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, OPSUI$OPSUIHelper.mapSensorToSensorGroup(n))) {
            case 1: 
            case 2: {
                return false;
            }
        }
        return true;
    }

    static boolean isSenorStateEqual(int n, int[] nArray, int n2) {
        boolean bl = false;
        if (-1 == n) {
            return bl;
        }
        if (n >= 0 && n < nArray.length) {
            return nArray[n] == n2;
        }
        return bl;
    }

    static int mapBackgroundToSensor(int n) {
        int n2 = -1;
        switch (n) {
            case 5: 
            case 26: {
                n2 = 0;
                break;
            }
            case 6: 
            case 15: {
                n2 = 1;
                break;
            }
            case 105: 
            case 126: {
                n2 = 8;
                break;
            }
            case 106: 
            case 115: {
                n2 = 9;
                break;
            }
            case 7: {
                n2 = 2;
                break;
            }
            case 8: {
                n2 = 3;
                break;
            }
            case 9: {
                n2 = 4;
                break;
            }
            case 10: {
                n2 = 5;
                break;
            }
            case 107: {
                n2 = 10;
                break;
            }
            case 108: {
                n2 = 11;
                break;
            }
            case 109: {
                n2 = 12;
                break;
            }
            case 110: {
                n2 = 13;
                break;
            }
            case 12: 
            case 13: 
            case 27: {
                n2 = 7;
                break;
            }
            case 11: 
            case 14: 
            case 16: {
                n2 = 6;
                break;
            }
            case 112: 
            case 113: 
            case 127: {
                n2 = 15;
                break;
            }
            case 111: 
            case 114: 
            case 116: {
                n2 = 14;
                break;
            }
        }
        return n2;
    }

    static int mapBackgroundTrafficAlertToSensor(int n) {
        int n2 = -1;
        switch (n) {
            case 33: 
            case 34: 
            case 35: 
            case 36: {
                n2 = 0;
                break;
            }
            case 133: 
            case 134: 
            case 235: 
            case 236: {
                n2 = 1;
                break;
            }
            case 17: 
            case 18: 
            case 28: 
            case 31: 
            case 32: {
                n2 = 0;
                break;
            }
            case 117: 
            case 118: 
            case 128: 
            case 231: 
            case 232: {
                n2 = 1;
                break;
            }
        }
        return n2;
    }

    static int mapLogicalSensorToRealSensor(int n) {
        int n2 = n;
        switch (n) {
            case 106: {
                n2 = 6;
                break;
            }
            case 107: {
                n2 = 7;
                break;
            }
            case 115: {
                n2 = 15;
                break;
            }
            case 114: {
                n2 = 14;
                break;
            }
            case 201: 
            case 301: {
                n2 = 1;
                break;
            }
            case 206: 
            case 306: {
                n2 = 6;
                break;
            }
            case 209: 
            case 309: {
                n2 = 9;
                break;
            }
            case 214: 
            case 314: {
                n2 = 14;
                break;
            }
            case 500: {
                n2 = 0;
                break;
            }
            case 501: {
                n2 = 1;
                break;
            }
            case 400: 
            case 600: {
                n2 = 0;
                break;
            }
            case 401: 
            case 601: {
                n2 = 1;
                break;
            }
        }
        return n2;
    }

    static int mapOverlayToSensor(int n) {
        int n2 = -1;
        switch (n) {
            case 35: 
            case 36: {
                n2 = 0;
                break;
            }
            case 235: 
            case 236: {
                n2 = 1;
                break;
            }
            case 31: 
            case 32: {
                n2 = 0;
                break;
            }
            case 231: 
            case 232: {
                n2 = 1;
                break;
            }
        }
        return n2;
    }

    static int mapRightToLeftBackground(int n) {
        int n2 = n;
        switch (n) {
            case 105: {
                n2 = 5;
                break;
            }
            case 106: {
                n2 = 6;
                break;
            }
            case 107: {
                n2 = 7;
                break;
            }
            case 108: {
                n2 = 8;
                break;
            }
            case 109: {
                n2 = 9;
                break;
            }
            case 110: {
                n2 = 10;
                break;
            }
            case 111: {
                n2 = 11;
                break;
            }
            case 112: {
                n2 = 12;
                break;
            }
            case 114: {
                n2 = 14;
                break;
            }
            case 113: {
                n2 = 13;
                break;
            }
            case 115: {
                n2 = 15;
                break;
            }
            case 116: {
                n2 = 16;
                break;
            }
            case 126: {
                n2 = 26;
                break;
            }
            case 127: {
                n2 = 27;
                break;
            }
        }
        return n2;
    }

    static int mapRightToLeftBackgroundTrafficAlert(int n) {
        int n2 = n;
        switch (n) {
            case 133: {
                n2 = 33;
                break;
            }
            case 134: {
                n2 = 34;
                break;
            }
            case 117: {
                n2 = 17;
                break;
            }
            case 118: {
                n2 = 18;
                break;
            }
            case 128: {
                n2 = 28;
                break;
            }
            case 235: {
                n2 = 35;
                break;
            }
            case 236: {
                n2 = 36;
                break;
            }
            case 231: {
                n2 = 31;
                break;
            }
            case 232: {
                n2 = 32;
                break;
            }
        }
        return n2;
    }

    static int mapRightToLeftOverlay(int n) {
        int n2 = n;
        switch (n) {
            case 235: {
                n2 = 35;
                break;
            }
            case 236: {
                n2 = 36;
                break;
            }
            case 231: {
                n2 = 31;
                break;
            }
            case 232: {
                n2 = 32;
                break;
            }
        }
        return n2;
    }

    static int mapRightToLeftSensor(int n) {
        switch (n) {
            case 8: {
                return 0;
            }
            case 9: {
                return 1;
            }
            case 10: {
                return 2;
            }
            case 11: {
                return 3;
            }
            case 12: {
                return 4;
            }
            case 13: {
                return 5;
            }
            case 14: {
                return 6;
            }
            case 15: {
                return 7;
            }
        }
        return n;
    }

    static int mapRimProtectionToSensor(int n) {
        int n2 = -1;
        switch (n) {
            case 39: {
                n2 = 0;
                break;
            }
            case 40: {
                n2 = 1;
                break;
            }
            case 41: {
                n2 = 2;
                break;
            }
            case 42: {
                n2 = 3;
                break;
            }
        }
        return n2;
    }

    static int mapSensorCameraBasedToSensor(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 8: {
                return 8;
            }
            case 1: {
                return 1;
            }
            case 9: {
                return 9;
            }
            case 2: {
                return 2;
            }
            case 10: {
                return 10;
            }
            case 3: {
                return 3;
            }
            case 11: {
                return 11;
            }
            case 4: {
                return 4;
            }
            case 12: {
                return 12;
            }
            case 5: {
                return 5;
            }
            case 13: {
                return 13;
            }
            case 6: {
                return 6;
            }
            case 14: {
                return 14;
            }
            case 7: {
                return 7;
            }
            case 15: {
                return 15;
            }
            case 301: {
                return 1;
            }
            case 309: {
                return 9;
            }
            case 306: {
                return 6;
            }
            case 314: {
                return 14;
            }
        }
        return n;
    }

    static int mapSensorToSensorGroup(int n) {
        if (OPSUI$OPSUIHelper.isLogicalSensor(n)) {
            n = OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n);
        }
        switch (n) {
            case 0: 
            case 1: 
            case 8: 
            case 9: {
                return 0;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return 1;
            }
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                return 2;
            }
            case 6: 
            case 7: 
            case 14: 
            case 15: {
                return 3;
            }
        }
        return -1;
    }

    static int mapSensorToConfigSectorId(int n) {
        switch (n) {
            case 0: 
            case 8: {
                n = 0;
                break;
            }
            case 1: 
            case 9: {
                n = 1;
                break;
            }
            case 2: 
            case 10: {
                n = 2;
                break;
            }
            case 3: 
            case 11: {
                n = 3;
                break;
            }
            case 4: 
            case 12: {
                n = 4;
                break;
            }
            case 5: 
            case 13: {
                n = 5;
                break;
            }
            case 6: 
            case 14: {
                n = 6;
                break;
            }
            case 7: 
            case 15: {
                n = 7;
                break;
            }
            case 106: 
            case 114: {
                n = 16;
                break;
            }
            case 107: 
            case 115: {
                n = 17;
                break;
            }
            case 201: 
            case 209: {
                n = 20;
                break;
            }
            case 206: 
            case 214: {
                n = 21;
                break;
            }
        }
        return n;
    }

    static int mapSensorToConfigSectorIdCameraBased(int n) {
        switch (n) {
            case 0: 
            case 8: {
                n = 28;
                break;
            }
            case 1: 
            case 9: {
                n = 29;
                break;
            }
            case 2: 
            case 10: {
                n = 30;
                break;
            }
            case 3: 
            case 11: {
                n = 31;
                break;
            }
            case 4: 
            case 12: {
                n = 32;
                break;
            }
            case 5: 
            case 13: {
                n = 33;
                break;
            }
            case 6: 
            case 14: {
                n = 34;
                break;
            }
            case 7: 
            case 15: {
                n = 35;
                break;
            }
            case 301: 
            case 309: {
                n = 44;
                break;
            }
            case 306: 
            case 314: {
                n = 45;
                break;
            }
        }
        return n;
    }

    static int mapSensorToConfigSectorIdFrontTrafficAlert(int n) {
        switch (n) {
            case 0: 
            case 1: {
                n = 50;
                break;
            }
            case 500: 
            case 501: {
                n = 52;
                break;
            }
        }
        return n;
    }

    static int mapSensorToConfigSectorIdRearTrafficAlert(int n) {
        switch (n) {
            case 0: 
            case 1: {
                n = 24;
                break;
            }
            case 600: 
            case 601: {
                n = 26;
                break;
            }
            case 400: 
            case 401: {
                n = 48;
                break;
            }
        }
        return n;
    }

    private OPSUI$OPSUIHelper() {
    }
}

