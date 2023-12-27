/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.log;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.log.AbstractWidgetLogger;
import de.vw.mib.widgets.log.SpellerLogger$SpellerLoggerHolder;

public final class SpellerLogger
extends AbstractWidgetLogger {
    private static final int LOG_CLASSIFIER;

    public static SpellerLogger getLogger() {
        return SpellerLogger$SpellerLoggerHolder.SPELLERLOGGER;
    }

    protected SpellerLogger() {
        super(64);
    }

    @Override
    public LogMessage warn() {
        if (FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.logging.speller.warnings.disabled")) {
            return EMPTY_LOGGER.warn(64);
        }
        return super.warn();
    }
}

