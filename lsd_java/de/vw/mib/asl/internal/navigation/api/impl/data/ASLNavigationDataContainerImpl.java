/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.data;

import de.vw.mib.asl.api.navigation.data.ASLNavigationDataContainer;
import de.vw.mib.asl.api.navigation.data.ASLNavigationDataObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

public class ASLNavigationDataContainerImpl
implements ASLNavigationDataContainer {
    private final Map observers = new IdentityHashMap();

    @Override
    public void notifyObserversNavigationDataChanged() {
        ArrayList arrayList = new ArrayList(this.observers.keySet());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((ASLNavigationDataObserver)iterator.next()).navigationDataChanged(this);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public void addObserver(ASLNavigationDataObserver aSLNavigationDataObserver) {
        if (aSLNavigationDataObserver != null) {
            this.observers.put(aSLNavigationDataObserver, aSLNavigationDataObserver);
        }
    }

    @Override
    public void removeObserver(ASLNavigationDataObserver aSLNavigationDataObserver) {
        if (aSLNavigationDataObserver != null) {
            this.observers.remove(aSLNavigationDataObserver);
        }
    }
}

