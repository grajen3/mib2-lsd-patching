/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.keypanel.lock.components.AbstractLockStateComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.ChildLockComponent$ChildLockToggleListener;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

public class ChildLockComponent
extends AbstractLockStateComponent {
    private final SystemCommon systemCommon;
    private final ASLPropertyManager propertyManager;
    private final DSIPowerManagement dsiPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;

    public ChildLockComponent(SystemServices systemServices) {
        this.systemCommon = systemServices.getSystemCommonPersistenceService().loadSystemCommon();
        this.propertyManager = systemServices.getPropertyManager();
        this.dsiPowerManagement = (DSIPowerManagement)systemServices.getDsiProxy().getService(null, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = ChildLockComponent.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        new ChildLockComponent$ChildLockToggleListener(this, systemServices);
        boolean bl = this.systemCommon.isRearSeatControlLocked();
        this.setLockState(bl);
    }

    private void setLockState(boolean bl) {
        this.setLocked(bl);
        this.updateDataPool(bl);
        this.dsiPowerManagement.setChildLockRSE(bl ? 1 : 0);
    }

    @Override
    protected boolean checkIsKeyApplicable(int n, int n2) {
        return n == 1;
    }

    void onToggleRsc() {
        boolean bl = !this.systemCommon.isRearSeatControlLocked();
        this.systemCommon.setRearSeatControlLocked(bl);
        this.setLockState(bl);
    }

    private void updateDataPool(boolean bl) {
        this.propertyManager.valueChangedBoolean(1429348352, bl);
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

