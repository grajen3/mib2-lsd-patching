/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.uota;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.uota.PackageInfo;

public interface DSIUotAListener
extends DSIListener {
    default public void updateDownloadState(int n, int n2, int n3) {
    }

    default public void updateDownloadProgress(int n, int n2, int n3, String string, int n4) {
    }

    default public void getServerList(int n, String[] stringArray) {
    }

    default public void getUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
    }

    default public void toggleSelection(int n, int n2, int[] nArray) {
    }

    default public void startDownload(int n, int n2) {
    }

    default public void triggerAction(int n, int n2, int n3, String string) {
    }

    default public void updatePackagesAvailable(int n, int n2) {
    }

    default public void featureResult(String string, int n, boolean bl) {
    }

    default public void attributeResult(int n, int n2, int n3, String string) {
    }

    default public void updateServcieReady(int n, boolean bl, int n2) {
    }

    default public void getUpdatePackagesForDestinations(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
    }

    default public void getUpdatePackagesViaApp(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
    }

    default public void abortDownload(int n, int n2) {
    }

    default public void customerDownloadFinished(int n, int n2) {
    }
}

