/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car;

import de.vw.mib.asl.internal.car.transformer.CarFunctionAvailability_CarSetupTransformer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionAvailability_FactorySettingsTransformer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionAvailableReason_CarSetupTransformer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionAvailableReason_FactorySettingsTransformer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionAvailableTransformer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionExistence_CarSetupTransformer;
import de.vw.mib.asl.internal.car.transformer.CarFunctionExistence_FactorySettingsTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.transformer.CarCompassInfoCollector;
import generated.de.vw.mib.asl.internal.car.transformer.CarCompassInfoTransformer;
import generated.de.vw.mib.asl.internal.car.transformer.CarHDCAvailabilityCollector;
import generated.de.vw.mib.asl.internal.car.transformer.CarHDCAvailabilityTransformer;

public final class ASLCarDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarDeviceImpl INSTANCE = new ASLCarDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(12);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLCarDeviceImpl() {
    }

    public static ASLCarDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car";
    }

    @Override
    public int getTargetId() {
        return 11005;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10126, this);
        aSLListRegistry.registerASLDevice(10127, this);
        aSLListRegistry.registerASLDevice(10545, this);
        aSLListRegistry.registerASLDevice(10771, this);
        aSLListRegistry.registerASLDevice(10772, this);
        aSLListRegistry.registerASLDevice(10773, this);
        aSLListRegistry.registerASLDevice(10775, this);
        aSLListRegistry.registerASLDevice(10776, this);
        aSLListRegistry.registerASLDevice(10777, this);
        aSLListRegistry.registerASLDevice(10791, this);
        aSLListRegistry.registerASLDevice(10792, this);
        aSLListRegistry.registerASLDevice(10793, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-502595520, 11005);
        serviceRegister.registerService(-116654016, 11005);
        serviceRegister.registerService(453836864, 11005);
        serviceRegister.registerService(1426915392, 11005);
        serviceRegister.registerService(1460469824, 11005);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10126: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10127: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10545: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10771: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10772: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10773: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10775: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10776: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10777: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10791: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10792: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10793: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car: ").append(n).toString());
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
        return ASLCarDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10126: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFunctionAvailableTransformer(), n, "Car", "FunctionAvailable");
                break;
            }
            case 10127: {
                genericASLList = aSLListFactory.createGenericASLList(new CarCompassInfoTransformer(), n, "Car", "CompassInfo");
                genericASLList.updateList(new CarCompassInfoCollector[]{new CarCompassInfoCollector()});
                break;
            }
            case 10545: {
                genericASLList = aSLListFactory.createGenericASLList(new CarHDCAvailabilityTransformer(), n, "Car", "HDCAvailability");
                genericASLList.updateList(new CarHDCAvailabilityCollector[]{new CarHDCAvailabilityCollector()});
                break;
            }
            case 10771: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFunctionExistence_FactorySettingsTransformer(), n, "Car", "FunctionExistence_FactorySettings");
                break;
            }
            case 10772: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFunctionAvailableReason_FactorySettingsTransformer(), n, "Car", "FunctionAvailableReason_FactorySettings");
                break;
            }
            case 10773: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFunctionAvailability_FactorySettingsTransformer(), n, "Car", "FunctionAvailability_FactorySettings");
                break;
            }
            case 10775: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionExistence_ClimateSplFunc"), n, "Car", "FunctionExistence_ClimateSplFunc");
                break;
            }
            case 10776: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason_ClimateSplFunc"), n, "Car", "FunctionAvailableReason_ClimateSplFunc");
                break;
            }
            case 10777: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability_ClimateSplFunc"), n, "Car", "FunctionAvailability_ClimateSplFunc");
                break;
            }
            case 10791: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFunctionExistence_CarSetupTransformer(), n, "Car", "FunctionExistence_CarSetup");
                break;
            }
            case 10792: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFunctionAvailability_CarSetupTransformer(), n, "Car", "FunctionAvailability_CarSetup");
                break;
            }
            case 10793: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFunctionAvailableReason_CarSetupTransformer(), n, "Car", "FunctionAvailableReason_CarSetup");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 10775: {
                string3 = "de.vw.mib.asl.internal.car.transformer.";
                string2 = "CarFunctionExistence_ClimateSplFuncTransformer";
                break;
            }
            case 10776: {
                string3 = "de.vw.mib.asl.internal.car.transformer.";
                string2 = "CarFunctionAvailableReason_ClimateSplFuncTransformer";
                break;
            }
            case 10777: {
                string3 = "de.vw.mib.asl.internal.car.transformer.";
                string2 = "CarFunctionAvailability_ClimateSplFuncTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Car: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Car", string);
    }
}

