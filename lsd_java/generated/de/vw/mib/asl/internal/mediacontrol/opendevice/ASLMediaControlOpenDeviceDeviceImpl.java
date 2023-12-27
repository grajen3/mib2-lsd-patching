/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.mediacontrol.opendevice;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.mediacontrol.opendevice.transformer.MediaControlOpenDeviceCurrentTrackInfoCollector;
import generated.de.vw.mib.asl.internal.mediacontrol.opendevice.transformer.MediaControlOpenDeviceCurrentTrackInfoTransformer;

public final class ASLMediaControlOpenDeviceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMediaControlOpenDeviceDeviceImpl INSTANCE = new ASLMediaControlOpenDeviceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLMediaControlOpenDeviceDeviceImpl() {
    }

    public static ASLMediaControlOpenDeviceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "MediaControl.OpenDevice";
    }

    @Override
    public int getTargetId() {
        return 16702;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1189062912, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1560717760, 16702);
        serviceRegister.registerService(-1543940544, 16702);
        serviceRegister.registerService(-1275505088, 16702);
        serviceRegister.registerService(-1258727872, 16702);
        serviceRegister.registerService(-1527163328, 16702);
        serviceRegister.registerService(-1493608896, 16702);
        serviceRegister.registerService(-1476831680, 16702);
        serviceRegister.registerService(-1460054464, 16702);
        serviceRegister.registerService(-1443277248, 16702);
        serviceRegister.registerService(-1141287360, 16702);
        serviceRegister.registerService(-1426500032, 16702);
        serviceRegister.registerService(-1409722816, 16702);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5710009: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device MediaControl.OpenDevice: ").append(n).toString());
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
        return ASLMediaControlOpenDeviceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMediaControlOpenDeviceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5710009: {
                genericASLList = aSLListFactory.createGenericASLList(new MediaControlOpenDeviceCurrentTrackInfoTransformer(), n, "MediaControl.OpenDevice", "currentTrackInfo");
                genericASLList.updateList(new MediaControlOpenDeviceCurrentTrackInfoCollector[]{new MediaControlOpenDeviceCurrentTrackInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device MediaControl.OpenDevice: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

