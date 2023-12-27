/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.bordcomputer;

import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerActiveEcoComfortConsumersTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerBCMenu1Transformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerBCMenu1_BITransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerBCMenu2Transformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerBCMenu2_BITransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerBCMenu3Transformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerBCMenu3_BITransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerFunctionAvailability_CarBordComputerTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerFunctionAvailability_CarMainTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerFunctionAvailableReason_CarBordComputerTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerFunctionAvailableReason_CarMainTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerFunctionExistence_CarBordComputerTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerFunctionExistence_CarMainTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerHUDConfigurationTransformer;
import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerKombiDisplayConfigurationTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerEcoComfortConsumptionCollector;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerEcoComfortConsumptionTransformer;

public final class ASLCarBordComputerDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarBordComputerDeviceImpl INSTANCE = new ASLCarBordComputerDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(18);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLCarBordComputerDeviceImpl() {
    }

    public static ASLCarBordComputerDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.BordComputer";
    }

    @Override
    public int getTargetId() {
        return 11006;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10136, this);
        aSLListRegistry.registerASLDevice(10137, this);
        aSLListRegistry.registerASLDevice(10138, this);
        aSLListRegistry.registerASLDevice(10139, this);
        aSLListRegistry.registerASLDevice(10140, this);
        aSLListRegistry.registerASLDevice(10141, this);
        aSLListRegistry.registerASLDevice(10142, this);
        aSLListRegistry.registerASLDevice(10480, this);
        aSLListRegistry.registerASLDevice(10128, this);
        aSLListRegistry.registerASLDevice(10129, this);
        aSLListRegistry.registerASLDevice(10130, this);
        aSLListRegistry.registerASLDevice(10131, this);
        aSLListRegistry.registerASLDevice(10816, this);
        aSLListRegistry.registerASLDevice(10817, this);
        aSLListRegistry.registerASLDevice(10818, this);
        aSLListRegistry.registerASLDevice(10812, this);
        aSLListRegistry.registerASLDevice(10813, this);
        aSLListRegistry.registerASLDevice(10814, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-485818304, 11006);
        serviceRegister.registerService(-469041088, 11006);
        serviceRegister.registerService(957153344, 11006);
        serviceRegister.registerService(-452263872, 11006);
        serviceRegister.registerService(671940672, 11006);
        serviceRegister.registerService(-435486656, 11006);
        serviceRegister.registerService(-301203392, 11006);
        serviceRegister.registerService(-284426176, 11006);
        serviceRegister.registerService(-267648960, 11006);
        serviceRegister.registerService(-250871744, 11006);
        serviceRegister.registerService(-234094528, 11006);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10136: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10137: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10138: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10139: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10140: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10141: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10142: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10480: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10128: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10129: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10130: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10131: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10816: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10817: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10818: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10812: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10813: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10814: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.BordComputer: ").append(n).toString());
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
        return ASLCarBordComputerDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarBordComputerDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10136: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerBCMenu1Transformer(), n, "Car.BordComputer", "BCMenu1");
                break;
            }
            case 10137: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerBCMenu2Transformer(), n, "Car.BordComputer", "BCMenu2");
                break;
            }
            case 10138: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerBCMenu3Transformer(), n, "Car.BordComputer", "BCMenu3");
                break;
            }
            case 10139: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerBCMenu1_BITransformer(), n, "Car.BordComputer", "BCMenu1_BI");
                break;
            }
            case 10140: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerBCMenu2_BITransformer(), n, "Car.BordComputer", "BCMenu2_BI");
                break;
            }
            case 10141: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerBCMenu3_BITransformer(), n, "Car.BordComputer", "BCMenu3_BI");
                break;
            }
            case 10142: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerEcoComfortConsumptionTransformer(), n, "Car.BordComputer", "EcoComfortConsumption");
                genericASLList.updateList(new CarBordComputerEcoComfortConsumptionCollector[]{new CarBordComputerEcoComfortConsumptionCollector()});
                break;
            }
            case 10480: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerActiveEcoComfortConsumersTransformer(), n, "Car.BordComputer", "ActiveEcoComfortConsumers");
                break;
            }
            case 10128: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerHUDConfigurationTransformer(), n, "Car.BordComputer", "HUDConfiguration");
                break;
            }
            case 10129: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerKombiDisplayConfigurationTransformer(), n, "Car.BordComputer", "KombiDisplayConfiguration");
                break;
            }
            case 10130: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarBordComputerDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "EcoComfortConsumersID"), n, "Car.BordComputer", "EcoComfortConsumersID");
                break;
            }
            case 10131: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarBordComputerDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "EcoComfortConsumersValue"), n, "Car.BordComputer", "EcoComfortConsumersValue");
                break;
            }
            case 10816: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerFunctionExistence_CarMainTransformer(), n, "Car.BordComputer", "FunctionExistence_CarMain");
                break;
            }
            case 10817: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerFunctionAvailability_CarMainTransformer(), n, "Car.BordComputer", "FunctionAvailability_CarMain");
                break;
            }
            case 10818: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerFunctionAvailableReason_CarMainTransformer(), n, "Car.BordComputer", "FunctionAvailableReason_CarMain");
                break;
            }
            case 10812: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerFunctionExistence_CarBordComputerTransformer(), n, "Car.BordComputer", "FunctionExistence_CarBordComputer");
                break;
            }
            case 10813: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerFunctionAvailability_CarBordComputerTransformer(), n, "Car.BordComputer", "FunctionAvailability_CarBordComputer");
                break;
            }
            case 10814: {
                genericASLList = aSLListFactory.createGenericASLList(new CarBordComputerFunctionAvailableReason_CarBordComputerTransformer(), n, "Car.BordComputer", "FunctionAvailableReason_CarBordComputer");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.BordComputer: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 10130: {
                string3 = "de.vw.mib.asl.internal.car.bordcomputer.transformer.";
                string2 = "CarBordComputerEcoComfortConsumersIDTransformer";
                break;
            }
            case 10131: {
                string3 = "de.vw.mib.asl.internal.car.bordcomputer.transformer.";
                string2 = "CarBordComputerEcoComfortConsumersValueTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Car.BordComputer: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Car.BordComputer", string);
    }
}

