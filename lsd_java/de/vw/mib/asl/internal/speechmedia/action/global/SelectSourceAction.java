/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.internal.speechmedia.action.global.GenericGlobalAction;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;

public class SelectSourceAction
extends GenericGlobalAction {
    public SelectSourceAction(MediaServiceController mediaServiceController) {
        super(mediaServiceController);
    }

    @Override
    protected int getSuccessEvent() {
        return -1165938176;
    }

    @Override
    protected int getDatapoolValue() {
        return 3;
    }

    @Override
    public int getDownEvent() {
        return -1504038336;
    }

    @Override
    protected boolean doSourceCheck() {
        return false;
    }

    @Override
    protected boolean doSuccess() {
        return false;
    }
}

