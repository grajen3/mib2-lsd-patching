/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.LscListener;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import de.vw.mib.lsctng.internal.AbstractChanger;
import de.vw.mib.lsctng.internal.AbstractMediator$IgnoringChanger;
import de.vw.mib.lsctng.internal.CheckAllChangesReady;
import de.vw.mib.lsctng.internal.LscControllerImpl;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.util.StringBuilder;

abstract class AbstractMediator {
    private final int listenerType;
    private String currentLanguage;
    private int currentSkin;
    private int currentSkinmode;
    private String lastRequestedLanguage = "NO_LANGUAGE";
    private boolean lastLanguageChangeResult;
    private boolean lastSkinChangeResult;
    private boolean lastSkinmodeChangeResult;
    private final IntSet languageChangeIds;
    private final IntSet skinChangeIds;
    private final IntSet skinmodeChangeIds;
    private boolean isTurnedOn;
    private String bufferLanguage = "NO_LANGUAGE";
    private int bufferLanguageChangeId;
    private LanguageChanger bufferLanguageChanger;
    private SkinChanger bufferSkinChanger;
    private int bufferSkin;
    private int bufferSkinChangeId;
    protected static final int SUB_CLASSIFIER;
    protected static final Logger LOG;
    private static final AbstractMediator$IgnoringChanger IGNORING_CHANGER;

    AbstractMediator(int n, String string, int n2, int n3) {
        this.listenerType = n;
        this.languageChangeIds = new IntOptHashSet();
        this.skinChangeIds = new IntOptHashSet();
        this.skinmodeChangeIds = new IntOptHashSet();
        this.setCurrentLanguage(string, true);
        this.setCurrentSkin(n2, true);
        this.setCurrentSkinmode(n3, true);
        this.turnOn();
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("new: ").append(super.getClass().getName()).log();
        }
    }

    int getListenerType() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".getListenerType()").log();
        }
        return this.listenerType;
    }

    String getCurrentLanguage() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".getCurrentLanguage()").log();
        }
        if (this.isChangingLanguage()) {
            return "NO_LANGUAGE";
        }
        return this.currentLanguage;
    }

    boolean getLastLanguageChangeResult() {
        return this.lastLanguageChangeResult;
    }

    int getCurrentSkin() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".getCurrentSkin()").log();
        }
        if (this.isChangingSkin()) {
            return -1;
        }
        return this.currentSkin;
    }

    boolean getLastSkinChangeResult() {
        return this.lastSkinChangeResult;
    }

    int getCurrentSkinmode() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".getCurrentSkinmode()").log();
        }
        if (this.isChangingSkinmode()) {
            return -1;
        }
        return this.currentSkinmode;
    }

    boolean getLastSkinmodeChangeResult() {
        return this.lastSkinmodeChangeResult;
    }

    boolean isChangingLanguage() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isChangingLanguage()").log();
        }
        return !this.languageChangeIds.isEmpty();
    }

    boolean isChangingSkin() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isChangingSkin()").log();
        }
        return !this.skinChangeIds.isEmpty();
    }

    boolean isChangingSkinmode() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isChangingSkinmode()").log();
        }
        return !this.skinmodeChangeIds.isEmpty();
    }

    final void onNewLanguage(LanguageChanger languageChanger, String string, int n) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewLanguage()").log();
        }
        if (this.isTurnedOff()) {
            return;
        }
        if (this.isChangingLanguage()) {
            this.bufferLanguage = string;
            this.bufferLanguageChangeId = n;
            this.bufferLanguageChanger = languageChanger;
            return;
        }
        this.onNewLanguageInternalIfNecessary(languageChanger, string, n);
    }

    private void onNewLanguageInternalIfNecessary(LanguageChanger languageChanger, String string, int n) {
        if (!string.equals(this.getCurrentLanguage()) || !this.lastLanguageChangeResult || languageChanger == IGNORING_CHANGER) {
            LOG.normal(4).append("Change ").append(this.toString()).append(" with changeId ").append(n).append(" from language ").append(this.getCurrentLanguage()).append(" to language ").append(string).log();
            this.clearBufferedLanguage();
            this.languageChangeIds.add(n);
            if (this.currentLanguage != null && this.lastRequestedLanguage.equals(string)) {
                LOG.normal(4, new StringBuffer().append("LSC short cut - ").append(this).toString());
                languageChanger.setChangeResult(n, true, this.currentLanguage);
                return;
            }
            this.onNewLanguageInternal(languageChanger, n, string);
        } else {
            LOG.normal(4).append("Don't change ").append(this.toString()).append(" with changeId ").append(n).append(" to language ").append(string).log();
            ((CheckAllChangesReady)((Object)languageChanger)).checkAllChangesReady();
        }
    }

    private void clearBufferedLanguage() {
        this.bufferLanguage = "NO_LANGUAGE";
        this.bufferLanguageChangeId = -1;
        this.bufferLanguageChanger = null;
    }

    void invalidateLanguage() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".invalidateLanguage()").log();
        }
        this.currentLanguage = "NO_LANGUAGE";
        this.lastLanguageChangeResult = false;
        this.lastRequestedLanguage = this.currentLanguage;
    }

    abstract void onNewLanguageInternal(LanguageChanger languageChanger, int n, String string) {
    }

    final void languageChangeEnded(int n, boolean bl, String string) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".languageChangeEnded()").log();
        }
        this.languageChangeIds.remove(n);
        this.setCurrentLanguage(string, bl);
        if (this.bufferLanguage != "NO_LANGUAGE") {
            this.onNewLanguageInternalIfNecessary(this.bufferLanguageChanger, this.bufferLanguage, this.bufferLanguageChangeId);
        }
    }

    boolean isLanguageChangeId(int n) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isLanguageChangeId()").log();
        }
        return this.languageChangeIds.contains(n);
    }

    final void onNewSkin(SkinChanger skinChanger, int n, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewSkin(").append(skinChanger).append(", ").append(n).append(", ").append(n2).append(")").log();
        }
        if (this.isTurnedOff()) {
            return;
        }
        if (this.isChangingSkin()) {
            this.storeBufferedSkin(skinChanger, n, n2);
        }
        this.onNewSkinInternalIfNecessary(skinChanger, n, n2);
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("eom: ").append(super.getClass().getName()).append(".onNewSkin(SkinChanger, skin, changeId)").log();
        }
    }

    private void storeBufferedSkin(SkinChanger skinChanger, int n, int n2) {
        this.bufferSkinChanger = skinChanger;
        this.bufferSkin = n;
        this.bufferSkinChangeId = n2;
    }

    private void onNewSkinInternalIfNecessary(SkinChanger skinChanger, int n, int n2) {
        if (n != this.getCurrentSkin() || skinChanger == IGNORING_CHANGER) {
            this.clearBufferedSkin();
            this.skinChangeIds.add(n2);
            LOG.info(4).append("Change ").append(this.toString()).append(" with changeId ").append(n2).append(" to skin ").append(n).log();
            this.onNewSkinInternal(skinChanger, n2, n);
        } else {
            LOG.normal(4).append("No need to change ").append(this.toString()).append(" with changeId ").append(n2).append(" to skin ").append(n).log();
            ((CheckAllChangesReady)((Object)skinChanger)).checkAllChangesReady();
        }
    }

    private void clearBufferedSkin() {
        this.storeBufferedSkin(this.bufferSkinChanger, this.bufferSkin, this.bufferSkinChangeId);
        this.bufferSkin = -1;
        this.bufferSkinChangeId = -1;
        this.bufferSkinChanger = null;
    }

    abstract void onNewSkinInternal(SkinChanger skinChanger, int n, int n2) {
    }

    void skinChangeEnded(int n, boolean bl, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".skinChangeEnded()").log();
        }
        this.skinChangeIds.remove(n);
        this.setCurrentSkin(n2, bl);
        if (this.bufferSkin != -1) {
            this.onNewSkinInternalIfNecessary(this.bufferSkinChanger, this.bufferSkin, this.bufferSkinChangeId);
        }
    }

    boolean isSkinChangeId(int n) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isSkinChangeId()").log();
        }
        return this.skinChangeIds.contains(n);
    }

    void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewSkinmode()").log();
        }
        if (this.isTurnedOff()) {
            return;
        }
        if (n != this.getCurrentSkinmode() || skinmodeChanger == IGNORING_CHANGER) {
            this.skinmodeChangeIds.add(n2);
            LOG.info(4).append("Change ").append(this.toString()).append(" with changeId ").append(n2).append(" to skinmode ").append(n).log();
            this.onNewSkinmodeInternal(skinmodeChanger, n2, n);
        } else {
            LOG.normal(4).append("Don't change ").append(this.toString()).append(" with changeId ").append(n2).append(" to skinmode ").append(n).log();
            ((CheckAllChangesReady)((Object)skinmodeChanger)).checkAllChangesReady();
        }
    }

    abstract void onNewSkinmodeInternal(SkinmodeChanger skinmodeChanger, int n, int n2) {
    }

    void skinmodeChangeEnded(int n, boolean bl, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".skinmodeChangeEnded()").log();
        }
        this.skinmodeChangeIds.remove(n);
        this.setCurrentSkinmode(n2, bl);
    }

    boolean isSkinmodeChangeId(int n) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isSkinmodeChangeId()").log();
        }
        return this.skinmodeChangeIds.contains(n);
    }

    void turnOff() {
        LOG.normal(4).append("Turn off mediator ").append(this.toString()).log();
        this.isTurnedOn = true;
        this.clearAllChangeIds();
        if (this.isInterestedInSkinChanges()) {
            this.onNewSkin(IGNORING_CHANGER, -1, AbstractChanger.getNextChangeId());
        }
        if (this.isInterestedInLanguageChanges()) {
            this.onNewLanguage(IGNORING_CHANGER, "NO_LANGUAGE", AbstractChanger.getNextChangeId());
        }
        if (this.isInterestedInSkinmodeChanges()) {
            this.onNewSkinmode(IGNORING_CHANGER, -1, AbstractChanger.getNextChangeId());
        }
        this.setCurrentLanguage("NO_LANGUAGE", true);
        this.setCurrentSkin(-1, true);
        this.setCurrentSkinmode(-1, true);
        this.isTurnedOn = false;
    }

    private void clearAllChangeIds() {
        this.languageChangeIds.clear();
        this.skinChangeIds.clear();
        this.skinmodeChangeIds.clear();
    }

    void turnOn() {
        LOG.normal(4).append("Turn on mediator ").append(this.toString()).log();
        this.clearAllChangeIds();
        this.isTurnedOn = true;
    }

    void setCurrentLanguage(String string, boolean bl) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".setCurrentLanguage()").log();
        }
        this.currentLanguage = string;
        this.lastLanguageChangeResult = bl;
    }

    void setCurrentSkin(int n, boolean bl) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".setCurrentSkin()").log();
        }
        this.currentSkin = n;
        this.lastSkinChangeResult = bl;
    }

    void setCurrentSkinmode(int n, boolean bl) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".setCurrentSkinmode()").log();
        }
        this.currentSkinmode = n;
        this.lastSkinmodeChangeResult = bl;
    }

    boolean isTurnedOn() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isTurnedOn()").log();
        }
        return this.isTurnedOn;
    }

    boolean isTurnedOff() {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".isTurnedOff() result:").append(!this.isTurnedOn).log();
        }
        return !this.isTurnedOn;
    }

    public boolean isSimpleLscListenerMediator(LscListener lscListener) {
        return false;
    }

    public boolean isAslLscListenerMediator(int n) {
        return false;
    }

    public boolean isAslLscListenerMediator() {
        return false;
    }

    public boolean isInterestedInSkinChanges() {
        return (this.getListenerType() & LscControllerImpl.TMA_SKIN) != 0;
    }

    public boolean isInterestedInLanguageChanges() {
        return (this.getListenerType() & LscControllerImpl.TMA_LANG) != 0;
    }

    public boolean isInterestedInSkinmodeChanges() {
        return (this.getListenerType() & LscControllerImpl.TMA_SKINMODE) != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toHexString(this.getListenerType()));
        stringBuilder.append("_").append(this.shortbool(this.isInterestedInSkinChanges())).append(this.shortbool(this.isInterestedInLanguageChanges())).append(this.shortbool(this.isInterestedInSkinmodeChanges()));
        stringBuilder.append("_").append(this.getCurrentSkin()).append("/").append(this.getCurrentLanguage()).append("/").append(this.getCurrentSkinmode());
        return stringBuilder.toString();
    }

    private String shortbool(boolean bl) {
        return bl ? "T" : "F";
    }

    protected void setLastRequestedLanguage(String string) {
        this.lastRequestedLanguage = string;
    }

    static {
        LOG = ServiceManager.createLogger();
        IGNORING_CHANGER = new AbstractMediator$IgnoringChanger();
    }
}

