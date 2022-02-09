# Mail Management System 
## Abouth the Project
It is a backend application developed with Restful architecture for Mail Management System application.In the application, it is possible to perform database create, update and delete operations on mail addresses.You can send an e-mail to a record or you can send an e-mail to the e-mail addresses in the entire database.
## Build With
- Java 11
- Spring Boot
- Spring Data
- H2 Database
- Spring Mail
- Maven
## Getting Started
This is an example of how you may give instructions on setting up your project locally. To get a local copy up and running follow these simple example steps.
### Installation
1.Clone the repo 
``` bash
git clone https://github.com/emirleroglu/SpringEmailDemo.git
```
2.Type the email and password in the `application.properties`
``` proporties
spring.mail.username= your mail address
spring.mail.password= your google app password

```
3.If you want to add database mail addresses beforehand, enter `LoadDatabase.java `and add it.

<img width="701" alt="Screen Shot 2022-02-09 at 13 22 48" src="https://user-images.githubusercontent.com/52790536/153178790-d7fc8ef5-815f-4e84-ad4a-36e2a2df273d.png">

### Build and Run
1.Build your app
```bash
mvn package
```
2.Run your app with dependencies
```bash
mvn spring-boot:run
```
## Usage
1.Post mail addres

<img width="713" alt="Screen Shot 2022-02-09 at 13 30 12" src="https://user-images.githubusercontent.com/52790536/153180101-31db8acd-0609-45da-9954-06268fd7a7ba.png">

2.Get all mail adresses 

<img width="841" alt="Screen Shot 2022-02-09 at 13 33 08" src="https://user-images.githubusercontent.com/52790536/153180478-8451a21c-9f47-424a-ae42-13a321b2c555.png">

3.Updata mail adress

<img width="822" alt="Screen Shot 2022-02-09 at 13 34 14" src="https://user-images.githubusercontent.com/52790536/153180671-579f68ab-b2de-4f7d-8587-6f0a23cc61de.png">

4.Send mail using id 

<img width="743" alt="Screen Shot 2022-02-09 at 13 36 50" src="https://user-images.githubusercontent.com/52790536/153181105-222552b1-56ec-4ea9-a78f-d7e4e9c76b3c.png">

5.Send mail all mail adresses

<img width="751" alt="Screen Shot 2022-02-09 at 13 37 48" src="https://user-images.githubusercontent.com/52790536/153181223-db56b7ee-9028-4c12-ba6f-db6febf11d34.png">

## Contact
Halil Emirleroğlu - emirlerogluhalil@gmail.com

Project Source - https://github.com/emirleroglu/SpringEmailDemo




