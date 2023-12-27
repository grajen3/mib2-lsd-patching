/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.has;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class AslTargetSystemHas
extends AbstractASLTarget {
    private static final String LOGGING_DELIM;
    private final SystemHasBridge hasBridge;
    private boolean registeredAsLac = false;

    public AslTargetSystemHas(GenericEvents genericEvents, SystemHasBridge systemHasBridge) {
        super(genericEvents, -307620608);
        this.hasBridge = systemHasBridge;
        this.register(this.getMainObject(), -307620608, "hsmtask");
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.processRegistered();
                break;
            }
            case 1600000: {
                if (!this.registeredAsLac) {
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(1234960384);
                    eventGeneric2.setInt(0, this.getTargetId());
                    eventGeneric2.setInt(1, 0);
                    eventGeneric2.setString(2, "NO_LANGUAGE");
                    eventGeneric2.setString(3, super.getClass().getName());
                    ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric2);
                    this.registeredAsLac = true;
                }
                this.removeObserver(6952960);
                break;
            }
            case 40003: {
                int n = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                this.hasBridge.setPropertyLanguageInfo(string);
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(1151074304);
                eventGeneric3.setInt(0, n);
                eventGeneric3.setBoolean(1, true);
                eventGeneric3.setString(2, string);
                ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric3);
                break;
            }
            case 40007: {
                Object object;
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                this.trace(new StringBuffer().append("Received event LSCTNG_CHANGE_SKIN with skin id ").append(n2).append(".").toString());
                if (n2 != -1) {
                    object = ServiceManager.configManagerDiag.getSkinModName(n2);
                    this.trace(new StringBuffer().append("Skin name is ").append((String)object).append(" and will be forwarded to HAS.").toString());
                    this.hasBridge.setPropertySkinInfo((String)object);
                } else {
                    this.warn().append("[AslTargetSystemHas] ").append("Skin id is -1, so the skin name will not be forwarded to HAS.").log();
                }
                object = ServiceManager.mGenericEventFactory.newEvent(1218183168);
                ((EventGeneric)object).setInt(0, n);
                ((EventGeneric)object).setBoolean(1, true);
                ((EventGeneric)object).setInt(2, n2);
                ServiceManager.eventMain.getEventDispatcher().sendSafe((EventGeneric)object);
                break;
            }
        }
    }

    private void processRegistered() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemHas] ").append("processRegistered").log();
        }
        this.addObserver(6952960);
    }

    @Override
    public int getDefaultTargetId() {
        return -307620608;
    }
}

