/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$DiagnosisReport;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$DisconnectPeer;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$DoctorShellCommand;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$FloaterFlushCommand;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$FloaterWasteCommand;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$PingControlCallback;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$SuicideCommand;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$TracePeer;
import de.esolutions.fw.util.commons.error.Floater;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;

public class AgentCallbacks {
    private static TraceChannel channel = new TraceChannel("comm.agent.Callback");
    private int disconnectPeerId;
    private int tracePeerId;
    private int diagReportId;
    private int doctorCallId;
    private int suicideId;
    private int floaterWasteCallId;
    private int floaterFlushCallId;
    private int pingControlCallId;
    private final DoctorShell shell = new DoctorShell();
    private final Floater floater = new Floater();

    public void register() {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            AgentCallbacks$DisconnectPeer agentCallbacks$DisconnectPeer = new AgentCallbacks$DisconnectPeer(null);
            this.disconnectPeerId = traceClient.registerCallback("comm_disconnectPeer", agentCallbacks$DisconnectPeer);
            AgentCallbacks$TracePeer agentCallbacks$TracePeer = new AgentCallbacks$TracePeer(null);
            this.tracePeerId = traceClient.registerCallback("comm_tracePeer", agentCallbacks$TracePeer);
            AgentCallbacks$DiagnosisReport agentCallbacks$DiagnosisReport = new AgentCallbacks$DiagnosisReport(null);
            this.diagReportId = traceClient.registerCallback("comm_diagnosis", agentCallbacks$DiagnosisReport);
            AgentCallbacks$DoctorShellCommand agentCallbacks$DoctorShellCommand = new AgentCallbacks$DoctorShellCommand(this, null);
            this.doctorCallId = traceClient.registerCallback("comm_doctor", agentCallbacks$DoctorShellCommand);
            AgentCallbacks$SuicideCommand agentCallbacks$SuicideCommand = new AgentCallbacks$SuicideCommand(this, null);
            this.suicideId = traceClient.registerCallback("vm_suicide", agentCallbacks$SuicideCommand);
            AgentCallbacks$FloaterWasteCommand agentCallbacks$FloaterWasteCommand = new AgentCallbacks$FloaterWasteCommand(this, null);
            this.floaterWasteCallId = traceClient.registerCallback("floater_waste", agentCallbacks$FloaterWasteCommand);
            AgentCallbacks$FloaterFlushCommand agentCallbacks$FloaterFlushCommand = new AgentCallbacks$FloaterFlushCommand(this, null);
            this.floaterFlushCallId = traceClient.registerCallback("floater_flush", agentCallbacks$FloaterFlushCommand);
            AgentCallbacks$PingControlCallback agentCallbacks$PingControlCallback = new AgentCallbacks$PingControlCallback(null);
            this.pingControlCallId = traceClient.registerCallback("ping_control", agentCallbacks$PingControlCallback);
        }
    }

    public void unregister() {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            traceClient.unregisterCallback(this.disconnectPeerId);
            traceClient.unregisterCallback(this.tracePeerId);
            traceClient.unregisterCallback(this.diagReportId);
            traceClient.unregisterCallback(this.doctorCallId);
            traceClient.unregisterCallback(this.suicideId);
            traceClient.unregisterCallback(this.pingControlCallId);
            traceClient.unregisterCallback(this.floaterWasteCallId);
            traceClient.unregisterCallback(this.floaterFlushCallId);
        }
    }

    static /* synthetic */ TraceChannel access$000() {
        return channel;
    }

    static /* synthetic */ DoctorShell access$100(AgentCallbacks agentCallbacks) {
        return agentCallbacks.shell;
    }

    static /* synthetic */ Floater access$200(AgentCallbacks agentCallbacks) {
        return agentCallbacks.floater;
    }
}

