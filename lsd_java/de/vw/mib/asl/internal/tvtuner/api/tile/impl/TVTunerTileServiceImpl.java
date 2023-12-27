/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.api.tile.impl;

import de.vw.mib.asl.api.tvtuner.tile.TVTunerTileListener;
import de.vw.mib.asl.api.tvtuner.tile.TVTunerTileService;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TVTunerTileServiceImpl
implements TVTunerTileService,
TVTunerTileListener {
    private List listeners = Collections.synchronizedList(new ArrayList());
    private int currentAvVideoFormat = 0;
    private int currentTvVideoFormat = 0;

    @Override
    public void registerListener(TVTunerTileListener tVTunerTileListener) {
        if (!this.listeners.contains(tVTunerTileListener)) {
            this.listeners.add(tVTunerTileListener);
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#registerListener() - Listener count = ").append(this.listeners.size()).toString());
        }
        this.sendAllToListener(tVTunerTileListener);
    }

    @Override
    public void unregisterListener(TVTunerTileListener tVTunerTileListener) {
        this.listeners.remove(tVTunerTileListener);
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#unregisterListener() - Listener count = ").append(this.listeners.size()).toString());
        }
    }

    @Override
    public void requestNextStation() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerTileServiceImpl#requestNextStation()");
        }
        TVTunerObjectAccessor.getTuningHandler().tuneToNextStation(1);
    }

    @Override
    public void requestPreviousStation() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerTileServiceImpl#requestPreviousStation()");
        }
        TVTunerObjectAccessor.getTuningHandler().tuneToNextStation(2);
    }

    @Override
    public void requestActiveSource(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#requestActiveSource( source = ").append(n).append(" )").toString());
        }
        TVTunerObjectAccessor.getTvAvSourceHandler().setSource(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateCurrentStationName(String string) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateCurrentStationName( stationName = ").append(string).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateCurrentStationName(string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDisclaimerTunerNotAvailableVisible(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateDisclaimerNotAvailableVisible( visible = ").append(bl).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateDisclaimerTunerNotAvailableVisible(bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDisclaimerTunerStartingVisible(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateDisclaimerStartingVisible( visible = ").append(bl).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateDisclaimerTunerStartingVisible(bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDisclaimerCasVisible(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateDisclaimerCasVisible( visible = ").append(bl).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateDisclaimerCasVisible(bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateActiveSource(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateActiveSource( source = ").append(n).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateActiveSource(n);
            }
        }
        TVTunerObjectAccessor.getTileDisclaimerHelper().checkDisclaimers();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateTVVideoFormat(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateTVVideoFormat( format = ").append(n).append(" )").toString());
        }
        this.currentTvVideoFormat = n;
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateTVVideoFormat(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateAVVideoFormat(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateAVVideoFormat( format = ").append(n).append(" )").toString());
        }
        this.currentAvVideoFormat = n;
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateAVVideoFormat(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateTVMuteIconVisible(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateTVMuteIconVisible( visible = ").append(bl).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateTVMuteIconVisible(bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDisclaimerRadioVisible(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateDisclaimerRadioVisible( visible = ").append(bl).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateDisclaimerRadioVisible(bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateProgramInfo(String string, int n, int n2, int n3, int n4) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateProgramTime( starthour = ").append(n).append(", startMinute = ").append(n2).append(", endHour = ").append(n3).append(", endMinute = ").append(n4).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateProgramInfo(string, n, n2, n3, n4);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSourceAvAvailable(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerTileServiceImpl#updateSourceAvAvailable( available = ").append(bl).append(" )").toString());
        }
        List list = this.listeners;
        synchronized (list) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((TVTunerTileListener)iterator.next()).updateSourceAvAvailable(bl);
            }
        }
    }

    private void sendAllToListener(TVTunerTileListener tVTunerTileListener) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerTileServiceImpl#sendAllToListener()");
        }
        tVTunerTileListener.updateCurrentStationName(TVTunerObjectAccessor.getTVInfo().getCurrentStationName());
        int n = TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource();
        if (n == -1) {
            n = 0;
        }
        tVTunerTileListener.updateActiveSource(n);
        if (n == 0) {
            tVTunerTileListener.updateTVVideoFormat(this.currentTvVideoFormat);
        } else if (n == 1) {
            tVTunerTileListener.updateAVVideoFormat(this.currentAvVideoFormat);
        }
        tVTunerTileListener.updateSourceAvAvailable(TVTunerObjectAccessor.getStartUpConfigHandler().getLastStartupConfig().avSrcAvail);
        tVTunerTileListener.updateTVMuteIconVisible(TVTunerObjectAccessor.getTvTunerAudio().isVolumeLockNeeded());
        TVTunerObjectAccessor.getTileDisclaimerHelper().checkDisclaimers();
    }
}

