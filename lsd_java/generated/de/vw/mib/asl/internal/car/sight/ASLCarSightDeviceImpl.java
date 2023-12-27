/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.sight;

import de.vw.mib.asl.internal.car.sight.transformer.CarSightFunctionAvailability_4Transformer;
import de.vw.mib.asl.internal.car.sight.transformer.CarSightFunctionAvailableReason_4Transformer;
import de.vw.mib.asl.internal.car.sight.transformer.CarSightFunctionExistence_5Transformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarSightDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarSightDeviceImpl INSTANCE = new ASLCarSightDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(11);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLCarSightDeviceImpl() {
    }

    public static ASLCarSightDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Sight";
    }

    @Override
    public int getTargetId() {
        return 11011;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10643, this);
        aSLListRegistry.registerASLDevice(10644, this);
        aSLListRegistry.registerASLDevice(10628, this);
        aSLListRegistry.registerASLDevice(10645, this);
        aSLListRegistry.registerASLDevice(10650, this);
        aSLListRegistry.registerASLDevice(10651, this);
        aSLListRegistry.registerASLDevice(10654, this);
        aSLListRegistry.registerASLDevice(10655, this);
        aSLListRegistry.registerASLDevice(10754, this);
        aSLListRegistry.registerASLDevice(10735, this);
        aSLListRegistry.registerASLDevice(10736, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(487325760, 11011);
        serviceRegister.registerService(504102976, 11011);
        serviceRegister.registerService(520880192, 11011);
        serviceRegister.registerService(537657408, 11011);
        serviceRegister.registerService(554434624, 11011);
        serviceRegister.registerService(571211840, 11011);
        serviceRegister.registerService(587989056, 11011);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10643: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10644: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10628: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10645: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10650: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10651: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10654: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10655: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10754: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10735: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10736: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Sight: ").append(n).toString());
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
        return ASLCarSightDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarSightDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10643: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionExistence_1"), n, "Car.Sight", "FunctionExistence_1");
                break;
            }
            case 10644: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason_1"), n, "Car.Sight", "FunctionAvailableReason_1");
                break;
            }
            case 10628: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability"), n, "Car.Sight", "FunctionAvailability");
                break;
            }
            case 10645: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability_1"), n, "Car.Sight", "FunctionAvailability_1");
                break;
            }
            case 10650: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason_2"), n, "Car.Sight", "FunctionAvailableReason_2");
                break;
            }
            case 10651: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability_2"), n, "Car.Sight", "FunctionAvailability_2");
                break;
            }
            case 10654: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason_3"), n, "Car.Sight", "FunctionAvailableReason_3");
                break;
            }
            case 10655: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarSightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability_3"), n, "Car.Sight", "FunctionAvailability_3");
                break;
            }
            case 10754: {
                genericASLList = aSLListFactory.createGenericASLList(new CarSightFunctionExistence_5Transformer(), n, "Car.Sight", "FunctionExistence_5");
                break;
            }
            case 10735: {
                genericASLList = aSLListFactory.createGenericASLList(new CarSightFunctionAvailableReason_4Transformer(), n, "Car.Sight", "FunctionAvailableReason_4");
                break;
            }
            case 10736: {
                genericASLList = aSLListFactory.createGenericASLList(new CarSightFunctionAvailability_4Transformer(), n, "Car.Sight", "FunctionAvailability_4");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.Sight: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 10643: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionExistence_1Transformer";
                break;
            }
            case 10644: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionAvailableReason_1Transformer";
                break;
            }
            case 10628: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionAvailabilityTransformer";
                break;
            }
            case 10645: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionAvailability_1Transformer";
                break;
            }
            case 10650: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionAvailableReason_2Transformer";
                break;
            }
            case 10651: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionAvailability_2Transformer";
                break;
            }
            case 10654: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionAvailableReason_3Transformer";
                break;
            }
            case 10655: {
                string3 = "de.vw.mib.asl.internal.car.sight.transformer.";
                string2 = "CarSightFunctionAvailability_3Transformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Car.Sight: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Car.Sight", string);
    }
}

