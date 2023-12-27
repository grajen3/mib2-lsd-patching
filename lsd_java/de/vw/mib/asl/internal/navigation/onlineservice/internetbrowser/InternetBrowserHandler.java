/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.onlineservice.internetbrowser;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class InternetBrowserHandler
extends AbstractASLTarget {
    private static final int[] EVENTS = new int[]{-2068239872, -2034685440, 466161728, 449384512};

    public InternetBrowserHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101001: {
                this.addObservers(EVENTS);
                break;
            }
            case 1074841882: {
                break;
            }
            case 1074841883: {
                int n = eventGeneric.getInt(0);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -262139136, -2001131008);
                eventGeneric2.setInt(0, n);
                this.sendSafe(eventGeneric2);
                break;
            }
            case 2800004: {
                this.updateModelBrowserState(eventGeneric);
                break;
            }
            case 2800006: {
                this.updateModelScrollbarY(eventGeneric);
                break;
            }
        }
    }

    private void updateModelBrowserState(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                if (this.isTraceEnabled()) {
                    this.trace("Navi InternetBrowserHandler: setModelBrowserState loading");
                }
                n = 0;
                break;
            }
            case 2: {
                if (this.isTraceEnabled()) {
                    this.trace("Navi InternetBrowserHandler: setModelBrowserState not found");
                }
                n = 3;
                break;
            }
            case 5: {
                if (this.isTraceEnabled()) {
                    this.trace("Navi InternetBrowserHandler: setModelBrowserState error");
                }
                n = 2;
                break;
            }
            default: {
                if (this.isTraceEnabled()) {
                    this.trace("Navi InternetBrowserHandler: setModelBrowserState idle");
                }
                n = 1;
            }
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(854593536, n);
    }

    private void updateModelScrollbarY(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        ServiceManager.aslPropertyManager.valueChangedInteger(888147968, n - n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(904925184, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(871370752, n3);
    }
}

