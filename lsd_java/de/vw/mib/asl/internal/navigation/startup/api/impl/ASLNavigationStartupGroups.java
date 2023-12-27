/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.api.impl;

import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.Target;
import java.util.ArrayList;
import java.util.List;

public class ASLNavigationStartupGroups {
    private boolean targetsAlreadyCreated = false;
    private ArrayList navContainer = new ArrayList();
    private IntObjectOptHashMap startupGroups = new IntObjectOptHashMap();
    private static ASLNavigationStartupGroups mpInstance = new ASLNavigationStartupGroups();

    public static ASLNavigationStartupGroups getInstance() {
        return mpInstance;
    }

    public void addTarget(int n, Target target) {
        if (!this.startupGroups.containsKey(n)) {
            this.startupGroups.put(n, new ArrayList());
        }
        ArrayList arrayList = (ArrayList)this.startupGroups.get(n);
        arrayList.add(target);
    }

    public void addTargets(int n, List list) {
        if (!this.startupGroups.containsKey(n)) {
            this.startupGroups.put(n, new ArrayList());
        }
        ArrayList arrayList = (ArrayList)this.startupGroups.get(n);
        arrayList.addAll(list);
    }

    public Target[] getGroupTargets(int n) {
        ArrayList arrayList = (ArrayList)this.startupGroups.get(n);
        if (arrayList != null) {
            return (Target[])arrayList.toArray(new Target[0]);
        }
        return new Target[0];
    }

    public void registerContainer(ASLNavigationContainer aSLNavigationContainer) {
        this.navContainer.add(aSLNavigationContainer);
    }

    public void createAllTargets() {
        if (!this.targetsAlreadyCreated) {
            for (int i2 = 0; i2 < this.navContainer.size(); ++i2) {
                ASLNavigationContainer aSLNavigationContainer = (ASLNavigationContainer)this.navContainer.get(i2);
                try {
                    aSLNavigationContainer.createTargets();
                    continue;
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
            }
            this.targetsAlreadyCreated = true;
        }
    }
}

