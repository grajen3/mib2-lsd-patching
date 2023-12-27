/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$1;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.tracing.ITraceCallback;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

class AgentCallbacks$DoctorShellCommand
implements ITraceCallback {
    private final /* synthetic */ AgentCallbacks this$0;

    private AgentCallbacks$DoctorShellCommand(AgentCallbacks agentCallbacks) {
        this.this$0 = agentCallbacks;
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        String string;
        String string2 = new String(byArray);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println(new StringBuffer().append(AgentCallbacks.access$100(this.this$0).getPrompt()).append(string2).toString());
        AgentCallbacks.access$100(this.this$0).handleCommand(string2, printStream);
        try {
            string = byteArrayOutputStream.toString("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string = byteArrayOutputStream.toString();
            AgentCallbacks.access$000().log((short)4, "DoctorShellCommand executeTraceCallback found UnsupportedEncodingException");
        }
        CommAgentTracing.DOCTOR.log((short)2, string);
    }

    /* synthetic */ AgentCallbacks$DoctorShellCommand(AgentCallbacks agentCallbacks, AgentCallbacks$1 agentCallbacks$1) {
        this(agentCallbacks);
    }
}

