package shalbaf.phonebook.entity;

public class ContactEntity {
    private String mobile;
    private String name;
    private String family;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return String.format("Mobile: %s, Name: %s, Family: %s%n", mobile, name, family);
    }
}
