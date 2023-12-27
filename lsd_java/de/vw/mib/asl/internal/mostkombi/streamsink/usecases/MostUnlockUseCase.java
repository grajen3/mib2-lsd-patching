/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkUseCase;

public class MostUnlockUseCase
extends StreamSinkUseCase {
    private NavigationMapService _navigationMapService;
    private DisplayManagementService _displayManagementService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;

    private NavigationMapService getNavigationMapService() {
        if (this._navigationMapService == null) {
            this._navigationMapService = (NavigationMapService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = MostUnlockUseCase.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService);
        }
        return this._navigationMapService;
    }

    private DisplayManagementService getDisplayManagementService() {
        if (this._displayManagementService == null) {
            this._displayManagementService = (DisplayManagementService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = MostUnlockUseCase.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService);
        }
        return this._displayManagementService;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getIdentifier() {
        return 1505498624;
    }

    @Override
    public void executeSequence() {
        this.getNavigationMapService().setMapInvisible();
        this.getDisplayManagementService().setDataFrameRate(0);
        SequenceDelegate sequenceDelegate = this.getSequenceDelegate();
        if (sequenceDelegate != null) {
            sequenceDelegate.sequenceDone(this);
        }
    }

    @Override
    public void sequenceDone(Sequence sequence) {
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

