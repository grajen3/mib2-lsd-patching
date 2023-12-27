/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.recording;

import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdDeactivatePlayer;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.recorder.MediaRecorder;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;

public final class CmdStartImport
extends AbstractCommand {
    private static int TIMEOUT = 6000;
    private static final int EXECUTION_STEP_0_VALIDATE;
    private static final int EXECUTION_STEP_1_PASS_SELECTION_TO_RECORDER;
    private static final int EXECUTION_STEP_2_SUSPEND_OPTICAL_SOURCE;
    private static final int EXECUTION_STEP_3_PROCESS_IMPORT;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;
    private final ISources mSources;
    private final MediaRecorderBrowser mRecorderBrowser;
    private final MediaRecorder mRecorder;
    private final boolean mResume;

    private CmdStartImport(MediaComponents mediaComponents, boolean bl) {
        super(1032, 0, 3, TIMEOUT);
        this.mPlayer = mediaComponents.getPlayer();
        this.mSound = mediaComponents.getSound();
        this.mSources = mediaComponents.getSources();
        this.mRecorderBrowser = mediaComponents.getBrowser_Recorder();
        this.mRecorder = mediaComponents.getRecorder();
        this.mResume = bl;
    }

    public static CmdStartImport createStartCmd(MediaComponents mediaComponents) {
        return new CmdStartImport(mediaComponents, false);
    }

    public static CmdStartImport createResumeCmd(MediaComponents mediaComponents) {
        return new CmdStartImport(mediaComponents, true);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mResume && this.mRecorder.getActiveMedia() == null) {
                    this.mRecorder.retrieveId(this.mSources);
                }
                if (this.mRecorder.getActiveMedia() == null) {
                    this.commandFailed("active recorder media must not be null");
                    return;
                }
                this.info(new StringBuffer().append("import media: ").append(this.mRecorder.getActiveMedia().toStringShort()).toString());
                this.nextStep();
                break;
            }
            case 1: {
                if (this.mResume) {
                    if (this.isTraceEnabled()) {
                        this.trace("step is not executed when resuming import");
                    }
                    this.nextStep();
                    return;
                }
                Selection selection = this.mRecorderBrowser.getSelection();
                if (selection == null || selection.getEntriesSelected() == 0L) {
                    this.commandFailed("selection is null or empty");
                    return;
                }
                this.mRecorder.rqSetSelection(selection, this.NEXT_STEP);
                return;
            }
            case 2: {
                boolean bl;
                MediaCollector mediaCollector = this.mRecorder.getActiveMedia();
                boolean bl2 = mediaCollector.isOpticalMedia() && mediaCollector.isMediaActive();
                boolean bl3 = bl = bl2 && mediaCollector.getMediaType() != 1;
                if (bl2) {
                    if (bl) {
                        this.rqExecuteCmd(new CmdDeactivatePlayer(this.mSound, this.mPlayer, this.mSources, false, false), this.NEXT_STEP);
                        return;
                    }
                    this.mPlayer.ripNPlay();
                }
                this.nextStep();
                break;
            }
            case 3: {
                this.suspendTimer("import running");
                this.mSources.getHDD().setImportedTo(true);
                this.mRecorder.rqStartImport(this.mResume, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onExit() {
        Selection selection;
        this.mSources.getHDD().setImportedTo(false);
        MediaCollector mediaCollector = this.mPlayer.getActiveMedia();
        if (mediaCollector != null && mediaCollector.isHDD() && (selection = this.mPlayer.getPlaySelection()) != null) {
            selection.deprecate();
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "PASS_SELECTION_TO_RECORDER";
            }
            case 2: {
                return "SUSPEND_OPTICAL_SOURCE";
            }
            case 3: {
                return "PROCESS_IMPORT";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("resume:").append(this.mResume).toString();
    }
}

