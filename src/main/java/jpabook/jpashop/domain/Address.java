package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

//임베디드 타입의 값타입 맵핑(이처럼 간단한 경우에 사용)
//UML 을 그릴때 스테레오 타입으로 따로 빼서 표현 함.
@Embeddable
public class Address {

    //validation 룰도 공통으로 사용할 수 있음.
    @Column(length=10)
    private String city;
    @Column(length=20)
    private String street;
    @Column(length=5)
    private String zipcode;

    //값 타입의 장점은 의미있는 메소드를 만들수 있음.
    private String fullAddress(){
        return getCity()+getStreet()+getZipcode();
    }

    //유효한 주소라는것을 확인시키는 메소드
    public boolean isValid(){
        //city 랑 street 의 값이 있나 없나
        return true;
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return city.equals(address.city) && street.equals(address.street) && zipcode.equals(address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
