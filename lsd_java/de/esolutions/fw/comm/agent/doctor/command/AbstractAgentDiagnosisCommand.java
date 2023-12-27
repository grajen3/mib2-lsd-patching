/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.IAgentDiagnosis;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractDoctorCommand;
import java.io.PrintStream;

public abstract class AbstractAgentDiagnosisCommand
extends AbstractDoctorCommand {
    private Agent agent;
    private IAgentDiagnosis diagnosis;

    @Override
    public boolean handle(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        this.agent = Agent.getAgent();
        if (this.agent != null) {
            this.diagnosis = this.agent.getAgentDiagnosis();
            if (this.diagnosis != null) {
                this.handleWithAgentDiagnosis(doctorShell, stringArray, printStream);
                this.diagnosis = null;
                this.agent = null;
            } else {
                printStream.println("No AgentDiagnosis?");
            }
        } else {
            printStream.println("No Agent?");
        }
        return false;
    }

    public Agent getAgent() {
        return this.agent;
    }

    public IAgentDiagnosis getDiagnosis() {
        return this.diagnosis;
    }

    protected abstract void handleWithAgentDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
    }
}

