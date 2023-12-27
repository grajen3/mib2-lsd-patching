/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import java.util.Arrays;
import java.util.List;

public class PersistenceValidator {
    private static final List SUPPORTED_LAST_CONTENTS = Arrays.asList(new Object[]{"HMI_NAVI", "HMI_TRAFFIC", "HMI_MEDIA", "HMI_PHONE", "HMI_RADIO", "HMI_CAR", "HMI_PICTUREVIEWER", "HMI_VIDEO", "HMI_TVTUNER", "HMI_TRAVELLINK", "HMI_SMARTPHONEINTEGRATION", "HMI_HOMESCREEN", "HMI_KOREA_DMB", "HMI_KOREA_NAV"});

    public static boolean validateLastContentId(String string) {
        return SUPPORTED_LAST_CONTENTS.contains(string);
    }
}

