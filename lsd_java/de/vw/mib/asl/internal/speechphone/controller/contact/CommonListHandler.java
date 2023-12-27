/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListController;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;

public class CommonListHandler
implements RecognizedEventConsumer,
ModelEventConsumer {
    private final ResultListController controller;
    private int absoluteIndex;
    private final SpeechPhoneLogger2 logger;
    private final ServiceFunctions serviceFunctions;

    public CommonListHandler(ServiceFunctions serviceFunctions, ResultListController resultListController) {
        this.serviceFunctions = serviceFunctions;
        this.controller = resultListController;
        this.logger = serviceFunctions.createLogger("CommonListHandler");
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077641872: {
                this.absoluteIndex = eventGeneric.getInt(0);
                this.controller.onSelectItem(this.absoluteIndex);
                break;
            }
            default: {
                this.logger.error(new StringBuffer().append("unhandled model event: ").append(n).append(" passed via ").append(this.controller.toString()).toString());
            }
        }
    }

    public int getAbsoluteIndex() {
        return this.absoluteIndex;
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077641852: {
                this.controller.onRecognizeRowNumber();
                break;
            }
            case 1077641864: {
                this.serviceFunctions.sendHMIEvent(-1532413184);
                break;
            }
            case 1077641865: {
                this.serviceFunctions.sendHMIEvent(-1515635968);
                break;
            }
            case 1077641866: {
                this.serviceFunctions.sendHMIEvent(-1482081536);
                break;
            }
            case 1077641867: {
                this.serviceFunctions.sendHMIEvent(-1498858752);
                break;
            }
            default: {
                this.logger.error(new StringBuffer().append("unhandled recognized event: ").append(n).toString());
            }
        }
    }

    public Object getSelectedItem() {
        Object[] objectArray = this.serviceFunctions.getListObjects(this.controller.getListIdSelectedItem());
        if (objectArray == null) {
            this.logger.error("Item selected but ASL list is still empty. Sending error to model to prevent hang.");
            this.serviceFunctions.sendHMIEvent(-1968620800);
            return null;
        }
        return objectArray[0];
    }
}

