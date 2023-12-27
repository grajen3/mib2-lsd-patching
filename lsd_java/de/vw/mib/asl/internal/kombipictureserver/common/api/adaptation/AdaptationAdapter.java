/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation;

import de.vw.mib.asl.internal.kombipictureserver.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.asl.AdaptationDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.asl.AdaptationService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import java.util.Iterator;
import java.util.List;

public class AdaptationAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
AdaptationService {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService = AdaptationAdapter.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.asl.AdaptationService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService;
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                AdaptationDelegate adaptationDelegate = (AdaptationDelegate)iterator.next();
                adaptationDelegate.updateAdaptation(this, n);
            }
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
    public boolean isMostCapabilityCallPictureSet() {
        return this.getDataPool().getBoolean(1093804032, false);
    }

    @Override
    public boolean isMostCapabilityCoverArtSet() {
        return this.getDataPool().getBoolean(1077026816, false);
    }

    @Override
    public boolean isMostCapabilityStationArtSet() {
        return this.getDataPool().getBoolean(1110581248, false);
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

