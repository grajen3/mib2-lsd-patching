/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.online.services.statusbar.OnlineStatusListener;
import de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingUpdate;
import de.vw.mib.asl.api.vicsetc.ASLVICSETCFactory;
import de.vw.mib.asl.api.vicsetc.ASLVicsEtcListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar$1;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar$2;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar$3;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar$4;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar$5;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar$6;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarEtcCollector;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarNavigationTargetCollector;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarNavigationTimeCollector;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarVicsCollector;

public class TargetASLStatusbar
extends AbstractASLTarget
implements INavServiceStateListener {
    private static final int[] OBSERVED_SERVICES = new int[]{-1544669696, -1527892480, -1511115264, -1494338048, -1477560832, -1460783616, -1030676224, -963567360};
    protected static final int EV_PAYMENT_AMOUNT_TIMEOUT;
    protected static final long PAYMENT_AMOUNT_TIMEOUT;
    private static final StatusbarEtcCollector[] ETC_COLLECTOR;
    private static final StatusbarVicsCollector[] VICS_COLLECTOR;
    StatusbarNavigationTimeCollector[] navigationTimeCollectorArray = (StatusbarNavigationTimeCollector[])ListManager.getGenericASLList(-168276736).getDSIObjects();
    StatusbarNavigationTimeCollector navigationTimeCollector = this.navigationTimeCollectorArray[0];
    StatusbarNavigationTargetCollector[] navigationTargetCollectorArray = (StatusbarNavigationTargetCollector[])ListManager.getGenericASLList(-185053952).getDSIObjects();
    StatusbarNavigationTargetCollector navigationTargetCollector = this.navigationTargetCollectorArray[0];
    WirelessChargingUpdate wirelessChargingUpdate = new TargetASLStatusbar$1(this);
    ASLVicsEtcListener vicsEtcListener = new TargetASLStatusbar$2(this);
    NavigationGuidanceListener navigationGuidanceListener = new TargetASLStatusbar$3(this);
    OnlineStatusListener onlineStatusListener = new TargetASLStatusbar$4(this);
    private NavigationGuidanceService navigationGuidanceService;
    private boolean phoneNetworkStateRegistered;
    private int onlineConnectionMode = -1;
    private boolean phoneNetworkTypeAvailable;
    private boolean nadPrimary;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService;

    public TargetASLStatusbar(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1824908288;
    }

    @Override
    public int getSubClassifier() {
        return 32768;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObservers(OBSERVED_SERVICES);
                ASLVICSETCFactory.getVICSETCApi().registerVicsEtcListener(this.vicsEtcListener);
                if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() != 0) {
                    this.navigationGuidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(this.navigationGuidanceListener);
                } else {
                    ASLNavigationFactory.getNavigationApi().registerNavServiceStateListener(this);
                }
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService == null ? (class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService = TargetASLStatusbar.class$("de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingService")) : class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService, new TargetASLStatusbar$5(this));
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService == null ? (class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService = TargetASLStatusbar.class$("de.vw.mib.asl.api.online.services.statusbar.OnlineStatusService")) : class$de$vw$mib$asl$api$online$services$statusbar$OnlineStatusService, new TargetASLStatusbar$6(this));
                break;
            }
            case 3600035: {
                TargetASLStatusbar.writeBooleanToDatapool(-218608384, eventGeneric.getBoolean(0));
                break;
            }
            case 2200006: {
                TargetASLStatusbar.writeBooleanToDatapool(-201831168, eventGeneric.getBoolean(0));
                break;
            }
            case 3600036: {
                TargetASLStatusbar.writeBooleanToDatapool(-235385600, eventGeneric.getBoolean(0));
                break;
            }
            case 3600038: {
                this.phoneNetworkStateRegistered = eventGeneric.getBoolean(0);
                this.setPhoneNetworkAvailabel();
                break;
            }
            case 3600037: {
                this.phoneNetworkTypeAvailable = eventGeneric.getBoolean(0);
                this.setPhoneNetworkAvailabel();
                break;
            }
            case 3600039: {
                this.nadPrimary = eventGeneric.getBoolean(0);
                this.setPhoneNetworkAvailabel();
                break;
            }
            case 3600040: {
                TargetASLStatusbar.writeIntegerToDatapool(-84390656, eventGeneric.getInt(0));
                break;
            }
            case 2200002: {
                this.onlineConnectionMode = eventGeneric.getInt(0);
                this.setPhoneNetworkAvailabel();
                break;
            }
            case 100001: {
                TargetASLStatusbar.ETC_COLLECTOR[0].statusbar_etc_state = 1;
                ListManager.getGenericASLList(-117945088).updateList(ETC_COLLECTOR);
                break;
            }
        }
    }

    private void setPhoneNetworkAvailabel() {
        boolean bl = !this.phoneNetworkTypeAvailable && this.onlineConnectionMode == 1 && this.nadPrimary || !this.phoneNetworkStateRegistered;
        TargetASLStatusbar.writeBooleanToDatapool(-101167872, !bl);
    }

    @Override
    public void navServiceStateChanged() {
        if (this.isTraceEnabled()) {
            this.trace("TargetASLStatusbar.navServiceStateChanged()", ASLNavigationFactory.getNavigationApi().getNavigationServiceState());
        }
        if (this.navigationGuidanceService == null && ASLNavigationFactory.getNavigationApi().getNavigationServiceState() != 0) {
            try {
                this.navigationGuidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(this.navigationGuidanceListener);
            }
            catch (NavigationServiceException navigationServiceException) {
                this.error(navigationServiceException);
            }
        }
    }

    static /* synthetic */ StatusbarEtcCollector[] access$000() {
        return ETC_COLLECTOR;
    }

    static /* synthetic */ StatusbarVicsCollector[] access$100() {
        return VICS_COLLECTOR;
    }

    static /* synthetic */ NavigationGuidanceService access$200(TargetASLStatusbar targetASLStatusbar) {
        return targetASLStatusbar.navigationGuidanceService;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        ETC_COLLECTOR = (StatusbarEtcCollector[])ListManager.getGenericASLList(-117945088).getDSIObjects();
        VICS_COLLECTOR = (StatusbarVicsCollector[])ListManager.getGenericASLList(-134722304).getDSIObjects();
    }
}

