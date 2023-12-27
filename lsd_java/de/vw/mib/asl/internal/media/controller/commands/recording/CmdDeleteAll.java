/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.recording;

import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdStartDelete;
import de.vw.mib.asl.internal.media.playback.PlayMode;

public class CmdDeleteAll
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int EXECUTION_STEP_1_SELECT_ALL;
    private static final int EXECUTION_STEP_2_PASS_TO_RECORDER;
    private final MediaRecorderBrowser mBrowser;
    private Selection mSelection;
    private final CmdStartDelete cmdStartDelete;

    public CmdDeleteAll(MediaComponents mediaComponents) {
        super(1032, 1, 2, TIMEOUT);
        this.mBrowser = mediaComponents.getBrowser_Recorder();
        this.cmdStartDelete = new CmdStartDelete(mediaComponents);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                this.mSelection = this.mBrowser.createFolderSelection(PlayMode.UNKNOWN, true, true, false);
                this.mBrowser.rqAddSelection(this.mSelection, this.NEXT_STEP);
                return;
            }
            case 2: {
                this.rqExecuteCmd(this.cmdStartDelete, this.NEXT_STEP);
                return;
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
                return "SUSPEND_SOURCE";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return "no parameters";
    }
}

