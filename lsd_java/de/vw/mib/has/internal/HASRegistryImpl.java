/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASListControl;
import de.vw.mib.has.HASListProperty;
import de.vw.mib.has.HASRegistry;
import de.vw.mib.has.internal.HASListControlImpl;
import de.vw.mib.has.internal.HASManager;
import java.util.HashMap;

final class HASRegistryImpl
implements HASRegistry {
    private final HashMap contexts = new HashMap();
    private final IntObjectOptHashMap actions = new IntObjectOptHashMap();
    private final IntObjectOptHashMap properties = new IntObjectOptHashMap();
    private final IntOptHashSet immediates = new IntOptHashSet();
    private final IntObjectOptHashMap lists = new IntObjectOptHashMap();
    private final IntObjectOptHashMap listsByAction = new IntObjectOptHashMap();
    private final IntObjectOptHashMap listsByProperty = new IntObjectOptHashMap();

    HASRegistryImpl() {
    }

    @Override
    public void registerContext(HASContext hASContext) {
        this.contexts.put(hASContext.getContextName(), hASContext);
    }

    @Override
    public HASContext getContextByName(String string) {
        return (HASContext)this.contexts.get(string);
    }

    @Override
    public HASContext getContextByAction(int n) {
        return (HASContext)this.actions.get(n);
    }

    @Override
    public HASContext getContextByProperty(int n) {
        return (HASContext)this.properties.get(n);
    }

    @Override
    public boolean isImmediateProperty(int n) {
        return this.immediates.contains(n);
    }

    @Override
    public void registerAction(int n, HASContext hASContext) {
        this.actions.put(n, hASContext);
    }

    @Override
    public void registerProperty(int n, HASContext hASContext) {
        this.properties.put(n, hASContext);
    }

    @Override
    public void registerImmediateProperty(int n, HASContext hASContext) {
        this.registerProperty(n, hASContext);
        this.immediates.add(n);
    }

    @Override
    public HASListControl registerList(HASListProperty hASListProperty, HASContext hASContext) {
        HASListControlImpl hASListControlImpl = HASListControlImpl.create(hASListProperty);
        this.lists.put(hASListProperty.getListId(), hASListControlImpl);
        this.listsByAction.put(hASListProperty.getActionId(), hASListControlImpl);
        this.listsByProperty.put(hASListProperty.getPropertyId(), hASListControlImpl);
        HASManager.getInstance().getClock().addConsumer(hASListControlImpl);
        return hASListControlImpl;
    }

    HASListControl getListByAction(int n) {
        return (HASListControl)this.listsByAction.get(n);
    }
}

