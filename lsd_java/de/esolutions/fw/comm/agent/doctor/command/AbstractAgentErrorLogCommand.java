/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.IAgentErrorLog;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractAgentDiagnosisCommand;
import java.io.PrintStream;

public abstract class AbstractAgentErrorLogCommand
extends AbstractAgentDiagnosisCommand {
    private IAgentErrorLog errorLog;

    protected IAgentErrorLog getErrorLog() {
        return this.errorLog;
    }

    @Override
    protected void handleWithAgentDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        this.errorLog = this.getDiagnosis().getErrorLog();
        if (this.errorLog != null) {
            this.handleWithAgentErrorLog(doctorShell, stringArray, printStream);
            this.errorLog = null;
        } else {
            printStream.println("No Agent Error Log!");
        }
    }

    protected abstract void handleWithAgentErrorLog(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
    }
}

