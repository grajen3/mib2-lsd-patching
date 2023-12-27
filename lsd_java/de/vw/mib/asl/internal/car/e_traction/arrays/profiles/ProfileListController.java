/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.profiles;

import de.vw.mib.asl.api.car.arrays.ArraySlider;
import de.vw.mib.asl.api.car.arrays.ArraySliderDelegate;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListArrayElementAdapter;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListContext;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListDsiAdapter;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListDsiListener;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListModelUpdater;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlProfileCollector;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

public class ProfileListController
extends ProfileListModelUpdater
implements ASGArrayListFactory,
ASGArrayListDelegate,
Logger,
ArraySliderDelegate {
    private ProfileListContext _context;
    private ASGArrayList _profileArrayList;
    private ProfileListDsiListener _profileListDsiListener;
    private ArraySlider profileListArraySlider;
    private static final int HIGH_LEVEL_RETRY_B_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_B_RETRY_TIME;
    private int MIN_NUMBER_TO_REQUEST = 4;
    public static int INDEX_NOT_FOUND;
    private static int UNKNOWN_PROVIDER_ID;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$car$e_traction$arrays$profiles$ProfileListArrayElementAdapter;

    public ProfileListController(ProfileListContext profileListContext) {
        super(profileListContext);
        this._context = profileListContext;
    }

    private ProfileListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    private ArraySlider getProfileListArraySlider() {
        if (this.profileListArraySlider == null) {
            this.profileListArraySlider = BapArrayFactory.getInstance().createArraySlider(this, 0);
            this.profileListArraySlider.setCorrespondingArrayList(this.getProfileListArrayList());
        }
        return this.profileListArraySlider;
    }

    private ASGArrayList getProfileListArrayList() {
        if (this._profileArrayList == null) {
            this._profileArrayList = new ArrayListFactory().createCompleteArrayList(this, this, this, 1, 0, true, 4, 0);
        }
        return this._profileArrayList;
    }

    public ProfileListDsiListener getProfileListDsiListener() {
        if (this._profileListDsiListener == null) {
            this._profileListDsiListener = new ProfileListDsiAdapter(this.getContext(), this.getProfileListArrayList());
        }
        return this._profileListDsiListener;
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        super.reloaded(aSGArrayList);
        if (!aSGArrayList.isLoading()) {
            this.getContext().profileListLoadedState(true);
        }
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapSetGetArray(class$de$vw$mib$asl$internal$car$e_traction$arrays$profiles$ProfileListArrayElementAdapter == null ? (class$de$vw$mib$asl$internal$car$e_traction$arrays$profiles$ProfileListArrayElementAdapter = ProfileListController.class$("de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListArrayElementAdapter")) : class$de$vw$mib$asl$internal$car$e_traction$arrays$profiles$ProfileListArrayElementAdapter);
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new ProfileListArrayElementAdapter();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        ProfileListArrayElementAdapter profileListArrayElementAdapter;
        ProfileListArrayElementAdapter profileListArrayElementAdapter2 = (ProfileListArrayElementAdapter)bAPArrayElement;
        ProfileListArrayElementAdapter profileListArrayElementAdapter3 = (ProfileListArrayElementAdapter)bAPArrayElement2;
        switch (n) {
            case 0: {
                profileListArrayElementAdapter = profileListArrayElementAdapter2;
                break;
            }
            case 1: {
                profileListArrayElementAdapter = profileListArrayElementAdapter3;
                profileListArrayElementAdapter.isAirConditioning = profileListArrayElementAdapter2.isAirConditioning;
                profileListArrayElementAdapter.isCharing = profileListArrayElementAdapter2.isCharing;
                profileListArrayElementAdapter.setClimateWithoutExternalSupply(profileListArrayElementAdapter2.isClimateWithoutExternalSupply());
                profileListArrayElementAdapter.maxCurrent = profileListArrayElementAdapter2.maxCurrent;
                profileListArrayElementAdapter.targetChargeLevel = profileListArrayElementAdapter2.targetChargeLevel;
                profileListArrayElementAdapter.autoDefrost = profileListArrayElementAdapter2.autoDefrost;
                profileListArrayElementAdapter.seatHeaterFrontLeft = profileListArrayElementAdapter2.seatHeaterFrontLeft;
                profileListArrayElementAdapter.seatHeaterFrontRight = profileListArrayElementAdapter2.seatHeaterFrontRight;
                profileListArrayElementAdapter.seatHeaterRearLeft = profileListArrayElementAdapter2.seatHeaterRearLeft;
                profileListArrayElementAdapter.seatHeaterRearRight = profileListArrayElementAdapter2.seatHeaterRearRight;
                if (profileListArrayElementAdapter.getPowerProviderId() != profileListArrayElementAdapter2.getPowerProviderId()) {
                    profileListArrayElementAdapter.setNewPowerProviderId(profileListArrayElementAdapter2.getPowerProviderId());
                }
                profileListArrayElementAdapter.profileName = profileListArrayElementAdapter2.profileName;
                break;
            }
            case 2: {
                profileListArrayElementAdapter = profileListArrayElementAdapter3;
                profileListArrayElementAdapter.isAirConditioning = profileListArrayElementAdapter2.isAirConditioning;
                profileListArrayElementAdapter.isCharing = profileListArrayElementAdapter2.isCharing;
                profileListArrayElementAdapter.setClimateWithoutExternalSupply(profileListArrayElementAdapter2.isClimateWithoutExternalSupply());
                profileListArrayElementAdapter.maxCurrent = profileListArrayElementAdapter2.maxCurrent;
                profileListArrayElementAdapter.targetChargeLevel = profileListArrayElementAdapter2.targetChargeLevel;
                profileListArrayElementAdapter.autoDefrost = profileListArrayElementAdapter2.autoDefrost;
                profileListArrayElementAdapter.seatHeaterFrontLeft = profileListArrayElementAdapter2.seatHeaterFrontLeft;
                profileListArrayElementAdapter.seatHeaterFrontRight = profileListArrayElementAdapter2.seatHeaterFrontRight;
                profileListArrayElementAdapter.seatHeaterRearLeft = profileListArrayElementAdapter2.seatHeaterRearLeft;
                profileListArrayElementAdapter.seatHeaterRearRight = profileListArrayElementAdapter2.seatHeaterRearRight;
                break;
            }
            case 3: {
                profileListArrayElementAdapter = profileListArrayElementAdapter3;
                profileListArrayElementAdapter.profileName = profileListArrayElementAdapter2.profileName;
                break;
            }
            case 4: {
                profileListArrayElementAdapter = profileListArrayElementAdapter3;
                profileListArrayElementAdapter.isAirConditioning = profileListArrayElementAdapter2.isAirConditioning;
                profileListArrayElementAdapter.isCharing = profileListArrayElementAdapter2.isCharing;
                profileListArrayElementAdapter.setClimateWithoutExternalSupply(profileListArrayElementAdapter2.isClimateWithoutExternalSupply());
                profileListArrayElementAdapter.maxCurrent = profileListArrayElementAdapter2.maxCurrent;
                profileListArrayElementAdapter.targetChargeLevel = profileListArrayElementAdapter2.targetChargeLevel;
                profileListArrayElementAdapter.temperatureValue = profileListArrayElementAdapter2.temperatureValue;
                profileListArrayElementAdapter.temperatureUnit = profileListArrayElementAdapter2.temperatureUnit;
                profileListArrayElementAdapter.leadTime = profileListArrayElementAdapter2.leadTime;
                profileListArrayElementAdapter.holdingTimePlug = profileListArrayElementAdapter2.holdingTimePlug;
                profileListArrayElementAdapter.minChargeLevel = profileListArrayElementAdapter2.minChargeLevel;
                profileListArrayElementAdapter.autoDefrost = profileListArrayElementAdapter2.autoDefrost;
                profileListArrayElementAdapter.seatHeaterFrontLeft = profileListArrayElementAdapter2.seatHeaterFrontLeft;
                profileListArrayElementAdapter.seatHeaterFrontRight = profileListArrayElementAdapter2.seatHeaterFrontRight;
                profileListArrayElementAdapter.seatHeaterRearLeft = profileListArrayElementAdapter2.seatHeaterRearLeft;
                profileListArrayElementAdapter.seatHeaterRearRight = profileListArrayElementAdapter2.seatHeaterRearRight;
                break;
            }
            case 5: {
                profileListArrayElementAdapter = profileListArrayElementAdapter3;
                profileListArrayElementAdapter.isAirConditioning = profileListArrayElementAdapter2.isAirConditioning;
                profileListArrayElementAdapter.isCharing = profileListArrayElementAdapter2.isCharing;
                profileListArrayElementAdapter.setClimateWithoutExternalSupply(profileListArrayElementAdapter2.isClimateWithoutExternalSupply());
                profileListArrayElementAdapter.isWindowHeating = profileListArrayElementAdapter2.isWindowHeating;
                profileListArrayElementAdapter.setParkHeater(profileListArrayElementAdapter2.isParkHeater());
                profileListArrayElementAdapter.maxCurrent = profileListArrayElementAdapter2.maxCurrent;
                profileListArrayElementAdapter.targetChargeLevel = profileListArrayElementAdapter2.targetChargeLevel;
                profileListArrayElementAdapter.autoDefrost = profileListArrayElementAdapter2.autoDefrost;
                profileListArrayElementAdapter.seatHeaterFrontLeft = profileListArrayElementAdapter2.seatHeaterFrontLeft;
                profileListArrayElementAdapter.seatHeaterFrontRight = profileListArrayElementAdapter2.seatHeaterFrontRight;
                profileListArrayElementAdapter.seatHeaterRearLeft = profileListArrayElementAdapter2.seatHeaterRearLeft;
                profileListArrayElementAdapter.seatHeaterRearRight = profileListArrayElementAdapter2.seatHeaterRearRight;
                profileListArrayElementAdapter.windowHeaterRear = profileListArrayElementAdapter2.windowHeaterRear;
                profileListArrayElementAdapter.parkHeaterAutomatic = profileListArrayElementAdapter2.parkHeaterAutomatic;
                if (profileListArrayElementAdapter.getPowerProviderId() != profileListArrayElementAdapter2.getPowerProviderId()) {
                    profileListArrayElementAdapter.setNewPowerProviderId(profileListArrayElementAdapter2.getPowerProviderId());
                }
                profileListArrayElementAdapter.profileName = profileListArrayElementAdapter2.profileName;
                break;
            }
            case 6: {
                profileListArrayElementAdapter = profileListArrayElementAdapter3;
                profileListArrayElementAdapter.isAirConditioning = profileListArrayElementAdapter2.isAirConditioning;
                profileListArrayElementAdapter.isCharing = profileListArrayElementAdapter2.isCharing;
                profileListArrayElementAdapter.setClimateWithoutExternalSupply(profileListArrayElementAdapter2.isClimateWithoutExternalSupply());
                profileListArrayElementAdapter.isWindowHeating = profileListArrayElementAdapter2.isWindowHeating;
                profileListArrayElementAdapter.setParkHeater(profileListArrayElementAdapter2.isParkHeater());
                profileListArrayElementAdapter.maxCurrent = profileListArrayElementAdapter2.maxCurrent;
                profileListArrayElementAdapter.targetChargeLevel = profileListArrayElementAdapter2.targetChargeLevel;
                profileListArrayElementAdapter.autoDefrost = profileListArrayElementAdapter2.autoDefrost;
                profileListArrayElementAdapter.seatHeaterFrontLeft = profileListArrayElementAdapter2.seatHeaterFrontLeft;
                profileListArrayElementAdapter.seatHeaterFrontRight = profileListArrayElementAdapter2.seatHeaterFrontRight;
                profileListArrayElementAdapter.seatHeaterRearLeft = profileListArrayElementAdapter2.seatHeaterRearLeft;
                profileListArrayElementAdapter.seatHeaterRearRight = profileListArrayElementAdapter2.seatHeaterRearRight;
                profileListArrayElementAdapter.windowHeaterRear = profileListArrayElementAdapter2.windowHeaterRear;
                profileListArrayElementAdapter.parkHeaterAutomatic = profileListArrayElementAdapter2.parkHeaterAutomatic;
                break;
            }
            case 7: {
                profileListArrayElementAdapter = profileListArrayElementAdapter3;
                profileListArrayElementAdapter.isAirConditioning = profileListArrayElementAdapter2.isAirConditioning;
                profileListArrayElementAdapter.isCharing = profileListArrayElementAdapter2.isCharing;
                profileListArrayElementAdapter.setClimateWithoutExternalSupply(profileListArrayElementAdapter2.isClimateWithoutExternalSupply());
                profileListArrayElementAdapter.isWindowHeating = profileListArrayElementAdapter2.isWindowHeating;
                profileListArrayElementAdapter.setParkHeater(profileListArrayElementAdapter2.isParkHeater());
                profileListArrayElementAdapter.maxCurrent = profileListArrayElementAdapter2.maxCurrent;
                profileListArrayElementAdapter.targetChargeLevel = profileListArrayElementAdapter2.targetChargeLevel;
                profileListArrayElementAdapter.temperatureValue = profileListArrayElementAdapter2.temperatureValue;
                profileListArrayElementAdapter.temperatureUnit = profileListArrayElementAdapter2.temperatureUnit;
                profileListArrayElementAdapter.leadTime = profileListArrayElementAdapter2.leadTime;
                profileListArrayElementAdapter.holdingTimePlug = profileListArrayElementAdapter2.holdingTimePlug;
                profileListArrayElementAdapter.holdingTimeBattery = profileListArrayElementAdapter2.holdingTimeBattery;
                profileListArrayElementAdapter.minChargeLevel = profileListArrayElementAdapter2.minChargeLevel;
                profileListArrayElementAdapter.autoDefrost = profileListArrayElementAdapter2.autoDefrost;
                profileListArrayElementAdapter.seatHeaterFrontLeft = profileListArrayElementAdapter2.seatHeaterFrontLeft;
                profileListArrayElementAdapter.seatHeaterFrontRight = profileListArrayElementAdapter2.seatHeaterFrontRight;
                profileListArrayElementAdapter.seatHeaterRearLeft = profileListArrayElementAdapter2.seatHeaterRearLeft;
                profileListArrayElementAdapter.seatHeaterRearRight = profileListArrayElementAdapter2.seatHeaterRearRight;
                profileListArrayElementAdapter.windowHeaterRear = profileListArrayElementAdapter2.windowHeaterRear;
                profileListArrayElementAdapter.parkHeaterAutomatic = profileListArrayElementAdapter2.parkHeaterAutomatic;
                break;
            }
            default: {
                profileListArrayElementAdapter = profileListArrayElementAdapter2;
                this.getContextLoger().error("ProfileList: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return profileListArrayElementAdapter;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return BapArrayFactory.getInstance().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPGetArray);
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        BatteryControlProfilesAH batteryControlProfilesAH = new BatteryControlProfilesAH(n, arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPGetArray.getTransactionId(), bAPGetArray.getAsgId());
        this.getContext().getCarHybrid().requestBatteryControlProfileList(batteryControlProfilesAH);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPSetGetArray);
        ArrayHeader arrayHeader = bAPSetGetArray.getArrayHeader();
        BatteryControlProfilesAH batteryControlProfilesAH = new BatteryControlProfilesAH(n, arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPSetGetArray.getTransactionId(), bAPSetGetArray.getAsgId());
        if (bAPSetGetArray.getArrayHeader().isSetGetInsertRequest()) {
            batteryControlProfilesAH.startElement = -1;
        }
        switch (bAPSetGetArray.getArrayHeader().getRecordAddress()) {
            case 3: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                BatteryControlProfileRA3[] batteryControlProfileRA3Array = new BatteryControlProfileRA3[bAPArrayElementArray.length];
                int n2 = bAPArrayElementArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    ProfileListArrayElementAdapter profileListArrayElementAdapter = (ProfileListArrayElementAdapter)bAPArrayElementArray[i2];
                    batteryControlProfileRA3Array[i2] = profileListArrayElementAdapter.toProfileListRA3();
                }
                this.getContext().getCarHybrid().setBatteryControlProfileListRA3(batteryControlProfilesAH, batteryControlProfileRA3Array);
                break;
            }
            case 5: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                BatteryControlProfileRA5[] batteryControlProfileRA5Array = new BatteryControlProfileRA5[bAPArrayElementArray.length];
                int n3 = bAPArrayElementArray.length;
                for (int i3 = 0; i3 < n3; ++i3) {
                    ProfileListArrayElementAdapter profileListArrayElementAdapter = (ProfileListArrayElementAdapter)bAPArrayElementArray[i3];
                    batteryControlProfileRA5Array[i3] = profileListArrayElementAdapter.toProfileListRA5();
                }
                this.getContext().getCarHybrid().setBatteryControlProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
                break;
            }
            case 0: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                BatteryControlProfileRA0[] batteryControlProfileRA0Array = new BatteryControlProfileRA0[bAPArrayElementArray.length];
                int n4 = bAPArrayElementArray.length;
                for (int i4 = 0; i4 < n4; ++i4) {
                    ProfileListArrayElementAdapter profileListArrayElementAdapter = (ProfileListArrayElementAdapter)bAPArrayElementArray[i4];
                    batteryControlProfileRA0Array[i4] = profileListArrayElementAdapter.toProfileListRA0();
                }
                this.getContext().getCarHybrid().setBatteryControlProfileListRA0(batteryControlProfilesAH, batteryControlProfileRA0Array);
                break;
            }
        }
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getContextLoger().error("ProfileList: Request time out for ProfileList Request");
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = this.MIN_NUMBER_TO_REQUEST;
                break;
            }
            default: {
                n2 = this.MIN_NUMBER_TO_REQUEST + 1;
            }
        }
        return n2;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append("ProfileList: ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContextLoger().fatal(string2);
                break;
            }
            case 2: {
                this.getContextLoger().error(string2);
                break;
            }
            case 4: {
                this.getContextLoger().warn(string2);
                break;
            }
            case 8: {
                this.getContextLoger().info(string2);
                break;
            }
            case 12: {
                this.getContextLoger().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContextLoger().isTraceEnabled()) break;
                this.getContextLoger().trace(string2);
                break;
            }
            default: {
                this.getContextLoger().error("ProfileList: Unknown log message called");
            }
        }
    }

    private int getIndexOfProfile(int n) {
        int n2 = INDEX_NOT_FOUND;
        int n3 = this.getProfileListArrayList().size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BAPArrayElement bAPArrayElement = this.getProfileListArrayList().get(i2);
            if (bAPArrayElement.getPos() != n) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public int getIndexOfProfileInModelProfileList(int n) {
        int n2 = this.getIndexOfProfile(n);
        if (this.getIndexOfProfile(0) != INDEX_NOT_FOUND && n2 != INDEX_NOT_FOUND) {
            --n2;
        }
        return n2;
    }

    private int getProfileIndexViaModelProfileListIndex(int n) {
        int n2;
        int n3 = n2 = this.getIndexOfProfile(0) != INDEX_NOT_FOUND ? n + 1 : n;
        if (n2 <= 0 || n2 >= this.getProfileListArrayList().size()) {
            n2 = INDEX_NOT_FOUND;
        }
        return n2;
    }

    public BatteryControlProfileCollector getProfileViaModelProfileListIndex(int n) {
        int n2 = this.getProfileIndexViaModelProfileListIndex(n);
        BatteryControlProfileCollector batteryControlProfileCollector = n2 != INDEX_NOT_FOUND ? this.getProfileListElement(n2) : null;
        return batteryControlProfileCollector;
    }

    public BatteryControlProfileCollector getProfileListElement(int n) {
        return (BatteryControlProfileCollector)((Object)this.getProfileListArrayList().get(n));
    }

    public BatteryControlProfileCollector getProfileListElementByProfile(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = null;
        int n2 = this.getIndexOfProfile(n);
        if (n2 != INDEX_NOT_FOUND) {
            batteryControlProfileCollector = this.getProfileListElement(n2);
        }
        return batteryControlProfileCollector;
    }

    public int getProfileListSize() {
        return this.getProfileListArrayList().size();
    }

    public BatteryControlProfileCollector getGlobalProfile() {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListElementByProfile(0);
        if (batteryControlProfileCollector == null) {
            batteryControlProfileCollector = new BatteryControlProfileCollector();
        } else {
            batteryControlProfileCollector = batteryControlProfileCollector.copyCollector();
            batteryControlProfileCollector.temperatureValue = this.getTemperatureValue();
            batteryControlProfileCollector.minChargeLevel = this.getMinSOC();
        }
        return batteryControlProfileCollector;
    }

    public boolean toggleParkHeaterInGlobalProfile() {
        BatteryControlProfileCollector batteryControlProfileCollector;
        batteryControlProfileCollector.setParkHeater(!(batteryControlProfileCollector = this.getGlobalProfile()).isParkHeater());
        return this.modifyProfileAttributes(batteryControlProfileCollector, 0);
    }

    public boolean deleteProfile(int n) {
        boolean bl;
        int n2 = this.getProfileIndexViaModelProfileListIndex(n);
        if (n2 != INDEX_NOT_FOUND) {
            if (n != 0) {
                this.getProfileListArrayList().deleteArrayElements(this.getProfileListArrayList().getElements(n2, 1), 3);
                bl = true;
            } else {
                bl = false;
            }
        } else {
            bl = false;
        }
        return bl;
    }

    public void insertProfile(String string) {
        ProfileListArrayElementAdapter profileListArrayElementAdapter = new ProfileListArrayElementAdapter();
        profileListArrayElementAdapter.profileName = string;
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        bAPArrayData.add(profileListArrayElementAdapter);
        this.getProfileListArrayList().insertArrayElements(bAPArrayData, 3, 0);
    }

    public boolean renameProfile(int n, String string) {
        boolean bl;
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileViaModelProfileListIndex(n);
        if (batteryControlProfileCollector != null) {
            batteryControlProfileCollector.profileName = string;
            bl = this.modifyProfileAttributes(batteryControlProfileCollector, 3);
        } else {
            bl = false;
        }
        return bl;
    }

    public boolean assignNewPowerProviderToProfile(BatteryControlProfileCollector batteryControlProfileCollector) {
        ProfileListArrayElementAdapter profileListArrayElementAdapter = (ProfileListArrayElementAdapter)batteryControlProfileCollector;
        profileListArrayElementAdapter.setNewPowerProviderId(batteryControlProfileCollector.posId);
        return this.modifyProfileAttributes(profileListArrayElementAdapter, 5);
    }

    public boolean modifyProfileAttributes(BatteryControlProfileCollector batteryControlProfileCollector, int n) {
        boolean bl;
        int n2 = this.getIndexOfProfile(batteryControlProfileCollector.posId);
        if (n2 != INDEX_NOT_FOUND) {
            ProfileListArrayElementAdapter profileListArrayElementAdapter = (ProfileListArrayElementAdapter)batteryControlProfileCollector;
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(101) && !profileListArrayElementAdapter.isNightRate()) {
                profileListArrayElementAdapter.setNewPowerProviderId(UNKNOWN_PROVIDER_ID);
            }
            this.getProfileListArrayList().modifyArrayElement(profileListArrayElementAdapter, n);
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    public void reloadData() {
        this.getContext().profileListLoadedState(false);
        this.getProfileListArrayList().reloadData();
    }

    public void stopLoadingData() {
        this.getProfileListArrayList().stopFetchingData();
    }

    public void updateListToModel() {
        super.updateProfileList(this.getProfileListArrayList());
    }

    public void updateListElementToModel(BatteryControlProfileCollector batteryControlProfileCollector, int n) {
        ListManager.getGenericASLList(10374).updateListItem(n, batteryControlProfileCollector);
    }

    public void modifyProfileSliderAttributes(BatteryControlProfileCollector batteryControlProfileCollector) {
        this.getProfileListArraySlider().requestNewValue(batteryControlProfileCollector);
    }

    @Override
    protected void profileListUpdated(BatteryControlProfileCollector batteryControlProfileCollector) {
        if (batteryControlProfileCollector != null) {
            this.getProfileListArraySlider().receivedNewValue(batteryControlProfileCollector);
        } else {
            this.getContext().profileListUpdated();
        }
    }

    @Override
    public void fakeValue(ArraySlider arraySlider, Object object) {
        BatteryControlProfileCollector batteryControlProfileCollector = (BatteryControlProfileCollector)object;
        if (batteryControlProfileCollector.posId == 0) {
            this.updateModelWithGlobalProfile(batteryControlProfileCollector);
        } else {
            this.getContextLoger().error("ProfileList Array slider: So far only global profile slider values are supported");
        }
    }

    @Override
    public void updateValue(ArraySlider arraySlider, Object object) {
        BatteryControlProfileCollector batteryControlProfileCollector = (BatteryControlProfileCollector)object;
        if (batteryControlProfileCollector.posId == 0) {
            this.updateModelWithGlobalProfile(batteryControlProfileCollector);
            this.getContext().profileListUpdated();
        } else {
            this.getContextLoger().error("ProfileList Array slider: So far only global profile slider values are supported");
        }
    }

    @Override
    public void sendNewValue(ArraySlider arraySlider, Object object) {
        BatteryControlProfileCollector batteryControlProfileCollector = (BatteryControlProfileCollector)object;
        this.modifyProfileAttributes(batteryControlProfileCollector, 0);
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
        INDEX_NOT_FOUND = -1;
        UNKNOWN_PROVIDER_ID = 0;
    }
}

