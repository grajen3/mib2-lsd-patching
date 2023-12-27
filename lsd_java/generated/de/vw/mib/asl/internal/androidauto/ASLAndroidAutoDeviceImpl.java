/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.androidauto;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.androidauto.transformer.AndroidAutoCanvasDimensionCollector;
import generated.de.vw.mib.asl.internal.androidauto.transformer.AndroidAutoCanvasDimensionTransformer;

public final class ASLAndroidAutoDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAndroidAutoDeviceImpl INSTANCE = new ASLAndroidAutoDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLAndroidAutoDeviceImpl() {
    }

    public static ASLAndroidAutoDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AndroidAuto";
    }

    @Override
    public int getTargetId() {
        return 13901;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(879176704, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(541076544, 13901);
        serviceRegister.registerService(557853760, 13901);
        serviceRegister.registerService(574630976, 13901);
        serviceRegister.registerService(591408192, 13901);
        serviceRegister.registerService(608185408, 13901);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2910004: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AndroidAuto: ").append(n).toString());
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
        return ASLAndroidAutoDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLAndroidAutoDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2910004: {
                genericASLList = aSLListFactory.createGenericASLList(new AndroidAutoCanvasDimensionTransformer(), n, "AndroidAuto", "CanvasDimension");
                genericASLList.updateList(new AndroidAutoCanvasDimensionCollector[]{new AndroidAutoCanvasDimensionCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device AndroidAuto: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

