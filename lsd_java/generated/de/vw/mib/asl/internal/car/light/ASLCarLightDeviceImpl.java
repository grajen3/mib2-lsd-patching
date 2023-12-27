/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.light;

import de.vw.mib.asl.internal.car.light.transformer.CarLightAmbienceLightBrightnessTransformer;
import de.vw.mib.asl.internal.car.light.transformer.CarLightComingLeavingHomeDurationTransformer;
import de.vw.mib.asl.internal.car.light.transformer.CarLightFunctionAvailability_LightTransformer;
import de.vw.mib.asl.internal.car.light.transformer.CarLightFunctionAvailableReason_LightTransformer;
import de.vw.mib.asl.internal.car.light.transformer.CarLightFunctionExistence_Light1Transformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.light.transformer.CarLightAmbienceColorAreaSettings_1Collector;
import generated.de.vw.mib.asl.internal.car.light.transformer.CarLightAmbienceColorAreaSettings_1Transformer;

public final class ASLCarLightDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarLightDeviceImpl INSTANCE = new ASLCarLightDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(19);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLCarLightDeviceImpl() {
    }

    public static ASLCarLightDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Light";
    }

    @Override
    public int getTargetId() {
        return 11007;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10464, this);
        aSLListRegistry.registerASLDevice(10599, this);
        aSLListRegistry.registerASLDevice(10639, this);
        aSLListRegistry.registerASLDevice(10647, this);
        aSLListRegistry.registerASLDevice(10640, this);
        aSLListRegistry.registerASLDevice(10641, this);
        aSLListRegistry.registerASLDevice(10658, this);
        aSLListRegistry.registerASLDevice(10659, this);
        aSLListRegistry.registerASLDevice(10662, this);
        aSLListRegistry.registerASLDevice(10663, this);
        aSLListRegistry.registerASLDevice(10666, this);
        aSLListRegistry.registerASLDevice(10667, this);
        aSLListRegistry.registerASLDevice(10749, this);
        aSLListRegistry.registerASLDevice(10727, this);
        aSLListRegistry.registerASLDevice(10728, this);
        aSLListRegistry.registerASLDevice(10143, this);
        aSLListRegistry.registerASLDevice(10146, this);
        aSLListRegistry.registerASLDevice(10485, this);
        aSLListRegistry.registerASLDevice(10486, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-418709440, 11007);
        serviceRegister.registerService(-401932224, 11007);
        serviceRegister.registerService(-385155008, 11007);
        serviceRegister.registerService(-368377792, 11007);
        serviceRegister.registerService(-351600576, 11007);
        serviceRegister.registerService(-334823360, 11007);
        serviceRegister.registerService(-318046144, 11007);
        serviceRegister.registerService(-301268928, 11007);
        serviceRegister.registerService(-284491712, 11007);
        serviceRegister.registerService(755826752, 11007);
        serviceRegister.registerService(772603968, 11007);
        serviceRegister.registerService(-267714496, 11007);
        serviceRegister.registerService(-250937280, 11007);
        serviceRegister.registerService(-653524928, 11007);
        serviceRegister.registerService(-234160064, 11007);
        serviceRegister.registerService(-636747712, 11007);
        serviceRegister.registerService(-217382848, 11007);
        serviceRegister.registerService(-200605632, 11007);
        serviceRegister.registerService(-183828416, 11007);
        serviceRegister.registerService(-167051200, 11007);
        serviceRegister.registerService(-150273984, 11007);
        serviceRegister.registerService(-133496768, 11007);
        serviceRegister.registerService(-116719552, 11007);
        serviceRegister.registerService(-99942336, 11007);
        serviceRegister.registerService(151846976, 11007);
        serviceRegister.registerService(185401408, 11007);
        serviceRegister.registerService(202178624, 11007);
        serviceRegister.registerService(0xD0D0040, 11007);
        serviceRegister.registerService(235733056, 11007);
        serviceRegister.registerService(252510272, 11007);
        serviceRegister.registerService(269287488, 11007);
        serviceRegister.registerService(-83165120, 11007);
        serviceRegister.registerService(168624192, 11007);
        serviceRegister.registerService(286064704, 11007);
        serviceRegister.registerService(302841920, 11007);
        serviceRegister.registerService(319619136, 11007);
        serviceRegister.registerService(336396352, 11007);
        serviceRegister.registerService(353173568, 11007);
        serviceRegister.registerService(369950784, 11007);
        serviceRegister.registerService(-66387904, 11007);
        serviceRegister.registerService(-49610688, 11007);
        serviceRegister.registerService(-32833472, 11007);
        serviceRegister.registerService(-16056256, 11007);
        serviceRegister.registerService(789381184, 11007);
        serviceRegister.registerService(806158400, 11007);
        serviceRegister.registerService(822935616, 11007);
        serviceRegister.registerService(1208811584, 11007);
        serviceRegister.registerService(1393360960, 11007);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10464: {
                nArray = ListColumnsUtil.getIntArrayByBits(8190, 12);
                break;
            }
            case 10599: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10639: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10647: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10640: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10641: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10658: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10659: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10662: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10663: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10666: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10667: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10749: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10727: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10728: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10143: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10146: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10485: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10486: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Light: ").append(n).toString());
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
        return ASLCarLightDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarLightDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10464: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "AmbienceColorAreaSettings"), n, "Car.Light", "AmbienceColorAreaSettings");
                break;
            }
            case 10599: {
                genericASLList = aSLListFactory.createGenericASLList(new CarLightAmbienceColorAreaSettings_1Transformer(), n, "Car.Light", "AmbienceColorAreaSettings_1");
                genericASLList.updateList(new CarLightAmbienceColorAreaSettings_1Collector[]{new CarLightAmbienceColorAreaSettings_1Collector()});
                break;
            }
            case 10639: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionExistence"), n, "Car.Light", "FunctionExistence");
                break;
            }
            case 10647: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionExistence_2"), n, "Car.Light", "FunctionExistence_2");
                break;
            }
            case 10640: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability"), n, "Car.Light", "FunctionAvailability");
                break;
            }
            case 10641: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason"), n, "Car.Light", "FunctionAvailableReason");
                break;
            }
            case 10658: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason_4"), n, "Car.Light", "FunctionAvailableReason_4");
                break;
            }
            case 10659: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability_4"), n, "Car.Light", "FunctionAvailability_4");
                break;
            }
            case 10662: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason_5"), n, "Car.Light", "FunctionAvailableReason_5");
                break;
            }
            case 10663: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability_5"), n, "Car.Light", "FunctionAvailability_5");
                break;
            }
            case 10666: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailableReason_6"), n, "Car.Light", "FunctionAvailableReason_6");
                break;
            }
            case 10667: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "FunctionAvailability_6"), n, "Car.Light", "FunctionAvailability_6");
                break;
            }
            case 10749: {
                genericASLList = aSLListFactory.createGenericASLList(new CarLightFunctionExistence_Light1Transformer(), n, "Car.Light", "FunctionExistence_Light1");
                break;
            }
            case 10727: {
                genericASLList = aSLListFactory.createGenericASLList(new CarLightFunctionAvailableReason_LightTransformer(), n, "Car.Light", "FunctionAvailableReason_Light");
                break;
            }
            case 10728: {
                genericASLList = aSLListFactory.createGenericASLList(new CarLightFunctionAvailability_LightTransformer(), n, "Car.Light", "FunctionAvailability_Light");
                break;
            }
            case 10143: {
                genericASLList = aSLListFactory.createGenericASLList(new CarLightComingLeavingHomeDurationTransformer(), n, "Car.Light", "ComingLeavingHomeDuration");
                break;
            }
            case 10146: {
                genericASLList = aSLListFactory.createGenericASLList(new CarLightAmbienceLightBrightnessTransformer(), n, "Car.Light", "AmbienceLightBrightness");
                break;
            }
            case 10485: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "AmbianceBrightnessValues"), n, "Car.Light", "AmbianceBrightnessValues");
                break;
            }
            case 10486: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarLightDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "AmbianceFeatureButtonMapping"), n, "Car.Light", "AmbianceFeatureButtonMapping");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.Light: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 10464: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightAmbienceColorAreaSettingsTransformer";
                break;
            }
            case 10639: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionExistenceTransformer";
                break;
            }
            case 10647: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionExistence_2Transformer";
                break;
            }
            case 10640: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailabilityTransformer";
                break;
            }
            case 10641: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailableReasonTransformer";
                break;
            }
            case 10658: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailableReason_4Transformer";
                break;
            }
            case 10659: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailability_4Transformer";
                break;
            }
            case 10662: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailableReason_5Transformer";
                break;
            }
            case 10663: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailability_5Transformer";
                break;
            }
            case 10666: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailableReason_6Transformer";
                break;
            }
            case 10667: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightFunctionAvailability_6Transformer";
                break;
            }
            case 10485: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightAmbianceBrightnessValuesTransformer";
                break;
            }
            case 10486: {
                string3 = "de.vw.mib.asl.internal.car.light.transformer.";
                string2 = "CarLightAmbianceFeatureButtonMappingTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Car.Light: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Car.Light", string);
    }
}

