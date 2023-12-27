/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.swap;

import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.swap.SFscStatusUtil;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.swap.transformer.SWaPFECDetailsCollector;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swap.DSISWaP;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscStatus;

public final class AslTargetSWaP
extends AbstractASLTarget {
    private static final String LOGGING_DELIM;
    private static final int SPORT_HMI_FEC;
    static final int ICC_HMI_FEC;
    private boolean sportHMIStatusRequested = false;
    private boolean isIccStatusRequested = false;
    private DSISWaP dsiSWaP;
    private SWaPFECDetailsCollector[] detailsCollector = new SWaPFECDetailsCollector[]{new SWaPFECDetailsCollector()};
    private SFscStatus[] installedFscs = null;
    private int fscIndexForShowingDetails = 0;
    private final IPersistableEarlyData persistableEarlyData;
    private final EventFactory eventFactory;
    private Boolean isIccAvailable = null;
    private boolean isFirstSwapUpdate = true;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaP;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaPListener;

    public AslTargetSWaP(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.persistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
        this.eventFactory = ServiceManager.mGenericEventFactory;
    }

    public AslTargetSWaP(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.persistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
        this.eventFactory = ServiceManager.mGenericEventFactory;
    }

    AslTargetSWaP(GenericEvents genericEvents, String string, IPersistableEarlyData iPersistableEarlyData, EventFactory eventFactory) {
        super(genericEvents, string);
        this.persistableEarlyData = iPersistableEarlyData;
        this.eventFactory = eventFactory;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 1073743152: {
                this.processAslSelectFECInstalled(eventGeneric);
                break;
            }
            case 4200001: {
                this.sportHMIStatusRequested = true;
                break;
            }
            case 4200003: {
                this.processIccStatusRequested();
                break;
            }
        }
    }

    @Override
    public int getSubClassifier() {
        return 4096;
    }

    private void processPowerOn() {
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        this.dsiSWaP = (DSISWaP)dSIServiceLocator.getService(this, class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = AslTargetSWaP.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP);
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$swap$DSISWaPListener == null ? (class$org$dsi$ifc$swap$DSISWaPListener = AslTargetSWaP.class$("org.dsi.ifc.swap.DSISWaPListener")) : class$org$dsi$ifc$swap$DSISWaPListener);
        dSIServiceLocator.addResponseListener(this, class$org$dsi$ifc$swap$DSISWaPListener == null ? (class$org$dsi$ifc$swap$DSISWaPListener = AslTargetSWaP.class$("org.dsi.ifc.swap.DSISWaPListener")) : class$org$dsi$ifc$swap$DSISWaPListener, dSIListener);
        this.dsiSWaP.setNotification(8, dSIListener);
    }

    private void processAslSelectFECInstalled(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWaP] ").append("processAslSelectFECInstalled").log();
        }
        this.fscIndexForShowingDetails = eventGeneric.getInt(0);
        SFscStatus sFscStatus = this.installedFscs[this.fscIndexForShowingDetails];
        this.dsiSWaP.getFscDetails(sFscStatus.swid, sFscStatus.state, sFscStatus.index);
    }

    public static int convertFscStateFromDSIValues(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 3;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public void dsiSWaPUpdateFscList(SFscStatus[] sFscStatusArray, int n) {
        Object object;
        int n2;
        int n3;
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWaP] ").append("dsiSWaPUpdateFscList").log();
        }
        int n4 = sFscStatusArray.length;
        ArrayList arrayList = new ArrayList();
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        for (n3 = 0; n3 < n4; ++n3) {
            if (sFscStatusArray[n3].state == 2) {
                intOptHashSet.add(sFscStatusArray[n3].swid);
                continue;
            }
            arrayList.add(sFscStatusArray[n3]);
        }
        n3 = arrayList.size();
        this.installedFscs = new SFscStatus[n3];
        boolean bl = false;
        for (n2 = 0; n2 < n3; ++n2) {
            object = (SFscStatus)arrayList.get(n2);
            this.installedFscs[n2] = new SFscStatus(((SFscStatus)object).swid, ((SFscStatus)object).state, ((SFscStatus)object).index);
            if (bl || ((SFscStatus)object).swid != 263680 || ((SFscStatus)object).state != 0) continue;
            bl = true;
        }
        if (this.isFirstSwapUpdate) {
            this.isFirstSwapUpdate = false;
            this.persistableEarlyData.setSportHMIEnabled(bl);
            this.triggerSportHMIEvent(bl);
        } else if (bl != this.persistableEarlyData.getSportHMIEnabled()) {
            this.persistableEarlyData.setSportHMIEnabled(bl);
            if (this.sportHMIStatusRequested) {
                this.triggerSportHMIEvent(bl);
            }
        }
        ListManager.getGenericASLList(1573).updateList(this.installedFscs);
        n2 = intOptHashSet.size();
        object = new int[n2];
        Object[] objectArray = new String[n2];
        int n5 = 0;
        IntIterator intIterator = intOptHashSet.iterator();
        while (intIterator.hasNext()) {
            int n6 = intIterator.next();
            object[n5] = n6;
            ++n5;
        }
        Arrays.sort((int[])object);
        for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
            objectArray[i2] = SFscStatusUtil.toHexString((int)object[i2]);
        }
        ListManager.getGenericASLList(1568).updateList(objectArray);
        this.updateIccAvailability(sFscStatusArray);
    }

    private void processIccStatusRequested() {
        this.isIccStatusRequested = true;
        if (this.isIccAvailable != null) {
            this.fireIccStatusResponse(this.isIccAvailable);
        }
    }

    private void updateIccAvailability(SFscStatus[] sFscStatusArray) {
        this.isIccAvailable = AslTargetSWaP.isIccAvailable(sFscStatusArray);
        this.fireIccStatusResponse(this.isIccAvailable);
    }

    private static Boolean isIccAvailable(SFscStatus[] sFscStatusArray) {
        boolean bl = SFscStatusUtil.containsLegalStatus(sFscStatusArray, 263936);
        return bl;
    }

    private void fireIccStatusResponse(boolean bl) {
        if (!this.isIccStatusRequested) {
            return;
        }
        EventGeneric eventGeneric = this.eventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(1142308864, eventGeneric);
        this.isIccStatusRequested = false;
    }

    private void triggerSportHMIEvent(boolean bl) {
        EventGeneric eventGeneric = this.eventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(1108754432, eventGeneric);
    }

    public void dsiSWaPGetFscDetail(SFscDetails sFscDetails) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWaP] ").append("dsiSWaPGetFscDetail").log();
        }
        this.detailsCollector[0].swap_fec_details__date = sFscDetails.date;
        this.detailsCollector[0].swap_fec_details__state = AslTargetSWaP.convertFscStateFromDSIValues(sFscDetails.state);
        String string = SFscStatusUtil.toHexString(sFscDetails.swid);
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSWaP] ").append("dsiSWaPGetFscDetail fec: ").append(string).append(" date ").append(this.detailsCollector[0].swap_fec_details__date).log();
        }
        this.detailsCollector[0].swap_fec_details__code = string;
        this.detailsCollector[0].swap_fec_details__vcrn = sFscDetails.vcrn;
        this.detailsCollector[0].swap_fec_details__vin = sFscDetails.vin;
        ListManager.getGenericASLList(1575).updateList(this.detailsCollector);
    }

    public void dsiSWaPAsyncException(int n, String string, int n2) {
        this.warn().append("[AslTargetSWaP] ").append("DSISWaP-ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").log();
    }

    @Override
    public int getDefaultTargetId() {
        return 5501;
    }

    public static String getFECCodeString(int n) {
        return SFscStatusUtil.toHexString(n);
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

