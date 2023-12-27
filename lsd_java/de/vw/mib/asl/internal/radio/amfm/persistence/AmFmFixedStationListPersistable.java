/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmFixedStationListItem;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class AmFmFixedStationListPersistable {
    private static Logger logger = ServiceManager.logger;
    private static final int INITIAL;
    private static final int MAXIMUM;
    private static final int MAX_STR_LEN;
    private Set mSet = new HashSet(50);
    private IntObjectMap stationsByFreq = new IntObjectOptHashMap(50);
    private IntObjectMap stationsByPi = new IntObjectOptHashMap(50);
    private AmFmFixedStationListItem fixedStation = null;
    private static boolean persistenceWriteAccessBlocked;

    public void clear() {
        this.mSet.clear();
        this.stationsByFreq.clear();
        this.stationsByPi.clear();
    }

    public void clearAndMarkDirty() {
        this.clear();
        this.toPersistence();
    }

    public void add() {
        Object object;
        if (logger.isTraceEnabled(128)) {
            object = logger.trace(128);
            object.append(RadioUtil.LOG_PREFIX_AMFM).append("adding fixed station: ").append(this.fixedStation).log();
        }
        if (null != this.fixedStation && (object = this.fixedStation.getName()) != null && ((String)object).trim().length() > 0) {
            this.add(this.fixedStation, true);
        }
    }

    private void add(AmFmFixedStationListItem amFmFixedStationListItem, boolean bl) {
        this.mSet.add(amFmFixedStationListItem);
        this.stationsByFreq.put(amFmFixedStationListItem.getFrequency(), amFmFixedStationListItem);
        this.stationsByPi.put(amFmFixedStationListItem.getPi(), amFmFixedStationListItem);
        if (this.mSet.size() > 50) {
            this.deleteOldestEntry(amFmFixedStationListItem);
        }
        this.toPersistence();
    }

    public void remove(AmFmStation amFmStation) {
        int n;
        int n2;
        AmFmFixedStationListItem amFmFixedStationListItem;
        if (logger.isTraceEnabled(128)) {
            LogMessage logMessage = logger.trace(128);
            logMessage.append(RadioUtil.LOG_PREFIX_AMFM).append("removing fixed station: ").append(amFmStation).log();
        }
        if (amFmStation != null && (amFmFixedStationListItem = this.getItem(n2 = amFmStation.getPi(), n = amFmStation.getFrequency())) != null) {
            if (ProgramIdentification.isValidPI(n2)) {
                this.stationsByPi.remove(n2);
            }
            if (n > 0) {
                this.stationsByFreq.remove(n);
            }
            this.mSet.remove(amFmFixedStationListItem);
            this.toPersistence();
        }
    }

    private void deleteOldestEntry(AmFmFixedStationListItem amFmFixedStationListItem) {
        AmFmFixedStationListItem amFmFixedStationListItem2 = null;
        Iterator iterator = this.mSet.iterator();
        while (iterator.hasNext()) {
            AmFmFixedStationListItem amFmFixedStationListItem3 = (AmFmFixedStationListItem)iterator.next();
            if (amFmFixedStationListItem3 == amFmFixedStationListItem) continue;
            if (amFmFixedStationListItem2 == null) {
                amFmFixedStationListItem2 = amFmFixedStationListItem3;
                continue;
            }
            if (amFmFixedStationListItem2.getRatingCounter() >= amFmFixedStationListItem3.getRatingCounter()) continue;
            amFmFixedStationListItem2 = amFmFixedStationListItem3;
        }
        if (amFmFixedStationListItem2 != null) {
            this.stationsByFreq.remove(amFmFixedStationListItem2.getFrequency());
            this.stationsByPi.remove(amFmFixedStationListItem2.getPi());
            this.mSet.remove(amFmFixedStationListItem2);
        }
    }

    private AmFmFixedStationListItem getItem(int n, int n2) {
        AmFmFixedStationListItem amFmFixedStationListItem = null;
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            if (RadioCodingAdapter.isPiActivated() && ProgramIdentification.isValidPI(n)) {
                amFmFixedStationListItem = (AmFmFixedStationListItem)this.stationsByPi.get(n);
                if (ProgramIdentification.isLocalStation(n) && null != amFmFixedStationListItem && amFmFixedStationListItem.getFrequency() != n2) {
                    amFmFixedStationListItem = null;
                }
            }
            if (!RadioCodingAdapter.isPiActivated()) {
                if (AmfmRDSOption.get() && RadioCurrentWaveband.get() == 1 && ProgramIdentification.isValidPI(n)) {
                    amFmFixedStationListItem = (AmFmFixedStationListItem)this.stationsByPi.get(n);
                }
                if (null == amFmFixedStationListItem) {
                    amFmFixedStationListItem = (AmFmFixedStationListItem)this.stationsByFreq.get(n2);
                }
            }
        }
        return amFmFixedStationListItem;
    }

    public String getName(int n, int n2) {
        AmFmFixedStationListItem amFmFixedStationListItem = this.getItem(n, n2);
        if (amFmFixedStationListItem == null) {
            return null;
        }
        amFmFixedStationListItem.alterRatingCounter((short)1);
        return amFmFixedStationListItem.getName();
    }

    public String toString() {
        int n = this.mSet.size();
        StringBuffer stringBuffer = new StringBuffer(270);
        stringBuffer.append("FreezePS(");
        stringBuffer.append(n);
        stringBuffer.append(")");
        Iterator iterator = this.mSet.iterator();
        while (iterator.hasNext()) {
            AmFmFixedStationListItem amFmFixedStationListItem = (AmFmFixedStationListItem)iterator.next();
            stringBuffer.append(amFmFixedStationListItem.toString());
            if (stringBuffer.length() <= 250) continue;
            stringBuffer.append("...");
            break;
        }
        return stringBuffer.toString();
    }

    public void freezePS(AmFmStation amFmStation) {
        if (amFmStation != null && amFmStation.getFrequency() > 0 && amFmStation.getNameLength() > 0) {
            this.fixedStation = new AmFmFixedStationListItem(amFmStation);
        }
    }

    public String getFreezedPS() {
        return this.fixedStation == null ? null : this.fixedStation.getName();
    }

    public void unfreezePS() {
        this.fixedStation = null;
    }

    public AmFmFixedStationListItem getmFreezePs() {
        return this.fixedStation;
    }

    public void fromPersistence() {
        try {
            Iterator iterator;
            List list;
            persistenceWriteAccessBlocked = true;
            this.clear();
            AmFmFixedStationListPersistence amFmFixedStationListPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getAmFmFixedStationListPersistence();
            if (null != amFmFixedStationListPersistence && null != (list = amFmFixedStationListPersistence.getFixedStationListPersistence()) && null != (iterator = list.iterator())) {
                while (iterator.hasNext()) {
                    AmFmFixedStationPersistence amFmFixedStationPersistence = (AmFmFixedStationPersistence)iterator.next();
                    AmFmFixedStationListItem amFmFixedStationListItem = new AmFmFixedStationListItem(amFmFixedStationPersistence);
                    amFmFixedStationListItem.alterRatingCounter((short)-1);
                    this.add(amFmFixedStationListItem, false);
                }
            }
            persistenceWriteAccessBlocked = false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            persistenceWriteAccessBlocked = false;
        }
    }

    public void toPersistence() {
        try {
            List list;
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("AmFmFixedStationListPersistable - toPersistence() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (persistenceWriteAccessBlocked) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - persistenceWriteAccessBlocked == true").log();
                }
                return;
            }
            AmFmFixedStationListPersistence amFmFixedStationListPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getAmFmFixedStationListPersistence();
            if (null != amFmFixedStationListPersistence && null != (list = amFmFixedStationListPersistence.getFixedStationListPersistence())) {
                list.clear();
                Iterator iterator = this.mSet.iterator();
                while (iterator.hasNext()) {
                    AmFmFixedStationListItem amFmFixedStationListItem = (AmFmFixedStationListItem)iterator.next();
                    AmFmFixedStationPersistence amFmFixedStationPersistence = amFmFixedStationListItem.getStationPersistence();
                    list.add(amFmFixedStationPersistence);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    static {
        persistenceWriteAccessBlocked = false;
    }
}

