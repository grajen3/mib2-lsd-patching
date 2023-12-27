/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.uota;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.uota.PackageInfo;

public final class DSIUotATracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_PACKAGEINFO;
    static /* synthetic */ Class class$org$dsi$ifc$uota$PackageInfo;

    public DSIUotATracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$uota$PackageInfo == null ? (class$org$dsi$ifc$uota$PackageInfo = DSIUotATracer.class$("org.dsi.ifc.uota.PackageInfo")) : class$org$dsi$ifc$uota$PackageInfo, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.tracePackageInfo(printWriter, (PackageInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void tracePackageInfo(PrintWriter printWriter, PackageInfo packageInfo) {
        int n;
        int n2;
        if (packageInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(packageInfo.symbolicName);
        printWriter.print(packageInfo.category);
        printWriter.print(packageInfo.version);
        if (packageInfo.hierarchyInfo == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = packageInfo.hierarchyInfo.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(packageInfo.hierarchyInfo[n]);
            }
        }
        printWriter.print(packageInfo.priority);
        printWriter.print(packageInfo.label);
        printWriter.print(packageInfo.size);
        printWriter.print(packageInfo.type);
        if (packageInfo.extras == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = packageInfo.extras.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(packageInfo.extras[n]);
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

