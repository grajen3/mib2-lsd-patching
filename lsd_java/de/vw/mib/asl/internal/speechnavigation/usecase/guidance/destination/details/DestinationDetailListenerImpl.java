/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details;

import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListener;

public class DestinationDetailListenerImpl
implements DestinationDetailListener {
    private final ApplicationVariant variantService = new ApplicationVariantImpl();
    private int vdeFallbackCounter;

    @Override
    public void onReEnterAddress(boolean bl) {
        ++this.vdeFallbackCounter;
        if (bl) {
            if (this.vdeFallbackCounter >= 3) {
                this.vdeFallbackCounter = 0;
                if (!this.variantService.isCHNVariant()) {
                    if (this.variantService.isJPNVariant()) {
                        DestinationInputPrefectureController.enterPrefectureFallback();
                    } else {
                        DestinationInputCityController.enterCity();
                    }
                } else if (this.variantService.isCHNVariant()) {
                    DestinationInputOneShotController.enterOneShotAgain();
                }
            } else if (this.variantService.isJPNVariant()) {
                DestinationInputOneShotJpnController.enterOneShotAgain();
            } else {
                DestinationInputOneShotController.enterOneShotAgain();
            }
        } else if (this.variantService.isJPNVariant()) {
            Framework.fireEvent(1627789568);
        } else {
            Framework.fireEvent(1627789568);
        }
    }

    @Override
    public void onResetCounter() {
        this.vdeFallbackCounter = 0;
    }
}

