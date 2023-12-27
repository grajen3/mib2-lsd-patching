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

public class CmdChooseSourceForImport
extends AbstractCommand {
    private static int TIMEOUT = 0;
    private static final int STEP_0_VALIDATE;
    private static final int STEP_1_PREPARE;
    private static final int STEP_2_SET_IMPORT_MEDIA;
    private static final int STEP_3_SET_IMPORT_QUALITY;
    private static final int STEP_4_DEACTIVATE_MAIN_BROWSER;
    private static final int STEP_5_BROWSE_IMPORT_MEDIA;
    private static final int STEP_6_NOTIFY_RECORDER;
    private final MediaRecorderBrowser mRecorderBrowser;
    private final MediaMainBrowser mMainBrowser;
    private final MediaRecorder mRecorder;
    private final MediaCollector mMedia;

    public CmdChooseSourceForImport(MediaComponents mediaComponents, int n) {
        super(1032, 0, 6, TIMEOUT);
        this.mMedia = mediaComponents.getSources().getSourceByID(n);
        this.mRecorderBrowser = mediaComponents.getBrowser_Recorder();
        this.mMainBrowser = mediaComponents.getBrowser_MainView();
        this.mRecorder = mediaComponents.getRecorder();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mMedia == null || this.mRecorder == null || this.mRecorderBrowser == null) {
                    this.commandFailed("Media, Recorder or Browser is null");
                    return;
                }
                if (this.mRecorder.getRecorderState().isRecorderIdle()) {
                    if (!this.mMedia.isImportPossible()) {
                        MediaObjectAccessor.getModelController().reportMediumNotImportable(this.mMedia.getMedium().getParent());
                        this.commandCompleted("media not importable: popup shown");
                        return;
                    }
                } else {
                    MediaObjectAccessor.getModelController().reportErrorJukeboxSynchronizing();
                    this.commandCompleted("Jukebox not idle: popup shown");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                this.mRecorder.reset();
                this.nextStep();
                break;
            }
            case 2: {
                this.mRecorder.rqSetActiveMedia(this.mMedia, this.NEXT_STEP);
                return;
            }
            case 3: {
                this.mRecorder.rqSetEncodingQuality(this.NEXT_STEP);
                return;
            }
            case 4: {
                this.rqExecuteCmd(new CmdSetupBrowser(this.mMainBrowser, MediaCollector.EMPTY, 0), this.NEXT_STEP);
                return;
            }
            case 5: {
                this.mRecorderBrowser.invalidate("import source init");
                this.rqExecuteCmd(new CmdSetupBrowser(this.mRecorderBrowser, this.mMedia, 0), this.NEXT_STEP);
                return;
            }
            case 6: {
                this.mRecorder.notifyFileSelectionDone(this.mRecorderBrowser.getSelection());
                this.nextStep();
                break;
            }
        }
    }

    @Override
    public void onExit() {
        ServiceManager.aslPropertyManager.valueChangedInteger(2735, 2);
    }

    @Override
    protected String getParameterStr() {
        return this.mMedia.toString();
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "PREPARE";
            }
            case 2: {
                return "SET_IMPORT_MEDIA";
            }
            case 3: {
                return "SET_IMPORT_QUALITY";
            }
            case 4: {
                return "DEACTIVATE_MAIN_BROWSER";
            }
            case 5: {
                return "BROWSE_IMPORT_MEDIA";
            }
            case 6: {
                return "NOTIFY_RECORDER";
            }
        }
        return "UNKNOWN";
    }
}

