/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.RadioCodingAdapter;

final class RadiotextData {
    private boolean mDirty = false;
    private String mText;
    private String mArtist;
    private String mTitle;

    RadiotextData() {
        this.mText = "";
        this.mArtist = "";
        this.mTitle = "";
    }

    RadiotextData(RadiotextData radiotextData) {
        this.mText = radiotextData.mText;
        this.mArtist = radiotextData.mArtist;
        this.mTitle = radiotextData.mTitle;
    }

    void setText(String string) {
        this.mDirty = true;
        this.mText = string;
    }

    void setArtistAndTitle(String string, String string2) {
        this.mDirty = true;
        this.mArtist = string;
        this.mTitle = string2;
    }

    String getText() {
        this.mDirty = false;
        return this.mText;
    }

    String getArtist() {
        this.mDirty = false;
        return this.mArtist;
    }

    String getTitle() {
        this.mDirty = false;
        return this.mTitle;
    }

    boolean isDirty() {
        if (!RadioCodingAdapter.isPiActivated()) {
            if (this.mDirty && (null != this.mText && this.mText.length() > 0 || this.isPlus())) {
                return this.mDirty;
            }
            return false;
        }
        return this.mDirty;
    }

    boolean isPlus() {
        return this.mArtist.length() > 0 || this.mTitle.length() > 0;
    }
}

