/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.media.asl;

import de.vw.mib.asl.internal.kombipictureserver.common.api.media.asl.MediaCoverArtService;

public interface MediaCoverArtDelegate {
    public static final int MEDIA_COVER_ART_COVER_ART;
    public static final int[] MEDIA_COVER_ART_PROPERTIES;

    default public void updateMediaCoverArt(MediaCoverArtService mediaCoverArtService, int n) {
    }

    static {
        MEDIA_COVER_ART_PROPERTIES = new int[]{58};
    }
}

