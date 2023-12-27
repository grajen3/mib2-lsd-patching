/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.api.system.proximity.ProximityListener;
import de.vw.mib.asl.api.system.proximity.ProximityService;
import de.vw.mib.asl.internal.system.proximity.component.AbstractProximityComponent;
import de.vw.mib.asl.internal.system.proximity.filter.AbstractProximityFilter;
import java.util.ArrayList;
import java.util.Iterator;

public class ProximityServiceImpl
implements ProximityService {
    private static final boolean PROXIMITY_SENSOR_DEFAULT_VALUE;
    private final ArrayList components = new ArrayList();
    private final ArrayList filters = new ArrayList();
    private final ArrayList listeners = new ArrayList();
    private boolean lastNotfiedProximityState = false;
    private boolean lastNotfiedUserInteractionState = false;

    @Override
    public void addListener(ProximityListener proximityListener) {
        this.verifyListener(proximityListener);
        this.listeners.add(proximityListener);
    }

    @Override
    public boolean getCurrentProximityState() {
        return this.lastNotfiedProximityState;
    }

    @Override
    public boolean getCurrentUserInteractionState() {
        return this.lastNotfiedUserInteractionState;
    }

    public void onComponentProximityChanged() {
        if (!this.checkIsOverrideActive()) {
            this.notifyListenersForUnfilteredProximityState();
        } else if (!this.checkIsUserInteractionOverrideActive()) {
            this.notifyListenersUserInteractionChange(this.calculateUserInteractionProximityState());
        }
    }

    public void onFilterStateChanged() {
        if (this.checkIsOverrideActive()) {
            this.notifyListenersProximityChange(this.calculateFilterProximityState());
            if (this.checkIsUserInteractionOverrideActive()) {
                this.notifyListenersUserInteractionChange(this.calculateUserInteractionFilterProximityState());
            } else {
                this.notifyListenersUserInteractionChange(this.calculateUserInteractionProximityState());
            }
        } else {
            this.notifyListenersForUnfilteredProximityState();
        }
    }

    public void registerComponent(AbstractProximityComponent abstractProximityComponent) {
        this.components.add(abstractProximityComponent);
    }

    public void registerFilter(AbstractProximityFilter abstractProximityFilter) {
        this.filters.add(abstractProximityFilter);
    }

    public void removeListener(ProximityListener proximityListener) {
        this.listeners.remove(proximityListener);
    }

    private boolean calculateFilterProximityState() {
        Iterator iterator = this.filters.iterator();
        while (iterator.hasNext()) {
            AbstractProximityFilter abstractProximityFilter = (AbstractProximityFilter)iterator.next();
            if (!abstractProximityFilter.isOverrideActive()) continue;
            return abstractProximityFilter.getFilterOverride();
        }
        return false;
    }

    private boolean calculateUserInteractionFilterProximityState() {
        Iterator iterator = this.filters.iterator();
        while (iterator.hasNext()) {
            AbstractProximityFilter abstractProximityFilter = (AbstractProximityFilter)iterator.next();
            if (!abstractProximityFilter.isOverrideActive() || !abstractProximityFilter.isOverridingUserInteraction()) continue;
            return abstractProximityFilter.getFilterOverride();
        }
        return false;
    }

    private boolean calculateProximityState() {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            AbstractProximityComponent abstractProximityComponent = (AbstractProximityComponent)iterator.next();
            if (!abstractProximityComponent.getProximityState()) continue;
            return true;
        }
        return false;
    }

    private boolean calculateUserInteractionProximityState() {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            AbstractProximityComponent abstractProximityComponent = (AbstractProximityComponent)iterator.next();
            if (abstractProximityComponent.getComponentType() != AbstractProximityComponent.PROXIMITY_COMPONENT_TYPE_USER_INTERACTION || !abstractProximityComponent.getProximityState()) continue;
            return true;
        }
        return false;
    }

    private boolean checkIsOverrideActive() {
        boolean bl = false;
        Iterator iterator = this.filters.iterator();
        while (iterator.hasNext()) {
            bl |= ((AbstractProximityFilter)iterator.next()).isOverrideActive();
        }
        return bl;
    }

    private boolean checkIsUserInteractionOverrideActive() {
        boolean bl = false;
        Iterator iterator = this.filters.iterator();
        while (iterator.hasNext()) {
            AbstractProximityFilter abstractProximityFilter = (AbstractProximityFilter)iterator.next();
            bl |= abstractProximityFilter.isOverrideActive() && abstractProximityFilter.isOverridingUserInteraction();
        }
        return bl;
    }

    private void notifyListenersForUnfilteredProximityState() {
        boolean bl = this.calculateProximityState();
        this.notifyListenersProximityChange(bl);
        this.notifyListenersUserInteractionChange(bl);
    }

    private void notifyListenersProximityChange(boolean bl) {
        if (bl != this.lastNotfiedProximityState) {
            this.lastNotfiedProximityState = bl;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ((ProximityListener)this.listeners.get(i2)).onProximityChanged(bl);
            }
        }
    }

    private void notifyListenersUserInteractionChange(boolean bl) {
        if (bl != this.lastNotfiedUserInteractionState) {
            this.lastNotfiedUserInteractionState = bl;
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ((ProximityListener)this.listeners.get(i2)).onUserInteractionProximityChanged(bl);
            }
        }
    }

    private void verifyListener(ProximityListener proximityListener) {
        if (proximityListener == null) {
            throw new IllegalArgumentException("ProximityListener must not be null.");
        }
        if (this.listeners.contains(proximityListener)) {
            throw new IllegalArgumentException("The given proxmity listener was added before.");
        }
    }
}

