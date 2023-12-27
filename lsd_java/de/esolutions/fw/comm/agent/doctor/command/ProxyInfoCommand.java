/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.IAgentSnapshot;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractAgentSnapshotCommand;
import java.io.PrintStream;

public class ProxyInfoCommand
extends AbstractAgentSnapshotCommand {
    @Override
    public String[] getNames() {
        return new String[]{"proxy_info", "pi"};
    }

    @Override
    public String getDescription() {
        return "info on prox(y|ies)";
    }

    @Override
    public String getUsage() {
        return "[proxy_id|uuid][,proxy_id|uuid...]";
    }

    @Override
    protected void handleWithAgentSnapshot(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        IAgentSnapshot iAgentSnapshot = this.getSnapshot();
        IInfoBase[] iInfoBaseArray = iAgentSnapshot.getAllProxies();
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

