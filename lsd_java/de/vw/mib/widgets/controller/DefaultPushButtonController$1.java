/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultPushButtonController;
import de.vw.mib.widgets.models.ButtonModel;

class DefaultPushButtonController$1
implements Runnable {
    private final /* synthetic */ DefaultPushButtonController this$0;

    DefaultPushButtonController$1(DefaultPushButtonController defaultPushButtonController) {
        this.this$0 = defaultPushButtonController;
    }

    @Override
    public void run() {
        ButtonModel buttonModel = (ButtonModel)this.this$0.getWidget();
        if (buttonModel.isActivatedInternal() != buttonModel.is_activated()) {
            buttonModel.setActivatedInternal(buttonModel.is_activated());
            if (AbstractWidgetController.LOGGER.isTraceEnabled(8)) {
                LogMessage logMessage = AbstractWidgetController.LOGGER.trace(8);
                logMessage.append(buttonModel.getQualifiedName()).append(": predictive activation timed out. Internal activation flag set to '").append(buttonModel.isActivatedInternal()).append("'").log();
            }
        }
    }
}

