/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.navinfotile.appui.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.appui.AbstractModelApiUpEventHandler;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public class NavInfoTileModelApiUpEventHandler
extends AbstractModelApiUpEventHandler
implements ModelApiUpEventHandler {
    public NavInfoTileModelApiUpEventHandler(AppDefinition appDefinition, StatemachineEventDispatcher statemachineEventDispatcher, ModelDatapool modelDatapool, AppAdapterListItemControlManager appAdapterListItemControlManager) {
        super(appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void onDatapoolUpdate(ModelApiUpEvent modelApiUpEvent) {
        int n = modelApiUpEvent.getActionId();
        switch (n) {
            case 0: {
                this.modelDatapool.setInteger(1730150656, modelApiUpEvent.getInt(0));
                break;
            }
            case 1: {
                this.modelDatapool.setInteger(-283246336, modelApiUpEvent.getInt(0));
                break;
            }
            default: {
                super.onDatapoolUpdate(modelApiUpEvent);
            }
        }
    }
}

