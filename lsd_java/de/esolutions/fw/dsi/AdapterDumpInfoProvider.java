/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi;

import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

public class AdapterDumpInfoProvider
implements DumpInfoProvider {
    private DSIAdmin dsiAdmin;

    public AdapterDumpInfoProvider(DSIAdmin dSIAdmin) {
        this.dsiAdmin = dSIAdmin;
    }

    @Override
    public String getName() {
        return "DSIAdapter";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        if (this.dsiAdmin == null) {
            printStream.println("FATAL: No DSIAdmin found!");
        } else {
            this.dsiAdmin.writeDiagnosisReport(printStream);
        }
    }
}

