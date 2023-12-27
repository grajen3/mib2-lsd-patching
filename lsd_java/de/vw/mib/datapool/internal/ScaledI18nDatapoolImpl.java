/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.datapool.I18nDatapool;
import de.vw.mib.datapool.ScaledI18nDatapool;
import de.vw.mib.datapool.ScaledI18nListener;
import de.vw.mib.datapool.internal.AbstractI18nDatapool;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.i18n.I18nGuiUpdater;
import de.vw.mib.i18n.I18nLanguage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.LoggerFactory;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

public class ScaledI18nDatapoolImpl
extends AbstractI18nDatapool
implements ScaledI18nDatapool,
I18nGuiUpdater {
    private final I18nDatapool i18nDatapool;
    private String currentLanguageTag;
    private CopyOnWriteArrayList listeners = new CopyOnWriteArrayList();

    public ScaledI18nDatapoolImpl(I18nDatapool i18nDatapool, LoggerFactory loggerFactory) {
        super(loggerFactory);
        this.i18nDatapool = i18nDatapool;
    }

    @Override
    public String getScaledString(int n) {
        String string = this.getString(n);
        if (string != null) {
            return string;
        }
        this.logScaledTranslationNotAvailableWarning(n);
        return this.i18nDatapool.getString(n);
    }

    @Override
    public String[] getScaledStrings(int n) {
        String[] stringArray = this.getStrings(n);
        if (stringArray != null) {
            return stringArray;
        }
        this.logScaledTranslationNotAvailableWarning(n);
        return this.i18nDatapool.getStrings(n);
    }

    @Override
    public void languageChanged(String string, I18nLanguage i18nLanguage) {
        if (i18nLanguage != this.getCurrentLanguage()) {
            this.setCurrentLanguage(i18nLanguage);
            this.currentLanguageTag = string;
            this.updateListeners();
        }
    }

    @Override
    public void addListener(ScaledI18nListener scaledI18nListener) {
        Preconditions.checkNotNull(scaledI18nListener, "listener");
        Preconditions.checkArgument(!this.listeners.contains(scaledI18nListener), "Listener already added.");
        this.listeners.add(scaledI18nListener);
    }

    @Override
    public void removeListener(ScaledI18nListener scaledI18nListener) {
        Preconditions.checkNotNull(scaledI18nListener, "listener");
        Preconditions.checkArgument(this.listeners.contains(scaledI18nListener), "Listener was not added and can't be removed from register.");
        this.listeners.remove(scaledI18nListener);
    }

    private void updateListeners() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ScaledI18nListener scaledI18nListener = (ScaledI18nListener)iterator.next();
            scaledI18nListener.onUpdateScaledI18n(this);
        }
    }

    private String getString(int n) {
        return this.getScalarString(n, null);
    }

    private String[] getStrings(int n) {
        return this.getStringArray(n, null);
    }

    private void logScaledTranslationNotAvailableWarning(int n) {
        LogMessage logMessage = this.logger.warn(2048);
        logMessage.append("Could not find a scaled I18n translation. Default I18n translation will be used. ");
        logMessage.append("Property Id: ").append(n);
        logMessage.append("Language Tag: ").append(this.currentLanguageTag);
        logMessage.log();
    }
}

