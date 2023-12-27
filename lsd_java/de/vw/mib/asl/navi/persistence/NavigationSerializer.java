/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.navi.persistence.Navigation;
import de.vw.mib.collections.ints.IntIterator;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class NavigationSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$navi$persistence$NavigationSerializer;

    NavigationSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 1;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((Navigation)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeUserSpecificData((Navigation)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(Navigation navigation) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(navigation.getRouteOptionsVignetteAvailableCountryIds().size());
        IntIterator intIterator = navigation.getRouteOptionsVignetteAvailableCountryIds().iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            dataOutputStream.writeInt(n);
        }
        dataOutputStream.writeInt(navigation.getOnlineToursAvailable());
        dataOutputStream.writeBoolean(navigation.isSeasonalRestrictions());
        dataOutputStream.writeBoolean(navigation.isStatisticalData());
        dataOutputStream.writeBoolean(navigation.isMergingTraffic());
        dataOutputStream.writeBoolean(navigation.isReduceLane());
        dataOutputStream.writeBoolean(navigation.isRailwayCrossing());
        dataOutputStream.writeInt(navigation.getSpeedCameraWarningType());
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(Navigation navigation) {
        byte by;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(navigation.getVoiceAnouncementDuringPhoneCall());
        dataOutputStream.writeInt(navigation.getVoiceAnouncementDetail());
        dataOutputStream.writeBoolean(navigation.isVoiceAnouncementState());
        dataOutputStream.writeInt(navigation.getTrafficSignMode());
        dataOutputStream.writeInt(navigation.getGuidanceTimeFormat());
        dataOutputStream.writeBoolean(navigation.isGuidanceStatusLineInfo());
        dataOutputStream.writeBoolean(navigation.isBorderChangeActive());
        dataOutputStream.writeBoolean(navigation.isRouteOptionsAlternativeRouteCalc());
        dataOutputStream.writeInt(navigation.getRouteOptionsRouteCalculationType());
        dataOutputStream.writeInt(navigation.getRouteOptionsDynamicRouteCalculation());
        dataOutputStream.writeInt(navigation.getRouteOptionsAvoidRoadTypes().size());
        Object object = navigation.getRouteOptionsAvoidRoadTypes().iterator();
        while (object.hasNext()) {
            by = object.next();
            dataOutputStream.writeBoolean(by != 0);
        }
        dataOutputStream.writeBoolean(navigation.isMapMainMapShowBrandIcons());
        dataOutputStream.writeBoolean(navigation.isMapMainMapShowFavoriteIcons());
        dataOutputStream.writeBoolean(navigation.isMapMainLaneGuidance());
        dataOutputStream.writeBoolean(navigation.isFuelWarinigPopup());
        dataOutputStream.writeBoolean(navigation.isHOVUsage());
        dataOutputStream.writeBoolean(navigation.isMainMapShowPoiIcons());
        dataOutputStream.writeInt(navigation.getHomeAddressStream().size());
        object = navigation.getHomeAddressStream().iterator();
        while (object.hasNext()) {
            by = (Byte)object.next();
            dataOutputStream.writeByte(by);
        }
        dataOutputStream.writeInt(navigation.getMainMapOrientation());
        dataOutputStream.writeInt(navigation.getMainMapTypeLast());
        dataOutputStream.writeBoolean(navigation.isMainMapShowSpeedAndFlow());
        dataOutputStream.writeBoolean(navigation.isTrafficShowFreeFlow());
        dataOutputStream.writeBoolean(navigation.isTrafficShowCongestion());
        dataOutputStream.writeBoolean(navigation.isTrafficShowIncidents());
        dataOutputStream.writeBoolean(navigation.isMainMapIsKdkActive());
        dataOutputStream.writeInt(navigation.getMapInMapMode());
        dataOutputStream.writeInt(navigation.getMainMapAutoZoomMode());
        dataOutputStream.writeBoolean(navigation.isSpeedCameraWarning());
        dataOutputStream.writeBoolean(navigation.isMainMapVisibleInKombi());
        dataOutputStream.writeInt(navigation.getMapTypeKombiFpk());
        dataOutputStream.writeInt(navigation.getMapOrientationKombiFpk());
        dataOutputStream.writeInt(navigation.getMapContentKombiFpk());
        dataOutputStream.writeBoolean(navigation.isKdkActiveInKombiFpk());
        dataOutputStream.writeInt(navigation.getAutoZoomModeKombiFpk());
        dataOutputStream.writeBoolean(navigation.isPrivacyMode());
        dataOutputStream.writeBoolean(navigation.isSplitScreenGuidanceVisibility());
        dataOutputStream.writeBoolean(navigation.isSplitScreenNoGuidanceVisibility());
        dataOutputStream.writeInt(navigation.getSplitScreenGuidanceContent());
        dataOutputStream.writeInt(navigation.getSplitScreenNoGuidanceContent());
        dataOutputStream.writeBoolean(navigation.isAudibleApproachPPOIHintStatus());
        dataOutputStream.writeInt(navigation.getMainMapMapMode());
        dataOutputStream.writeInt(navigation.getDayNightMainMapMode());
        dataOutputStream.writeBoolean(navigation.isPnavEnabled());
        dataOutputStream.writeBoolean(navigation.isShowSldeHelp());
        dataOutputStream.writeInt(navigation.getLastModeDestinationInput());
        dataOutputStream.writeLong(navigation.getLastTimeStampBeforeHmiOff());
        return byteArrayOutputStream.toByteArray();
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
        $assertionsDisabled = !(class$de$vw$mib$asl$navi$persistence$NavigationSerializer == null ? (class$de$vw$mib$asl$navi$persistence$NavigationSerializer = NavigationSerializer.class$("de.vw.mib.asl.navi.persistence.NavigationSerializer")) : class$de$vw$mib$asl$navi$persistence$NavigationSerializer).desiredAssertionStatus();
    }
}

