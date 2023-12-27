/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.TagInformation;

public interface DSIRadioTagging
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_COMPATIBLEDEVAVAIL;
    public static final int RT_TAGSONG;
    public static final int RT_TAGAMBIGUOUSSONG;
    public static final int RT_GROUPTAGS;
    public static final int RP_TAGRESULT;
    public static final int RP_GROUPTAGSRESULT;
    public static final int TAGRESULT_OK;
    public static final int TAGRESULT_ERROR;
    public static final int TAGRESULT_TARGETMEMORY_FULL;
    public static final int DEVICESTATUS_NODEVICE;
    public static final int DEVICESTATUS_AVAILABLE;
    public static final int DEVICESTATUS_NOT_SUPPORTED;
    public static final int DEVICESTATUS_ERROR;

    default public void tagSong(TagInformation tagInformation) {
    }

    default public void tagAmbiguousSong(TagInformation tagInformation, TagInformation tagInformation2) {
    }

    default public void groupTags(int n) {
    }
}

