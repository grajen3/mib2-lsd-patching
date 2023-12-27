/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.profiles;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListContext;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlProfileCollector;
import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionProfileListTransformer;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Iterator;

abstract class ProfileListModelUpdater
implements ASGArrayListChangeNotifier {
    private ProfileListContext _context;
    private int temperatureValue;
    private int minSOC;
    protected static final int GLOBAL_PROFILE_POS_ID;

    public ProfileListModelUpdater(ProfileListContext profileListContext) {
        this._context = profileListContext;
        this.temperatureValue = 220;
        this.minSOC = 0;
    }

    private ProfileListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateProfileListInternal(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateProfileListInternal(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateProfileListInternal(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this.updateProfileListInternal(aSGArrayList);
    }

    private void updateTemperatureValue(int n, int n2) {
        this.temperatureValue = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(10341, n2 == 0 ? n + 100 : (n / 4 + 50) * 10);
        ServiceManager.aslPropertyManager.valueChangedInteger(10342, n2 == 0 ? 0 : 1);
    }

    private void updateMinSOC(int n) {
        this.minSOC = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(10344, ASLCarUtil.rounding(n));
    }

    protected final int getTemperatureValue() {
        return this.temperatureValue;
    }

    protected final int getMinSOC() {
        return this.minSOC;
    }

    protected abstract void profileListUpdated(BatteryControlProfileCollector batteryControlProfileCollector) {
    }

    protected final void updateModelWithGlobalProfile(BatteryControlProfileCollector batteryControlProfileCollector) {
        this.updateTemperatureValue(batteryControlProfileCollector.temperatureValue, batteryControlProfileCollector.temperatureUnit);
        ServiceManager.aslPropertyManager.valueChangedInteger(10343, CarE_TractionProfileListTransformer.maxCurrentProfileHmi(batteryControlProfileCollector.maxCurrent));
        this.updateMinSOC(batteryControlProfileCollector.getMinChargeLevel());
        ServiceManager.aslPropertyManager.valueChangedBoolean(10346, batteryControlProfileCollector.isClimateWithoutExternalSupply());
        ServiceManager.aslPropertyManager.valueChangedBoolean(10472, batteryControlProfileCollector.isParkHeater());
    }

    private BatteryControlProfileCollector constructArrayForUpdate(ASGArrayList aSGArrayList, ArrayList arrayList) {
        BatteryControlProfileCollector batteryControlProfileCollector = null;
        Iterator iterator = aSGArrayList.getAllElements().getIterator();
        while (iterator.hasNext()) {
            BAPArrayElement bAPArrayElement = (BAPArrayElement)iterator.next();
            if (bAPArrayElement.getPos() == 0) {
                batteryControlProfileCollector = (BatteryControlProfileCollector)((Object)bAPArrayElement);
                continue;
            }
            arrayList.add(bAPArrayElement);
        }
        return batteryControlProfileCollector;
    }

    private void updateProfileListInternal(ASGArrayList aSGArrayList) {
        ArrayList arrayList = new ArrayList(aSGArrayList.size());
        BatteryControlProfileCollector batteryControlProfileCollector = this.constructArrayForUpdate(aSGArrayList, arrayList);
        ListManager.getGenericASLList(10374).updateList(arrayList.toArray());
        if (batteryControlProfileCollector != null) {
            this.profileListUpdated(batteryControlProfileCollector);
        }
    }

    protected final void updateProfileList(ASGArrayList aSGArrayList) {
        ArrayList arrayList = new ArrayList(aSGArrayList.size());
        BatteryControlProfileCollector batteryControlProfileCollector = this.constructArrayForUpdate(aSGArrayList, arrayList);
        ListManager.getGenericASLList(10374).updateList(arrayList.toArray());
        if (batteryControlProfileCollector != null) {
            this.updateModelWithGlobalProfile(batteryControlProfileCollector);
        }
    }
}

