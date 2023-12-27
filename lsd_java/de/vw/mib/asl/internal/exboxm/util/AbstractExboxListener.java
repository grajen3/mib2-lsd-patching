/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.util;

import org.dsi.ifc.exboxm.AudioRequest;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.DSIExBoxMListener;
import org.dsi.ifc.exboxm.ExBoxState;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public abstract class AbstractExboxListener
implements DSIExBoxMListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseDisplayControl(int n, int n2) {
    }

    @Override
    public void updateAudioRequest(AudioRequest audioRequest, int n) {
    }

    @Override
    public void updateDisplayRequest(int n, int n2) {
    }

    @Override
    public void updateOperationState(int n, int n2) {
    }

    @Override
    public void responseVolumeRange(int n) {
    }

    @Override
    public void responseResetToFactory(int n) {
    }

    @Override
    public void responseConnectionControl(ConnectionControl connectionControl) {
    }

    @Override
    public void updateActiveSourceType(int n, int n2) {
    }

    @Override
    public void updateCurrentStationInfo(String string, int n, String string2, int n2, int n3, String string3, int n4, String string4, int n5, int n6) {
    }

    @Override
    public void updateMobileDeviceLinkStatus(MobileDeviceLinkStatus mobileDeviceLinkStatus, ExBoxState exBoxState, int n) {
    }

    @Override
    public void updatePublicDeviceAddress(PublicDeviceAddress publicDeviceAddress, int n) {
    }
}

