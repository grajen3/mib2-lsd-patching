/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlselection;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swdlselection.LameClient;

public interface DSISwdlSelectionListener
extends DSIListener {
    default public void updateLameClients(LameClient[] lameClientArray, int n) {
    }

    default public void updateEngineering(boolean bl, int n) {
    }

    default public void updateUserSwdl(boolean bl, int n) {
    }

    default public void updateRingNotOK(boolean bl, int n) {
    }

    default public void updateEndDownload(boolean bl, int n) {
    }

    default public void updateAvailableMedia(byte by, int n) {
    }

    default public void updateUnitType(int n, int n2) {
    }

    default public void getMedia(int[] nArray) {
    }

    default public void storeNfsIpAddress(String string) {
    }

    default public void storeNfsPath(String string) {
    }

    default public void storeFsPath(String string) {
    }

    default public void setMedium(int n, String string, String[] stringArray) {
    }

    default public void setRelease(int n, String string) {
    }

    default public void getUserDefinedAllowed(boolean bl) {
    }

    default public void setTargetLanguage(short s) {
    }

    default public void getIncompatibleDevices(String[] stringArray, String[] stringArray2) {
    }

    default public void startVersionUpload(boolean bl) {
    }

    default public void checkConsistency(int n, boolean bl, String string, int n2) {
    }

    default public void abortSetMedium() {
    }

    default public void abortSetRelease() {
    }

    default public void getFinalizeTargets(int[] nArray) {
    }

    default public void setFinalizeTarget(int n, long l, long l2, long l3) {
    }

    default public void enterComponentUpdateConfirmation() {
    }
}

