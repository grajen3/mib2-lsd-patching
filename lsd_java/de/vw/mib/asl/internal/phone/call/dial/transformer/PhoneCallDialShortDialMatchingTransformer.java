/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call.dial.transformer;

import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.AbstractPhoneCallDialShortDialMatchingTransformer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.Highlight;

public class PhoneCallDialShortDialMatchingTransformer
extends AbstractPhoneCallDialShortDialMatchingTransformer
implements Comparator {
    @Override
    public String getString(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 3: {
                if (Util.isNullOrEmpty(dataSet.getHighlight())) {
                    return dataSet.getGeneralDescription1();
                }
                return this.checkAndValidateHighlightObjects(dataSet);
            }
            case 2: {
                if (Util.isNullOrEmpty(dataSet.getHighlight())) {
                    return dataSet.getGeneralDescription2();
                }
                for (int i2 = 0; i2 < dataSet.getHighlight().length; ++i2) {
                    Highlight highlight = dataSet.getHighlight()[i2];
                    if (highlight.gendescription != 5 || !this.validateHighlighting(highlight, dataSet.getGeneralDescription2())) continue;
                    return new StringBuilder(dataSet.getGeneralDescription2()).insert(highlight.getHighlightEnd(), '\u0087').insert(highlight.getHighlightStart(), '\u0086').toString();
                }
                return dataSet.getGeneralDescription2();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private String checkAndValidateHighlightObjects(DataSet dataSet) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < dataSet.getHighlight().length; ++i2) {
            if (dataSet.getHighlight()[i2].getGendescription() != 1 || !this.validateHighlighting(dataSet.getHighlight()[i2], dataSet.getGeneralDescription1())) continue;
            arrayList.add(dataSet.getHighlight()[i2]);
        }
        if (!arrayList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(dataSet.getGeneralDescription1());
            Collections.sort(arrayList, this);
            for (int i3 = arrayList.size() - 1; i3 >= 0; --i3) {
                Highlight highlight = (Highlight)arrayList.get(i3);
                stringBuilder.insert(highlight.getHighlightEnd(), '\u0087').insert(highlight.getHighlightStart(), '\u0086');
            }
            return stringBuilder.toString();
        }
        return dataSet.getGeneralDescription1();
    }

    boolean validateHighlighting(Highlight highlight, String string) {
        return highlight.getHighlightStart() >= 0 && highlight.getHighlightStart() < highlight.getHighlightEnd() && highlight.getHighlightEnd() <= string.length();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 4: {
                if (Util.isNullOrEmpty(dataSet.getHighlight())) {
                    return dataSet.phoneCount > 1;
                }
                int n2 = 0;
                for (int i2 = 0; i2 < dataSet.getHighlight().length; ++i2) {
                    Highlight highlight = dataSet.getHighlight()[i2];
                    if (highlight.gendescription != 5) continue;
                    ++n2;
                }
                if (n2 == 1) {
                    return false;
                }
                return dataSet.phoneCount > 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 0: {
                return (int)dataSet.entryId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        DataSet dataSet = (DataSet)object;
        switch (n) {
            case 5: {
                return PhoneUtil.convertPhoneTypeDSI2ASLCombined(dataSet.getNumberType());
            }
            case 6: {
                return dataSet.getNumberType();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int compare(Object object, Object object2) {
        Highlight highlight = (Highlight)object;
        Highlight highlight2 = (Highlight)object2;
        return highlight.getHighlightStart() - highlight2.getHighlightStart();
    }
}

