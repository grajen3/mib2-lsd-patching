/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.filebrowser;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.filebrowser.FilebrowserSessionListener;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;

public interface FilebrowserSession {
    default public void start(Device device) {
    }

    default public void start(Medium medium) {
    }

    default public void stop() {
    }

    default public void setFileExtensionFilter(String[] stringArray) {
    }

    default public void getViewWindow(int n, int n2) {
    }

    default public void requestOpenDirectoryRelative(BrowsedFile browsedFile) {
    }

    default public void requestChangeToRootDirectory() {
    }

    default public void requestChangeToParentDirectory(int n) {
    }

    default public void getFileCount() {
    }

    default public void getResourceLocators(BrowsedFileSet browsedFileSet) {
    }

    default public void requestOpenDirectoryAbsoluteByPath(Path path) {
    }

    default public void setContentFilter(int n) {
    }

    default public boolean dispatch(EventGeneric eventGeneric, FilebrowserSessionListener filebrowserSessionListener) {
    }
}

