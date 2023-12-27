/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.IAgentSnapshot;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractAgentDiagnosisCommand;
import java.io.PrintStream;

public abstract class AbstractAgentSnapshotCommand
extends AbstractAgentDiagnosisCommand {
    private IAgentSnapshot snapshot;

    protected IAgentSnapshot getSnapshot() {
        return this.snapshot;
    }

    @Override
    protected void handleWithAgentDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        this.snapshot = doctorShell.getState().ensureSnapshot(this.getDiagnosis());
        if (this.snapshot != null) {
            this.handleWithAgentSnapshot(doctorShell, stringArray, printStream);
        } else {
            printStream.println("No Agent Snapshot!");
        }
    }

    protected abstract void handleWithAgentSnapshot(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
    }
}

