/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common.lists;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.GenericListHandler;
import de.vw.mib.genericevents.EventGeneric;

public abstract class ApplicationNBestListControllerBase
extends ResultListNBestControllerBase
implements ApplicationErrorHandler,
RecognizedEventConsumer,
ModelEventConsumer {
    private final GenericListHandler listHandler = new GenericListHandler(this);

    protected ApplicationNBestListControllerBase(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onActionFailed() {
        Framework.fireUIEvent(2097689600);
    }

    @Override
    public void onActionNotAvailable() {
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141825: {
                int n2 = eventGeneric.getInt(0);
                super.onSelectSubItem(n2);
                break;
            }
            default: {
                this.listHandler.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141826: {
                super.onSelectItem();
                break;
            }
            case 1077141846: {
                super.onSelectItem(0);
                break;
            }
            case 1077141847: {
                Framework.fireUIEvent(1963471872);
                break;
            }
            default: {
                this.listHandler.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void notifyGroupExpanded(int n) {
        Framework.updateUIValue(1359492096, n);
        Framework.fireUIEvent(2013803520);
    }

    @Override
    public void notifyGroupCollapsed(int n) {
        Framework.updateUIValue(1359492096, -1);
        Framework.fireUIEvent(2030580736);
    }

    @Override
    public void notifyItemSelected() {
        Framework.fireUIEvent(1997026304);
    }

    @Override
    public void notifyRowNumberRecognized(int n) {
        Framework.updateUIValue(1577595904, n);
        Framework.updateUIValue(1376269312, n - 1);
    }
}

