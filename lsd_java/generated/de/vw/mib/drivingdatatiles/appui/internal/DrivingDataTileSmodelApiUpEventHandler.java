/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.drivingdatatiles.appui.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.appui.AbstractModelApiUpEventHandler;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public class DrivingDataTileSmodelApiUpEventHandler
extends AbstractModelApiUpEventHandler
implements ModelApiUpEventHandler {
    public DrivingDataTileSmodelApiUpEventHandler(AppDefinition appDefinition, StatemachineEventDispatcher statemachineEventDispatcher, ModelDatapool modelDatapool, AppAdapterListItemControlManager appAdapterListItemControlManager) {
        super(appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void onDatapoolUpdate(ModelApiUpEvent modelApiUpEvent) {
        int n = modelApiUpEvent.getActionId();
        switch (n) {
            case 0: {
                this.modelDatapool.setBoolean(-621215744, modelApiUpEvent.getBoolean(0));
                break;
            }
            case 1: {
                this.modelDatapool.setInteger(614006784, modelApiUpEvent.getInt(0));
                break;
            }
            case 2: {
                this.modelDatapool.setInteger(-1332936704, modelApiUpEvent.getInt(0));
                break;
            }
            case 3: {
                this.modelDatapool.setBoolean(1760296960, modelApiUpEvent.getBoolean(0));
                this.modelDatapool.setBoolean(-2004484096, modelApiUpEvent.getBoolean(1));
                this.modelDatapool.setBoolean(908525824, modelApiUpEvent.getBoolean(2));
                this.modelDatapool.setBoolean(-135397376, modelApiUpEvent.getBoolean(3));
                break;
            }
            case 4: {
                this.modelDatapool.setIntegerVector(12690, (int[])modelApiUpEvent.getObject(0));
                this.modelDatapool.setIntegerVector(972816384, (int[])modelApiUpEvent.getObject(2));
                break;
            }
            case 5: {
                this.modelDatapool.setIntegerVector(-1477181440, (int[])modelApiUpEvent.getObject(0));
                this.modelDatapool.setIntegerVector(-876675072, (int[])modelApiUpEvent.getObject(2));
                break;
            }
            case 6: {
                this.modelDatapool.setIntegerVector(16807, (int[])modelApiUpEvent.getObject(0));
                this.modelDatapool.setIntegerVector(-914161664, (int[])modelApiUpEvent.getObject(2));
                break;
            }
            default: {
                super.onDatapoolUpdate(modelApiUpEvent);
            }
        }
    }
}

