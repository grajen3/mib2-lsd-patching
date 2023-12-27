/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.iconhandling;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public final class DSIIconhandlingTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_TEXTRENDERINGINFO;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$TextRenderingInfo;

    public DSIIconhandlingTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$iconhandling$TextRenderingInfo == null ? (class$org$dsi$ifc$iconhandling$TextRenderingInfo = DSIIconhandlingTracer.class$("org.dsi.ifc.iconhandling.TextRenderingInfo")) : class$org$dsi$ifc$iconhandling$TextRenderingInfo, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceTextRenderingInfo(printWriter, (TextRenderingInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceTextRenderingInfo(PrintWriter printWriter, TextRenderingInfo textRenderingInfo) {
        if (textRenderingInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(textRenderingInfo.fontReference);
        printWriter.print(textRenderingInfo.fontSize);
        printWriter.print(textRenderingInfo.fontColor);
        printWriter.print(textRenderingInfo.deltaX);
        printWriter.print(textRenderingInfo.deltaY);
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

