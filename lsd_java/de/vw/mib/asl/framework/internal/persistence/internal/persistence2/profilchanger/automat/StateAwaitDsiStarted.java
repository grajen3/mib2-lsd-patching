/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateAwaitDsiStarted$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateDsiNotPresentInVariant;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateDsiUnavailableError;

public class StateAwaitDsiStarted
extends State {
    private static final long TIMEOUT;
    private DSIServiceStateListenerAdapter listener;

    @Override
    public boolean isFinalState() {
        return false;
    }

    @Override
    public void onEnter(Context context) {
        Class clazz;
        String[] stringArray = context.getServices().getAslStartupApi().getVariantDsiNames();
        if (this.contains(stringArray, (clazz = context.getDsiAdapter().getDsiClass()).getName())) {
            this.awaitDsiRegistered(context, clazz);
            context.startTimer(0);
        } else {
            context.transitionToState(new StateDsiNotPresentInVariant());
        }
    }

    @Override
    public void onExit(Context context) {
        if (this.listener != null) {
            context.getServices().getDsiProxy().removeServiceStateListener(this.listener);
        }
    }

    @Override
    public void onTimeout(Context context) {
        context.transitionToState(new StateDsiUnavailableError("Waiting for dsi registration timed out after 5000ms."));
    }

    private boolean contains(String[] stringArray, String string) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!stringArray[i2].equals(string)) continue;
            return true;
        }
        return false;
    }

    private void awaitDsiRegistered(Context context, Class clazz) {
        DSIProxy dSIProxy = context.getServices().getDsiProxy();
        this.listener = new StateAwaitDsiStarted$1(this, context);
        dSIProxy.addServiceStateListener(clazz, this.listener);
    }
}

