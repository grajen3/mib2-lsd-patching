/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.travelguide;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public final class DSITravelGuideTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_TRAVELGUIDEMEMORYLISTELEMENT;
    static /* synthetic */ Class class$org$dsi$ifc$travelguide$TravelGuideMemoryListElement;

    public DSITravelGuideTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$travelguide$TravelGuideMemoryListElement == null ? (class$org$dsi$ifc$travelguide$TravelGuideMemoryListElement = DSITravelGuideTracer.class$("org.dsi.ifc.travelguide.TravelGuideMemoryListElement")) : class$org$dsi$ifc$travelguide$TravelGuideMemoryListElement, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceTravelGuideMemoryListElement(printWriter, (TravelGuideMemoryListElement)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceTravelGuideMemoryListElement(PrintWriter printWriter, TravelGuideMemoryListElement travelGuideMemoryListElement) {
        if (travelGuideMemoryListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(travelGuideMemoryListElement.uID);
        this.trace(printWriter, travelGuideMemoryListElement.icon);
        printWriter.print(travelGuideMemoryListElement.title);
        printWriter.print(travelGuideMemoryListElement.status);
        printWriter.print(travelGuideMemoryListElement.progress);
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

