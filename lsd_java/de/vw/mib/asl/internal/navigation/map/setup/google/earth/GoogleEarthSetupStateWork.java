/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.google.earth;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashSet;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.LayerProperty;

public class GoogleEarthSetupStateWork
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthSetupStateWork]");
    private final GoogleEarthSetupTargetHSM target;

    public GoogleEarthSetupStateWork(GoogleEarthSetupTargetHSM googleEarthSetupTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = googleEarthSetupTargetHSM;
    }

    public HsmState dsiMapViewerGoogleCtrlUpdateAvailableLayers(LayerProperty[] layerPropertyArray, int n) {
        if (layerPropertyArray == null || layerPropertyArray.length == 0) {
            return null;
        }
        int[] nArray = new int[layerPropertyArray.length];
        for (int i2 = 0; i2 < layerPropertyArray.length; ++i2) {
            LayerProperty layerProperty = layerPropertyArray[i2];
            ResourceLocator resourceLocator = new ResourceLocator(layerProperty.iconFilename);
            nArray[i2] = layerProperty.uId;
            if (layerProperty.uId == 1) {
                this.target.notifierModel.setLayerBusinessIcon(resourceLocator);
                this.target.notifierModel.setLayerBusinessAvailable();
                continue;
            }
            if (layerProperty.uId == 3) {
                this.target.notifierModel.setLayerWikipediaIcon(resourceLocator);
                this.target.notifierModel.setLayerWikipediaAvailable();
                continue;
            }
            if (layerProperty.uId == 2) {
                this.target.notifierModel.setLayerPanoramioIcon(resourceLocator);
                this.target.notifierModel.setLayerPanoramioAvailable();
                continue;
            }
            if (layerProperty.uId == 0) {
                this.target.notifierModel.setLayerPlacesIcon(resourceLocator);
                this.target.notifierModel.setLayerPlacesAvailable();
                continue;
            }
            this.logger.makeError().append("Unknown layer: TextDescription=\"").append(layerProperty.text).append("\", Uid=").append(layerProperty.uId).log();
        }
        int[] nArray2 = this.getVisibleLayerUIDs(nArray);
        this.target.datapool.setGoogleEarthVisibleLayer(nArray2);
        this.target.notifierDSI.setLayerVisibility(nArray2);
        this.target.notifierModel.setLayerAvailable();
        return null;
    }

    public HsmState dsiMapViewerGoogleCtrlUpdateGoogleDataStatus(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerGoogleEarthCtrlUpdateGoogleDataStatus(").append(n).append(")").log();
        }
        this.target.notifierModel.notifyGoogleEarthDataStatusChanged(n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvGoogleEarthDataStatusChanged(n);
        return null;
    }

    private int[] getVisibleLayerUIDs(int[] nArray) {
        if (nArray == null || nArray.length < 1) {
            return new int[0];
        }
        int[] nArray2 = this.target.datapool.getGoogleEarthVisibleLayer();
        if (nArray2 == null || nArray2.length < 1) {
            return new int[0];
        }
        HashSet hashSet = new HashSet(nArray2.length);
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            hashSet.add(new Integer(nArray2[i2]));
        }
        HashSet hashSet2 = new HashSet(nArray.length);
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            hashSet2.add(new Integer(nArray[i3]));
        }
        hashSet2.retainAll(hashSet);
        int[] nArray3 = new int[hashSet2.size()];
        int n = 0;
        Iterator iterator = hashSet2.iterator();
        while (iterator.hasNext()) {
            nArray3[n] = (Integer)iterator.next();
            ++n;
        }
        return nArray3;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 1074841831: {
                this.handleShowLayerWikipedia(eventGeneric);
                break;
            }
            case 1074841829: {
                this.handleShowLayerBusiness(eventGeneric);
                break;
            }
            case 1074841828: {
                this.handleShowLayerPlaces(eventGeneric);
                break;
            }
            case 1074841830: {
                this.handleShowLayerPanoramio(eventGeneric);
                break;
            }
            case 3400009: {
                this.handleGoogleEarthChangeLanguage();
                break;
            }
            case 3499043: {
                this.handleGoogleEarthCheckCrosshairVisibility();
                break;
            }
            case 3499044: {
                this.handleGoogleEarthClearCache();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleGoogleEarthChangeLanguage() {
        this.logger.trace("handleGoogleEarthChangeLanguage()");
        String string = ServiceManager.configManagerDiag.getCurrentGuiLanguage();
        if (string == null || string.length() == 0) {
            this.logger.makeError().append("The new language '").append(string).append("' is not valid, we can't change the language for Google Earth.").log();
            return;
        }
        this.target.notifierDSI.googleEarthSetLanguage(string);
    }

    private void handleGoogleEarthCheckCrosshairVisibility() {
        this.logger.trace("handleGoogleEarthCheckCrosshairVisibility()");
        int n = this.target.datapool.getMapMode();
        if (GoogleEarthUtils.isUseCrosshairMap()) {
            if (n == 2) {
                this.target.notifierDSI.setMode(3);
            }
        } else if (n == 3) {
            this.target.notifierDSI.setMode(2);
        }
    }

    private void handleGoogleEarthClearCache() {
        this.logger.trace("handleGoogleEarthClearCache()");
        this.target.notifierDSI.requestClearCache();
    }

    private void handleShowLayerBusiness(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            this.target.notifierModel.setLayerBusinessVisible();
            if (!this.isLayerVisible(1)) {
                this.makeLayerVisible(1);
            }
        } else {
            this.target.notifierModel.setLayerBusinessInvisible();
            if (this.isLayerVisible(1)) {
                this.makeLayerInvisible(1);
            }
        }
    }

    private void handleShowLayerPanoramio(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            this.target.notifierModel.setLayerPanoramioVisible();
            if (!this.isLayerVisible(2)) {
                this.makeLayerVisible(2);
            }
        } else {
            this.target.notifierModel.setLayerPanoramioInvisible();
            if (this.isLayerVisible(2)) {
                this.makeLayerInvisible(2);
            }
        }
    }

    private void handleShowLayerPlaces(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            this.target.notifierModel.setLayerPlacesVisible();
            if (!this.isLayerVisible(0)) {
                this.makeLayerVisible(0);
            }
        } else {
            this.target.notifierModel.setLayerPlacesInvisible();
            if (this.isLayerVisible(0)) {
                this.makeLayerInvisible(0);
            }
        }
    }

    private void handleShowLayerWikipedia(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            this.target.notifierModel.setLayerWikipediaVisible();
            if (!this.isLayerVisible(3)) {
                this.makeLayerVisible(3);
            }
        } else {
            this.target.notifierModel.setLayerWikipediaInvisible();
            if (this.isLayerVisible(3)) {
                this.makeLayerInvisible(3);
            }
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private boolean isLayerVisible(int n) {
        int[] nArray = this.target.datapool.getGoogleEarthVisibleLayer();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n != nArray[i2]) continue;
            return true;
        }
        return false;
    }

    private void makeLayerInvisible(int n) {
        int[] nArray = this.target.datapool.getGoogleEarthVisibleLayer();
        int[] nArray2 = new int[nArray.length - 1];
        int n2 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n == nArray[i2]) continue;
            nArray2[n2] = nArray[i2];
            ++n2;
        }
        this.target.datapool.setGoogleEarthVisibleLayer(nArray2);
        this.target.notifierDSI.setLayerVisibility(nArray2);
    }

    private void makeLayerVisible(int n) {
        int[] nArray = this.target.datapool.getGoogleEarthVisibleLayer();
        int[] nArray2 = new int[nArray.length + 1];
        int n2 = 0;
        for (n2 = 0; n2 < nArray.length; ++n2) {
            nArray2[n2] = nArray[n2];
        }
        nArray2[n2] = n;
        this.target.datapool.setGoogleEarthVisibleLayer(nArray2);
        this.target.notifierDSI.setLayerVisibility(nArray2);
    }
}

