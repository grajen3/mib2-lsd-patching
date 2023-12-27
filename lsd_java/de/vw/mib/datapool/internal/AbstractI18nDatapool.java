/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.i18n.I18nGuiUpdater;
import de.vw.mib.i18n.I18nLanguage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;

public abstract class AbstractI18nDatapool
implements I18nGuiUpdater {
    protected final Logger logger;
    private I18nLanguage currentLanguage;

    protected AbstractI18nDatapool(LoggerFactory loggerFactory) {
        Preconditions.checkNotNull(loggerFactory, "loggerFactory");
        this.logger = loggerFactory.getLogger(8);
    }

    protected void setCurrentLanguage(I18nLanguage i18nLanguage) {
        this.currentLanguage = i18nLanguage;
    }

    @Override
    public I18nLanguage getCurrentLanguage() {
        return this.currentLanguage;
    }

    protected String getScalarString(int n, String string) {
        if (this.currentLanguage == null) {
            this.issueNoInitialLanguageSet();
            return string;
        }
        try {
            return this.currentLanguage.getScalarString(n);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.issueIdOutOfBoundsException(n, indexOutOfBoundsException);
            return string;
        }
    }

    protected String[] getStringArray(int n, String[] stringArray) {
        if (this.currentLanguage == null) {
            this.issueNoInitialLanguageSet();
            return stringArray;
        }
        try {
            return this.currentLanguage.getStringArray(n);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.issueIdOutOfBoundsException(n, indexOutOfBoundsException);
            return stringArray;
        }
    }

    private void issueNoInitialLanguageSet() {
        LogMessage logMessage = this.logger.error(2048);
        logMessage.append("Could not get an I18n translation: No language set.");
        logMessage.log();
    }

    private void issueIdOutOfBoundsException(int n, IndexOutOfBoundsException indexOutOfBoundsException) {
        LogMessage logMessage = this.logger.error(2048);
        logMessage.append("Could not get an I18n translation for property ID ").append(n);
        logMessage.append(": ").append(indexOutOfBoundsException.getMessage());
        logMessage.log();
    }
}

