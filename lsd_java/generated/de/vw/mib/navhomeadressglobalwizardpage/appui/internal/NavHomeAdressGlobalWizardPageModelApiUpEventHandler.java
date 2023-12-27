/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.navhomeadressglobalwizardpage.appui.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.appui.AbstractModelApiUpEventHandler;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public class NavHomeAdressGlobalWizardPageModelApiUpEventHandler
extends AbstractModelApiUpEventHandler
implements ModelApiUpEventHandler {
    public NavHomeAdressGlobalWizardPageModelApiUpEventHandler(AppDefinition appDefinition, StatemachineEventDispatcher statemachineEventDispatcher, ModelDatapool modelDatapool, AppAdapterListItemControlManager appAdapterListItemControlManager) {
        super(appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void onNotification(ModelApiUpEvent modelApiUpEvent) {
        int n = modelApiUpEvent.getActionId();
        switch (n) {
            case 2: {
                this.eventDispatcher.createAndSubmitHMIEvent(this.appDefinition, this.appDefinition, -1571254967);
                break;
            }
            default: {
                super.onNotification(modelApiUpEvent);
            }
        }
    }

    @Override
    protected void onDatapoolUpdate(ModelApiUpEvent modelApiUpEvent) {
        int n = modelApiUpEvent.getActionId();
        switch (n) {
            case 0: {
                this.modelDatapool.setInteger(27618, modelApiUpEvent.getInt(0));
                break;
            }
            case 1: {
                this.modelDatapool.setBoolean(1846411520, modelApiUpEvent.getBoolean(0));
                break;
            }
            default: {
                super.onDatapoolUpdate(modelApiUpEvent);
            }
        }
    }
}

