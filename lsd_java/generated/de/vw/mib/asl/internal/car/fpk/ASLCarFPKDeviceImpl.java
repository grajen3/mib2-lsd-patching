/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.fpk;

import de.vw.mib.asl.internal.car.fpk.transformer.CarFPKAvailableContentDisplay1_1Transformer;
import de.vw.mib.asl.internal.car.fpk.transformer.CarFPKAvailableContentDisplay2_1Transformer;
import de.vw.mib.asl.internal.car.fpk.transformer.CarFPKAvailableModesTransformer;
import de.vw.mib.asl.internal.car.fpk.transformer.CarFPKFunctionAvailabilityTransformer;
import de.vw.mib.asl.internal.car.fpk.transformer.CarFPKFunctionAvailableReasonTransformer;
import de.vw.mib.asl.internal.car.fpk.transformer.CarFPKFunctionExistenceTransformer;
import de.vw.mib.asl.internal.car.fpk.transformer.CarFPKPresetIdsTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay1_1Collector;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay1_1Transformer;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay2_1Collector;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay2_1Transformer;

public final class ASLCarFPKDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarFPKDeviceImpl INSTANCE = new ASLCarFPKDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(9);
    private ASLListFactory listFactory;

    private ASLCarFPKDeviceImpl() {
    }

    public static ASLCarFPKDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.FPK";
    }

    @Override
    public int getTargetId() {
        return 11031;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10885, this);
        aSLListRegistry.registerASLDevice(10886, this);
        aSLListRegistry.registerASLDevice(10863, this);
        aSLListRegistry.registerASLDevice(10883, this);
        aSLListRegistry.registerASLDevice(10884, this);
        aSLListRegistry.registerASLDevice(10860, this);
        aSLListRegistry.registerASLDevice(10866, this);
        aSLListRegistry.registerASLDevice(10867, this);
        aSLListRegistry.registerASLDevice(10868, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1192034368, 11031);
        serviceRegister.registerService(1158479936, 11031);
        serviceRegister.registerService(1175257152, 11031);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10885: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10886: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10863: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10883: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10884: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10860: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10866: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10867: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10868: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.FPK: ").append(n).toString());
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
        return ASLCarFPKDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarFPKDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10885: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKCurrentElementContentSelectionDisplay1_1Transformer(), n, "Car.FPK", "currentElementContentSelectionDisplay1_1");
                genericASLList.updateList(new CarFPKCurrentElementContentSelectionDisplay1_1Collector[]{new CarFPKCurrentElementContentSelectionDisplay1_1Collector()});
                break;
            }
            case 10886: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKCurrentElementContentSelectionDisplay2_1Transformer(), n, "Car.FPK", "currentElementContentSelectionDisplay2_1");
                genericASLList.updateList(new CarFPKCurrentElementContentSelectionDisplay2_1Collector[]{new CarFPKCurrentElementContentSelectionDisplay2_1Collector()});
                break;
            }
            case 10863: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKAvailableModesTransformer(), n, "Car.FPK", "availableModes");
                break;
            }
            case 10883: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKAvailableContentDisplay1_1Transformer(), n, "Car.FPK", "AvailableContentDisplay1_1");
                break;
            }
            case 10884: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKAvailableContentDisplay2_1Transformer(), n, "Car.FPK", "AvailableContentDisplay2_1");
                break;
            }
            case 10860: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKPresetIdsTransformer(), n, "Car.FPK", "PresetIds");
                break;
            }
            case 10866: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKFunctionExistenceTransformer(), n, "Car.FPK", "FunctionExistence");
                break;
            }
            case 10867: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKFunctionAvailabilityTransformer(), n, "Car.FPK", "FunctionAvailability");
                break;
            }
            case 10868: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPKFunctionAvailableReasonTransformer(), n, "Car.FPK", "FunctionAvailableReason");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.FPK: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

