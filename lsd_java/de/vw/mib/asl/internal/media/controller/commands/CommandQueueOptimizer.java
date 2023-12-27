/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdExecuteBAPAction;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser;
import de.vw.mib.asl.internal.media.controller.commands.has.CmdExecuteHASAction;
import de.vw.mib.collections.ObjectOptHashSet;
import java.util.ArrayList;

public class CommandQueueOptimizer {
    private static final ObjectOptHashSet PLAY_X_REPLACES = new ObjectOptHashSet(4);
    private static final ObjectOptHashSet SET_PLAYBACK_MODE_REPLACES;
    private static final ObjectOptHashSet SOURCE_ACTIVATION_REPLACES_WHITELIST;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$base$CmdStartupMedia;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartDelete;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdDeleteAll;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartImport;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdDeactivatePlayer;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$base$CmdEjectSource;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForDelete;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRequestDummyAudioConnection;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackResume;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction;

    protected void optimizeQueue(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() >= 2) {
            Command command = (Command)arrayList.get(arrayList.size() - 1);
            for (int i2 = arrayList.size() - 2; i2 >= 0; --i2) {
                Command command2 = (Command)arrayList.get(i2);
                if (!this.canBeCanceledBy(command, command2)) continue;
                command2.abort("[optimizer] obsolete command");
            }
        }
    }

    private boolean canBeCanceledBy(Command command, Command command2) {
        if (command == command2) {
            return false;
        }
        Class clazz = command.getCommandType();
        if (command2.isWaiting() && command2.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource) && clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource)) {
            command2.abort(new StringBuffer().append("[optimizer] made obsolete by: ").append(command.getCommandStr(true, false, false, false)).toString());
            return false;
        }
        if (!(command2.getCommandType() != (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause) && command2.getCommandType() != (class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection == null ? (class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.sound.CmdRestoreAudioConnection")) : class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection) || clazz != (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause) && clazz != (class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection == null ? (class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.sound.CmdRestoreAudioConnection")) : class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection))) {
            command2.cancel(new StringBuffer().append("made obsolete by: ").append(command.getCommandStr(true, false, false, false)).toString());
            return false;
        }
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause) || clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackResume == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackResume = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackResume)) {
            return command2.isWaiting() && (command2.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackPause) || command2.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackResume == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackResume = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlaybackResume));
        }
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder) || clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayCurrentFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder) || clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile)) {
            return command2.isWaiting() && PLAY_X_REPLACES.contains(command2.getCommandType());
        }
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode)) {
            return command2.isWaiting() && SET_PLAYBACK_MODE_REPLACES.contains(command2.getCommandType());
        }
        if (this.isSourceChange(command)) {
            CmdSetupBrowser cmdSetupBrowser = this.findCmdBrowserSetup(command2);
            if (cmdSetupBrowser != null && cmdSetupBrowser.isSynchronizingToPlayer()) {
                command2.cancel(new StringBuffer().append("made obsolete by: ").append(command.getCommandStr(true, false, false, false)).toString());
                return false;
            }
            return !SOURCE_ACTIVATION_REPLACES_WHITELIST.contains(command2.getCommandType());
        }
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdTrack2Time")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdTrack2Time) && command.getCommandType() == command2.getCommandType() && command2.isWaiting()) {
            return true;
        }
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings == null ? (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.base.CmdFactorySettings")) : class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings) && IMediaConstants.ESO) {
            return true;
        }
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport == null ? (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.recording.CmdChooseSourceForImport")) : class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport) && command2.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport == null ? (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.recording.CmdChooseSourceForImport")) : class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport)) {
            return true;
        }
        CmdSetupBrowser cmdSetupBrowser = this.findCmdBrowserSetup(command);
        CmdSetupBrowser cmdSetupBrowser2 = this.findCmdBrowserSetup(command2);
        if (cmdSetupBrowser != null && cmdSetupBrowser2 != null && cmdSetupBrowser.getInstanceId() == cmdSetupBrowser2.getInstanceId()) {
            command2.cancel(new StringBuffer().append("made obsolete by: ").append(command.getCommandStr(true, false, false, false)).toString());
        }
        return false;
    }

    private boolean isSourceChange(Command command) {
        Class clazz = command.getCommandType();
        return clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource) || clazz == (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdDeactivatePlayer == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdDeactivatePlayer = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdDeactivatePlayer")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdDeactivatePlayer);
    }

    private CmdSetupBrowser findCmdBrowserSetup(Command command) {
        Command command2;
        CmdSetupBrowser cmdSetupBrowser = null;
        Class clazz = command.getCommandType();
        if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser)) {
            cmdSetupBrowser = (CmdSetupBrowser)command;
        } else if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdExecuteBAPAction")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdExecuteBAPAction)) {
            Command command3 = ((CmdExecuteBAPAction)command).getBAPAction();
            if (command3.getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser)) {
                cmdSetupBrowser = (CmdSetupBrowser)command3;
            }
        } else if (clazz == (class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction == null ? (class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.has.CmdExecuteHASAction")) : class$de$vw$mib$asl$internal$media$controller$commands$has$CmdExecuteHASAction) && (command2 = ((CmdExecuteHASAction)command).getHASAction()).getCommandType() == (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser)) {
            cmdSetupBrowser = (CmdSetupBrowser)command2;
        }
        return cmdSetupBrowser;
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
        PLAY_X_REPLACES.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile);
        PLAY_X_REPLACES.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode);
        PLAY_X_REPLACES.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder);
        PLAY_X_REPLACES.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayCurrentFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayCurrentFolder);
        SET_PLAYBACK_MODE_REPLACES = new ObjectOptHashSet(1);
        SET_PLAYBACK_MODE_REPLACES.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdSetPlaybackMode);
        SOURCE_ACTIVATION_REPLACES_WHITELIST = new ObjectOptHashSet(6);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$base$CmdStartupMedia == null ? (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdStartupMedia = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.base.CmdStartupMedia")) : class$de$vw$mib$asl$internal$media$controller$commands$base$CmdStartupMedia);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdSetupBrowser);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartDelete == null ? (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartDelete = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.recording.CmdStartDelete")) : class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartDelete);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdDeleteAll == null ? (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdDeleteAll = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.recording.CmdDeleteAll")) : class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdDeleteAll);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartImport == null ? (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartImport = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.recording.CmdStartImport")) : class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdStartImport);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdActivateSource);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdDeactivatePlayer == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdDeactivatePlayer = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdDeactivatePlayer")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdDeactivatePlayer);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings == null ? (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.base.CmdFactorySettings")) : class$de$vw$mib$asl$internal$media$controller$commands$base$CmdFactorySettings);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$base$CmdEjectSource == null ? (class$de$vw$mib$asl$internal$media$controller$commands$base$CmdEjectSource = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.base.CmdEjectSource")) : class$de$vw$mib$asl$internal$media$controller$commands$base$CmdEjectSource);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport == null ? (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.recording.CmdChooseSourceForImport")) : class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForImport);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForDelete == null ? (class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForDelete = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.recording.CmdChooseSourceForDelete")) : class$de$vw$mib$asl$internal$media$controller$commands$recording$CmdChooseSourceForDelete);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection == null ? (class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.sound.CmdRestoreAudioConnection")) : class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRestoreAudioConnection);
        SOURCE_ACTIVATION_REPLACES_WHITELIST.add(class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRequestDummyAudioConnection == null ? (class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRequestDummyAudioConnection = CommandQueueOptimizer.class$("de.vw.mib.asl.internal.media.controller.commands.sound.CmdRequestDummyAudioConnection")) : class$de$vw$mib$asl$internal$media$controller$commands$sound$CmdRequestDummyAudioConnection);
    }
}

