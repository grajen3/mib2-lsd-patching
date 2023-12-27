/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.lists;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPersistenceService;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;

public final class AmFmFixedStationListItem {
    private static final int MAX_RATING;
    private static final int MIN_RATING;
    private AmFmFixedStationPersistence stationPersistence = null;

    public AmFmFixedStationListItem(AmFmFixedStationPersistence amFmFixedStationPersistence) {
        this.stationPersistence = amFmFixedStationPersistence;
    }

    public AmFmFixedStationListItem(AmFmStation amFmStation) {
        AmFmPersistenceService amFmPersistenceService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getRadioPersistenceService();
        if (null != amFmPersistenceService) {
            this.stationPersistence = amFmPersistenceService.createAmFmFixedStationPersistence();
            this.stationPersistence.setPi(amFmStation.getPi());
            this.stationPersistence.setFrequency(amFmStation.getFrequency());
            this.stationPersistence.setShortName(amFmStation.getShortNameHD());
            this.stationPersistence.setName(amFmStation.getName());
            this.stationPersistence.setRatingCounter((short)0);
            this.stationPersistence.setSubChannel(amFmStation.getSubChannel());
        }
    }

    public void clear() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("[ NAME : ");
        if (null != this.stationPersistence) {
            stringBuffer.append(this.stationPersistence.getName());
            stringBuffer.append(" SHORTNAME : ");
            stringBuffer.append(this.stationPersistence.getShortName());
            if (this.stationPersistence.getPi() > 0) {
                stringBuffer.append("-P(");
                stringBuffer.append(Integer.toHexString(this.stationPersistence.getPi()));
                stringBuffer.append(")");
            }
            stringBuffer.append("-F(");
            stringBuffer.append(this.stationPersistence.getFrequency());
            stringBuffer.append(")-R(");
            stringBuffer.append(this.stationPersistence.getRatingCounter());
            stringBuffer.append(")]");
        }
        return stringBuffer.toString();
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        if (null != this.stationPersistence) {
            n2 = 31 * n2 + this.stationPersistence.getFrequency();
            String string = this.stationPersistence.getName();
            n2 = 31 * n2 + (string == null ? 0 : string.hashCode());
            n2 = 31 * n2 + this.stationPersistence.getPi();
            String string2 = this.stationPersistence.getShortName();
            n2 = 31 * n2 + (string2 == null ? 0 : string2.hashCode());
            n2 = 31 * n2 + this.stationPersistence.getSubChannel();
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AmFmFixedStationListItem amFmFixedStationListItem = (AmFmFixedStationListItem)object;
        if (null == this.stationPersistence || null == amFmFixedStationListItem.stationPersistence) {
            return true;
        }
        int n = amFmFixedStationListItem.stationPersistence.getFrequency();
        String string = amFmFixedStationListItem.stationPersistence.getName();
        int n2 = amFmFixedStationListItem.stationPersistence.getPi();
        String string2 = amFmFixedStationListItem.stationPersistence.getShortName();
        int n3 = amFmFixedStationListItem.stationPersistence.getSubChannel();
        int n4 = this.stationPersistence.getFrequency();
        String string3 = this.stationPersistence.getName();
        int n5 = this.stationPersistence.getPi();
        String string4 = this.stationPersistence.getShortName();
        int n6 = this.stationPersistence.getSubChannel();
        if (n4 != n) {
            return false;
        }
        if (string3 == null ? string != null : !string3.equals(string)) {
            return false;
        }
        if (n5 != n2) {
            return false;
        }
        if (string4 == null ? string2 != null : !string4.equals(string2)) {
            return false;
        }
        return n6 == n3;
    }

    public int getFrequency() {
        if (null != this.stationPersistence) {
            return this.stationPersistence.getFrequency();
        }
        return 0;
    }

    public int getPi() {
        if (null != this.stationPersistence) {
            return this.stationPersistence.getPi();
        }
        return 0;
    }

    public String getName() {
        if (null != this.stationPersistence) {
            return this.stationPersistence.getName();
        }
        return "";
    }

    public String getShortName() {
        if (null != this.stationPersistence) {
            return this.stationPersistence.getShortName();
        }
        return "";
    }

    public int getSubChannel() {
        if (null != this.stationPersistence) {
            return this.stationPersistence.getSubChannel();
        }
        return 0;
    }

    public void alterRatingCounter(short s) {
        if (null != this.stationPersistence) {
            int n = this.stationPersistence.getRatingCounter() + s;
            if (n < Short.MIN_VALUE) {
                n = Short.MIN_VALUE;
            } else if (n > Short.MAX_VALUE) {
                n = Short.MAX_VALUE;
            }
            this.stationPersistence.setRatingCounter((short)n);
        }
    }

    public short getRatingCounter() {
        if (null != this.stationPersistence) {
            return this.stationPersistence.getRatingCounter();
        }
        return 0;
    }

    public AmFmFixedStationPersistence getStationPersistence() {
        return this.stationPersistence;
    }
}

