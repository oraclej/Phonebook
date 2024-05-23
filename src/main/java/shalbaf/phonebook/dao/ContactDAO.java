package shalbaf.phonebook.dao;

import shalbaf.phonebook.entity.ContactEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    public boolean addContact(ContactEntity contact) {
        Connection connection = SingleConnection.getSingleConnection().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("insert into contact values(?,?,?)");
            ps.setString(1, contact.getMobile());
            ps.setString(2, contact.getName());
            ps.setString(3, contact.getFamily());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<ContactEntity> searchAllContacts(String name, String family) {
        Connection connection = SingleConnection.getSingleConnection().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from contact where name like ? and family like ?");
            ps.setString(1, "%"+name+"%");
            ps.setString(2, "%" + family + "%");
            ResultSet rs = ps.executeQuery();
            List<ContactEntity> list = new ArrayList<>();
            while (rs.next()){
                ContactEntity contact = new ContactEntity();
                contact.setMobile(rs.getString("MOBILE"));
                contact.setName(rs.getString("name"));
                contact.setFamily(rs.getString("family"));
                list.add(contact);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ContactEntity searchContact(String mobile) {
        Connection connection = SingleConnection.getSingleConnection().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from contact where mobile = ? ");
            ps.setString(1, mobile);
            ResultSet rs = ps.executeQuery();
            ContactEntity contact = new ContactEntity();
            if (rs.next()){
                contact.setMobile(rs.getString("MOBILE"));
                contact.setName(rs.getString("name"));
                contact.setFamily(rs.getString("family"));
            }
            return contact;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
