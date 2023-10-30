package model;

import java.util.Objects;

public class ComputerEngine {

    private String numberOfInstance;
    private String whatAreTheseInstancesFor;
    private String operatingSystemSoftware;
    private String provisioningModel;
    private String series;
    private String machineType;
    //Add GPUs.click();
    private String numbersOfGPUs;
    private String GPUType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;


    public ComputerEngine(String numberOfInstance, String whatAreTheseInstancesFor, String operatingSystemSoftware, String provisioningModel, String series, String machineType, String numbersOfGPUs, String GPUType, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstance = numberOfInstance;
        this.whatAreTheseInstancesFor = whatAreTheseInstancesFor;
        this.operatingSystemSoftware = operatingSystemSoftware;
        this.provisioningModel = provisioningModel;
        this.series = series;
        this.machineType = machineType;
        this.numbersOfGPUs = numbersOfGPUs;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    public String getWhatAreTheseInstancesFor() {
        return whatAreTheseInstancesFor;
    }

    public void setWhatAreTheseInstancesFor(String whatAreTheseInstancesFor) {
        this.whatAreTheseInstancesFor = whatAreTheseInstancesFor;
    }

    public String getOperatingSystemSoftware() {
        return operatingSystemSoftware;
    }

    public void setOperatingSystemSoftware(String operatingSystemSoftware) {
        this.operatingSystemSoftware = operatingSystemSoftware;
    }


    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumbersOfGPUs() {
        return numbersOfGPUs;
    }

    public void setNumbersOfGPUs(String numbersOfGPUs) {
        this.numbersOfGPUs = numbersOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerEngine that = (ComputerEngine) o;
        return Objects.equals(numberOfInstance, that.numberOfInstance)
                && Objects.equals(whatAreTheseInstancesFor, that.whatAreTheseInstancesFor)
                && Objects.equals(operatingSystemSoftware, that.operatingSystemSoftware)
                && Objects.equals(provisioningModel, that.provisioningModel)
                && Objects.equals(series, that.series)
                && Objects.equals(machineType, that.machineType)
                && Objects.equals(numbersOfGPUs, that.numbersOfGPUs)
                && Objects.equals(GPUType, that.GPUType)
                && Objects.equals(localSSD, that.localSSD)
                && Objects.equals(datacenterLocation, that.datacenterLocation)
                && Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance, whatAreTheseInstancesFor, operatingSystemSoftware, provisioningModel, series, machineType, numbersOfGPUs, GPUType, localSSD, datacenterLocation, committedUsage);
    }

    @Override
    public String toString() {
        return "ComputerEngineForm{" +
                "NumberOfInstance='" + numberOfInstance + '\'' +
                ", WhatAreTheseInstancesFor='" + whatAreTheseInstancesFor + '\'' +
                ", OperatingSystemSoftware='" + operatingSystemSoftware + '\'' +
                ", ProvisioningModel='" + provisioningModel + '\'' +
                ", Series='" + series + '\'' +
                ", MachineType='" + machineType + '\'' +
                ", NumbersOfGPUs='" + numbersOfGPUs + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", LocalSSD='" + localSSD + '\'' +
                ", DatacenterLocation='" + datacenterLocation + '\'' +
                ", CommittedUsage='" + committedUsage + '\'' +
                '}';
    }
}
