/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.IAgentErrorLog;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractAgentErrorLogCommand;
import java.io.PrintStream;

public class StubErrorCommand
extends AbstractAgentErrorLogCommand {
    @Override
    public String[] getNames() {
        return new String[]{"stub_errors", "se"};
    }

    @Override
    public String getDescription() {
        return "Show stub errors from error log";
    }

    @Override
    public String getUsage() {
        return "[id][[,id]...]";
    }

    @Override
    protected void handleWithAgentErrorLog(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        IAgentErrorLog iAgentErrorLog = this.getErrorLog();
        IInfoBase[] iInfoBaseArray = iAgentErrorLog.getStubErrors();
        if (stringArray.length > 0) {
            iInfoBaseArray = InfoUtils.pickInfos(stringArray, iInfoBaseArray);
        }
        InfoUtils.printInfos(iInfoBaseArray, new InfoStream(printStream));
        int n = iAgentErrorLog.getNumDroppedStubErrors();
        if (n > 0) {
            printStream.println(new StringBuffer().append("Dropped stub error entries: ").append(n).toString());
        }
    }
}

