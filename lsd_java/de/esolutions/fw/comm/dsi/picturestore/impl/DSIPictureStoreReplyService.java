/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureStoreReply;
import de.esolutions.fw.comm.dsi.picturestore.impl.GeoPictureSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.PictureAttributeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public class DSIPictureStoreReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.picturestore.DSIPictureStore");
    private static int dynamicHandle = 0;
    private DSIPictureStoreReply p_DSIPictureStoreReply;

    public DSIPictureStoreReplyService(DSIPictureStoreReply dSIPictureStoreReply) {
        super(new ServiceInstanceID("cf4b0f19-f102-5a25-9c9a-e20ad310a491", DSIPictureStoreReplyService.nextDynamicHandle(), "1c27b1cd-5f97-5915-aba4-7477cff8c408", "dsi.picturestore.DSIPictureStore"));
        this.p_DSIPictureStoreReply = dSIPictureStoreReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 52: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    ResourceLocator resourceLocator2 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.importPictureResult(n, resourceLocator, resourceLocator2, n2);
                    break;
                }
                case 57: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIPictureStoreReply.pictureExists(resourceLocator, bl);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.freeSlots(n, n3);
                    break;
                }
                case 50: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIPictureStoreReply.getReferencesResult(resourceLocator, nArray);
                    break;
                }
                case 43: {
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    this.p_DSIPictureStoreReply.deletedPictures(resourceLocatorArray);
                    break;
                }
                case 59: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    this.p_DSIPictureStoreReply.responseLRUPictures(n, resourceLocatorArray);
                    break;
                }
                case 56: {
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.listResult(resourceLocatorArray, n);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.listForContextResult(n, resourceLocatorArray, n4);
                    break;
                }
                case 48: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    PictureAttribute[] pictureAttributeArray = PictureAttributeSerializer.getOptionalPictureAttributeVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.getPictureAttributesResult(resourceLocator, pictureAttributeArray, n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    ResourceLocator resourceLocator3 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.importPictureFromSourceResult(n, resourceLocator, resourceLocator3, n5);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.listForContextWithFilterResult(n, resourceLocatorArray, n6);
                    break;
                }
                case 61: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n7 = iDeserializer.getInt32();
                    float f2 = iDeserializer.getFloat();
                    float f3 = iDeserializer.getFloat();
                    this.p_DSIPictureStoreReply.listForContextWithFilterSortDistResult(n, resourceLocatorArray, n7, f2, f3);
                    break;
                }
                case 49: {
                    GeoPicture[] geoPictureArray = GeoPictureSerializer.getOptionalGeoPictureVarArray(iDeserializer);
                    this.p_DSIPictureStoreReply.getRectanglePicturesGridResult(geoPictureArray);
                    break;
                }
                case 47: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIPictureStoreReply.getAvailableYearsResult(nArray);
                    break;
                }
                case 46: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIPictureStoreReply.getAvailableMonthsResult(nArray);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.createFilterSetResult(n);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.cloneFilterSetResult(n, n8);
                    break;
                }
                case 58: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.resetToFactorySettingsResult(n);
                    break;
                }
                case 63: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.invalidData(nArray, n);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSIPictureStoreReply.getAvailableFoldersResult(n, stringArray);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.countPicturesInContextResult(n, n9, n10);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIPictureStoreReply.asyncException(n, string, n11);
                    break;
                }
                case 60: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPictureStoreReply.yyIndication(string, string2);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

