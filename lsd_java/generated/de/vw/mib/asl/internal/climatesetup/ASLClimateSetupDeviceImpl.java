/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.climatesetup;

import de.vw.mib.asl.internal.climatesetup.transformer.ClimateSetupFunctionAvailability_ClimateSetupTransformer;
import de.vw.mib.asl.internal.climatesetup.transformer.ClimateSetupFunctionAvailableReason_ClimateSetupTransformer;
import de.vw.mib.asl.internal.climatesetup.transformer.ClimateSetupFunctionExistence_ClimateSetupTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLClimateSetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLClimateSetupDeviceImpl INSTANCE = new ASLClimateSetupDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLClimateSetupDeviceImpl() {
    }

    public static ASLClimateSetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "ClimateSetup";
    }

    @Override
    public int getTargetId() {
        return 18201;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(621047296, this);
        aSLListRegistry.registerASLDevice(637824512, this);
        aSLListRegistry.registerASLDevice(654601728, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(98397504, 18201);
        serviceRegister.registerService(48065856, 18201);
        serviceRegister.registerService(14511424, 18201);
        serviceRegister.registerService(64843072, 18201);
        serviceRegister.registerService(115174720, 18201);
        serviceRegister.registerService(81620288, 18201);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 7210021: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 7210022: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 7210023: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device ClimateSetup: ").append(n).toString());
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
        return ASLClimateSetupDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLClimateSetupDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 7210021: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateSetupFunctionExistence_ClimateSetupTransformer(), n, "ClimateSetup", "FunctionExistence_ClimateSetup");
                break;
            }
            case 7210022: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateSetupFunctionAvailability_ClimateSetupTransformer(), n, "ClimateSetup", "FunctionAvailability_ClimateSetup");
                break;
            }
            case 7210023: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateSetupFunctionAvailableReason_ClimateSetupTransformer(), n, "ClimateSetup", "FunctionAvailableReason_ClimateSetup");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device ClimateSetup: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

