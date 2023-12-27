/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.command.TimerCommand;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.commons.queue.Queue;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;

public class AgentWorker$AgentTimer
implements Runnable {
    private final Queue queue;
    private final int timePulse;
    private Thread timerThread;
    private boolean stay = true;
    private final /* synthetic */ AgentWorker this$0;

    public AgentWorker$AgentTimer(AgentWorker agentWorker, Queue queue, int n) {
        this.this$0 = agentWorker;
        this.queue = queue;
        this.timePulse = n;
    }

    public void start() {
        this.stay = true;
        this.timerThread = new Thread(AgentWorker.access$000(this.this$0).wrap(this), "commTimer");
        this.timerThread.start();
    }

    public void stop() {
        this.stay = false;
        this.timerThread.interrupt();
        try {
            this.timerThread.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    @Override
    public void run() {
        while (this.stay) {
            try {
                Thread.sleep(this.timePulse);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            if (AgentWorker.access$100(this.this$0) != null) {
                AgentWorker.access$100(this.this$0).check();
            }
            try {
                if (!this.queue.put(new TimerCommand())) continue;
                CommAgentTracing.AGENT.log((short)3, "Enqueueing timer command in high water range! queue size=%1", new Integer(this.queue.size()));
            }
            catch (QueueShutdownException queueShutdownException) {
                CommAgentTracing.AGENT.log((short)4, "Timer command: %1", queueShutdownException);
            }
        }
    }
}

