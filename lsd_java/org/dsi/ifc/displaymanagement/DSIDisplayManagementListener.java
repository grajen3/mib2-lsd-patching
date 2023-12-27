/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.displaymanagement;

import org.dsi.ifc.base.DSIListener;

public interface DSIDisplayManagementListener
extends DSIListener {
    default public void getExtents(int n, int n2, int n3) {
    }

    default public void activeContext(int n, int n2, int n3) {
    }

    default public void fadeStarted(int n, int n2) {
    }

    default public void fadeComplete(int n, int n2) {
    }

    default public void getDisplayPower(int n, int n2) {
    }

    default public void getDisplayBrightness(int n, int n2) {
    }

    default public void getBrightness(int n, int n2) {
    }

    default public void getContrast(int n, int n2) {
    }

    default public void getColor(int n, int n2) {
    }

    default public void getTint(int n, int n2) {
    }

    default public void lockDisplayResult(int n) {
    }

    default public void unlockDisplayResult(int n) {
    }

    default public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
    }

    default public void getDisplayableInfo(int n, int n2, int n3) {
    }

    default public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
    }

    default public void setDisplayTypeResult(int n, int n2) {
    }

    default public void getDisplayTypeResult(int n, int n2) {
    }

    default public void setUpdateRateResult(int n, int n2) {
    }

    default public void getUpdateRateResult(int n, int n2) {
    }

    default public void startComponentResult(int n, int n2, int n3, int n4) {
    }

    default public void stopComponentResult(int n, int n2, int n3, int n4) {
    }

    default public void setAnnotationDataResponse(int n, int n2) {
    }

    default public void initAnnotationsResponse(int n, int n2) {
    }

    default public void destroyImageDisplayableResponse(int n, int n2) {
    }

    default public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    default public void createImageDisplayableResponse(int n, int n2) {
    }
}

