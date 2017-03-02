package ua.shield.hw01032017.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sa on 01.03.17.
 */
@Entity
@Table(name="stock")
public class Stock implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="stock_code")
    private String code;

    @Column(name="stock_name")
    private String name;

    public Stock() {
    }

    public Stock(String code, String name) {
        this.code=code;
        this.name=name;
    }
    public Stock(int id,String code, String name) {
        this.id=id;
        this.code=code;
        this.name=name;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;
        if (id != stock.id) return false;
        if (!code.equals(stock.code)) return false;
        return name.equals(stock.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + code.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Stock:" + "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
