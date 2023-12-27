/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.video.dvd;

import de.vw.mib.asl.internal.avdc.video.dvd.transformer.AVDCVideoDVDAvailableDVDAudioChannelsTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLAVDCVideoDVDDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCVideoDVDDeviceImpl INSTANCE = new ASLAVDCVideoDVDDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLAVDCVideoDVDDeviceImpl() {
    }

    public static ASLAVDCVideoDVDDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Video.DVD";
    }

    @Override
    public int getTargetId() {
        return 10009;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(153, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(37030976, 10009);
        serviceRegister.registerService(-2013265856, 10009);
        serviceRegister.registerService(-1996488640, 10009);
        serviceRegister.registerService(53808192, 10009);
        serviceRegister.registerService(3476544, 10009);
        serviceRegister.registerService(20253760, 10009);
        serviceRegister.registerService(70585408, 10009);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 153: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Video.DVD: ").append(n).toString());
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
        return ASLAVDCVideoDVDDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLAVDCVideoDVDDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 153: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCVideoDVDAvailableDVDAudioChannelsTransformer(), n, "AVDC.Video.DVD", "AvailableDVDAudioChannels");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device AVDC.Video.DVD: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

