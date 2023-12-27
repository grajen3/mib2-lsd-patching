/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.commands;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.common.commands.Command;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandQueueOptimizer;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandStateListener;
import de.vw.mib.asl.internal.mediacontrol.services.Components;
import de.vw.mib.util.Util;
import java.util.ArrayList;

public class CommandQueue
implements CommandStateListener {
    private long mLastAssignedSequenceNumber = 0L;
    private static final int INITIAL_QUE_CAPACITY;
    private static final int MAX_QUE_ELEMENTS;
    private final ArrayList mQueue = new ArrayList(5);
    private final CommandQueueOptimizer mOptimizer = new CommandQueueOptimizer();
    private int mLockedComponentMask = 0;

    private boolean isValidCommand(Command command) {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addCommand(Command command) {
        if (!this.isValidCommand(command)) {
            command.abort("[queue] invalid command ");
            return;
        }
        try {
            if (this.mQueue.size() >= 30) {
                ServiceManager.logger.error(8, new StringBuffer().append("clear QUEUE because MAX Elements (30) reached: ").append(this.toString()).toString());
                this.mQueue.clear();
                this.mLockedComponentMask = 0;
            }
            this.insertCmd(command);
            if (this.mOptimizer != null) {
                this.mOptimizer.optimizeQueue(this.mQueue);
            }
        }
        finally {
            this.executeNextCmdIfAvailable();
        }
    }

    private void insertCmd(Command command) {
        command.setExecutionDepth(0);
        command.setSequenceNumber(this.mLastAssignedSequenceNumber++);
        command.enter();
        this.mQueue.add(command);
        command.setCommandStateListener(this);
        this.traceQueue(" inserted ");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyCommandStateChanged(Command command) {
        try {
            this.traceQueue("  state   ");
            if (command.isTerminated()) {
                this.removeCmd(command);
            }
        }
        finally {
            this.executeNextCmdIfAvailable();
        }
    }

    private void removeCmd(Command command) {
        command.exit();
        if (Util.isNullOrEmpty(this.mQueue)) {
            return;
        }
        command.setCommandStateListener(null);
        this.mQueue.remove(command);
        this.updateLockedComponentMask();
        this.traceQueue(" removed  ");
    }

    private void executeNextCmdIfAvailable() {
        if (!Util.isNullOrEmpty(this.mQueue)) {
            for (int i2 = 0; i2 < this.mQueue.size(); ++i2) {
                int n;
                Command command = (Command)this.mQueue.get(i2);
                if (!command.isWaiting() || this.isComponentLocked(n = command.getRequiredComponents())) continue;
                this.lockComponents(n);
                this.executeCmd(command);
            }
        }
    }

    private void executeCmd(Command command) {
        ServiceManager.logger.trace(8, new StringBuffer().append("QUEUE Execute = ").append(command).toString() != null ? command.toString() : "");
        if (command == null) {
            return;
        }
        if (!command.isWaiting()) {
            return;
        }
        command.execute();
    }

    private boolean isComponentLocked(int n) {
        return (n & this.mLockedComponentMask) != 0;
    }

    private void lockComponents(int n) {
        this.mLockedComponentMask |= n;
    }

    private void updateLockedComponentMask() {
        int n = 0;
        for (int i2 = 0; i2 < this.mQueue.size(); ++i2) {
            Command command = (Command)this.mQueue.get(i2);
            if (!command.isExecuting()) continue;
            n |= command.getRequiredComponents();
        }
        this.mLockedComponentMask = n;
    }

    private void traceQueue(String string) {
        if (ServiceManager.logger.isTraceEnabled(8)) {
            String string2 = "";
            string2 = new StringBuffer().append("( ").append(string).append(") ").toString();
            ServiceManager.logger.trace(8, new StringBuffer().append("QUEUE ").append(string2).append(this.toString()).toString());
        }
    }

    public String toString() {
        String string = "null";
        String string2 = ", ";
        ArrayList arrayList = this.mQueue;
        if (arrayList != null) {
            string = "";
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                Command command = (Command)arrayList.get(i2);
                string = new StringBuffer().append(string).append(command.getCommandStr(true, true, false, false)).append(string2).toString();
            }
            string = string.length() > 0 ? string.substring(0, string.length() - string2.length()) : "empty";
            string = new StringBuffer().append("{ ").append(string).append(" } ").toString();
        }
        string = new StringBuffer().append(string).append(Components.getComponentsStr(this.mLockedComponentMask)).append(" ").toString();
        return string;
    }
}

