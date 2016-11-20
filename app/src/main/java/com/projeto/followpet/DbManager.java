package com.projeto.followpet;

import android.content.Context;

/**
 * Created by eduardo on 20/11/16.
 */

public class DbManager {
    private static  DbFollowpet dbfollowpet = null;

    public  DbManager(Context context){
        if (dbfollowpet == null){
            dbfollowpet = new DbFollowpet(context);
        }
    }


}
