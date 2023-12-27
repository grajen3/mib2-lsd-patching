/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.messages.transformer.MessagesDraftMessageTransformer;
import de.vw.mib.asl.internal.messages.transformer.MessagesExtractedAddressesTransformer;
import de.vw.mib.asl.internal.messages.transformer.MessagesExtractedContactNumbersTransformer;
import de.vw.mib.asl.internal.messages.transformer.MessagesExtractedEmailAddressesTransformer;
import de.vw.mib.asl.internal.messages.transformer.MessagesExtractedNumbersTransformer;
import de.vw.mib.asl.internal.messages.transformer.MessagesMessageListTransformer;
import de.vw.mib.asl.internal.messages.transformer.MessagesSelectedMessageContactsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageTransformer;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageDisplayedFolderCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageDisplayedFolderTransformer;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageSendErrorCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageSendErrorTransformer;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesNavigationTemplateCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesNavigationTemplateTransformer;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesSelectedMessageCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesSelectedMessageTransformer;

public final class ASLMessagesDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMessagesDeviceImpl INSTANCE = new ASLMessagesDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(12);
    private ASLListFactory listFactory;

    private ASLMessagesDeviceImpl() {
    }

    public static ASLMessagesDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Messages";
    }

    @Override
    public int getTargetId() {
        return 10029;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1226699520, this);
        aSLListRegistry.registerASLDevice(-1126036224, this);
        aSLListRegistry.registerASLDevice(458, this);
        aSLListRegistry.registerASLDevice(459, this);
        aSLListRegistry.registerASLDevice(3612, this);
        aSLListRegistry.registerASLDevice(460, this);
        aSLListRegistry.registerASLDevice(461, this);
        aSLListRegistry.registerGrammar(2, 461, -1, true);
        aSLListRegistry.registerASLDevice(462, this);
        aSLListRegistry.registerASLDevice(463, this);
        aSLListRegistry.registerASLDevice(464, this);
        aSLListRegistry.registerASLDevice(465, this);
        aSLListRegistry.registerASLDevice(4037, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1694564416, 10029);
        serviceRegister.registerService(1711341632, 10029);
        serviceRegister.registerService(1728118848, 10029);
        serviceRegister.registerService(1744896064, 10029);
        serviceRegister.registerService(1761673280, 10029);
        serviceRegister.registerService(1778450496, 10029);
        serviceRegister.registerService(1795227712, 10029);
        serviceRegister.registerService(436863040, 10029);
        serviceRegister.registerService(1812004928, 10029);
        serviceRegister.registerService(1828782144, 10029);
        serviceRegister.registerService(1845559360, 10029);
        serviceRegister.registerService(1862336576, 10029);
        serviceRegister.registerService(-1313141440, 10029);
        serviceRegister.registerService(1879113792, 10029);
        serviceRegister.registerService(1895891008, 10029);
        serviceRegister.registerService(-1564799680, 10029);
        serviceRegister.registerService(-1346695872, 10029);
        serviceRegister.registerService(1912668224, 10029);
        serviceRegister.registerService(1929445440, 10029);
        serviceRegister.registerService(1962999872, 10029);
        serviceRegister.registerService(453640256, 10029);
        serviceRegister.registerService(1979777088, 10029);
        serviceRegister.registerService(1996554304, 10029);
        serviceRegister.registerService(2013331520, 10029);
        serviceRegister.registerService(-1329918656, 10029);
        serviceRegister.registerService(2030108736, 10029);
        serviceRegister.registerService(2046885952, 10029);
        serviceRegister.registerService(-1246032576, 10029);
        serviceRegister.registerService(2063663168, 10029);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 910006: {
                nArray = ListColumnsUtil.getIntArrayByBits(2934, 8);
                break;
            }
            case 910012: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 458: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 459: {
                nArray = ListColumnsUtil.getIntArrayByBits(6, 2);
                break;
            }
            case 3612: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 460: {
                nArray = ListColumnsUtil.getIntArrayByBits(126, 6);
                break;
            }
            case 461: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 462: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 463: {
                nArray = ListColumnsUtil.getIntArrayByBits(-536871168, 23);
                break;
            }
            case 464: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 465: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 4037: {
                nArray = ListColumnsUtil.getSimpleIntArray(9);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages: ").append(n).toString());
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
        return ASLMessagesDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMessagesDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 910006: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesNavigationTemplateTransformer(), n, "Messages", "navigationTemplate");
                genericASLList.updateList(new MessagesNavigationTemplateCollector[]{new MessagesNavigationTemplateCollector()});
                break;
            }
            case 910012: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesMessageSendErrorTransformer(), n, "Messages", "messageSendError");
                genericASLList.updateList(new MessagesMessageSendErrorCollector[]{new MessagesMessageSendErrorCollector()});
                break;
            }
            case 458: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesDraftMessageTransformer(), n, "Messages", "draftMessage");
                break;
            }
            case 459: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesExtractedContactNumbersTransformer(), n, "Messages", "extractedContactNumbers");
                break;
            }
            case 3612: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesExtractedEmailAddressesTransformer(), n, "Messages", "extractedEmailAddresses");
                break;
            }
            case 460: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesExtractedNumbersTransformer(), n, "Messages", "extractedNumbers");
                break;
            }
            case 461: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesExtractedAddressesTransformer(), n, "Messages", "extractedAddresses");
                genericASLList.setSpeechListIds(new int[]{2});
                break;
            }
            case 462: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesMessageDisplayedFolderTransformer(), n, "Messages", "messageDisplayedFolder");
                genericASLList.updateList(new MessagesMessageDisplayedFolderCollector[]{new MessagesMessageDisplayedFolderCollector()});
                break;
            }
            case 463: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesMessageListTransformer(), n, "Messages", "messageList");
                break;
            }
            case 464: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesSelectedMessageContactsTransformer(), n, "Messages", "selectedMessageContacts");
                break;
            }
            case 465: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesSelectedMessageTransformer(), n, "Messages", "selectedMessage");
                genericASLList.updateList(new MessagesSelectedMessageCollector[]{new MessagesSelectedMessageCollector()});
                break;
            }
            case 4037: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesEditedMessageTransformer(), n, "Messages", "editedMessage");
                genericASLList.updateList(new MessagesEditedMessageCollector[]{new MessagesEditedMessageCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Messages: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

