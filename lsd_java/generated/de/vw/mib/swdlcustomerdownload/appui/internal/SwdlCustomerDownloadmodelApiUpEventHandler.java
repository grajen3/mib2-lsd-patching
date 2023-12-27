/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.swdlcustomerdownload.appui.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.appui.AbstractModelApiUpEventHandler;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public class SwdlCustomerDownloadmodelApiUpEventHandler
extends AbstractModelApiUpEventHandler
implements ModelApiUpEventHandler {
    public SwdlCustomerDownloadmodelApiUpEventHandler(AppDefinition appDefinition, StatemachineEventDispatcher statemachineEventDispatcher, ModelDatapool modelDatapool, AppAdapterListItemControlManager appAdapterListItemControlManager) {
        super(appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }
}

