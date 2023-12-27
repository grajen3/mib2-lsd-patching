/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag.doctor;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.doctor.AbstractDSIAdapterErrorLogCommand;
import java.io.PrintStream;

public class DSIAdapterProviderErrorCommand
extends AbstractDSIAdapterErrorLogCommand {
    public DSIAdapterProviderErrorCommand(DSIAdmin dSIAdmin) {
        super(dSIAdmin);
    }

    @Override
    public String[] getNames() {
        return new String[]{"dsi_provider_error", "dsipe"};
    }

    @Override
    public String getDescription() {
        return "shows error of dsi provider(s)";
    }

    @Override
    public String getUsage() {
        return "[error_id|uuid][,error_id|uuid...]";
    }

    @Override
    protected void handleWithDSIAdapterErrorLog(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        IAdapterErrorLog iAdapterErrorLog = this.getErrorLog();
        IInfoBase[] iInfoBaseArray = iAdapterErrorLog.getProviderErrors();
        if (stringArray.length > 0) {
            iInfoBaseArray = InfoUtils.pickInfos(stringArray, iInfoBaseArray);
        }
        InfoUtils.printInfos(iInfoBaseArray, new InfoStream(printStream));
        int n = iAdapterErrorLog.getNumDroppedProviderErrors();
        if (n > 0) {
            printStream.println(new StringBuffer().append("Dropped provider error entries: ").append(n).toString());
        }
    }
}

