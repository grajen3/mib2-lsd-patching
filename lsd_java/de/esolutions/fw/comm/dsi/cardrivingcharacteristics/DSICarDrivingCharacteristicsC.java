/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;

public interface DSICarDrivingCharacteristicsC {
    default public void setSuspensionControlLiftMode(boolean bl) {
    }

    default public void setSuspensionControlCarJackMode(boolean bl) {
    }

    default public void setSuspensionControlTrailerMode(boolean bl) {
    }

    default public void setSuspensionControlLoadingMode(boolean bl) {
    }

    default public void setSuspensionControlActiveProfile(int n) {
    }

    default public void setSuspensionControlSnowChainMode(boolean bl) {
    }

    default public void setSuspensionControlActiveMode(int n) {
    }

    default public void seteABCEasyEntry(boolean bl) {
    }

    default public void seteABCPitchControl(boolean bl) {
    }

    default public void seteABCSpecialPosition(boolean bl) {
    }

    default public void seteABCPreview(int n) {
    }

    default public void setCharismaActiveProfile(int n) {
    }

    default public void setCharismaActiveOperationMode(int n) {
    }

    default public void setCharismaTrailerSetting(boolean bl) {
    }

    default public void setCharismaProgButton(CharismaProgButton charismaProgButton) {
    }

    default public void requestCharismaProfileFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    default public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
    }

    default public void showCharismaPopup(int n, int n2) {
    }

    default public void cancelCharismaPopup(int n, int n2) {
    }

    default public void setCharismaSetFactoryDefault() {
    }

    default public void setCharismaSound(boolean bl) {
    }

    default public void showTADPopup(int n, int n2) {
    }

    default public void cancelTADPopup(int n, int n2) {
    }

    default public void setTADSetFactoryDefault() {
    }

    default public void setTADMaxMinAngleReset(TADMaxMinAngleReset tADMaxMinAngleReset) {
    }

    default public void setHMIIsReady(boolean bl) {
    }

    default public void setSpoilerSetFactoryDefault() {
    }

    default public void setSpoilerPositionSelection(int n) {
    }

    default public void setSpoilerActuation(boolean bl) {
    }

    default public void setSpoilerSystemOnOff(boolean bl) {
    }

    default public void setSoundSetFactoryDefault() {
    }

    default public void setSoundStyle(int n) {
    }

    default public void setSoundSystemOnOff(boolean bl) {
    }

    default public void setSoundOnOff(boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

