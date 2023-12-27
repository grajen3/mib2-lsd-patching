/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.picturestore;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public final class DSIPictureStoreTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_GEOPICTURE;
    private static final int ID_PICTUREATTRIBUTE;
    private static final int ID_PICTUREENTRYINFO;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$GeoPicture;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$PictureAttribute;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$PictureEntryInfo;

    public DSIPictureStoreTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$picturestore$GeoPicture == null ? (class$org$dsi$ifc$picturestore$GeoPicture = DSIPictureStoreTracer.class$("org.dsi.ifc.picturestore.GeoPicture")) : class$org$dsi$ifc$picturestore$GeoPicture, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$picturestore$PictureAttribute == null ? (class$org$dsi$ifc$picturestore$PictureAttribute = DSIPictureStoreTracer.class$("org.dsi.ifc.picturestore.PictureAttribute")) : class$org$dsi$ifc$picturestore$PictureAttribute, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$picturestore$PictureEntryInfo == null ? (class$org$dsi$ifc$picturestore$PictureEntryInfo = DSIPictureStoreTracer.class$("org.dsi.ifc.picturestore.PictureEntryInfo")) : class$org$dsi$ifc$picturestore$PictureEntryInfo, 3);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceGeoPicture(printWriter, (GeoPicture)object);
                break;
            }
            case 2: {
                this.tracePictureAttribute(printWriter, (PictureAttribute)object);
                break;
            }
            case 3: {
                this.tracePictureEntryInfo(printWriter, (PictureEntryInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceGeoPicture(PrintWriter printWriter, GeoPicture geoPicture) {
        if (geoPicture == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, geoPicture.pictureResource);
        printWriter.print(geoPicture.latitudeDecimalDegrees);
        printWriter.print(geoPicture.longitudeDecimalDegrees);
    }

    private void tracePictureAttribute(PrintWriter printWriter, PictureAttribute pictureAttribute) {
        if (pictureAttribute == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pictureAttribute.key);
        printWriter.print(pictureAttribute.value);
    }

    private void tracePictureEntryInfo(PrintWriter printWriter, PictureEntryInfo pictureEntryInfo) {
        if (pictureEntryInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pictureEntryInfo.type);
        if (pictureEntryInfo.attributes == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = pictureEntryInfo.attributes.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, pictureEntryInfo.attributes[i2]);
            }
        }
        printWriter.print(pictureEntryInfo.filename);
        printWriter.print(pictureEntryInfo.selected);
        this.trace(printWriter, pictureEntryInfo.resourceLocator);
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

