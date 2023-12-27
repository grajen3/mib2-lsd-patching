/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tunerautostoreglobalwizardpage.appui.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.appui.AbstractModelApiUpEventHandler;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public class TunerAutostoreGlobalWizardPageModelApiUpEventHandler
extends AbstractModelApiUpEventHandler
implements ModelApiUpEventHandler {
    public TunerAutostoreGlobalWizardPageModelApiUpEventHandler(AppDefinition appDefinition, StatemachineEventDispatcher statemachineEventDispatcher, ModelDatapool modelDatapool, AppAdapterListItemControlManager appAdapterListItemControlManager) {
        super(appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void onNotification(ModelApiUpEvent modelApiUpEvent) {
        int n = modelApiUpEvent.getActionId();
        switch (n) {
            case 3: {
                this.eventDispatcher.createAndSubmitHMIEvent(this.appDefinition, this.appDefinition, -1118270135);
                break;
            }
            case 4: {
                this.eventDispatcher.createAndSubmitHMIEvent(this.appDefinition, this.appDefinition, -1101492919);
                break;
            }
            case 5: {
                this.eventDispatcher.createAndSubmitHMIEvent(this.appDefinition, this.appDefinition, -1084715703);
                break;
            }
            case 6: {
                this.eventDispatcher.createAndSubmitHMIEvent(this.appDefinition, this.appDefinition, -1067938487);
                break;
            }
            case 7: {
                this.eventDispatcher.createAndSubmitHMIEvent(this.appDefinition, this.appDefinition, -1017606839);
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
                this.modelDatapool.setInteger(32027, modelApiUpEvent.getInt(0));
                break;
            }
            default: {
                super.onDatapoolUpdate(modelApiUpEvent);
            }
        }
    }
}

