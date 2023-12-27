/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetNVCRange;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class SldeSpellerDsiHandler
extends AbstractNavGatewayTarget
implements DSIServiceStateListener {
    private static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SldeSpellerDsiHandler");
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public SldeSpellerDsiHandler(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = SldeSpellerDsiHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
    }

    public void handleHwrSpellerModeEnabled(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            new CmdSetNVCRange(this, 2);
        } else {
            new CmdSetNVCRange(this, 1);
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public void registered(String string, int n) {
    }

    @Override
    public void unregistered(String string, int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

