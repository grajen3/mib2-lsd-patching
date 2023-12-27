/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import org.dsi.ifc.global.ResourceLocator;

public final class AlertCollector {
    private final String mChannelName;
    private final int mChannelNumber;
    private final ResourceLocator mImage;
    private final boolean mIsSportProgram;
    private final String mTeamAName;
    private final String mTeamBName;
    private final String mTeamAScore;
    private final String mTeamBScore;
    private final String mArtistName;
    private final String mSongName;

    public AlertCollector(String string, int n, ResourceLocator resourceLocator, boolean bl, String string2, String string3, String string4, String string5, String string6, String string7) {
        this.mChannelName = string;
        this.mChannelNumber = n;
        this.mImage = resourceLocator;
        this.mIsSportProgram = bl;
        this.mTeamAName = string2;
        this.mTeamBName = string3;
        this.mTeamAScore = string4;
        this.mTeamBScore = string5;
        this.mArtistName = string6;
        this.mSongName = string7;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public int getChannelNumber() {
        return this.mChannelNumber;
    }

    public ResourceLocator getImage() {
        return this.mImage;
    }

    public boolean isSportProgram() {
        return this.mIsSportProgram;
    }

    public String getTeamAName() {
        return this.mTeamAName;
    }

    public String getTeamBName() {
        return this.mTeamBName;
    }

    public String getTeamAScore() {
        return this.mTeamAScore;
    }

    public String getTeamBScore() {
        return this.mTeamBScore;
    }

    public String getArtistName() {
        return this.mArtistName;
    }

    public String getSongName() {
        return this.mSongName;
    }
}

