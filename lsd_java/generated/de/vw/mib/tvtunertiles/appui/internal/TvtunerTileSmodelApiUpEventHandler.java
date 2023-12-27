/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tvtunertiles.appui.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.appui.AbstractModelApiUpEventHandler;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public class TvtunerTileSmodelApiUpEventHandler
extends AbstractModelApiUpEventHandler
implements ModelApiUpEventHandler {
    public TvtunerTileSmodelApiUpEventHandler(AppDefinition appDefinition, StatemachineEventDispatcher statemachineEventDispatcher, ModelDatapool modelDatapool, AppAdapterListItemControlManager appAdapterListItemControlManager) {
        super(appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void onDatapoolUpdate(ModelApiUpEvent modelApiUpEvent) {
        int n = modelApiUpEvent.getActionId();
        switch (n) {
            case 0: {
                this.modelDatapool.setInteger(-36110336, modelApiUpEvent.getInt(0));
                break;
            }
            case 1: {
                this.modelDatapool.setString(27185, modelApiUpEvent.getString(0));
                break;
            }
            case 2: {
                this.modelDatapool.setBoolean(29446, modelApiUpEvent.getBoolean(0));
                break;
            }
            case 3: {
                this.modelDatapool.setBoolean(-219217920, modelApiUpEvent.getBoolean(0));
                break;
            }
            case 4: {
                this.modelDatapool.setBoolean(-622395392, modelApiUpEvent.getBoolean(0));
                break;
            }
            case 5: {
                this.modelDatapool.setBoolean(21784, modelApiUpEvent.getBoolean(0));
                break;
            }
            default: {
                super.onDatapoolUpdate(modelApiUpEvent);
            }
        }
    }
}

