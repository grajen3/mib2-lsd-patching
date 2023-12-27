/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.profiles;

import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlProfileCollector;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;

class ProfileListArrayElementAdapter
extends BatteryControlProfileCollector
implements BAPArrayElement {
    private ArrayHeader _arrayHeader;
    private static final boolean PROFILE_LIST__PROFILE_LIST__IS_WINDOW_HEATING_DEFAULT_VALUE;
    private static final int PROFILE_LIST__PROFILE_LIST__POWER_PROVIDER_DEFAULT_VALUE;
    private static final int PROFILE_LIST__PROFILE_LIST__TARGET_CHARGE_LEVEL_DEFAULT_VALUE;

    static boolean evaluteNightRate(int n) {
        return n != 0;
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, int n, int n2, int n3, int n4, int n5, String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, boolean bl5, boolean bl6, int n8, int n9, int n10, int n11, boolean bl7, int n12, int n13, int n14, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14) {
        super(n, n2, n3, n4, n5, string, bl, bl2, bl3, bl4, n6, n7, bl5, bl6, n8, n9, n10, n11, bl7, n12, n13, n14, bl8, bl9, bl10, bl11, bl12, bl13, bl14);
        this._arrayHeader = arrayHeader;
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    public ProfileListArrayElementAdapter() {
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA0 batteryControlProfileRA0) {
        this(arrayHeader, batteryControlProfileRA0.pos, batteryControlProfileRA0.temperature, batteryControlProfileRA0.temperatureUnit, batteryControlProfileRA0.maxCurrent, ASLCarUtil.rounding(batteryControlProfileRA0.getTargetChargeLevel()), batteryControlProfileRA0.name, batteryControlProfileRA0.getProfileOperation().isClimate(), batteryControlProfileRA0.getProfileOperation().isCharge(), false, false, batteryControlProfileRA0.getProviderDataId(), batteryControlProfileRA0.getMinChargeLevel(), batteryControlProfileRA0.getProfileOperation().isClimateWithoutExternalSupply(), false, batteryControlProfileRA0.minRange, batteryControlProfileRA0.targetChargeDuration, batteryControlProfileRA0.targetChargeRange, batteryControlProfileRA0.unitRange, batteryControlProfileRA0.rangeCalculationSetup, batteryControlProfileRA0.leadTime, batteryControlProfileRA0.holdingTimePlug, batteryControlProfileRA0.holdingTimeBattery, batteryControlProfileRA0.profileOperation.autoDefrost, batteryControlProfileRA0.profileOperation.seatHeaterFrontLeft, batteryControlProfileRA0.profileOperation.seatHeaterFrontRight, batteryControlProfileRA0.profileOperation.seatHeaterRearLeft, batteryControlProfileRA0.profileOperation.seatHeaterRearRight, batteryControlProfileRA0.profileOperation2.windowHeaterRear, batteryControlProfileRA0.profileOperation2.parkHeaterAutomatic);
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA1 batteryControlProfileRA1) {
        this(arrayHeader, batteryControlProfileRA1.pos, 0, 0, batteryControlProfileRA1.maxCurrent, ASLCarUtil.rounding(batteryControlProfileRA1.getTargetChargeLevel()), batteryControlProfileRA1.name, batteryControlProfileRA1.getProfileOperation().isClimate(), batteryControlProfileRA1.getProfileOperation().isCharge(), false, false, batteryControlProfileRA1.providerDataId, 0, batteryControlProfileRA1.getProfileOperation().isClimateWithoutExternalSupply(), false, 0, 0, 0, 0, false, 0, 0, 0, batteryControlProfileRA1.profileOperation.autoDefrost, batteryControlProfileRA1.profileOperation.seatHeaterFrontLeft, batteryControlProfileRA1.profileOperation.seatHeaterFrontRight, batteryControlProfileRA1.profileOperation.seatHeaterRearLeft, batteryControlProfileRA1.profileOperation.seatHeaterRearRight, false, false);
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA2 batteryControlProfileRA2) {
        this(arrayHeader, batteryControlProfileRA2.pos, 0, 0, batteryControlProfileRA2.maxCurrent, ASLCarUtil.rounding(batteryControlProfileRA2.getTargetChargeLevel()), "", batteryControlProfileRA2.getProfileOperation().isClimate(), batteryControlProfileRA2.getProfileOperation().isCharge(), false, false, 0, 0, batteryControlProfileRA2.getProfileOperation().isClimateWithoutExternalSupply(), false, 0, 0, 0, 0, false, 0, 0, 0, batteryControlProfileRA2.profileOperation.autoDefrost, batteryControlProfileRA2.profileOperation.seatHeaterFrontLeft, batteryControlProfileRA2.profileOperation.seatHeaterFrontRight, batteryControlProfileRA2.profileOperation.seatHeaterRearLeft, batteryControlProfileRA2.profileOperation.seatHeaterRearRight, false, false);
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA3 batteryControlProfileRA3) {
        this(arrayHeader, batteryControlProfileRA3.pos, 0, 0, 1, 0, batteryControlProfileRA3.name, false, false, false, false, 0, 0, false, false, 0, 0, 0, 0, false, 0, 0, 0, false, false, false, false, false, false, false);
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA4 batteryControlProfileRA4) {
        this(arrayHeader, batteryControlProfileRA4.pos, batteryControlProfileRA4.temperature, batteryControlProfileRA4.temperatureUnit, batteryControlProfileRA4.maxCurrent, 0, "", batteryControlProfileRA4.getProfileOperation().isClimate(), batteryControlProfileRA4.getProfileOperation().isCharge(), false, false, 0, batteryControlProfileRA4.getMinChargeLevel(), batteryControlProfileRA4.getProfileOperation().isClimateWithoutExternalSupply(), false, 0, 0, 0, 0, false, batteryControlProfileRA4.leadTime, batteryControlProfileRA4.holdingTimePlug, 0, batteryControlProfileRA4.profileOperation.autoDefrost, batteryControlProfileRA4.profileOperation.seatHeaterFrontLeft, batteryControlProfileRA4.profileOperation.seatHeaterFrontRight, batteryControlProfileRA4.profileOperation.seatHeaterRearLeft, batteryControlProfileRA4.profileOperation.seatHeaterRearRight, false, false);
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA5 batteryControlProfileRA5) {
        this(arrayHeader, batteryControlProfileRA5.pos, 0, 0, batteryControlProfileRA5.maxCurrent, ASLCarUtil.rounding(batteryControlProfileRA5.getTargetChargeLevel()), batteryControlProfileRA5.name, batteryControlProfileRA5.getProfileOperation().isClimate(), batteryControlProfileRA5.getProfileOperation().isCharge(), false, false, batteryControlProfileRA5.getProviderDataId(), 0, batteryControlProfileRA5.getProfileOperation().isClimateWithoutExternalSupply(), false, 0, 0, 0, 0, false, 0, 0, 0, batteryControlProfileRA5.profileOperation.autoDefrost, batteryControlProfileRA5.profileOperation.seatHeaterFrontLeft, batteryControlProfileRA5.profileOperation.seatHeaterFrontRight, batteryControlProfileRA5.profileOperation.seatHeaterRearLeft, batteryControlProfileRA5.profileOperation.seatHeaterRearRight, batteryControlProfileRA5.profileOperation2.windowHeaterRear, batteryControlProfileRA5.profileOperation2.parkHeaterAutomatic);
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA6 batteryControlProfileRA6) {
        this(arrayHeader, batteryControlProfileRA6.pos, 0, 0, batteryControlProfileRA6.maxCurrent, ASLCarUtil.rounding(batteryControlProfileRA6.getTargetChargeLevel()), "", batteryControlProfileRA6.getProfileOperation().isClimate(), batteryControlProfileRA6.getProfileOperation().isCharge(), false, false, 0, 0, batteryControlProfileRA6.getProfileOperation().isClimateWithoutExternalSupply(), false, 0, 0, 0, 0, false, 0, 0, 0, batteryControlProfileRA6.profileOperation.autoDefrost, batteryControlProfileRA6.profileOperation.seatHeaterFrontLeft, batteryControlProfileRA6.profileOperation.seatHeaterFrontRight, batteryControlProfileRA6.profileOperation.seatHeaterRearLeft, batteryControlProfileRA6.profileOperation.seatHeaterRearRight, batteryControlProfileRA6.profileOperation2.windowHeaterRear, batteryControlProfileRA6.profileOperation2.parkHeaterAutomatic);
    }

    public ProfileListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlProfileRA7 batteryControlProfileRA7) {
        this(arrayHeader, batteryControlProfileRA7.pos, batteryControlProfileRA7.temperature, batteryControlProfileRA7.temperatureUnit, batteryControlProfileRA7.maxCurrent, 0, "", batteryControlProfileRA7.getProfileOperation().isClimate(), batteryControlProfileRA7.getProfileOperation().isCharge(), false, false, 0, batteryControlProfileRA7.getMinChargeLevel(), batteryControlProfileRA7.getProfileOperation().isClimateWithoutExternalSupply(), false, 0, 0, 0, 0, false, batteryControlProfileRA7.leadTime, batteryControlProfileRA7.holdingTimePlug, batteryControlProfileRA7.holdingTimeBattery, batteryControlProfileRA7.profileOperation.autoDefrost, batteryControlProfileRA7.profileOperation.seatHeaterFrontLeft, batteryControlProfileRA7.profileOperation.seatHeaterFrontRight, batteryControlProfileRA7.profileOperation.seatHeaterRearLeft, batteryControlProfileRA7.profileOperation.seatHeaterRearRight, batteryControlProfileRA7.profileOperation2.windowHeaterRear, batteryControlProfileRA7.profileOperation2.parkHeaterAutomatic);
    }

    @Override
    protected BatteryControlProfileCollector copyCollector(int n, int n2, int n3, int n4, int n5, String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, boolean bl5, boolean bl6, int n8, int n9, int n10, int n11, boolean bl7, int n12, int n13, int n14, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14) {
        return new ProfileListArrayElementAdapter(this.getArrayHeader(), n, n2, n3, n4, n5, string, bl, bl2, bl3, bl4, n6, n7, bl5, bl6, n8, n9, n10, n11, bl7, n12, n13, n14, bl8, bl9, bl10, bl11, bl12, bl13, bl14);
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ProfileListArrayElementAdapter profileListArrayElementAdapter = (ProfileListArrayElementAdapter)bAPEntity;
        return profileListArrayElementAdapter.profileName != null && this.profileName != null && profileListArrayElementAdapter.profileName.length() == 0 && this.profileName.length() == 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public int getPos() {
        return this.posId;
    }

    @Override
    public void setPos(int n) {
        this.posId = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        if (this._arrayHeader == null) {
            this._arrayHeader = new ArrayHeader();
        }
        return this._arrayHeader;
    }

    void setNewPowerProviderId(int n) {
        this.setPowerProvider(null);
        this.setPowerProviderId(n);
    }

    public BatteryControlProfileRA0 toProfileListRA0() {
        return new BatteryControlProfileRA0(this.getPos(), this.createProfileOperation(), this.createProfileOperation2(), this.maxCurrent, this.getMinChargeLevel(), this.getMinRange(), this.targetChargeLevel, this.getTargetChargeDuration(), this.getTargetChargeRange(), this.getUnitRange(), this.isRangeCalculationSetup(), this.temperatureValue, this.temperatureUnit, this.leadTime, this.holdingTimePlug, this.holdingTimeBattery, this.getPowerProviderId(), this.profileName);
    }

    public BatteryControlProfileRA3 toProfileListRA3() {
        return new BatteryControlProfileRA3(this.getPos(), this.profileName);
    }

    public BatteryControlProfileRA5 toProfileListRA5() {
        return new BatteryControlProfileRA5(this.getPos(), this.createProfileOperation(), this.createProfileOperation2(), this.maxCurrent, this.targetChargeLevel, this.getPowerProviderId(), this.profileName);
    }

    public BatteryControlProfileOperation createProfileOperation() {
        return new BatteryControlProfileOperation(this.isCharing, this.isAirConditioning, this.isClimateWithoutExternalSupply(), this.autoDefrost, this.seatHeaterFrontLeft, this.seatHeaterFrontRight, this.seatHeaterRearLeft, this.seatHeaterRearRight);
    }

    public BatteryControlProfileOperation2 createProfileOperation2() {
        return new BatteryControlProfileOperation2(this.isWindowHeating, this.windowHeaterRear, this.isParkHeater(), this.parkHeaterAutomatic);
    }

    public boolean equals(Object object) {
        ProfileListArrayElementAdapter profileListArrayElementAdapter = (ProfileListArrayElementAdapter)object;
        boolean bl = profileListArrayElementAdapter.profileName != null && this.profileName != null && profileListArrayElementAdapter.profileName.compareTo(this.profileName) == 0;
        return bl && profileListArrayElementAdapter.posId == this.posId && profileListArrayElementAdapter.targetChargeLevel == this.targetChargeLevel && profileListArrayElementAdapter.temperatureUnit == this.temperatureUnit && profileListArrayElementAdapter.temperatureValue == this.temperatureValue && profileListArrayElementAdapter.isAirConditioning == this.isAirConditioning && profileListArrayElementAdapter.autoDefrost == this.autoDefrost && profileListArrayElementAdapter.seatHeaterFrontLeft == this.seatHeaterFrontLeft && profileListArrayElementAdapter.seatHeaterFrontRight == this.seatHeaterFrontRight && profileListArrayElementAdapter.seatHeaterRearRight == this.seatHeaterRearRight && profileListArrayElementAdapter.isCharing == this.isCharing && profileListArrayElementAdapter.isWindowHeating == this.isWindowHeating && profileListArrayElementAdapter.windowHeaterRear == this.windowHeaterRear && profileListArrayElementAdapter.isParkHeater() == this.isParkHeater() && profileListArrayElementAdapter.parkHeaterAutomatic == this.parkHeaterAutomatic && profileListArrayElementAdapter.maxCurrent == this.maxCurrent && profileListArrayElementAdapter.minChargeLevel == this.minChargeLevel && profileListArrayElementAdapter.isClimateWithoutExternalSupply() == this.isClimateWithoutExternalSupply() && profileListArrayElementAdapter.getMinRange() == this.getMinRange() && profileListArrayElementAdapter.getTargetChargeDuration() == this.getTargetChargeDuration() && profileListArrayElementAdapter.getTargetChargeRange() == this.getTargetChargeRange() && profileListArrayElementAdapter.getUnitRange() == this.getUnitRange() && profileListArrayElementAdapter.isRangeCalculationSetup() == this.isRangeCalculationSetup() && profileListArrayElementAdapter.leadTime == this.leadTime && profileListArrayElementAdapter.holdingTimePlug == this.holdingTimePlug && profileListArrayElementAdapter.holdingTimeBattery == this.holdingTimeBattery;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

