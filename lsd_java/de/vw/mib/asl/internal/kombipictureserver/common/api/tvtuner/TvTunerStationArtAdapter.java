/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner;

import de.vw.mib.asl.internal.kombipictureserver.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import org.dsi.ifc.global.ResourceLocator;

public class TvTunerStationArtAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
TvTunerStationArtService {
    private static final int[] RADIO_TV_TUNER_STATION_ART_PROPERTY_IDS = new int[]{2494};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService = TvTunerStationArtAdapter.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService;
    }

    @Override
    protected int[] getPropertyIds() {
        return RADIO_TV_TUNER_STATION_ART_PROPERTY_IDS;
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
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
    }

    @Override
    public ResourceLocator getCurrentTvStationArt() {
        return null;
    }

    @Override
    public boolean isCurrentTvStationArtValid() {
        return false;
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

