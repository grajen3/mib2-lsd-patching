/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.albumbrowser;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;

public final class DSIAlbumBrowserTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ALBUMENTRYINFO;
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$AlbumEntryInfo;

    public DSIAlbumBrowserTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$albumbrowser$AlbumEntryInfo == null ? (class$org$dsi$ifc$albumbrowser$AlbumEntryInfo = DSIAlbumBrowserTracer.class$("org.dsi.ifc.albumbrowser.AlbumEntryInfo")) : class$org$dsi$ifc$albumbrowser$AlbumEntryInfo, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAlbumEntryInfo(printWriter, (AlbumEntryInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAlbumEntryInfo(PrintWriter printWriter, AlbumEntryInfo albumEntryInfo) {
        if (albumEntryInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(albumEntryInfo.albumIdx);
        printWriter.print(albumEntryInfo.artistID);
        printWriter.print(albumEntryInfo.artist);
        printWriter.print(albumEntryInfo.albumID);
        printWriter.print(albumEntryInfo.album);
        printWriter.print(albumEntryInfo.flags);
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

