/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractDoctorCommand;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.diag.IAdapterDiagnosis;
import java.io.PrintStream;

public abstract class AbstractDSIAdapterDiagnosisCommand
extends AbstractDoctorCommand {
    protected final String ADAPTER_SNAPSHOT_STATE_NAME = (class$de$esolutions$fw$dsi$diag$IAdapterSnapshot == null ? (class$de$esolutions$fw$dsi$diag$IAdapterSnapshot = AbstractDSIAdapterDiagnosisCommand.class$("de.esolutions.fw.dsi.diag.IAdapterSnapshot")) : class$de$esolutions$fw$dsi$diag$IAdapterSnapshot).getName();
    protected DSIAdmin admin;
    private IAdapterDiagnosis diagnosis;
    static /* synthetic */ Class class$de$esolutions$fw$dsi$diag$IAdapterSnapshot;

    public AbstractDSIAdapterDiagnosisCommand(DSIAdmin dSIAdmin) {
        this.admin = dSIAdmin;
    }

    protected IAdapterDiagnosis getDiagnosis() {
        return this.diagnosis;
    }

    @Override
    public boolean handle(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        System.out.println("+ AbstractDSIAdapterDiagnosisCommand::handle");
        if (this.admin != null) {
            this.diagnosis = this.admin.getDiagnosis();
            if (this.diagnosis != null) {
                this.handleWithDSIAdapterDiagnosis(doctorShell, stringArray, printStream);
                this.diagnosis = null;
            } else {
                printStream.println("No DSIAdapter Diagnosis?");
            }
        } else {
            printStream.println("No DSI Adapter?");
        }
        System.out.println("- AbstractDSIAdapterDiagnosisCommand::handle");
        return false;
    }

    protected abstract void handleWithDSIAdapterDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
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

