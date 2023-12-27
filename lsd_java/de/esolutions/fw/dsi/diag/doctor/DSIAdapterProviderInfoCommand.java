/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag.doctor;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.diag.IAdapterSnapshot;
import de.esolutions.fw.dsi.diag.doctor.AbstractDSIAdapterSnapshotCommand;
import java.io.PrintStream;

public class DSIAdapterProviderInfoCommand
extends AbstractDSIAdapterSnapshotCommand {
    public DSIAdapterProviderInfoCommand(DSIAdmin dSIAdmin) {
        super(dSIAdmin);
    }

    @Override
    public String[] getNames() {
        return new String[]{"dsi_providers", "dsipi"};
    }

    @Override
    public String getDescription() {
        return "shows info of dsi provider(s)";
    }

    @Override
    public String getUsage() {
        return "[provider_id|uuid][,provider_id|uuid...]";
    }

    @Override
    protected void handleWithDSIAdapterSnapshot(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        IAdapterSnapshot iAdapterSnapshot = this.getSnapshot();
        IInfoBase[] iInfoBaseArray = iAdapterSnapshot.getAllProviders();
        if (iInfoBaseArray == null) {
            return;
        }
        IInfoBase[] iInfoBaseArray2 = iInfoBaseArray;
        if (stringArray.length > 0) {
            iInfoBaseArray2 = InfoUtils.pickInfos(stringArray, iInfoBaseArray2);
        }
        InfoUtils.printInfos(iInfoBaseArray2, new InfoStream(printStream));
    }
}

