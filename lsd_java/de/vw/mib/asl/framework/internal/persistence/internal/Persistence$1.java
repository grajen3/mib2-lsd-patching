/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.persistence.internal.Persistence;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersonalizationListener;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.personalization.DSIPersonalization;

class Persistence$1
implements DSIServiceStateListener {
    private final /* synthetic */ PersistenceServices val$serviceManager;
    private final /* synthetic */ Persistence this$0;

    Persistence$1(Persistence persistence, PersistenceServices persistenceServices) {
        this.this$0 = persistence;
        this.val$serviceManager = persistenceServices;
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void registered(String string, int n) {
        PersDebug.trace("Got DSIPersonalization, adding corresponding listeener", true);
        Target target = null;
        PersonalizationListener personalizationListener = new PersonalizationListener(this.val$serviceManager);
        DSIPersonalization dSIPersonalization = (DSIPersonalization)DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getService(target, Persistence.class$org$dsi$ifc$personalization$DSIPersonalization == null ? (Persistence.class$org$dsi$ifc$personalization$DSIPersonalization = Persistence.class$("org.dsi.ifc.personalization.DSIPersonalization")) : Persistence.class$org$dsi$ifc$personalization$DSIPersonalization);
        dSIPersonalization.setNotification(personalizationListener);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addResponseListener(target, Persistence.class$org$dsi$ifc$personalization$DSIPersonalizationListener == null ? (Persistence.class$org$dsi$ifc$personalization$DSIPersonalizationListener = Persistence.class$("org.dsi.ifc.personalization.DSIPersonalizationListener")) : Persistence.class$org$dsi$ifc$personalization$DSIPersonalizationListener, personalizationListener);
    }
}

