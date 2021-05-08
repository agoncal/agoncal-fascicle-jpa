# AGoncal Fascicle: Understanding Java Persistence API 2.2

Code of my [Java Persistence API Fascicle](https://agoncal.teachable.com/p/ebook-understanding-jpa).

![Travis](https://travis-ci.org/agoncal/agoncal-fascicle-jpa.svg?branch=2.2)

Applications are made up of business logic, interaction with other systems, user interfaces etc. and data.
Most of the data that our applications manipulate have to be stored in datastores, retrieved, processed and analysed.
If this datastore is a relational database and you use an object-oriented programming language such as Java, then you might want to use an Object-Relational Mapping tool.

That's when [Java Persistence API](https://jakarta.ee/specifications/persistence/2.2/) comes into play.

In this fascicle, you will learn JPA, the standard ORM that maps Java objects to relational databases.
You will discover its annotations for mapping entities, as well as the Java Persistence Query Language, entity life cycle and a few advanced topics such as integrating JPA with other frameworks (Bean Validation, JTA, CDI, Spring).

In this [fascicle](https://agoncal.teachable.com) will you will learn Java Persistence API, its annotations for mapping entities as well as the Java Persistence Query Language and entity life cycle and a few advanced topics such as integrating JPA with other frameworks (Bean Validation, JTA, CDI, Spring).

![Java Persistence API Fascicle](https://raw.githubusercontent.com/agoncal/agoncal-fascicle-jpa/master/cover.jpg)

Foreword by [Thorben Janssen](https://twitter.com/thjanssen123)

> Lots of Java applications use an _Object-Relational Mapping_ (ORM) framework, like Hibernate or EclipseLink, to read data from and to write it to a relational database.
As a reader of this fascicle, you might already know that both frameworks implement the Java Persistence API (JPA) specification and that the popular Spring Data JPA project integrates them into the Spring ecosystem.
But don't worry if you've never heard about the JPA specification.
If that's the case, I want to congratulate you on your decision to learn about it.
<br/><br/>
JPA is one of the most popular specifications in the Java world.
It defines an easy-to-use way to map database records to Java objects and to update the database records based on the changes you performed on these Java objects.
It also specifies a query language that you can use to define database queries based on your Java classes.
All of these powerful features are relatively easy to use if you know the basic concepts of JPA.
That's why Hibernate and other JPA implementations have become so popular and are used in most enterprise Java applications.
<br/><br/>
So, it should be evident that, as a professional Java developer or somebody who aspires to become one, you should have a solid understanding of JPA's general concepts and capabilities.
<br/><br/>
When Antonio asked me to write this foreword, I more than happily agreed to do it.
I still remember reading his blog articles at the relative beginning of my career as a Java developer in the mid-2000s.
That makes writing this foreword something special.
His ability to explain complex features in an easily understandable way still amazes me, and it made me a long-time reader and follower of his work.
<br/><br/>
I obviously wasn't the only one who liked his style of teaching and writing.
In 2007, he wrote and published his first book about Java EE 5.
And that was just the beginning.
During the following years, he wrote 3 additional books and recorded 7 video courses teaching Java developers various Java EE specifications, like JPA or Bean Validation.
He also worked as an expert group member on various Java EE specifications and co-created the Devoxx France and the Voxxed Days Microservices conferences.
Antonio is clearly a prolific member of the Java EE community, and that's just one of the reasons why he became a Java Champion.
<br/><br/>
Several years into my career, after I learned as much about JPA and Hibernate as I could, and after I became a freelance consultant and trainer specialised in solving Java persistence problems, I finally met Antonio at a speaker's dinner in Prague.
And let me tell you, he not only has an impressive knowledge about Java EE technologies and knows how to share it with other developers, but he is also a great guy who's fun to hang out with.
This was just one of the various reasons why I happily agreed to proofread this fascicle and to write this foreword.
<br/><br/>
But let's get back to this fascicle.
<br/><br/>
The JPA specification defines a vast feature set that makes working with a relational database simple and complex at the same time.
It only takes a few annotations to implement robust and efficient mappings.
You can then focus on your business code, and the JPA implementation takes care of all the nitty-gritty details.
<br/><br/>
But it only works that way if you're familiar with the general concepts of the specification.
You need to know how the internal life cycle model works, which annotations you need to use and all the defaults that your JPA implementation applies.
<br/><br/>
Antonio does a great job explaining all of it in this fascicle.
He first shows you the necessary configuration parameters and mapping annotations that you need in order to start implementing your first persistence layer.
After that, Antonio explains the different query capabilities defined by the JPA specification before he dives into its more advanced features, like life cycle events and caching.
<br/><br/>
And after you've learned about all the features specified by the JPA specification, you should pay special attention to Chapter 10.
There, Antonio shows you how to use your new knowledge to implement and test a small application so that you are well prepared to use JPA in your own projects.
<br/><br/>
**Thorben Janssen**  
_Independent Consultant and Trainer_  
https://thoughts-on-java.org

And thanks to my proof-reader team:

* [Thorben Janssen](https://twitter.com/thjanssen123)
* [Youness Teimouri](http://www.youness-teimouri.com)
* [Aurélie Vache](https://twitter.com/aurelievache)
* [Aymeric Beaumet](https://twitter.com/aymericbeaumet)

## References

* [Testing CDI Beans and the Persistence Layer Under Java SE](http://in.relation.to/2019/01/23/testing-cdi-beans-and-persistence-layer-under-java-se) by [Gunnar Morling](https://twitter.com/gunnarmorling)
