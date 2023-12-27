/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser;

import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIFileBrowserC {
    default public void start(Path path) {
    }

    default public void setFileExtensionFilter(int n, String[] stringArray) {
    }

    default public void setFileTypeFilter(int n, int n2) {
    }

    default public void stop(int n) {
    }

    default public void getViewWindow(int n, int n2, int n3) {
    }

    default public void getViewWindowWithPreviews(int n, int n2, int n3) {
    }

    default public void getViewWindowFromFile(int n, int n2, BrowsedFile browsedFile, int n3) {
    }

    default public void getResourceLocatorWindow(int n, int n2, int n3) {
    }

    default public void getSelectedFiles(int n) {
    }

    default public void getResourceLocators(int n, BrowsedFileSet browsedFileSet) {
    }

    default public void getFileCount(int n) {
    }

    default public void getFileCountWithFileTypeFilter(int n, int n2) {
    }

    default public void setSelectionSingle(int n, BrowsedFile browsedFile, boolean bl) {
    }

    default public void setSelection(int n, int n2) {
    }

    default public void changeFolder(int n, Path path) {
    }

    default public void setLanguage(String string) {
    }

    default public void startSpeller(int n, int n2) {
    }

    default public void addSpellerChars(int n, String string) {
    }

    default public void removeSpellerChar(int n) {
    }

    default public void stopSpeller(int n) {
    }

    default public void setFileTypeActive(boolean bl) {
    }

    default public void validateSpellerChars(int n, String string) {
    }

    default public void deleteAllPreviewFiles() {
    }

    default public void createPreviewImage(ResourceLocator resourceLocator, int n, int n2) {
    }

    default public void cancelPreviewCreation() {
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

