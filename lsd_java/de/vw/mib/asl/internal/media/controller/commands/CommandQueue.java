/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.CommandQueueOptimizer;
import de.vw.mib.asl.internal.media.controller.commands.CommandStateListener;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdExecuteBAPAction;
import de.vw.mib.asl.internal.media.controller.commands.has.CmdExecuteHASAction;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode;
import de.vw.mib.collections.ObjectOptHashSet;
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
    private static final ObjectOptHashSet SEEK_BLACK_LIST;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaySimilar;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSkip;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSeek;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction;

    private boolean isValidCommand(Command command) {
        boolean bl = (SEEK_BLACK_LIST.contains(command.getCommandType()) || this.findPlayFile(command) != null || this.findSetPlaybackMode(command) != null) && this.contains(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSeek == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSeek = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSeek")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSeek);
        boolean bl2 = command.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings == null ? (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.base.CmdFactorySettings")) : class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings) && this.contains(class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings == null ? (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.base.CmdFactorySettings")) : class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings);
        return !bl && !bl2;
    }

    private boolean contains(Class clazz) {
        for (int i2 = 0; i2 < this.mQueue.size(); ++i2) {
            Command command = (Command)this.mQueue.get(i2);
            if (command.getCommandType() != clazz) continue;
            return true;
        }
        return false;
    }

    private CmdPlayFile findPlayFile(Command command) {
        Command command2;
        CmdPlayFile cmdPlayFile = null;
        Class clazz = command.getCommandType();
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile)) {
            cmdPlayFile = (CmdPlayFile)command;
        } else if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdExecuteBAPAction")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction)) {
            Command command3 = ((CmdExecuteBAPAction)command).getBAPAction();
            if (command3.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile)) {
                cmdPlayFile = (CmdPlayFile)command3;
            }
        } else if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction == null ? (class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.has.CmdExecuteHASAction")) : class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction) && (command2 = ((CmdExecuteHASAction)command).getHASAction()).getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile)) {
            cmdPlayFile = (CmdPlayFile)command2;
        }
        return cmdPlayFile;
    }

    private CmdSetPlaybackMode findSetPlaybackMode(Command command) {
        Command command2;
        CmdSetPlaybackMode cmdSetPlaybackMode = null;
        Class clazz = command.getCommandType();
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode)) {
            cmdSetPlaybackMode = (CmdSetPlaybackMode)command;
        } else if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdExecuteBAPAction")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction)) {
            Command command3 = ((CmdExecuteBAPAction)command).getBAPAction();
            if (command3.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode)) {
                cmdSetPlaybackMode = (CmdSetPlaybackMode)command3;
            }
        } else if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction == null ? (class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.has.CmdExecuteHASAction")) : class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction) && (command2 = ((CmdExecuteHASAction)command).getHASAction()).getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode)) {
            cmdSetPlaybackMode = (CmdSetPlaybackMode)command2;
        }
        return cmdSetPlaybackMode;
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
                ServiceManager.logger.error(1024, new StringBuffer().append("clear QUEUE because MAX Elements (30) reached: ").append(this.toString()).toString());
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
        command.setCommandStateListener(this);
        try {
            command.enter();
            this.mQueue.add(command);
            this.traceQueue(new StringBuffer().append(" inserted #").append(command.getSequenceNumber()).append(" ").toString());
        }
        catch (Exception exception) {
            ServiceManager.logger.error(1024, "Insertion failed! ", exception);
            command.abort(new StringBuffer().append("aborted while queue insertion: ").append(exception).toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyCommandStateChanged(Command command) {
        try {
            this.traceQueue(new StringBuffer().append("  state   #").append(command.getSequenceNumber()).append(" ").toString());
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
        this.traceQueue(new StringBuffer().append(" removed  #").append(command.getSequenceNumber()).append(" ").toString());
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
        ServiceManager.logger.trace(1024, new StringBuffer().append("QUEUE Execute = ").append(command).toString() != null ? command.toString() : "");
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
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            String string2 = "";
            string2 = new StringBuffer().append("( ").append(string).append(") ").toString();
            ServiceManager.logger.trace(1024, new StringBuffer().append("QUEUE ").append(string2).append(this.toString()).toString());
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
                string = new StringBuffer().append(string).append(command.getCommandStr(true, true, false, false)).append(", ").toString();
            }
            string = string.length() > 0 ? string.substring(0, string.length() - ", ".length()) : "empty";
            string = new StringBuffer().append("{ ").append(string).append(" } ").toString();
        }
        string = new StringBuffer().append(string).append(MediaComponents.getComponentsStr(this.mLockedComponentMask)).append(" ").toString();
        return string;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SEEK_BLACK_LIST = new ObjectOptHashSet(5);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayCurrentFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaySimilar == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaySimilar = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaySimilar")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaySimilar);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSkip == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSkip = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSkip")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSkip);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdTrack2Time")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time);
        SEEK_BLACK_LIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSeek == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSeek = CommandQueue.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSeek")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSeek);
    }
}

