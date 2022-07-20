package pl.coderslab.charity.model;




import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "quantity must be grater than 0")
    @Positive
    private Integer quantity;
    @ManyToMany
    @NotEmpty(message = "pick at least one category")
    private List<Category> categories;
    @ManyToOne
    @NotNull(message = "pick at least one institution")
    private Institution institution;
    @NotBlank(message = "insert street")
    private String street;
    @NotBlank(message = "insert city")
    private String city;
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    @NotBlank(message = "insert zip code")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "insert pickup date")
    private LocalDate pickUpDate;
    @NotNull(message = "insert pickup time")
    private LocalTime pickUpTime;
    @Length(max = 255)
    private String pickUpComment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }
}
