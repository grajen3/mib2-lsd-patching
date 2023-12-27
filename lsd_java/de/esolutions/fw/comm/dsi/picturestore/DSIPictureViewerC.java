/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureViewerC {
    default public void initializeViewer(int n, int n2) {
    }

    default public void deinitializeViewer() {
    }

    default public void setSelectionMode(int n) {
    }

    default public void startRendering() {
    }

    default public void stopRendering() {
    }

    default public void setScrollMode(int n) {
    }

    default public void scrollTicks(long l) {
    }

    default public void moveFocus(long l, int n) {
    }

    default public void getPictureInfo(long l) {
    }

    default public void changeFolder(long l) {
    }

    default public void togglePictureSelection(long l) {
    }

    default public void toggleAllPicturesSelection() {
    }

    default public void clearAllPicturesSelection() {
    }

    default public void triggerAnimation(int n, long l) {
    }

    default public void setFilterSetId(int n) {
    }

    default public void moveFocusByResourceLocator(ResourceLocator resourceLocator, int n) {
    }

    default public void setSortingDirection(int n) {
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

