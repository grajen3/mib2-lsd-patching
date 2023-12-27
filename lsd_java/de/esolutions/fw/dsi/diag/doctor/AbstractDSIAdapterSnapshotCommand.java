/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.diag.IAdapterSnapshot;
import de.esolutions.fw.dsi.diag.doctor.AbstractDSIAdapterDiagnosisCommand;
import java.io.PrintStream;

public abstract class AbstractDSIAdapterSnapshotCommand
extends AbstractDSIAdapterDiagnosisCommand {
    private IAdapterSnapshot snapshot;

    public AbstractDSIAdapterSnapshotCommand(DSIAdmin dSIAdmin) {
        super(dSIAdmin);
    }

    protected IAdapterSnapshot getSnapshot() {
        return this.snapshot;
    }

    @Override
    protected void handleWithDSIAdapterDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        this.snapshot = (IAdapterSnapshot)doctorShell.getState().getKey(this.ADAPTER_SNAPSHOT_STATE_NAME);
        if (this.snapshot == null) {
            this.snapshot = this.getDiagnosis().createSnapshot();
            doctorShell.getState().setKey(this.ADAPTER_SNAPSHOT_STATE_NAME, this.snapshot);
        }
        if (this.snapshot != null) {
            this.handleWithDSIAdapterSnapshot(doctorShell, stringArray, printStream);
        } else {
            printStream.println("No Adapter Snapshot!");
        }
    }

    protected abstract void handleWithDSIAdapterSnapshot(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
    }
}

