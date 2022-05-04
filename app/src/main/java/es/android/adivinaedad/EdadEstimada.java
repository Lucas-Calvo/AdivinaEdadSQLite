package es.android.adivinaedad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EdadEstimada {

    private String name;
    private Integer age;
    private Integer count;

    public EdadEstimada( Integer age,String name, Integer count) {
        this.name = name;
        this.age = age;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
