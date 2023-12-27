/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.carlife;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.carlife.transformer.CarLifeCanvasDimensionCollector;
import generated.de.vw.mib.asl.internal.carlife.transformer.CarLifeCanvasDimensionTransformer;

public final class ASLCarLifeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarLifeDeviceImpl INSTANCE = new ASLCarLifeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLCarLifeDeviceImpl() {
    }

    public static ASLCarLifeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "CarLife";
    }

    @Override
    public int getTargetId() {
        return 13906;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1315384320, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(910175296, 13906);
        serviceRegister.registerService(926952512, 13906);
        serviceRegister.registerService(943729728, 13906);
        serviceRegister.registerService(960506944, 13906);
        serviceRegister.registerService(977284160, 13906);
        serviceRegister.registerService(994061376, 13906);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2910030: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device CarLife: ").append(n).toString());
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
        return ASLCarLifeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarLifeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2910030: {
                genericASLList = aSLListFactory.createGenericASLList(new CarLifeCanvasDimensionTransformer(), n, "CarLife", "CanvasDimension");
                genericASLList.updateList(new CarLifeCanvasDimensionCollector[]{new CarLifeCanvasDimensionCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device CarLife: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

