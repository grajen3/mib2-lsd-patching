/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.configuration.ConfigurationManagerValueSetter;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.internal.AbstractChanger;
import de.vw.mib.lsctng.internal.AbstractMediator;
import de.vw.mib.lsctng.internal.ServiceManager;
import java.util.LinkedHashSet;
import java.util.Set;

class LanguageChangerImpl
extends AbstractChanger
implements LanguageChanger {
    private static final String MASTER_FALLBACK_LANG_1;
    private static final String MASTER_FALLBACK_LANG_2;
    private final String[] strategy;
    private final IntObjectMap expectedChanges = new IntObjectOptHashMap();
    static /* synthetic */ Class class$de$vw$mib$lsctng$internal$LanguageChangerImpl;

    LanguageChangerImpl(String string, String string2, CowList cowList) {
        super(cowList, LanguageChanger.LANGUAGE_CHANGE_TIMEOUT_PER_LANGUAGE, LanguageChanger.LANGUAGE_CHANGE_TIMEOUT_TOTAL);
        this.strategy = LanguageChangerImpl.generateStrategy(string2);
        this.logStrategy();
    }

    static String[] generateStrategy(String string) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append((class$de$vw$mib$lsctng$internal$LanguageChangerImpl == null ? (class$de$vw$mib$lsctng$internal$LanguageChangerImpl = LanguageChangerImpl.class$("de.vw.mib.lsctng.internal.LanguageChangerImpl")) : class$de$vw$mib$lsctng$internal$LanguageChangerImpl).getName()).append(".generateStrategy()").log();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String string2 = ServiceManager.configValueSetter.getFallbackLanguage(string);
        String string3 = ServiceManager.configValueSetter.getDefaultLanguage();
        LanguageChangerImpl.addToStrategy(linkedHashSet, string, string2, string3, ServiceManager.configValueSetter.getAvailableLanguages());
        if (linkedHashSet.size() < 1) {
            LOG.warn(1024, "Language strategy with available languages is empty. Try fallback to variant defined languages.");
            LanguageChangerImpl.addToStrategy(linkedHashSet, string, string2, string3, ServiceManager.configValueSetter.getVariantDefinedLanguages());
        }
        if (linkedHashSet.size() < 1) {
            LOG.fatal(1024, "Language strategy empty!");
        } else if (linkedHashSet.size() < 2) {
            LOG.warn(1024, "No fallback language defined.");
        }
        return (String[])linkedHashSet.toArray(new String[linkedHashSet.size()]);
    }

    private static void addToStrategy(Set set, String string, String string2, String string3, String[] stringArray) {
        LanguageChangerImpl.addIfSupported(set, string, stringArray);
        LanguageChangerImpl.addIfSupported(set, string2, stringArray);
        LanguageChangerImpl.addIfSupported(set, string3, stringArray);
        LanguageChangerImpl.addIfSupported(set, "en_GB", stringArray);
        LanguageChangerImpl.addIfSupported(set, "en_US", stringArray);
    }

    private static void addIfSupported(Set set, String string, String[] stringArray) {
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            if (!stringArray[i2].equals(string)) continue;
            set.add(string);
        }
    }

    private void logStrategy() {
        LogMessage logMessage = LOG.info(1024).append("language strategy = [");
        String string = "";
        for (int i2 = 0; i2 < this.strategy.length; ++i2) {
            logMessage.append(string).append(this.strategy[i2]);
            string = ", ";
        }
        logMessage.append("]").log();
    }

    @Override
    protected void changeInternal(AbstractMediator abstractMediator, int n, int n2) {
        String string = this.getRequestedLanguage(n);
        this.expectedChanges.put(n2, abstractMediator);
        abstractMediator.onNewLanguage(this, string, n2);
    }

    private String getRequestedLanguage(int n) {
        String string = this.strategy[n];
        return string;
    }

    @Override
    protected int getStrategyLength() {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".getStrategyLength()").log();
        }
        return this.strategy.length;
    }

    @Override
    protected CowList computeMediatorsForNextChange(CowList cowList, int n) {
        boolean bl;
        int n2 = this.getStrategyLength();
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".computeMediatorsForNextChange()").log();
        }
        this.turnOffMediatorsIfNecessary(cowList, n, n2);
        boolean[] blArray = new boolean[cowList.size()];
        while (bl = this.updateCurrMediators(cowList, blArray)) {
        }
        return this.collectCurrentMediators(cowList, blArray);
    }

    private void turnOffMediatorsIfNecessary(CowList cowList, int n, int n2) {
        boolean bl;
        while (bl = this.turnOffMediatorsIfNecessaryInternal(cowList, n, n2)) {
        }
    }

    private boolean turnOffMediatorsIfNecessaryInternal(CowList cowList, int n, int n2) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".turnOffMediatorsIfNecessary(CowList)").log();
        }
        boolean bl = false;
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList2.head();
            if (!abstractMediator.isTurnedOn() || !this.turnOffMediatorIfNecessary(abstractMediator, cowList, n, n2)) continue;
            bl = true;
        }
        return bl;
    }

    private boolean turnOffMediatorIfNecessary(AbstractMediator abstractMediator, CowList cowList, int n, int n2) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".turnOffMediatorsIfNecessary(LscListenerMediator, CowList)").log();
        }
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator2 = (AbstractMediator)cowList2.head();
            if (this.isStrongRelation(abstractMediator, abstractMediator2)) {
                if (abstractMediator2.isTurnedOff()) {
                    abstractMediator.turnOff();
                    return true;
                }
                if (this.hasLanguageDefined(abstractMediator2) && !this.hasLanguage(abstractMediator2, abstractMediator.getCurrentLanguage())) {
                    abstractMediator.turnOff();
                    return true;
                }
            }
            if (!this.isWeakRelation(abstractMediator, abstractMediator2) || !this.isLastLanguageChangeFailed(abstractMediator) || !this.isLastPossibleIndex(n, n2)) continue;
            abstractMediator.turnOff();
            return true;
        }
        return false;
    }

    private boolean isLastLanguageChangeFailed(AbstractMediator abstractMediator) {
        return this.hasNoLanguageDefined(abstractMediator) || !abstractMediator.getLastLanguageChangeResult();
    }

    private boolean hasLanguageDefined(AbstractMediator abstractMediator) {
        return !this.hasNoLanguageDefined(abstractMediator);
    }

    private boolean hasNoLanguageDefined(AbstractMediator abstractMediator) {
        return this.hasLanguage(abstractMediator, "NO_LANGUAGE");
    }

    private boolean hasLanguage(AbstractMediator abstractMediator, String string) {
        return abstractMediator.getCurrentLanguage().equals(string);
    }

    private boolean isLastPossibleIndex(int n, int n2) {
        return n + 1 >= n2;
    }

    private boolean isStrongRelation(AbstractMediator abstractMediator, AbstractMediator abstractMediator2) {
        int n;
        int n2 = abstractMediator.getListenerType();
        return ServiceManager.configValueSetter.getLscDependencyType(n2, n = abstractMediator2.getListenerType()) == 1;
    }

    private boolean isWeakRelation(AbstractMediator abstractMediator, AbstractMediator abstractMediator2) {
        int n;
        int n2 = abstractMediator.getListenerType();
        return ServiceManager.configValueSetter.getLscDependencyType(n2, n = abstractMediator2.getListenerType()) == 2;
    }

    private boolean updateCurrMediators(CowList cowList, boolean[] blArray) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".updatecurrMediators(CowList, boolean[])").log();
        }
        boolean bl = false;
        int n = 0;
        CowList cowList2 = cowList;
        while (cowList2 != CowList.EMPTY) {
            if (!blArray[n] && this.mustChangeMediator(cowList, (AbstractMediator)cowList2.head(), blArray)) {
                bl = true;
                blArray[n] = true;
            }
            cowList2 = cowList2.tail();
            ++n;
        }
        return bl;
    }

    private boolean mustChangeMediator(CowList cowList, AbstractMediator abstractMediator, boolean[] blArray) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".mustChangeMediator(CowList, LscListenerMediator, boolean[])").log();
        }
        if (abstractMediator.isTurnedOff()) {
            return false;
        }
        if (this.isLastLanguageChangeFailed(abstractMediator)) {
            return true;
        }
        int n = 0;
        CowList cowList2 = cowList;
        while (cowList2 != CowList.EMPTY) {
            AbstractMediator abstractMediator2;
            if (blArray[n] && this.haveRelation(abstractMediator, abstractMediator2 = (AbstractMediator)cowList2.head())) {
                return true;
            }
            cowList2 = cowList2.tail();
            ++n;
        }
        return false;
    }

    private boolean haveRelation(AbstractMediator abstractMediator, AbstractMediator abstractMediator2) {
        int n;
        int n2;
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".haveRelation(LscListenerMediator, LscListenerMediator)").log();
        }
        return ServiceManager.configValueSetter.getLscDependencyType(n2 = abstractMediator.getListenerType(), n = abstractMediator2.getListenerType()) != 0;
    }

    private CowList collectCurrentMediators(CowList cowList, boolean[] blArray) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".collectCurrentMediators(CowList, boolean[])").log();
        }
        CowList cowList2 = CowList.EMPTY;
        int n = 0;
        CowList cowList3 = cowList;
        while (cowList3 != CowList.EMPTY) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList3.head();
            if (blArray[n]) {
                cowList2 = cowList2.add(abstractMediator);
            }
            cowList3 = cowList3.tail();
            ++n;
        }
        return cowList2;
    }

    @Override
    public synchronized void setChangeResult(int n, boolean bl, String string) {
        LOG.normal(1024).append("language change result: changeId=").append(n).append(", result=").append(bl).append(", language=").append(string).log();
        AbstractMediator abstractMediator = (AbstractMediator)this.expectedChanges.get(n);
        abstractMediator.languageChangeEnded(n, bl, string);
        this.checkAllChangesReady();
    }

    @Override
    protected boolean isChanging(AbstractMediator abstractMediator) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".isChanging(LscListenerMediator)").log();
        }
        return abstractMediator.isChangingLanguage();
    }

    @Override
    boolean isRelevantMediator(AbstractMediator abstractMediator) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".isRelevantMediator(LscListenerMediator)").log();
        }
        return abstractMediator.isInterestedInLanguageChanges();
    }

    @Override
    void cleanUp(CowList cowList) {
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList2.head();
            abstractMediator.setLastRequestedLanguage(this.strategy[0]);
        }
    }

    @Override
    protected boolean tryToReachValidState(CowList cowList) {
        this.turnOffMediatorsIfNecessaryAfterTimeout(cowList);
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList2.head();
            if (abstractMediator.getCurrentLanguage() != "NO_LANGUAGE" && !abstractMediator.isTurnedOff()) continue;
            if (!this.isServant(cowList, abstractMediator)) {
                LOG.error(1024).append("Mediator ").append(abstractMediator).append(" has no language!").log();
                this.logLanguageConfiguration(cowList);
                return false;
            }
            LOG.warn(1024).append("Turn off mediator ").append(abstractMediator).append(" to correct language state!").log();
            abstractMediator.turnOff();
        }
        return true;
    }

    private void turnOffMediatorsIfNecessaryAfterTimeout(CowList cowList) {
        this.turnOffMediatorsIfNecessary(cowList, this.getStrategyLength() - 1, this.getStrategyLength());
    }

    private void logLanguageConfiguration(CowList cowList) {
        Object object;
        ConfigurationManagerValueSetter configurationManagerValueSetter = ServiceManager.configValueSetter;
        int[] nArray = configurationManagerValueSetter.getUsedLscListenerTypes();
        LOG.info(1024, "Language dependency table: ");
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            object = LOG.info(1024).append(Integer.toHexString(nArray[i2])).append("=").append(configurationManagerValueSetter.getLscListenerTypeName(nArray[i2]));
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                object.append(" ").append(this.getDependencyTypeString(nArray[i2], nArray[i3]));
            }
            object.log();
        }
        LOG.info(1024, "Registered mediators: ");
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            object = (AbstractMediator)cowList2.head();
            LOG.info(1024, ((AbstractMediator)object).toString());
        }
    }

    private String getDependencyTypeString(int n, int n2) {
        ConfigurationManagerValueSetter configurationManagerValueSetter = ServiceManager.configValueSetter;
        switch (configurationManagerValueSetter.getLscDependencyType(n, n2)) {
            case 0: {
                return "-";
            }
            case 1: {
                return "STRONG";
            }
            case 2: {
                return "WEAK";
            }
        }
        return new StringBuffer().append("???").append(configurationManagerValueSetter.getLscDependencyType(n, n2)).toString();
    }

    private boolean isServant(CowList cowList, AbstractMediator abstractMediator) {
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator2 = (AbstractMediator)cowList2.head();
            if (!this.haveRelation(abstractMediator, abstractMediator2)) continue;
            return true;
        }
        return false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

