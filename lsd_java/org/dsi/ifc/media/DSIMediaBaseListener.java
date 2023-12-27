/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public interface DSIMediaBaseListener
extends DSIListener {
    default public void updateParentalML(int n, int n2) {
    }

    default public void updatePreferredLanguage(String string, int n) {
    }

    default public void updateMediaList(MediaInfo[] mediaInfoArray, int n) {
    }

    default public void updateDeviceList(DeviceInfo[] deviceInfoArray, int n) {
    }

    default public void updateCustomerUpdate(int n, int n2) {
    }

    default public void updateApplicationVersion(String string, int n) {
    }

    default public void updateMetadataDBVersion(String string, int n) {
    }

    default public void responseResetFactorySettings(int n, boolean bl) {
    }

    default public void launchAppResult(long l, long l2, String string, boolean bl) {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }
}

