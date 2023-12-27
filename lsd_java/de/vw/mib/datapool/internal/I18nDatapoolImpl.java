/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.datapool.I18nDatapool;
import de.vw.mib.datapool.I18nListener;
import de.vw.mib.datapool.internal.AbstractI18nDatapool;
import de.vw.mib.i18n.I18nLanguage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.LoggerFactory;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArraySet;
import java.util.Iterator;

public class I18nDatapoolImpl
extends AbstractI18nDatapool
implements I18nDatapool {
    private static final String UNKNOWN_TRANSLATION_SCALAR;
    private static final String[] UNKNOWN_TRANSLATION_ARRAY;
    private CopyOnWriteArraySet registeredViews = new CopyOnWriteArraySet();

    public I18nDatapoolImpl(LoggerFactory loggerFactory) {
        super(loggerFactory);
    }

    @Override
    public String getString(int n) {
        return this.getScalarString(n, "<translation unknown>");
    }

    @Override
    public String[] getStrings(int n) {
        return this.getStringArray(n, UNKNOWN_TRANSLATION_ARRAY);
    }

    @Override
    public void registerI18nListener(I18nListener i18nListener) {
        this.registeredViews.add(i18nListener);
    }

    @Override
    public void deregisterI18nListener(I18nListener i18nListener) {
        this.registeredViews.remove(i18nListener);
    }

    @Override
    public void languageChanged(String string, I18nLanguage i18nLanguage) {
        if (i18nLanguage != this.getCurrentLanguage()) {
            this.validateCompatibility(string, i18nLanguage);
            this.setCurrentLanguage(i18nLanguage);
            this.updateListeners();
        }
    }

    private void validateCompatibility(String string, I18nLanguage i18nLanguage) {
        I18nLanguage i18nLanguage2 = this.getCurrentLanguage();
        if (string != null && i18nLanguage2 != null) {
            try {
                i18nLanguage2.checkCompatibility(i18nLanguage);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.issueIncompatibleLanguage(illegalArgumentException);
                throw new IllegalArgumentException(new StringBuffer().append("Language '").append(string).append("' is not compatible.").toString());
            }
        }
    }

    private void updateListeners() {
        if (!this.registeredViews.isEmpty()) {
            Iterator iterator = this.registeredViews.iterator();
            while (iterator.hasNext()) {
                ((I18nListener)iterator.next()).updateI18n();
            }
        }
    }

    private void issueIncompatibleLanguage(IllegalArgumentException illegalArgumentException) {
        LogMessage logMessage = this.logger.error(2048);
        logMessage.append("Switching language aborted. Set new language set failed: ").append(illegalArgumentException.getMessage()).log();
    }

    static {
        UNKNOWN_TRANSLATION_ARRAY = new String[]{"<translation unknown>"};
    }
}

