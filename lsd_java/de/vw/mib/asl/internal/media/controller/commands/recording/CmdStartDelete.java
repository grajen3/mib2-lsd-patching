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

public class CmdStartDelete
extends AbstractCommand {
    private static int TIMEOUT = 0;
    private static final int EXECUTION_STEP_0_VALIDATE;
    private static final int EXECUTION_STEP_1_PASS_SELECTION_TO_RECORDER;
    private static final int EXECUTION_STEP_2_SUSPEND_SOURCE;
    private static final int EXECUTION_STEP_3_REMOVE_LSM_PLAYMODE;
    private static final int EXECUTION_STEP_4_PROCESS_DELETE;
    private final MediaAudioManager mSound;
    private final MediaPlayer mPlayer;
    private final ISources mSources;
    private final MediaRecorderBrowser mRecorderBrowser;
    private final MediaRecorder mRecorder;
    private final MediaCollector importDestination;

    public CmdStartDelete(MediaComponents mediaComponents) {
        super(1032, 0, 4, TIMEOUT);
        this.mSound = mediaComponents.getSound();
        this.mSources = mediaComponents.getSources();
        this.mPlayer = mediaComponents.getPlayer();
        this.mRecorderBrowser = mediaComponents.getBrowser_Recorder();
        this.mRecorder = mediaComponents.getRecorder();
        this.importDestination = this.mRecorder.getActiveMedia();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.importDestination == null) {
                    this.commandFailed("active recorder media must not be null");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                Selection selection = this.mRecorderBrowser.getSelection();
                if (selection == null || selection.getEntriesSelected() == 0L) {
                    this.commandFailed("selection is null or empty");
                    return;
                }
                this.mRecorder.rqSetSelection(selection, this.NEXT_STEP);
                return;
            }
            case 2: {
                this.mPlayer.removePlaymodeLSM(this.importDestination);
                if (this.importDestination.isMediaActive()) {
                    this.rqExecuteCmd(new CmdDeactivatePlayer(this.mSound, this.mPlayer, this.mSources, false, false), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 3: {
                this.nextStep();
                break;
            }
            case 4: {
                this.mRecorder.rqStartDelete(this.NEXT_STEP);
                return;
            }
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
                return "SUSPEND_SOURCE";
            }
            case 3: {
                return "REMOVE_LSM_PLAYMODE";
            }
            case 4: {
                return "PROCESS_DELETE";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return null;
    }
}

