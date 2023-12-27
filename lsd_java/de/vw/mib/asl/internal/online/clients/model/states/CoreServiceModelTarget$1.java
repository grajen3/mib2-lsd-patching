/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListenerAdapter;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.util.Util;

class CoreServiceModelTarget$1
extends NavigationOnlinePoiListenerAdapter {
    private final /* synthetic */ CoreServiceModelTarget this$0;

    CoreServiceModelTarget$1(CoreServiceModelTarget coreServiceModelTarget) {
        this.this$0 = coreServiceModelTarget;
    }

    @Override
    public void updateDynPoi2ServiceID(int n, String string) {
        if (CoreServiceFactory.getCoreService() != null && !Util.isNullOrEmpty(string)) {
            CoreServiceFactory.getCoreService().checkServiceStatus(CoreServiceModelFactory.getPropertyManager().setPrecheckServiceID(string), CoreServiceModelFactory.getPropertyManager().setPrecheckUser(CoreServiceModelFactory.getCoreServiceModelController(this.this$0).getMainUser()), this.this$0);
            try {
                this.this$0.triggerMe(-1266286336);
            }
            catch (Exception exception) {
                this.this$0.error(exception);
            }
        } else {
            CoreServiceModelFactory.getPropertyManager().setPrecheckServiceID(string != null ? string : "");
            CoreServiceModelFactory.getPropertyManager().setPrecheckResult(59);
            CoreServiceModelFactory.getCoreServiceModelController(this.this$0).serviceStatusResult(CoreServiceModelFactory.getPropertyManager().getPrecheckServiceID(), CoreServiceModelFactory.getPropertyManager().getPrecheckResult());
        }
    }
}

