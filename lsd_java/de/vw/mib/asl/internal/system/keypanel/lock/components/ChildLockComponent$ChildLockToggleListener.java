/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.keypanel.lock.components.ChildLockComponent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

class ChildLockComponent$ChildLockToggleListener
extends AbstractSystemTarget {
    private final /* synthetic */ ChildLockComponent this$0;

    ChildLockComponent$ChildLockToggleListener(ChildLockComponent childLockComponent, SystemServices systemServices) {
        this.this$0 = childLockComponent;
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -240511744);
        this.registerEvents(systemServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 789258304) {
            this.this$0.onToggleRsc();
        }
    }

    private void registerEvents(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(789258304, this.getTargetId());
    }
}

