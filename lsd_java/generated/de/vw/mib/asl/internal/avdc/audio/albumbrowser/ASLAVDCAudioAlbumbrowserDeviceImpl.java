/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.albumbrowser;

import de.vw.mib.asl.internal.avdc.audio.albumbrowser.transformer.AVDCAudioAlbumbrowserCoverFlowInfolistTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLAVDCAudioAlbumbrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCAudioAlbumbrowserDeviceImpl INSTANCE = new ASLAVDCAudioAlbumbrowserDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLAVDCAudioAlbumbrowserDeviceImpl() {
    }

    public static ASLAVDCAudioAlbumbrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Audio.Albumbrowser";
    }

    @Override
    public int getTargetId() {
        return 10003;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2350, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1191575616, 10003);
        serviceRegister.registerService(553648192, 10003);
        serviceRegister.registerService(0x22000040, 10003);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2350: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Audio.Albumbrowser: ").append(n).toString());
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
        return ASLAVDCAudioAlbumbrowserDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLAVDCAudioAlbumbrowserDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2350: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioAlbumbrowserCoverFlowInfolistTransformer(), n, "AVDC.Audio.Albumbrowser", "coverFlowInfolist");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device AVDC.Audio.Albumbrowser: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

