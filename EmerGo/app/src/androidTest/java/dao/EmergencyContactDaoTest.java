package dao;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assert;

import unlv.erc.emergo.controller.EmergencyContactController;

public class EmergencyContactDaoTest extends ActivityInstrumentationTestCase2<EmergencyContactController> {
    EmergencyContactDao emergencyContactDao;
    private EmergencyContactController activity;

    public EmergencyContactDaoTest(){
        super(EmergencyContactController.class);
    }

    protected void setUp() throws Exception{
        super.setUp();
        this.activity = getActivity();
    }

    public void testSuccessInsertEmergencyContact(){
        boolean wasInserted = true;
        emergencyContactDao = EmergencyContactDao.getInstance(activity.getApplicationContext());
        wasInserted = emergencyContactDao.insertEmergencyContact(5,"MrVictor","(061)98310-4981");
        Assert.assertTrue(wasInserted);
        emergencyContactDao.deleteEmergencyContact(5);
    }

    public void testUpdateEmergencyContact(){
        boolean wasUpdated = true;
        emergencyContactDao = EmergencyContactDao.getInstance(activity.getApplicationContext());
        emergencyContactDao.insertEmergencyContact(4,"MrVictor","(061)98310-4981");
        wasUpdated = emergencyContactDao.updateEmergencyContact(4,"Victor","(061)98310-4981");
        Assert.assertTrue(wasUpdated);
        emergencyContactDao.deleteEmergencyContact(4);
    }
}
