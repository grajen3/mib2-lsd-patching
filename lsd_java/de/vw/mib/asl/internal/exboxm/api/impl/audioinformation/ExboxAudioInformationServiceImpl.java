/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl.audioinformation;

import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationListener;
import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationService;
import de.vw.mib.asl.api.exboxm.audioinformation.StationInfoData;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.DsiAudioInformationListener;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl$1;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl$2;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl$3;
import de.vw.mib.asl.internal.exboxm.services.StartupService;
import de.vw.mib.asl.internal.exboxm.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import java.util.HashSet;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exboxm.DSIExBoxM;

public class ExboxAudioInformationServiceImpl
implements ExboxAudioInformationService {
    private Invoker invoker;
    private StationInfoData lastData;
    private int lastSourceType = 255;
    private final HashSet listeners = new HashSet();
    private final Logger logger;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$DSIExBoxM;

    public ExboxAudioInformationServiceImpl(Logger logger, StartupService startupService) {
        Preconditions.checkArgumentNotNull(startupService, "Startup Service must not be null.");
        Preconditions.checkArgumentNotNull(logger, "DSIProxy must not be null.");
        this.logger = logger;
        this.addStartupServiceListener(startupService);
    }

    @Override
    public void addListener(ExboxAudioInformationListener exboxAudioInformationListener) {
        if (exboxAudioInformationListener == null) {
            throw new IllegalArgumentException("Listener must not be null.");
        }
        if (this.listeners.contains(exboxAudioInformationListener)) {
            throw new IllegalArgumentException("Same listener registered twice.");
        }
        this.listeners.add(exboxAudioInformationListener);
    }

    @Override
    public int getCurrentAudioSource() {
        return this.lastSourceType;
    }

    @Override
    public StationInfoData getCurrentStationInfo() {
        return this.lastData;
    }

    @Override
    public void removeListener(ExboxAudioInformationListener exboxAudioInformationListener) {
        this.listeners.remove(exboxAudioInformationListener);
    }

    void registerToDsi(DSIProxy dSIProxy) {
        Preconditions.checkArgumentNotNull(dSIProxy, "DSIProxy must not be null.");
        DSIExBoxM dSIExBoxM = (DSIExBoxM)dSIProxy.getService(null, class$org$dsi$ifc$exboxm$DSIExBoxM == null ? (class$org$dsi$ifc$exboxm$DSIExBoxM = ExboxAudioInformationServiceImpl.class$("org.dsi.ifc.exboxm.DSIExBoxM")) : class$org$dsi$ifc$exboxm$DSIExBoxM);
        dSIExBoxM.setNotification(new int[]{5, 6}, this.createAudioInfoListener());
    }

    void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }

    void updateSourceType(int n) {
        this.lastSourceType = n;
        if (this.logger.isTraceEnabled(8)) {
            this.logger.trace(8, new StringBuffer().append("[ExboxAudioSourceServiceImpl] New audio source >").append(n).append("< will be notified.").toString());
        }
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ExboxAudioInformationListener exboxAudioInformationListener = (ExboxAudioInformationListener)iterator.next();
            this.notifyAudioSourceAsynchronously(exboxAudioInformationListener, n);
        }
    }

    void updateStationInfoData(StationInfoData stationInfoData) {
        this.lastData = stationInfoData;
        if (this.logger.isTraceEnabled(8)) {
            this.logger.trace(8, "[StationInfoServiceImpl] New station info will be notified.");
        }
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ExboxAudioInformationListener exboxAudioInformationListener = (ExboxAudioInformationListener)iterator.next();
            this.notifyStationInfoUpdateAsynchronously(exboxAudioInformationListener, stationInfoData);
        }
    }

    private void addStartupServiceListener(StartupService startupService) {
        startupService.addStartupListener(new ExboxAudioInformationServiceImpl$1(this));
    }

    private DSIListener createAudioInfoListener() {
        return new DsiAudioInformationListener(this);
    }

    private void notifyAudioSourceAsynchronously(ExboxAudioInformationListener exboxAudioInformationListener, int n) {
        this.invoker.invoke(new ExboxAudioInformationServiceImpl$2(this, exboxAudioInformationListener, n));
    }

    private void notifyStationInfoUpdateAsynchronously(ExboxAudioInformationListener exboxAudioInformationListener, StationInfoData stationInfoData) {
        this.invoker.invoke(new ExboxAudioInformationServiceImpl$3(this, exboxAudioInformationListener, stationInfoData));
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

