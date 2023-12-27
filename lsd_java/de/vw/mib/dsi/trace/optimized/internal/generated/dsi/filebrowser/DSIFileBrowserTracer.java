/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.filebrowser;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.GPSInfo;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;

public final class DSIFileBrowserTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_BROWSEDFILE;
    private static final int ID_BROWSEDFILESET;
    private static final int ID_GPSINFO;
    private static final int ID_PATH;
    private static final int ID_PREVIEWINFO;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$BrowsedFile;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$BrowsedFileSet;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$GPSInfo;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$Path;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$PreviewInfo;

    public DSIFileBrowserTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$filebrowser$BrowsedFile == null ? (class$org$dsi$ifc$filebrowser$BrowsedFile = DSIFileBrowserTracer.class$("org.dsi.ifc.filebrowser.BrowsedFile")) : class$org$dsi$ifc$filebrowser$BrowsedFile, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$filebrowser$BrowsedFileSet == null ? (class$org$dsi$ifc$filebrowser$BrowsedFileSet = DSIFileBrowserTracer.class$("org.dsi.ifc.filebrowser.BrowsedFileSet")) : class$org$dsi$ifc$filebrowser$BrowsedFileSet, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$filebrowser$GPSInfo == null ? (class$org$dsi$ifc$filebrowser$GPSInfo = DSIFileBrowserTracer.class$("org.dsi.ifc.filebrowser.GPSInfo")) : class$org$dsi$ifc$filebrowser$GPSInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$filebrowser$Path == null ? (class$org$dsi$ifc$filebrowser$Path = DSIFileBrowserTracer.class$("org.dsi.ifc.filebrowser.Path")) : class$org$dsi$ifc$filebrowser$Path, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$filebrowser$PreviewInfo == null ? (class$org$dsi$ifc$filebrowser$PreviewInfo = DSIFileBrowserTracer.class$("org.dsi.ifc.filebrowser.PreviewInfo")) : class$org$dsi$ifc$filebrowser$PreviewInfo, 5);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceBrowsedFile(printWriter, (BrowsedFile)object);
                break;
            }
            case 2: {
                this.traceBrowsedFileSet(printWriter, (BrowsedFileSet)object);
                break;
            }
            case 3: {
                this.traceGPSInfo(printWriter, (GPSInfo)object);
                break;
            }
            case 4: {
                this.tracePath(printWriter, (Path)object);
                break;
            }
            case 5: {
                this.tracePreviewInfo(printWriter, (PreviewInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceBrowsedFile(PrintWriter printWriter, BrowsedFile browsedFile) {
        if (browsedFile == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(browsedFile.id);
        printWriter.print(browsedFile.selected);
        printWriter.print(browsedFile.filename);
        printWriter.print(browsedFile.fileType);
        printWriter.print(browsedFile.fileSize);
    }

    private void traceBrowsedFileSet(PrintWriter printWriter, BrowsedFileSet browsedFileSet) {
        if (browsedFileSet == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, browsedFileSet.path);
        if (browsedFileSet.files == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = browsedFileSet.files.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, browsedFileSet.files[i2]);
            }
        }
    }

    private void traceGPSInfo(PrintWriter printWriter, GPSInfo gPSInfo) {
        if (gPSInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(gPSInfo.latitudeDecimalDegrees);
        printWriter.print(gPSInfo.longitudeDecimalDegrees);
        printWriter.print(gPSInfo.altitudeMetersAboveSeaLevel);
    }

    private void tracePath(PrintWriter printWriter, Path path) {
        if (path == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(path.mountPoint);
        if (path.folderNames == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = path.folderNames.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(path.folderNames[i2]);
            }
        }
    }

    private void tracePreviewInfo(PrintWriter printWriter, PreviewInfo previewInfo) {
        if (previewInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, previewInfo.previewRL);
        printWriter.print(previewInfo.utcTimestampCreatedOn);
        this.trace(printWriter, previewInfo.gpsInfo);
        printWriter.print(previewInfo.headline);
        printWriter.print(previewInfo.imageDescription);
        printWriter.print(previewInfo.copyright);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

