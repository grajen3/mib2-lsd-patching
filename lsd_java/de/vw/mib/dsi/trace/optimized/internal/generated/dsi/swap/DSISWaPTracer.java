/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.swap;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public final class DSISWaPTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CONFIGINFO;
    private static final int ID_SFSCDETAILS;
    private static final int ID_SFSCHISTORY;
    private static final int ID_SFSCIMPORTSTATUS;
    private static final int ID_SFSCSTATUS;
    static /* synthetic */ Class class$org$dsi$ifc$swap$ConfigInfo;
    static /* synthetic */ Class class$org$dsi$ifc$swap$SFscDetails;
    static /* synthetic */ Class class$org$dsi$ifc$swap$SFscHistory;
    static /* synthetic */ Class class$org$dsi$ifc$swap$SFscImportStatus;
    static /* synthetic */ Class class$org$dsi$ifc$swap$SFscStatus;

    public DSISWaPTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swap$ConfigInfo == null ? (class$org$dsi$ifc$swap$ConfigInfo = DSISWaPTracer.class$("org.dsi.ifc.swap.ConfigInfo")) : class$org$dsi$ifc$swap$ConfigInfo, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swap$SFscDetails == null ? (class$org$dsi$ifc$swap$SFscDetails = DSISWaPTracer.class$("org.dsi.ifc.swap.SFscDetails")) : class$org$dsi$ifc$swap$SFscDetails, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swap$SFscHistory == null ? (class$org$dsi$ifc$swap$SFscHistory = DSISWaPTracer.class$("org.dsi.ifc.swap.SFscHistory")) : class$org$dsi$ifc$swap$SFscHistory, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swap$SFscImportStatus == null ? (class$org$dsi$ifc$swap$SFscImportStatus = DSISWaPTracer.class$("org.dsi.ifc.swap.SFscImportStatus")) : class$org$dsi$ifc$swap$SFscImportStatus, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swap$SFscStatus == null ? (class$org$dsi$ifc$swap$SFscStatus = DSISWaPTracer.class$("org.dsi.ifc.swap.SFscStatus")) : class$org$dsi$ifc$swap$SFscStatus, 5);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceConfigInfo(printWriter, (ConfigInfo)object);
                break;
            }
            case 2: {
                this.traceSFscDetails(printWriter, (SFscDetails)object);
                break;
            }
            case 3: {
                this.traceSFscHistory(printWriter, (SFscHistory)object);
                break;
            }
            case 4: {
                this.traceSFscImportStatus(printWriter, (SFscImportStatus)object);
                break;
            }
            case 5: {
                this.traceSFscStatus(printWriter, (SFscStatus)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceConfigInfo(PrintWriter printWriter, ConfigInfo configInfo) {
        int n;
        int n2;
        if (configInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(configInfo.componentName);
        if (configInfo.packets == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = configInfo.packets.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(configInfo.packets[n]);
            }
        }
        if (configInfo.configs == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = configInfo.configs.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(configInfo.configs[n]);
            }
        }
    }

    private void traceSFscDetails(PrintWriter printWriter, SFscDetails sFscDetails) {
        if (sFscDetails == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sFscDetails.swid);
        printWriter.print(sFscDetails.state);
        printWriter.print(sFscDetails.index);
        printWriter.print(sFscDetails.version);
        printWriter.print(sFscDetails.vin);
        printWriter.print(sFscDetails.date);
        printWriter.print(sFscDetails.vcrn);
    }

    private void traceSFscHistory(PrintWriter printWriter, SFscHistory sFscHistory) {
        if (sFscHistory == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sFscHistory.swid);
        printWriter.print(sFscHistory.timestamp);
        printWriter.print(sFscHistory.loginfo);
    }

    private void traceSFscImportStatus(PrintWriter printWriter, SFscImportStatus sFscImportStatus) {
        if (sFscImportStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sFscImportStatus.swid);
        printWriter.print(sFscImportStatus.state);
        printWriter.print(sFscImportStatus.suppinfo);
        printWriter.print(sFscImportStatus.index);
    }

    private void traceSFscStatus(PrintWriter printWriter, SFscStatus sFscStatus) {
        if (sFscStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sFscStatus.swid);
        printWriter.print(sFscStatus.state);
        printWriter.print(sFscStatus.index);
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

