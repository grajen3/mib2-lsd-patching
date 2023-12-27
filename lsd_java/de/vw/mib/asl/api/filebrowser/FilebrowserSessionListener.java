/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.filebrowser;

import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public interface FilebrowserSessionListener {
    default public void updateSessionClosed() {
    }

    default public void updateSourceList(FileBrowserSourceList fileBrowserSourceList) {
    }

    default public void getFileCountResult(boolean bl, int n) {
    }

    default public void changeFolderResult(boolean bl, Path path) {
    }

    default public void responseOpenDirectoryAbsoluteByPath(boolean bl, Path path) {
    }

    default public void startResult(boolean bl, Path path) {
    }

    default public void responseStopSession() {
    }

    default public void getViewWindowResult(boolean bl, int n, BrowsedFileSet browsedFileSet) {
    }

    default public void getResourceLocatorsResult(boolean bl, ResourceLocator[] resourceLocatorArray) {
    }

    default public void responseSetContentFilter(boolean bl) {
    }
}

