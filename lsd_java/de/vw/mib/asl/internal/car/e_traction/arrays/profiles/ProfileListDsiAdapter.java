/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.profiles;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListArrayElementAdapter;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListContext;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListDsiListener;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

class ProfileListDsiAdapter
implements ProfileListDsiListener {
    private ProfileListContext _context;
    private int _totalNumberOfElements;
    private ASGArrayList _profileListArrayList;

    public ProfileListDsiAdapter(ProfileListContext profileListContext, ASGArrayList aSGArrayList) {
        this._context = profileListContext;
        this._profileListArrayList = aSGArrayList;
    }

    private ProfileListContext getContext() {
        return this._context;
    }

    private void setTotalNumberOfElements(int n) {
        this._totalNumberOfElements = n;
    }

    private int getTotalNumberOfElements() {
        return this._totalNumberOfElements;
    }

    private ASGArrayList getProfileArrayList() {
        return this._profileListArrayList;
    }

    private BAPStatusArray convertToStatusArrayHeader(BatteryControlProfilesAH batteryControlProfilesAH) {
        return BapArrayFactory.getInstance().getBAPArrayConverter().convertStatusArrayResponse(batteryControlProfilesAH.getStartElement(), batteryControlProfilesAH.getNumOfElements(), batteryControlProfilesAH.getArrayContent(), batteryControlProfilesAH.getRecordContent(), batteryControlProfilesAH.getTransactionID(), batteryControlProfilesAH.getAsgID(), this.getTotalNumberOfElements());
    }

    @Override
    public void dsiCarHybridResponseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA0 batteryControlProfileRA0 : batteryControlProfileRA0Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA0));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA1 batteryControlProfileRA1 : batteryControlProfileRA1Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA1));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA2 batteryControlProfileRA2 : batteryControlProfileRA2Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA2));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA3 batteryControlProfileRA3 : batteryControlProfileRA3Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA3));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA4 batteryControlProfileRA4 : batteryControlProfileRA4Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA4));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA5 batteryControlProfileRA5 : batteryControlProfileRA5Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA5));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(101) && batteryControlProfilesAH.asgID == 0) {
            batteryControlProfilesAH.asgID = 1;
        }
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA6 batteryControlProfileRA6 : batteryControlProfileRA6Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA6));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        for (BatteryControlProfileRA7 batteryControlProfileRA7 : batteryControlProfileRA7Array) {
            bAPStatusArray.getArrayData().add(new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader(), batteryControlProfileRA7));
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridResponseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(batteryControlProfilesAH);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ProfileListArrayElementAdapter profileListArrayElementAdapter = new ProfileListArrayElementAdapter(bAPStatusArray.getArrayHeader());
            profileListArrayElementAdapter.setPos(nArray[i2]);
            bAPStatusArray.getArrayData().add(profileListArrayElementAdapter);
        }
        this.getProfileArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarHybridUpdateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
        int n2 = nArray != null ? nArray.length : 0;
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().getBAPArrayConverter().convertChangedArrayUpdateInfo(batteryControlProfilesAH.startElement, batteryControlProfilesAH.getNumOfElements(), batteryControlProfilesAH.getArrayContent(), batteryControlProfilesAH.getRecordContent(), n2 > 0);
        if (nArray != null) {
            int n3 = nArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                ProfileListArrayElementAdapter profileListArrayElementAdapter = new ProfileListArrayElementAdapter(bAPChangedArray.getArrayHeader());
                profileListArrayElementAdapter.setPos(nArray[i2]);
                bAPChangedArray.getArrayData().add(profileListArrayElementAdapter);
            }
        }
        this.getProfileArrayList().changedArray(bAPChangedArray);
    }

    @Override
    public void dsiCarHybridUpdateBatteryControlTotalNumberOfProfiles(int n, int n2) {
        this.setTotalNumberOfElements(n);
    }
}

