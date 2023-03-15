package com.example.CIMAInspection.service;

import com.example.CIMAInspection.entity.PartData;

public interface PartDataService {

    PartData savePartData(PartData partData);

    PartData getPartDataByClientId(int clientId);

    boolean isPartDataExists(int clientId);

}
