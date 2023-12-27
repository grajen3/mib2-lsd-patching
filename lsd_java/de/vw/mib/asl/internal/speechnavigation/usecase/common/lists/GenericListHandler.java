/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common.lists;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListController;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.genericevents.EventGeneric;

public class GenericListHandler
implements RecognizedEventConsumer,
ModelEventConsumer {
    private final ResultListController controller;

    public GenericListHandler(ResultListController resultListController) {
        this.controller = resultListController;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141824: {
                int n2 = eventGeneric.getInt(0);
                this.controller.onSelectItem(n2);
                break;
            }
            default: {
                AppLogger.error(this, new StringBuffer().append(".onEvent( event = ").append(eventGeneric.toString()).append(" ), is not handled.").toString());
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141848: {
                this.controller.onRecognizeRowNumber();
                break;
            }
            case 1077141842: {
                Framework.fireUIEvent(1896363008);
                break;
            }
            case 1077141849: {
                Framework.fireUIEvent(1913140224);
                break;
            }
            case 1077141844: {
                Framework.fireUIEvent(1929917440);
                break;
            }
            case 1077141845: {
                Framework.fireUIEvent(1946694656);
                break;
            }
            default: {
                AppLogger.error(this, new StringBuffer().append(".onRecognizedEvent( event = ").append(n).append(" ), is not handled.").toString());
            }
        }
    }
}

