package service;

import model.ComputerEngine;

public class ComputerEngineCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.of.instances";
    public static final String TESTDATA_WHAT_ARE_THESE_INSTANCES_FOR = "testdata.what.are.these.instances.for";
    public static final String TESTDATA_OPERATING_SYSTEM_SOFTWARE = "testdata.operating.system.software";
    public static final String TESTDATA_PROVISIONING_MODEL = "testdata.provisioning.model";
    public static final String TESTDATA_SERIES = "testdata.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public static final String TESTDATA_NUMBERS_OF_GPUS = "testdata.numbers.of.gpus";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter.location";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.committed.usage";

    public static ComputerEngine withCredentialsFromProperty(){
        return new ComputerEngine(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_WHAT_ARE_THESE_INSTANCES_FOR),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBERS_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
