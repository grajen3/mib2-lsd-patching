/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.collections.HashCodeBuilder;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public final class SimilarContentCollector {
    public final String mArtistName;
    public final String mChannelName;
    public final String mChannelNumber;
    public final String mTeamA;
    public final String mTeamB;
    public final String mTeamAScore;
    public final String mTeamBScore;
    public final String mSongName;
    public final boolean mIsSportProgram;
    public final ResourceLocator mImage;
    public final int mHashCode;
    public final StationInfo mChannel;

    public SimilarContentCollector(SatDb satDb, StationInfo stationInfo, RadioText radioText) {
        this.mTeamA = "";
        this.mTeamB = "";
        this.mTeamAScore = "";
        this.mTeamBScore = "";
        this.mIsSportProgram = false;
        if (stationInfo != null) {
            this.mChannelNumber = Integer.toString(stationInfo.getStationNumber());
            this.mChannelName = stationInfo.getFullLabel();
            this.mImage = satDb.getImageDb().getImage(stationInfo.sID);
        } else {
            this.mChannelNumber = "";
            this.mImage = null;
            this.mChannelName = "";
        }
        if (radioText != null) {
            this.mArtistName = radioText.getLongArtistName();
            this.mSongName = radioText.getLongProgramTitle();
        } else {
            this.mArtistName = "";
            this.mSongName = "";
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.mChannelNumber);
        hashCodeBuilder.append(this.mChannelName);
        hashCodeBuilder.append(this.mArtistName);
        hashCodeBuilder.append(this.mSongName);
        if (this.mImage == null) {
            hashCodeBuilder.append(0);
            hashCodeBuilder.append("");
        } else {
            hashCodeBuilder.append(this.mImage.getId());
            hashCodeBuilder.append(this.mImage.getUrl());
        }
        this.mChannel = stationInfo;
        this.mHashCode = hashCodeBuilder.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append(this.mChannelName);
        stringBuffer.append('(');
        stringBuffer.append(this.mChannelNumber);
        stringBuffer.append(':');
        stringBuffer.append(this.mChannel.sID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public int hashCode() {
        return this.mHashCode;
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
        SimilarContentCollector similarContentCollector = (SimilarContentCollector)object;
        return this.mHashCode == similarContentCollector.mHashCode;
    }
}

