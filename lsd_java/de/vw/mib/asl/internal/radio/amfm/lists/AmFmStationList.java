/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListAM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.genericevents.GenericEventException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.dsi.ifc.radio.Station;

public abstract class AmFmStationList {
    private static final int NOT_IN_LIST;
    private static final int IN_LIST_NO_NAME;
    private static final int IN_LIST_VALID_NAME;
    public TreeSet stationList;
    protected boolean piMode;
    private static boolean listItemPressed;

    protected AmFmStationList(Comparator comparator) {
        this.stationList = new TreeSet(comparator);
    }

    public boolean add(AmFmStation amFmStation) {
        if (null != amFmStation && null != this.stationList) {
            AmFmStation amFmStation2 = new AmFmStation(amFmStation);
            amFmStation2.setRdsPiIgnoreProperties();
            return this.stationList.add(amFmStation2);
        }
        return false;
    }

    public void add(AmFmStation[] amFmStationArray) {
        if (null != amFmStationArray && null != this.stationList) {
            for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
                this.add(amFmStationArray[i2]);
            }
        }
    }

    public void addCurrentStation(AmFmStation amFmStation) {
        if (amFmStation != null && null != this.stationList) {
            AmFmStation amFmStation2 = new AmFmStation(amFmStation);
            amFmStation2.setRdsPiIgnoreProperties();
            if (amFmStation2.getWaveband() == 1) {
                AmFmStationListFM.setFmStationName(amFmStation2);
            }
            if (amFmStation2.isCoChannel()) {
                amFmStation2.setName("");
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2) && (RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDFilter() && RadioCurrentWaveband.isAm() || RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter() && RadioCurrentWaveband.isFm())) {
                if (amFmStation2.isHD()) {
                    this.stationList.add(amFmStation2);
                }
            } else {
                this.stationList.add(amFmStation2);
            }
        }
    }

    public void add(Set set) {
        if (set != null) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                this.add((AmFmStation)iterator.next());
            }
        }
    }

    public boolean contains(AmFmStation amFmStation) {
        if (null != this.stationList) {
            return this.stationList.contains(amFmStation);
        }
        return false;
    }

    public boolean contains(Station station) {
        if (null != this.stationList) {
            return this.stationList.contains(new AmFmStation(station));
        }
        return false;
    }

    public Iterator getStationListIterator() {
        if (null != this.stationList) {
            return this.stationList.iterator();
        }
        return null;
    }

    public void clear() {
        if (null != this.stationList) {
            this.stationList.clear();
        }
    }

    public AmFmStation[] toArray() {
        if (null != this.stationList) {
            return (AmFmStation[])this.stationList.toArray(new AmFmStation[this.stationList.size()]);
        }
        return new AmFmStation[0];
    }

    public int size() {
        if (null == this.stationList) {
            return 0;
        }
        return this.stationList.size();
    }

    public int indexOf(AmFmStation amFmStation) {
        if (null != this.stationList && amFmStation != null) {
            int n = -1;
            Comparator comparator = this.stationList.comparator();
            Iterator iterator = this.getStationListIterator();
            if (null != iterator) {
                while (iterator.hasNext()) {
                    AmFmStation amFmStation2 = (AmFmStation)iterator.next();
                    ++n;
                    if (comparator != null && comparator.compare(amFmStation, amFmStation2) == 0) {
                        return n;
                    }
                    if (comparator != null || !amFmStation2.equals(amFmStation)) continue;
                    return n;
                }
            }
        }
        return -1;
    }

    public int indexOf(AmFmStation amFmStation, TreeSet treeSet) {
        if (amFmStation != null && treeSet != null) {
            int n = -1;
            Comparator comparator = treeSet.comparator();
            Iterator iterator = treeSet.iterator();
            if (null != iterator) {
                while (iterator.hasNext()) {
                    AmFmStation amFmStation2 = (AmFmStation)iterator.next();
                    ++n;
                    if (comparator != null && comparator.compare(amFmStation, amFmStation2) == 0) {
                        return n;
                    }
                    if (comparator != null || !amFmStation2.equals(amFmStation)) continue;
                    return n;
                }
            }
        }
        return -1;
    }

    public int indexOfWithFrequency(AmFmStation amFmStation) {
        if (amFmStation != null) {
            int n = -1;
            Iterator iterator = this.getStationListIterator();
            if (null != iterator) {
                while (iterator.hasNext()) {
                    AmFmStation amFmStation2 = (AmFmStation)iterator.next();
                    ++n;
                    if (amFmStation2.getFrequency() != amFmStation.getFrequency()) continue;
                    return n;
                }
            }
        }
        return -1;
    }

    public int deleteCurrentStationInList(AmFmStation amFmStation) {
        int n = -1;
        if (amFmStation != null && null != this.stationList) {
            int n2 = amFmStation.getPi();
            int n3 = amFmStation.getFrequency();
            int n4 = amFmStation.getServiceId();
            AmFmStation amFmStation2 = null;
            boolean bl = false;
            if (RadioCurrentWaveband.isFm() && AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated() && !amFmStation.isCoChannel()) {
                Iterator iterator = this.getStationListIterator();
                if (null == iterator) {
                    return -1;
                }
                while (iterator.hasNext()) {
                    amFmStation2 = (AmFmStation)iterator.next();
                    int n5 = amFmStation2.getPi();
                    int n6 = amFmStation2.getFrequency();
                    ++n;
                    if (n6 == n3) {
                        bl = true;
                        break;
                    }
                    if (ProgramIdentification.isValidPI(n2)) {
                        if (n2 != n5) continue;
                        if (AmFmAlternativeFrequencySwitch.get() && !ProgramIdentification.isLocalStation(n2)) {
                            bl = true;
                            break;
                        }
                        if (n6 != n3) continue;
                        bl = true;
                        break;
                    }
                    if (ProgramIdentification.isValidPI(n5) || n6 != n3) continue;
                    bl = true;
                    break;
                }
                if (bl && amFmStation2 != null) {
                    this.stationList.remove(amFmStation2);
                }
            } else {
                Iterator iterator = this.getStationListIterator();
                if (null != iterator) {
                    while (iterator.hasNext()) {
                        amFmStation2 = (AmFmStation)iterator.next();
                        int n7 = amFmStation2.getFrequency();
                        int n8 = amFmStation2.getServiceId();
                        ++n;
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                            if (n7 != n3 || n8 != n4) continue;
                            bl = true;
                            break;
                        }
                        if (n7 != n3) continue;
                        bl = true;
                        break;
                    }
                    if (bl && amFmStation2 != null) {
                        this.stationList.remove(amFmStation2);
                    }
                }
            }
        }
        return n;
    }

    protected int relativeIndexOf(AmFmStation amFmStation) {
        int n = -1;
        if (amFmStation != null) {
            Comparator comparator = this.stationList.comparator();
            Iterator iterator = this.getStationListIterator();
            if (null != iterator) {
                while (iterator.hasNext()) {
                    AmFmStation amFmStation2 = (AmFmStation)iterator.next();
                    ++n;
                    if (comparator == null || comparator.compare(amFmStation, amFmStation2) >= 0) continue;
                    return n - 1;
                }
            }
        }
        return -1;
    }

    public AmFmStation get(int n) {
        if (null != this.stationList && n >= 0 && n < this.stationList.size()) {
            int n2 = 0;
            Iterator iterator = this.getStationListIterator();
            if (null != iterator) {
                while (iterator.hasNext()) {
                    AmFmStation amFmStation = (AmFmStation)iterator.next();
                    if (n2 == n) {
                        return amFmStation;
                    }
                    ++n2;
                }
            }
        }
        return null;
    }

    public void setCurrentIndex(int n) {
        if (n < 0 || n >= this.size()) {
            throw new GenericEventException(new StringBuffer().append("Station list index ").append(n).append(" out of range, max index is ").append(this.size() - 1).toString());
        }
        int n2 = 0;
        Iterator iterator = this.getStationListIterator();
        if (null != iterator) {
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (n2 == n) {
                    RadioData.getAmfmDatabase().setCurrentStation(amFmStation);
                    break;
                }
                ++n2;
            }
        }
    }

    public void writeInFileLogger() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        Object[] objectArray = new AmFmStation[this.size()];
        objectArray = (AmFmStation[])this.stationList.toArray(objectArray);
        stringBuffer.append("AslStationList[");
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            stringBuffer.append("(");
            stringBuffer.append(((AmFmStation)objectArray[i2]).toString());
            stringBuffer.append(")");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public int containsFrequency(int n) {
        int n2 = 0;
        AmFmStation amFmStation = this.getByFrequency(n);
        if (amFmStation != null) {
            n2 = amFmStation.getNameLength() > 0 ? 2 : 1;
        }
        return n2;
    }

    public boolean containsStationWithFrequencyAndServiceID(int n, int n2) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (amFmStation.getFrequency() != n || amFmStation.getServiceId() != n2 && (n2 > 1 || amFmStation.getServiceId() > 1)) continue;
                return true;
            }
        }
        return false;
    }

    public AmFmStation getByFrequency(int n) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (amFmStation.getFrequency() != n) continue;
                return amFmStation;
            }
        }
        return null;
    }

    public AmFmStation getByFrequencyAndPi(int n, int n2) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (amFmStation.getFrequency() != n) continue;
                if (!RadioCodingAdapter.isPiActivated()) {
                    return amFmStation;
                }
                if (amFmStation.getPi() != n2) continue;
                return amFmStation;
            }
        }
        return null;
    }

    public AmFmStation getByFrequencyAndSubChannel(int n, int n2) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (amFmStation.getFrequency() != n || amFmStation.getServiceId() != n2 && (amFmStation.getServiceId() > 1 || n2 > 1)) continue;
                return amFmStation;
            }
        }
        return null;
    }

    public AmFmStation getStationWithFrequencyHDAndSubChannel(int n, boolean bl, int n2) {
        Iterator iterator = this.stationList.iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation = (AmFmStation)iterator.next();
            if (amFmStation.getFrequency() != n || amFmStation.isHD() != bl || amFmStation.getServiceId() != n2) continue;
            return amFmStation;
        }
        return null;
    }

    public AmFmStation getByID(long l) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (RadioUtil.computeUniqueID(amFmStation) != l) continue;
                return amFmStation;
            }
        }
        return null;
    }

    public AmFmStation getByStationId(long l) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (amFmStation.getUniqueId() != l) continue;
                return amFmStation;
            }
        }
        return null;
    }

    public AmFmStation getByDatabaseId(long l) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if ((long)amFmStation.getDbStationId() != l) continue;
                return amFmStation;
            }
        }
        return null;
    }

    public int getIndexByStationId(long l) {
        if (null != this.stationList) {
            Iterator iterator = this.stationList.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (amFmStation.getUniqueId() == l) {
                    return n;
                }
                ++n;
            }
        }
        return -1;
    }

    public boolean setNameForPI(int n, String string) {
        boolean bl = false;
        Iterator iterator = this.stationList.iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation = (AmFmStation)iterator.next();
            if (amFmStation.getPi() != n) continue;
            amFmStation.setName(string);
            bl = true;
            break;
        }
        return bl;
    }

    public boolean setNameForFrequency(int n, String string) {
        boolean bl = false;
        Iterator iterator = this.stationList.iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation = (AmFmStation)iterator.next();
            if (amFmStation.getFrequency() != n) continue;
            if (amFmStation.isHD()) {
                amFmStation.setShortNameHD(string);
            } else {
                amFmStation.setName(string);
            }
            bl = true;
            break;
        }
        return bl;
    }

    public TreeSet getListAsTreeSet() {
        return this.stationList;
    }

    public Set getListCopy() {
        if (null != this.stationList) {
            TreeSet treeSet = new TreeSet(this.stationList.comparator());
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                AmFmStation amFmStation2 = new AmFmStation(amFmStation);
                if (amFmStation2.getWaveband() == 1) {
                    AmFmStationListFM.setFmStationName(amFmStation2);
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    if (RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDFilter() && RadioCurrentWaveband.isAm() || RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter() && RadioCurrentWaveband.isFm()) {
                        if (!amFmStation2.isHD()) continue;
                        treeSet.add(amFmStation2);
                        continue;
                    }
                    treeSet.add(amFmStation2);
                    continue;
                }
                treeSet.add(amFmStation2);
            }
            return treeSet;
        }
        return null;
    }

    public AmFmStation[] getDeepListCopy() {
        if (null != this.stationList) {
            AmFmStation[] amFmStationArray = new AmFmStation[this.stationList.size()];
            Iterator iterator = this.stationList.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                AmFmStation amFmStation2 = new AmFmStation(amFmStation);
                if (n > -1 && n < amFmStationArray.length) {
                    amFmStationArray[n] = amFmStation2;
                }
                ++n;
            }
            return amFmStationArray;
        }
        return null;
    }

    public AmFmStationList generateFrozenFmList(AmFmStation amFmStation) {
        AmFmStationListFM amFmStationListFM = new AmFmStationListFM(AmFmFactory.getInstanceEUStationListViewWalker().getFmComparator());
        amFmStationListFM.add(this.getListCopy());
        if (null != amFmStation) {
            AmFmStation amFmStation2 = new AmFmStation(amFmStation);
            amFmStationListFM.deleteCurrentStationInList(amFmStation2);
            amFmStationListFM.addCurrentStation(amFmStation2);
        }
        return amFmStationListFM;
    }

    public AmFmStationList generateFrozenAmList(AmFmStation amFmStation) {
        AmFmStationListAM amFmStationListAM = new AmFmStationListAM();
        amFmStationListAM.add(this.getListCopy());
        if (null != amFmStation) {
            AmFmStation amFmStation2 = new AmFmStation(amFmStation);
            amFmStationListAM.deleteCurrentStationInList(amFmStation2);
            amFmStationListAM.addCurrentStation(amFmStation2);
        }
        return amFmStationListAM;
    }

    public Object[] getListCopyAsArray() {
        if (null != this.stationList) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDFilter()) {
                    Object[] objectArray = this.stationList.toArray();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < objectArray.length; ++i2) {
                        if (!((AmFmStation)objectArray[i2]).isHD()) continue;
                        arrayList.add(objectArray[i2]);
                    }
                    Object[] objectArray2 = arrayList.toArray(new Object[arrayList.size()]);
                    return objectArray2;
                }
                return this.stationList.toArray();
            }
            return this.stationList.toArray();
        }
        return null;
    }

    public abstract void updateStationListToHMI() {
    }

    public abstract void toggleStation(int n) {
    }

    public boolean remove(AmFmStation amFmStation) {
        boolean bl = false;
        if (null != amFmStation) {
            bl = this.stationList.remove(amFmStation);
        }
        return bl;
    }

    public static void setListItemPressed(boolean bl) {
        listItemPressed = bl;
    }

    public static boolean isListItemPressed() {
        return listItemPressed;
    }

    public static Station[] copyStationList(Station[] stationArray) {
        Station[] stationArray2 = null;
        if (null != stationArray) {
            stationArray2 = new Station[stationArray.length];
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                stationArray2[i2] = null == stationArray[i2] ? null : new Station(stationArray[i2].name, stationArray[i2].frequency, stationArray[i2].pi, stationArray[i2].receptionQuality, stationArray[i2].ptyCode, stationArray[i2].waveband, stationArray[i2].rds, stationArray[i2].tp, stationArray[i2].ta, stationArray[i2].tmc, stationArray[i2].scrollingPS, stationArray[i2].radioText, stationArray[i2].realPS, stationArray[i2].hd, stationArray[i2].shortNameHD, stationArray[i2].longNameHD, stationArray[i2].fullDigital, stationArray[i2].serviceId, stationArray[i2].subscription, stationArray[i2].eon, stationArray[i2].coChannel, stationArray[i2].stationArt);
            }
        }
        return stationArray2;
    }

    static {
        listItemPressed = false;
    }
}

