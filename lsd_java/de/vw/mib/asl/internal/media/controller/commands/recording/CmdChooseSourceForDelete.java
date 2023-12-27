/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.recording;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser;
import de.vw.mib.asl.internal.media.recorder.MediaRecorder;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public class CmdChooseSourceForDelete
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int STEP_1_SET_RECORDER_MEDIUM;
    private static final int STEP_2_DEACTIVATE_MAIN_BROWSER;
    private static final int STEP_3_SETUP_BROWSER;
    private final MediaRecorderBrowser mRecorderBrowser;
    private final MediaMainBrowser mMainBrowser;
    private final MediaRecorder mRecorder;
    private final MediaCollector mMedia;

    public CmdChooseSourceForDelete(MediaComponents mediaComponents) {
        super(1032, 1, 3, TIMEOUT);
        this.mRecorderBrowser = mediaComponents.getBrowser_Recorder();
        this.mMainBrowser = mediaComponents.getBrowser_MainView();
        this.mRecorder = mediaComponents.getRecorder();
        this.mMedia = mediaComponents.getSources().getHDD();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                if (this.mRecorder.getRecorderState().isRecorderIdle()) {
                    if (this.mMedia == null) {
                        this.commandFailed("passed Media is null");
                        return;
                    }
                } else {
                    MediaObjectAccessor.getModelController().reportErrorJukeboxSynchronizing();
                    this.commandCompleted("Jukebox not idle: popup shown");
                    return;
                }
                this.mRecorderBrowser.invalidate("delete source init");
                ServiceManager.aslPropertyManager.valueChangedString(77, this.mMedia.getName());
                ServiceManager.aslPropertyManager.valueChangedInteger(76, 0);
                this.mRecorder.rqSetActiveMedia(this.mMedia, this.NEXT_STEP);
                return;
            }
            case 2: {
                this.rqExecuteCmd(new CmdSetupBrowser(this.mMainBrowser, MediaCollector.EMPTY, 0), this.NEXT_STEP);
                return;
            }
            case 3: {
                this.rqExecuteCmd(new CmdSetupBrowser(this.mRecorderBrowser, this.mMedia, 1), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onExit() {
        ServiceManager.aslPropertyManager.valueChangedInteger(2734, 2);
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "SET_RECORDER_MEDIUM";
            }
            case 2: {
                return "DEACTIVATE_MAIN_BROWSER";
            }
            case 3: {
                return "SETUP_BROWSER";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return "no parameters";
    }
}

