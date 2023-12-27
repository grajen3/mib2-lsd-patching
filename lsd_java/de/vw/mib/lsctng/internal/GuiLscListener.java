/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.i18n.I18nLanguage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.LscListener;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import de.vw.mib.lsctng.internal.GuiLscListener$1;
import de.vw.mib.lsctng.internal.GuiLscListener$TemporaryViewLanguageSkinChanger;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.lsctng.internal.SkinClassLoaderInternal;
import de.vw.mib.skin.SkinDatapoolUpdater;
import de.vw.mib.skin.ViewLanguageSkinChanger;
import java.io.File;
import java.io.IOException;

public class GuiLscListener
implements LscListener {
    private final SkinClassLoaderInternal classloader;
    private boolean startupSkinReadyEventAlreadySent;
    private String currentLanguage;
    private boolean areViewResourcesReleased;
    static final Logger LOG = ServiceManager.loggerFactory.getLogger(1024);
    private static final int SUB_CLASSIFIER;

    public GuiLscListener(SkinClassLoaderInternal skinClassLoaderInternal) {
        this.classloader = skinClassLoaderInternal;
        this.areViewResourcesReleased = false;
        this.startupSkinReadyEventAlreadySent = false;
        this.currentLanguage = "NO_LANGUAGE";
        if (LOG.isTraceEnabled(16384)) {
            LOG.trace(16384).append("call: ").append(super.getClass().getName()).append(" instantiated").log();
        }
    }

    @Override
    public void onNewLanguage(LanguageChanger languageChanger, int n, String string) {
        I18nLanguage i18nLanguage;
        if (LOG.isTraceEnabled(16384)) {
            LOG.trace(16384).append("call: ").append(super.getClass().getName()).append(".onNewLanguage()").log();
        }
        if (null != (i18nLanguage = this.loadLanguage(string))) {
            if (this.isInitialLanguageChange()) {
                this.onNewLanguageInternal(string, i18nLanguage);
            } else {
                ServiceManager.eventDispatcher.invoke(new GuiLscListener$1(this, string, i18nLanguage));
            }
        }
        languageChanger.setChangeResult(n, i18nLanguage != null, this.currentLanguage);
    }

    private boolean isInitialLanguageChange() {
        return !this.startupSkinReadyEventAlreadySent;
    }

    void onNewLanguageInternal(String string, I18nLanguage i18nLanguage) {
        ServiceManager.i18nGuiUpdater.languageChanged(string, i18nLanguage);
        this.sendStartupSkinReadyEventIfPossible();
    }

    private I18nLanguage loadLanguage(String string) {
        I18nLanguage i18nLanguage = null;
        try {
            i18nLanguage = this.loadLanguageInternal(string);
            this.currentLanguage = string;
        }
        catch (IOException iOException) {
            LOG.error(16384).append("loading language ").append(string).append(" failed.").attachThrowable(iOException).log();
            this.currentLanguage = "NO_LANGUAGE";
        }
        return i18nLanguage;
    }

    private I18nLanguage loadLanguageInternal(String string) {
        File file = null;
        I18nLanguage i18nLanguage = null;
        file = this.classloader.getLanguageFile(string);
        i18nLanguage = ServiceManager.i18nTableDecoder.loadI18nTable(file);
        if (LOG.isTraceEnabled(16384)) {
            LOG.trace(16384).append("language loaded: ").append(string).log();
        }
        return i18nLanguage;
    }

    private void sendStartupSkinReadyEventIfPossible() {
        if (this.currentLanguage != "NO_LANGUAGE" && this.classloader.getSkin() != -1) {
            if (this.isInitialLanguageChange()) {
                LOG.info(16384).append("send STARTUP_SKIN_READY").log();
                ServiceManager.startupEventDispatcher.createAndSubmitStartupEvent(2);
                this.setInitialLanguageChangeEnded();
            } else {
                LOG.normal(16384).append("say startOfLsc()").log();
                ServiceManager.lscBullhorn.startOfLsc();
            }
        }
        this.restoreViewResources();
    }

    private void setInitialLanguageChangeEnded() {
        this.startupSkinReadyEventAlreadySent = true;
    }

    private void restoreViewResources() {
        if (!this.areViewResourcesReleased) {
            return;
        }
        ServiceManager.viewLanguageSkinChanger.restoreResourcesForSkinChange();
        this.areViewResourcesReleased = false;
    }

    @Override
    public void onNewSkin(SkinChanger skinChanger, int n, int n2) {
        if (LOG.isTraceEnabled(16384)) {
            LOG.trace(16384).append("call: ").append(super.getClass().getName()).append(".onNewSkin(").append(n2).append(")").log();
        }
        this.currentLanguage = "NO_LANGUAGE";
        this.releaseViewResources();
        boolean bl = true;
        bl &= this.update(this.updateSkinClassloader(n2), "updateSkinClassloader");
        bl &= this.update(this.updateSkinImagePool(n2), "updateSkinImagePool");
        bl &= this.update(this.updateSkinAnimations(n2), "updateSkinAnimations");
        skinChanger.setChangeResult(n, bl &= this.update(this.updateSkinDatapool(), "updateSkinDatapool"), this.classloader.getSkin());
    }

    private void releaseViewResources() {
        if (this.areViewResourcesReleased) {
            return;
        }
        ServiceManager.viewLanguageSkinChanger.releaseResourcesForSkinChange();
        this.areViewResourcesReleased = true;
    }

    private boolean update(boolean bl, String string) {
        if (bl) {
            if (LOG.isTraceEnabled(16384)) {
                LOG.trace(16384).append(new StringBuffer().append(string).append(": ok").toString()).log();
            }
            return true;
        }
        LOG.error(16384).append(new StringBuffer().append(string).append(": nok").toString()).log();
        return false;
    }

    private boolean updateSkinDatapool() {
        SkinDatapoolUpdater skinDatapoolUpdater = this.classloader.getSkinDatapoolUpdater();
        if (null != skinDatapoolUpdater) {
            skinDatapoolUpdater.updateDatapool();
            return true;
        }
        return false;
    }

    private boolean updateSkinClassloader(int n) {
        return this.classloader.initializeClassLoaderForSkinId(n);
    }

    private boolean updateSkinImagePool(int n) {
        try {
            ServiceManager.sipUpdater.updateSkin(n);
        }
        catch (IOException iOException) {
            return false;
        }
        return true;
    }

    private boolean updateSkinAnimations(int n) {
        try {
            ServiceManager.saUpdater.updateSkin(n);
        }
        catch (IOException iOException) {
            return false;
        }
        return true;
    }

    @Override
    public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2) {
        if (LOG.isTraceEnabled(16384)) {
            LOG.trace(16384).append("call: ").append(super.getClass().getName()).append(".onNewSkinmode()").log();
        }
        ServiceManager.viewLanguageSkinChanger.propagateSkinMode(n2);
        skinmodeChanger.setChangeResult(n, true, n2);
    }

    public static ViewLanguageSkinChanger getTemporaryViewLanguageSkinChanger() {
        return new GuiLscListener$TemporaryViewLanguageSkinChanger();
    }
}

