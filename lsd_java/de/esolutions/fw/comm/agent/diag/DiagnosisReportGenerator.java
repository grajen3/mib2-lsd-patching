/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.IAgentDiagnosis;
import de.esolutions.fw.comm.agent.IAgentErrorLog;
import de.esolutions.fw.comm.agent.IAgentSnapshot;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils;
import de.esolutions.fw.comm.agent.diag.info.WorkerInfo;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.PrintStream;

public class DiagnosisReportGenerator {
    private final PrintStream out;
    private final boolean brief;

    public DiagnosisReportGenerator(PrintStream printStream, boolean bl) {
        this.out = printStream;
        this.brief = bl;
    }

    public void generate(IAgentDiagnosis iAgentDiagnosis) {
        InfoStream infoStream = new InfoStream(this.out, this.brief);
        infoStream.begin("AgentDiagnosis ");
        this.generateSnapshot(iAgentDiagnosis, infoStream);
        this.generateErrorLog(iAgentDiagnosis, infoStream);
        infoStream.end();
    }

    private void generateErrorLog(IAgentDiagnosis iAgentDiagnosis, InfoStream infoStream) {
        IAgentErrorLog iAgentErrorLog = iAgentDiagnosis.getErrorLog();
        if (iAgentErrorLog != null) {
            IInfoBase[] iInfoBaseArray;
            IInfoBase[] iInfoBaseArray2;
            infoStream.begin("ErrorLog");
            IInfoBase[] iInfoBaseArray3 = iAgentErrorLog.getProxyErrors();
            if (iInfoBaseArray3 != null) {
                InfoUtils.printInfos(iInfoBaseArray3, infoStream);
            } else {
                infoStream.print("No proxy errors reported.");
            }
            int n = iAgentErrorLog.getNumDroppedProxyErrors();
            if (n > 0) {
                infoStream.print(new StringBuffer().append("Proxy errors dropped: ").append(n).toString());
            }
            if ((iInfoBaseArray2 = iAgentErrorLog.getProxyErrors()) != null) {
                InfoUtils.printInfos(iInfoBaseArray2, infoStream);
            } else {
                infoStream.print("No stub errors reported.");
            }
            n = iAgentErrorLog.getNumDroppedStubErrors();
            if (n > 0) {
                infoStream.print(new StringBuffer().append("Stub errors dropped: ").append(n).toString());
            }
            if ((iInfoBaseArray = iAgentErrorLog.getClientErrors()) != null) {
                InfoUtils.printInfos(iInfoBaseArray, infoStream);
            } else {
                infoStream.print("No client errors reported.");
            }
            n = iAgentErrorLog.getNumDroppedClientErrors();
            if (n > 0) {
                infoStream.print(new StringBuffer().append("Client errors dropped: ").append(n).toString());
            }
            infoStream.end();
        }
    }

    private void generateSnapshot(IAgentDiagnosis iAgentDiagnosis, InfoStream infoStream) {
        IAgentSnapshot iAgentSnapshot = iAgentDiagnosis.createSnapshot();
        if (iAgentSnapshot != null) {
            String[] stringArray;
            TraceTimeStamp traceTimeStamp = new TraceTimeStamp(iAgentSnapshot.getTimeStamp());
            infoStream.begin(new StringBuffer().append("Snapshot @").append(traceTimeStamp.toUTCTimeString(true)).toString());
            IInfoBase[] iInfoBaseArray = iAgentSnapshot.getAllProxies();
            if (iInfoBaseArray != null) {
                InfoUtils.printInfos(iInfoBaseArray, infoStream);
            } else {
                infoStream.print("No Proxies found!");
            }
            IInfoBase[] iInfoBaseArray2 = iAgentSnapshot.getAllStubs();
            if (iInfoBaseArray2 != null) {
                InfoUtils.printInfos(iInfoBaseArray2, infoStream);
            } else {
                infoStream.print("No Stubs found!");
            }
            IInfoBase[] iInfoBaseArray3 = iAgentSnapshot.getAllClients();
            if (iInfoBaseArray3 != null) {
                InfoUtils.printInfos(iInfoBaseArray3, infoStream);
            } else {
                infoStream.print("No Clients found!");
            }
            IInfoBase[] iInfoBaseArray4 = iAgentSnapshot.getAllServiceHandlers();
            if (iInfoBaseArray4 != null) {
                InfoUtils.printInfos(iInfoBaseArray4, infoStream);
            } else {
                infoStream.print("No ServiceHandlers found!");
            }
            IInfoBase[] iInfoBaseArray5 = iAgentSnapshot.getAllServiceLocators();
            if (iInfoBaseArray5 != null) {
                InfoUtils.printInfos(iInfoBaseArray5, infoStream);
            } else {
                infoStream.print("No ServiceLocators found!");
            }
            WorkerInfo workerInfo = iAgentSnapshot.getWorker();
            if (workerInfo != null) {
                workerInfo.write(infoStream);
            }
            if ((stringArray = iAgentSnapshot.getAllInfoProviderNames()).length == 0) {
                infoStream.print("No optional Info Providers found!");
            } else {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    IInfoBase[] iInfoBaseArray6 = iAgentSnapshot.getInfoProviderData(stringArray[i2]);
                    InfoUtils.printInfos(iInfoBaseArray6, infoStream);
                }
            }
            infoStream.end();
        }
    }
}

