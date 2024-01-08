"# springboot-data-jpa"
Hibernate -- framework for persisting /saving java objects in a database.
             handles all of the low-level SQL
             provides the Object-to-Relational Mapping(ORM) -- developer defines mapping between java class and database table
JPA--Jakarta Persistence API -- standard API for ORM --- which is only a specification -- 
no need to get locked out in vendor's implementation
1.entityManager.persist(theStudent) --saves the student object row in database
2.entityManager.find(Student.class,Id)--- finds the student having id of Student class
3.entityManager.merge(theStudent)--update the entity
4.entityManager.createQuery("from Student",Student.class) -- creates a query to get list of students and this TypedQuery will return the list using query.getResultList();
JPA Hibernate CRUD Apps -- Create objects,read objects,Update objects,Delete Objects
JPA/Hibernate uses JDBC for all database communications.


In SpringBoot ,Hibernate is the default implementation of JPA -- EntityManager is main component for creating queries which is from Jakarta Persistence API
based on configs-- springboot will automatically create the beans such as DataSource ,EntityManager etc. based on the entries we provide in maven pom.xml by getting the DB connection from application.properties.
Entity Class -- java class that is mapped to a database table --should be annotated with @Entity 
Two things have to be done -- which is optional
   1.Map class to database table-- @Table(name="table name")
   2.Map fields to database columns -- @Column(name="column name")
   mandatory -- for primary key unlike column and table
   3.@ID -- makes the column as the primary key with Generation Strategy @GeneratedValue(strategy = GenerationType.IDENTITY) we have .AUTO,Sequence and Table.
   We can define our own CUSTOM generation Strategy-- by creating the implementation of org.hibernate.id.identifierGenerator
   Data Access Object --DAO design pattern for interfacing with the database .We need to inject EntityManager into our Student DAO
    Spring provides an @Transactional annotation where automatic beginning and ending of transaction for our JPA code happens.
    Spring provides @Repository annotation  which applies to DAO implemenations which automatically registers the DAO implementation.
    spring.jpa.hibernate.ddl-auto=create -- will drop and create tables automatically without running sql scripts
