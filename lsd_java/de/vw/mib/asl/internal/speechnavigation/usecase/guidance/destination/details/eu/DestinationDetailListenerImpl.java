/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.eu;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListener;

public class DestinationDetailListenerImpl
implements DestinationDetailListener {
    private int vdeFallbackCounter;

    @Override
    public void onReEnterAddress(boolean bl) {
        ++this.vdeFallbackCounter;
        if (bl) {
            if (this.vdeFallbackCounter >= 3) {
                this.vdeFallbackCounter = 0;
                DestinationInputCityController.enterCity();
            } else {
                DestinationInputOneShotController.enterOneShotAgain();
            }
        } else {
            Framework.fireEvent(1627789568);
        }
    }

    @Override
    public void onResetCounter() {
        this.vdeFallbackCounter = 0;
    }
}

