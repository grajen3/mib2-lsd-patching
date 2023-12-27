/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListenerAdapter;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelStateActive;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.util.Util;

class CoreServiceModelStateActive$1
extends NavigationOnlinePoiListenerAdapter {
    private final /* synthetic */ CoreServiceModelStateActive this$0;

    CoreServiceModelStateActive$1(CoreServiceModelStateActive coreServiceModelStateActive) {
        this.this$0 = coreServiceModelStateActive;
    }

    @Override
    public void updateDynPoi2ServiceID(int n, String string) {
        if (CoreServiceFactory.getCoreService() != null && !Util.isNullOrEmpty(string)) {
            CoreServiceFactory.getCoreService().checkServiceStatus(CoreServiceModelFactory.getPropertyManager().setPrecheckServiceID(string), CoreServiceModelFactory.getPropertyManager().setPrecheckUser(CoreServiceModelFactory.getCoreServiceModelController(this.this$0.getTarget()).getMainUser()), this.this$0.getTarget());
            try {
                this.this$0.trans(this.this$0.getTarget().getAuthenticationState());
                this.this$0.getTarget().getHsm().activateTransition();
            }
            catch (Exception exception) {
                this.this$0.getTarget().error(exception);
            }
        } else {
            CoreServiceModelFactory.getPropertyManager().setPrecheckServiceID(string != null ? string : "");
            CoreServiceModelFactory.getPropertyManager().setPrecheckResult(59);
            CoreServiceModelFactory.getCoreServiceModelController(this.this$0.getTarget()).serviceStatusResult(CoreServiceModelFactory.getPropertyManager().getPrecheckServiceID(), CoreServiceModelFactory.getPropertyManager().getPrecheckResult());
        }
    }
}

