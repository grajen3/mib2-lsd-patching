/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.framework.api.diagnosis.config.LoadSystemLanguages;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.testmode.HsmTestmode;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

final class TargetLanguage
extends AbstractASLTarget {
    private static final int EVENT_RESULT_GET_DIAG;
    private static TargetLanguage mInstance;

    private TargetLanguage(HsmTestmode hsmTestmode) {
        super(hsmTestmode.getMainObject(), hsmTestmode.getEventDispatcher().getNextTargetId());
    }

    static void enableTarget(HsmTestmode hsmTestmode) {
        if (mInstance == null) {
            try {
                mInstance = new TargetLanguage(hsmTestmode);
                mInstance.register();
            }
            catch (Exception exception) {
                hsmTestmode.error(exception);
            }
        }
    }

    private void register() {
        try {
            this.register(this.getMainObject(), this.getTargetId(), this.getEventDispatcher().getRandomTaskId());
        }
        catch (Exception exception) {
            this.error().append("TargetLanguage could not be registered ").append(exception).log();
        }
    }

    private boolean isValid(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(2);
        long l = eventGeneric.getLong(3);
        return n == 906042371 && l == 0;
    }

    private void requestData() {
        ServiceManager.adaptionApi.requestConfigManagerPersLoadSystemLanguages(this.getTargetId(), -1585053440);
    }

    private void updateList(EventGeneric eventGeneric) {
        String[][] stringArrayArray;
        LoadSystemLanguages loadSystemLanguages = (LoadSystemLanguages)eventGeneric.getObject(1);
        int n = loadSystemLanguages.getValue(609);
        if (n > 32) {
            n = 32;
        }
        if (n > 0) {
            stringArrayArray = new String[n][];
            int n2 = 0;
            int n3 = n;
            for (int i2 = 0; i2 < n; ++i2) {
                String string = loadSystemLanguages.getLanguage(n2++);
                String string2 = loadSystemLanguages.getLanguage(n3++);
                stringArrayArray[i2] = new String[]{string, string2};
            }
        } else {
            stringArrayArray = new String[][]{{"No", "Languages"}};
        }
        ListManager.getGenericASLList(-659021568).updateList((Object[])stringArrayArray);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.addObservers(new int[]{-2075192832});
                this.requestData();
                break;
            }
            case 1200004: {
                if (!this.isValid(eventGeneric)) break;
                this.requestData();
                break;
            }
            case 100001: {
                if (!this.isValid(eventGeneric)) break;
                this.updateList(eventGeneric);
                break;
            }
        }
    }
}

