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

---------------------------------------------------------------------  
public interface StudentRepository extends JpaRepository<Student, Integer> { = Repository'i sadece Interface şekinde açıp, bu şekilde JpaRepository'i extend etmeliyiz.  
 
@Autowired
private StudentRepository studentRepository;  
//Bu şekilde ServiceImpl classımda Repository ile bağlantımı kurdum.

İşlem yaparken her daim Service'in Interfacesinden başla, public POST(ekliceksen ekleyeceğin sınıftan bir saveSınıfismi (Sınıfismi sınıfismi); şeklinde yap)  
GET (Sınıfismi getSınıfismiById(Integer id);)    
Liste şeklinde göstericeksen public List<SınıfIsmi> getAllSınıfismi();  
DELETE public void deleteSınıismiById(Integer id);  
 
Ardından hemen normal Service sınıfımıza gigip methodu @Override ediyoruz.  
Methodu yazdıktan sonra @Autowired ile bağladığımız Repository nesnemizi yazıp yanına . koyup gereken işlemi yazıyoruz.  
//Örneğin return studentRepository.save(student) //Studenti veri tabanına kaydetmesi için Repository'ye gönderir.  

DTO  
Verilerin korunması ve ihtiyaç olunan kadar verinin çağırılması için kullanılmalıdır.

DTO paketinde 2 class oluşturduk (DtoStudent, DtoStudenIU)
DtoStudentIU //IU = Insert Update demek.

DtoStudent = GET işlemlerinde bu kullanılır.  
DtoStudentIU = INSERT UPDATE işlemlerinde bu kullanılır.  

public *DtoStudent* saveStudent(*DtoStudentIU* student);  //Insert işlemi olduğundan. studenti IU lu aldım ama baş kısmına IU'suz versiyonunu yazdım.


BeanUtils.copyProperties(dtoStudentIU, student);  
BeanUtils.copyProperties metodu, dtoStudentIU içindeki verileri alır ve adları aynı olan alanları student nesnesine kopyalar. Bu, DTO'dan entity'ye veri aktarımı için pratik bir yoldur.

HQL : Sınıfın ismi ve değişken isimleri ile sorgu yazılır.  
SQL : Veritabanı tablo ve sütun isimleri ile sorgu yazılır  

nativeQuery = true  => SQL sorgusu  
nativeQuery = false => HQL sorgusu