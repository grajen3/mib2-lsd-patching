/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.recording;

import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.recorder.MediaRecorder;

public class CmdSelectActiveFolder
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int EXECUTION_STEP_1_SELECT;
    private static final int EXECUTION_STEP_2_PASS_TO_RECORDER;
    private final MediaRecorderBrowser mBrowser;
    private final MediaRecorder mRecorder;
    private final boolean mSelected;
    private Selection mSelection;

    public CmdSelectActiveFolder(MediaRecorderBrowser mediaRecorderBrowser, MediaRecorder mediaRecorder, boolean bl) {
        super(1032, 1, 2, TIMEOUT);
        this.mBrowser = mediaRecorderBrowser;
        this.mRecorder = mediaRecorder;
        this.mSelected = bl;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                this.mSelection = this.mBrowser.createFolderSelection(PlayMode.UNKNOWN, this.mSelected, true, true);
                this.mBrowser.rqAddSelection(this.mSelection, this.NEXT_STEP);
                return;
            }
            case 2: {
                this.mBrowser.refetch();
                this.mRecorder.notifyFileSelectionDone(this.mSelection);
                this.nextStep();
                break;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "SELECT";
            }
            case 2: {
                return "PASS_TO_RECORDER";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("selected=").append(this.mSelected).toString();
    }
}

