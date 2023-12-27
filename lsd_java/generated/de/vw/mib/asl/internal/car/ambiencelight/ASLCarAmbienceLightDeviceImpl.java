/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.ambiencelight;

import de.vw.mib.asl.internal.car.ambiencelight.transformer.CarAmbienceLightFunctionAvailabilityTransformer;
import de.vw.mib.asl.internal.car.ambiencelight.transformer.CarAmbienceLightFunctionAvailableReasonTransformer;
import de.vw.mib.asl.internal.car.ambiencelight.transformer.CarAmbienceLightFunctionExistenceTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarAmbienceLightDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarAmbienceLightDeviceImpl INSTANCE = new ASLCarAmbienceLightDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLCarAmbienceLightDeviceImpl() {
    }

    public static ASLCarAmbienceLightDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.AmbienceLight";
    }

    @Override
    public int getTargetId() {
        return 11029;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10779, this);
        aSLListRegistry.registerASLDevice(10780, this);
        aSLListRegistry.registerASLDevice(10781, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10779: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10780: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10781: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.AmbienceLight: ").append(n).toString());
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
        return ASLCarAmbienceLightDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarAmbienceLightDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10779: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAmbienceLightFunctionExistenceTransformer(), n, "Car.AmbienceLight", "FunctionExistence");
                break;
            }
            case 10780: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAmbienceLightFunctionAvailabilityTransformer(), n, "Car.AmbienceLight", "FunctionAvailability");
                break;
            }
            case 10781: {
                genericASLList = aSLListFactory.createGenericASLList(new CarAmbienceLightFunctionAvailableReasonTransformer(), n, "Car.AmbienceLight", "FunctionAvailableReason");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.AmbienceLight: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

