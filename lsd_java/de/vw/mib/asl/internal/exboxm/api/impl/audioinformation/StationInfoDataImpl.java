/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl.audioinformation;

import de.vw.mib.asl.api.exboxm.audioinformation.StationInfoData;

class StationInfoDataImpl
implements StationInfoData {
    private final int firstId;
    private final String firstInfo;
    private final int firstInfoType;
    private final String fourthInfo;
    private final int fourthInfoType;
    private final String secondInfo;
    private final int secondInfoType;
    private final String thirdInfo;
    private final int thirdInfoType;

    StationInfoDataImpl(int n, String string, int n2, String string2, int n3, String string3, int n4, String string4, int n5) {
        this.firstId = n;
        this.firstInfo = string;
        this.firstInfoType = n2;
        this.fourthInfo = string4;
        this.fourthInfoType = n5;
        this.secondInfo = string2;
        this.secondInfoType = n3;
        this.thirdInfo = string3;
        this.thirdInfoType = n4;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof StationInfoDataImpl)) {
            return false;
        }
        StationInfoDataImpl stationInfoDataImpl = (StationInfoDataImpl)object;
        if (this.firstId != stationInfoDataImpl.firstId) {
            return false;
        }
        if (this.firstInfo == null ? stationInfoDataImpl.firstInfo != null : !this.firstInfo.equals(stationInfoDataImpl.firstInfo)) {
            return false;
        }
        if (this.firstInfoType != stationInfoDataImpl.firstInfoType) {
            return false;
        }
        if (this.fourthInfo == null ? stationInfoDataImpl.fourthInfo != null : !this.fourthInfo.equals(stationInfoDataImpl.fourthInfo)) {
            return false;
        }
        if (this.fourthInfoType != stationInfoDataImpl.fourthInfoType) {
            return false;
        }
        if (this.secondInfo == null ? stationInfoDataImpl.secondInfo != null : !this.secondInfo.equals(stationInfoDataImpl.secondInfo)) {
            return false;
        }
        if (this.secondInfoType != stationInfoDataImpl.secondInfoType) {
            return false;
        }
        if (this.thirdInfo == null ? stationInfoDataImpl.thirdInfo != null : !this.thirdInfo.equals(stationInfoDataImpl.thirdInfo)) {
            return false;
        }
        return this.thirdInfoType == stationInfoDataImpl.thirdInfoType;
    }

    @Override
    public int getPrimaryID() {
        return this.firstId;
    }

    @Override
    public String getPrimaryInfo() {
        return this.firstInfo;
    }

    @Override
    public int getPrimaryInfoType() {
        return this.firstInfoType;
    }

    @Override
    public String getQuaternaryInfo() {
        return this.fourthInfo;
    }

    @Override
    public int getQuaternaryInfoType() {
        return this.fourthInfoType;
    }

    @Override
    public String getSecondaryInfo() {
        return this.secondInfo;
    }

    @Override
    public int getSecondaryInfoType() {
        return this.secondInfoType;
    }

    @Override
    public String getTertiaryInfo() {
        return this.thirdInfo;
    }

    @Override
    public int getTertiaryInfoType() {
        return this.thirdInfoType;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.firstId;
        n2 = 31 * n2 + (this.firstInfo == null ? 0 : this.firstInfo.hashCode());
        n2 = 31 * n2 + this.firstInfoType;
        n2 = 31 * n2 + (this.fourthInfo == null ? 0 : this.fourthInfo.hashCode());
        n2 = 31 * n2 + this.fourthInfoType;
        n2 = 31 * n2 + (this.secondInfo == null ? 0 : this.secondInfo.hashCode());
        n2 = 31 * n2 + this.secondInfoType;
        n2 = 31 * n2 + (this.thirdInfo == null ? 0 : this.thirdInfo.hashCode());
        n2 = 31 * n2 + this.thirdInfoType;
        return n2;
    }
}

