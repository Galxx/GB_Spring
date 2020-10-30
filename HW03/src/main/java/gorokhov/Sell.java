package gorokhov;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sells")
@NamedQueries({@NamedQuery(name = "Sell.findById", query = "SELECT s FROM Sell s WHERE s.id = :id")})
public class Sell {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "Sell_SequenceStyleGenerator")
    private int id;

    @Column(name = "date")
    @Type(type="date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "id=" + id +
                ", date=" + date +
                ", product=" + product +
                ", client=" + client +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
