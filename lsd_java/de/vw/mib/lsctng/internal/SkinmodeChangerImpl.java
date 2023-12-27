/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.lsctng.SkinmodeChanger;
import de.vw.mib.lsctng.internal.AbstractChanger;
import de.vw.mib.lsctng.internal.AbstractMediator;

class SkinmodeChangerImpl
extends AbstractChanger
implements SkinmodeChanger {
    private final int currentSkinmode;
    private final int nextSkinmode;
    private final int[] skinmodeStrat;
    private final IntObjectMap expectedChanges;

    SkinmodeChangerImpl(int n, int n2, CowList cowList) {
        super(cowList, SkinmodeChanger.SKINMODE_CHANGE_TIMEOUT_PER_SKINMODE, SkinmodeChanger.SKINMODE_CHANGE_TIMEOUT_TOTAL);
        this.currentSkinmode = n;
        this.nextSkinmode = n2;
        this.expectedChanges = new IntObjectOptHashMap();
        this.skinmodeStrat = this.computeSkinmodeStrategyOnFailRollback();
    }

    private int[] computeSkinmodeStrategyOnFailRollback() {
        int[] nArray = new int[]{this.nextSkinmode, this.currentSkinmode};
        LogMessage logMessage = LOG.info(1024).append("skinmode strategy = [");
        String string = "";
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            logMessage.append(string).append(nArray[i2]);
            string = ", ";
        }
        logMessage.append("]").log();
        return nArray;
    }

    @Override
    protected int getStrategyLength() {
        return this.skinmodeStrat.length;
    }

    @Override
    protected void changeInternal(AbstractMediator abstractMediator, int n, int n2) {
        int n3 = this.skinmodeStrat[n];
        this.expectedChanges.put(n2, abstractMediator);
        abstractMediator.onNewSkinmode(this, n3, n2);
    }

    @Override
    protected CowList computeMediatorsForNextChange(CowList cowList, int n) {
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            if (((AbstractMediator)cowList2.head()).getCurrentSkinmode() == this.skinmodeStrat[n]) continue;
            return cowList;
        }
        return CowList.EMPTY;
    }

    @Override
    public synchronized void setChangeResult(int n, boolean bl, int n2) {
        LOG.normal(1024).append("skinmode change result: changeId=").append(n).append(", result=").append(bl).append(", skinmode=").append(n2).log();
        AbstractMediator abstractMediator = (AbstractMediator)this.expectedChanges.get(n);
        abstractMediator.skinmodeChangeEnded(n, bl, n2);
        this.checkAllChangesReady();
    }

    @Override
    protected boolean isChanging(AbstractMediator abstractMediator) {
        return abstractMediator.isChangingSkinmode();
    }

    @Override
    boolean isRelevantMediator(AbstractMediator abstractMediator) {
        return abstractMediator.isInterestedInSkinmodeChanges();
    }

    @Override
    protected boolean tryToReachValidState(CowList cowList) {
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            AbstractMediator abstractMediator = (AbstractMediator)cowList.head();
            int n = abstractMediator.getCurrentSkinmode();
            if (n == -1) {
                LOG.fatal(1024).append("Mediator ").append(abstractMediator).append(" has no skinmode!").log();
                return false;
            }
            if (this.nextSkinmode == n) continue;
            LOG.error(1024).append("Mediator ").append(abstractMediator).append(" has skinmode ").append(n).append(" and not ").append(this.nextSkinmode).log();
        }
        return true;
    }
}

