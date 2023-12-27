/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.tvtuner;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerServiceListener;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.datatypes.iterator.asl.TvPresetListASLDataPoolIterator;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.List;

public class TvTunerASLDataAdapter
extends ASLDataPoolAdapter
implements TvTunerService {
    private APIFactoryInterface apiFactory;
    private static final int[] TV_TUNER_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{2314, 2687, 2573, 2662};
    private static final int[] TV_TUNER_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{2710};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$tvtuner$TvTunerService;

    public TvTunerASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$tvtuner$TvTunerService == null ? (class$de$vw$mib$bap$mqbab2$common$api$tvtuner$TvTunerService = TvTunerASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService")) : class$de$vw$mib$bap$mqbab2$common$api$tvtuner$TvTunerService;
    }

    @Override
    public String getCurrentTvTunerStationName() {
        return this.getDataPool().getString(2314, "");
    }

    @Override
    public int getCurrentTvTunerSource() {
        return this.getDataPool().getInteger(2687, 1);
    }

    @Override
    public int getCurrentTvMuteState() {
        return this.getDataPool().getInteger(2573, 0);
    }

    @Override
    public int getTvScopeOfArrowKeyMode() {
        return this.getDataPool().getInteger(2662, 1);
    }

    @Override
    public Iterator getTvTunerPresetList() {
        return new TvPresetListASLDataPoolIterator();
    }

    @Override
    public void activateNextTvTunerStation() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(2013724736);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activatePreviousTvTunerStation() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(2030501952);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateTvTunerPreset(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-234422208, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                TvTunerServiceListener tvTunerServiceListener = (TvTunerServiceListener)iterator.next();
                tvTunerServiceListener.updateTvTunerData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return TV_TUNER_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return TV_TUNER_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addTvTunerServiceListener(TvTunerServiceListener tvTunerServiceListener, int[] nArray) {
        this.registerServiceListener((Object)tvTunerServiceListener, nArray);
    }

    @Override
    public void removeTvTunerServiceListener(TvTunerServiceListener tvTunerServiceListener, int[] nArray) {
        this.removeServiceListener(tvTunerServiceListener, nArray);
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

