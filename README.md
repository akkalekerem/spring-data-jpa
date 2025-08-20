Spring Data JPA = Veri tabanına bağlanmamızı sağlayan ara katman. Veri tabanına projemiz üzerinden bağlanıp insert, update, delete ,get gibi işlemler yapmamıza olanak sağlar.

Yeni bir class oluştururken @Entity kullanarak classımızı tabloya dönüştürüyoruz ve içinde oluşturduğumuz değişkenler de o tablonun sütunları olmuş oluyor.

JpaRepository (interface) = Veri tabanına erişim için kullanılan arayüz. Bu arayüzü kullanarak veri tabanına erişebiliriz.  
HIBERNATE = Java Persistence API (JPA) uygulaması. JPA, Java'da nesne-ilişkisel haritalama (ORM) için bir standarttır.  
 Java classımızı Veritabanına ORM aracılığıyla bağlıyoruz.

Hibernate ORM Mapping = Java Classlarımızı Database tablolarıyla Maplayan yapıdır.  
@Entity kullanırsak aynı isimde database de tablo oluşturur.  
Her bir değişkenin üzerine @Column kullanırsak Database de yeni bir sütun oluşturur.

@Table(name = "tabloIsmi")  
@Column(name = "first_name")  
@Id kullanırsan Primary Key olarak işaretler.    


spring.datasource.url=jdbc:postgresql://localhost:5432/<YOUR_DATABASE_NAME> (postgres)   
spring.datasource.username=<YOUR_USERNAME> (postgres)    
spring.datasource.password=<Your_Password>  

@OneToMany : 1 öğrencinin 1 den fazla dersi olabilir.   (@ManyToOne, @OneToOne)

@GeneratedValue(strategy = GenerationType.IDENTITY) = Id yi birer birer arttır.  
 @Column(name = "last_name" , nullable = false) nullable = false kısmı = Boş geçilemez demek.

@EntityScan(basePackages = {"com.keremakkale"}) = Entity anatasyonu var mı diye tara (Bu özelliği kesinlikle uygulamayı çalıştıracak class'a atamak gerekiyor)
