/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.personalization;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.util.personalization.AbstractDsiAwareProfileChangeHandler;
import de.vw.mib.genericevents.EventGeneric;

public class NavProfileChangeHandler
extends AbstractDsiAwareProfileChangeHandler {
    @Override
    protected void prepareForProfileChange() {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setObject(0, this);
        eventGeneric.setReceiverEventId(75956480);
        eventGeneric.setReceiverTargetId(-833940480);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public void loadPersonalizedPersistedValues() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().reloadPersonalNaviPersistence();
    }

    @Override
    protected void changeProfilePreDsi() {
        this.notifyTaskDone(true);
    }

    @Override
    protected void changeProfilePostDsi() {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setObject(0, this);
        eventGeneric.setReceiverEventId(92733696);
        eventGeneric.setReceiverTargetId(-833940480);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }
}

