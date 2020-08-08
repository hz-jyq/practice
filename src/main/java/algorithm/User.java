package algorithm;


import java.math.BigDecimal;

public class User  {

    @LogRemarks(name = "姓名")
    private String name;

    @LogRemarks(name = "年纪",type = "arg",clazz = UserEnum.class)
    private String age;

    @LogRemarks(name = "价格")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
