/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.filter;

import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;

public abstract class AbstractProximityFilter {
    private final ProximityServiceImpl service;
    private boolean isOverrideActive;
    private boolean filterValue;

    public AbstractProximityFilter(ProximityServiceImpl proximityServiceImpl) {
        if (proximityServiceImpl == null) {
            throw new IllegalArgumentException("Proximity Service must not be null.");
        }
        this.service = proximityServiceImpl;
        this.service.registerFilter(this);
    }

    public boolean getFilterOverride() {
        return this.filterValue;
    }

    public boolean isOverrideActive() {
        return this.isOverrideActive;
    }

    public abstract boolean isOverridingUserInteraction() {
    }

    protected void installOverride(boolean bl) {
        boolean bl2 = !this.isOverrideActive || bl != this.filterValue;
        this.isOverrideActive = true;
        this.filterValue = bl;
        if (bl2) {
            this.service.onFilterStateChanged();
        }
    }

    protected void removeOverride() {
        if (this.isOverrideActive) {
            this.isOverrideActive = false;
            this.service.onFilterStateChanged();
        }
    }
}

