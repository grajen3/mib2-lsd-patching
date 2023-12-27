/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.slde.SldeEventHelper;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.properties.values.SpellerData;
import java.util.Vector;

public abstract class SldeProxyModule {
    IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SldeProxyModule");
    SldeSpellerHandler spellerHandler = SldeSpellerHandler.getInstance();
    SldeEventHelper eventHelper = new SldeEventHelper();

    void quitModelWaitstate() {
        this.printTrace("quitWaitstate");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1693454336, true);
    }

    void clearResultList() {
        this.printTrace("clearResultList");
        ASLNavigationTruffelFactory.getNavigationTruffelApi().setSearchResults(new Vector(), true, ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription(), false);
    }

    void printTrace(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append(string).log();
        }
    }

    abstract void handleCancelSearch() {
    }

    abstract void handleSwitchToMapResultView() {
    }

    abstract void handleRequestNextPage() {
    }

    abstract void handleListSelectById(EventGeneric eventGeneric) {
    }

    abstract void startSearch() {
    }

    abstract void stopSearch() {
    }

    abstract void setupSlde(EventGeneric eventGeneric) {
    }

    abstract void spellerTextChanged(SpellerData spellerData) {
    }

    abstract void sendEvent(EventGeneric eventGeneric) {
    }

    abstract void allowReceivingEvents(boolean bl) {
    }

    abstract void handleReturnToDualList() {
    }

    abstract void initXt9Finished() {
    }
}

