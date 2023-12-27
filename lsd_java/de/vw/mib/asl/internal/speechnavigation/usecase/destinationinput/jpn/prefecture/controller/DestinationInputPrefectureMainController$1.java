/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureMainController;

class DestinationInputPrefectureMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputPrefectureMainController this$0;

    DestinationInputPrefectureMainController$1(DestinationInputPrefectureMainController destinationInputPrefectureMainController) {
        this.this$0 = destinationInputPrefectureMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 0) {
            try {
                this.this$0.checkCountrySupported();
                StartEntryMode.setMode(9);
                DestinationInputPrefectureController.enterPrefecture();
            }
            catch (NavigationServiceException navigationServiceException) {
                AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(" ").append(navigationServiceException.getMessage()).toString());
                this.this$0.onActionNotAvailable();
            }
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

