/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;

class DestinationInputPrefectureController$1
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputPrefectureController this$0;

    DestinationInputPrefectureController$1(DestinationInputPrefectureController destinationInputPrefectureController, int n) {
        this.this$0 = destinationInputPrefectureController;
        this.val$notificationEventId = n;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
        } else if (n == 2) {
            this.this$0.onActionNotSupported();
        } else {
            this.this$0.notifyEnterPrefectureSucceeded(iNavigationLocation, this.val$notificationEventId);
        }
    }
}

