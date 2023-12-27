/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.modelapi;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.modelapi.ListCellData;
import org.dsi.ifc.modelapi.ListCellDataFixFormat;
import org.dsi.ifc.modelapi.ListRowData;
import org.dsi.ifc.modelapi.NBestResultEntry;

public final class DSIModelAPITracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_LISTCELLDATA;
    private static final int ID_LISTCELLDATAFIXFORMAT;
    private static final int ID_LISTROWDATA;
    private static final int ID_NBESTRESULTENTRY;
    static /* synthetic */ Class class$org$dsi$ifc$modelapi$ListCellData;
    static /* synthetic */ Class class$org$dsi$ifc$modelapi$ListCellDataFixFormat;
    static /* synthetic */ Class class$org$dsi$ifc$modelapi$ListRowData;
    static /* synthetic */ Class class$org$dsi$ifc$modelapi$NBestResultEntry;

    public DSIModelAPITracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$modelapi$ListCellData == null ? (class$org$dsi$ifc$modelapi$ListCellData = DSIModelAPITracer.class$("org.dsi.ifc.modelapi.ListCellData")) : class$org$dsi$ifc$modelapi$ListCellData, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$modelapi$ListCellDataFixFormat == null ? (class$org$dsi$ifc$modelapi$ListCellDataFixFormat = DSIModelAPITracer.class$("org.dsi.ifc.modelapi.ListCellDataFixFormat")) : class$org$dsi$ifc$modelapi$ListCellDataFixFormat, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$modelapi$ListRowData == null ? (class$org$dsi$ifc$modelapi$ListRowData = DSIModelAPITracer.class$("org.dsi.ifc.modelapi.ListRowData")) : class$org$dsi$ifc$modelapi$ListRowData, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$modelapi$NBestResultEntry == null ? (class$org$dsi$ifc$modelapi$NBestResultEntry = DSIModelAPITracer.class$("org.dsi.ifc.modelapi.NBestResultEntry")) : class$org$dsi$ifc$modelapi$NBestResultEntry, 4);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceListCellData(printWriter, (ListCellData)object);
                break;
            }
            case 2: {
                this.traceListCellDataFixFormat(printWriter, (ListCellDataFixFormat)object);
                break;
            }
            case 3: {
                this.traceListRowData(printWriter, (ListRowData)object);
                break;
            }
            case 4: {
                this.traceNBestResultEntry(printWriter, (NBestResultEntry)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceListCellData(PrintWriter printWriter, ListCellData listCellData) {
        if (listCellData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listCellData.longListCellData);
        printWriter.print(listCellData.textListCellData);
    }

    private void traceListCellDataFixFormat(PrintWriter printWriter, ListCellDataFixFormat listCellDataFixFormat) {
        if (listCellDataFixFormat == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listCellDataFixFormat.typeFormat);
        if (listCellDataFixFormat.values == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = listCellDataFixFormat.values.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(listCellDataFixFormat.values[i2]);
            }
        }
    }

    private void traceListRowData(PrintWriter printWriter, ListRowData listRowData) {
        int n;
        int n2;
        if (listRowData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (listRowData.listCellData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = listRowData.listCellData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, listRowData.listCellData[n]);
            }
        }
        if (listRowData.listCellDataFixFormat == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = listRowData.listCellDataFixFormat.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, listRowData.listCellDataFixFormat[n]);
            }
        }
        if (listRowData.resourceLocators == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = listRowData.resourceLocators.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, listRowData.resourceLocators[n]);
            }
        }
    }

    private void traceNBestResultEntry(PrintWriter printWriter, NBestResultEntry nBestResultEntry) {
        int n;
        int n2;
        if (nBestResultEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (nBestResultEntry.nBestIDs == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = nBestResultEntry.nBestIDs.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(nBestResultEntry.nBestIDs[n]);
            }
        }
        if (nBestResultEntry.nBestData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = nBestResultEntry.nBestData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(nBestResultEntry.nBestData[n]);
            }
        }
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

