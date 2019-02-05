//package pl.javastart.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//
//   country
//@Entity
//@Table(name="authorities")
//public class Authorities implements Serializable {
//    private static final long serialVersionUID = 8539936152170847419L;
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_role_id")
//    private int id;
//    
//    @ManyToOne
//    @JoinColumn(name="email" , referencedColumnName = "email")
//    private User users;
//    
//    @Column(name = "authority")
//    private String authority;
//    
//   
//
//
//}
//
// 
