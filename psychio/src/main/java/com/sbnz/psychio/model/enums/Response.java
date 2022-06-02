package com.sbnz.psychio.model.enums;

public enum Response {
    STRONGLY_DISAGREE, DISAGREE, NA, AGREE, STRONGLY_AGREE;

    public static int getResponseValue(Response r){
        if (r == STRONGLY_DISAGREE) return -2;
        else if (r == DISAGREE) return -1;
        else if (r == NA) return 0;
        else if (r == AGREE) return 1;
        else if (r == STRONGLY_AGREE) return 2;

        return 0;

    }

}


