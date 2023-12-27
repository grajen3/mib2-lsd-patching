/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$1;
import de.esolutions.fw.util.tracing.ITraceCallback;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

class AgentCallbacks$DiagnosisReport
implements ITraceCallback {
    private AgentCallbacks$DiagnosisReport() {
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        String string;
        Agent agent = Agent.getAgent();
        if (agent != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            agent.writeDiagnosisReport(printStream);
            try {
                string = byteArrayOutputStream.toString("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                string = byteArrayOutputStream.toString();
                AgentCallbacks.access$000().log((short)4, "DiagnosisReport executeTraceCallback found UnsupportedEncodingException");
            }
        } else {
            string = "DiagnosisReport failed: NO AGENT FOUND!";
        }
        AgentCallbacks.access$000().log((short)2, string);
    }

    /* synthetic */ AgentCallbacks$DiagnosisReport(AgentCallbacks$1 agentCallbacks$1) {
        this();
    }
}

