/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.browsing;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserCurrentActionStatusCollector;

public class CmdExecuteBAPAction
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int EXECUTION_STEP_0_VALIDATE;
    private static final int EXECUTION_STEP_1_EXECUTE_BAP_ACTION;
    private final Command mBapAction;
    private static final GenericASLList CURRENT_ACTION_STATUS;
    private final AVDCAudioBapMediaBrowserCurrentActionStatusCollector[] bapActionStatusObjects;

    public CmdExecuteBAPAction(Command command, int n) {
        super(command.getRequiredComponents(), 0, 1, TIMEOUT);
        this.mBapAction = command;
        this.bapActionStatusObjects = (AVDCAudioBapMediaBrowserCurrentActionStatusCollector[])CURRENT_ACTION_STATUS.getDSIObjects();
        this.bapActionStatusObjects[0].avdc_audio_bap_mediabrowser_action_type = n;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.bapActionStatusObjects[0].avdc_audio_bap_mediabrowser_action_status = 2;
                CURRENT_ACTION_STATUS.updateList(this.bapActionStatusObjects);
                this.nextStep();
                break;
            }
            case 1: {
                this.rqExecuteCmd(this.mBapAction, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onExit() {
        this.bapActionStatusObjects[0].avdc_audio_bap_mediabrowser_action_status = this.isCompleted() ? 1 : 3;
        CURRENT_ACTION_STATUS.updateList(this.bapActionStatusObjects);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(556);
    }

    @Override
    protected String getStepStr(int n) {
        return null;
    }

    @Override
    protected String getParameterStr() {
        return null;
    }

    public Command getBAPAction() {
        return this.mBapAction;
    }

    static {
        CURRENT_ACTION_STATUS = ListManager.getGenericASLList(3834);
    }
}

