/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.has;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public final class DSIHASTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_HASDATACONTAINER;
    private static final int ID_HASDATAELEMENT;
    static /* synthetic */ Class class$org$dsi$ifc$has$HASDataContainer;
    static /* synthetic */ Class class$org$dsi$ifc$has$HASDataElement;

    public DSIHASTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$has$HASDataContainer == null ? (class$org$dsi$ifc$has$HASDataContainer = DSIHASTracer.class$("org.dsi.ifc.has.HASDataContainer")) : class$org$dsi$ifc$has$HASDataContainer, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$has$HASDataElement == null ? (class$org$dsi$ifc$has$HASDataElement = DSIHASTracer.class$("org.dsi.ifc.has.HASDataElement")) : class$org$dsi$ifc$has$HASDataElement, 2);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceHASDataContainer(printWriter, (HASDataContainer)object);
                break;
            }
            case 2: {
                this.traceHASDataElement(printWriter, (HASDataElement)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceHASDataContainer(PrintWriter printWriter, HASDataContainer hASDataContainer) {
        if (hASDataContainer == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hASDataContainer.containerId);
        printWriter.print(hASDataContainer.hierarchyId);
        printWriter.print(hASDataContainer.parentId);
        if (hASDataContainer.dataElements == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = hASDataContainer.dataElements.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, hASDataContainer.dataElements[i2]);
            }
        }
        printWriter.print(hASDataContainer.elementId);
    }

    private void traceHASDataElement(PrintWriter printWriter, HASDataElement hASDataElement) {
        if (hASDataElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hASDataElement.elementId);
        printWriter.print(hASDataElement.elementType);
        printWriter.print(hASDataElement.numericData);
        printWriter.print(hASDataElement.stringData);
        printWriter.print(hASDataElement.doubleData);
        if (hASDataElement.binaryData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = hASDataElement.binaryData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(hASDataElement.binaryData[i2]);
            }
        }
        this.trace(printWriter, hASDataElement.resourceLocator);
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

