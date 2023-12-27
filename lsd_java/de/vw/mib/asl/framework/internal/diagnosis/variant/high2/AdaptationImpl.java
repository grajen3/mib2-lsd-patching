/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.high2;

import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class AdaptationImpl
extends AccessImpl
implements Adaptation {
    public AdaptationImpl(byte[] byArray) {
        super(byArray, new int[]{50, 90}, -536825343, 0);
        this.mConfiguration = new int[]{2029, 2, 0, 1, 1, 0, 10037, 1, 0, 0, 1, 4, 20051, 8, 1, 0, 0, -1, 10037, 1, 2, 0, 0, -1, 10037, 1, 2, 1, 0, -1, 2029, 3, 0, 1, 255, 1, 30, 20051, 8, 6, 0, 1, 35, 10037, 1, 7, 0, 0, -1, 1091, 0, 8, 1, 49, 20051, 8, 9, 0, 2, 52, 1091, 0, 3, 1, 60, 20051, 8, 10, 0, 2, 63, 10037, 1, 11, 0, 0, -1, 10037, 1, 12, 0, 0, -1, 20051, 8, 13, 0, 3, -1, 20051, 8, 14, 0, 0, 63, 2029, 1, 255, 2, 60, 95, 20051, 8, 15, 0, 0, 98, 20051, 8, 16, 0, 0, 4, 10037, 1, 17, 0, 0, -1, 10037, 1, 17, 1, 0, -1, 10037, 1, 17, 2, 0, -1, 10037, 1, 17, 3, 0, -1, 10037, 1, 17, 4, 0, -1, 10037, 1, 17, 5, 0, -1, 10037, 1, 17, 6, 0, -1, 10037, 1, 17, 7, 0, -1, 10037, 1, 18, 0, 0, -1, 10037, 1, 18, 1, 0, -1, 10037, 1, 18, 2, 0, -1, 10037, 1, 18, 3, 0, -1, 10037, 1, 18, 4, 0, -1, 10037, 1, 18, 5, 0, -1, 10037, 1, 18, 6, 0, -1, 10037, 1, 18, 7, 0, -1, 10037, 1, 19, 0, 0, -1, 10037, 1, 19, 1, 0, -1, 1091, 0, 2, 1, 221, 20051, 2, 19, 2, 0, 224, 20051, 2, 19, 4, 0, 224, 20051, 1, 19, 6, 0, 4, 20051, 1, 19, 7, 0, 4, 20051, 16, 20, 0, 0, -1, 20051, 8, 22, 0, 255, 35, 10037, 1, 23, 0, 0, -1, 10037, 1, 23, 1, 0, -1, 10037, 1, 23, 2, 0, -1, 10037, 1, 23, 3, 0, -1, 20051, 1, 23, 4, 0, 4, 20051, 1, 24, 0, 0, 4, 20051, 1, 24, 1, 0, 4, 10037, 1, 24, 2, 0, 4, 10037, 1, 24, 3, 0, 4, 10037, 1, 24, 4, 0, 4, 20051, 8, 25, 0, 0, 4, 20051, 1, 26, 0, 0, 4, 20051, 8, 27, 0, 0, -1, 813183556, 30029, 16, 28, 0, 340, -1, 20051, 2, 30, 0, 0, 4, 20051, 2, 31, 0, 0, 4, 20051, 2, 32, 0, 0, 4, 20051, 2, 33, 0, 0, 4, 20051, 8, 34, 0, 0, 224, 20051, 8, 35, 0, 0, 4, 20051, 8, 36, 0, 0, 224, 20051, 8, 37, 0, 0, 224, 20051, 8, 38, 0, 0, 4, 20051, 8, 39, 0, 0, 224, 10037, 1, 40, 0, 0, -1, 10037, 1, 40, 1, 0, -1, 10037, 1, 40, 2, 0, -1, 10037, 1, 40, 3, 0, 4, 10037, 1, 41, 0, 0, 4, 10037, 1, 41, 1, 0, 4, 10037, 1, 41, 2, 0, 4, 10037, 1, 41, 3, 0, 4, 10037, 1, 41, 4, 0, 4, 10037, 1, 41, 5, 0, 4, 20051, 2, 41, 6, 0, 63, 10037, 1, 42, 0, 0, 4, 10037, 1, 42, 1, 0, 4, 10037, 1, 42, 2, 0, 4, 10037, 1, 42, 3, 0, 4, 10037, 1, 42, 4, 0, 4, 10037, 1, 42, 5, 0, 4, 10037, 1, 42, 6, 0, 4, 10037, 1, 42, 7, 0, 4, 10037, 1, 43, 0, 0, 4, 10037, 1, 43, 1, 0, 4, 10037, 1, 43, 2, 0, 4, 10037, 1, 43, 3, 0, 4, 10037, 1, 43, 4, 0, 4, 10037, 1, 43, 5, 0, 4, 10037, 1, 43, 6, 0, 4, 10037, 1, 43, 7, 0, -1, 30029, 16, 44, 0, 340, -1, 10037, 1, 46, 0, 1, 4, 10037, 1, 46, 1, 0, 4, 10037, 1, 46, 2, 0, 4, 10037, 1, 46, 3, 0, 4, 10037, 1, 46, 4, 0, 4, 10037, 1, 46, 5, 0, 4, 10037, 1, 46, 6, 0, 4, 10037, 1, 47, 0, 0, -1, 10037, 1, 47, 1, 0, -1, 10037, 1, 47, 2, 0, 4, 10037, 1, 47, 3, 0, 4, 10037, 1, 47, 4, 0, 4, 20051, 8, 48, 0, 0, -1, 10037, 1, 49, 0, 0, 4, 10037, 1, 49, 1, 0, 4, 20051, 8, 50, 0, 0, 224, 10037, 1, 51, 0, 0, -1, 10037, 1, 51, 1, 0, 4, 10037, 1, 51, 2, 0, -1, 10037, 1, 51, 3, 0, 4, 10037, 1, 51, 4, 0, -1, 20051, 2, 51, 5, 0, 224, 20051, 8, 52, 0, 255, -1, 1091, 0, 21, 1, 713, 20051, 8, 53, 0, 10, 716, 20051, 8, 55, 0, 0, -1, 10037, 1, 56, 2, 0, 4, 10037, 1, 56, 3, 0, 4, 10037, 1, 56, 4, 0, 4, 10037, 1, 56, 5, 0, 4, 10037, 1, 56, 6, 0, 4, 10037, 1, 56, 7, 0, 4, 10037, 1, 57, 0, 0, 4, 10037, 1, 57, 1, 0, 4, 20051, 6, 57, 2, 0, 4, 20051, 8, 58, 0, 9, -1, 20051, 8, 59, 0, 0, -1, 20051, 8, 60, 0, 0, -1, 20051, 8, 61, 0, 0, 224, 30029, 16, 62, 0, -1, -1, 20051, 8, 64, 0, 0, -1, 20051, 8, 65, 0, 0, -1, 10037, 1, 66, 0, 0, 4, 20051, 4, 66, 1, 0, 63, 20051, 3, 66, 5, 0, 224, 10037, 1, 67, 2, 0, 4, 10037, 1, 67, 3, 0, 4, 10037, 1, 67, 4, 0, 4, 10037, 1, 67, 6, 0, 4, 10037, 1, 67, 7, 0, 4, 10037, 1, 68, 0, 0, 4, 10037, 1, 70, 2, 0, 4, 30029, 72, 71, 0, -1, -1, 813183024, 30029, 32, 80, 0, 892, 4, 298, 149, 226, 112, 12, 857, 539, 187, 485, 150, 232, 113, 18, 858, 545, 188, 491, 151, 262, 114, 24, 970, 551, 189, 521, 152, 268, 1194, 557, 1231, 617, 1232, 623, 153, 274, 116, 37, 861, 238, 1233, 629, 154, 280, 117, 43, 862, 425, 859, 653, 155, 286, 118, 54, 860, 659, 863, 665, 1155, 683, 119, 65, 864, 677, 1160, 689, 157, 322, 120, 71, 971, 707, 156, 724, 158, 328, 121, 77, 1195, 730, 1196, 736, 159, 334, 122, 83, 1197, 742, 1198, 748, 160, 341, 123, 89, 1166, 304, 1199, 754, 161, 347, 1167, 310, 1200, 760, 1159, 784, 162, 353, 1168, 695, 1161, 790, 1162, 796, 163, 359, 1169, 701, 1221, 820, 1235, 826, 164, 365, 1236, 832, 1237, 838, 1222, 844, 165, 569, 1223, 856, 1229, 862, 1230, 868, 166, 101, 129, 107, 1238, 880, 1217, 893, 167, 256, 130, 250, 1173, 802, 128, 128, 168, 292, 131, 113, 128, 128, 128, 128, 169, 298, 132, 119, 128, 128, 128, 128, 170, 371, 133, 125, 128, 128, 1251, 874, 171, 377, 134, 131, 1140, 244, 1214, 850, 172, 383, 135, 137, 1141, 718, 1215, 808, 173, 389, 1179, 6, 136, 143, 1142, 563, 174, 395, 137, 149, 1143, 671, 1253, 886, 175, 401, 138, 155, 1144, 461, 1181, 766, 1219, 316, 139, 161, 176, 407, 1145, 497, 177, 413, 140, 167, 1146, 503, 847, 575, 178, 419, 141, 173, 1147, 509, 848, 581, 179, 431, 142, 179, 1148, 515, 849, 587, 180, 437, 143, 185, 850, 593, 851, 599, 181, 443, 144, 191, 852, 605, 1183, 772, 182, 449, 145, 197, 853, 611, 1182, 778, 183, 455, 146, 203, 1226, 635, 1220, 814, 184, 467, 147, 209, 855, 527, 1227, 641, 185, 473, 148, 215, 856, 533, 1228, 647, 186, 479, 899};
        this.mEngine = new Engine(this.mConfiguration);
    }

    @Override
    public boolean isPayTmcSetOnlineTrafficAvailable(int n) {
        switch (n) {
            case 32768: 
            case 32769: 
            case 32770: 
            case 32771: 
            case 32772: 
            case 32773: 
            case 32774: 
            case 32775: 
            case 32776: 
            case 32777: 
            case 32778: 
            case 32779: 
            case 32780: 
            case 32781: 
            case 32782: 
            case 32783: 
            case 32784: 
            case 32785: 
            case 32786: 
            case 32787: 
            case 32788: 
            case 32789: 
            case 32790: 
            case 33791: 
            case 33792: 
            case 33793: 
            case 34048: 
            case 34049: 
            case 34304: 
            case 34305: 
            case 34306: {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAccessPointNameEntryActivated(int n) {
        return n == 1;
    }

    @Override
    public boolean isAccessPointNameEntryDeactivated(int n) {
        return n == 0;
    }

    @Override
    public boolean isActivationForExternalUsb1Activate(int n) {
        return n == 1;
    }

    @Override
    public boolean isActivationForExternalUsb1Deactivate(int n) {
        return n == 0;
    }

    @Override
    public boolean isActivationForExternalUsb2Activate(int n) {
        return n == 1;
    }

    @Override
    public boolean isActivationForExternalUsb2Deactivate(int n) {
        return n == 0;
    }

    @Override
    public boolean isActivationForExternalUsb3Activate(int n) {
        return n == 1;
    }

    @Override
    public boolean isActivationForExternalUsb3Deactivate(int n) {
        return n == 0;
    }

    @Override
    public boolean isActivationForExternalUsb4Activate(int n) {
        return n == 1;
    }

    @Override
    public boolean isActivationForExternalUsb4Deactivate(int n) {
        return n == 0;
    }

    @Override
    public boolean isBluetoothDeactivationStateNotAvailable(int n) {
        return n == 255;
    }

    @Override
    public boolean isBluetoothDeactivationStateOff(int n) {
        return n == 0;
    }

    @Override
    public boolean isBluetoothDeactivationStateOn(int n) {
        return n == 1;
    }

    @Override
    public boolean isCallCenterFunctionNotVisible(int n) {
        return n == 0;
    }

    @Override
    public boolean isCallCenterFunctionVisible(int n) {
        return n == 1;
    }

    @Override
    public boolean isCrossroadDetailMapCompressionModeH264(int n) {
        return n == 1;
    }

    @Override
    public boolean isCrossroadDetailMapCompressionModeRle(int n) {
        return n == 0;
    }

    @Override
    public boolean isCrossroadDetailMapMostTransmissionModeMostHigh(int n) {
        return n == 1;
    }

    @Override
    public boolean isCrossroadDetailMapMostTransmissionModeMostStreaming(int n) {
        return n == 2;
    }

    @Override
    public boolean isCrossroadDetailMapMostTransmissionModeOff(int n) {
        return n == 0;
    }

    @Override
    public boolean isCrossroadDetailMapResolutionResolution1(int n) {
        return n == 0;
    }

    @Override
    public boolean isCrossroadDetailMapResolutionResolution2(int n) {
        return n == 1;
    }

    @Override
    public boolean isCrossroadDetailMapResolutionResolution3(int n) {
        return n == 2;
    }

    @Override
    public boolean isEmergencyCallPrivateModeActivated(int n) {
        return n == 1;
    }

    @Override
    public boolean isEmergencyCallPrivateModeDeactivated(int n) {
        return n == 0;
    }

    @Override
    public boolean isEmergencyCallPrivateModeUserDefined(int n) {
        return n == 255;
    }

    @Override
    public boolean isJokerButton1Left(int n) {
        return n == 1;
    }

    @Override
    public boolean isJokerButton1NotDetected(int n) {
        return n == 0;
    }

    @Override
    public boolean isJokerButton1Right(int n) {
        return n == 2;
    }

    @Override
    public boolean isJokerButton2Left(int n) {
        return n == 1;
    }

    @Override
    public boolean isJokerButton2NotDetected(int n) {
        return n == 0;
    }

    @Override
    public boolean isJokerButton2Right(int n) {
        return n == 2;
    }

    @Override
    public boolean isNavigationMapCompressionModeH264(int n) {
        return n == 1;
    }

    @Override
    public boolean isNavigationMapCompressionModeRle(int n) {
        return n == 0;
    }

    @Override
    public boolean isNavigationMapMostTransmissionModeMostHigh(int n) {
        return n == 1;
    }

    @Override
    public boolean isNavigationMapMostTransmissionModeMostStreaming(int n) {
        return n == 2;
    }

    @Override
    public boolean isNavigationMapMostTransmissionModeOff(int n) {
        return n == 0;
    }

    @Override
    public boolean isNavigationMapResolutionResolution1(int n) {
        return n == 0;
    }

    @Override
    public boolean isNavigationMapResolutionResolution2(int n) {
        return n == 1;
    }

    @Override
    public boolean isNavigationMapResolutionResolution3(int n) {
        return n == 2;
    }

    @Override
    public boolean isOnlineServicesHmiAvailabilityActivated(int n) {
        return n == 1;
    }

    @Override
    public boolean isOnlineServicesHmiAvailabilityDeactivated(int n) {
        return n == 0;
    }

    @Override
    public boolean isPsdProtocolVersionPsd14(int n) {
        return false;
    }

    @Override
    public boolean isPsdProtocolVersionPsd15(int n) {
        return false;
    }

    @Override
    public boolean isRvcVideoInputFbas(int n) {
        return n == 0;
    }

    @Override
    public boolean isRvcVideoInputLvds(int n) {
        return n == 1;
    }

    @Override
    public boolean isSummerTimeShiftMethodCet(int n) {
        return n == 2;
    }

    @Override
    public boolean isSummerTimeShiftMethodManual(int n) {
        return n == 1;
    }

    @Override
    public boolean isSummerTimeShiftMethodNone(int n) {
        return n == 0;
    }

    @Override
    public boolean isSummerTimeShiftMethodUsa(int n) {
        return n == 3;
    }

    @Override
    public boolean isTelephoneDeactivationActivated(int n) {
        return n == 1;
    }

    @Override
    public boolean isTelephoneDeactivationDataOnly(int n) {
        return n == 2;
    }

    @Override
    public boolean isTelephoneDeactivationNotActivated(int n) {
        return n == 0;
    }

    @Override
    public boolean isTelephoneDeactivationNotAvailable(int n) {
        return n == 255;
    }

    @Override
    public boolean isTelephoneDeactivationVoiceOnly(int n) {
        return n == 3;
    }

    @Override
    public boolean isTpegAvailabilityOff(int n) {
        return n == 0;
    }

    @Override
    public boolean isTpegAvailabilityOn(int n) {
        return n == 1;
    }

    @Override
    public boolean isWlanModulActivationActivated(int n) {
        return n == 1;
    }

    @Override
    public boolean isWlanModulActivationNotActivated(int n) {
        return n == 0;
    }
}

