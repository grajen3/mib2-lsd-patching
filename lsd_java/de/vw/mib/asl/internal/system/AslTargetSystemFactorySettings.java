/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.FactorySettingsService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class AslTargetSystemFactorySettings
extends AbstractASLTarget {
    private static final int CONTEXT_UNKNOWN;
    private static final String LOGGING_DELIM;
    private boolean diagnosticFactoryResetRequested = false;
    private static final IntIntMap MAPPING;

    public AslTargetSystemFactorySettings(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AslTargetSystemFactorySettings(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public int getDefaultTargetId() {
        return 5608;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.logTrace("IdEvent.POWER_ON");
                return;
            }
            case 4300010: {
                this.logTrace("ASLSystemServiceIds.RESET_SETTINGS_FULL_FACTORY_RESET received (from Persistence)!");
                this.getFactorySettings().resetAllToFactorySettingsRemoteControlMode();
                return;
            }
            case 4300030: {
                if (this.diagnosticFactoryResetRequested) {
                    this.diagnosticFactoryResetRequested = false;
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 7303, -23314176);
                    eventGeneric2.setBoolean(0, eventGeneric.getBoolean(0));
                    this.send(eventGeneric2);
                }
                return;
            }
            case 4300025: {
                this.logTrace("ASLSystemServiceIds.DIAGNOSTIC_MODE_RESET_ALL_SETTINGS_AND_DATA received");
                this.diagnosticFactoryResetRequested = true;
                this.getFactorySettings().resetAllToFactorySettings();
                return;
            }
            case 1073743166: {
                this.resetContext(eventGeneric);
                return;
            }
            case 1073743167: {
                this.getFactorySettings().resetAllToFactorySettings();
                return;
            }
        }
    }

    private void resetContext(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = AslTargetSystemFactorySettings.toContextId(n);
        if (n2 == -1) {
            ServiceManager.eventDispatcher.createAndSubmitRestoreFactorySettingsEvent();
        } else {
            FactorySettingsService factorySettingsService = this.getFactorySettings();
            factorySettingsService.resetToFactorySettings(n2);
        }
    }

    private FactorySettingsService getFactorySettings() {
        return ASLSystemFactory.getSystemApi().getFactorySettingsService();
    }

    private void logTrace(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemFactorySettings] ").append(string).log();
        }
    }

    private static int toContextId(int n) {
        if (MAPPING.containsKey(n)) {
            return MAPPING.get(n);
        }
        return -1;
    }

    private static IntIntMap mapIndexToContextId() {
        IntIntOptHashMap intIntOptHashMap = new IntIntOptHashMap();
        intIntOptHashMap.put(0, 1000);
        intIntOptHashMap.put(1, 2000);
        intIntOptHashMap.put(2, 3000);
        intIntOptHashMap.put(3, 4000);
        intIntOptHashMap.put(4, 5000);
        intIntOptHashMap.put(5, 6000);
        intIntOptHashMap.put(6, 7000);
        intIntOptHashMap.put(7, 8000);
        intIntOptHashMap.put(9, 9000);
        intIntOptHashMap.put(10, 10000);
        intIntOptHashMap.put(11, 11000);
        intIntOptHashMap.put(12, 12000);
        intIntOptHashMap.put(13, 13000);
        intIntOptHashMap.put(14, 14000);
        intIntOptHashMap.put(15, 15000);
        return intIntOptHashMap;
    }

    static {
        MAPPING = AslTargetSystemFactorySettings.mapIndexToContextId();
    }
}

