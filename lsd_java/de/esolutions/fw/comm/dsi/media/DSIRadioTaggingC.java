/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import org.dsi.ifc.media.TagInformation;

public interface DSIRadioTaggingC {
    default public void tagSong(TagInformation tagInformation) {
    }

    default public void tagAmbiguousSong(TagInformation tagInformation, TagInformation tagInformation2) {
    }

    default public void groupTags(int n) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

