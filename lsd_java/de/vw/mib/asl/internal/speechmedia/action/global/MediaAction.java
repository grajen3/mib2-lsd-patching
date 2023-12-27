/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.internal.speechmedia.action.global.GenericGlobalAction;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;

public class MediaAction
extends GenericGlobalAction {
    public MediaAction(MediaServiceController mediaServiceController) {
        super(mediaServiceController);
    }

    @Override
    protected int getSuccessEvent() {
        return -1283378688;
    }

    @Override
    protected int getDatapoolValue() {
        return 2;
    }

    @Override
    public int getDownEvent() {
        return -1604701632;
    }

    @Override
    protected boolean doSourceCheck() {
        return false;
    }

    @Override
    protected boolean doSuccess() {
        return true;
    }

    @Override
    public boolean executeAction(int n) {
        if (super.executeAction(4)) {
            this.msController.activate();
            return true;
        }
        return false;
    }
}

