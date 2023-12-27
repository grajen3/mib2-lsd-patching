/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.mediacontrol;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mediacontrol.transformer.MediaControlDeviceListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMediaControlDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMediaControlDeviceImpl INSTANCE = new ASLMediaControlDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLMediaControlDeviceImpl() {
    }

    public static ASLMediaControlDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "MediaControl";
    }

    @Override
    public int getTargetId() {
        return 16701;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1306503424, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1174841792, 16701);
        serviceRegister.registerService(-1325836736, 16701);
        serviceRegister.registerService(-1241950656, 16701);
        serviceRegister.registerService(-1225173440, 16701);
        serviceRegister.registerService(-1292282304, 16701);
        serviceRegister.registerService(-1158064576, 16701);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5710002: {
                nArray = ListColumnsUtil.getIntArrayByBits(59, 5);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device MediaControl: ").append(n).toString());
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
        return ASLMediaControlDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMediaControlDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5710002: {
                genericASLList = aSLListFactory.createGenericASLList(new MediaControlDeviceListTransformer(), n, "MediaControl", "deviceList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device MediaControl: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

