/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public interface DSISWaPListener
extends DSIListener {
    default public void updateSoftwareEnabling(int[] nArray, int n) {
    }

    default public void updateIllegalFSCs(int[] nArray, int n) {
    }

    default public void updateAreFSCsSigned(boolean bl, int n) {
    }

    default public void updateLimitedLifetime(boolean bl, int n) {
    }

    default public void updateConfigCheck(ConfigInfo configInfo, int n) {
    }

    default public void updateConfigPrepare(String string, int n) {
    }

    default public void updateConfigFinalize(ConfigInfo configInfo, int n) {
    }

    default public void updateFscList(SFscStatus[] sFscStatusArray, int n) {
    }

    default public void encryptFile(String string, int n) {
    }

    default public void checkSignature(boolean bl, String string) {
    }

    default public void getPublicKey(short[] sArray, boolean bl) {
    }

    default public void checkSingleFsc(int n, int n2) {
    }

    default public void decryptFile(String string, int n) {
    }

    default public void getFscDetail(SFscDetails sFscDetails) {
    }

    default public void importFSCs(int n, SFscImportStatus sFscImportStatus) {
    }

    default public void importFSCsList(int n, SFscImportStatus[] sFscImportStatusArray) {
    }

    default public void exportCCD(int n) {
    }

    default public void getHistory(SFscHistory sFscHistory) {
    }

    default public void getHistoryList(SFscHistory[] sFscHistoryArray) {
    }
}

