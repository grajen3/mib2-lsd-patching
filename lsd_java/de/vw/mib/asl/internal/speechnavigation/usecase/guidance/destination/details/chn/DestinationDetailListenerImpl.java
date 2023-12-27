/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.chn;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListener;

public class DestinationDetailListenerImpl
implements DestinationDetailListener {
    @Override
    public void onReEnterAddress(boolean bl) {
        if (bl) {
            DestinationInputOneShotController.enterOneShotAgain();
        } else {
            Framework.fireEvent(1627789568);
        }
    }

    @Override
    public void onResetCounter() {
    }
}

