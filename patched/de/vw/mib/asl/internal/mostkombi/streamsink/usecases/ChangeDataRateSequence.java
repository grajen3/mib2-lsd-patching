/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkSequence;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public class ChangeDataRateSequence
extends StreamSinkSequence
implements NavigationMapDelegate,
DisplayManagementDelegate {
    private NavigationMapService _navigationMapService;
    private static /*final*/int[] NAVIGATION_MAP_SERVICES = NavigationMapDelegate.NAVIGATION_MAP_KOMBI_MAP_PROPERTIES;
    private DisplayManagementService _displayManagementService;
    private static /*final*/int[] DISPLAY_MANAGEMENT_SERVICES = new int[]{993140736};
    private DSIKOMOGfxStreamSink _komoGfxStreamSink;
    private static /*final*/int STEP_MAP_VISIBLE_CHANGE;
    private static /*final*/int STEP_KOMBI_DISPLAY_UPDATE_DATA_RATE;
    private static /*final*/int STEP_DONE;
    private int _streamSinkDataRate;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;

    public ChangeDataRateSequence(int n) {
        if (n == 1) {
            System.out.println("ChangeDataRateSequence: " + n + " ( mod -> 2 )");
            n = 2;
        } else {
            System.out.println("ChangeDataRateSequence: " + n);
        }
        new Exception("Stack trace").printStackTrace();

        this._streamSinkDataRate = n;
    }

    private DSIKOMOGfxStreamSink getKomoGfxStreamSink() {
        if (this._komoGfxStreamSink == null) {
            this._komoGfxStreamSink = (DSIKOMOGfxStreamSink)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = ChangeDataRateSequence.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink);
        }
        return this._komoGfxStreamSink;
    }

    private NavigationMapService getNavigationMapService() {
        if (this._navigationMapService == null) {
            this._navigationMapService = (NavigationMapService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = ChangeDataRateSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = ChangeDataRateSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
        }
        return this._navigationMapService;
    }

    private DisplayManagementService getDisplayManagementService() {
        if (this._displayManagementService == null) {
            this._displayManagementService = (DisplayManagementService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = ChangeDataRateSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = ChangeDataRateSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        }
        return this._displayManagementService;
    }

    public int getStreamSinkDataRate() {
        return this._streamSinkDataRate;
    }

   // @Override
    public void initialize() {
    }

   // @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = ChangeDataRateSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = ChangeDataRateSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        this.sequenceAbort();
    }

   // @Override
    public int getIdentifier() {
        return 1438389760;
    }

   // @Override
    public void executeSequence() {
        this.getKomoGfxStreamSink();
        this.stepDone();
    }

   // @Override
    public void sequenceDone(Sequence sequence) {
    }

   // @Override
    protected boolean executeNextStep() {
        if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
            this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier(), new StringBuffer().append("Starting Step ChangeDataRateSequence#").append(this.getStepDescription(this.getCurrentStep())).toString());
        }
        boolean bl = true;
        switch (this.getCurrentStep()) {
            case 0: {
                this._stepVisibleChange();
                break;
            }
            case 1: {
                this._stepChangeDataRate();
                break;
            }
            case 2: {
                bl = false;
                this.sequenceFinished();
                break;
            }
        }
        return bl;
    }

    private void _stepVisibleChange() {
        switch (this.getStreamSinkDataRate()) {
            case 0: 
            case 1: {
                if (this.getNavigationMapService().getKombiMapVisibility() == 1) {
                    this.getNavigationMapService().setMapInvisible();
                    break;
                }
                this.stepDone();
                break;
            }
            case 2: {
                if (this.getNavigationMapService().getKombiMapVisibility() == 0) {
                    this.getNavigationMapService().setMapVisible();
                    break;
                }
                this.stepDone();
                break;
            }
        }
    }

    private void _stepChangeDataRate() {
        switch (this.getStreamSinkDataRate()) {
            case 0: {
                this.getDisplayManagementService().setDataFrameRate(0); // invisible
                break;
            }
            case 1: {
                this.getDisplayManagementService().setDataFrameRate(1); // invisible
                break;
            }
            case 2: {
                this.getDisplayManagementService().setDataFrameRate(10); // visible
                break;
            }
        }
    }

   // @Override
    protected String getStepDescription(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "STEP_MAP_VISIBLE_CHANGE";
                break;
            }
            case 1: {
                string = "STEP_KOMBI_DISPLAY_UPDATE_DATA_RATE";
                break;
            }
            case 2: {
                string = "STEP_DONE";
                break;
            }
            default: {
                string = "Unknown";
            }
        }
        return string;
    }

   // @Override
    public void updateNavigationMap(NavigationMapService navigationMapService, int n) {
        if (n == 502272000) {
            this._stepVisibleChange();
        }
    }

   // @Override
    public void updateDisplayManagement(DisplayManagementService displayManagementService, int n) {
        this.stepDone();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(string);
        }
    }
}

