/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.recorder;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.common.MediaConstants;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public class RecorderBrowserActiveSource {
    private static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;

    public static void update(MediaBrowserState mediaBrowserState) {
        MediaCollector mediaCollector;
        int n = 0;
        boolean bl = false;
        MediaCollector mediaCollector2 = mediaCollector = mediaBrowserState != null ? mediaBrowserState.getBrowseMedia() : null;
        if (mediaCollector != null) {
            n = RecorderBrowserActiveSource.getImportAslDeviceID(mediaCollector.getAslDeviceID());
            bl = mediaCollector.getMedium().getParent().getCurrentState().isMultiPartition();
        }
        DATA_POOL.valueChangedInteger(11, n);
        DATA_POOL.valueChangedBoolean(3625, bl);
    }

    public static void updatePrepareScreen(MediaCollector mediaCollector) {
        int n = 0;
        String string = "";
        int n2 = 0;
        if (mediaCollector != null) {
            n = RecorderBrowserActiveSource.getImportAslDeviceID(mediaCollector.getAslDeviceID());
            string = mediaCollector.getName();
            n2 = 0;
        }
        DATA_POOL.valueChangedInteger(11, n);
        DATA_POOL.valueChangedString(77, MediaConstants.deleteI18nTags(string));
        DATA_POOL.valueChangedInteger(76, n2);
    }

    private static int getImportAslDeviceID(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 10: {
                return 5;
            }
            case 8: {
                return 3;
            }
            case 13: {
                return 6;
            }
        }
        return 0;
    }
}

