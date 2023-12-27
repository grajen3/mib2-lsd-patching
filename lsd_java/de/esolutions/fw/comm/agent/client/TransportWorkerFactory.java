/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.config.CommConfigTransport;
import de.esolutions.fw.comm.agent.config.CommConfigTransportParams;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.transport.async.TransportWorker;

public class TransportWorkerFactory {
    private CommConfig config;

    public TransportWorkerFactory(CommConfig commConfig) {
        this.config = commConfig;
    }

    public synchronized TransportWorker createTransportWorker(short s) {
        boolean bl;
        if (s == -1) {
            CommAgentTracing.TRANSPORTWORKERFACTORY.log((short)4, "%1: bad process id! ignoring...", new Short(s));
            return null;
        }
        CommConfigTransport commConfigTransport = this.config.getTransport();
        CommConfigTransportParams commConfigTransportParams = commConfigTransport.getTxTransportConfig(s, bl = this.config.getDynamicAgentIdsConfig().isDynamicAgentID(s));
        if (!commConfigTransportParams.getAsync()) {
            CommAgentTracing.TRANSPORTWORKERFACTORY.log((short)1, "%1: no tx worker enabled", new Short(s));
            return null;
        }
        int n = commConfigTransportParams.getPriority();
        int n2 = commConfigTransportParams.getQueueLimitJobs();
        String string = null;
        string = bl ? this.getTxWorkerName(s, "Dyn") : this.getTxWorkerName(s, null);
        CommAgentTracing.TRANSPORTWORKERFACTORY.log((short)1, "%1: create transport worker[%5] ! (prio %2, queueLimitJobs %3 )", new Short(s), (Object)new Integer(n), (Object)new Integer(n2), (Object)string);
        return new TransportWorker(string, n, n2);
    }

    private String getTxWorkerName(Short[] shortArray, String string) {
        Buffer buffer = new Buffer();
        buffer.append("commTx");
        if (string != null) {
            buffer.append(string);
        }
        if (shortArray.length > 0) {
            for (int i2 = 0; i2 < shortArray.length; ++i2) {
                if (shortArray[i2] != null) {
                    buffer.append(shortArray[i2].toString());
                    if (i2 >= shortArray.length - 1) continue;
                    buffer.append('+');
                    continue;
                }
                CommAgentTracing.TRANSPORTWORKERFACTORY.log((short)3, "bad framework.json? maybe tx worker priorites definied for unknown process");
                buffer.append("N/A");
            }
        }
        return buffer.toString();
    }

    private String getTxWorkerName(short s, String string) {
        return this.getTxWorkerName(new Short[]{new Short(s)}, string);
    }
}

