/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIOnlineRadioListener
extends DSIListener {
    default public void getRadioStationLogoResult(int n, int n2, RadioStation radioStation, int n3) {
    }

    default public void getStreamUrlResult(int n, int n2, RadioStation radioStation) {
    }

    default public void getMetaInformationResult(int n, int n2, RadioStation radioStation) {
    }

    default public void downloadDatabaseResult(int n, int n2) {
    }

    default public void cancelDownloadDatabaseResult(int n, int n2) {
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

