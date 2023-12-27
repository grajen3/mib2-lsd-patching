/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.std2;

import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class AdaptationImpl
extends AccessImpl
implements Adaptation {
    public AdaptationImpl(byte[] byArray) {
        super(byArray, new int[]{50}, -536825343, 0);
        this.mConfiguration = new int[]{20051, 8, 1, 0, 0, -1, 10037, 1, 2, 0, 0, -1, 10037, 1, 2, 1, 0, -1, 2029, 3, 0, 1, 255, 1, 18, 20051, 8, 6, 0, 1, 23, 10037, 1, 7, 0, 0, -1, 1091, 0, 8, 1, 37, 20051, 8, 9, 0, 2, 40, 1091, 0, 3, 1, 48, 20051, 8, 10, 0, 2, 51, 10037, 1, 11, 0, 0, -1, 10037, 1, 12, 0, 0, -1, 1091, 0, 9, 1, 71, 20051, 7, 12, 1, 0, 74, 20051, 8, 13, 0, 3, -1, 20051, 8, 14, 0, 0, 51, 10037, 1, 15, 0, 0, -1, 10037, 1, 15, 1, 0, -1, 10037, 1, 15, 2, 0, -1, 10037, 1, 15, 3, 0, -1, 10037, 1, 15, 4, 0, -1, 10037, 1, 15, 5, 0, -1, 10037, 1, 15, 6, 0, -1, 2029, 2, 0, 1, 1, 136, 20051, 8, 16, 0, 0, 140, 20051, 16, 17, 0, 0, -1, 10037, 1, 19, 0, 0, -1, 10037, 1, 19, 1, 0, -1, 10037, 1, 19, 2, 0, -1, 10037, 1, 19, 3, 0, -1, 10037, 1, 19, 4, 0, -1, 10037, 1, 19, 5, 0, -1, 10037, 1, 19, 6, 0, -1, 10037, 1, 19, 7, 0, -1, 10037, 1, 20, 0, 0, -1, 10037, 1, 20, 1, 0, -1, 10037, 1, 20, 2, 0, -1, 10037, 1, 20, 3, 0, -1, 10037, 1, 20, 4, 0, -1, 10037, 1, 20, 5, 0, -1, 10037, 1, 20, 6, 0, -1, 10037, 1, 20, 7, 0, -1, 10037, 1, 21, 0, 0, -1, 10037, 1, 21, 1, 0, -1, 1091, 0, 2, 1, 262, 20051, 2, 21, 2, 0, 265, 20051, 2, 21, 4, 0, 265, 10037, 1, 21, 7, 0, -1, 10037, 1, 22, 0, 0, -1, 10037, 1, 22, 1, 0, -1, 10037, 1, 22, 2, 0, -1, 10037, 1, 22, 3, 0, -1, 20051, 1, 22, 4, 0, 140, 20051, 8, 23, 0, 0, 140, 20051, 8, 24, 0, 0, 140, 20051, 1, 25, 0, 0, 140, 20051, 8, 26, 0, 0, -1, 813183556, 30029, 16, 27, 0, 339, -1, 20051, 2, 29, 0, 0, 140, 20051, 2, 30, 0, 0, 140, 20051, 2, 31, 0, 0, 140, 20051, 2, 32, 0, 0, 140, 30029, 16, 33, 0, 339, -1, 1091, 0, 21, 1, 376, 20051, 8, 35, 0, 10, 379, 10037, 1, 36, 0, 0, -1, 10037, 1, 36, 1, 0, -1, 10037, 1, 36, 2, 0, 140, 10037, 1, 36, 3, 0, 140, 10037, 1, 36, 4, 0, 140, 10037, 1, 36, 5, 0, 140, 10037, 1, 36, 6, 0, 140, 10037, 1, 36, 7, 0, 140, 20051, 2, 37, 0, 0, 51, 10037, 1, 37, 2, 0, 140, 10037, 1, 37, 3, 0, 140, 10037, 1, 37, 4, 0, 140, 10037, 1, 37, 5, 0, 140, 10037, 1, 37, 6, 0, 140, 10037, 1, 37, 7, 0, 140, 10037, 1, 38, 0, 0, 140, 10037, 1, 38, 1, 0, 140, 20051, 2, 38, 2, 0, 265, 20051, 2, 38, 4, 0, 265, 10037, 1, 38, 6, 0, 140, 10037, 1, 38, 7, 0, 140, 813183024, 30029, 32, 39, 0, 513, -1, 166, 145, 238, 1141, 381, 125, 100, 146, 244, 1142, 387, 186, 447, 126, 106, 147, 250, 1143, 393, 187, 453, 127, 112, 148, 256, 1144, 429, 188, 459, 128, 118, 149, 267, 1145, 465, 1180, 495, 129, 142, 150, 273, 1146, 471, 1238, 507, 130, 148, 151, 285, 1147, 477, 1217, 514, 131, 154, 152, 291, 1148, 483, 1169, 489, 132, 160, 153, 297, 1170, 124, 112, 0, 133, 166, 154, 303, 1171, 130, 113, 6, 134, 172, 155, 309, 128, 128, 114, 12, 135, 178, 156, 315, 128, 128, 1194, 501, 136, 184, 157, 321, 128, 128, 116, 25, 137, 190, 158, 327, 179, 399, 117, 31, 138, 196, 159, 333, 180, 405, 118, 42, 139, 202, 160, 340, 181, 411, 119, 53, 140, 208, 161, 346, 182, 417, 120, 59, 141, 214, 162, 352, 183, 423, 121, 65, 142, 220, 163, 358, 184, 435, 122, 82, 143, 226, 164, 364, 185, 441, 123, 88, 144, 232, 1140, 279, 165, 370, 124, 94, 1224, 76, 520};
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
        return false;
    }

    @Override
    public boolean isAccessPointNameEntryDeactivated(int n) {
        return false;
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
        return false;
    }

    @Override
    public boolean isCallCenterFunctionVisible(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapCompressionModeH264(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapCompressionModeRle(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapMostTransmissionModeMostHigh(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapMostTransmissionModeMostStreaming(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapMostTransmissionModeOff(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapResolutionResolution1(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapResolutionResolution2(int n) {
        return false;
    }

    @Override
    public boolean isCrossroadDetailMapResolutionResolution3(int n) {
        return false;
    }

    @Override
    public boolean isEmergencyCallPrivateModeActivated(int n) {
        return false;
    }

    @Override
    public boolean isEmergencyCallPrivateModeDeactivated(int n) {
        return false;
    }

    @Override
    public boolean isEmergencyCallPrivateModeUserDefined(int n) {
        return false;
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
        return false;
    }

    @Override
    public boolean isNavigationMapCompressionModeRle(int n) {
        return false;
    }

    @Override
    public boolean isNavigationMapMostTransmissionModeMostHigh(int n) {
        return false;
    }

    @Override
    public boolean isNavigationMapMostTransmissionModeMostStreaming(int n) {
        return false;
    }

    @Override
    public boolean isNavigationMapMostTransmissionModeOff(int n) {
        return false;
    }

    @Override
    public boolean isNavigationMapResolutionResolution1(int n) {
        return false;
    }

    @Override
    public boolean isNavigationMapResolutionResolution2(int n) {
        return false;
    }

    @Override
    public boolean isNavigationMapResolutionResolution3(int n) {
        return false;
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
        return n == 1;
    }

    @Override
    public boolean isPsdProtocolVersionPsd15(int n) {
        return n == 0;
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
        return false;
    }

    @Override
    public boolean isTelephoneDeactivationDataOnly(int n) {
        return false;
    }

    @Override
    public boolean isTelephoneDeactivationNotActivated(int n) {
        return false;
    }

    @Override
    public boolean isTelephoneDeactivationNotAvailable(int n) {
        return false;
    }

    @Override
    public boolean isTelephoneDeactivationVoiceOnly(int n) {
        return false;
    }

    @Override
    public boolean isTpegAvailabilityOff(int n) {
        return false;
    }

    @Override
    public boolean isTpegAvailabilityOn(int n) {
        return false;
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

