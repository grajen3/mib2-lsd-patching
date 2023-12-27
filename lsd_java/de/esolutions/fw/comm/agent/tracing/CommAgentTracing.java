/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.tracing;

import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;

public interface CommAgentTracing {
    public static final TraceChannel AGENT = TraceClient.createTraceChannel("comm.agent.Agent");
    public static final TraceChannel CONFIG = TraceClient.createTraceChannel("comm.agent.Config");
    public static final TraceChannel BROKER = TraceClient.createTraceChannel("comm.agent.Broker");
    public static final TraceChannel BROKER_SERVICE = TraceClient.createTraceChannel("comm.agent.BrokerService");
    public static final TraceChannel CLIENTPOOL = TraceClient.createTraceChannel("comm.agent.ClientPool");
    public static final TraceChannel TRANSPORTWORKERFACTORY = TraceClient.createTraceChannel("comm.agent.TransportWorkerFactory");
    public static final TraceChannel PROXYSTUBPOOL = TraceClient.createTraceChannel("comm.agent.ProxyStubPool");
    public static final TraceChannel CLIENT = TraceClient.createTraceChannel("comm.agent.Client");
    public static final TraceChannel CLIENT_CALLS = TraceClient.createTraceChannel("comm.agent.Client.Calls");
    public static final TraceChannel DIRECTORY = TraceClient.createTraceChannel("comm.agent.Directory");
    public static final TraceChannel SERVICE = TraceClient.createTraceChannel("comm.agent.Service");
    public static final TraceChannel REGISTRY = TraceClient.createTraceChannel("comm.agent.Registry");
    public static final TraceChannel NOTIFICATION = TraceClient.createTraceChannel("comm.agent.Notify");
    public static final TraceChannel UTIL = TraceClient.createTraceChannel("comm.agent.Util");
    public static final TraceChannel PEER = TraceClient.createTraceChannel("comm.agent.Peer");
    public static final TraceChannel COMM = TraceClient.createTraceChannel("FW.COMM.DataModel");
    public static final TraceChannel MEMORY = TraceClient.createTraceChannel("comm.agent.Memory");
    public static final TraceChannel IKCHECKER = TraceClient.createTraceChannel("comm.agent.IKChecker");
    public static final TraceChannel DIAGNOSIS = TraceClient.createTraceChannel("comm.agent.Diagnosis");
    public static final TraceChannel DOCTOR = TraceClient.createTraceChannel("comm.agent.Doctor");
    public static final TraceChannel PINGHANDLER = TraceClient.createTraceChannel("comm.agent.PingHandler");
    public static final TraceChannel PINGHANDLER_TX = TraceClient.createTraceChannel("comm.agent.PingHandler.Tx");
    public static final TraceChannel PINGHANDLER_RX = TraceClient.createTraceChannel("comm.agent.PingHandler.Rx");
}

