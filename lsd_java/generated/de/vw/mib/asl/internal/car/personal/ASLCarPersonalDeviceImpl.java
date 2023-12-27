/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.personal;

import de.vw.mib.asl.internal.car.personal.transformer.CarPersonalDriverListTransformer;
import de.vw.mib.asl.internal.car.personal.transformer.CarPersonalFunctionAvailability_PersonalTransformer;
import de.vw.mib.asl.internal.car.personal.transformer.CarPersonalFunctionAvailableReason_PersonalTransformer;
import de.vw.mib.asl.internal.car.personal.transformer.CarPersonalFunctionExistence_PersonalTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.personal.transformer.CarPersonalAssignKeyAvailabilityCollector;
import generated.de.vw.mib.asl.internal.car.personal.transformer.CarPersonalAssignKeyAvailabilityTransformer;

public final class ASLCarPersonalDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarPersonalDeviceImpl INSTANCE = new ASLCarPersonalDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLCarPersonalDeviceImpl() {
    }

    public static ASLCarPersonalDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Personal";
    }

    @Override
    public int getTargetId() {
        return 11022;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10449, this);
        aSLListRegistry.registerASLDevice(10534, this);
        aSLListRegistry.registerASLDevice(10764, this);
        aSLListRegistry.registerASLDevice(10765, this);
        aSLListRegistry.registerASLDevice(10766, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-871628736, 11022);
        serviceRegister.registerService(-854851520, 11022);
        serviceRegister.registerService(-838074304, 11022);
        serviceRegister.registerService(-821297088, 11022);
        serviceRegister.registerService(-804519872, 11022);
        serviceRegister.registerService(-787742656, 11022);
        serviceRegister.registerService(-385089472, 11022);
        serviceRegister.registerService(-368312256, 11022);
        serviceRegister.registerService(-351535040, 11022);
        serviceRegister.registerService(101515328, 11022);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10449: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 10534: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10764: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10765: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10766: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Personal: ").append(n).toString());
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
        return ASLCarPersonalDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarPersonalDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10449: {
                genericASLList = aSLListFactory.createGenericASLList(new CarPersonalDriverListTransformer(), n, "Car.Personal", "DriverList");
                break;
            }
            case 10534: {
                genericASLList = aSLListFactory.createGenericASLList(new CarPersonalAssignKeyAvailabilityTransformer(), n, "Car.Personal", "AssignKeyAvailability");
                genericASLList.updateList(new CarPersonalAssignKeyAvailabilityCollector[]{new CarPersonalAssignKeyAvailabilityCollector()});
                break;
            }
            case 10764: {
                genericASLList = aSLListFactory.createGenericASLList(new CarPersonalFunctionExistence_PersonalTransformer(), n, "Car.Personal", "FunctionExistence_Personal");
                break;
            }
            case 10765: {
                genericASLList = aSLListFactory.createGenericASLList(new CarPersonalFunctionAvailability_PersonalTransformer(), n, "Car.Personal", "FunctionAvailability_Personal");
                break;
            }
            case 10766: {
                genericASLList = aSLListFactory.createGenericASLList(new CarPersonalFunctionAvailableReason_PersonalTransformer(), n, "Car.Personal", "FunctionAvailableReason_Personal");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.Personal: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

