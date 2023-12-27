/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdldeviceinfo;

import org.dsi.ifc.base.DSIListener;

public interface DSISwdlDeviceInfoListener
extends DSIListener {
    default public void updateSummaryChanged(String string, int n) {
    }

    default public void getDevices(String[] stringArray, int[] nArray) {
    }

    default public void getModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
    }

    default public void getLanguages(int n, String[] stringArray, short s, short s2, short s3) {
    }

    default public void getErrors(int n, int[] nArray, short[] sArray) {
    }

    default public void isDataModule(int n, int n2, boolean bl) {
    }

    default public void isNoExclusiveBoloUpdate(int n, int n2, boolean bl) {
    }

    default public void getVersions(int n, int n2, long[] lArray) {
    }

    default public void getTargetVersions(int n, int n2, long[] lArray) {
    }

    default public void getAdditionalInfo(int n, int n2, int[] nArray) {
    }

    default public void getFileNames(int n, int n2, String[] stringArray) {
    }

    default public void getFileDetails(int n, int n2, int n3, long l, long l2, long l3, boolean bl, boolean bl2, String string, String string2) {
    }

    default public void getInfoFilePath(int n, String string, String string2) {
    }

    default public void getNumberOfPopups(int n) {
    }

    default public void getPopup(int n, int n2, String string, int n3, int n4, int n5, String string2) {
    }
}

