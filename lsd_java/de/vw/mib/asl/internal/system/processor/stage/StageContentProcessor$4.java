/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;

class StageContentProcessor$4
extends ValetParkingListenerAdapter {
    private final /* synthetic */ StageContentProcessor this$0;

    StageContentProcessor$4(StageContentProcessor stageContentProcessor) {
        this.this$0 = stageContentProcessor;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.this$0.processNewValetparkingState(bl);
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

