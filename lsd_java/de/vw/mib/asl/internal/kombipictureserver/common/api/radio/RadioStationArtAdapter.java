/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.radio;

import de.vw.mib.asl.internal.kombipictureserver.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.kombipictureserver.common.util.KombiPictureServerUtil;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;

public class RadioStationArtAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
RadioStationArtService {
    private static final int[] RADIO_STATION_ART_LIST_IDS = new int[]{1002841088, 1036395520, 1019618304, 1053172736};
    private boolean isFMStationArtValid = this.isCurrentFmStationArtValidIntern();
    private ResourceLocator resourceLocatorFMStationArt;
    private boolean isAMStationArtValid = this.isCurrentAmStationArtValidIntern();
    private ResourceLocator resourceLocatorAMStationArt;
    private boolean isDABStationArtValid = this.isCurrentDabStationArtValidIntern();
    private ResourceLocator resourceLocatorDABStationArt;
    private boolean isSDARSStationArtValid = this.isCurrentSdarsStationArtValidIntern();
    private ResourceLocator resourceLocatorSDARSStationArt;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService;

    public RadioStationArtAdapter() {
        this.resourceLocatorFMStationArt = this.getCurrentFmStationArtIntern();
        this.resourceLocatorAMStationArt = this.getCurrentAmStationArtIntern();
        this.resourceLocatorDABStationArt = this.getCurrentDabStationArtIntern();
        this.resourceLocatorSDARSStationArt = this.getCurrentSdarsStationArtIntern();
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService = RadioStationArtAdapter.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService;
    }

    @Override
    protected int[] getPropertyIds() {
        return null;
    }

    @Override
    protected int[] getListIds() {
        return RADIO_STATION_ART_LIST_IDS;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected void listValueChanged(int n) {
        switch (n) {
            case 2410043: {
                if (!KombiPictureServerUtil.compareResourceLocator(this.resourceLocatorFMStationArt, this.getCurrentFmStationArtIntern())) {
                    this.resourceLocatorFMStationArt = this.getCurrentFmStationArtIntern();
                    this._notifyServiceDelegates(-1);
                }
                if (this.isFMStationArtValid == this.isCurrentFmStationArtValidIntern()) break;
                this.isFMStationArtValid = this.isCurrentFmStationArtValidIntern();
                this._notifyServiceDelegates(-2);
                break;
            }
            case 2410044: {
                if (!KombiPictureServerUtil.compareResourceLocator(this.resourceLocatorAMStationArt, this.getCurrentAmStationArtIntern())) {
                    this.resourceLocatorAMStationArt = this.getCurrentAmStationArtIntern();
                    this._notifyServiceDelegates(-5);
                }
                if (this.isAMStationArtValid == this.isCurrentAmStationArtValidIntern()) break;
                this.isAMStationArtValid = this.isCurrentAmStationArtValidIntern();
                this._notifyServiceDelegates(-6);
                break;
            }
            case 2410045: {
                if (!KombiPictureServerUtil.compareResourceLocator(this.resourceLocatorDABStationArt, this.getCurrentDabStationArtIntern())) {
                    this.resourceLocatorDABStationArt = this.getCurrentDabStationArtIntern();
                    this._notifyServiceDelegates(-3);
                }
                if (this.isDABStationArtValid == this.isCurrentDabStationArtValidIntern()) break;
                this.isDABStationArtValid = this.isCurrentDabStationArtValidIntern();
                this._notifyServiceDelegates(-4);
                break;
            }
            case 2410046: {
                if (!KombiPictureServerUtil.compareResourceLocator(this.resourceLocatorSDARSStationArt, this.getCurrentSdarsStationArtIntern())) {
                    this.resourceLocatorSDARSStationArt = this.getCurrentSdarsStationArtIntern();
                    this._notifyServiceDelegates(-7);
                }
                if (this.isSDARSStationArtValid == this.isCurrentSdarsStationArtValidIntern()) break;
                this.isSDARSStationArtValid = this.isCurrentSdarsStationArtValidIntern();
                this._notifyServiceDelegates(-8);
                break;
            }
        }
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                RadioStationArtDelegate radioStationArtDelegate = (RadioStationArtDelegate)iterator.next();
                radioStationArtDelegate.updateRadioStationArt(this, n);
            }
        }
    }

    @Override
    public ResourceLocator getCurrentFmStationArt() {
        return this.resourceLocatorFMStationArt;
    }

    private ResourceLocator getCurrentFmStationArtIntern() {
        return RadioStationArtAdapter.getResourceLocatorListValue(1002841088, 0);
    }

    @Override
    public boolean isCurrentFmStationArtValid() {
        return this.isFMStationArtValid;
    }

    private boolean isCurrentFmStationArtValidIntern() {
        return RadioStationArtAdapter.getBooleanListValue(1002841088, 1);
    }

    @Override
    public ResourceLocator getCurrentAmStationArt() {
        return this.resourceLocatorAMStationArt;
    }

    private ResourceLocator getCurrentAmStationArtIntern() {
        return RadioStationArtAdapter.getResourceLocatorListValue(1019618304, 0);
    }

    @Override
    public boolean isCurrentAmStationArtValid() {
        return this.isAMStationArtValid;
    }

    private boolean isCurrentAmStationArtValidIntern() {
        return RadioStationArtAdapter.getBooleanListValue(1019618304, 1);
    }

    @Override
    public ResourceLocator getCurrentDabStationArt() {
        return this.resourceLocatorDABStationArt;
    }

    private ResourceLocator getCurrentDabStationArtIntern() {
        return RadioStationArtAdapter.getResourceLocatorListValue(1036395520, 0);
    }

    @Override
    public boolean isCurrentDabStationArtValid() {
        return this.isDABStationArtValid;
    }

    private boolean isCurrentDabStationArtValidIntern() {
        return RadioStationArtAdapter.getBooleanListValue(1036395520, 1);
    }

    @Override
    public ResourceLocator getCurrentSdarsStationArt() {
        return RadioStationArtAdapter.getResourceLocatorListValue(1053172736, 0);
    }

    private ResourceLocator getCurrentSdarsStationArtIntern() {
        return RadioStationArtAdapter.getResourceLocatorListValue(1053172736, 0);
    }

    @Override
    public boolean isCurrentSdarsStationArtValid() {
        return this.isSDARSStationArtValid;
    }

    private boolean isCurrentSdarsStationArtValidIntern() {
        return RadioStationArtAdapter.getBooleanListValue(1053172736, 1);
    }

    @Override
    public int getCurrentlyActiveRadioPresetIndex() {
        return RadioStationArtAdapter.getIntegerListValue(2486, 0);
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

