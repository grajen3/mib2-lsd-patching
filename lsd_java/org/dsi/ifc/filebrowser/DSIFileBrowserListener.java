/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIFileBrowserListener
extends DSIListener {
    default public void startResult(int n, int n2, Path path) {
    }

    default public void setFileExtensionFilterResult(int n, int n2) {
    }

    default public void setFileTypeFilterResult(int n, int n2) {
    }

    default public void getViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
    }

    default public void getViewWindowWithPreviewsResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, PreviewInfo[] previewInfoArray, int n4) {
    }

    default public void getResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
    }

    default public void indicateSelectionResult(int n, int n2, int n3) {
    }

    default public void changeFolderResult(int n, int n2, Path path) {
    }

    default public void getSelectedFilesResult(int n, int n2, int n3) {
    }

    default public void getResourceLocatorsResult(int n, int n2, ResourceLocator[] resourceLocatorArray) {
    }

    default public void getFileCountResult(int n, int n2, int n3) {
    }

    default public void getFileCountWithFileTypeFilterResult(int n, int n2, int n3, int n4) {
    }

    default public void spellerResult(int n, int n2, String string, String string2) {
    }

    default public void setLanguageResult(int n, String string) {
    }

    default public void setFileTypeActiveResult(int n) {
    }

    default public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
    }

    default public void createPreviewImageResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
    }

    default public void cancelPreviewCreationResult(int n) {
    }
}

