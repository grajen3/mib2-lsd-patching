/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appui;

import de.vw.mib.app.appadapter.list.AppAdapterList;
import de.vw.mib.app.appadapter.list.AppAdapterListUpdateEvent;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.datapool.internal.AppAdapterListItemControl;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.hmi.utils.StringTemplate;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public abstract class AbstractModelApiUpEventHandler
implements ModelApiUpEventHandler {
    private static final int ACTION_ID_APP_ADAPTER_LIST_BIND;
    private static final int ACTION_ID_APP_ADAPTER_LIST_BIND__APP_ADAPTER_LIST;
    private static final int ACTION_ID_APP_ADAPTER_LIST_UPDATE;
    private static final int ACTION_ID_APP_ADAPTER_LIST_UPDATE__APP_ADAPTER_LIST_ID;
    private static final int ACTION_ID_APP_ADAPTER_LIST_UPDATE__UPDATE_EVENT;
    protected final AppDefinition appDefinition;
    protected final StatemachineEventDispatcher eventDispatcher;
    protected final ModelDatapool modelDatapool;
    protected final AppAdapterListItemControlManager appAdapterListItemControlManager;

    protected AbstractModelApiUpEventHandler(AppDefinition appDefinition, StatemachineEventDispatcher statemachineEventDispatcher, ModelDatapool modelDatapool, AppAdapterListItemControlManager appAdapterListItemControlManager) {
        this.appDefinition = appDefinition;
        this.eventDispatcher = statemachineEventDispatcher;
        this.modelDatapool = modelDatapool;
        this.appAdapterListItemControlManager = appAdapterListItemControlManager;
    }

    @Override
    public final void onModelApiUpEvent(ModelApiUpEvent modelApiUpEvent) {
        if (modelApiUpEvent.getActionId() < 0) {
            this.onSpecialModelApiUpEvent(modelApiUpEvent);
        } else if (modelApiUpEvent.getParamCount() == 0) {
            this.onNotification(modelApiUpEvent);
        } else {
            this.onDatapoolUpdate(modelApiUpEvent);
        }
    }

    private void onSpecialModelApiUpEvent(ModelApiUpEvent modelApiUpEvent) {
        switch (modelApiUpEvent.getActionId()) {
            case -1: {
                AppAdapterList appAdapterList = (AppAdapterList)modelApiUpEvent.getObject(0);
                AppAdapterListItemControl appAdapterListItemControl = this.appAdapterListItemControlManager.getListItemControl(appAdapterList.id());
                appAdapterListItemControl.bind(appAdapterList);
                break;
            }
            case -2: {
                int n = modelApiUpEvent.getInt(0);
                AppAdapterListUpdateEvent appAdapterListUpdateEvent = (AppAdapterListUpdateEvent)modelApiUpEvent.getObject(1);
                AppAdapterListItemControl appAdapterListItemControl = this.appAdapterListItemControlManager.getListItemControl(n);
                appAdapterListItemControl.refresh(appAdapterListUpdateEvent);
                break;
            }
            default: {
                this.unsupportedModelApiUpEvent(modelApiUpEvent);
            }
        }
    }

    protected void onNotification(ModelApiUpEvent modelApiUpEvent) {
        this.unsupportedModelApiUpEvent(modelApiUpEvent);
    }

    protected void onDatapoolUpdate(ModelApiUpEvent modelApiUpEvent) {
        this.unsupportedModelApiUpEvent(modelApiUpEvent);
    }

    private void unsupportedModelApiUpEvent(ModelApiUpEvent modelApiUpEvent) {
        Integer n = new Integer(modelApiUpEvent.getActionId());
        Integer n2 = new Integer(modelApiUpEvent.getParamCount());
        String string = this.appDefinition.getAppName();
        String string2 = this.appDefinition.getAppInstanceName();
        String string3 = "Unknown action ID '%s' with %s parameter(s) for app '%s:%s' received. AppAdapterProxy mismatch.";
        throw new IllegalArgumentException(StringTemplate.format(string3, new Object[]{n, n2, string, string2}));
    }
}

