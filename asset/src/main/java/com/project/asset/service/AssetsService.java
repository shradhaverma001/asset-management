package com.project.asset.service;
import java.util.ArrayList;
import java.util.List;
import com.project.asset.model.Assets;
import com.project.asset.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {
    @Autowired
    AssetsRepository assetsRepository;
    public List<Assets> getAllAssets()
    {
        List<Assets> assets = new ArrayList<Assets>();
        assetsRepository.findAll().forEach(assets1 -> assets.add(assets1));
        return assets;
    }

    public void saveOrUpdate(Assets assets)
    {
        assetsRepository.save(assets);
    }

    public Assets getAssetById(int id)
    {
        return assetsRepository.findById(id).get();
    }

    public void delete(int id)
    {
        assetsRepository.deleteById(id);
    }
}
