/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.api.adaption;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.mostkombi.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationDelegate;
import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceRegistry;
import java.util.Iterator;
import java.util.List;

public class AdaptationAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
AdaptationService {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService = AdaptationAdapter.class$("de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService")) : class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService;
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AdaptationDelegate adaptationDelegate = (AdaptationDelegate)iterator.next();
            adaptationDelegate.updateAdaptation(this, n);
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return AdaptationDelegate.ADAPTATION_PROPERTIES;
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
    public int getMostCapabilityForMap() {
        return this.getDataPool().getInteger(1043472384, 0);
    }

    @Override
    public int getMostCapabilityForKdk() {
        return this.getDataPool().getInteger(1060249600, 0);
    }

    @Override
    public boolean isNavigationMapSwitchSupported() {
        return this.getDataPool().getBoolean(-1695543296, false) || ASLFrameworkFactory.getASLFrameworkAPI().getServices().getConfigurationManagerDiag().isFeatureFlagSet(139);
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

