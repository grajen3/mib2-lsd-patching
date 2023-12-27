/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.offclock;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.offclock.OffClockPersistenceTarget$1;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class OffClockPersistenceTarget
extends AbstractASLTarget {
    private final ConfigurationManagerDiag configurationManager = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getConfigurationManagerDiag();

    public OffClockPersistenceTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.writePersistedClockLayoutToAslApi();
        this.addConfigManagerObserver();
        this.addObserver(1612800064);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1011934208;
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1080041824: {
                this.writeClockLayoutToPersistence(eventGeneric);
                break;
            }
        }
    }

    void writePersistedClockLayoutToAslApi() {
        int n = this.configurationManager.getOffClockLayout();
        OffClockPersistenceTarget.writeIntegerToDatapool(1917345792, n);
    }

    private void addConfigManagerObserver() {
        this.configurationManager.addNvListener(new OffClockPersistenceTarget$1(this), 5);
    }

    private void writeClockLayoutToPersistence(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.configurationManager.setOffClockLayout(n);
    }
}

