package com.management.portfolio.service;

import com.management.portfolio.model.Asset;
import com.management.portfolio.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets(){
        return assetRepository.findAll();
    }

    public Asset createAsset(Asset asset){
        return assetRepository.save(asset);
    }
    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset asset = assetRepository.findById(id).orElseThrow();
        asset.setName(assetDetails.getName());
        asset.setType(assetDetails.getType());
        asset.setValue(assetDetails.getValue());
        return assetRepository.save(asset);
    }
    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }

}
