package dao;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assert;

import unlv.erc.emergo.controller.MedicalRecordsController;

public class UserDaoTest extends ActivityInstrumentationTestCase2<MedicalRecordsController>{
    UserDao userDao;
    private MedicalRecordsController activity;

    public UserDaoTest(){
        super(MedicalRecordsController.class);
    }

    protected void setUp() throws Exception{
        super.setUp();
        this.activity = getActivity();
    }

    public void testSuccessInsertUser(){
        boolean wasInserted = true;
        userDao = UserDao.getInstance(activity.getApplicationContext());
        wasInserted = userDao.insertUser(1,"MrVictor","09/07/1995","AB+","Não","Não","Não","Não","");
        Assert.assertTrue(wasInserted);
        userDao.deleteUser(1);
    }

    public void testUpdateEmergencyContact(){
        boolean wasUpdated = true;
        userDao = userDao.getInstance(activity.getApplicationContext());
        userDao.insertUser(1,"MrVictor","09/07/1995","AB+","Não","Não","Não","Não","");
        wasUpdated = userDao.updateUser(1,"MrVictor","09/07/1995","AB+","Não","Não","Não","Não","");
        Assert.assertTrue(wasUpdated);
        userDao.deleteUser(1);
    }
}
