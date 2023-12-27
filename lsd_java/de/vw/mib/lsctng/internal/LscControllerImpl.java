/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.event.LSChangeEvent;
import de.vw.mib.event.consumer.LSChangeEventConsumer;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.LscController;
import de.vw.mib.lsctng.LscListener;
import de.vw.mib.lsctng.LscUserInteractionFilterService;
import de.vw.mib.lsctng.internal.AbstractMediator;
import de.vw.mib.lsctng.internal.AslLscListenerMediator;
import de.vw.mib.lsctng.internal.LanguageChangerImpl;
import de.vw.mib.lsctng.internal.LscControllerImpl$1;
import de.vw.mib.lsctng.internal.LscCoordinator;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.lsctng.internal.SimpleLscListenerMediator;
import de.vw.mib.threads.MIBThreadManager;

class LscControllerImpl
implements LscController,
LSChangeEventConsumer {
    private static final int LSCHANGE_START;
    private static final int LSCHANGE_FINISHED;
    static int TMA_LANG;
    static int TMA_SKIN;
    static int TMA_SKINMODE;
    static int TMA_VOICE;
    private CowList lscListenerMediators = CowList.EMPTY;
    private CowList lscHighPrioListenerMediators;
    private CowList allMediators;
    protected static final int SUB_CLASSIFIER;
    protected static final Logger LOG;
    private final Object mutex;
    private String lastRqLanguage = "NO_LANGUAGE";
    private int lastRqSkin = -1;
    private int lastRqSkinmode = -1;
    private String rqLanguage = "NO_LANGUAGE";
    private int rqSkin = -1;
    private int rqSkinmode = -1;
    private boolean isLscChangeRunning = false;
    private CowList lscListenerMediatorsChanged = CowList.EMPTY;
    private boolean lscQueued;
    private final CowArray lscUserInteractionFilterServices;
    private boolean isLsChangerFilterActive = false;

    public LscControllerImpl() {
        this.lscHighPrioListenerMediators = CowList.EMPTY;
        this.lscUserInteractionFilterServices = new CowArray();
        this.mutex = new Object();
        this.updateAllMediators();
    }

    @Override
    public void addListener(LscListener lscListener, int n, String string, int n2, int n3) {
        LOG.normal(2).append("new listener: type=").append(Integer.toHexString(n)).append(", language=").append(string).append(", skin=").append(n2).append(", skinmode=").append(n3).log();
        this.lscListenerMediators = this.lscListenerMediators.add(this.newMediator(lscListener, n, string, n2, n3));
        this.updateAllMediators();
        this.coordinateLscInOwnThreadIfNecessary();
    }

    private void updateAllMediators() {
        this.allMediators = this.lscListenerMediators.addAll(this.lscHighPrioListenerMediators);
    }

    @Override
    public void addHighPrioListener(LscListener lscListener, int n, String string, int n2, int n3) {
        LOG.normal(2).append("new high prio listener: type=").append(Integer.toHexString(n)).append(", language=").append(string).append(", skin=").append(n2).append(", skinmode=").append(n3).log();
        this.lscHighPrioListenerMediators = this.lscHighPrioListenerMediators.add(this.newMediator(lscListener, n, string, n2, n3));
        this.updateAllMediators();
        this.coordinateLscInOwnThreadIfNecessary();
    }

    private SimpleLscListenerMediator newMediator(LscListener lscListener, int n, String string, int n2, int n3) {
        return new SimpleLscListenerMediator(this.createListenerType(n, string, n2, n3), lscListener, string, n2, n3);
    }

    private int createListenerType(int n, String string, int n2, int n3) {
        return n | this.tellMeAbout(string, n2, n3);
    }

    @Override
    public void addAslListener(int n, int n2, String string, int n3, int n4) {
        LOG.normal(2).append("new ASL listener: ID=").append(Integer.toHexString(n)).append(", type=").append(Integer.toHexString(n2)).append(", language=").append(string).append(", skin=").append(n3).append(", skinmode=").append(n4).log();
        this.lscListenerMediators = this.lscListenerMediators.add(this.newMediator(n, n2, string, n3, n4));
        this.updateAllMediators();
        this.coordinateLscInOwnThreadIfNecessary();
    }

    private AslLscListenerMediator newMediator(int n, int n2, String string, int n3, int n4) {
        return new AslLscListenerMediator(this.createListenerType(n2, string, n3, n4), n, string, n3, n4);
    }

    @Override
    public void removeListener(LscListener lscListener) {
        CowList cowList = this.removeListener(lscListener, this.lscListenerMediators);
        if (cowList == this.lscListenerMediators) {
            this.lscHighPrioListenerMediators = this.removeListener(lscListener, this.lscHighPrioListenerMediators);
        } else {
            this.lscListenerMediators = cowList;
        }
        this.updateAllMediators();
    }

    private CowList removeListener(LscListener lscListener, CowList cowList) {
        AbstractMediator abstractMediator = null;
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator2 = (AbstractMediator)cowList2.head();
            if (!abstractMediator2.isSimpleLscListenerMediator(lscListener)) continue;
            abstractMediator = abstractMediator2;
            break;
        }
        if (null != abstractMediator) {
            cowList = cowList.remove(abstractMediator);
        }
        return cowList;
    }

    @Override
    public void removeAslListener(int n) {
        AbstractMediator abstractMediator = null;
        for (CowList cowList = this.lscListenerMediators; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AbstractMediator abstractMediator2 = (AbstractMediator)cowList.head();
            if (!abstractMediator2.isAslLscListenerMediator(n)) continue;
            abstractMediator = abstractMediator2;
            break;
        }
        this.lscListenerMediators = this.lscListenerMediators.remove(abstractMediator);
        this.updateAllMediators();
    }

    private int tellMeAbout(String string, int n, int n2) {
        int n3 = 0;
        if (string != "NOT_INTERESTED") {
            n3 |= TMA_LANG;
        }
        if (n != -2) {
            n3 |= TMA_SKIN;
        }
        if (n2 != -2) {
            n3 |= TMA_SKINMODE;
        }
        return n3;
    }

    CowList getMediators() {
        return this.allMediators;
    }

    @Override
    public void initialChangeTo(String string, int n, int n2) {
        if (LOG.isTraceEnabled(2)) {
            LOG.trace(2).append("call: ").append(super.getClass().getName()).append(".initialChangeTo(").append(string).append(", ").append(n).append(", ").append(n2).append(")").log();
        }
        this.storeLastRequestedData("NO_LANGUAGE", -1, -1);
        this.storeRequestedData(string, n, n2);
        this.waitForNoChangeRunning();
        this.coordinateTheLscInOwnThread();
    }

    private void storeLastRequestedData(String string, int n, int n2) {
        this.lastRqLanguage = string;
        this.lastRqSkin = n;
        this.lastRqSkinmode = n2;
    }

    @Override
    public void changeTo(String string, int n, int n2) {
        if (LOG.isTraceEnabled(2)) {
            LOG.trace(2).append("call: ").append(super.getClass().getName()).append(".change()").log();
        }
        this.storeRequestedData(string, n, n2);
        this.initiateLsc(string, n, n2);
    }

    private void storeRequestedData(String string, int n, int n2) {
        this.rqSkin = this.findLanguageSupportingSkin(string, n);
        this.rqLanguage = string;
        this.rqSkinmode = n2;
        this.lscListenerMediatorsChanged = CowList.EMPTY;
    }

    private int findLanguageSupportingSkin(String string, int n) {
        int n2;
        String string2 = LanguageChangerImpl.generateStrategy(string)[0];
        int n3 = n2 = n == -1 ? this.lastRqSkin : n;
        if (ServiceManager.configValueSetter.isLanguageSupportedBySkin(string2, n2)) {
            return n;
        }
        int[] nArray = ServiceManager.configValueSetter.getAvailableSkins();
        int n4 = ServiceManager.configValueSetter.getDefaultSkinId();
        int n5 = 0;
        while (nArray[n5] != n4) {
            ++n5;
        }
        int n6 = nArray.length;
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7 = nArray[(i2 + n5) % n6];
            if (!ServiceManager.configValueSetter.isLanguageSupportedBySkin(string, n7)) continue;
            return n7;
        }
        return n;
    }

    private void initiateLsc(String string, int n, int n2) {
        boolean bl;
        if (LOG.isTraceEnabled(2)) {
            LOG.trace(2).append("call: ").append(super.getClass().getName()).append(".preLsc()").log();
        }
        boolean bl2 = bl = n2 != this.lastRqSkinmode && string == this.lastRqLanguage && n == this.lastRqSkin;
        if (!bl) {
            this.startLsChangerFilter();
        }
        ServiceManager.eventDispatcher.createAndSubmitLSChangeEvent(0);
    }

    @Override
    public void consumeEvent(LSChangeEvent lSChangeEvent) {
        int n = lSChangeEvent.getCommand();
        if (LOG.isTraceEnabled(2)) {
            LOG.trace(2).append("call: ").append(super.getClass().getName()).append(".consumeEvent(").append(n).append(")").log();
        }
        switch (n) {
            case 0: {
                if (this.isLscChangeRunning) {
                    this.lscQueued = true;
                    LOG.warn(2).append("previous lsc is still running, new lsc is being queued").log();
                    break;
                }
                this.isLscChangeRunning = true;
                this.coordinateTheLscInOwnThread();
                break;
            }
            case 1: {
                this.postLsc();
                break;
            }
            default: {
                LOG.error(2, new StringBuffer().append("Unknown command in LSChangeEvent: ").append(n).toString());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void waitForNoChangeRunning() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.isLscChangeRunning) {
                this.lscQueued = true;
            }
            this.isLscChangeRunning = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void coordinateLscInOwnThreadIfNecessary() {
        boolean bl;
        if (this.hasNoRequestedInformation()) {
            if (LOG.isTraceEnabled(2)) {
                LOG.trace(2, "No LSC information yet. Don't start a change.");
            }
            return;
        }
        Object object = this.mutex;
        synchronized (object) {
            boolean bl2 = bl = !this.isLscChangeRunning;
            if (bl) {
                this.isLscChangeRunning = true;
            }
        }
        if (bl) {
            this.coordinateTheLscInOwnThread();
        }
    }

    private boolean hasNoRequestedInformation() {
        return this.rqLanguage == "NO_LANGUAGE" && this.rqSkin == -1 && this.rqSkinmode == -1;
    }

    private void coordinateTheLscInOwnThread() {
        MIBThreadManager mIBThreadManager = ServiceManager.threadManager;
        if (null == mIBThreadManager) {
            this.isLscChangeRunning = false;
            return;
        }
        mIBThreadManager.createThread(4, new LscControllerImpl$1(this)).start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void coordinateTheLsc() {
        while (true) {
            Object object = this.mutex;
            synchronized (object) {
                if (this.allMediators == this.lscListenerMediatorsChanged) {
                    this.isLscChangeRunning = false;
                    this.mutex.notify();
                    break;
                }
                this.lscListenerMediatorsChanged = this.allMediators;
            }
            object = new LscCoordinator(this.lscListenerMediatorsChanged, this.lastRqLanguage, this.lastRqSkin, this.lastRqSkinmode);
            ((LscCoordinator)object).changeLscTo(this.rqLanguage, this.rqSkin, this.rqSkinmode);
        }
        this.storeLastRequestedData(this.rqLanguage, this.rqSkin, this.rqSkinmode);
        ServiceManager.eventDispatcher.createAndSubmitLSChangeEvent(1);
    }

    private void postLsc() {
        if (LOG.isTraceEnabled(2)) {
            LOG.trace(2).append("call: ").append(super.getClass().getName()).append(".postLsc()").log();
        }
        if (this.lscQueued) {
            LOG.warn(2).append("handle queued lsc").log();
            this.lscQueued = false;
            if (this.rqSkinmode != this.lastRqSkinmode || this.rqLanguage != this.lastRqLanguage || this.rqSkin != this.lastRqSkin) {
                this.initiateLsc(this.rqLanguage, this.rqSkin, this.rqSkinmode);
                return;
            }
            LOG.warn(2).append("nothing to change").log();
        }
        this.stopLsChangerFilter();
        ServiceManager.lscBullhorn.endOfLsc(this.getAslLanguageResults());
    }

    private IntObjectMap getAslLanguageResults() {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        for (CowList cowList = this.allMediators; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
            if (!abstractMediator.isAslLscListenerMediator()) continue;
            intObjectOptHashMap.put(((AslLscListenerMediator)abstractMediator).getAslTargetId(), abstractMediator.getCurrentLanguage());
        }
        return intObjectOptHashMap;
    }

    public boolean isLscChangeRunning() {
        return this.isLscChangeRunning;
    }

    synchronized void registerLscUserInteractionFilterService(LscUserInteractionFilterService lscUserInteractionFilterService) {
        this.lscUserInteractionFilterServices.addIfNotAlreadyIn(lscUserInteractionFilterService);
        if (this.isLsChangerFilterActive) {
            lscUserInteractionFilterService.startLsChangerFilter();
        } else {
            lscUserInteractionFilterService.stopLsChangerFilter();
        }
    }

    private synchronized void startLsChangerFilter() {
        if (this.isLsChangerFilterActive) {
            return;
        }
        this.isLsChangerFilterActive = true;
        Object[] objectArray = this.lscUserInteractionFilterServices.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((LscUserInteractionFilterService)objectArray[i2]).startLsChangerFilter();
        }
    }

    private synchronized void stopLsChangerFilter() {
        if (!this.isLsChangerFilterActive) {
            return;
        }
        this.isLsChangerFilterActive = false;
        Object[] objectArray = this.lscUserInteractionFilterServices.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((LscUserInteractionFilterService)objectArray[i2]).stopLsChangerFilter();
        }
    }

    static {
        TMA_LANG = 128;
        TMA_SKIN = 64;
        TMA_SKINMODE = 32;
        TMA_VOICE = 16;
        LOG = ServiceManager.createLogger();
    }
}

