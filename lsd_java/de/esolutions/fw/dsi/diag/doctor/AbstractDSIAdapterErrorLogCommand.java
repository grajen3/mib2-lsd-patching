/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.doctor.AbstractDSIAdapterDiagnosisCommand;
import java.io.PrintStream;

public abstract class AbstractDSIAdapterErrorLogCommand
extends AbstractDSIAdapterDiagnosisCommand {
    private IAdapterErrorLog errorLog;

    public AbstractDSIAdapterErrorLogCommand(DSIAdmin dSIAdmin) {
        super(dSIAdmin);
    }

    protected IAdapterErrorLog getErrorLog() {
        return this.errorLog;
    }

    @Override
    protected void handleWithDSIAdapterDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        this.errorLog = this.getDiagnosis().getErrorLog();
        if (this.errorLog != null) {
            this.handleWithDSIAdapterErrorLog(doctorShell, stringArray, printStream);
            this.errorLog = null;
        } else {
            printStream.println("No Adapter ErrorLog!");
        }
    }

    protected abstract void handleWithDSIAdapterErrorLog(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
    }
}

