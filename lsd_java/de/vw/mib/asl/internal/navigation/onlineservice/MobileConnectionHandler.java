/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.onlineservice;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class MobileConnectionHandler
extends AbstractASLTarget {
    private static final int[] EVENTS = new int[]{-1013899008, -963567360, -997121792, -980344576, -1030676224, -1047453440, -946790144};

    public MobileConnectionHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101001: {
                this.addObservers(EVENTS);
                break;
            }
            case 2200001: {
                break;
            }
            case 2200003: {
                int n = eventGeneric.getInt(0);
                this.setModelConnectionType(n);
                break;
            }
            case 2200002: {
                int n = eventGeneric.getInt(0);
                this.setModelWlanAvailable(n);
                break;
            }
            case 2200004: {
                int n = eventGeneric.getInt(0);
                this.setModelGsmSignalStrength(n);
                break;
            }
            case 2200007: {
                int n = eventGeneric.getInt(0);
                this.setModelWlanSignalStrength(n);
                break;
            }
            case 2200006: {
                boolean bl = eventGeneric.getBoolean(0);
                MobileConnectionHandler.writeBooleanToDatapool(1425018880, bl);
                break;
            }
            case 2200005: {
                boolean bl = eventGeneric.getBoolean(0);
                MobileConnectionHandler.writeBooleanToDatapool(1441796096, bl);
                break;
            }
        }
    }

    private void setModelGsmSignalStrength(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        MobileConnectionHandler.writeIntegerToDatapool(1341132800, n2);
    }

    private void setModelWlanSignalStrength(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        MobileConnectionHandler.writeIntegerToDatapool(1357910016, n2);
    }

    private void setModelWlanAvailable(int n) {
        switch (n) {
            case 3: {
                MobileConnectionHandler.writeBooleanToDatapool(1391464448, true);
                MobileConnectionHandler.writeBooleanToDatapool(1408241664, false);
                break;
            }
            case 1: 
            case 2: {
                MobileConnectionHandler.writeBooleanToDatapool(1391464448, false);
                MobileConnectionHandler.writeBooleanToDatapool(1408241664, true);
                break;
            }
            default: {
                MobileConnectionHandler.writeBooleanToDatapool(1408241664, false);
                MobileConnectionHandler.writeBooleanToDatapool(1391464448, false);
            }
        }
    }

    private void setModelConnectionType(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        MobileConnectionHandler.writeIntegerToDatapool(1374687232, n2);
    }
}

