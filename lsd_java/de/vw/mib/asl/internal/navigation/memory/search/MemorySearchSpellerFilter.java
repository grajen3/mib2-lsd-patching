/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.memory.search.MemorySearchDataPool;
import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.speller.filter.SpellerFilterListener;
import de.vw.mib.util.StringUtil;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;

final class MemorySearchSpellerFilter
implements SpellerFilter {
    private SpellerFilterListener filterListener;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[MemorySearchSpellerFilter]");

    MemorySearchSpellerFilter() {
    }

    @Override
    public void initFilter(SpellerFilterListener spellerFilterListener) {
        this.filterListener = spellerFilterListener;
    }

    @Override
    public void releaseFilter() {
        this.filterListener = null;
    }

    @Override
    public void filterCharacters(String[] stringArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("filterCharacters(").append(Arrays.toString(stringArray)).append(")...").toString());
        }
        if (this.filterListener != null) {
            if (this.logger.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Entering HWR filtered characters: '").append(Arrays.toString(stringArray)).append("'");
                this.logger.trace(stringBuffer.toString());
            }
            this.setFilteredCharacters(stringArray);
        }
    }

    private void setFilteredCharacters(String[] stringArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("setFilteredHwrCharacters(...)");
        }
        Object[] objectArray = null;
        if (MemorySearchDataPool.getInstance().isHwrEnabled()) {
            if (stringArray != null) {
                String string = MemorySearchDataPool.getInstance().getSpellerData().getAvailableCharacters();
                StringBuffer stringBuffer = new StringBuffer(stringArray.length);
                this.logger.makeTrace().append("setFilteredHwrCharacters(): next valid characters: ").append(string).log();
                if (string != null && string.length() > 0) {
                    ArrayList arrayList = new ArrayList(stringArray.length);
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        if (stringArray[i2] != null) {
                            String string2;
                            if (stringArray[i2].length() > 1) {
                                this.logger.warn("recognized character contains more than one character. It will be truncated.");
                            }
                            if (arrayList.contains(string2 = stringArray[i2].substring(0, 1).toLowerCase())) continue;
                            arrayList.add(string2);
                            continue;
                        }
                        this.logger.error("one of the recognized characters is null!");
                    }
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("updateFilteredCharacters()").append(stringBuffer.toString()).toString());
                        this.logger.trace(new StringBuffer().append("Filtering '").append((Object)stringBuffer).append("' with '").append(string).append("'...").toString());
                    }
                    objectArray = StringUtil.filterStringList((String[])arrayList.toArray(new String[arrayList.size()]), string.toLowerCase());
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("Filtering result: '").append(Arrays.toString(objectArray)).toString());
                    }
                }
            }
        } else {
            this.logger.makeTrace().append("setFilteredHwrCharacters(): XT9 use case, no filtering applied! ").append(stringArray).log();
            objectArray = stringArray;
        }
        this.updateFilteredCharacters((String[])objectArray);
    }

    private void updateFilteredCharacters(String[] stringArray) {
        this.logger.makeTrace().append("updateFilteredCharacters() to speller widget: ").append(Arrays.toString(stringArray)).log();
        if (stringArray == null) {
            stringArray = new String[]{};
        }
        this.filterListener.setFilteredCharacters(stringArray);
    }
}

