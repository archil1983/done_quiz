package org.cartrawler.quiz.consts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Archil Matchavariani on 21/01/2020
 */
public enum SippType {

    MINI("M"), ECONOMY("E"), COMPACT("C"), OTHER(null);

    private final static Map<String, SippType> CODES_MAP = new HashMap<>();


    private final String code;


    SippType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static SippType detectType(String sspTypeCode) {
        if (CODES_MAP.isEmpty()) {
            for (SippType ssp : SippType.values()) {
                if (ssp != OTHER) {
                    CODES_MAP.put(ssp.code, ssp);
                }
            }
        }
        SippType result = CODES_MAP.get(sspTypeCode);
        if (result == null) {
            result = OTHER;
        }
        return result;
    }
}
