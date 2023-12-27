/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechmedia.sources;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechmedia.sources.transformer.SpeechMediaSourcesSourceListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechMediaSourcesDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechMediaSourcesDeviceImpl INSTANCE = new ASLSpeechMediaSourcesDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLSpeechMediaSourcesDeviceImpl() {
    }

    public static ASLSpeechMediaSourcesDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechMedia.Sources";
    }

    @Override
    public int getTargetId() {
        return 14305;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1300155904, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1336266176, 14305);
        serviceRegister.registerService(-1319488960, 14305);
        serviceRegister.registerService(-1302711744, 14305);
        serviceRegister.registerService(-1285934528, 14305);
        serviceRegister.registerService(-1269157312, 14305);
        serviceRegister.registerService(-1252380096, 14305);
        serviceRegister.registerService(-1235602880, 14305);
        serviceRegister.registerService(-1218825664, 14305);
        serviceRegister.registerService(-1118162368, 14305);
        serviceRegister.registerService(-1134939584, 14305);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3310002: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Sources: ").append(n).toString());
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
        return ASLSpeechMediaSourcesDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechMediaSourcesDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3310002: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechMediaSourcesSourceListTransformer(), n, "SpeechMedia.Sources", "SourceList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechMedia.Sources: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

