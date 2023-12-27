/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.api.testmode.ASLTestmodeFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.impl.testmode.TestModeServicesProvider;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.testmode.HsmTestmode;
import de.vw.mib.asl.internal.testmode.TargetETM$1;
import de.vw.mib.asl.internal.testmode.ValetParkingTestmodeServiceImpl;
import de.vw.mib.asl.internal.testmode.helper.trace.LogRoot;
import de.vw.mib.asl.internal.testmode.helper.trace.debugprobe.DebugProbeRoot;
import de.vw.mib.asl.internal.testmode.model.ProfileModel;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeGenericNameValueCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class TargetETM
extends AbstractASLTarget {
    public static TargetETM instance = null;
    private LogRoot mTraceRootInfo = null;
    private int mSelectedSubClassifierIndex = -1;
    private DebugProbeRoot mDebugProbeInfo = null;
    private boolean mSwdlRegionStatus;
    private boolean mSwdlManualStatus;
    private final ProfileModel profileModel = this.createProfileModel();
    private final ValetParkingTestmodeServiceImpl valetParkingService;
    private static final int[] OBSERVER = new int[]{201719872, 1115101952, -335216576, 50724928, 33947712, 0x4060040, 168165440, 184942656, 218497088, 84279360, 503709760, 486932544, -980344512, -963567296};

    public TargetETM(HsmTestmode hsmTestmode) {
        super(hsmTestmode.getMainObject(), -237955840);
        this.setupGlobalProfileChangeListener();
        this.initValetParkingDatapool();
        this.valetParkingService = (ValetParkingTestmodeServiceImpl)ASLTestmodeFactory.getTestmodeApi().getTestmodeValetParkingService();
    }

    @Override
    public int getSubClassifier() {
        return 64;
    }

    public static void enableTarget(HsmTestmode hsmTestmode) {
        if (instance == null) {
            try {
                instance = new TargetETM(hsmTestmode);
            }
            catch (Exception exception) {
                hsmTestmode.error(exception);
            }
            instance.registerTarget();
            instance.writeFeatureFlagList();
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.addObservers(OBSERVER);
                break;
            }
            case 9: {
                this.removeObservers(OBSERVER);
                break;
            }
            case 1073743340: {
                int n = eventGeneric.getInt(0);
                if (n == 53) {
                    this.initTraceCategories();
                    this.initDebugProbeList();
                    break;
                }
                if (n != 48) break;
                this.updateProfileList();
                break;
            }
            case 1073743363: {
                this.mTraceRootInfo.toggleTcpSinkState();
                TargetETM.writeBooleanToDatapool(2201, this.mTraceRootInfo.getTcpSinkState());
                break;
            }
            case 1073743362: {
                this.mTraceRootInfo.toggleFileSinkState();
                TargetETM.writeBooleanToDatapool(2200, this.mTraceRootInfo.getFileSinkState());
                break;
            }
            case 0x40000604: {
                this.mTraceRootInfo.toggleSerialSinkState();
                TargetETM.writeBooleanToDatapool(2202, this.mTraceRootInfo.getSerialSinkState());
                break;
            }
            case 1073743365: {
                this.mTraceRootInfo.toggleMainLoggingState();
                TargetETM.writeBooleanToDatapool(2203, this.mTraceRootInfo.getMainLoggingState());
                break;
            }
            case 1073743370: {
                this.mSelectedSubClassifierIndex = eventGeneric.getInt(0);
                Object[] objectArray = this.mTraceRootInfo.getClassifierInfoArray()[this.mSelectedSubClassifierIndex].getSubClassifierInfoArray();
                ListManager.getGenericASLList(2281).updateList(objectArray);
                break;
            }
            case 1073743371: {
                ListManager.getGenericASLList(2280).updateList(this.mTraceRootInfo.getClassifierInfoArray());
                break;
            }
            case 1073743373: {
                Object[] objectArray = this.mTraceRootInfo.getClassifierInfoArray()[this.mSelectedSubClassifierIndex].getSubClassifierInfoArray();
                objectArray[eventGeneric.getInt(0)].toggleState(this.mTraceRootInfo);
                ListManager.getGenericASLList(2281).updateList(objectArray);
                break;
            }
            case 1073743390: {
                this.mSwdlRegionStatus = !this.mSwdlRegionStatus;
                TargetETM.writeBooleanToDatapool(2223, this.mSwdlRegionStatus);
                break;
            }
            case 1073743389: {
                this.mSwdlManualStatus = !this.mSwdlManualStatus;
                TargetETM.writeBooleanToDatapool(2222, this.mSwdlManualStatus);
                break;
            }
            case 1073743372: {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric2.setInt(0, this.mDebugProbeInfo.getDebugProbeNrByIndex(eventGeneric.getInt(0)));
                this.triggerObserver(1115101952, eventGeneric2);
                break;
            }
            case 1800002: {
                int n = eventGeneric.getInt(0);
                if (this.mDebugProbeInfo == null) {
                    this.mDebugProbeInfo = new DebugProbeRoot();
                }
                this.mDebugProbeInfo.setSelectedDebugProbe(n);
                ListManager.getGenericASLList(2282).updateList(this.mDebugProbeInfo.getDebugRootArray());
                TargetETM.writeBooleanToDatapool(2204, this.mDebugProbeInfo.getMainLoggingState());
                if (n != -3 || this.mSelectedSubClassifierIndex == -1) break;
                Object[] objectArray = this.mTraceRootInfo.getClassifierInfoArray()[this.mSelectedSubClassifierIndex].getSubClassifierInfoArray();
                ListManager.getGenericASLList(2281).updateList(objectArray);
                break;
            }
            case 1075941829: {
                int n = eventGeneric.getInt(0);
                this.activateProfile(n);
                break;
            }
            case 1075941830: {
                this.onToggleValetParkingState();
                break;
            }
        }
    }

    void updateProfileList() {
        int n = ServiceManager.persistence.getActiveProfile() - 1;
        this.profileModel.activateProfile(n);
        ASLListManager aSLListManager = TestModeServicesProvider.getTestModeServices().getAslListManager();
        aSLListManager.getGenericASLList(-608689920).updateList(this.profileModel.getProfiles());
    }

    private void initValetParkingDatapool() {
        TargetETM.writeBooleanToDatapool(-591912704, false);
    }

    private void onToggleValetParkingState() {
        this.valetParkingService.onValetParkingChanged();
        TargetETM.writeBooleanToDatapool(-591912704, this.valetParkingService.isValetParkingActive());
    }

    private void setupGlobalProfileChangeListener() {
        ServiceManager.persistence.addGlobalProfileChangeListener(new TargetETM$1(this));
    }

    private void activateProfile(int n) {
        try {
            ServiceManager.persistence.activateProfile((byte)(n + 1));
            this.profileModel.activateProfile(n);
        }
        catch (IllegalStateException illegalStateException) {
            this.error().append("Could not change profile").append(illegalStateException);
        }
        this.updateProfileList();
    }

    private ProfileModel createProfileModel() {
        int n = 0;
        int n2 = 7;
        String[] stringArray = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            String string;
            stringArray[i2] = string = new StringBuffer().append("Profile ").append(i2 + 1).toString();
        }
        ProfileModel profileModel = new ProfileModel(stringArray, n);
        return profileModel;
    }

    private void writeFeatureFlagList() {
        int n;
        String[] stringArray = ServiceManager.configManagerDiag.getAllFeatureFlagNames();
        String[] stringArray2 = ServiceManager.configManagerDiag.getAllFeatureFlagValuesAsString();
        int n2 = stringArray.length;
        Object[] objectArray = new TestmodeGenericNameValueCollector[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = new TestmodeGenericNameValueCollector(stringArray[i2], stringArray2[i2]);
        }
        String[][] stringArray3 = ServiceManager.configManagerDiag.getAllConstNames();
        String[][] stringArray4 = ServiceManager.configManagerDiag.getAllConstValuesAsStrings();
        int n3 = 0;
        int n4 = 0;
        for (int i3 = 0; i3 < stringArray3.length; ++i3) {
            for (n = 0; n < stringArray3[i3].length; ++n) {
                ++n3;
            }
        }
        Object[] objectArray2 = new TestmodeGenericNameValueCollector[n3];
        for (n = 0; n < stringArray3.length; ++n) {
            for (int i4 = 0; i4 < stringArray3[n].length; ++i4) {
                objectArray2[n4] = new TestmodeGenericNameValueCollector(stringArray3[n][i4], stringArray4[n][i4]);
                ++n4;
            }
        }
        ListManager.getGenericASLList(3935).updateList(objectArray);
        ListManager.getGenericASLList(3936).updateList(objectArray2);
    }

    private void registerTarget() {
        try {
            this.register(this.getMainObject(), this.getTargetId(), this.getEventDispatcher().getRandomTaskId());
        }
        catch (Exception exception) {
            this.error().append("TargetETM could not be registered").append(exception).log();
        }
        if (this.isTraceEnabled()) {
            this.trace("TargetETM registered: ", this.getTargetId());
        }
    }

    private void initTraceCategories() {
        if (this.mTraceRootInfo == null) {
            this.mTraceRootInfo = new LogRoot();
        }
        TargetETM.writeBooleanToDatapool(2201, this.mTraceRootInfo.getTcpSinkState());
        TargetETM.writeBooleanToDatapool(2200, this.mTraceRootInfo.getFileSinkState());
        TargetETM.writeBooleanToDatapool(2202, this.mTraceRootInfo.getSerialSinkState());
        TargetETM.writeBooleanToDatapool(2203, this.mTraceRootInfo.getMainLoggingState());
        ListManager.getGenericASLList(2280).updateList(this.mTraceRootInfo.getClassifierInfoArray());
    }

    private void initDebugProbeList() {
        if (this.mDebugProbeInfo == null) {
            this.mDebugProbeInfo = new DebugProbeRoot();
        }
        TargetETM.writeBooleanToDatapool(2204, this.mDebugProbeInfo.getMainLoggingState());
        ListManager.getGenericASLList(2282).updateList(this.mDebugProbeInfo.getDebugRootArray());
    }
}

