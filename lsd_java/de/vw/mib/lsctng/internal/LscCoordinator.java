/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.internal.AbstractMediator;
import de.vw.mib.lsctng.internal.LanguageChangerImpl;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.lsctng.internal.SkinChangerImpl;
import de.vw.mib.lsctng.internal.SkinmodeChangerImpl;

class LscCoordinator {
    private final CowList mediators;
    private final String currentLanguage;
    private final int currentSkin;
    private final int currentSkinmode;
    private String nextLanguage;
    private int nextSkin;
    private int nextSkinmode;
    private transient SkinChangerImpl skinChanger;
    private transient LanguageChangerImpl languageChanger;
    private transient SkinmodeChangerImpl skinmodeChanger;
    protected static final int SUB_CLASSIFIER;
    protected static final Logger LOG;

    public LscCoordinator(CowList cowList, String string, int n, int n2) {
        this.mediators = cowList;
        this.currentLanguage = string;
        this.currentSkin = n;
        this.currentSkinmode = n2;
        this.skinChanger = null;
        this.languageChanger = null;
        this.skinmodeChanger = null;
        if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("new: ").append(super.getClass().getName()).log();
        }
    }

    public void changeLscTo(String string, int n, int n2) {
        if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("call: ").append(super.getClass().getName()).append(".changeLscTo(").append(string).append(", ").append(n).append(", ").append(n2).append(")").log();
        }
        this.nextLanguage = string;
        this.nextSkin = n;
        this.nextSkinmode = n2;
        this.changeSkinIfNecessary();
        this.changeLanguageIfNecessary();
        this.changeSkinmodeIfNecessary();
    }

    private void changeSkinIfNecessary() {
        if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("call: ").append(super.getClass().getName()).append(".changeSkinIfNecessary()").log();
        }
        boolean bl = false;
        if (this.nextSkin != -1) {
            for (CowList cowList = this.mediators; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
                if (!abstractMediator.isInterestedInSkinChanges() || abstractMediator.getCurrentSkin() == this.nextSkin) continue;
                bl = true;
            }
        }
        if (bl) {
            if (LOG.isTraceEnabled(8)) {
                LOG.trace(8).append("Start change to skin ").append(this.nextSkin).log();
            }
            this.skinChanger = new SkinChangerImpl(this.currentSkin, this.nextSkin, this.mediators);
            this.skinChanger.change();
        } else if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("Do not change to skin ").append(this.nextSkin).append(", it's unnecessary.").log();
        }
    }

    private void changeLanguageIfNecessary() {
        if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("call: ").append(super.getClass().getName()).append(".changeLanguageIfNecessary()").log();
        }
        boolean bl = false;
        if (this.nextLanguage != "NO_LANGUAGE") {
            for (CowList cowList = this.mediators; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
                if (!abstractMediator.isInterestedInLanguageChanges() || abstractMediator.getCurrentLanguage().equals(this.nextLanguage)) continue;
                if (abstractMediator.isTurnedOff()) {
                    abstractMediator.turnOn();
                }
                bl = true;
            }
        }
        if (bl) {
            if (LOG.isTraceEnabled(8)) {
                LOG.trace(8).append("Start change to language ").append(this.nextLanguage).log();
            }
            this.languageChanger = new LanguageChangerImpl(this.currentLanguage, this.nextLanguage, this.mediators);
            this.languageChanger.change();
        } else if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("Do not change to language ").append(this.nextLanguage).append(", it's unnecessary.").log();
        }
    }

    private void changeSkinmodeIfNecessary() {
        if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("call: ").append(super.getClass().getName()).append(".changeSkinmodeIfNecessary()").log();
        }
        boolean bl = false;
        if (this.nextSkinmode != -1) {
            for (CowList cowList = this.mediators; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
                if (!abstractMediator.isInterestedInSkinmodeChanges() || abstractMediator.getCurrentSkinmode() == this.nextSkinmode) continue;
                bl = true;
            }
        }
        if (bl) {
            if (LOG.isTraceEnabled(8)) {
                LOG.trace(8).append("Start change to skinmode ").append(this.nextSkinmode).log();
            }
            this.skinmodeChanger = new SkinmodeChangerImpl(this.currentSkinmode, this.nextSkinmode, this.mediators);
            this.skinmodeChanger.change();
        } else if (LOG.isTraceEnabled(8)) {
            LOG.trace(8).append("Do not change to skinmode ").append(this.nextSkinmode).append(", it's unnecessary.").log();
        }
    }

    static {
        LOG = ServiceManager.createLogger();
    }
}

