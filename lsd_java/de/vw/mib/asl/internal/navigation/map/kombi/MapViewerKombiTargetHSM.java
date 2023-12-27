/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiDataPool;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiNotifierModel;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateInit;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateInitMapViewer;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateInitMapViewerConfigure;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateInvisible;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateMain;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateMapScaleContinuousIn;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateMapScaleContinuousOut;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateRestart;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateSpeechRecognizerActive;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateVisible;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM$1;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.map.Point;

public class MapViewerKombiTargetHSM
extends AbstractResettableAslHsmTarget
implements ReloadPersistedDataListener {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM]");
    protected final MapViewerKombiNotifierDSI notifierDSI;
    private final MapViewerKombiStateInit stateInit;
    private final MapViewerKombiStateInitMapViewer stateInitMapViewer;
    private final MapViewerKombiStateInvisible stateInvisible;
    private final MapViewerKombiStateMain stateMain;
    private final MapViewerKombiStateRestart stateRestart;
    private final MapViewerKombiStateInitMapViewerConfigure stateInitMapViewerConfigure;
    private final MapViewerKombiStateVisible stateVisible;
    private final MapViewerKombiStateSpeechRecognizerActive stateSpeechRecognizerActive;
    protected final MapViewerKombiDataPool datapool = new MapViewerKombiDataPool();
    protected final MapViewerKombiNotifierModel notifierModel;
    private static final int SCREEN_CAR_POSITION_DEFAULT_X_HEADINGUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_Y_HEADINGUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_X_NORTHUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_Y_NORTHUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_X_CHN_HEADINGUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_Y_CHN_HEADINGUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_X_CHN_NORTHUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_Y_CHN_NORTHUP;
    private static final int SCREEN_CAR_POSITION_DEFAULT_X_HEADINGUP_FPK_ENTRY;
    private static final int SCREEN_CAR_POSITION_DEFAULT_Y_HEADINGUP_FPK_ENTRY;
    private static final int SCREEN_CAR_POSITION_DEFAULT_X_NORTHUP_FPK_ENTRY;
    private static final int SCREEN_CAR_POSITION_DEFAULT_Y_NORTHUP_FPK_ENTRY;
    private int SENSOR_MODE_NIGHT = 2;
    private boolean isDayNightServiceRegistered;
    private MapViewerKombiStateMapScaleContinuousIn stateMapScaleContinuousIn;
    private MapViewerKombiStateMapScaleContinuousOut stateMapScaleContinuousOut;

    public MapViewerKombiTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierDSI = new MapViewerKombiNotifierDSI();
        this.notifierModel = new MapViewerKombiNotifierModel();
        this.stateInit = new MapViewerKombiStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateMain = new MapViewerKombiStateMain(this, "stateMain", (HsmState)this.stateInit);
        this.stateRestart = new MapViewerKombiStateRestart(this, "stateRestart", (HsmState)this.stateMain);
        this.stateVisible = new MapViewerKombiStateVisible(this, "stateVisible", (HsmState)this.stateMain);
        this.stateInvisible = new MapViewerKombiStateInvisible(this, "stateInvisible", (HsmState)this.stateMain);
        this.stateInitMapViewer = new MapViewerKombiStateInitMapViewer(this, "stateInitMapViewer", (HsmState)this.stateMain);
        this.stateInitMapViewerConfigure = new MapViewerKombiStateInitMapViewerConfigure(this, "stateInitMapViewerConfigure", (HsmState)this.stateMain);
        this.stateSpeechRecognizerActive = new MapViewerKombiStateSpeechRecognizerActive(this, "stateSpeechRecognizerActive", (HsmState)this.stateMain);
        this.stateMapScaleContinuousIn = new MapViewerKombiStateMapScaleContinuousIn(this, "stateMapScaleContinuousIn", (HsmState)this.stateVisible);
        this.stateMapScaleContinuousOut = new MapViewerKombiStateMapScaleContinuousOut(this, "stateMapScaleContinuousOut", (HsmState)this.stateVisible);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    public boolean isStateInvisbileActive() {
        boolean bl;
        boolean bl2 = bl = this.getHsm().getState() == this.stateInvisible;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("isStateInvisbileActive() - ").append(bl).log();
        }
        return bl;
    }

    public boolean isStateVisbileActive() {
        boolean bl;
        boolean bl2 = bl = this.getHsm().getState() == this.stateVisible;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("isStateVisbileActive() - ").append(bl).log();
        }
        return bl;
    }

    public boolean isStateContinuousZoomActive() {
        boolean bl;
        boolean bl2 = bl = this.getHsm().getState() == this.stateMapScaleContinuousIn || this.getHsm().getState() == this.stateMapScaleContinuousOut;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("isStateVisbileActive() - ").append(bl).log();
        }
        return bl;
    }

    public float rasterizeZoomLevel(float f2) {
        if (f2 < (float)this.datapool.getAutoZoomLimit()) {
            this.datapool.setAutoZoomLimit(this.datapool.getZoomLevelUpwards());
            return this.datapool.getZoomLevelLow();
        }
        if (f2 >= (float)this.datapool.getAutoZoomLimit()) {
            this.datapool.setAutoZoomLimit(this.datapool.getZoomLevelDownwards());
            return f2;
        }
        return this.datapool.getZoomLevelLow();
    }

    public void transStateInitMapViewer() {
        this.logger.trace("transStateInitMapViewer()");
        this.getHsm().trans(this.stateInitMapViewer);
    }

    public void transStateInitMapViewerConfigure() {
        this.logger.trace("transStateInitMapViewerConfigure()");
        this.getHsm().trans(this.stateInitMapViewerConfigure);
    }

    public void transStateInvisible() {
        this.logger.trace("transStateInvisible()");
        this.getHsm().trans(this.stateInvisible);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateRestart() {
        this.logger.trace("transStateRestart()");
        this.getHsm().trans(this.stateRestart);
    }

    void transStateMapScaleContinuousIn() {
        this.logger.trace("transStateMapScale()");
        this.getHsm().trans(this.stateMapScaleContinuousIn);
    }

    void transStateMapScaleContinuousOut() {
        this.logger.trace("transStateMapScaleContinuous()");
        this.getHsm().trans(this.stateMapScaleContinuousOut);
    }

    public void transStateSpeechRecognizerActive() {
        this.logger.trace("transStateSpeechRecognizerActive()");
        this.getHsm().trans(this.stateSpeechRecognizerActive);
    }

    public void transStateVisible() {
        this.logger.trace("transStateVisible()");
        this.getHsm().trans(this.stateVisible);
    }

    public void setPerspective2DNorth() {
        this.logger.trace("setPerspective2DNorth()");
        this.notifierDSI.viewFreeze(true);
        this.notifierDSI.setViewType(0);
        this.notifierDSI.setOrientation(2);
        Point point = this.getCarPosition(true);
        this.notifierDSI.setCarPosition(point);
        this.notifierDSI.setHotPoint(point);
        this.notifierDSI.viewFreeze(false);
        this.notifierModel.notifyFPKMapPerspective2DNorthUp();
    }

    public void setPerspective2DHeading() {
        this.logger.trace("setPerspective2DHeading()");
        this.notifierDSI.viewFreeze(true);
        this.notifierDSI.setViewType(0);
        this.notifierDSI.setOrientation(0);
        Point point = this.getCarPosition(false);
        this.notifierDSI.setCarPosition(point);
        this.notifierDSI.setHotPoint(point);
        this.notifierDSI.viewFreeze(false);
        this.notifierModel.notifyFPKMapPerspective2DHeadingUp();
    }

    public void setPerspective3D() {
        this.logger.trace("setPerspective3D()");
        this.notifierDSI.viewFreeze(true);
        this.notifierDSI.setViewType(3);
        this.notifierDSI.setOrientation(0);
        Point point = this.getCarPosition(false);
        this.notifierDSI.setCarPosition(point);
        this.notifierDSI.setHotPoint(point);
        this.notifierDSI.viewFreeze(false);
        this.notifierModel.notifyFPKMapPerspective3D();
    }

    private Point getCarPosition(boolean bl) {
        int n = this.datapool.getMapViewer3Resolution();
        if (0 == n) {
            return new Point(bl ? 400 : 400, bl ? 248 : 353);
        }
        if (1 == n) {
            return new Point(bl ? 400 : 400, bl ? 154 : 250);
        }
        if (2 == n) {
            return new Point(bl ? 505 : 505, bl ? 188 : 249);
        }
        this.logger.error("getCarPosition(): FPK resolution not avaliable, using default coordinates for FPK-STD");
        return new Point(bl ? 400 : 400, bl ? 248 : 353);
    }

    void setMapInKombiPerspective(int n) {
        this.datapool.setMapInKombiPerspective(n);
        switch (n) {
            case 0: {
                this.setPerspective2DNorth();
                break;
            }
            case 1: {
                this.setPerspective2DHeading();
                break;
            }
            case 2: {
                this.setPerspective3D();
                break;
            }
        }
    }

    @Override
    public void reloadPersistedData() {
        if (this.isStateInvisbileActive() || this.isStateVisbileActive() || this.isStateContinuousZoomActive()) {
            this.setMapInKombiPerspective(this.datapool.getMapInKombiPerspective());
            this.setSelectedDayNightMode(this.datapool.getDayNightModeMainMap());
        }
    }

    void setSelectedDayNightMode(int n) {
        this.datapool.setDayNightModeMainMap(n);
        this.notifierModel.notifyDayNightModeChanged(n);
        switch (n) {
            case 0: {
                this.changeDayNightMode(false);
                break;
            }
            case 1: {
                this.changeDayNightMode(true);
                break;
            }
            default: {
                DayNightService dayNightService = ASLSystemFactory.getSystemApi().getDayNightService();
                boolean bl = this.convertDayNightSensorValueToIsNightBoolean(dayNightService.getDayNightModeSensorValue());
                this.changeDayNightMode(bl);
            }
        }
    }

    boolean convertDayNightSensorValueToIsNightBoolean(int n) {
        return n == this.SENSOR_MODE_NIGHT;
    }

    void changeDayNightMode(boolean bl) {
        if (bl) {
            this.notifierModel.updateCurrentDayNightMode(1);
            this.notifierDSI.setNightView();
        } else {
            this.notifierModel.updateCurrentDayNightMode(0);
            this.notifierDSI.setDayView();
        }
    }

    protected void addDayNightModeListener() {
        if (!this.isDayNightServiceRegistered) {
            ASLSystemFactory.getSystemApi().getDayNightService().addListener(new MapViewerKombiTargetHSM$1(this));
            this.isDayNightServiceRegistered = true;
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("no reset necessary");
        }
    }
}

