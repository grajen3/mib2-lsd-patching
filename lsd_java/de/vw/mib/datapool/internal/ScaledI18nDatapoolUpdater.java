/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.i18n.I18nGuiUpdater;
import de.vw.mib.i18n.I18nLanguage;
import de.vw.mib.i18n.I18nTableDecoder;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.io.File;
import java.io.IOException;

public class ScaledI18nDatapoolUpdater
implements NvListener {
    private static final String DOT_RES;
    private static final String CLUSTER_SIZE_SEPARATOR;
    private final I18nGuiUpdater i18nGuiUpdater;
    private final ConfigurationManager configurationManager;
    private final I18nTableDecoder i18nTableDecoder;
    private final Logger logger;

    public ScaledI18nDatapoolUpdater(I18nGuiUpdater i18nGuiUpdater, ConfigurationManager configurationManager, I18nTableDecoder i18nTableDecoder, LoggerFactory loggerFactory) {
        Preconditions.checkNotNull(i18nGuiUpdater, "i18nGuiUpdater");
        Preconditions.checkNotNull(loggerFactory, "loggerFactory");
        this.i18nGuiUpdater = i18nGuiUpdater;
        this.configurationManager = configurationManager;
        this.i18nTableDecoder = i18nTableDecoder;
        this.logger = loggerFactory.getLogger(8);
    }

    @Override
    public void notifyNvListener(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: {
                this.updateLanguage();
                break;
            }
            default: {
                this.logUnknownNotficationKey(n);
            }
        }
    }

    public void startListening() {
        this.configurationManager.addNvListener(this, 4);
        this.configurationManager.addNvListener(this, 3);
        this.configurationManager.addNvListener(this, 2);
    }

    public void updateLanguage() {
        String string = this.getNewLanguageTag();
        String string2 = this.configurationManager.getCurrentI18nPath();
        I18nLanguage i18nLanguage = this.tryLoadingLanguage(string, string2);
        this.i18nGuiUpdater.languageChanged(string, i18nLanguage);
    }

    private String getNewLanguageTag() {
        String string = this.configurationManager.getCurrentGuiLanguage();
        int n = this.configurationManager.getInstrumentClusterSize();
        return new StringBuffer().append(string).append("-").append(n).toString();
    }

    private I18nLanguage tryLoadingLanguage(String string, String string2) {
        this.logLanguageChange(string);
        try {
            File file = this.getI18nResourceFile(string, string2);
            return this.loadLanguage(file);
        }
        catch (IOException iOException) {
            this.logLanguageChangeFailed(string, iOException);
            return null;
        }
    }

    private File getI18nResourceFile(String string, String string2) {
        return new File(string2, new StringBuffer().append(string).append(".res").toString());
    }

    private I18nLanguage loadLanguage(File file) {
        if (!file.exists()) {
            throw new IOException(new StringBuffer().append("Resource not exists: '").append(file).append("'").toString());
        }
        I18nLanguage i18nLanguage = this.i18nTableDecoder.loadI18nDeltaTable(file);
        return i18nLanguage;
    }

    private void logLanguageChange(String string) {
        LogMessage logMessage = this.logger.info(2048);
        logMessage.append("Loading display size dependent translations.");
        logMessage.append(" Language tag: ").append(string);
        logMessage.log();
    }

    private void logLanguageChangeFailed(String string, Exception exception) {
        LogMessage logMessage = this.logger.error(2048);
        logMessage.append("Disable display size dependent translations.");
        logMessage.append(" Language tag: ").append(string);
        logMessage.append(" Failed to load resource: ").append(exception.getMessage());
        logMessage.log();
    }

    private void logUnknownNotficationKey(int n) {
        LogMessage logMessage = this.logger.info(2048);
        logMessage.append("Ignore unknown notifivation from Configuration manager.");
        logMessage.append(" Notification value: ").append(n);
        logMessage.log();
    }
}

