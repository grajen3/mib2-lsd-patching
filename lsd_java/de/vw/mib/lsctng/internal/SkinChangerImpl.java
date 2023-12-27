/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.internal.AbstractChanger;
import de.vw.mib.lsctng.internal.AbstractMediator;
import de.vw.mib.lsctng.internal.ServiceManager;

class SkinChangerImpl
extends AbstractChanger
implements SkinChanger {
    private final int currentSkin;
    private final int nextSkin;
    private final int[] skinStrat;
    private final IntObjectMap expectedChanges;
    private int[] availableSkins;

    SkinChangerImpl(int n, int n2, CowList cowList) {
        super(cowList, SkinChanger.SKIN_CHANGE_TIMEOUT_PER_SKIN, SkinChanger.SKIN_CHANGE_TIMEOUT_TOTAL);
        this.currentSkin = n;
        this.nextSkin = n2;
        this.expectedChanges = new IntObjectOptHashMap();
        this.skinStrat = this.computeSkinStrategyOnFailRollback();
    }

    private int[] computeSkinStrategyOnFailRollback() {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".computeSkinStrategyOnFailRollback()").log();
        }
        this.availableSkins = ServiceManager.configValueSetter.getAvailableSkins();
        IntArrayList intArrayList = new IntArrayList();
        this.addIfSupported(intArrayList, this.nextSkin);
        this.addIfSupported(intArrayList, this.currentSkin);
        this.addAllOtherSkins(intArrayList);
        if (intArrayList.size() < 1) {
            LOG.fatal(1024, "Skin strategy empty!");
        } else if (intArrayList.size() < 2) {
            LOG.warn(1024, "No fallback skin available.");
        }
        int[] nArray = intArrayList.toArray();
        this.logStrategy(nArray);
        return nArray;
    }

    private void addIfSupported(IntArrayList intArrayList, int n) {
        if (!intArrayList.contains(n)) {
            for (int i2 = this.availableSkins.length - 1; i2 >= 0; --i2) {
                if (this.availableSkins[i2] != n) continue;
                intArrayList.add(n);
            }
        }
    }

    private void addAllOtherSkins(IntArrayList intArrayList) {
        for (int i2 = this.availableSkins.length - 1; i2 >= 0; --i2) {
            int n = this.availableSkins[i2];
            if (intArrayList.contains(n)) continue;
            intArrayList.add(n);
        }
    }

    private void logStrategy(int[] nArray) {
        LogMessage logMessage = LOG.info(1024).append("skin strategy = [");
        String string = "";
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            logMessage.append(string).append(nArray[i2]);
            string = ", ";
        }
        logMessage.append("]").log();
    }

    @Override
    protected int getStrategyLength() {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".getStrategyLength()").log();
        }
        return this.skinStrat.length;
    }

    @Override
    protected void changeInternal(AbstractMediator abstractMediator, int n, int n2) {
        int n3 = this.skinStrat[n];
        this.expectedChanges.put(n2, abstractMediator);
        this.invalidateLanguage(abstractMediator);
        abstractMediator.onNewSkin(this, n3, n2);
    }

    private void invalidateLanguage(AbstractMediator abstractMediator) {
        abstractMediator.invalidateLanguage();
    }

    @Override
    protected CowList computeMediatorsForNextChange(CowList cowList, int n) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".computeMediatorsForNextChange()").log();
        }
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            if (((AbstractMediator)cowList2.head()).getCurrentSkin() == this.skinStrat[n]) continue;
            return cowList;
        }
        return CowList.EMPTY;
    }

    @Override
    public synchronized void setChangeResult(int n, boolean bl, int n2) {
        LOG.normal(1024).append("skin change result: changeId=").append(n).append(", result=").append(bl).append(", skin=").append(n2).log();
        AbstractMediator abstractMediator = (AbstractMediator)this.expectedChanges.get(n);
        abstractMediator.skinChangeEnded(n, bl, n2);
        this.checkAllChangesReady();
    }

    @Override
    protected boolean isChanging(AbstractMediator abstractMediator) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".isChanging()").log();
        }
        return abstractMediator.isChangingSkin();
    }

    @Override
    boolean isRelevantMediator(AbstractMediator abstractMediator) {
        if (LOG.isTraceEnabled(1024)) {
            LOG.trace(1024).append("call: ").append(super.getClass().getName()).append(".isRelevantMediator()").log();
        }
        return abstractMediator.isInterestedInSkinChanges();
    }

    @Override
    protected boolean tryToReachValidState(CowList cowList) {
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
            int n = abstractMediator.getCurrentSkin();
            if (n == -1) {
                LOG.fatal(1024).append("Mediator ").append(abstractMediator).append(" has no skin!").log();
                return false;
            }
            if (this.nextSkin == n) continue;
            LOG.error(1024).append("Mediator ").append(abstractMediator).append(" has skin ").append(n).append(" and not ").append(this.nextSkin).log();
        }
        return true;
    }
}

