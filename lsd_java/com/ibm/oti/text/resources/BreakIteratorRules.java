/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text.resources;

import java.util.ListResourceBundle;

public class BreakIteratorRules
extends ListResourceBundle {
    static final Object[][] contents = new Object[][]{{"BreakIteratorClasses", new String[]{"RuleBasedBreakIterator", "RuleBasedBreakIterator", "RuleBasedBreakIterator", "RuleBasedBreakIterator"}}, {"CharacterBreakRules", "<enclosing>=[:Mn::Me:];<choseong>=[\u1100-\u115f];<jungseong>=[\u1160-\u11a7];<jongseong>=[\u11a8-\u11ff];<surr-hi>=[\ud800-\udbff];<surr-lo>=[\udc00-\udfff];.;<base>=[^<enclosing>^[:Cc::Cf::Zl::Zp:]];<base><enclosing><enclosing>*;\r\n;<surr-hi><surr-lo>;<choseong>*<jungseong>*<jongseong>*;<nukta>=[\u093c];<danda>=[\u0964\u0965];<virama>=[\u094d];<devVowelSign>=[\u093e-\u094c\u0962\u0963];<devConsonant>=[\u0915-\u0939];<devNuktaConsonant>=[\u0958-\u095f];<devCharEnd>=[\u0902\u0903\u0951-\u0954];<devCAMN>=(<devConsonant>{<nukta>});<devConsonant1>=(<devNuktaConsonant>|<devCAMN>);<zwj>=[\u200d];<devConjunct>=({<devConsonant1><virama>{<zwj>}}<devConsonant1>);<devConjunct>{<devVowelSign>}{<devCharEnd>};<danda><nukta>;"}, {"WordBreakRules", "<ignore>=[:Cf:];<enclosing>=[:Mn::Me:];<danda>=[\u0964\u0965];<kanji>=[\u3005\u4e00-\u9fa5\uf900-\ufa2d];<kata>=[\u30a1-\u30fa\u30fd\u30fe];<hira>=[\u3041-\u3094\u309d\u309e];<cjk-diacrit>=[\u3099-\u309c\u30fb\u30fc];<letter-base>=[:L::Mc:^[<kanji><kata><hira><cjk-diacrit>]];<let>=(<letter-base><enclosing>*);<digit-base>=[:N:];<dgt>=(<digit-base><enclosing>*);<mid-word>=[:Pd::Pc:\u00ad\u2027\\\"\\'\\.];<mid-num>=[\\\"\\'\\,\u066b\\.];<pre-num>=[:Sc:\\#\\.^\u00a2];<post-num>=[\\%\\&\u00a2\u066a\u2030\u2031];<ls>=[\n\f\u2028\u2029];<ws-base>=[:Zs:\t];<ws>=(<ws-base><enclosing>*);<word>=((<let><let>*(<mid-word><let><let>*)*){<danda>});<number>=(<dgt><dgt>*(<mid-num><dgt><dgt>*)*);.;{<word>}(<number><word>)*{<number>{<post-num>}};<pre-num>(<number><word>)*{<number>{<post-num>}};<ws>*{\r}{<ls>};[<kata><cjk-diacrit>]*;[<hira><cjk-diacrit>]*;<kanji>*;<base>=[^<enclosing>^[:Cc::Cf::Zl::Zp:]];<base><enclosing><enclosing>*;"}, {"LineBreakRules", "<break>=[\u0003\t\n\f\u2028\u2029];<ignore>=[:Cf:[:Cc:^[<break>\r]]];<enclosing>=[:Mn::Me:];<danda>=[\u0964\u0965];<glue>=[\u00a0\u0f0c\u2007\u2011\u202f\ufeff];<space>=[:Zs::Cc:^[<glue><break>\r]];<dash>=[:Pd:\u00ad^<glue>];<pre-word>=[:Sc::Ps::Pi:^[\u00a2]\\\"\\'];<post-word>=[\\\":Pe::Pf:\\!\\%\\.\\,\\:\\;\\?\u00a2\u00b0\u066a\u2030-\u2034\u2103\u2105\u2109\u3001\u3002\u3005\u3041\u3043\u3045\u3047\u3049\u3063\u3083\u3085\u3087\u308e\u3099-\u309e\u30a1\u30a3\u30a5\u30a7\u30a9\u30c3\u30e3\u30e5\u30e7\u30ee\u30f5\u30f6\u30fc-\u30fe\uff01\uff05\uff0c\uff0e\uff1a\uff1b\uff1f];<kanji>=[\u4e00-\u9fa5\uf900-\ufa2d\u3041-\u3094\u30a1-\u30fa^[<post-word><ignore>]];<digit>=[:Nd::No:];<mid-num>=[\\.\\,];<char>=[^[<break><space><dash><kanji><glue><ignore><pre-word><post-word><mid-num>\r<danda>]];<number>=([<pre-word><dash>]*<digit><digit>*(<mid-num><digit><digit>*)*);<word-core>=(<char>*|<kanji>|<number>);<word-suffix>=((<dash><dash>*|<post-word>*));<word>=(<pre-word>*<word-core><word-suffix>);<hack1>=[\\(];<hack2>=[\\)];<hack3>=[\\$\\'];<word>(((<space>*<glue><glue>*{<space>})|<hack3>)<word>)*<space>*{<enclosing>*}{<hack1><hack2><post-word>*}{<enclosing>*}{\r}{<break>};\r<break>;"}, {"SentenceBreakRules", "<ignore>=[:Mn::Me::Cf:];<letter>=[:L:];<lc>=[:Ll:];<uc>=[:Lu:];<notlc>=[<letter>^<lc>];<space>=[\t\r\f\n\u2028:Zs:];<start-punctuation>=[:Ps::Pi:\\\"\\'];<end>=[:Pe::Pf:\\\"\\'];<digit>=[:N:];<term>=[\\!\\?\u3002\uff01\uff1f];<period>=[\\.\uff0e];<sent-start>=[^[:L:<space><start-punctuation><end><digit><term><period>\u2029<ignore>]];<danda>=[\u0964\u0965];.*?{\u2029};.*?<danda><space>*;.*?<period>[<period><end>]*<space><space>*/<notlc>;.*?<period>[<period><end>]*<space>*/[<start-punctuation><sent-start>][<start-punctuation><sent-start>]*<letter>;.*?<term>[<term><period><end>]*<space>*{\u2029};!<sent-start><start-punctuation>*<space>*<end>*<period>;![<sent-start><lc><digit>]<start-punctuation>*<space>*<end>*<term>;"}};

    @Override
    public Object[][] getContents() {
        return contents;
    }
}
