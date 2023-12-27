/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaymanagement;

import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIDisplayManagementC {
    default public void declareContexts(DisplayContext[] displayContextArray) {
    }

    default public void switchContext(int n, int n2, int n3) {
    }

    default public void setOpacity(int n, int n2, int n3) {
    }

    default public void fadeToOpacity(int n, int n2, int n3, int n4) {
    }

    default public void setPosition(int n, int n2, int n3, int n4) {
    }

    default public void getExtents(int n) {
    }

    default public void takeScreenshot(int n, String string) {
    }

    default public void lockDisplay(int n) {
    }

    default public void unlockDisplay(int n) {
    }

    default public void switchDisplayPower(int n, int n2) {
    }

    default public void getDisplayPower(int n) {
    }

    default public void setDisplayBrightness(int n, int n2) {
    }

    default public void getDisplayBrightness(int n) {
    }

    default public void setBrightness(int n, int n2) {
    }

    default public void getBrightness(int n) {
    }

    default public void setContrast(int n, int n2) {
    }

    default public void getContrast(int n) {
    }

    default public void setColor(int n, int n2) {
    }

    default public void getColor(int n) {
    }

    default public void setTint(int n, int n2) {
    }

    default public void getTint(int n) {
    }

    default public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void getDisplayableInfo(int n, int n2) {
    }

    default public void setDimension(int n, int n2, int n3, int n4) {
    }

    default public void setScaleMode(int n, int n2, int n3) {
    }

    default public void takeScreenshotOnExternalStorage(int n, String string) {
    }

    default public void setDisplayType(int n, int n2) {
    }

    default public void getDisplayType(int n) {
    }

    default public void setUpdateRate(int n, int n2) {
    }

    default public void getUpdateRate(int n) {
    }

    default public void startComponent(int n, int n2, int n3) {
    }

    default public void stopComponent(int n, int n2, int n3) {
    }

    default public void createImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    default public void requestUpdateImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    default public void destroyImageDisplayable(int n) {
    }

    default public void initAnnotations(int n) {
    }

    default public void setAnnotationData(int n, int n2, String string) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

