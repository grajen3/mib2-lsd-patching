/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public interface DSICarDrivingCharacteristicsReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
    }

    default public void updateSuspensionControlLiftMode(boolean bl, int n) {
    }

    default public void updateSuspensionControlCarJackMode(boolean bl, int n) {
    }

    default public void updateSuspensionControlTrailerMode(boolean bl, int n) {
    }

    default public void updateSuspensionControlLoadingMode(boolean bl, int n) {
    }

    default public void updateSuspensionControlActiveProfile(int n, int n2) {
    }

    default public void updateSuspensionControlAccessibleAirProfiles(SuspensionControlAirProfiles suspensionControlAirProfiles, int n) {
    }

    default public void updateSuspensionControlAccessibleDRCProfiles(SuspensionControlDRCProfiles suspensionControlDRCProfiles, int n) {
    }

    default public void updateSuspensionControlVehicleStatus(int n, int n2) {
    }

    default public void updateSuspensionControlCurrentLevel(int n, int n2) {
    }

    default public void updateSuspensionControlTargetLevel(int n, int n2) {
    }

    default public void updateSuspensionControlHeightInfo(SuspensionControlHeightInfo suspensionControlHeightInfo, int n) {
    }

    default public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages suspensionControlOperationMessages, int n) {
    }

    default public void updateSuspensionControlSnowChainMode(boolean bl, int n) {
    }

    default public void updateSuspensionControlVehicleStateControl(boolean bl, int n) {
    }

    default public void updateSuspensionControlActiveMode(int n, boolean bl, int n2) {
    }

    default public void updateeABCEasyEntry(boolean bl, int n) {
    }

    default public void updateeABCPitchControl(boolean bl, int n) {
    }

    default public void updateeABCSpecialPosition(boolean bl, int n) {
    }

    default public void updateeABCPreview(int n, int n2) {
    }

    default public void updateeABCPreviewState(SuspensionControleABCPreview suspensionControleABCPreview, int n) {
    }

    default public void updateSuspensionControlActuatorInfo(SuspensionControlActuatorInfo suspensionControlActuatorInfo, int n) {
    }

    default public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
    }

    default public void updateCharismaActiveProfile(int n, int n2) {
    }

    default public void updateCharismaActiveOperationMode(int n, int n2) {
    }

    default public void updateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
    }

    default public void updateCharismaContent(int n, int n2) {
    }

    default public void updateCharismaTrailerDetection(boolean bl, int n) {
    }

    default public void updateCharismaTrailerSetting(boolean bl, int n) {
    }

    default public void updateCharismaProgButton(CharismaProgButton charismaProgButton, int n) {
    }

    default public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    default public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    default public void requestCharismaPopup(int n) {
    }

    default public void acknowledgeCharismaPopup(int n) {
    }

    default public void acknowledgeCharismaSetFactoryDefault(boolean bl) {
    }

    default public void updateCharismaSound(boolean bl, int n) {
    }

    default public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
    }

    default public void updateTADContent(int n, int n2) {
    }

    default public void requestTADPopup(int n) {
    }

    default public void acknowledgeTADPopup(int n) {
    }

    default public void acknowledgeTADSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeTADMaxMinAngleReset(boolean bl) {
    }

    default public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, int n) {
    }

    default public void updateTADCurrentRollAngle(float f2, int n) {
    }

    default public void updateTADCurrentPitchAngle(float f2, int n) {
    }

    default public void updateTADPosMaxRollAngle(float f2, int n) {
    }

    default public void updateTADNegMaxRollAngle(float f2, int n) {
    }

    default public void updateTADPosMaxPitchAngle(float f2, int n) {
    }

    default public void updateTADNegMaxPitchAngle(float f2, int n) {
    }

    default public void updateSpoilerViewOptions(SpoilerViewOptions spoilerViewOptions, int n) {
    }

    default public void updateSpoilerPositionSelection(int n, int n2) {
    }

    default public void updateSpoilerState(SpoilerState spoilerState, int n) {
    }

    default public void updateSpoilerActuation(boolean bl, int n) {
    }

    default public void updateSpoilerMessages(int n, int n2) {
    }

    default public void updateSpoilerSystemOnOff(boolean bl, int n) {
    }

    default public void acknowledgeSpoilerSetFactoryDefault(boolean bl) {
    }

    default public void updateSoundViewOptions(SoundViewOptions soundViewOptions, int n) {
    }

    default public void updateSoundStyle(int n, int n2) {
    }

    default public void updateSoundSystemOnOff(boolean bl, int n) {
    }

    default public void updateSoundOnOff(boolean bl, int n) {
    }

    default public void acknowledgeSoundSetFactoryDefault(boolean bl) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

