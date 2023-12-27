/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.service;

import de.vw.mib.asl.internal.car.service.transformer.CarServiceFunctionAvailability_ServiceTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceFunctionAvailability_TiresTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceFunctionAvailableReason_ServiceTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceFunctionAvailableReason_TiresTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceFunctionExistence_ServiceTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceFunctionExistence_TiresTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSTireListTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceRKA_RDKS_StatesTransformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceStartStopListProhibitReason_2Transformer;
import de.vw.mib.asl.internal.car.service.transformer.CarServiceVehicleStatusWarningTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceCurrentSpeedCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceCurrentSpeedTransformer;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceOilServiceButtonAvailabilityCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceOilServiceButtonAvailabilityTransformer;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSSnowTireWarningCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSSnowTireWarningTransformer;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSTiresCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSTiresTransformer;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceSIAOilCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceSIAOilTransformer;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceSIAServiceCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceSIAServiceTransformer;

public final class ASLCarServiceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarServiceDeviceImpl INSTANCE = new ASLCarServiceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(17);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLCarServiceDeviceImpl() {
    }

    public static ASLCarServiceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Service";
    }

    @Override
    public int getTargetId() {
        return 11013;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10266, this);
        aSLListRegistry.registerASLDevice(10267, this);
        aSLListRegistry.registerASLDevice(10268, this);
        aSLListRegistry.registerASLDevice(10269, this);
        aSLListRegistry.registerASLDevice(10270, this);
        aSLListRegistry.registerASLDevice(10271, this);
        aSLListRegistry.registerASLDevice(10598, this);
        aSLListRegistry.registerASLDevice(10254, this);
        aSLListRegistry.registerASLDevice(10844, this);
        aSLListRegistry.registerASLDevice(10624, this);
        aSLListRegistry.registerASLDevice(10491, this);
        aSLListRegistry.registerASLDevice(10756, this);
        aSLListRegistry.registerASLDevice(10757, this);
        aSLListRegistry.registerASLDevice(10758, this);
        aSLListRegistry.registerASLDevice(10760, this);
        aSLListRegistry.registerASLDevice(10761, this);
        aSLListRegistry.registerASLDevice(10762, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-418643904, 11013);
        serviceRegister.registerService(1292632128, 11013);
        serviceRegister.registerService(1309409344, 11013);
        serviceRegister.registerService(1326186560, 11013);
        serviceRegister.registerService(1342963776, 11013);
        serviceRegister.registerService(1359740992, 11013);
        serviceRegister.registerService(1376518208, 11013);
        serviceRegister.registerService(437059648, 11013);
        serviceRegister.registerService(739049536, 11013);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10266: {
                nArray = ListColumnsUtil.getSimpleIntArray(18);
                break;
            }
            case 10267: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 10268: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 10269: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10270: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10271: {
                nArray = ListColumnsUtil.getIntArrayByBits(3851, 7);
                break;
            }
            case 10598: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10254: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10844: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10624: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10491: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10756: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10757: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10758: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10760: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10761: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10762: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Service: ").append(n).toString());
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
        return ASLCarServiceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarServiceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10266: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceRDKSTiresTransformer(), n, "Car.Service", "RDKSTires");
                genericASLList.updateList(new CarServiceRDKSTiresCollector[]{new CarServiceRDKSTiresCollector()});
                break;
            }
            case 10267: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceSIAServiceTransformer(), n, "Car.Service", "SIAService");
                genericASLList.updateList(new CarServiceSIAServiceCollector[]{new CarServiceSIAServiceCollector()});
                break;
            }
            case 10268: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceSIAOilTransformer(), n, "Car.Service", "SIAOil");
                genericASLList.updateList(new CarServiceSIAOilCollector[]{new CarServiceSIAOilCollector()});
                break;
            }
            case 10269: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceRDKSSnowTireWarningTransformer(), n, "Car.Service", "RDKSSnowTireWarning");
                genericASLList.updateList(new CarServiceRDKSSnowTireWarningCollector[]{new CarServiceRDKSSnowTireWarningCollector()});
                break;
            }
            case 10270: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceCurrentSpeedTransformer(), n, "Car.Service", "CurrentSpeed");
                genericASLList.updateList(new CarServiceCurrentSpeedCollector[]{new CarServiceCurrentSpeedCollector()});
                break;
            }
            case 10271: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceVehicleStatusWarningTransformer(), n, "Car.Service", "VehicleStatusWarning");
                break;
            }
            case 10598: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceOilServiceButtonAvailabilityTransformer(), n, "Car.Service", "OilServiceButtonAvailability");
                genericASLList.updateList(new CarServiceOilServiceButtonAvailabilityCollector[]{new CarServiceOilServiceButtonAvailabilityCollector()});
                break;
            }
            case 10254: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceRDKSTireListTransformer(), n, "Car.Service", "RDKSTireList");
                break;
            }
            case 10844: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceStartStopListProhibitReason_2Transformer(), n, "Car.Service", "StartStopListProhibitReason_2");
                break;
            }
            case 10624: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarServiceDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "StartStopListProhibitReason_1"), n, "Car.Service", "StartStopListProhibitReason_1");
                break;
            }
            case 10491: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceRKA_RDKS_StatesTransformer(), n, "Car.Service", "RKA_RDKS_States");
                break;
            }
            case 10756: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceFunctionExistence_ServiceTransformer(), n, "Car.Service", "FunctionExistence_Service");
                break;
            }
            case 10757: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceFunctionAvailability_ServiceTransformer(), n, "Car.Service", "FunctionAvailability_Service");
                break;
            }
            case 10758: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceFunctionAvailableReason_ServiceTransformer(), n, "Car.Service", "FunctionAvailableReason_Service");
                break;
            }
            case 10760: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceFunctionExistence_TiresTransformer(), n, "Car.Service", "FunctionExistence_Tires");
                break;
            }
            case 10761: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceFunctionAvailability_TiresTransformer(), n, "Car.Service", "FunctionAvailability_Tires");
                break;
            }
            case 10762: {
                genericASLList = aSLListFactory.createGenericASLList(new CarServiceFunctionAvailableReason_TiresTransformer(), n, "Car.Service", "FunctionAvailableReason_Tires");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.Service: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 10624: {
                string3 = "de.vw.mib.asl.internal.car.service.transformer.";
                string2 = "CarServiceStartStopListProhibitReason_1Transformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Car.Service: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Car.Service", string);
    }
}

