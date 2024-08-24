# User Guide :

I have completed the coding and unit testing for the task provided in the lines of RESTful API developement using Java Spring Boot.

## Design:

API Endpoint : /api/supplier/query [POST] as given in the requirement

I have two .csv files storing the Supplier data and Manufacturer data (check path : src/main/resources/static).

Fields in Supplier.csv:
  1. supplier_id : unique identifier for each supplier
  2. company_name
  3. website
  4. location : city, assuming one supplier_id maps to just one location
  5. nature_of_business : Possible values: small_scale, medium_scale, large_scale
  6. manufacturing_processes : Possible values for POC: moulding, 3d_printing, casting, coating

Fields in Manufacturer.csv:
  1. manufacturer_id : unique identifier for each manufacturer
  2. manufacturer_name
  3. contact
  4. location : city, assuming one supplier_id maps to just one location
  5. nature_of_business : Possible values: small_scale, medium_scale, large_scale
  6. manufacturing_processes : Possible values for POC: moulding, 3d_printing, casting, coating

API is designed to respond to a request in the format as specified below:
POST:
  Input Parameters in query : supplier_id, location, natureOfBusiness, manufacturingProcess, page, size (Mandatory)
  Response : JSON file with supplier record, matching manufacturer records as a list
  Response statistics : total pages, total manufacturers matching the given query, current page number, page size

## How does the API work:
  1. The API takes the input parameters given in the POST request sent by the user.
  2. It checks the supplier.csv file, for the existence of a supplier with the input parameters supplier_id, location, natureOfBusiness and manufacturingProcess.
  3. If such a supplier exists in the supplier file, then a supplier object is created.
  4. After that, if supplier is present, then the manufacturer.csv file will be traversed to find the matching manufacturers for the given input location, natureOfBusiness and manufacturing process.
  5. All such matching manufacturer records will be fetched and made into a list of Manufacturers.
  6. Based of the page and size parameter given as input, the list of manufacturers is paginated and the corresponding subList is produced.
  7. All these data (supplier object, list of manufacturers after pagination) along with the statistics information such as the number of pages, number of manufacturers for the matching query, page size and current page number are all made into a object of PaginationResponse.
  8. This PaginationResponse in binded into a JSON and sent as the response to the received POST API request

## Request Format Screen (With POSTMAN request):
![image](https://github.com/user-attachments/assets/4e379440-df4b-4004-9102-555babc73b31)

Response:
![image](https://github.com/user-attachments/assets/1259b2ed-7911-4308-91ab-1ace8e82b2d3)


## Follow the below steps to setup and run 
Prerequisite : JDK 22, SpringBoot framework, some IDE with maven dependency management support, POSTMAN or any other API request sender.
  1. Download the respository or clone the respository from GitHub
  2. Open the downloaded repository in the preferred IDE.
  3. Setup and manage all dependencies and run the project.
  4. Now, go to postman and send the POST request in the format (replace the <> brackets with the value for the field)
      http://localhost:8080/api/supplier/query?supplierId=<>&location=<>&natureOfBusiness=<>&manufacturingProcess=<>&page=<>&size=<>
  5. The response JSON will be received and shown in the POSTMAN screen.

## Test cases:

Test case 1:
