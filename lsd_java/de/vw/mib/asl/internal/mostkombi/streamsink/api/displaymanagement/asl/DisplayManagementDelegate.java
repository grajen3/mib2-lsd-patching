/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl;

import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;

public interface DisplayManagementDelegate {
    public static final int DISPLAY_MANAGEMENT_KOMBI_DISPLAY;
    public static final int DISPLAY_MANAGEMENT_DATA_FRAME_RATE;
    public static final int[] DISPLAY_MANAGEMENT_PROPERTIES;

    default public void updateDisplayManagement(DisplayManagementService displayManagementService, int n) {
    }

    static {
        DISPLAY_MANAGEMENT_PROPERTIES = new int[]{976363520, 993140736};
    }
}

