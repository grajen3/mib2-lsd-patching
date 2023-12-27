/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.has;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.util.StringBuilder;
import generated.de.vw.mib.has.contexts.media.MediaResults;

public class CmdExecuteHASAction
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int EXECUTION_STEP_0_EXECUTE_HAS_ACTION;
    private final Command mHasAction;
    private final MediaResults mHASResults;
    private final int mActionId;
    private final int mCallId;

    public CmdExecuteHASAction(Command command, int n, int n2) {
        super(command.getRequiredComponents(), 0, 0, TIMEOUT);
        this.mHasAction = command;
        this.mCallId = n;
        this.mActionId = n2;
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
        this.mHASResults = (MediaResults)hASContext.getResultsImpl();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.rqExecuteCmd(this.mHasAction, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        this.mHasAction.enter();
    }

    @Override
    public void onExit() {
        this.mHasAction.exit();
        switch (this.mActionId) {
            case 6: {
                this.mHASResults.setPlayModeResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 7: {
                this.mHASResults.nextTrackResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 8: {
                this.mHASResults.previousTrackResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 15: {
                this.mHASResults.playMediaResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 16: {
                this.mHASResults.pauseMediaResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 17: {
                this.mHASResults.setTrackPositionResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 19: {
                this.mHASResults.selectMediaBrowserSourceResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 29: {
                this.mHASResults.mediaBrowserPlayResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 32: {
                this.mHASResults.enableMediaBrowserFollowModeResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 33: {
                this.mHASResults.disableMediaBrowserFollowModeResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 35: {
                this.mHASResults.changeMediaBrowserFolderResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            case 36: {
                this.mHASResults.mediaBrowserPlayResult(this.mCallId, this.isCompleted() ? 0 : 1);
                break;
            }
            default: {
                this.error(new StringBuffer().append("Unknown HAS action id! ").append(this.mActionId).toString());
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "Executing HAS action...";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        StringBuilder stringBuilder = new StringBuilder(200);
        return stringBuilder.append("HAS action ").append(this.mActionId).append(", call id: ").append(this.mCallId).append(" mapped to: ").append(this.mHasAction).toString();
    }

    public Command getHASAction() {
        return this.mHasAction;
    }
}

