/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.mfa;

import de.vw.mib.asl.internal.car.mfa.transformer.CarMFAFunctionAvailabilityTransformer;
import de.vw.mib.asl.internal.car.mfa.transformer.CarMFAFunctionAvailableReasonTransformer;
import de.vw.mib.asl.internal.car.mfa.transformer.CarMFAFunctionExistenceTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarMFADeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarMFADeviceImpl INSTANCE = new ASLCarMFADeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLCarMFADeviceImpl() {
    }

    public static ASLCarMFADeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.MFA";
    }

    @Override
    public int getTargetId() {
        return 11027;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10738, this);
        aSLListRegistry.registerASLDevice(10739, this);
        aSLListRegistry.registerASLDevice(10740, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10738: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10739: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10740: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.MFA: ").append(n).toString());
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
        return ASLCarMFADeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarMFADeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10738: {
                genericASLList = aSLListFactory.createGenericASLList(new CarMFAFunctionExistenceTransformer(), n, "Car.MFA", "FunctionExistence");
                break;
            }
            case 10739: {
                genericASLList = aSLListFactory.createGenericASLList(new CarMFAFunctionAvailabilityTransformer(), n, "Car.MFA", "FunctionAvailability");
                break;
            }
            case 10740: {
                genericASLList = aSLListFactory.createGenericASLList(new CarMFAFunctionAvailableReasonTransformer(), n, "Car.MFA", "FunctionAvailableReason");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.MFA: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

