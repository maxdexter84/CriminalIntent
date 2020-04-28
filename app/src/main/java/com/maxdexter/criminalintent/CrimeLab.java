package com.maxdexter.criminalintent;

import android.content.Context;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    public CrimeLab(Context context) {

    }

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
}
