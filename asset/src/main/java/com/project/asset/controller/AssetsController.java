package com.project.asset.controller;

import com.project.asset.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetsController {
    @Autowired
    AssetsService assetsService;

    @GetMapping("/assets")
    private List<Category> getAllAssets()
    {
        return assetsService.getAllAssets();
    }

    @PostMapping("/assets")
    private int saveAssets(@RequestBody Assets assets)
    {
        assetsService.saveOrUpdate(assets);
        return assets.getAsset_id();
    }

    @PutMapping("/assets")
    private Assets update(@RequestBody Assets assets)
    {
        assetsService.saveOrUpdate(assets);
        return assets;
    }

    @DeleteMapping("/assets/{asset_id}")
    private void deleteAssets(@PathVariable("asset_id") int asset_id)
    {
        assetsService.delete(asset_id);
    }
}
