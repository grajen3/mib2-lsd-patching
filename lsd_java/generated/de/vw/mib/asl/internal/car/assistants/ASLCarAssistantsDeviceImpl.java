/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.assistants;

import de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsFunctionAvailability_AssistDriveTransformer;
import de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsFunctionAvailableReason_AssistDriveTransformer;
import de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsFunctionExistence_DriveAssistTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsTakeOverSpeedOffsetCollector;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsTrailerModeSpeedThresholdCollector;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsTrailerModeSpeedThresholdTransformer;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsVZESpeedLimitExceededByCollector;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsVZESpeedWarningThresholdCollector;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.CarAssistantsVZESpeedWarningThresholdTransformer;

public final class ASLCarAssistantsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarAssistantsDeviceImpl INSTANCE = new ASLCarAssistantsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(7);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_GEN;

    private ASLCarAssistantsDeviceImpl() {
    }

    public static ASLCarAssistantsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Assistants";
    }

    @Override
    public int getTargetId() {
        return 11012;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10248, this);
        aSLListRegistry.registerASLDevice(10249, this);
        aSLListRegistry.registerASLDevice(10617, this);
        aSLListRegistry.registerASLDevice(10594, this);
        aSLListRegistry.registerASLDevice(10753, this);
        aSLListRegistry.registerASLDevice(10731, this);
        aSLListRegistry.registerASLDevice(10732, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(604766272, 11012);
        serviceRegister.registerService(621543488, 11012);
        serviceRegister.registerService(-485752768, 11012);
        serviceRegister.registerService(655097920, 11012);
        serviceRegister.registerService(671875136, 11012);
        serviceRegister.registerService(688652352, 11012);
        serviceRegister.registerService(705429568, 11012);
        serviceRegister.registerService(722206784, 11012);
        serviceRegister.registerService(738984000, 11012);
        serviceRegister.registerService(755761216, 11012);
        serviceRegister.registerService(789315648, 11012);
        serviceRegister.registerService(806092864, 11012);
        serviceRegister.registerService(0x400D0040, 11012);
        serviceRegister.registerService(822870080, 11012);
        serviceRegister.registerService(839712832, 11012);
        serviceRegister.registerService(856490048, 11012);
        serviceRegister.registerService(856424512, 11012);
        serviceRegister.registerService(873201728, 11012);
        serviceRegister.registerService(889978944, 11012);
        serviceRegister.registerService(906756160, 11012);
        serviceRegister.registerService(1108148288, 11012);
        serviceRegister.registerService(923533376, 11012);
        serviceRegister.registerService(940310592, 11012);
        serviceRegister.registerService(957087808, 11012);
        serviceRegister.registerService(973865024, 11012);
        serviceRegister.registerService(1091371072, 11012);
        serviceRegister.registerService(1057751104, 11012);
        serviceRegister.registerService(0x400C0040, 11012);
        serviceRegister.registerService(1091305536, 11012);
        serviceRegister.registerService(1108082752, 11012);
        serviceRegister.registerService(-334757824, 11012);
        serviceRegister.registerService(1124859968, 11012);
        serviceRegister.registerService(0x440C0040, 11012);
        serviceRegister.registerService(1158414400, 11012);
        serviceRegister.registerService(1175191616, 11012);
        serviceRegister.registerService(1191968832, 11012);
        serviceRegister.registerService(873267264, 11012);
        serviceRegister.registerService(890044480, 11012);
        serviceRegister.registerService(1024262208, 11012);
        serviceRegister.registerService(604831808, 11012);
        serviceRegister.registerService(621609024, 11012);
        serviceRegister.registerService(-536084416, 11012);
        serviceRegister.registerService(-519307200, 11012);
        serviceRegister.registerService(-183762880, 11012);
        serviceRegister.registerService(386728000, 11012);
        serviceRegister.registerService(403505216, 11012);
        serviceRegister.registerService(420282432, 11012);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10248: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10249: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10617: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10594: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 10753: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10731: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10732: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Assistants: ").append(n).toString());
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
        return ASLCarAssistantsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarAssistantsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10248: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarAssistantsDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "TakeOverSpeedOffset"), n, "Car.Assistants", "TakeOverSpeedOffset");
                genericASLList.updateList(new CarAssistantsTakeOverSpeedOffsetCollector[]{new CarAssistantsTakeOverSpeedOffsetCollector()});
                break;
            }
            case 10249: {
                genericASLList = aSLListFactory.createGenericASLList(ASLCarAssistantsDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "VZESpeedLimitExceededBy"), n, "Car.Assistants", "VZESpeedLimitExceededBy");
                genericASLList.updateList(new CarAssistantsVZESpeedLimitExceededByCollector[]{new CarAssistantsVZESpeedLimitExceededByCollector()});
                break;
            }
            case 10617: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAssistantsTrailerModeSpeedThresholdTransformer(), n, "Car.Assistants", "TrailerModeSpeedThreshold");
                genericASLList.updateList(new CarAssistantsTrailerModeSpeedThresholdCollector[]{new CarAssistantsTrailerModeSpeedThresholdCollector()});
                break;
            }
            case 10594: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAssistantsVZESpeedWarningThresholdTransformer(), n, "Car.Assistants", "VZESpeedWarningThreshold");
                genericASLList.updateList(new CarAssistantsVZESpeedWarningThresholdCollector[]{new CarAssistantsVZESpeedWarningThresholdCollector()});
                break;
            }
            case 10753: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAssistantsFunctionExistence_DriveAssistTransformer(), n, "Car.Assistants", "FunctionExistence_DriveAssist");
                break;
            }
            case 10731: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAssistantsFunctionAvailableReason_AssistDriveTransformer(), n, "Car.Assistants", "FunctionAvailableReason_AssistDrive");
                break;
            }
            case 10732: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAssistantsFunctionAvailability_AssistDriveTransformer(), n, "Car.Assistants", "FunctionAvailability_AssistDrive");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.Assistants: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 10248: {
                string3 = "generated.de.vw.mib.asl.internal.car.assistants.transformer.";
                string2 = "CarAssistantsTakeOverSpeedOffsetTransformer";
                break;
            }
            case 10249: {
                string3 = "generated.de.vw.mib.asl.internal.car.assistants.transformer.";
                string2 = "CarAssistantsVZESpeedLimitExceededByTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Car.Assistants: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Car.Assistants", string);
    }
}

