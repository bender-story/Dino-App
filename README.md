# Dino APP – Super App Guide 

 

## Prerequisites 

* Android Studio 

* Have Basic understanding of kotlin

* Create an emulator with 28 or higher SDK versions 

* Build the application on the emulator. 

 

## Contents 

1. [Dino APP](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#dino-app)

2. [Create android project](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#create-android-project) 

3. [Create module](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#create-module) 

4. [Gradle Kotlin DSL and BuildSrc](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#gradle-kotlin-dsl-and-buildsrc)  

5. [Core Module](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#core-module) 

6. [Resources Module](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#resources-module)  

7. [Features Module](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#features-module)  

8. [DI layer](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#di-layer)  

9. [Android Navigation Layer](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#android-navigation-layer)  

10. [Navigation Module](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#navigation-module) 

11. [MVVM](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#mvvm) 

12. [Network Layer](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#network-layer)  

13. [Unit Tests](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#unit-tests)  

14. [UI Tests](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#ui-tests)  

15. [Individual Module UI Testing](https://github.com/bender-story/Dino-Super-App/blob/main/README.md#individual-module-ui-testing)  

 

 

 

## Dino APP   

 Sample social media APP, which is developed in Native android. It is developed as Modular app architecture using Android Navigations. 

<img width="200" alt="Login" src="https://user-images.githubusercontent.com/10196013/116344573-0cf58d80-a819-11eb-848b-5340b24ffab1.png">             <img width="200" alt="Dashboard" src="https://user-images.githubusercontent.com/10196013/116344579-1252d800-a819-11eb-956f-ad5fd23e48c1.png">


 

## Create android project 

* Install the latest version of Android Studio. 

* In the Welcome to Android Studio window, click Create New Project. If you have a project already opened, select File > New > New Project. 
<img width="300" alt="Screenshot 2021-04-26 at 1 15 22 PM" src="https://user-images.githubusercontent.com/10196013/116346115-2d731700-a81c-11eb-835a-7053ea798c8f.png">

 

 

* In the Select a Project Template window, select Option and click Next.         
<img width="300" alt="Screenshot 2021-04-26 at 1 16 37 PM" src="https://user-images.githubusercontent.com/10196013/116346124-32d06180-a81c-11eb-9c8f-7478540ac179.png">

              

* Fill all the details and click Finish 
<img width="300" alt="Screenshot 2021-04-26 at 1 19 49 PM" src="https://user-images.githubusercontent.com/10196013/116344659-32829700-a819-11eb-9ff0-ed875e523a08.png">

 

* Project is Created, check Activity and Android Manifest. Now run the app. 

 

 

## Create module 

* Keep the project open, right click on root folder -> New -> Module 
<img width="300" alt="Screenshot 2021-04-26 at 1 24 03 PM" src="https://user-images.githubusercontent.com/10196013/116346276-83e05580-a81c-11eb-9201-eef9d2657041.png">


 

* Create New Module tab appears, select Android Library and click Next 
<img width="300" alt="Screenshot 2021-04-26 at 1 25 18 PM" src="https://user-images.githubusercontent.com/10196013/116346287-893da000-a81c-11eb-96a7-bb557fc732da.png">

 

* Fill the details and click finish. 
<img width="300" alt="Screenshot 2021-04-26 at 1 27 10 PM" src="https://user-images.githubusercontent.com/10196013/116346317-95296200-a81c-11eb-9c40-c5b4a9621e37.png">

 

* Module is created. 

* Every module has its own UI, build.gradle and manifest. 

* In setting.gradle add line -> include ':sample’ 

* To Implement this module in app add this line in build.gradle of the app module ->  implementation(project(":sample")) 

* Click sync now and use the sample module code in the app module. 

 

 

## Gradle Kotlin DSL and BuildSrc 

 

* Create a new directory with name buildsrc 

* Add build.gradle.kts file in the directory 


* Create a buildSrc/src/main/Java directory 

* Create a Dependencies.kt in that directory 

* Add object class in Dependencies file and add all the package names as const.  
<img width="300" alt="Screenshot 2021-04-26 at 1 34 12 PM" src="https://user-images.githubusercontent.com/10196013/116346472-edf8fa80-a81c-11eb-9467-32799247f1b9.png">

 

* In build.gradle.kts add this code 
<img width="300" alt="Screenshot 2021-04-26 at 1 31 21 PM" src="https://user-images.githubusercontent.com/10196013/116346421-d0c42c00-a81c-11eb-99da-5ae4341dd771.png">
 

* Change your build.gradle of app module to build.gradle.kts. Replace the actual package names with these conts. 

 <img width="300" alt="Screenshot 2021-04-26 at 1 36 36 PM" src="https://user-images.githubusercontent.com/10196013/116346520-05d07e80-a81d-11eb-9d43-7499d7c49912.png">


 

 

## Core Module 

* Core module has all the commonly used classes like network classes, utils, Ui components. This module will help the feature modules to reuse the classes that are commonly used. 
<img width="300" alt="Screenshot 2021-04-26 at 1 39 31 PM" src="https://user-images.githubusercontent.com/10196013/116346578-239de380-a81d-11eb-9bfc-6799616b8b01.png">

 

 

 

 

## Resources Module 

* Resource's module has all the commonly used styles, drawables, strings, colors and dimens. 
<img width="300" alt="Screenshot 2021-04-26 at 1 42 56 PM" src="https://user-images.githubusercontent.com/10196013/116346611-2f89a580-a81d-11eb-9788-afb10c671b9e.png">

 

 

## Features Module 

* Features module has all the features as sub modules. Like feature has login module, dashboard module, etc... 

 <img width="257" alt="Screenshot 2021-04-26 at 1 57 19 PM" src="https://user-images.githubusercontent.com/10196013/116346654-416b4880-a81d-11eb-8861-55210812bd5b.png">


 

 

* But as these modules are in a directory, the settings.gradle should have its name as -> include ':features:login' 
<img width="272" alt="Screenshot 2021-04-26 at 1 55 35 PM" src="https://user-images.githubusercontent.com/10196013/116346700-5516af00-a81d-11eb-88ab-150112601cc9.png">
 

 

 

* And it should be implemented in other modules as -> implementation(project(": features:login")) 

<img width="300" alt="Screenshot 2021-04-26 at 1 56 32 PM" src="https://user-images.githubusercontent.com/10196013/116346727-619b0780-a81d-11eb-9da8-cfbeb4d8f080.png">
 

 

 

## DI layer 

* We are using koin for the dependency injection. 

* Create a custom Application class and bind it to the app module in the mainfest. 

 <img width="300" alt="Screenshot 2021-04-26 at 2 14 38 PM" src="https://user-images.githubusercontent.com/10196013/116346853-9eff9500-a81d-11eb-8ddf-3dbd904b5e2e.png">


        

* Add  koin module code block in each of the modules. Like below 
<img width="300" alt="Screenshot 2021-04-26 at 2 16 10 PM" src="https://user-images.githubusercontent.com/10196013/116347107-251bdb80-a81e-11eb-953e-0bec2cce2e42.png">

    

* Add the all these code blocks from each of modules and add it in the application class 

 <img width="300" alt="Screenshot 2021-04-26 at 2 18 26 PM" src="https://user-images.githubusercontent.com/10196013/116347139-3b299c00-a81e-11eb-9374-0fdfcd8901c9.png">


* Later use all the inject these classes or viewmodels where ever it is required. 
<img width="300" alt="Screenshot 2021-04-26 at 2 20 34 PM" src="https://user-images.githubusercontent.com/10196013/116347162-48df2180-a81e-11eb-85eb-9d4cb0337979.png">

 

 

## Android Navigation Layer 

* Add FragmentContainerView in activity_main.xml of app module. This will be parent fragment for the whole app. 

* Add navigation directory under res folder of login module. 

* Create nav_graph.xml file and add the nav graph to all the fragments in the module 
<img width="300" alt="Screenshot 2021-04-26 at 2 28 03 PM" src="https://user-images.githubusercontent.com/10196013/116347426-c7d45a00-a81e-11eb-9518-fe9127360fda.png">

 		 

* Now add navigation directory under res folder of app module.  

* Create nav_graph.xml file and add the nav graph to all the other modules in the project. This will act as a parent nav graph for the project. 
<img width="300" alt="Screenshot 2021-04-26 at 2 29 30 PM" src="https://user-images.githubusercontent.com/10196013/116348337-85138180-a820-11eb-9d87-e7bda523eb80.png">



 		 

 

* As app:startDestination is nav_graph_login. The app will launch with login page as its first page. 

 

## Navigation Module 

* This will act as a navigation interface between the modules. 

* It has AppNavigationViewModel, AppNavigationInterface, NavigationType, AppNavigationHandler and NavigationConstants 

* AppNavigationInterface has the code to move the view to other modules. 
<img width="300" alt="Screenshot 2021-04-26 at 2 38 38 PM" src="https://user-images.githubusercontent.com/10196013/116347983-d111f680-a81f-11eb-8080-27610dd5cad1.png">

 

* AppNavigationInterface needs a implementation in app module and we have created a class called AppNavigationImpl. Each method used NavController to move to a different module. 

<img width="300" alt="Screenshot 2021-04-26 at 2 37 56 PM" src="https://user-images.githubusercontent.com/10196013/116348011-dd964f00-a81f-11eb-9e28-e3b118cbb7d1.png">



* AppNavigationHandler is being added as a constructor parm to AppNavigationImpl and it emits whenever a specific method. And its objects are injected in appmodule. 
<img width="300" alt="Screenshot 2021-04-26 at 2 16 10 PM" src="https://user-images.githubusercontent.com/10196013/116347107-251bdb80-a81e-11eb-953e-0bec2cce2e42.png">



 

* AppNavigationHandler live data is having its observer in Main Activity. 

<img width="300" alt="Screenshot 2021-04-26 at 2 44 38 PM" src="https://user-images.githubusercontent.com/10196013/116348081-fbfc4a80-a81f-11eb-8ac9-88321e6b31ce.png">



 

* AppNavigationViewModel is share view model between all the fragments. This has constructer param as AppNavigationInterface and its object is created in the DI app module by adding AppNavigationImpl as parameter. 
<img width="300" alt="Screenshot 2021-04-26 at 2 39 08 PM" src="https://user-images.githubusercontent.com/10196013/116348103-0ae2fd00-a820-11eb-90cc-773d389df23f.png">

 

* Now to AppNavigationViewModel is shared in the fragments and the fragments use the NavigationType to move to different module. 

 <img width="300" alt="Screenshot 2021-04-26 at 2 53 52 PM" src="https://user-images.githubusercontent.com/10196013/116348169-277f3500-a820-11eb-9f4f-50eb83da2eb1.png">

<img width="300" alt="Screenshot 2021-04-26 at 2 53 41 PM" src="https://user-images.githubusercontent.com/10196013/116348174-28b06200-a820-11eb-991c-93306463703a.png">

 

 

## MVVM 

 

* Each fragment has its own viewmodel Ex LoginViewModel 

* LoginViewModel has a method called login, which calls the login service through service layer. 

* And the login gets back the success or failure response as callbacks. 

* LoginViewModel has success and failure live data which has observes in fragment.  
<img width="300" alt="Screenshot 2021-04-26 at 2 57 55 PM" src="https://user-images.githubusercontent.com/10196013/116348410-a4121380-a820-11eb-901b-fe37fa672741.png">

 

* So fragment reacts as per the live data’s values. 

 

## Network Layer 

* App has a common network layer in core module. 

* App is using retrofit for the network calls 

* NetworkAPIController is the actual intializer that is in the core module 

* ServiceAPIHelper is the class that helps all the modules to go either mock environment or actual server. 
<img width="300" alt="Screenshot 2021-04-28 at 12 54 47 PM" src="https://user-images.githubusercontent.com/10196013/116348587-f4897100-a820-11eb-91b2-dbb25b36d10c.png">


* And each module will have its own network layer which will have ServiceInterface and ServiceMockImpl. 

* These classes are passed as param to ServiceAPIHelper which would create a retrofit layer for that module. 

* ServiceAPIHelper object is created in a module repo which would be called from the viewmodel of that module 

* ServiceAPIHelper gets it enivronment configuration from NetworkConfigImpl 
<img width="300" alt="Screenshot 2021-04-26 at 3 09 46 PM" src="https://user-images.githubusercontent.com/10196013/116348455-b8eea700-a820-11eb-87d0-43a91ad6b3b1.png">


## Unit Tests 

* We are using Junit for Unit testing 

* Each module have its own unit testing environment. 

* Each module has its own base test class which will initiate the koin module required for the test 
<img width="300" alt="Screenshot 2021-04-26 at 3 12 49 PM" src="https://user-images.githubusercontent.com/10196013/116348624-079c4100-a821-11eb-8255-334b7e2e74fa.png">

                          

 

## UI Tests 

* We are using espresso for UI tests. And it is added in the app module. 

This is for the whole app and all the features are tested here. 

 

 

## Individual Module UI Testing 

* We are using espresso, fragment testing and navigation testing for individul module UI tests. 

* This uses the nav_graph of that module to run the test cases. 
<img width="300" alt="Screenshot 2021-04-26 at 3 18 04 PM" src="https://user-images.githubusercontent.com/10196013/116348656-1551c680-a821-11eb-9a7b-c5e49a42673d.png">


 
