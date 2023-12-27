/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import org.dsi.ifc.global.ResourceLocator;

public class PresetManualPictureStore {
    private static boolean isPictureStoreTargetAvailable = false;
    private static boolean deleteAllPicturesFailed = false;

    private static boolean isDeleteAllPicturesFailed() {
        return deleteAllPicturesFailed;
    }

    public static void setDeleteAllPicturesFailed(boolean bl) {
        deleteAllPicturesFailed = bl;
    }

    public static boolean isPictureStoreTargetAvailable() {
        if (!isPictureStoreTargetAvailable) {
            ServiceManager.logger.warn(128).append("PresetManualPictureStore - storePresetPicture()").log();
        }
        return isPictureStoreTargetAvailable;
    }

    public static void setPictureStoreTargetAvailable(boolean bl) {
        isPictureStoreTargetAvailable = bl;
        if (bl) {
            RadioDataApi.updatedPresetsAfterStartUpOrProfileChange();
        }
    }

    public static void storePresetPicture(AbstractTarget abstractTarget, int n, ResourceLocator resourceLocator, int n2, int n3, int n4) {
        try {
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("PresetManualPictureStore - storePresetPicture() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("PresetManualPictureStore - storePresetPicture()").log();
            }
            if (null == resourceLocator || null == abstractTarget || !PresetManualPictureStore.isPictureStoreTargetAvailable()) {
                return;
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(abstractTarget.getTargetId(), -2134895616, 544552960);
            eventGeneric.setInt(0, n4);
            eventGeneric.setInt(1, n3);
            eventGeneric.setInt(2, RadioData.getAmfmDatabase().getPresetWidth());
            eventGeneric.setInt(3, RadioData.getAmfmDatabase().getPresetHeigth());
            abstractTarget.send(eventGeneric);
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(abstractTarget.getTargetId(), -2134895616, n2, 561330176);
            eventGeneric2.setInt(0, n4);
            eventGeneric2.setObject(1, resourceLocator);
            eventGeneric2.setObject(2, new Integer(n));
            abstractTarget.send(eventGeneric2);
            if (RadioUtil.isDabTraceEnabled()) {
                RadioDabTraceUtil.traceDab(abstractTarget.getTargetId(), new StringBuffer().append("storePresetPicture - index[").append(n).append("] ResourceLocator[").append(resourceLocator).append("]").toString());
            }
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.logger.error(128, "PresetManualPictureStore - storePresetPicture()", genericEventException);
        }
    }

    public static void deletePicture(ResourceLocator[] resourceLocatorArray, AbstractTarget abstractTarget) {
        try {
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("PresetManualPictureStore - deletePicture() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("PresetManualPictureStore - deletePicture()").log();
            }
            if (null == resourceLocatorArray || null == abstractTarget || !PresetManualPictureStore.isPictureStoreTargetAvailable()) {
                return;
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(abstractTarget.getTargetId(), -2134895616, 661993472);
            eventGeneric.setObject(0, resourceLocatorArray);
            eventGeneric.setBoolean(1, true);
            abstractTarget.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.logger.error(128, "PresetManualPictureStore - deletePicture()", genericEventException);
        }
    }

    public static void deleteAllPictures(int n, AbstractTarget abstractTarget) {
        try {
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("PresetManualPictureStore - deleteAllPictures() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("PresetManualPictureStore - deleteAllPictures()").log();
            }
            if (null == abstractTarget || !PresetManualPictureStore.isPictureStoreTargetAvailable()) {
                return;
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(abstractTarget.getTargetId(), -2134895616, 645216256);
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, true);
            abstractTarget.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.logger.error(128, "PresetManualPictureStore - deleteAllPictures()", genericEventException);
        }
    }
}

