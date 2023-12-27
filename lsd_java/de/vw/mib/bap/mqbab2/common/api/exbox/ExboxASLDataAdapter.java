/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.exbox;

import de.vw.mib.asl.api.exboxm.ASLExboxmAPI;
import de.vw.mib.asl.api.exboxm.ASLExboxmFactory;
import de.vw.mib.asl.api.exboxm.audioinformation.StationInfoData;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxService;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxServiceListener;
import de.vw.mib.bap.mqbab2.common.api.exbox.datatypes.ExboxCurrentStationInfo;
import de.vw.mib.bap.mqbab2.common.api.exbox.listener.ExboxAudioInformationDataListener;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExboxASLDataAdapter
implements ExboxService,
ExboxCurrentStationInfo {
    private ASLExboxmAPI exboxAPI = ASLExboxmFactory.getExboxmApi();
    private ExboxAudioInformationDataListener exboxAudioInformationListener = new ExboxAudioInformationDataListener(this);
    private static int LIST_INITIAL_CAPACITY = 3;
    private static String EMPTY_STRING = "";
    private IntObjectOptHashMap registeredListeners;

    public ExboxASLDataAdapter() {
        this.exboxAPI.getAudioInformationService().addListener(this.exboxAudioInformationListener);
    }

    protected IntObjectOptHashMap getRegisteredListeners() {
        if (this.registeredListeners == null) {
            this.registeredListeners = new IntObjectOptHashMap();
        }
        return this.registeredListeners;
    }

    protected final List getRegisteredListenersForService(int n) {
        return (List)this.getRegisteredListeners().get(n);
    }

    @Override
    public int getExboxActiveSource() {
        return this.exboxAPI.getAudioInformationService().getCurrentAudioSource();
    }

    public void onAudioSourceChanges(int n) {
        this._notifyServiceDelegates(-2012020608);
    }

    @Override
    public int getPrimaryID() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getPrimaryID();
        }
        return 0;
    }

    @Override
    public String getPrimaryInfo() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getPrimaryInfo();
        }
        return EMPTY_STRING;
    }

    @Override
    public int getPrimaryInfoType() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getPrimaryInfoType();
        }
        return 0;
    }

    @Override
    public String getSecondaryInfo() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getSecondaryInfo();
        }
        return EMPTY_STRING;
    }

    @Override
    public int getSecondaryInfoType() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getPrimaryInfoType();
        }
        return 0;
    }

    @Override
    public String getTertiaryInfo() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getTertiaryInfo();
        }
        return EMPTY_STRING;
    }

    @Override
    public int getTertiaryInfoType() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getPrimaryInfoType();
        }
        return 0;
    }

    @Override
    public String getQuaternaryInfo() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getQuaternaryInfo();
        }
        return EMPTY_STRING;
    }

    @Override
    public int getQuaternaryInfoType() {
        if (this.exboxAPI.getAudioInformationService().getCurrentStationInfo() != null) {
            return this.exboxAPI.getAudioInformationService().getCurrentStationInfo().getPrimaryInfoType();
        }
        return 0;
    }

    @Override
    public ExboxCurrentStationInfo getExboxCurrentStationInfo() {
        return this;
    }

    public void onStationInfoDataUpdate(StationInfoData stationInfoData) {
        this._notifyServiceDelegates(-1995243392);
    }

    @Override
    public void addExboxServiceListener(ExboxServiceListener exboxServiceListener, int[] nArray) {
        if (nArray != null) {
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredListeners();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                List list = (List)intObjectOptHashMap.get(nArray[i2]);
                if (list == null) {
                    ArrayList arrayList = new ArrayList(LIST_INITIAL_CAPACITY);
                    arrayList.add(exboxServiceListener);
                    intObjectOptHashMap.put(nArray[i2], arrayList);
                    continue;
                }
                if (list.contains(exboxServiceListener)) continue;
                list.add(exboxServiceListener);
            }
        }
    }

    @Override
    public void removeExboxServiceListener(ExboxServiceListener exboxServiceListener, int[] nArray) {
        if (nArray != null) {
            IntObjectOptHashMap intObjectOptHashMap = this.getRegisteredListeners();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                List list = (List)intObjectOptHashMap.get(nArray[i2]);
                if (list == null) continue;
                list.remove(exboxServiceListener);
                if (!list.isEmpty()) continue;
                intObjectOptHashMap.remove(nArray[i2]);
            }
        }
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredListenersForService(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ExboxServiceListener exboxServiceListener = (ExboxServiceListener)iterator.next();
                exboxServiceListener.updateExboxData(this, n);
            }
        }
    }
}

