/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action;

import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.Action;
import de.vw.mib.genericevents.EventGeneric;

public class PagingAction
implements Action {
    public static final int NEXT_PAGE_COMMAND;
    public static final int NEXT_PAGE_EVENT;
    public static final int PREV_PAGE_COMMAND;
    public static final int PREV_PAGE_EVENT;
    public static final int FIRST_PAGE_COMMAND;
    public static final int FIRST_PAGE_EVENT;
    public static final int LAST_PAGE_COMMAND;
    public static final int LAST_PAGE_EVENT;

    public PagingAction(ResultControllerRouter resultControllerRouter) {
        resultControllerRouter.register(this, -1487261120, 0);
        resultControllerRouter.register(this, -1470483904, 0);
        resultControllerRouter.register(this, -1453706688, 0);
        resultControllerRouter.register(this, -1436929472, 0);
    }

    @Override
    public void onRecognizedEvent(int n) {
        this.onAction(n);
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        this.onAction(eventGeneric.getReceiverEventId());
    }

    private void onAction(int n) {
        switch (n) {
            case 1077041831: {
                this.fireEvent(-1149160960);
                break;
            }
            case 1077041832: {
                this.fireEvent(-1132383744);
                break;
            }
            case 1077041833: {
                this.fireEvent(-1115606528);
                break;
            }
            case 1077041834: {
                this.fireEvent(-1098829312);
                break;
            }
        }
    }

    private void fireEvent(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    @Override
    public int getDownEvent() {
        return -1;
    }
}

