/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exboxm.AudioRequest;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.ExBoxState;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public interface DSIExBoxMListener
extends DSIListener {
    default public void responseDisplayControl(int n, int n2) {
    }

    default public void updateAudioRequest(AudioRequest audioRequest, int n) {
    }

    default public void updateDisplayRequest(int n, int n2) {
    }

    default public void updateOperationState(int n, int n2) {
    }

    default public void responseVolumeRange(int n) {
    }

    default public void responseResetToFactory(int n) {
    }

    default public void responseConnectionControl(ConnectionControl connectionControl) {
    }

    default public void updateActiveSourceType(int n, int n2) {
    }

    default public void updateCurrentStationInfo(String string, int n, String string2, int n2, int n3, String string3, int n4, String string4, int n5, int n6) {
    }

    default public void updateMobileDeviceLinkStatus(MobileDeviceLinkStatus mobileDeviceLinkStatus, ExBoxState exBoxState, int n) {
    }

    default public void updatePublicDeviceAddress(PublicDeviceAddress publicDeviceAddress, int n) {
    }
}

