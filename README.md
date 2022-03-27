# asset-management

# Information
* The project is about Asset Management System in a company.
* Tools used are Spring Boot and H2 DataBase.
* Java version 11.0.14.
* The routes present in the application are -
    * "/category" for get, put and post operations on Category.
    * "/employee" for get and post operations of Employee.
    * "/category/{categoryId}/assets" for inserting (post) the assets data.
    * "/category/{categoryId}/assets/{assetId}" for updating (put) the assets.
    * "/assets/{assetId}/employee/{employeeId}" for assigning the assets to employees.
    * "/assets/{assetId}/employee/{employeeId}/remove" for recovering the assigned assets from employees.
    * "/assets/{assetId}" for deleting the non assigned assets.
