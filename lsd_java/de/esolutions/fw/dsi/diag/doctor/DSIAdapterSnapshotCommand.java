/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.diag.IAdapterDiagnosis;
import de.esolutions.fw.dsi.diag.IAdapterSnapshot;
import de.esolutions.fw.dsi.diag.doctor.AbstractDSIAdapterDiagnosisCommand;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.PrintStream;

public class DSIAdapterSnapshotCommand
extends AbstractDSIAdapterDiagnosisCommand {
    public DSIAdapterSnapshotCommand(DSIAdmin dSIAdmin) {
        super(dSIAdmin);
    }

    @Override
    public String[] getNames() {
        return new String[]{"dsi_snapshot", "dsis"};
    }

    @Override
    public String getDescription() {
        return "take an dsiadapter snapshot for info commands";
    }

    @Override
    protected void handleWithDSIAdapterDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        IAdapterDiagnosis iAdapterDiagnosis = this.getDiagnosis();
        IAdapterSnapshot iAdapterSnapshot = iAdapterDiagnosis.createSnapshot();
        if (iAdapterSnapshot != null) {
            doctorShell.getState().setKey(this.ADAPTER_SNAPSHOT_STATE_NAME, iAdapterSnapshot);
            TraceTimeStamp traceTimeStamp = new TraceTimeStamp(iAdapterSnapshot.getTimeStamp());
            printStream.println(new StringBuffer().append("Snapshot taken: ").append(traceTimeStamp.toUTCTimeString(true)).toString());
        } else {
            printStream.println("Error taking snapshot!");
        }
    }
}

