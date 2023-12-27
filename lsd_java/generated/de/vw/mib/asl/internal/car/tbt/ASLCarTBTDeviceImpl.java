/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.tbt;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTBluePointsStatistics_1Collector;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTBluePointsStatistics_1Transformer;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTConsumptionStatisticsElectricCollector;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTConsumptionStatisticsElectricTransformer;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTConsumptionStatistics_1Collector;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTConsumptionStatistics_1Transformer;

public final class ASLCarTBTDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarTBTDeviceImpl INSTANCE = new ASLCarTBTDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLCarTBTDeviceImpl() {
    }

    public static ASLCarTBTDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.TBT";
    }

    @Override
    public int getTargetId() {
        return 11019;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10438, this);
        aSLListRegistry.registerASLDevice(10439, this);
        aSLListRegistry.registerASLDevice(10440, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1039400896, 11019);
        serviceRegister.registerService(-619970496, 11019);
        serviceRegister.registerService(-401866688, 11019);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10438: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10439: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10440: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.TBT: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLCarTBTDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarTBTDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10438: {
                genericASLList = aSLListFactory.createGenericASLList(new CarTBTBluePointsStatistics_1Transformer(), n, "Car.TBT", "BluePointsStatistics_1");
                genericASLList.updateList(new CarTBTBluePointsStatistics_1Collector[]{new CarTBTBluePointsStatistics_1Collector()});
                break;
            }
            case 10439: {
                genericASLList = aSLListFactory.createGenericASLList(new CarTBTConsumptionStatistics_1Transformer(), n, "Car.TBT", "ConsumptionStatistics_1");
                genericASLList.updateList(new CarTBTConsumptionStatistics_1Collector[]{new CarTBTConsumptionStatistics_1Collector()});
                break;
            }
            case 10440: {
                genericASLList = aSLListFactory.createGenericASLList(new CarTBTConsumptionStatisticsElectricTransformer(), n, "Car.TBT", "ConsumptionStatisticsElectric");
                genericASLList.updateList(new CarTBTConsumptionStatisticsElectricCollector[]{new CarTBTConsumptionStatisticsElectricCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.TBT: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

