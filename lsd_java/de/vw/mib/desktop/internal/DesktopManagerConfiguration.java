/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

public final class DesktopManagerConfiguration {
    public static final boolean DEBUG;
    public static final int ACTIVATE_EARLY_AT_DEFAULT;
    public static final boolean PANIC_ENABLED;
    public static final boolean DISABLE_MAINVIEWREACTIVATION;
    public static final String ACTIVATE_EARLY_AT_XX_PERCENT;
    public static final boolean AGITATE_POPUPS;
    public static final boolean DEACTIVATE_HERO_ANIMATION;
    public static final String SHORTVIEWHANDLERNAME_HOMESCREEN;
    public static final String SHORTSCREENAREANAME_HOMESCREENTRANSITION;

    private DesktopManagerConfiguration() {
    }

    static {
        PANIC_ENABLED = "enabled".equals(System.getProperty("ErrorHandling.showViewCreationError")) || "true".equals(System.getProperty("de.vw.mib.desktop.showViewError"));
        DISABLE_MAINVIEWREACTIVATION = System.getProperty("de.vw.mib.legacy.DisableReactivation") != null;
        ACTIVATE_EARLY_AT_XX_PERCENT = System.getProperty("de.vw.mib.legacy.activateEarlyAt");
        AGITATE_POPUPS = System.getProperty("de.vw.mib.legacy.agitatePopups") != null;
        DEACTIVATE_HERO_ANIMATION = System.getProperty("de.vw.mib.desktop.deactivateHeroAnimation") != null;
    }
}

