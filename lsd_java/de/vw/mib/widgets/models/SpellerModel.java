/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.ContainerModel;

public interface SpellerModel
extends AbstractSpellerModel {
    public static final int PID_BASE;
    public static final int PID_LANGUAGE_INDICATOR_REF;
    public static final int PID_LANGUAGE_INDICATOR_DELAY;
    public static final int PID_COUNT_SPELLER;
    public static final int DEFAULT_TIMER_START_DELAY;

    default public ContainerModel get_languageIndicatorRef() {
    }

    default public void set_languageIndicatorRef(ContainerModel containerModel) {
    }

    default public int get_languageIndicatorDelay() {
    }

    default public void set_languageIndicatorDelay(int n) {
    }

    default public void handleLanguageFlagContainer() {
    }
}

