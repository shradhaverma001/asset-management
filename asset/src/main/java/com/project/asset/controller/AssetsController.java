package com.project.asset.controller;

import com.project.asset.model.Category;
import com.project.asset.model.Employee;
import com.project.asset.repository.AssetsRepository;
import com.project.asset.service.CategoryService;
import com.project.asset.service.EmployeeService;
import com.project.asset.shared.AssignStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.asset.service.AssetsService;
import com.project.asset.model.Assets;


@RestController
public class AssetsController {
    @Autowired
    AssetsService assetsService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AssetsRepository assetsRepository;

    @PostMapping("/category/{categoryId}/assets")
    private void saveAssets(@PathVariable(value = "categoryId") int categoryId, @RequestBody Assets assets)
    {
        Category categoryObj =  categoryService.getCategoryById(categoryId);
        assets.setCategory(categoryObj);
        assets.setAssignStatus(AssignStatus.Available);
        assetsRepository.save(assets);
    }

    @PutMapping("/category/{categoryId}/assets/{assetId}")
    private void updateAssets(@PathVariable(value = "categoryId") int categoryId, @PathVariable(value = "assetId") int assetId,
                              @RequestBody Assets assets)
    {
        Assets assetObj = assetsService.getAssetById(assetId);

        assetObj.setAsset_name(assets.getAsset_name());
        assetObj.setPurchase_date(assets.getPurchase_date());
        assetObj.setAssignStatus(assets.getAssignStatus());
        assetsRepository.save(assetObj);
    }

    @PostMapping("/assets/{assetId}/employee/{employeeId}")
    private void assignAssets(@PathVariable(value = "assetId") int assetId, @PathVariable(value = "employeeId") int employeeId)
    {
        Employee employeeObj = employeeService.getEmployeeById(employeeId);
        Assets assetObj = assetsService.getAssetById(assetId);
        assetObj.setEmployee(employeeObj);
        assetObj.setAssignStatus(AssignStatus.Assigned);
        assetsRepository.save(assetObj);

    }

    @PostMapping("/assets/{assetId}/employee/{employeeId}/remove")
    private void removeAssets(@PathVariable(value = "assetId") int assetId, @PathVariable(value = "employeeId") int employeeId)
    {
        Employee employeeObj = employeeService.getEmployeeById(employeeId);
        Assets assetObj = assetsService.getAssetById(assetId);
        assetObj.setEmployee(null);
        assetObj.setAssignStatus(AssignStatus.Recovered);
        assetsRepository.save(assetObj);
    }

    @DeleteMapping("/assets/{assetId}")
    private Boolean deleteAssets(@PathVariable("assetId") int assetId)
    {
        Assets assetObj = assetsService.getAssetById(assetId);
        if(assetObj.getEmployee() != null) {
            return false;
        } else {
            assetsService.delete(assetId);
            return true;
        }
    }
}
