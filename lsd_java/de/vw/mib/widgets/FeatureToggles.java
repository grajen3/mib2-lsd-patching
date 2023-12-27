/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public final class FeatureToggles {
    private static final String ENABLED;
    private static final String DISABLED;
    private static final String PREFIX;
    public static final int CLASSIFIER_CAR;
    public static final int CLASSIFIER_LOGGING;
    public static final int CLASSIFIER_SPELLER;
    public static final int CLASSIFIER_ALL;
    public static final String LOGGING_SPELLER_WARNINGS_DISABLED;
    public static final String LOGGING_SPELLERMANAGER_WARNINGS_DISABLED;
    public static final String ASIASPELLER_PERMANENT_CONVERSION_DISABLED;
    public static final String OPS_SHOW_DEBUG_TRACK_VALUES_ENABLED;
    public static final String SPELLER_SHOW_ALPHABET_ENABLED;
    public static final String SPELLER_USE_PROJECT_ENABLED;
    public static final String SPELLERMANAGER_ALPHABET_CACHING_DISABLED;

    public static void disableFeatureToggle(String string) {
        System.setProperty(string, Boolean.toString(false));
    }

    public static void enableFeatureToggle(String string) {
        System.setProperty(string, Boolean.toString(true));
    }

    public static String getShortName(String string) {
        return string != null ? string.substring("de.vw.mib.widgets.".length()) : "";
    }

    public static boolean isFeatureToggleEnabled(String string) {
        return Boolean.getBoolean(string);
    }

    public static Iterator iterator() {
        return FeatureToggles.iterator(7);
    }

    public static Iterator iterator(int n) {
        ArrayList arrayList = new ArrayList();
        if ((n & 1) != 0) {
            arrayList.addAll(Arrays.asList(new String[]{"de.vw.mib.widgets.ops.show.debug.track.values.enabled"}));
        }
        if ((n & 2) != 0) {
            arrayList.addAll(Arrays.asList(new String[]{"de.vw.mib.widgets.logging.speller.warnings.disabled", "de.vw.mib.widgets.logging.spellermanager.warnings.disabled"}));
        }
        if ((n & 4) != 0) {
            arrayList.addAll(Arrays.asList(new String[]{"de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled", "de.vw.mib.widgets.speller.show.alphabet.enabled", "de.vw.mib.widgets.speller.use.project.enabled", "de.vw.mib.widgets.spellermanager.alphabet.caching.disabled"}));
        }
        Collections.sort(arrayList);
        return arrayList.iterator();
    }

    private FeatureToggles() {
    }
}

