# Clean Architechture

 <img src="image/CleanArchitecture.jpg" />

Though these architectures all vary somewhat in their details, they are very similar. They all have the same objective, which is the separation of concerns. They all achieve this separation by dividing the software into layers. Each has at least one layer for business rules, and another for interfaces.

Each of these architectures systems that are:

1. Independent of Frameworks. The architecture does not depend on the existence of some library of feature laden software. This allows you to use such frameworks as tools, rather than having to cram your system into their limited constraints.
2. The business rules can be tested without the UI, Database, Web Server, or any other external element.
3. Independent of UI. The UI can change easily, without changing the rest of the system. A Web UI could be replaced with a console UI, for example, without changing the business rules.
4. Independent of Database . Your business rules are not bound to the database.
5. Independent of any external agency. In fact your business rules simply don&#39;t know anything at all about the outside world.

The diagram at the top of this article is an attempt at integrating all these architectures into a single actionable idea.

**Refer :**   [**https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html**](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)

#Clean Architechture sample with MVP and MVVM

**We know that writing quality software is hard and complex:**  It is not only about satisfying requirements, also should be robust, maintainable, testable, and flexible enough to adapt to growth and change. This is where  **&quot;the clean architecture&quot;**  comes up and could be a good approach for using when developing any software application.

The idea is simple:  **clean architecture**  stands for a group of practices that produce systems that are:

- **Independent of Frameworks.**
- **Testable.**
- **Independent of UI.**
- **Independent of Database.**
- **Independent of any external agency.**

  <img src="image/clean architecture copy.png" />



It is not a must to use only 4 circles (as you can see in the picture), because they are only schematic but you should take into consideration the  **Dependency Rule: source code dependencies can only point inwards and nothing in an inner circle can know anything at all about something in an outer circle.**

Here is some vocabulary that is relevant for getting familiar and understanding this approach in a better way:

- **Entities:**  These are the business objects of the application.
- **Use Cases:**  These use cases orchestrate the flow of data to and from the entities. Are also called Interactors.
- **Interface Adapters:**  This set of adapters convert data from the format most convenient for the use cases and entities. Presenters and Controllers belong here.
- **Frameworks and Drivers:**  This is where all the details go: UI, tools, frameworks, etc.

## **Detail overview**

 <img src="image/ModulesDetails.png" />

## **Presentation or ViewModel Layer**

Is here, where the logic related with views and animations happens. It uses no more than a  **Model View Presente**** r ** and** Model View ViewModel **. I will not get into details on it, but here ** fragments and activities are only views,** there is no logic inside them other than UI logic, and this is where all the rendering stuff takes place.

**Presenters or ViewModel**  in this layer are composed with **interactors (use cases)** that perform the job in a  **new thread outside the main android UI thread** , and come back using a callback with the data that will be rendered in the view.

## **Domain Layer**

**Business rules here: all the logic happens in this layer.**  Regarding the android project, you will see all the interactors (use cases) implementations here as well.

**This layer is a pure java module without any android dependencies.**  All the external components use interfaces when connecting to the business objects.

 <img src="image/clean_architecture_data copy.jpg" />

## **Data Layer**

**All data needed for the application comes from this layer through a UserRepository implementation (the interface is in the domain layer) that uses a ** [**Repository Pattern**](http://martinfowler.com/eaaCatalog/repository.html) ** with a strategy that, through a factory, picks different data sources depending on certain conditions.**

For instance, when getting a user by id, the disk cache data source will be selected if the user already exists in cache, otherwise the cloud will be queried to retrieve the data and later save it to the disk cache.

**The idea behind all this is that the data origin is transparent for the client,**  which does not care if the data is coming from memory, disk or the cloud, the only truth is that the data will arrive and will be got.

 

**NOTE:**  In terms of code I have implemented a very simple and primitive disk cache using the file system and android preferences, it was for learning purpose. Remember again that you  **SHOULD NOT REINVENT THE WHEEL**  if there are existing libraries that perform these jobs in a better way.

## **Error Handling**

This is always a topic for discussion and could be great if you share your solutions here.

**My strategy was to use callbacks,**  thus, if something happens in the data repository for example, the callback has 2 methods **onResponse()** and **onError().** The last one encapsulates exceptions in a wrapper class called  **&quot;ErrorBundle&quot;:**  This approach brings some difficulties because there is a chains of callbacks one after the other until the error goes to the presentation layer to be rendered. Code readability could be a bit compromised.

On the other side, I could have implemented an event bus system that throws events if something wrong happens but this kind of solution is like using a  [GOTO](http://www.drdobbs.com/jvm/programming-with-reason-why-is-goto-bad/228200966), and,  **in my opinion, sometimes you can get lost when you&#39;re subscribed to several events if you do not control that closely.**

## **Testing**

Regarding testing, I opted for several solutions depending on the layer:

- **Presentation Layer or ViewModel Layer:**  used android instrumentation and espresso for integration and functional testing.
- **Domain Layer:**  JUnit plus mockito for unit tests was used here.
- **Data Layer:**  Robolectric (since this layer has android dependencies) plus junit plus mockito for integration and unit tests .

**Refer** : https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way