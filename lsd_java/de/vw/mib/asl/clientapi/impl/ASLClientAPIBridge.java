/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPI;
import de.vw.mib.asl.clientapi.ASLClientAPIService;
import de.vw.mib.asl.clientapi.ASLClientAPIStateListener;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$APIStateBridge;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$Services;
import de.vw.mib.collections.copyonwrite.CowArray;

public abstract class ASLClientAPIBridge
implements ASLClientAPI {
    private final ASLClientAPIBridge$Services services;
    private final ASLClientAPIBridge$APIStateBridge stateBridge;
    private int state = 0;
    private final CowArray stateListeners = new CowArray();
    static /* synthetic */ Class class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge;

    protected ASLClientAPIBridge(ASLClientAPIBridge$Services aSLClientAPIBridge$Services) {
        this.services = aSLClientAPIBridge$Services;
        this.stateBridge = new ASLClientAPIBridge$APIStateBridge(this);
    }

    @Override
    public int getAPIState() {
        return this.state;
    }

    @Override
    public void subscribeAPIState(ASLClientAPIStateListener aSLClientAPIStateListener) {
        this.stateListeners.addIfNotAlreadyIn(aSLClientAPIStateListener);
        aSLClientAPIStateListener.updateAPIState(this.state);
    }

    @Override
    public void unsubscribeAPIState(ASLClientAPIStateListener aSLClientAPIStateListener) {
        this.stateListeners.remove(aSLClientAPIStateListener);
    }

    protected ASLClientAPIStateListener getStateListener() {
        return this.stateBridge;
    }

    final void bind(ASLClientAPIService aSLClientAPIService) {
        if (null == aSLClientAPIService) {
            throw new NullPointerException("service");
        }
        this.stateBridge.init();
        this.bindService(aSLClientAPIService);
        this.stateBridge.ready();
    }

    protected abstract void bindService(ASLClientAPIService aSLClientAPIService) {
    }

    void updateAPIState(int n) {
        if (this.state != n) {
            this.state = n;
            Object[] objectArray = this.stateListeners.getArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    ((ASLClientAPIStateListener)objectArray[i2]).updateAPIState(n);
                    continue;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

