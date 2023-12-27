/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;

class FactoryResetPopupUpdater
implements FactoryResetListener {
    private final SystemEventDispatcher systemEventDispatcher;

    public FactoryResetPopupUpdater(SystemEventDispatcher systemEventDispatcher) {
        this.systemEventDispatcher = systemEventDispatcher;
    }

    @Override
    public void onFactoryResetStateChanged(int n) {
        switch (n) {
            case 1: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(2033328128);
                break;
            }
            case 0: {
                this.systemEventDispatcher.createAndSubmitHMIEvent(2050105344);
                break;
            }
        }
    }
}

