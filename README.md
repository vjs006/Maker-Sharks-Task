# User Guide :

I have completed the coding and unit testing for the task provided in the lines of RESTful API developement using Java Spring Boot.

## Design:

API Endpoint : /api/supplier/query [POST] as given in the requirement

I have two .csv files storing the Supplier data and Manufacturer data (check path : src/main/resources/static).

### Fields in Supplier.csv:
  1. supplier_id : unique identifier for each supplier
  2. company_name
  3. website
  4. location : city, assuming one supplier_id maps to just one location
  5. nature_of_business : Possible values: small_scale, medium_scale, large_scale
  6. manufacturing_processes : Possible values for POC: moulding, 3d_printing, casting, coating

### Fields in Manufacturer.csv:
  1. manufacturer_id : unique identifier for each manufacturer
  2. manufacturer_name
  3. contact
  4. location : city, assuming one supplier_id maps to just one location
  5. nature_of_business : Possible values: small_scale, medium_scale, large_scale
  6. manufacturing_processes : Possible values for POC: moulding, 3d_printing, casting, coating

API is designed to respond to a request in the format as specified below:
### POST Request:
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

## Coding and Implementation:
  Status : Completed Successfully.
  
## Unit Testing:
  Status : Completed Successfully.

The following are some of the key test cases covered during my exhaustive unit testing.

### Test case 1: 
Checking the correctness of the response data.

Expected Result: 
Data to get retreived correctly from the manufacturer.csv file for the given input parameter and sent as a response

Actual Result: Pass (Worked as expected)

Screen Shots of the input parameter:

![image](https://github.com/user-attachments/assets/a99cc7e9-e613-4cc3-9943-dafb36bb6fe6)

Response Screen shot:

![image](https://github.com/user-attachments/assets/227a6ec3-b43c-469e-bacb-7466bbbd225d)
![image](https://github.com/user-attachments/assets/106f19ad-cddc-4ebd-a5dd-c74281215fd7)
![image](https://github.com/user-attachments/assets/389465bc-ae09-4c8d-92c1-26b80d7fc6ce)

Supplier.csv data (Supplier used : S001, New Delhi, medium_scale, moulding)
![image](https://github.com/user-attachments/assets/71ccf498-7b0e-4e18-85a7-5505c955c039)
Manufacturer.csv data (received as resonse - which is the expected response)
![image](https://github.com/user-attachments/assets/2f71a1b8-be74-4347-ad2e-30417f794e83)

### Test Case Status: Passed

### Test case 2: 
Checking if the pagination is working fine.

Expected Result: 
Data to get retreived correctly from the manufacturer.csv file for the given input parameter and sent as a response. The response must contain data of the page specified in the input parameter and each page shouldnt exceed the specified size parameter. Multiple pages consists of the paginated data.

Actual Result: Pass (Worked as expected)

Used Input Parameters : S001, New Delhi, medium_scale, moulding
Returns 5 manufacturers.
Used input size - 2 => 3 pages with maximum 2 manufacturer per page. Since there are 5 manufacturers, split will be 2+2+1.

Screen Shots of the input parameter:

### Page 0, size 2 check:

Request SS:

![image](https://github.com/user-attachments/assets/7f8281b2-bb39-4165-a7ec-347e95d14acf)

Response Screen shot:

![image](https://github.com/user-attachments/assets/85d337c0-3385-41c8-9c59-7c32d7a0accc)
![image](https://github.com/user-attachments/assets/b53a0b8a-6b22-4808-849c-974adbeb0ae5)


### Page 1, size 2 check:

Request SS:
![image](https://github.com/user-attachments/assets/7f3362bf-52a7-4be4-bb86-b84523b6e91d)

Response Screen shot:
![image](https://github.com/user-attachments/assets/36e967de-2a53-4b0e-82dd-3fb9aed22856)
![image](https://github.com/user-attachments/assets/d5850a73-9942-442d-ae02-2c5cf57ca01b)

### Page 2, size 2 check:

Request SS:
![image](https://github.com/user-attachments/assets/c6153956-00d6-49da-9228-897317af736d)

Response Screen shot:
![image](https://github.com/user-attachments/assets/41c27ef3-9101-403a-a43b-34b671052c12)


Supplier.csv data (Supplier used : S001, New Delhi, medium_scale, moulding)
![image](https://github.com/user-attachments/assets/71ccf498-7b0e-4e18-85a7-5505c955c039)
Manufacturer.csv data (received as resonse - which is the expected response)
![image](https://github.com/user-attachments/assets/2f71a1b8-be74-4347-ad2e-30417f794e83)

### Test Case Status: Passed 

  
