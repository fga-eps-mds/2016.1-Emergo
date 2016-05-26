package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Context;

import dao.UserDao;

public class UserController extends Activity {
    private static Context context;
    private static UserDao userDao;
    private static UserController instance = null;

    public UserController(Context context) {
        this.context = context;
        userDao = UserDao.getInstance(context);
    }

    public static UserController getInstance(Context context) {
        if (instance == null) {
            instance = new UserController(context);
        } else {
			/* ! Nothing To Do. */
        }
        return instance;
    }
}
