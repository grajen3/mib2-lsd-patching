/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.internal.media.common.MediaConstants$1;
import de.vw.mib.collections.ObjectOptHashSet;

public final class MediaConstants
implements IMediaConstants {
    public static final int MAX_DEVICES;
    private static final ObjectOptHashSet I18N_STRING_SET;

    private MediaConstants() {
    }

    public static String deleteI18nTags(String string) {
        if (I18N_STRING_SET.contains(string)) {
            return "";
        }
        return string;
    }

    static {
        I18N_STRING_SET = new MediaConstants$1(59);
    }
}

