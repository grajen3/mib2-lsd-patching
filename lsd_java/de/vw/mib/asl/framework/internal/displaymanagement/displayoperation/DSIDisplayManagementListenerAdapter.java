/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.displayoperation;

import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;

public abstract class DSIDisplayManagementListenerAdapter
implements DSIDisplayManagementListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void getExtents(int n, int n2, int n3) {
    }

    @Override
    public void activeContext(int n, int n2, int n3) {
    }

    @Override
    public void fadeStarted(int n, int n2) {
    }

    @Override
    public void fadeComplete(int n, int n2) {
    }

    @Override
    public void getDisplayPower(int n, int n2) {
    }

    @Override
    public void getDisplayBrightness(int n, int n2) {
    }

    @Override
    public void getBrightness(int n, int n2) {
    }

    @Override
    public void getContrast(int n, int n2) {
    }

    @Override
    public void getColor(int n, int n2) {
    }

    @Override
    public void getTint(int n, int n2) {
    }

    @Override
    public void lockDisplayResult(int n) {
    }

    @Override
    public void unlockDisplayResult(int n) {
    }

    @Override
    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
    }

    @Override
    public void getDisplayableInfo(int n, int n2, int n3) {
    }

    @Override
    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
    }

    @Override
    public void setDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void getDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void setUpdateRateResult(int n, int n2) {
    }

    @Override
    public void getUpdateRateResult(int n, int n2) {
    }

    @Override
    public void startComponentResult(int n, int n2, int n3, int n4) {
    }

    @Override
    public void stopComponentResult(int n, int n2, int n3, int n4) {
    }

    @Override
    public void setAnnotationDataResponse(int n, int n2) {
    }

    @Override
    public void initAnnotationsResponse(int n, int n2) {
    }

    @Override
    public void destroyImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void createImageDisplayableResponse(int n, int n2) {
    }

    public void showDisplayablesResult(int n, int[] nArray, int n2, int n3) {
    }

    public void dumpDisplayableResult(int n, int n2) {
    }

    public void getDisplaySizeResult(int n, int n2, int n3, int n4) {
    }

    public void getAvailableDisplayablesResult(int[] nArray) {
    }
}

