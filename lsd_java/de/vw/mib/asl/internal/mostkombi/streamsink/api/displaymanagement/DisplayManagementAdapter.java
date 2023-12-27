/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mostkombi.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.genericevents.EventGeneric;
import java.util.List;

public class DisplayManagementAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
DisplayManagementService {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = DisplayManagementAdapter.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        Object[] objectArray = new DisplayManagementDelegate[list.size()];
        for (DisplayManagementDelegate displayManagementDelegate : (DisplayManagementDelegate[])list.toArray(objectArray)) {
            displayManagementDelegate.updateDisplayManagement(this, n);
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return DisplayManagementDelegate.DISPLAY_MANAGEMENT_PROPERTIES;
    }

    @Override
    protected int[] getListIds() {
        return null;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected void listValueChanged(int n) {
    }

    @Override
    public void switchToKombiDisplayContext(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(604708928);
        eventGeneric.setInt(0, n);
        DisplayManagementAdapter.sendSafe(eventGeneric);
    }

    @Override
    public void setDataFrameRate(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(621486144);
        eventGeneric.setInt(0, n);
        DisplayManagementAdapter.sendSafe(eventGeneric);
    }

    @Override
    public int getKombiDisplay() {
        return this.getDataPool().getInteger(976363520, -2);
    }

    @Override
    public int getDataFrameRate() {
        return this.getDataPool().getInteger(993140736, -1);
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

