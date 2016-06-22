package dao;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assert;
import org.junit.Test;

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
    @Test
    public void testSuccessInsertEmergencyContact(){
        boolean wasInserted = true;
        emergencyContactDao = EmergencyContactDao.getInstance(activity.getApplicationContext());
        wasInserted = emergencyContactDao.insertEmergencyContact(2,"MrVictor","1234532");
        Assert.assertTrue(wasInserted);
        int num = emergencyContactDao.deleteEmergencyContact(2);
    }
}
