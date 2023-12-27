/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.api.impl.listeners;

import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.hmi.utils.Preconditions;

public final class FunctionBlockResponseImpl
implements AdaptionResponse {
    private final IExtLogger logger;
    private final MapViewerDatapoolShared mapViewerDatapoolShared;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$util$IExtLogger;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared;

    public FunctionBlockResponseImpl(IExtLogger iExtLogger, MapViewerDatapoolShared mapViewerDatapoolShared) {
        Preconditions.checkNotNull(iExtLogger, new StringBuffer().append((class$de$vw$mib$asl$api$navigation$util$IExtLogger == null ? (class$de$vw$mib$asl$api$navigation$util$IExtLogger = FunctionBlockResponseImpl.class$("de.vw.mib.asl.api.navigation.util.IExtLogger")) : class$de$vw$mib$asl$api$navigation$util$IExtLogger).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(mapViewerDatapoolShared, new StringBuffer().append((class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared == null ? (class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared = FunctionBlockResponseImpl.class$("de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared")) : class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared).getName()).append(" must not be null!").toString());
        this.logger = iExtLogger;
        this.mapViewerDatapoolShared = mapViewerDatapoolShared;
    }

    @Override
    public void onSuccess(Access access) {
        if (access != null && access.contains(1118) && access.getValue(1118) == 1) {
            this.logger.makeInfo().append("NHTSA feature 'block satellite view while driving' available").log();
            this.mapViewerDatapoolShared.setDriverDistractionPreventionFeatureAvailable(true);
        } else {
            this.logger.makeInfo().append("NHTSA feature 'block satellite view while driving' not available").log();
            this.mapViewerDatapoolShared.setDriverDistractionPreventionFeatureAvailable(false);
        }
    }

    @Override
    public void onError() {
        this.logger.makeError().append("MapViewerPerspectivesStateInit couldn't receive requestHmiFuncBlockTbl from Adaptation.").log();
        this.mapViewerDatapoolShared.setDriverDistractionPreventionFeatureAvailable(false);
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

